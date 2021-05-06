package Controllers;

import DAO.DocGiaDAO;
import Models.DocGia;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DocGiaController {
    private Scanner scanner = new Scanner(System.in);
    private DocGiaDAO docGiaDAO = new DocGiaDAO();
    //Hàm check xem id có thỏa mãn dạng mẫu không .
    public boolean checkID(String id){
        var regex  = "^DG_\\d{2,6}$";
        if (id.matches(regex)){
            return true;
        }
        return false;
    }
    public DocGia ThemDocGia() {
        var sothe = "";
        // kiem tra id when enter
        do {
            System.out.println("Nhập mã độc giả :(ví dụ DG_01)");
            sothe = scanner.nextLine();
        }while (!checkID(sothe));

        // kiểm tra có id trong database
        var isIDValid = docGiaDAO.isIDValid(sothe, "dbo.DOCGIA");
        while (!isIDValid){
            System.out.println("Mã độc giả đã tồn tại !");
            System.out.println("Nhập lại mã độc giả :(ví dụ DOC_012345)");
            sothe = scanner.nextLine();
            isIDValid = docGiaDAO.isIDValid(sothe, "DOCGIA");
        }
        // nhập họ tên
        System.out.println("Nhập họ tên : ");
        var hoten = scanner.nextLine();
        //nhập ngày sinh
        System.out.println("Nhập ngày sinh : ");
        var ngaysinh = scanner.nextLine();

       //nhập địa chỉ
        System.out.println("Nhập địa chỉ");
       var diachi = scanner.nextLine();
        //nhập số điện thoại
        System.out.println("Nhập số điện thoại");
        var sdt  = scanner.nextLine();
        //declare đối tượng d của lớp Document với các thuộc tính đã được nhập vào !
        return new DocGia(sothe, hoten,ngaysinh ,diachi, sdt);
    }
    public String NhapID(){
        System.out.println("Nhập mã độc giả :(ví dụ DG_01)");
        var soThe = scanner.nextLine();
        // check sothe đã có trong data hay chưa , nếu
        // chưa thì thông báo tồn tại và try again
        var isValid = docGiaDAO.isIDValid(soThe, "dbo.DOCGIA");
        while (isValid){
            System.out.println("Nhập vào mã độc giả : ");
            soThe = scanner.nextLine();
            isValid = docGiaDAO.isIDValid(soThe, "dbo.DOCGIA");
        }
        return soThe;
    }
    public DocGia ThemDocGiaDeSua() {
        // nhập họ tên
        System.out.println("Nhập họ tên : ");
        var hoten = scanner.nextLine();
        //nhập ngày sinh
        System.out.println("Nhập ngày sinh : ");
        var ngaysinh = scanner.nextLine();
        //nhập địa chỉ
        System.out.println("Nhập địa chỉ");
        var diachi = scanner.nextLine();
        //nhập số điện thoại
        System.out.println("Nhập số điện thoại");
        var sdt  = scanner.nextLine();
        //declare đối tượng d của lớp Document với các thuộc tính đã được nhập vào !
        return new DocGia( hoten,ngaysinh ,diachi, sdt);
    }
    public String NhapHoTen(){
        System.out.println("Nhập họ tên : ");
        var hoten = scanner.nextLine();

        return hoten;
    }

}
