package DAO;

import Models.DocGia;
import Models.LoaiTaiLieu;
import Models.TaiLieu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaiLieuDAO {
    private Connection connection = MConnection.getInstance().getConnection();
    private String sql;
    public boolean isIDValid(String maloaitailieu, String tableName){
        sql = "SELECT masach FROM " + tableName + " WHERE masach = ?";
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
    public void ThemTaiLieu(TaiLieu taiLieu) {
        sql = "INSERT INTO TAILIEU VALUES(?, ?, ?, ?, ?, ?)";
        try {
            var prepare = connection.prepareStatement(sql);
            prepare.setString(1,taiLieu.getMaSach());
            prepare.setString(2,taiLieu.getTenSach());
            prepare.setString(3,taiLieu.getTenTg());
            prepare.setInt(4,taiLieu.getNamXB());
            prepare.setLong(5,taiLieu.getDongia());
            prepare.setString(6,taiLieu.getMaLoaiTaiLieu());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void  XoaTaiLieu(String masach){
        sql = "delete from PHIEUMUON where mamuon = (SELECT mamuon from MUONTRA where masach = ?)"
                +"delete from MUONTRA where masach = ?"+" delete from TAILIEU where masach = ?";
        try {
            var prepare = connection.prepareStatement(sql);
            prepare.setString(1,masach);
            prepare.setString(2,masach);
            prepare.setString(3,masach);
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<TaiLieu> HienThiMot(String tensach) {
        List<TaiLieu> listTL = new ArrayList<TaiLieu>();
        sql = "SELECT * FROM TAILIEU WHERE tensach = ? ";
        try {
            var prepare = connection.prepareStatement(sql);
            prepare.setString(1,tensach);
            var rs = prepare.executeQuery();

            while (rs.next()){
                TaiLieu taiLieu = new TaiLieu();
                taiLieu.setMaSach(rs.getString("masach"));
                taiLieu.setTenSach(rs.getString("tensach"));
                taiLieu.setTenTg(rs.getString("tentg"));
                taiLieu.setNamXB(rs.getInt("namxb"));
                taiLieu.setDongia(rs.getLong("dongia"));
                listTL.add(taiLieu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTL;
    }
    public List<TaiLieu> HienThiTatCa() {
        List<TaiLieu> listTL = new ArrayList<TaiLieu>();
        sql = "SELECT * FROM TAILIEU";
        try {
            var prepare = connection.prepareStatement(sql);
            var rs = prepare.executeQuery();
            while (rs.next()){
                TaiLieu taiLieu = new TaiLieu();
                taiLieu.setMaSach(rs.getString("masach"));
                taiLieu.setTenSach(rs.getString("tensach"));
                taiLieu.setTenTg(rs.getString("tentg"));
                taiLieu.setNamXB(rs.getInt("namxb"));
                taiLieu.setDongia(rs.getLong("dongia"));
                listTL.add(taiLieu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTL;
    }
}
