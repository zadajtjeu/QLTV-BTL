package View;

import Controllers.DocGiaController;
import Controllers.LoaiTaiLieuController;
import Controllers.MuonTraController;
import Controllers.TaiLieuController;
import DAO.DocGiaDAO;
import DAO.LoaiTaiLieuDAO;
import DAO.MuonTraDAO;
import DAO.TaiLieuDAO;
import Models.DocGia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainOfView.QuanLiThuVien();
        int choice ;

        do {
            System.out.println("0. Tiếp Tục");
            System.out.println("1. Thoát");
            choice = scanner.nextInt();
        }while (choice < -1 && choice > 4);
        switch (choice){
            case 0:{
                MainOfView.QuanLiThuVien();
                System.out.println("0. Tiếp Tục");
                System.out.println("1. Thoát");
                choice = scanner.nextInt();
                break;
            }
            case 1:{
                break;
            }
        }

    }
}
