package DAO;

import Controllers.DocGiaController;
import Models.DocGia;

import javax.print.Doc;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocGiaDAO {
    private Connection connection = MConnection.getInstance().getConnection();
    private String sql;
    public boolean isIDValid(String sothe, String tableName){
        sql = "SELECT Sothe FROM " + tableName + " WHERE Sothe = ?";
        try {
            var prepare = connection.prepareStatement(sql);
            prepare.setString(1,sothe);
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
    public void ThemDocGia(DocGia dg) {
        sql = "INSERT INTO DOCGIA VALUES(?, ?, ?, ?, ?)";
        try {
            var prepare = connection.prepareStatement(sql);
            prepare.setString(1,dg.getSoThe());
            prepare.setString(2,dg.getHoTen());
            prepare.setString(3, dg.getNgaySinh());
            prepare.setString(4,dg.getDiaChi());
            prepare.setString(5, dg.getSoDienThoai());
            prepare.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void SuaDocGia(String sothe, DocGia dg) {

        sql = "UPDATE DOCGIA SET hoten =  ? , ngaysinh = ?, diachi = ?, sodienthoai = ? " +
                "WHERE sothe = ?";
        try {
            var prepare = connection.prepareStatement(sql);
            prepare.setString(1,dg.getHoTen());
            prepare.setString(2,dg.getNgaySinh());
            prepare.setString(3,dg.getDiaChi());
            prepare.setString(4,dg.getSoDienThoai());
            prepare.setString(5,sothe);
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void XoaDocGia(String soThe) {
        sql = "delete from PHIEUMUON where mamuon = (select mamuon from MUONTRA where soThe = ?)"+
                "delete from MUONTRA where soThe = ?"+" delete from DOCGIA where soThe = ?";
        try {

            var prepare = connection.prepareStatement(sql);
            prepare.setString(1,soThe);
            prepare.setString(2,soThe);
            prepare.setString(3,soThe);
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<DocGia> HienThiMot(String hoten) {
        List<DocGia> listDG = new ArrayList<DocGia>();
        sql = "SELECT * FROM DOCGIA WHERE hoten = ? ";
        try {
            var prepare = connection.prepareStatement(sql);
            prepare.setString(1,hoten);
            var rs = prepare.executeQuery();

            while (rs.next()){
                DocGia dg = new DocGia();
                dg.setSoThe(rs.getString("sothe"));
                dg.setHoTen(rs.getString("hoten"));
                dg.setNgaySinh(rs.getString("ngaysinh"));
                dg.setDiaChi(rs.getString("diachi"));
                dg.setSoDienThoai(rs.getString("sodienthoai"));
                listDG.add(dg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDG;
    }
    public List<DocGia> HienThiTatCa() {
        List<DocGia> listDG = new ArrayList<DocGia>();
        sql = "SELECT * FROM DOCGIA";
        try {
            var prepare = connection.prepareStatement(sql);
            var rs = prepare.executeQuery();
            while (rs.next()){
                DocGia dg = new DocGia();
                dg.setSoThe(rs.getString("sothe"));
                dg.setHoTen(rs.getString("hoten"));
                dg.setNgaySinh(rs.getString("ngaysinh"));
                dg.setDiaChi(rs.getString("diachi"));
                dg.setSoDienThoai(rs.getString("sodienthoai"));
                listDG.add(dg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDG;
    }
}
