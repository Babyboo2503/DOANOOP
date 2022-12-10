package OOP;


import java.text.DecimalFormat;
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
        byte age = inputAge();String address = inputAddress();
        String email = inputEmail();
        String phonenumber = String.valueOf(inputPhonenumber());
        String posision = inputPosision();
        int overtime = inputOvertime();
        int salary = (int) inputSalary();
        Nhanvien nhanvien = new Nhanvien(id, name, age, address, phonenumber, posision, salary, email, overtime);
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
                nhanvienList.get(i).setEmail(String.valueOf(inputEmail()));
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
        DecimalFormat fm = new DecimalFormat("###,###,###VND");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("%5s   %-15s   %5s   %-25s   %-35s   %10s  %-25s   %10s   %15s", "ID",
                "Name", "Age", "Email", "Address", "Phonenumber", "Posision", "Overtime", "Salary"));
        for (Nhanvien nhanvien : nhanvienList) {
            System.out.println(String.format("%5s | %-15s | %5s | %-25s | %-35s | %10s | %-25s | %10s | %15s", nhanvien.getId(),
                    nhanvien.getName(), nhanvien.getAge(), nhanvien.getEmail(), nhanvien.getAddress(), nhanvien.getPhonenumber(), nhanvien.getPosision(), nhanvien.getOvertime(), fm.format(nhanvien.getSalary())));
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
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
        boolean ok = true;
        String name = "";
        do {
            System.out.print("Input nhanvien name: ");
            name = scanner.nextLine();
            ok = true;
            for (char c : name.toCharArray())
                if (c <= 57 && c >= 48) {
                    ok = false;
                    System.out.print("invalid! ");
                    break;
                }
        } while (!ok);
        return name;
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
                System.out.print("invalid! Input nhanvien Overtime again: ");
            }
        }
    }

    /**
     * input nhanvien phonenumber
     *
     * @return nhanvien phonenumber
     */
    private String inputPhonenumber() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input nhanvien Phone number: ");
        while (true) {
            try {
                String input = sc.nextLine();

                if (input.length() > 12 && input.length()<9) {
                    throw new NumberFormatException();
                }
                return input;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input nhanvien Phone number again: ");
            }

        }
    }

    /**
     * input nhanvien email
     *
     * @return nhanvien email
     */
    private String inputEmail() {
        String email = "";
        System.out.print("Input nhanvien Email: ");
        email = scanner.nextLine();
        boolean fullStop = false, atSign = false;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == 64) { // 64 = at sign
                if (atSign != true)
                    atSign = true;
                else break;
            } else if (email.charAt(i) == 46) { //46 = full stop
                if (atSign == true && email.charAt(i - 1) != 64)
                    fullStop = true;
                else break;
            }
        }
        if (fullStop == true && atSign == true && email.charAt(email.length() - 1) != 46)
            return email;
        else {
            System.out.print("Invalid! ");
            return inputEmail();
        }
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
                if (age > 0 && age < 18) {
                    throw new NumberFormatException();
                }
                return age;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input nhanvien age again: ");
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
        for (int i = 0; i < this.nhanvienList.size(); i++){
            String name = nhanvienList.get(i).getName().toLowerCase();
            if (name.equals(tenCanTim)){
                return "Nhan vien can tim la\n" +
                        String.format("%5s   %-15s   %5s   %-25s   %-35s   %10s  %-25s   %10s   %15s\n", "ID",
                                "Name", "Age", "Email", "Address", "Phonenumber", "Posision", "Overtime", "Salary") + this.nhanvienList.get(i).toString();
            }
        }
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