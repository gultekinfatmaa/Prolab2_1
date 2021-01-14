
public class Tedarikci_Firma {
    private String firma_id;
    private String firma_adi;
     private String ulke;
     private String sehir_merkezi;
     private String uretilen;
     private String miktarlari;
     private String uretim_tarihi;
     private String raf_omru;
     private String satis_fiyati;

    public Tedarikci_Firma(String firma_id, String firma_adi, String ulke, String sehir_merkezi, String uretilen, String miktarlari, String uretim_tarihi, String raf_omru, String satis_fiyati) {
        this.firma_id = firma_id;
        this.firma_adi = firma_adi;
        this.ulke = ulke;
        this.sehir_merkezi = sehir_merkezi;
        this.uretilen = uretilen;
        this.miktarlari = miktarlari;
        this.uretim_tarihi = uretim_tarihi;
        this.raf_omru = raf_omru;
        this.satis_fiyati = satis_fiyati;
    }

     

    public String getFirma_id() {
        return firma_id;
    }

    public void setFirma_id(String firma_id) {
        this.firma_id = firma_id;
    }

    public String getFirma_adi() {
        return firma_adi;
    }

    public void setFirma_adi(String firma_adi) {
        this.firma_adi = firma_adi;
    }

    public String getUlke() {
        return ulke;
    }

    public void setUlke(String ulke) {
        this.ulke = ulke;
    }

    public String getSehir_merkezi() {
        return sehir_merkezi;
    }

    public void setSehir_merkezi(String sehir_merkezi) {
        this.sehir_merkezi = sehir_merkezi;
    }

    public String getUretilen() {
        return uretilen;
    }

    public void setUretilen(String uretilen) {
        this.uretilen = uretilen;
    }

    public String getMiktarlari() {
        return miktarlari;
    }

    public void setMiktarlari(String miktarlari) {
        this.miktarlari = miktarlari;
    }

 

    public String getUretim_tarihi() {
        return uretim_tarihi;
    }

    public void setUretim_tarihi(String uretim_tarihi) {
        this.uretim_tarihi = uretim_tarihi;
    }

    public String getRaf_omru() {
        return raf_omru;
    }

    public void setRaf_omru(String raf_omru) {
        this.raf_omru = raf_omru;
    }

    public String getSatis_fiyati() {
        return satis_fiyati;
    }

    public void setSatis_fiyati(String satis_fiyati) {
        this.satis_fiyati = satis_fiyati;
    }

  

  
   

    
     
}
