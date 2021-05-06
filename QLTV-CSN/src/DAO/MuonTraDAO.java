package DAO;

import Models.MuonTra;
import Models.TaiLieu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MuonTraDAO {
    private Connection connection = MConnection.getInstance().getConnection();
    private String sql;
    public boolean isIDValid(String maloaitailieu, String tableName){
        sql = "SELECT mamuon FROM " + tableName + " WHERE mamuon = ?";
        try {
            var prepare = connection.prepareStatement(sql);
            prepare.setString(1,maloaitailieu);
            var rs = prepare.executeQuery();
            while (rs.next()){
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sai");
        }
        return true;
    }
    public void ThemMuonTra(MuonTra muonTra) {
        sql = "INSERT INTO MUONTRA VALUES(?, ?, ?, ?)";
        try {
            var prepare = connection.prepareStatement(sql);
            prepare.setString(1,muonTra.getMaMuon());
            prepare.setInt(2,muonTra.getSongaymuon());
            prepare.setString(3,muonTra.getMasach());
            prepare.setString(4,muonTra.getSothe());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void  XoaMuon(String mamuon){
        sql = "delete from PHIEUMUON where mamuon = ?"+" delete from MUONTRA where mamuon = ?";
        try {
            var prepare = connection.prepareStatement(sql);

            prepare.setString(1,mamuon);
            prepare.setString(2,mamuon);
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<MuonTra> HienThiTatCa() {
        List<MuonTra> listMT = new ArrayList<MuonTra>();
        sql = "SELECT * FROM MuonTra";
        try {
            var prepare = connection.prepareStatement(sql);
            var rs = prepare.executeQuery();
            while (rs.next()){
                MuonTra muonTra = new MuonTra();
                muonTra.setMaMuon(rs.getString("mamuon"));
                muonTra.setSongaymuon(rs.getInt("Songaymuon"));
                muonTra.setMasach(rs.getString("masach"));
                muonTra.setSothe(rs.getString("sothe"));
                listMT.add(muonTra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMT;
    }
}
