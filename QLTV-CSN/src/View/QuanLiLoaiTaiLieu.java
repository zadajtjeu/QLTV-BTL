package View;

import Controllers.DocGiaController;
import Controllers.LoaiTaiLieuController;
import DAO.DocGiaDAO;
import DAO.LoaiTaiLieuDAO;

import java.util.Scanner;

public class QuanLiLoaiTaiLieu {
    private LoaiTaiLieuController loaiTaiLieuController = new LoaiTaiLieuController();
    private LoaiTaiLieuDAO loaiTaiLieuDAO = new LoaiTaiLieuDAO();
    public void QuanLi(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("0. Thêm loại tài liệu");
            System.out.println("1. Xóa loại tài liệu");
            System.out.println("2. Hiển thị loại tài liệu");
            choice = scanner.nextInt();
        }while (choice < -1 && choice > 2);
        switch (choice){
            case 0:{
                loaiTaiLieuDAO.ThemLoaiTaiLieu(loaiTaiLieuController.ThemLoaiTaiLieu());
                break;
            }
            case 1:{
                loaiTaiLieuDAO.XoaLoaiTaiLieu(loaiTaiLieuController.NhapMaLoaiTaiLieu());
                break;
            }

            case 2:{
                var HienThiTatCa = loaiTaiLieuDAO.HienThiTatCa();
                System.out.printf("%-20s%-20s\n", "Mã loại tài liệu",
                        "Tên loại tài liệu");
                for (int i = 0; i < HienThiTatCa.size(); i++) {
                    System.out.printf("%-15s%-15s\n", HienThiTatCa.get(i).getMaLoaiTaiLieu(),
                            HienThiTatCa.get(i).getTenLoaiTaiLieu());
                }
            }
        }
    }
}
