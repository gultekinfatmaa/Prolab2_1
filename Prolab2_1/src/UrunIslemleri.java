
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UrunIslemleri {
     private Connection con=null;
     private Statement statement=null;
     private PreparedStatement preparedStatement=null;
     
       public ArrayList<Urunler> urunleriGetir(){
       ArrayList<Urunler> ciktii=new ArrayList<>();
          try {
              statement=con.createStatement();
              String sorgu="select * from urunler";
             
          
              ResultSet rs=statement.executeQuery(sorgu);
              while(rs.next()){
                  
                  
                  String urun_id=rs.getString("urun_id");
                  String urun_adi=rs.getString("urun_adi");
                  String hammaddeleri=rs.getString("hammaddeleri");
                  String miktarlari=rs.getString("miktarlari");
                  String tarih=rs.getString("tarih");
                  String raf_omru=rs.getString("raf_omru");
                  String iscilik_maliyeti=rs.getString("iscilik_maliyeti");
                  String toplam_maliyeti=rs.getString("toplam_maliyeti");
                  String satis_fiyati=rs.getString("satis_fiyati");
                      
  
                             
                 
            ciktii.add(new Urunler(urun_id,urun_adi,hammaddeleri,miktarlari,tarih,raf_omru,iscilik_maliyeti,toplam_maliyeti,satis_fiyati));
              }
              return ciktii;
              
          } catch (SQLException ex) {
              Logger.getLogger(UrunIslemleri.class.getName()).log(Level.SEVERE, null, ex);
              return null;
             
          }
       
     }
       
       
       
         public void urunEkle(String urun_id,String urun_adi,String hammaddeleri,int miktarlari,String tarih,int raf_omru,int iscilik_maliyeti,int toplam_maliyeti,int satis_fiyati){
         String sorgu="insert into urunler(urun_id,urun_adi,hammaddeleri,miktarlari,tarih,raf_omru,iscilik_maliyeti,toplam_maliyeti,satis_fiyati) values(?,?,?,?,?,?,?,?,?)";
       
          try {
              preparedStatement=con.prepareStatement(sorgu);
              preparedStatement.setString(1, urun_id);
              preparedStatement.setString(2, urun_adi);
              preparedStatement.setString(3, hammaddeleri);
              preparedStatement.setInt(4, miktarlari);
              preparedStatement.setString(5, tarih);
              preparedStatement.setInt(6, raf_omru);
              preparedStatement.setInt(7, iscilik_maliyeti);
             preparedStatement.setInt(8, toplam_maliyeti);
              preparedStatement.setInt(9, satis_fiyati);
              
              
              preparedStatement.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(UrunIslemleri.class.getName()).log(Level.SEVERE, null, ex);
          }
         
     }
       
       
          public UrunIslemleri(){
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
