package Controllers;

import DAO.LoaiTaiLieuDAO;
import DAO.TaiLieuDAO;
import Models.LoaiTaiLieu;
import Models.TaiLieu;

import java.util.Scanner;

public class TaiLieuController{
    private Scanner scanner = new Scanner(System.in);
    private TaiLieuDAO taiLieuDAO = new TaiLieuDAO();
    private  LoaiTaiLieuDAO loaiTaiLieuDAO = new LoaiTaiLieuDAO();

    //Hàm check xem id có thỏa mãn dạng mẫu không .
    public boolean checkID(String id){
        var regex  = "^MS_\\d{2,6}$";
        if (id.matches(regex)){
            return true;
        }
        return false;
    }
    public TaiLieu ThemTaiLieu() {
        var maSach = "";
        // kiem tra ma khi nhap
        do {
            System.out.println("Nhập mã loại tài liệu:(ví dụ MS_01)");
            maSach = scanner.nextLine();
        }while (!checkID(maSach));

        // kiểm tra có id trong database
        var isIDValid = taiLieuDAO.isIDValid(maSach, "TAILIEU");
        while (!isIDValid){
            System.out.println("Mã sách đã tồn tại !");
            System.out.println("Nhập lại mã sách :(ví dụ MS_01)");
            maSach = scanner.nextLine();
            isIDValid = taiLieuDAO.isIDValid(maSach, "TAILIEU");
        }
        // nhập họ tên
        System.out.println("Nhập tên sách : ");
        var tensach = scanner.nextLine();
        System.out.println("Nhập tên tác giả : ");
        var tentg = scanner.nextLine();
        System.out.println("Nhập năm xuất bản : ");
        var namxb = scanner.nextInt();
        System.out.println("Nhập đơn giá : ");
        var dongia = scanner.nextLong();
        var maloaitailieu = "";
        // kiem tra ma khi nhap
        //xóa bộ nhớ đệm
        scanner.nextLine();
        System.out.println("Nhập mã loại tài liệu:(ví dụ TL_01)");
        maloaitailieu = scanner.nextLine();

        // kiểm tra có id trong database
        var isTLValid = loaiTaiLieuDAO.isIDValid(maloaitailieu, "LOAITAILIEU");
        while (isTLValid){
            System.out.println("Mã loại tài liệu đã tồn tại !");
            System.out.println("Nhập lại mã loại tài liệu :(ví dụ TL_01)");
            maloaitailieu = scanner.nextLine();
            isTLValid = loaiTaiLieuDAO.isIDValid(maloaitailieu, "LOAITAILIEU");
        }
        return new TaiLieu(maSach,tensach,tentg,namxb,dongia,maloaitailieu);
    }
    public String NhapMaTaiLieu(){
        System.out.println("Nhập mã sách:(ví dụ MS_01)");
        var masach = scanner.nextLine();

        // kiểm tra có maloaitailieu trong database
        var isIDValid = taiLieuDAO.isIDValid(masach, "TAILIEU");
        while (isIDValid){
            System.out.println(isIDValid);
            System.out.println("Mã sách chưa tồn tại !");
            System.out.println("Nhập lại mã sách :(ví dụ MS_01)");
            masach = scanner.nextLine();
            isIDValid = taiLieuDAO.isIDValid(masach, "TAILIEU");
        }
        return masach;
    }
    public String NhapTenSach(){
        System.out.println("Nhập tên sách :");
        var tensach = scanner.nextLine();
        return tensach;
    }

}
