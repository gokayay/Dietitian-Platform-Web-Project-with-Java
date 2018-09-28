/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.lang.Integer.parseInt;
import java.text.DecimalFormat;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Gokay
 */

@ManagedBean (name="kitleindeksi")
@RequestScoped

public class KitleIndeksi {

    
  private String kilo;
  private String boy;
  private String sonuc;
  public double kilodouble;
  public double boydouble;
  public double h3;
  public double h2;
  
    public String getKilo() {
        return kilo;
    }

    public void setKilo(String kilo) {
        this.kilo = kilo;
    }

    public String getBoy() {
        return boy;
    }

    public void setBoy(String boy) {
        this.boy = boy;
    }

    public String getSonuc() {
        return sonuc;
    }

    public void setSonuc(String sonuc) {
        this.sonuc = sonuc;
    }


     public void hesapla(){
      
         
         boydouble=Double.parseDouble(boy);
         kilodouble=Double.parseDouble(kilo);
        
         h2=boydouble*boydouble;
         h3=kilodouble/h2;
  
          if(h3<18.5){
    sonuc="\tVücut kitle indeksinize göre durumunuz:Zayıf";
    } 
          else if(h3>=18.5&&h3<=24.9) {
    sonuc="\tVücut kitle indeksinize göre durumunuz:Normal";
    } 
          else if(h3>24.9&&h3<=29.9) {
    sonuc="\tVücut kitle indeksinize göre durumunuz:Kilolu";
    } 
          else if(h3>29.9&&h3<=34.9) {
    sonuc="\tVücut kitle indeksinize göre durumunuz:1.Derece obez";
    } 
          else if(h3>34.9&&h3<=39.9) {
    sonuc="\tVücut kitle indeksinize göre durumunuz:2.Derece obez)";
    } 
          else if(h3>39.9) {
    sonuc="\tVücut kitle indeksinize göre durumunuz:3.Derece obez";
    } 
          else {
   sonuc="\tHata oluştu";
    }
          
          DecimalFormat df = new DecimalFormat("#.##");
          String ah3=df.format(h3);
          
          

        sonuc="Vücut kitle indeksiniz\t\t"+ah3+"\t"+sonuc;   
    }
  
  
  
  
  
  
  
  
}


