package project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Checking {
    private String []ch;
    private short ngay;    
    private short thang;
    private short nam;
  
    Checking(){
    }
    Checking(String []ch , short ngay, short thang, short nam){
        this.ch = ch;
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }
    
    public boolean checkNull(String str){
        return str == null || "".equals(str);
    }
    
    // A=65 Z=90 a=97 z=122 
    public boolean checkTextString(String str){
        char []ck = str.toCharArray();
        for (int k = 0; k<ck.length; k++){
            if (ck[k] == 32)
                continue;
            if ( ck[k]<65 || ck[k]>122 )
                return false;
            else{
                if(ck[k]>90 && ck[k]<97)
                    return false;
            }
        }
        return true;
    }
    
    public boolean checkDateFormat(String d){
        ch = d.split("/");
        if (ch.length !=3 )
            return false; 
        if (ch[0].length() < 2 || ch[1].length() < 2 || ch[2].length() != 4)
            return false;
        ngay = Short.parseShort(ch[0]);
        thang = Short.parseShort(ch[1]);
        nam = Short.parseShort(ch[2]);
        if (ngay <= 0 || ngay > 31 || thang <= 0 || thang > 12 || nam <= 0)
            return false;
        switch (thang) {
            case 2:{
                if (nam % 4 == 0){
                    if(ngay > 29)
                        return false;
                }
                else if(nam % 4 != 0){
                    if( ngay >28 )
                        return false;
                }   
            }       break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(ngay > 30)
                    return false;
                break;
            default:
                if (ngay > 31)
                    return false;
                break;
        }
        return true;
        
    }
    public boolean checkMonthYear(String month){
        ch = month.split("/");
        if (ch.length !=2 )
            return false; 
        if (ch[0].length() < 2 || ch[1].length() < 4)
            return false;
        thang = Short.parseShort(ch[0]);
        nam = Short.parseShort(ch[1]);
        if(thang < 1 || thang > 12 || nam <= 0)
            return false;
        return true;
    }
    public boolean checkNumString(String str){
        char []ck = str.toCharArray();
        int length = ck.length;
        for(int i=0; i<length; i++){
            if(ck[i] < '0' || ck[i] > '9'){
                return false;
            }
        }
        return true;
    }
    public boolean checkPhoneNum(String phone){
        char []c = phone.toCharArray();
        if(c[0] != '0'){
            return false;
        }
        else{
            if(c.length == 10 || c.length == 11){
                return checkNumString(phone);
            }
            else{
                return false;
            }
        }
    }

    public int checkEXP(String exp){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.parse(exp, formatter);
        return date.compareTo(today);
    }
    
    public int checkNgayNhapPhieu(String ngaynhap){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.parse(ngaynhap, formatter);
        return date.compareTo(today);
    }
}