
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MusteriIslemleri {
  
        private Connection con=null;
     private Statement statement=null;
     private PreparedStatement preparedStatement=null;
     
       public ArrayList<Musteriler> musterileriGetir(){
       ArrayList<Musteriler> ciktii=new ArrayList<>();
          try {
              statement=con.createStatement();
              String sorgu="select * from musteriler";
             
          
              ResultSet rs=statement.executeQuery(sorgu);
              while(rs.next()){
                  
                  
                  String musteri_id=rs.getString("musteri_id");
                  String musteri_adi=rs.getString("musteri_adi");
                  String adres=rs.getString("adres");
                  String talep_urun_id=rs.getString("talep_urun_id");
                  String adet=rs.getString("adet");
        
                      
  
                             
                 
            ciktii.add(new Musteriler(musteri_id,musteri_adi,adres,talep_urun_id,adet));
              }
              return ciktii;
              
          } catch (SQLException ex) {
              Logger.getLogger(MusteriIslemleri.class.getName()).log(Level.SEVERE, null, ex);
              return null;
             
          }
       
     }
       
       
       
         public void musteriEkle(String musteri_id,String musteri_adi,String adres,String talep_urun_id,int adet){
         String sorgu="insert into musteriler(musteri_id,musteri_adi,adres,talep_urun_id,adet) values(?,?,?,?,?)";
       
          try {
              preparedStatement=con.prepareStatement(sorgu);
              preparedStatement.setString(1, musteri_id);
              preparedStatement.setString(2, musteri_adi);
              preparedStatement.setString(3, adres);
              preparedStatement.setString(4, talep_urun_id);
              preparedStatement.setInt(5, adet);
              preparedStatement.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(MusteriIslemleri.class.getName()).log(Level.SEVERE, null, ex);
          }
         
     }
       
       
          public MusteriIslemleri(){
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
