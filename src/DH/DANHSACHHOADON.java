package DH;
import java.util.ArrayList;
public class DANHSACHHOADON {
    ArrayList<THONGTINHOADON> arrayHD=new ArrayList<>();
    char i='0';
    public void themHD(){
        THONGTINHOADON a= new THONGTINHOADON();
        a.NHAP();
        arrayHD.add(a);
        a.maHD="HD"+i;
        i++;
        System.out.println("Them thanh cong!");
        System.out.println(a.maHD);
    }
}
