
public class Urunler {
     private String urun_id;
     private String urun_adi;
     private String hammaddeleri;
     private String miktarlari;
     private String tarih;
     private String raf_omru;
     private String iscilik_maliyeti; 
     private String toplam_maliyeti;
     private String satis_fiyati;

    public Urunler(String urun_id, String urun_adi, String hammaddeleri, String miktarlari, String tarih, String raf_omru, String iscilik_maliyeti, String toplam_maliyeti, String satis_fiyati) {
        this.urun_id = urun_id;
        this.urun_adi = urun_adi;
        this.hammaddeleri = hammaddeleri;
        this.miktarlari = miktarlari;
        this.tarih = tarih;
        this.raf_omru = raf_omru;
        this.iscilik_maliyeti = iscilik_maliyeti;
        this.toplam_maliyeti = toplam_maliyeti;
        this.satis_fiyati = satis_fiyati;
    }

    public String getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(String urun_id) {
        this.urun_id = urun_id;
    }

    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public String getHammaddeleri() {
        return hammaddeleri;
    }

    public void setHammaddeleri(String hammaddeleri) {
        this.hammaddeleri = hammaddeleri;
    }

    public String getMiktarlari() {
        return miktarlari;
    }

    public void setMiktarlari(String miktarlari) {
        this.miktarlari = miktarlari;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getRaf_omru() {
        return raf_omru;
    }

    public void setRaf_omru(String raf_omru) {
        this.raf_omru = raf_omru;
    }

    public String getIscilik_maliyeti() {
        return iscilik_maliyeti;
    }

    public void setIscilik_maliyeti(String iscilik_maliyeti) {
        this.iscilik_maliyeti = iscilik_maliyeti;
    }

    public String getToplam_maliyeti() {
        return toplam_maliyeti;
    }

    public void setToplam_maliyeti(String toplam_maliyeti) {
        this.toplam_maliyeti = toplam_maliyeti;
    }

    public String getSatis_fiyati() {
        return satis_fiyati;
    }

    public void setSatis_fiyati(String satis_fiyati) {
        this.satis_fiyati = satis_fiyati;
    }
     
     
     
}
