package Controllers;
import DAO.LoaiTaiLieuDAO;
import Models.LoaiTaiLieu;

import java.util.Scanner;

public class LoaiTaiLieuController {
    private Scanner scanner = new Scanner(System.in);
    private LoaiTaiLieuDAO loaiTaiLieuDAO = new LoaiTaiLieuDAO();
    //Hàm check xem id có thỏa mãn dạng mẫu không .
    public boolean checkID(String id){
        var regex  = "^TL_\\d{2,6}$";
        if (id.matches(regex)){
            return true;
        }
        return false;
    }
    public LoaiTaiLieu ThemLoaiTaiLieu() {
        var maloaitailieu = "";
        // kiem tra ma khi nhap
        do {
            System.out.println("Nhập mã loại tài liệu:(ví dụ TL_01)");
            maloaitailieu = scanner.nextLine();
        }while (!checkID(maloaitailieu));

        // kiểm tra có id trong database
        var isIDValid = loaiTaiLieuDAO.isIDValid(maloaitailieu, "LOAITAILIEU");
        while (!isIDValid){
            System.out.println("Mã loại tài liệu đã tồn tại !");
            System.out.println("Nhập lại mã loại tài liệu :(ví dụ TL_01)");
            maloaitailieu = scanner.nextLine();
            isIDValid = loaiTaiLieuDAO.isIDValid(maloaitailieu, "LOAITAILIEU");
        }
        // nhập họ tên
        System.out.println("Nhập tên loại tài liệu : ");
        var tenloaitailieu = scanner.nextLine();

        return new LoaiTaiLieu(maloaitailieu, tenloaitailieu);
    }
    public String NhapMaLoaiTaiLieu(){
        System.out.println("Nhập mã loại tài liệu:(ví dụ TL_01)");
        var  maloaitailieu = scanner.nextLine();

        // kiểm tra có maloaitailieu trong database
        var isIDValid = loaiTaiLieuDAO.isIDValid(maloaitailieu, "LOAITAILIEU");
        while (isIDValid){
            System.out.println("Mã loại tài liệu chưa tồn tại !");
            System.out.println("Nhập lại mã loại tài liệu :(ví dụ TL_01)");
            maloaitailieu = scanner.nextLine();
            isIDValid = loaiTaiLieuDAO.isIDValid(maloaitailieu, "LOAITAILIEU");
        }
        return maloaitailieu;
    }
}
