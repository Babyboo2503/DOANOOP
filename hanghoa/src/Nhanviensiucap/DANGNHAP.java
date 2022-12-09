package Nhanviensiucap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DANGNHAP extends ACCOUNT {
    Scanner sc = new Scanner(System.in);
    private String tk;
    private String mk;
    private int ok;

    public DANGNHAP() {
        super();
    }

    public int getOk() {
        return ok;
    }

    public void setOk(int ok) {
        this.ok = ok;
    }

    public List<ACCOUNT> readad() {
        List<ACCOUNT> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("accountad.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null)
                    break;
                String txt[] = line.split(";");
                String tkhoan = txt[0];
                String mkhau = txt[1];
                list.add(new ACCOUNT());
                list.get(list.size()-1).setMatkhau(mkhau);
                list.get(list.size()-1).setTaikhoan(tkhoan);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<ACCOUNT> readnv() {
        List<ACCOUNT> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("accountnv.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null)
                    break;
                String txt[] = line.split(";");
                String tkhoan = txt[0];
                String mkhau = txt[1];
                list.add(new ACCOUNT());
                list.get(list.size()-1).setMatkhau(mkhau);
                list.get(list.size()-1).setTaikhoan(tkhoan);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void nhap() {
        System.out.println("Nhap tai khoan");
        tk = sc.next();
        System.out.println("Nhap mat khau");
        mk = sc.next();
        List<ACCOUNT> listad = readad();
        List<ACCOUNT> listnv = readnv();

        for (ACCOUNT a : listad) {
            if (tk.compareTo(a.getTaikhoan()) == 0) {
                if (mk.compareTo(a.getMatkhau()) == 0) {
                    ok = 1;
                    break;

                } else
                    ok = 0;
            } else
                ok = 0;
        }
        if (ok == 1) {
            System.out.println("DANG NHAP THANH CONG");
        } else {
            for (ACCOUNT o : listnv) {
                if (tk.compareTo(o.getTaikhoan()) == 0) {
                    if (mk.compareTo(o.getMatkhau()) == 0) {
                        ok = 2;
                        break;
                    } else
                        ok = 0;
                } else
                    ok = 0;
            }

            if (ok == 2) {
                System.out.println("DANG NHAP THANH CONG");
            } else if (ok == 0) {
                System.out.println("DANG NHAP THAT BAI");
                System.out.println("Xin mời nhập lại ");
            }
        }

    }

}