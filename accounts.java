package Nhanviensiucap;

import taikhoan.Account;

import java.io.Serializable;
import java.util.ArrayList;

public class accounts implements Serializable {
    public ArrayList<account> accounts = new ArrayList();

    public ArrayList<account> getAccounts() {
        return this.accounts;
    }

    public void setaccounts(ArrayList<account> accounts) {
        this.accounts = accounts;
    }

    public accounts() {
        account nv1 = new account("vyle1603", "123456");
        this.accounts.add(nv1);
        account nv2 = new account("Nganleu", "1234567");
        this.accounts.add(nv2);
        account nv3 = new account("Namlord", "147258");
        this.accounts.add(nv3);
        account nv4 = new account("Sangdb","258369");
        this.accounts.add(nv4);
        account nv5 = new account("Phatnotfat","2583690");
        this.accounts.add(nv5);
    }
}