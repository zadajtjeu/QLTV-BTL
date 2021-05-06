package DAO;

import Models.DocGia;
import Models.LoaiTaiLieu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiTaiLieuDAO {
    private Connection connection = MConnection.getInstance().getConnection();
    private String sql;
    public boolean isIDValid(String maloaitailieu, String tableName){
        sql = "SELECT maloaitailieu FROM " + tableName + " WHERE maloaitailieu = ?";
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
    public void ThemLoaiTaiLieu(LoaiTaiLieu taiLieu) {
        sql = "INSERT INTO LOAITAILIEU VALUES(?, ?)";
        try {
            var prepare = connection.prepareStatement(sql);
            prepare.setString(1,taiLieu.getMaLoaiTaiLieu());
            prepare.setString(2,taiLieu.getTenLoaiTaiLieu());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void  XoaLoaiTaiLieu(String maloaitailieu){

        sql = " delete from PHIEUMUON WHERE mamuon = (SELECT mamuon FROM MUONTRA WHERE " +
                "masach = (SELECT masach FROM TAILIEU WHERE maloaitailieu = ?))\n" +
                "\n" +
                "delete from MUONTRA where masach = (SELECT masach from TAILIEU " +
                "WHERE maloaitailieu = ?)\n" +
                "\n" +
                "delete from TAILIEU where maloaitailieu = ?\n" +
                "\n" +
                "delete from LOAITAILIEU where maloaitailieu = ?";
        try {
            var prepare = connection.prepareStatement(sql);
            prepare.setString(1,maloaitailieu);
            prepare.setString(2,maloaitailieu);
            prepare.setString(3,maloaitailieu);
            prepare.setString(4,maloaitailieu);
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<LoaiTaiLieu> HienThiTatCa() {
        List<LoaiTaiLieu> listLTL = new ArrayList<LoaiTaiLieu>();
        sql = "SELECT * FROM LoaiTaiLieu";
        try {
            var prepare = connection.prepareStatement(sql);
            var rs = prepare.executeQuery();
            while (rs.next()){
                LoaiTaiLieu ltl = new LoaiTaiLieu();
                ltl.setMaLoaiTaiLieu(rs.getString("maloaitailieu"));
                ltl.setTenLoaiTaiLieu(rs.getString("tenloaitailieu"));
                listLTL.add(ltl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listLTL;
    }
}
