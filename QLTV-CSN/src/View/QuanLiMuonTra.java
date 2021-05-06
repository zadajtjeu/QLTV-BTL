package View;

import Controllers.LoaiTaiLieuController;
import Controllers.MuonTraController;
import DAO.LoaiTaiLieuDAO;
import DAO.MuonTraDAO;

import java.util.Scanner;

public class QuanLiMuonTra {
    private MuonTraController muonTraController = new MuonTraController();
    private MuonTraDAO muonTraDAO = new MuonTraDAO();
    public void QuanLi(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("0. Thêm mượn trả");
            System.out.println("1. Xóa mượn trả");
            System.out.println("2. Hiển thị mượn trả");
            choice = scanner.nextInt();
        }while (choice < -1 && choice > 2);
        switch (choice){
            case 0:{
                muonTraDAO.ThemMuonTra(muonTraController.ThemMuonTra());
                break;
            }
            case 1:{
                muonTraDAO.XoaMuon(muonTraController.NhapMaMuon());
                break;
            }
            case 2:{
                var HienThiTatCa = muonTraDAO.HienThiTatCa();
                System.out.printf("%-15s%-15s%-15s%-15s\n", "Mã mượn",
                        "Số ngày mượn", "mã sách", "mã số thẻ");
                for (int i = 0; i < HienThiTatCa.size(); i++) {
                    System.out.printf("%-15s%-15s%-15s%-15s\n",
                            HienThiTatCa.get(i).getMaMuon(),
                            HienThiTatCa.get(i).getSongaymuon(),
                            HienThiTatCa.get(i).getMasach(),
                            HienThiTatCa.get(i).getSothe());
                }
            }


        }
    }
}
