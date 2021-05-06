package View;

import Controllers.DocGiaController;
import DAO.DocGiaDAO;

import java.util.Scanner;

public class QuanLiDocGia {
    private  DocGiaController docGiaController = new DocGiaController();
    private DocGiaDAO docGiaDAO = new DocGiaDAO();
    public void QuanLi(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("0. Thêm độc giả");
            System.out.println("1. Sửa độc giả");
            System.out.println("2. Xóa độc giả theo mã!");
            System.out.println("3. Tìm độc giả theo tên");
            System.out.println("4. Hiện thị tất cả độc giả");
            choice = scanner.nextInt();
        }while (choice < -1 && choice > 4);
        switch (choice){
            case 0:{
                docGiaDAO.ThemDocGia(docGiaController.ThemDocGia());
                break;
            }
            case 1:{
                docGiaDAO.SuaDocGia(docGiaController.NhapID(),docGiaController.ThemDocGiaDeSua());
                break;
            }
            case 2:{
                docGiaDAO.XoaDocGia(docGiaController.NhapID());
                break;
            }
            case 3:{
                var timkiemtheoTen = docGiaDAO.HienThiMot(docGiaController.NhapHoTen());
                System.out.printf("%-15s%-15s%-15s%-15s%-15s\n", "Số thẻ",
                        "Họ Tên", "Ngày Sinh", "Địa chỉ",
                        "Số điện thoại");
                for (int i = 0; i < timkiemtheoTen.size(); i++) {
                    System.out.printf("%-15s%-15s%-15s%-15s%-15s\n", timkiemtheoTen.get(i).getSoThe(),
                            timkiemtheoTen.get(i).getHoTen(), timkiemtheoTen.get(i).getNgaySinh(),
                            timkiemtheoTen.get(i).getDiaChi(),
                            timkiemtheoTen.get(i).getSoDienThoai());
                }
                break;
            }
            case 4:{
                var HienThiTatCa = docGiaDAO.HienThiTatCa();
                System.out.printf("%-15s%-15s%-15s%-15s%-15s\n", "Số thẻ",
                        "Họ Tên", "Ngày Sinh", "Địa chỉ",
                        "Số điện thoại");
                for (int i = 0; i < HienThiTatCa.size(); i++) {
                    System.out.printf("%-15s%-15s%-15s%-15s%-15s\n", HienThiTatCa.get(i).getSoThe(),
                            HienThiTatCa.get(i).getHoTen(), HienThiTatCa.get(i).getNgaySinh(),
                            HienThiTatCa.get(i).getDiaChi(),
                            HienThiTatCa.get(i).getSoDienThoai());
                }
            }
        }






    }

}
