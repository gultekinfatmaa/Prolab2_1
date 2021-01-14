
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
     public static final String kullanıcı_adı="root";
     public static final String parola="";
     public static final String db_ismi="proje";
     public static final String host="localhost";
     public static final int port=3306;
     private Connection con=null;
     private Statement statement=null; 
     /*
     public Database(){
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
     public static void main(String[] args) {
        Database data=new Database();
    }*/
}
