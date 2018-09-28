
import java.sql.*;
import javax.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
/**
 *
 * @author ÖmerTalha
 */
@ManagedBean (name="diyetisyen")
@RequestScoped
public class Diyetisyen {
    
    DataSource dataSource;
    
    public Diyetisyen() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("jdbc/addressbook");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String age;
    private String location;
    private String url;
    private int price;
    public int diyetisyen_id[]={601,602,603,604,605,606,607,608};
    public int diyetisyen_idsi=0;
    public int zero=0;

    public int getDiyetisyen_idsi() {
        return diyetisyen_idsi;
    }

    public void setDiyetisyen_idsi(int diyetisyen_idsi) {
        this.diyetisyen_idsi = diyetisyen_idsi;
    }
    
    
    public int[] getDiyetisyen_id() {
        return diyetisyen_id;
    }

    public void setDiyetisyen_id(int[] diyetisyen_id) {
        this.diyetisyen_id = diyetisyen_id;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    public ResultSet getDiyetisyen() throws SQLException{
       if ( dataSource == null )
            throw new SQLException( "Unable to obtain DataSource" );
       
       Connection connection = dataSource.getConnection();
       
       if ( connection == null )
            throw new SQLException( "Unable to connect to DataSource" );
       
       try{
           PreparedStatement pre=connection.prepareStatement("SELECT * FROM DIYETISYEN ORDER BY PRICE DESC");
           CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
           resultSet1.populate(pre.executeQuery());
           return resultSet1;
       }
       
       finally{
           connection.close();
       }  
    }
    
        public ResultSet getDiyetisyenListesi() throws SQLException{
       if ( dataSource == null )
            throw new SQLException( "Unable to obtain DataSource" );
       
       Connection connection = dataSource.getConnection();
       
       if ( connection == null )
            throw new SQLException( "Unable to connect to DataSource" );
       
       try{
           PreparedStatement pre=connection.prepareStatement("SELECT DIYETISYEN.FIRSTNAME, DIYETISYEN.LASTNAME, DIYETISYEN.PRICE FROM DIYETISYEN ORDER BY PRICE DESC");
           CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
           resultSet1.populate(pre.executeQuery());
           return resultSet1;
       }
       
       finally{
           connection.close();
       }
    }
      
    public void diyet() throws SQLException{
     if ( dataSource == null )
       throw new SQLException( "Unable to obtain DataSource" );

       Connection connection = dataSource.getConnection();

       if ( connection == null )
       throw new SQLException( "Unable to connect to DataSource" );

       try{
       PreparedStatement pre = connection.prepareStatement("UPDATE KULLANICI SET DIYETISYENID="+diyetisyen_idsi+" WHERE DIYETISYENID="+zero+" ");
       pre.executeUpdate();

       }
       finally{
       connection.close();
       }

 }
        
}
