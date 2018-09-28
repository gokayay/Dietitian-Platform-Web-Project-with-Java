/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Gokay
 */

@ManagedBean (name="kalori")
@RequestScoped

public class KaloriIhtiyaci {

  private String cinsiyet;
  private String yas;     
  private String kilo;
  private String boy;
  private String sonuc;
  public double kilodouble;
  public double boydouble;
  public double yasdouble;
  public double h3;
  public double h2;

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }
  
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
      
         yasdouble=Double.parseDouble(yas);
         boydouble=Double.parseDouble(boy);
         kilodouble=Double.parseDouble(kilo);
        
        if("1".equals(cinsiyet)){
        
        h3=66.0+(13.7*kilodouble)+(5*boydouble)-(6.8*yasdouble);
        
        }
        else
        {
         h3=65.5+(9.6*kilodouble)+(3.7*boydouble)-(4.7*yasdouble);
            
        }

         

        sonuc="Günlük almanız gereken kalori miktarı:\t"+Double.toString(h3);   
    }
  
    
    
}
