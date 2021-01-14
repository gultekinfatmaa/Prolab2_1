
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TedarikciIslemleri {
     private Connection con=null;
     private Statement statement=null;
     private PreparedStatement preparedStatement=null;
     
       public ArrayList<Tedarikci_Firma> tedarikcileriGetir(){
       ArrayList<Tedarikci_Firma> ciktii=new ArrayList<>();
          try {
              statement=con.createStatement();
              String sorgu="select distinct * from tedarikciler";
             // int sorgu="select * from tedarikci where Miktarlari,Raf_omru,Satis_fiyati";
              
          
              ResultSet rs=statement.executeQuery(sorgu);
              while(rs.next()){
                  
                  
                  String firma_id=rs.getString("Firma_id");
                  String firma_adi=rs.getString("Firma_adi");
                  String ulke=rs.getString("Ulke");
                  String sehir_merkezi=rs.getString("SehirMerkezi");
                  String uretilen=rs.getString("Uretilen");
                  String miktarlari=rs.getString("Miktarlari");
                  String uretim_tarihi=rs.getString("Uretim_tarihi");
                  String raf_omru=rs.getString("Raf_omru");
                  String satis_fiyati=rs.getString("Satis_fiyati");
                      
  
                             
                       /*   int miktarlari=rs.getInt("Miktarlari");
                       String uretim_tarihi=rs.getString("Uretim_tarihi");
                       int raf_omru=rs.getInt("Raf_omru");
                       int satis_fiyati=rs.getInt("Satis_fiyati"); */
            ciktii.add(new Tedarikci_Firma(firma_id,firma_adi,ulke,sehir_merkezi,uretilen,miktarlari,uretim_tarihi,raf_omru,satis_fiyati));
              }
              return ciktii;
              
          } catch (SQLException ex) {
              Logger.getLogger(TedarikciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
              return null;
              //null demezsek hata veriyor
          }
       
     }
      
         public boolean girisYap(String username,String password){
         String sorguu="select * from adminler where username=? and password=? ";
          try {
              preparedStatement=con.prepareStatement(sorguu);
              preparedStatement.setString(1,username);
              preparedStatement.setString(2,password);
              
              ResultSet rs= preparedStatement.executeQuery();
              if(rs.next() == false){
                  return false;
                  
              }
              else{
                  return true;
              }
          } catch (SQLException ex) {
              Logger.getLogger(TedarikciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
                       return false;

          }
         
         
     }
       
         public void tedarikciEkle(String Firma_id,String Firma_adi,String Ulke,String SehirMerkezi,String Uretilen,int Miktarlari,String Uretim_tarihi,int Raf_omru,int Satis_fiyati){
                          
       //String Miktarlari = String.valueOf(Miktarlarii);
         // String Raf_omru = String.valueOf(Raf_omruu);
          //  String Satis_fiyati = String.valueOf(Satis_fiyatii);
         String sorgu="insert into tedarikciler(Firma_id,Firma_adi,Ulke,SehirMerkezi,Uretilen,Miktarlari,Uretim_tarihi,Raf_omru,Satis_fiyati) values(?,?,?,?,?,?,?,?,?)";
         //  String sorgu="insert into tedarikci(Firma_id,Firma_adi,Ulke,SehirMerkezi,Uretilen,Miktarlari,Uretim_tarihi,Raf_omru,Satis_fiyat
          try {
              preparedStatement=con.prepareStatement(sorgu);
              preparedStatement.setString(1, Firma_id);
              preparedStatement.setString(2, Firma_adi);
              preparedStatement.setString(3, Ulke);
              preparedStatement.setString(4, SehirMerkezi);
              preparedStatement.setString(5, Uretilen);
              preparedStatement.setInt(6, Miktarlari);
              preparedStatement.setString(7, Uretim_tarihi);
             preparedStatement.setInt(8, Raf_omru);
              preparedStatement.setInt(9, Satis_fiyati);
              
              
              preparedStatement.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(TedarikciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
          }
         
     }
       /*public void tedarikciEkle2(String Firma_adi,String SehirMerkezi){
                          
       //String Miktarlari = String.valueOf(Miktarlarii);
         // String Raf_omru = String.valueOf(Raf_omruu);
          //  String Satis_fiyati = String.valueOf(Satis_fiyatii);
      String sorgu="insert into firma_sehir(firma_adi,sehri) values(?,?)";
       /*   INSERT INTO Hedef_tablo (alan_adi1,alan_adi2...)
SELECT alan_adi1,alan_adi2...
FROM tablo1*/
         //String sorgu="insert into tedarikciler(Firma_adi,SehirMerkezi) select Firma_adi,SehirMerkezi from firma_sehir";
        //  String sorgu="insert into firma_sehir(firma_adi,sehri) select Firma_adi,SehirMerkezi from tedarikciler";
         //  String sorgu="insert into tedarikci(Firma_id,Firma_adi,Ulke,SehirMerkezi,Uretilen,Miktarlari,Uretim_tarihi,Raf_omru,Satis_fiyat
      /*   try {
              preparedStatement=con.prepareStatement(sorgu);
              preparedStatement.setString(1, Firma_adi);
              preparedStatement.setString(2, SehirMerkezi);
             
              
              preparedStatement.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(TedarikciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
          }
         
     }*/
public void stok_azalt(String Firma_id,String Firma_adi,String Ulke,String SehirMerkezi,String Uretilen,int Miktarlari,String Uretim_tarihi,int Raf_omru,int Satis_fiyati){
  
     String sorgumuz="update tedarikciler set Miktarlari=? where Firma_id=? and Firma_adi=?";

   try {
       
             preparedStatement=con.prepareStatement(sorgumuz);
       
          preparedStatement.setInt(1, Miktarlari);
             preparedStatement.setString(2, Firma_id);
            preparedStatement.setString(3, Firma_adi);
           
                 
              preparedStatement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(TedarikciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
         }
         
}


public void guncelle(int Raf_omruu){
  
     String sorg="delete from tedarikciler where Raf_omru=?";

   try {
       
             preparedStatement=con.prepareStatement(sorg);
       
          preparedStatement.setInt(1,Raf_omruu);
             
           
                 
              preparedStatement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(TedarikciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
         }
         
}
public void tedarikciEkle3(String firma_adi,String sehri){
                          
       //String Miktarlari = String.valueOf(Miktarlarii);
         // String Raf_omru = String.valueOf(Raf_omruu);
          //  String Satis_fiyati = String.valueOf(Satis_fiyatii);
      String sorgu="insert into firma_sehir(firma_adi,sehri) values(?,?)";
      
          try {
              preparedStatement=con.prepareStatement(sorgu);
              preparedStatement.setString(1, firma_adi);
              preparedStatement.setString(2, sehri);
             
              
              preparedStatement.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(TedarikciIslemleri.class.getName()).log(Level.SEVERE, null, ex);
          }
         
     }
          public TedarikciIslemleri(){
       String url="jdbc:mysql://"+ Database.host +":"+ Database.port +"/"+Database.db_ismi+"?useUnicode=true&characterEncoding=utf8";  //? koymanın nedeni türkçe karakter kabulu java da    
     try {
      Class.forName("com.mysql.jdbc.Driver");
      
     }  catch (ClassNotFoundException ex) {
            System.out.println("Driver bulunamadı");
            
        }
        try {
            con=DriverManager.getConnection(url, Database.kullanıcı_adı, Database.parola);
            System.out.println("Bağlantı başarılı..");
        } catch (SQLException ex) {
            System.out.println("Bağlantı başarısız..");
        } 
     }
       
       
}
