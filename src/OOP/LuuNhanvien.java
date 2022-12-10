package OOP;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * LuuNhanvien class
 *
 * @author Nhanviensiucap
 */
public class LuuNhanvien {

    /**
     * save list nhanvien to file
     *
     * @param nhanvienList: list nhanvien to save
     */
    public void write(List<Nhanvien> nhanvienList) {
        try {
            FileWriter fw= new FileWriter("nhanvien.txt");
            for(Nhanvien o: nhanvienList){
                String str;
                str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s\n", o.getId(), o.getName(), o.getAge(), o.getEmail(), o.getAddress(), o.getPhonenumber(), o.getPosision(), o.getOvertime(), o.getSalary());
                fw.write(str);
            }
            fw.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * read list nhanvien from file
     *
     * @return list nhanvien
     */
    public ArrayList<Nhanvien> read() {
        ArrayList<Nhanvien> nhanvienList = new ArrayList<>();
        try {
            FileReader fr= new FileReader("nhanvien.txt");
            BufferedReader br= new BufferedReader(fr);
            String line= br.readLine();
            if(line==null){
                System.out.println("Khong co thong tin nhan vien!");
                br.close();
                fr.close();
                return null;
            }
            while (line != null) {
                String txt[]= line.split(",");
                int id=Integer.parseInt(txt[0]);
                String name=txt[1];
                int age=Integer.parseInt(txt[2]);
                String email=txt[3];
                String address=txt[4];
                String phonenumber=txt[5];
                String position=txt[6];
                int overtime=Integer.parseInt(txt[7]);
                int salary=Integer.parseInt(txt[8]);
                
                nhanvienList.add(new Nhanvien(id, name, age, address, phonenumber, position, salary, email, overtime) );
                line= br.readLine();
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return nhanvienList;
    }
}