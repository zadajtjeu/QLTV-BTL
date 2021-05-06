package View;

import Controllers.MuonTraController;
import DAO.MuonTraDAO;
import DAO.PhieuMuonDAO;

import java.util.Scanner;

public class QuanLiPhieuMuon {
    private MuonTraController muonTraController = new MuonTraController();
    private PhieuMuonDAO phieuMuonDAO  = new PhieuMuonDAO();
    public void QuanLi(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("0. In phiếu mượn");
            System.out.println("1. Xóa phiếu mượn theo mã");
            choice = scanner.nextInt();
        }while (choice < -1 && choice > 1);
        switch (choice){
            case 0:{
                var p = phieuMuonDAO.Inra(muonTraController.NhapMaMuon());
                System.out.printf("%-15s%-15s%-15s%-15s%-15s\n",
                        "Mã mượn",
                        "Tên sách",
                        "Tên độc giả",
                        "Phí mượn",
                        "Tiền cọc");
                System.out.printf("%-15s%-15s%-15s%-15s%-15s\n",
                        p.getMaMuon(),
                        p.getTenSach(),
                        p.getTenDocGia(),
                        p.getTienPhiMuon(),
                        p.getTienCoc());
                break;
            }
            case 1:{
                phieuMuonDAO.XoaTheoMa(muonTraController.NhapMaMuon());
                break;
            }

        }
}
}
