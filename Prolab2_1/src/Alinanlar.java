
public class Alinanlar {
   private String firma_ismi;
   private String urun_ismi;
   private String istenen_aded;
   private String stok;
   private String toplam_fiyat;

    public Alinanlar(String firma_ismi, String urun_ismi, String istenen_aded, String stok, String toplam_fiyat) {
        this.firma_ismi = firma_ismi;
        this.urun_ismi = urun_ismi;
        this.istenen_aded = istenen_aded;
        this.stok = stok;
        this.toplam_fiyat = toplam_fiyat;
    }

    public String getFirma_ismi() {
        return firma_ismi;
    }

    public void setFirma_ismi(String firma_ismi) {
        this.firma_ismi = firma_ismi;
    }

    public String getUrun_ismi() {
        return urun_ismi;
    }

    public void setUrun_ismi(String urun_ismi) {
        this.urun_ismi = urun_ismi;
    }

    public String getIstenen_aded() {
        return istenen_aded;
    }

    public void setIstenen_aded(String istenen_aded) {
        this.istenen_aded = istenen_aded;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public String getToplam_fiyat() {
        return toplam_fiyat;
    }

    public void setToplam_fiyat(String toplam_fiyat) {
        this.toplam_fiyat = toplam_fiyat;
    }
   
}
