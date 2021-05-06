package View;

import Controllers.MuonTraController;
import DAO.PhieuMuonDAO;

import java.util.Scanner;

public class MainOfView {
        public static void QuanLiThuVien(){
            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("0. Quản lý độc giả");
                System.out.println("1. Quản lý loại tài liệu");
                System.out.println("2. Quản lý tài liệu");
                System.out.println("3. Quản lý thông tin mượn");
                System.out.println("4. In phiếu mượn");
                choice = scanner.nextInt();
            }while (choice < -1 && choice > 4);
            switch (choice){
                case 0:{
                   QuanLiDocGia quanLiDocGia = new QuanLiDocGia();
                   quanLiDocGia.QuanLi();
                    break;
                }
                case 1:{
                    QuanLiLoaiTaiLieu quanLiLoaiTaiLieu = new QuanLiLoaiTaiLieu();
                    quanLiLoaiTaiLieu.QuanLi();
                    break;
                }
                case 2:{
                    QuanLiTaiLieu quanLiTaiLieu = new QuanLiTaiLieu();
                    quanLiTaiLieu.QuanLi();
                    break;
                }
                case 3:{
                    QuanLiMuonTra quanLiMuonTra = new QuanLiMuonTra();
                    quanLiMuonTra.QuanLi();
                    break;
                }
                case 4:{
                    QuanLiPhieuMuon quanLiPhieuMuon = new QuanLiPhieuMuon();
                    quanLiPhieuMuon.QuanLi();
                }
            }
        }
}
