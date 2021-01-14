
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class enUcuz {
     private Connection con=null;
     private Statement statement=null;
     private PreparedStatement preparedStatement=null;
     
        public ArrayList<Alinanlar> alinanlariGetir(){
       ArrayList<Alinanlar> ciktii=new ArrayList<>();
          try {
              statement=con.createStatement();
              String sorgu="select  *from satin_alim";
             ResultSet rs=statement.executeQuery(sorgu);
              while(rs.next()){
                  
                  String firma_adi=rs.getString("Firma_ismi");
                  String urun=rs.getString("Uretilen");
                  String adet=rs.getString("Adett");
                  String stok=rs.getString("Stok");
                  String toplam_fiyat=rs.getString("toplam_fiyatt");
                  
                      
            ciktii.add(new Alinanlar(firma_adi,urun,adet,stok,toplam_fiyat));
              }
              return ciktii;
              
          } catch (SQLException ex) {
              Logger.getLogger(enUcuz.class.getName()).log(Level.SEVERE, null, ex);
              return null;
              //null demezsek hata veriyor
          }
       
     }
       
         
       public void alimEkle(String firma_adi,String urun,int adet,int stok,int toplam_fiyat){
           String sorgu="insert into satin_alim(Firma_ismi,Uretilen,Adett,Stok,toplam_fiyatt) values(?,?,?,?,?)";
         //  String sorgu="insert into tedarikci(Firma_id,Firma_adi,Ulke,SehirMerkezi,Uretilen,Miktarlari,Uretim_tarihi,Raf_omru,Satis_fiyat
          try {
              preparedStatement=con.prepareStatement(sorgu);
              
              preparedStatement.setString(1, firma_adi);
              preparedStatement.setString(2, urun);
              preparedStatement.setInt(3, adet);
              preparedStatement.setInt(4, stok);
              preparedStatement.setInt(5, toplam_fiyat);
              
              
              preparedStatement.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(enUcuz.class.getName()).log(Level.SEVERE, null, ex);
          }
       }
       
       
          public enUcuz(){
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
