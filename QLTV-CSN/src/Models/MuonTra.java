package Models;

import java.util.Date;

public class MuonTra {
    private  String maMuon;
    private int Songaymuon;
    private String masach;
    private String sothe;
    public MuonTra(){

    }
    public MuonTra(String maMuon,int songaymuon,String masach, String sothe){
        this.maMuon = maMuon;
        this.Songaymuon = songaymuon;
        this.masach  = masach;
        this.sothe = sothe;
    }

    public String getMasach() {
        return masach;
    }

    public String getSothe() {
        return sothe;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public void setSothe(String sothe) {
        this.sothe = sothe;
    }

    public String getMaMuon() {
        return maMuon;
    }

    public void setMaMuon(String maMuon) {
        this.maMuon = maMuon;
    }

    public int getSongaymuon() {
        return Songaymuon;
    }

    public void setSongaymuon(int songaymuon) {
        Songaymuon = songaymuon;
    }


}
