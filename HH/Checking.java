package project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Checking {
    private String []ch;
    private short ngay;    
    private short thang;
    private short nam;
  
    public Checking(){
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
        else{
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
        }
        return true;
        
    }
    
    public int checkEXP(String exp){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.parse(exp, formatter);
        return date.compareTo(today);
    }    
    
}