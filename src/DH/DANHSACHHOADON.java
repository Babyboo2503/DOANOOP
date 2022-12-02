package DH;
import java.util.ArrayList;
public class DANHSACHHOADON {
    ArrayList<HOADON> arrayHD=new ArrayList<>();
    char i='0';
    public void themHD(){
        HOADON a= new HOADON();
        a.NHAP();
        arrayHD.add(a);
        a.maHD="HD"+i;
        i++;
        System.out.println("Them thanh cong!");
        System.out.println(a.maHD);
    }
}
