package DAO;

import Models.MuonTra;
import Models.PhieuMuon;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhieuMuonDAO {
    private Connection connection = MConnection.getInstance().getConnection();
    private String sql;
    public PhieuMuon Inra(String mamuon){
        PhieuMuon p = new PhieuMuon();
        sql = "SELECT MUONTRA.mamuon,MUONTRA.Songaymuon,TAILIEU.tensach,DOCGIA.hoten,\n" +
                "(MUONTRA.Songaymuon * TAILIEU.dongia) AS 'Phi muon', (MUONTRA.Songaymuon * TAILIEU.dongia)*2 as 'Tien Coc'\n" +
                "from TAILIEU inner join MUONTRA on TAILIEU.masach = MUONTRA.masach \n" +
                "inner join DOCGIA on MUONTRA.sothe = DOCGIA.sothe\n" +
                "where mamuon =?";
        try {
            var prepare = connection.prepareStatement(sql);
            prepare.setString(1,mamuon);
            var rs = prepare.executeQuery();
            while (rs.next()){

                p.setMaMuon(rs.getString("mamuon"));
                p.setTenDocGia(rs.getString("hoten"));
                p.setTenSach(rs.getString("tensach"));
                p.setTienPhiMuon(rs.getLong("Phi muon"));
                p.setTienCoc(rs.getLong("Tien Coc"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sai");
        }

        return  p;
    }
    public void XoaTheoMa(String mamuon){
        sql = "Delete from PHIEUMUON WHERE MAMUON = ?";
        try {
            var prepare = connection.prepareStatement(sql);
            prepare.setString(1,mamuon);
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sai");
        }

    }
}
