package OOP;

public class ACCOUNT {
    private String taikhoan;
    private String matkhau;
    private int id;
    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public ACCOUNT(String taikhoan, String matkhau, int id) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.id = id;
    }
    public ACCOUNT(){
        this.taikhoan=null;
        this.matkhau=null;
        this.id=0;
    }
    @Override
    public String toString() {
        return this.taikhoan+";"+this.matkhau+";"+this.id;
    }
    
 
}