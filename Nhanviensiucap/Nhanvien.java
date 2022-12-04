package Nhanviensiucap;

import java.io.Serializable;

public class Nhanvien implements Serializable  {
    private int id,salary,overtime;
    private String name;
    private byte age;
    private String address,posision,phonenumber,email;
    public Nhanvien(int id, String name, byte age, String address, String phonenumber, String posision, int salary, int email, int overtime) {
    }


    public Nhanvien(int id, String name, byte age, String address, String phonenumber, String posision , int salary,String email,int overtime ) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phonenumber = phonenumber;
        this.posision = posision;
        this.salary = salary;
        this.email=email;
        this.overtime = overtime;
    }

    @Override
    public String toString() {
        return String.format("%5s | %-15s | %5s | %-25s | %-35s | %10s | %-25s | %10s | %15s", this.id, this.name,
                this.age, this.email,this.address,this.phonenumber, this.posision,this.overtime, this.salary);
    }

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPosision() {
        return posision;
    }

    public void setPosision(String posision) {
        this.posision = posision;
    }

    public int getSalary() {
        this.salary = this.salary + this.overtime * 30000;
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }
}