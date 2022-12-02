package Nhanviensiucap;

import java.io.Serializable;

public class Nhanvien implements Serializable {
    private int id,salary,phonenumber,yearofbirth,basicsalary,overtime;
    private String name;
    private byte age;
    private String address,posision;
    public Nhanvien() {
    }


    public Nhanvien(int id, String name, byte age, String address, int phonenumber, String posision , int salary,int yearofbirth,int overtime ) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phonenumber = phonenumber;
        this.posision = posision;
        this.salary = salary;
        this.yearofbirth=yearofbirth;
        this.overtime = overtime;
    }

    @Override
    public String toString() {
        return String.format("%5s | %-15s | %5s | %15s | %-35s | %010d | %-25s | %10s | %15s", this.id, this.name,
                this.age, this.yearofbirth,this.address,this.phonenumber, this.posision,this.overtime, this.salary);
    }

    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
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

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
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

    public int getYearofbirth() {
        return yearofbirth;
    }

    public void setYearofbirth(int yearofbirth) {
        this.yearofbirth = yearofbirth;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }
}