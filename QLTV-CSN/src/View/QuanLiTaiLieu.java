package View;

import Controllers.TaiLieuController;
import DAO.TaiLieuDAO;

import java.util.Scanner;

public class QuanLiTaiLieu {

    public void QuanLi(){
        TaiLieuController taiLieuController = new TaiLieuController();
        TaiLieuDAO taiLieuDAO = new TaiLieuDAO();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("0. Thêm tài liệu");
            System.out.println("1. Xóa tài liệu");
            System.out.println("2. Hiển thị loại tài liệu theo tên");
            System.out.println("3. Hiển thị tất cả loại tài liệu");
            choice = scanner.nextInt();
        }while (choice < -1 && choice > 2);
        switch (choice){
            case 0:{
                taiLieuDAO.ThemTaiLieu(taiLieuController.ThemTaiLieu());
                break;
            }
            case 1:{
                taiLieuDAO.XoaTaiLieu(taiLieuController.NhapMaTaiLieu());
                break;
            }

            case 2:{
                var timkiemtheoTen = taiLieuDAO.HienThiMot(taiLieuController.NhapTenSach());
                System.out.printf("%-15s%-50s%-40s%-15s%-15s\n",
                        "Mã sách", "Tên sách", "Tên tác giả",
                        "Năm xuất bản","Đơn giá");
                for (int i = 0; i < timkiemtheoTen.size(); i++) {
                    System.out.printf("%-15s%-50%-40s%-15s%-15s\n", timkiemtheoTen.get(i).getMaSach(),
                            timkiemtheoTen.get(i).getTenSach(), timkiemtheoTen.get(i).getTenTg(),
                            timkiemtheoTen.get(i).getNamXB(),
                            timkiemtheoTen.get(i).getDongia());
                }
                break;
            }
            case 3:{
                var HienThiTatCa = taiLieuDAO.HienThiTatCa();
                System.out.printf("%-15s%-50s%-40s%-15s%-15s\n",
                        "Mã sách", "Tên sách", "Tên tác giả",
                        "Năm xuất bản","Đơn giá");
                for (int i = 0; i < HienThiTatCa.size(); i++) {
                    System.out.printf("%-15s%-50s%-40s%-15s%-15s\n", HienThiTatCa.get(i).getMaSach(),
                            HienThiTatCa.get(i).getTenSach(), HienThiTatCa.get(i).getTenTg(),
                            HienThiTatCa.get(i).getNamXB(),
                            HienThiTatCa.get(i).getDongia());
                }
            }
        }
}
}
