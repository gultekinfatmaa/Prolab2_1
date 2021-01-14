
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class hammaddeIslemleri {
        private Connection con=null;
     private Statement statement=null;
     private PreparedStatement preparedStatement=null;
     
       public ArrayList<hammaddeler> hammaddeleriGetir(){
       ArrayList<hammaddeler> ciktii=new ArrayList<>();
          try {
              statement=con.createStatement();
              String sorgu="select  *from hammaddeler";
             
          
              ResultSet rs=statement.executeQuery(sorgu);
              while(rs.next()){
                  
                  
                  String hammadde_ismi=rs.getString("hammadde_ismi");
                  String hammadde_adet=rs.getString("hammadde_adet");
              
            ciktii.add(new hammaddeler(hammadde_ismi,hammadde_adet));
              }
              return ciktii;
              
          } catch (SQLException ex) {
              Logger.getLogger(hammaddeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
              return null;
             
          }
       
     }
       
       
       
         public void hammaddeEkle(String hammadde_ismi,int hammadde_adet){
         String sorgu="insert into hammaddeler(hammadde_ismi,hammadde_adet) values(?,?) ";
       
          try {
              preparedStatement=con.prepareStatement(sorgu);
              preparedStatement.setString(1,hammadde_ismi);
              preparedStatement.setInt(2,hammadde_adet);
             
              preparedStatement.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(hammaddeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
          }
         
     }
         
         public void adetEkle(){
             
      ArrayList<hammaddeler> ciktii=new ArrayList<>();
          String sorguu="SELECT hammadde_ismi, SUM(hammadde_adet) FROM `hammaddeler` GROUP BY hammadde_ismi";
       
          
         
         
     }
       
        public void guncelle(String hammadde_ismi,int hammadde_adeti){
         String sorgue="select * from hammaddeler";
       //select hammadde_ismi,SUM(hammadde_adet) as hammadde_adet from hammaddeler group by hammadde_ismi
          try {
              preparedStatement=con.prepareStatement(sorgue);
              
               preparedStatement.setString(1,hammadde_ismi);
               
               
              preparedStatement.setInt(2,hammadde_adeti);
            
              preparedStatement.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(hammaddeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
          }
         
     }
       
        public hammaddeIslemleri(){
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
