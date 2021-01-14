
public class Musteriler {
    private String musteri_id;
    private String musteri_adi;
    private String adres;
    private String talep_urun_id;
    private String adet;

    public Musteriler(String musteri_id, String musteri_adi, String adres, String talep_urun_id, String adet) {
        this.musteri_id = musteri_id;
        this.musteri_adi = musteri_adi;
        this.adres = adres;
        this.talep_urun_id = talep_urun_id;
        this.adet = adet;
    }

    public String getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(String musteri_id) {
        this.musteri_id = musteri_id;
    }

    public String getMusteri_adi() {
        return musteri_adi;
    }

    public void setMusteri_adi(String musteri_adi) {
        this.musteri_adi = musteri_adi;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTalep_urun_id() {
        return talep_urun_id;
    }

    public void setTalep_urun_id(String talep_urun_id) {
        this.talep_urun_id = talep_urun_id;
    }

    public String getAdet() {
        return adet;
    }

    public void setAdet(String adet) {
        this.adet = adet;
    }
    
    
    
}
