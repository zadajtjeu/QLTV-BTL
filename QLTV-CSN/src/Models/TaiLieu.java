package Models;

public class TaiLieu extends  LoaiTaiLieu {
    private  String maSach;
    private  String tenSach;
    private  String tenTg;
    private  int namXB;
    private  long dongia;
    public TaiLieu(){

    }
    public TaiLieu(String maSach,String tenSach,String tenTg,int namXB,long dongia,String maloaitailieu){
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tenTg = tenTg;
        this.namXB = namXB;
        this.dongia = dongia;
        this.maLoaiTaiLieu = maloaitailieu;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTenTg() {
        return tenTg;
    }

    public void setTenTg(String tenTg) {
        this.tenTg = tenTg;
    }

    public int getNamXB() {
        return namXB;
    }

    public void setNamXB(int namXB) {
        this.namXB = namXB;
    }

    public long getDongia() {
        return dongia;
    }

    public void setDongia(long dongia) {
        this.dongia = dongia;
    }


}
