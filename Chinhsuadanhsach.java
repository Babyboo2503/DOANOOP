package Nhanviensiucap;


import java.util.List;

import java.util.Scanner;
import java.lang.String;

/**
 * Chinhsuadanhsach class
 *
 * @author Nhanviensiucap
 */
public class Chinhsuadanhsach {
    public static Scanner scanner = new Scanner(System.in);
    private List<Nhanvien> nhanvienList;
    private LuuNhanvien luuNhanvien;

    /**
     * init LuuNhanvien object and
     * read list student when init Chinhsuadanhsach object
     */
    public Chinhsuadanhsach() {
        luuNhanvien = new LuuNhanvien();
        nhanvienList = luuNhanvien.read();
    }

    /**
     * add nhanvien to nhanvienlist
     */
    public void add() {
        int id = (nhanvienList.size() > 0) ? (nhanvienList.size() + 1) : 1;
        System.out.println("nhanvien id = " + id);
        String name = inputName();
        byte age = inputAge();
        String address = inputAddress();
        int yearofbirth = Integer.parseInt(inputYearofbirth());
        int phonenumber = inputPhonenumber();
        String posision = inputPosision();
        int overtime = inputOvertime();
        int salary = (int) inputSalary();
        Nhanvien nhanvien = new Nhanvien(id, name, age, address,phonenumber,posision, salary,yearofbirth,overtime);
        nhanvienList.add(nhanvien);
        luuNhanvien.write(nhanvienList);
    }


    /**
     * edit nhanvien by id
     *
     * @param id
     */
    public void edit(int id) {
        boolean isExisted = false;
        int size = nhanvienList.size();
        for (int i = 0; i < size; i++) {
            if (nhanvienList.get(i).getId() == id) {
                isExisted = true;
                nhanvienList.get(i).setName(inputName());
                nhanvienList.get(i).setAge(inputAge());
                nhanvienList.get(i).setYearofbirth(Integer.parseInt(inputYearofbirth()));
                nhanvienList.get(i).setAddress(inputAddress());
                nhanvienList.get(i).setPhonenumber(inputPhonenumber());
                nhanvienList.get(i).setPosision(inputPosision());
                nhanvienList.get(i).setOvertime(inputOvertime());
                nhanvienList.get(i).setSalary((int) inputSalary());

                break;
            }
        }
        if (!isExisted) {
            System.out.printf("id = %d not existed.\n", id);
        } else {
            luuNhanvien.write(nhanvienList);
        }
    }

    /**
     * delete nhanvien by id
     *
     * @param id: nhavnvien id
     */
    public void delete(int id) {
        Nhanvien nhanvien = null;
        int size = nhanvienList.size();
        for (int i = 0; i < size; i++) {
            if (nhanvienList.get(i).getId() == id) {
                nhanvien = nhanvienList.get(i);
                break;
            }
        }
        if (nhanvien != null) {
            nhanvienList.remove(nhanvien);
            luuNhanvien.write(nhanvienList);
        } else {
            System.out.printf("id = %d not existed.\n", id);
        }
    }


    public void show() {
        System.out.println(String.format("%5s   %-15s   %5s   %-15s   %-35s   %10s  %-25s   %10s   %15s", "ID",
                "Name", "Age","Date of Birth" ,"Address","Phonenumber","Posision","Overtime","Salary"));
        for (Nhanvien nhanvien : nhanvienList) {
            System.out.println(String.format("%5s | %-15s | %5s | %-15s | %-35s | %010d | %-25s | %10s | %15s", nhanvien.getId(),
                    nhanvien.getName(), nhanvien.getAge(),nhanvien.getYearofbirth(), nhanvien.getAddress(),nhanvien.getPhonenumber(),nhanvien.getPosision(),nhanvien.getOvertime(), nhanvien.getSalary()));
        }
    }

    /**
     * input nhanvien id
     *
     * @return nhanvien id
     */
    public int inputId() {
        System.out.print("Input nhanvien id: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input nhanvien id again: ");
            }
        }
    }

    /**
     * input nhanvien name
     *
     * @return nhanvien name
     */
    private String inputName() {
        System.out.print("Input nhanvien name: ");
        return scanner.nextLine();
    }

    /**
     * input nhanvien address
     *
     * @return nhanvien address
     */
    private String inputAddress() {
        System.out.print("Input nhanvien address: ");
        return scanner.nextLine();
    }
    /**
     * input nhanvien overtime
     *
     * @return nhanvien overtime
     */
    private int inputOvertime() {
        System.out.print("Input nhanvien OverTime: ");
        while (true) {
            try {
                int overtime = Integer.parseInt((scanner.nextLine()));
                if (overtime < 0 && overtime > 100) {
                    throw new NumberFormatException();
                }
                return overtime;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input nhanvien id again: ");
            }
        }
    }
/**
 *
        * input nhanvien phonenumber
     *
             * @return nhanvien phonenumber
     */
    private int inputPhonenumber() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input nhanvien Phone number: ");
        while (true) {
            try {
                String input = sc.nextLine();

                if (input.length() > 12) {
                    throw new NumberFormatException();
                }
                return Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input nhanvien Phone number again: ");
            }

        }
    }
    /**
     * input nhanvien yearofbirth
     *
     * @return nhanvien yearofbirth
     */
    private String inputYearofbirth() {
        System.out.print("Input nhanvien date of birth: ");
        return scanner.nextLine();
    }
    /**
     * input nhanvien age
     *
     * @return nhanvien age
     */
    private byte inputAge() {
        System.out.print("Input nhanvien age: ");
        while (true) {
            try {
                byte age = Byte.parseByte((scanner.nextLine()));
                if (age < 0 && age > 100) {
                    throw new NumberFormatException();
                }
                return age;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input nhanvien id again: ");
            }
        }
    }
    /**
     * input nhanvien posision
     *
     * @return posision
     */

    private String inputPosision() {
        System.out.print("Input nhanvien posision: ");
        return scanner.nextLine();
    }
    /**
     * input nhanvien salary
     *
     * @return salary
     */

    private float inputSalary() {
        System.out.print("Input nhanvien Salary: ");
        while (true) {
            try {
                int salary = Integer.parseInt((scanner.nextLine()));
                if (salary > 0 && salary < 1000000) {
                    throw new NumberFormatException();
                }
                return salary;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input nhanvien salary again: ");
            }
        }
    }

    public String findNhanVien() {
        String tenCanTim = inputName();
        for (int i = 0; i < this.nhanvienList.size(); i++)
            if (this.nhanvienList.get(i).getName().equals(tenCanTim))
                return "Nhan vien can tim la\n" +
                        String.format("%5s   %-15s   %5s   %15s   %-35s   %10s  %-25s   %10s   %15s\n" , "ID",
                                "Name", "Age","Date of Birth", "Address" ,"Phonenumber","Posision", "Salary") + this.nhanvienList.get(i).toString();
        return "Khong co nhan vien";
    }

    // getter && setter
    public List<Nhanvien> getNhanvienList() {
        return nhanvienList;
    }

    public void setNhanvienList(List<Nhanvien> nhanvienList) {
        this.nhanvienList = nhanvienList;
    }
}
