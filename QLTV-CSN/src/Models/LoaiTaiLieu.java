package Models;

public class LoaiTaiLieu {
    public  String maLoaiTaiLieu;
    public  String tenLoaiTaiLieu;
    public  LoaiTaiLieu(){

    }
    public  LoaiTaiLieu(String maLoaiTaiLieu,String tenLoaiTaiLieu){
        this.maLoaiTaiLieu = maLoaiTaiLieu;
        this.tenLoaiTaiLieu = tenLoaiTaiLieu;
    }

    public String getMaLoaiTaiLieu() {
        return maLoaiTaiLieu;
    }

    public void setMaLoaiTaiLieu(String maLoaiTaiLieu) {
        this.maLoaiTaiLieu = maLoaiTaiLieu;
    }

    public String getTenLoaiTaiLieu() {
        return tenLoaiTaiLieu;
    }

    public void setTenLoaiTaiLieu(String tenLoaiTaiLieu) {
        this.tenLoaiTaiLieu = tenLoaiTaiLieu;
    }



}
