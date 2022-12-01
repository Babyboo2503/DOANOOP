package project;

import java.text.ParseException;
import java.util.Scanner;

public abstract class MATHANG{
   private int id;
   private String name;
   private double price;
   private String exp;
   private String unit;
   private int quantity;
   private String condition;
   public MATHANG(){
   
   }
    public MATHANG(int id, String name, double price, String exp, String unit, int quantity, String condition) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.exp = exp;
        this.unit = unit;
        this.quantity = quantity;
        this.condition = condition;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getExp() {
        return exp;
    }
    public void setExp(String exp) {
        this.exp = exp;
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
    
    public abstract void giaThanh();
    
    public void nhapId(){
        Scanner inp = new Scanner(System.in);
        System.out.print("Nhập mã mặt hàng: ");
        id= inp.nextInt();
    }
    public void nhapTen(){
        Scanner inp = new Scanner(System.in);
        Checking check = new Checking(); 
        System.out.print("Nhập tên mặt hàng: ");
        name= inp.nextLine();
        
        while( check.checkNull(name)|| !check.checkTextString(name)){
            if (check.checkNull(name)){
                System.out.println("Chưa nhập tên mặt hàng!");
                System.out.print("Nhập tên mặt hàng: ");
                name = inp.nextLine();
            }
            else if (!check.checkTextString(name)){
                System.out.println("Nhập sai định dạng!");
                System.out.print("Nhập lại tên mặt hàng:"); 
                name = inp.nextLine();
            }
        }
    }
    public void nhapGia(){
        Scanner inp = new Scanner(System.in);
        System.out.print("Nhập giá mặt hàng:"); 
        price = inp.nextDouble();
    }
    public void nhapHSD(){
        Scanner inp = new Scanner(System.in);
        Checking check = new Checking();
        System.out.print("Nhập hạn sử dụng: ");
        this.exp = inp.nextLine();

        while ( check.checkNull(exp) ||!check.checkDateFormat(exp) )
        {
            if (check.checkNull(exp)){
                System.out.println("Chưa nhập hạn sử dụng!");
                System.out.println("Nhập hạn sử dụng theo định dạng DD/MM/YYYY. \tVD: 20/10/2020, 01/05/2021");
                exp = inp.nextLine();
            }
            else if(!check.checkDateFormat(exp)){
                System.out.println("Nhập sai định dạng!");
                System.out.println("Nhập lại hạn sử dụng theo định dạng DD/MM/YYYY. \tVD: 20/10/2020, 01/05/2021");
                exp = inp.nextLine();
            }
        }
    }
    public void nhapSoLuong(){
        Scanner inp = new Scanner(System.in);
        System.out.print("Số lượng: "); 
        quantity = inp.nextInt();
    }
    public void nhapDonVi(){
        Scanner inp = new Scanner(System.in);
        Checking check = new Checking(); 
        System.out.print("Nhập đơn vị tính: ");
        unit= inp.nextLine();
        
        while( check.checkNull(unit) ||!check.checkTextString(unit)){
            if( check.checkNull(unit)){
                System.out.println("Chưa nhập đơn vị tính!");
                System.out.println("Nhập đơn vị tính: ");
                unit = inp.nextLine();
            }
            else if (!check.checkTextString(unit)){
                System.out.println("Nhập sai định dạng!");
                System.out.print("Nhập lại đơn vị tính: "); 
                unit = inp.nextLine();
            }
        }
    }
    public void khoiTaoMH(){
        nhapId();
        nhapTen();
        nhapGia();
        nhapHSD();
        nhapSoLuong();
        nhapDonVi();
        kiemTraMatHang();
        giaThanh();
    }
    
    public void kiemTraMatHang(){
        Checking check = new Checking();
        if (check.checkEXP(exp) <= 0)
            setCondition("Hết hạn sử dụng");
        else if (check.checkEXP(exp) > 0)
            setCondition("Còn hạn sử dụng");
    }
    public void xuatMH(){
        System.out.printf("%-15s%-30s%-20s%-20s%-10s%-14s%-20s\n" ,"Mã mặt hàng", "Tên mặt hàng", "Giá", "HSD", "Số lượng", "Đơn vị tính", "Tình trạng");
        System.out.printf("%-15d%-30s%-,20f%-20s%-10d%-14s%-20s\n" ,id, name, price, exp, quantity, unit, condition);
    }
}