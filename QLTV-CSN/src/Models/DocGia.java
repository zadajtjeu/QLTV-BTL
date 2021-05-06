package Models;

import javax.print.Doc;
import java.util.Date;

public class DocGia {
    private  String soThe;
    private  String hoTen;
    private String ngaySinh;
    private  String diaChi;
    private  String soDienThoai;
    public DocGia(){

    }
    public DocGia(String hoTen,String ngaySinh, String diaChi,String soDienThoai){
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }
    public DocGia( String soThe, String hoTen,String ngaySinh, String diaChi,String soDienThoai){
        this.soThe = soThe;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getSoThe() {
        return soThe;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setSoThe(String soThe) {
        this.soThe = soThe;
    }


}
