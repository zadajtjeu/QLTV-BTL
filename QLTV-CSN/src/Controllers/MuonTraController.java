package Controllers;

import DAO.DocGiaDAO;
import DAO.LoaiTaiLieuDAO;
import DAO.MuonTraDAO;
import DAO.TaiLieuDAO;
import Models.LoaiTaiLieu;
import Models.MuonTra;

import java.util.Scanner;

public class MuonTraController {
    private Scanner scanner = new Scanner(System.in);
    private MuonTraDAO muonTraDAO = new MuonTraDAO();
    private TaiLieuDAO taiLieuDAO = new TaiLieuDAO();
    private DocGiaDAO docGiaDAO = new DocGiaDAO();

    //Hàm check xem id có thỏa mãn dạng mẫu không .
    public boolean checkID(String id){
        var regex  = "^M_\\d{2,6}$";
        if (id.matches(regex)){
            return true;
        }
        return false;
    }
    public MuonTra ThemMuonTra() {
        var mamuon = "";
        // kiem tra ma khi nhap
        do {
            System.out.println("Nhập mã mượn:(ví dụ M_01)");
            mamuon = scanner.nextLine();
        }while (!checkID(mamuon));

        // kiểm tra có id trong database
        var isIDValid = muonTraDAO.isIDValid(mamuon, "MUONTRA");
        while (!isIDValid){
            System.out.println("Mã mượn đã tồn tại !");
            System.out.println("Nhập lại mã mượn :(ví dụ M_01)");
            mamuon = scanner.nextLine();
            isIDValid = muonTraDAO.isIDValid(mamuon, "MUONTRA");
        }

        System.out.println("Nhập số ngày mượn : ");
        var songaymuon = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập mã loại tài liệu:(ví dụ MS_01)");
        var maSach = scanner.nextLine();

        // kiểm tra có id trong database
        var isMSValid = taiLieuDAO.isIDValid(maSach, "TAILIEU");
        while (isMSValid){
            System.out.println("Mã sách chưa tồn tại !");
            System.out.println("Nhập lại mã sách :(ví dụ MS_01)");
            maSach = scanner.nextLine();
            isMSValid = taiLieuDAO.isIDValid(maSach, "TAILIEU");
        }

        System.out.println("Nhập mã độc giả :(ví dụ DG_01)");
        var sothe = scanner.nextLine();
        // kiểm tra có id trong database
        var isSTValid = docGiaDAO.isIDValid(sothe, "dbo.DOCGIA");
        while (isSTValid){
            System.out.println("Mã độc giả đã tồn tại !");
            System.out.println("Nhập lại mã độc giả :(ví dụ DOC_012345)");
            sothe = scanner.nextLine();
            isSTValid = docGiaDAO.isIDValid(sothe, "DOCGIA");
        }
        return new MuonTra(mamuon,songaymuon,maSach,sothe);
    }
    public String NhapMaMuon(){
        System.out.println("Nhập mã mượn:(ví dụ M_01)");
        var mamuon = scanner.nextLine();
        var isIDValid = muonTraDAO.isIDValid(mamuon, "MUONTRA");
        while (isIDValid){
            System.out.println("Mã mượn chưa tồn tại !");
            System.out.println("Nhập lại mã mượn :(ví dụ M_01)");
            mamuon = scanner.nextLine();
            isIDValid = muonTraDAO.isIDValid(mamuon, "MUONTRA");
        }
        return mamuon;
    }
}
