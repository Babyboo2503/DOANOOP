package Nhanviensiucap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class ACCOUNT {
    private String taikhoan;
    private String matkhau;

    public ACCOUNT() {
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    @Override
    public String toString() {
        return "Tai khoan :" + taikhoan + " Mat khau :" + matkhau;
    }


}
