package project;

import java.text.ParseException;
import java.util.Scanner;

public abstract class MATHANG{
   private String id;
   private String name;
   private long price;
    private String exp;
   private String unit;
   private int quantity;
   private String condition;
   
    Checking check = new Checking(); 

   public MATHANG(){
   
   }
    public MATHANG(String id, String name, long price, String exp, String unit, int quantity, String condition) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.exp = exp;
        this.unit = unit;
        this.quantity = quantity;
        this.condition = condition;
    }
    public MATHANG(String id, String name, long price, String unit, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.quantity = quantity;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
    public String getExp() {
        return exp;
    }
    public void setExp(String exp) {
        this.exp = exp;
    }
    public abstract void giaThanh();
    
    public void nhapId(){
        Scanner inp = new Scanner(System.in); 
        System.out.print("Nhap ma mat hang: ");
        id= inp.nextLine();
        while(true){
            if (check.checkNull(id)){
                System.out.println("Chua nhap ma mat hang!");
                System.out.print("Nhap ma mat hang: ");
                id = inp.nextLine();
            }
            else if(!check.checkNumString(id)){
                System.out.println("Nhap sai dinh dang!");
                System.out.print("Nhap lai ma mat hang (chuoi ky tu so): ");
                id = inp.nextLine();
            }
            else{
                break;
            }
        }
    }
    public void nhapTen(){
        Scanner inp = new Scanner(System.in);
        System.out.print("Nhap ten mat hang: ");
        name= inp.nextLine();
        
        while( true ){
            if (check.checkNull(name)){
                System.out.println("Chua nhap ten mat hang!");
                System.out.print("Nhap ten mat hang: ");
                name = inp.nextLine();
            }
            else if (!check.checkTextString(name)){
                System.out.println("Nhap sai dinh dang!");
                System.out.print("Nhap lai ten mat hang: "); 
                name = inp.nextLine();
            }
            else{
                break;
            }
        }
    }
    public void nhapGia(){
        Scanner inp = new Scanner(System.in);
        System.out.print("Nhap gia mat hang: "); 
        price = inp.nextLong();
    }
    public void nhapSoLuong(){
        Scanner inp = new Scanner(System.in);
        System.out.print("So luong: "); 
        quantity = inp.nextInt();
    }
    public void nhapHSD(){
        Scanner inp = new Scanner(System.in);
        System.out.print("Nhap han su dung: ");
        this.exp = inp.nextLine();

        while ( check.checkNull(exp) ||!check.checkDateFormat(exp) )
        {
            if (check.checkNull(exp)){
                System.out.println("Chua nhap han su dung!");
                System.out.println("Nhap han su dung theo đinh dang DD/MM/YYYY. \tVD: 20/10/2020, 01/05/2021");
                exp = inp.nextLine();
            }
            else if(!check.checkDateFormat(exp)){
                System.out.println("Nhap sai định dạng!");
                System.out.println("Nhap lại han su dung theo đinh dang DD/MM/YYYY. \tVD: 20/10/2020, 01/05/2021");
                exp = inp.nextLine();
            }
        }
    }
    public void nhapDonVi(){
        Scanner inp = new Scanner(System.in);
        System.out.print("Nhap don vi tinh: ");
        unit= inp.nextLine();
        
        while( true ){
            if( check.checkNull(unit)){
                System.out.println("Chua nhap don vi tinh!");
                System.out.println("Nhap don vi tinh: ");
                unit = inp.nextLine();
            }
            else if (!check.checkTextString(unit)){
                System.out.println("Nhap sai dinh dang!");
                System.out.print("Nhap lai don vi tinh: "); 
                unit = inp.nextLine();
            }
            else{
                break;
            }
        }
    }
    
    public abstract void khoiTaoMH();
    public abstract void khoiTaoMH(String mamh);
    public void xuatMH(){
        //System.out.printf("%-15s%-30s%-20s%-20s%-10s\t%-14s%-20s\n" ,"Ma mat hang", "Ten mat hang", "Gia", "HSD", "So luong", "Don vi tinh", "Tinh trang");
        System.out.printf("%-15s%-30s%-,20d%-20s%-10d%-14s%-20s\n" ,id, name, price, exp, quantity, unit, condition);
    }
}