package Models;

import java.util.Date;

public class PhieuMuon {
    private String maMuon;
    private String tenDocGia;
    private String tenSach;
    private long tienCoc;
    private long tienPhiMuon;
    public PhieuMuon(){

    }
    public PhieuMuon(String maMuon,String tenDocGia,String tenSach, Date ngayMuon,Date ngayTra,long tienCoc,long tienPhiMuon){
        this.maMuon  = maMuon;
        this.tenDocGia = tenDocGia;
        this.tenSach = tenSach;
        this.tienCoc = tienCoc;
        this.tienPhiMuon = tienPhiMuon;
    }


    public String getTenSach() {
        return tenSach;
    }

    public long getTienCoc() {
        return tienCoc;
    }

    public long getTienPhiMuon() {
        return tienPhiMuon;
    }

    public String getMaMuon() {
        return maMuon;
    }

    public String getTenDocGia() {
        return tenDocGia;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setMaMuon(String maMuon) {
        this.maMuon = maMuon;
    }

    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    public void setTienCoc(long tienCoc) {
        this.tienCoc = tienCoc;
    }

    public void setTienPhiMuon(long tienPhiMuon) {
        this.tienPhiMuon = tienPhiMuon;
    }

}
