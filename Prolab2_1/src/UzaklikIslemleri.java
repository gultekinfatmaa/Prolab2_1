
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class UzaklikIslemleri {
     private Connection con=null;
     private Statement statement=null;
     private PreparedStatement preparedStatement=null;
     
       public ArrayList<Uzaklik> uzakliklariGetir(){
       ArrayList<Uzaklik> ciktii=new ArrayList<>();
          try {
              statement=con.createStatement();
              String sorgu="select * from uzaklik";
             // int sorgu="select * from tedarikci where Miktarlari,Raf_omru,Satis_fiyati";
              
          
              ResultSet rs=statement.executeQuery(sorgu);
              while(rs.next()){
                  
                  
                  String sehir=rs.getString("sehir");
                  String kocaeli=rs.getString("kocaeli");
                 
                          
                         
                         
                       
            ciktii.add(new Uzaklik(sehir,kocaeli));
            
              }
              return ciktii;
              
          } catch (SQLException ex) {
              Logger.getLogger(UzaklikIslemleri.class.getName()).log(Level.SEVERE, null, ex);
              return null;
              //null demezsek hata veriyor
          }
       
     }
       
         
       
         public void uzaklikEkle(String sehir,int kocaeli){
     
         String sorgu="insert into uzaklik(sehir,kocaeli) values(?,?)";
         
          try {
              preparedStatement=con.prepareStatement(sorgu);
              preparedStatement.setString(1, sehir);
              preparedStatement.setInt(2, kocaeli);
             
              
              
              preparedStatement.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(UzaklikIslemleri.class.getName()).log(Level.SEVERE, null, ex);
          }
         
     }
       
       
          public UzaklikIslemleri(){
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
