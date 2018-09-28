

import java.sql.*;
import javax.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;


@ManagedBean (name="bean")
@RequestScoped

public class NewJSFManagedBean {
    private    String firstName;
    private    String lastName;
    private    String email;
    private    String phone;
    private    String password;
    private    String height;
    private    String age;
    private    String weight;
    private    String tur;
    public     int min ;
    public     int max  ;
    public int zero;

    public int getZero() {
        return zero;
    }

    public void setZero(int zero) {
        this.zero = zero;
    }
    
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }
    
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
    
    
    
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
     


     public String[] getDeneme() {
		return new String[]{"yıl","1950","1951","1952","1953","1954","1955","1956","1957","1958","1959",
                                    "1960","1961","1962","1963","1964","1965","1966","1967","1968","1969",
                                    "1960","1961","1962","1963","1964","1965","1966","1967","1968","1969",
                                    "1970","1971","1972","1973","1974","1975","1976","1977","1978","1979",
                                    "1980","1981","1982","1983","1984","1985","1986","1987","1988","1989",                             
                                    "1990","1991","1992","1993","1994","1995","1996","1997","1998","1999",
                                    "2000","2001","2002","2003","2004","2005","2006","2007","2008","2009",
                                    "2010","2011","2011","2012","2013","2014","2015","2016","2017","2018"};
                
                }
    
    
    

	public String[] getPreparedYears() {
		return new String[]{"m","1.50","1.51","1.52","1.53","1.54","1.55","1.56","1.57","1.58","1.59",
                                    "1.60","1.61","1.62","1.63","1.64","1.65","1.66","1.67","1.68","1.69",
                                    "1.70","1.71","1.72","1.73","1.74","1.75","1.76","1.77","1.78","1.79",
                                    "1.80","1.81","1.82","1.83","1.84","1.85","1.86","1.87","1.88","1.89",
                                    "1.90","1.91","1.92","1.93","1.94","1.95","1.96","1.97","1.98","1.99"};
	}           

    DataSource dataSource;
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   
    public NewJSFManagedBean(){
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("jdbc/addressbook");
        } catch (NamingException e) {
            e.printStackTrace();
        }
   
    }
   
 public String update() throws SQLException{
     if ( dataSource == null )
       throw new SQLException( "Unable to obtain DataSource" );
       
       Connection connection = dataSource.getConnection();
       
       if ( connection == null )
       throw new SQLException( "Unable to connect to DataSource" );
       
       try{
       PreparedStatement pre = connection.prepareStatement("UPDATE KULLANICI SET FIRSTNAME='"+firstName+"', LASTNAME='"+lastName+"' , EMAIL='"+email+"', PASSWORD='"+password+"', PHONE='"+phone+"', AGE='"+age+"', HEIGHT='"+height+"', WEIGHT='"+weight+"' "
               + "WHERE EMAIL ='"+email+"' OR PHONE='"+phone+"'");
       pre.executeUpdate();
           
       return "profilepage";  
       }
       finally{
       connection.close();
       }
       
 }
    
     public String delete() throws SQLException{
     if ( dataSource == null )
       throw new SQLException( "Unable to obtain DataSource" );
       
       Connection connection = dataSource.getConnection();
       
       if ( connection == null )
       throw new SQLException( "Unable to connect to DataSource" );
       
       try{
       PreparedStatement pre = connection.prepareStatement("DELETE FROM KULLANICI WHERE EMAIL ='"+email+"'");
       pre.executeUpdate();
           
        return "signup";  
       }
       finally{
       connection.close();
       }
       
 }
    
    
   public String login() throws SQLException{
       
       if ( dataSource == null )
       throw new SQLException( "Unable to obtain DataSource" );
       
       Connection connection = dataSource.getConnection();
       
       if ( connection == null )
       throw new SQLException( "Unable to connect to DataSource" );
       
       
       
       try {
           PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM KULLANICI WHERE EMAIL='"+email.trim()+"' AND PASSWORD = '"+password.trim()+"'");
           ResultSet resultSet = preparedStatement.executeQuery();
           
           
            if(!email.trim().isEmpty())
                  {
                     if(!password.trim().isEmpty())
                     {
                        if(resultSet.next())
                        {
                            firstName=resultSet.getString("FIRSTNAME");
                            lastName=resultSet.getString("LASTNAME");
                            email=resultSet.getString("EMAIL");
                            password=resultSet.getString("PASSWORD");
                            age=resultSet.getString("AGE");
                            height=resultSet.getString("HEIGHT");
                            weight=resultSet.getString("WEIGHT");
                            phone=resultSet.getString("PHONE");
                            return "profilepage";
                                 
                        }
                        else
                        {
                             return "login";
                        }
                     }
                     else
                     {
                          return "login";
                     }
                  }
                  else
                  {
                      return "login";
                  }
              }

           
           
        finally
 {
 connection.close(); 
 }
    
    
}
   
     public ResultSet getSweetTarif() throws SQLException{
    
    if (dataSource==null) {
        throw new SQLException("Unable to obtain DataSource");
    }
    
    Connection conn = dataSource.getConnection();
    
     if (conn==null) {
        throw new SQLException("Unable to obtain DataSource");
    }    
    //"SELECT "+tur+".NAME , "+tur+".CALORIE FROM "+tur+" WHERE CALORIE BETWEEN "+min+" AND "+max+" "
    try {
        PreparedStatement pre = conn.prepareStatement("SELECT SWEET.NAME , SPEC.INFO FROM SWEET JOIN SPEC ON SWEET.ID=SPEC.ID ");
        CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
        resultSet1.populate(pre.executeQuery());
        return resultSet1;
        
        
    }   
    finally{
        conn.close();
    }

   }
     
    public ResultSet getMaincourseTarif() throws SQLException{
    
    if (dataSource==null) {
        throw new SQLException("Unable to obtain DataSource");
    }
    
    Connection conn = dataSource.getConnection();
    
     if (conn==null) {
        throw new SQLException("Unable to obtain DataSource");
    }    
    //"SELECT "+tur+".NAME , "+tur+".CALORIE FROM "+tur+" WHERE CALORIE BETWEEN "+min+" AND "+max+" "
    try {
        PreparedStatement pre = conn.prepareStatement("SELECT MAINCOURSE.NAME , SPEC.INFO FROM MAINCOURSE JOIN SPEC ON MAINCOURSE.ID=SPEC.ID ");
        CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
        resultSet1.populate(pre.executeQuery());
        return resultSet1;
        
        
    }   
    finally{
        conn.close();
    }

   }
     
   public ResultSet getFruitvegTarif() throws SQLException{
    
    if (dataSource==null) {
        throw new SQLException("Unable to obtain DataSource");
    }
    
    Connection conn = dataSource.getConnection();
    
     if (conn==null) {
        throw new SQLException("Unable to obtain DataSource");
    }    
    //"SELECT "+tur+".NAME , "+tur+".CALORIE FROM "+tur+" WHERE CALORIE BETWEEN "+min+" AND "+max+" "
    try {
        PreparedStatement pre = conn.prepareStatement("SELECT FRUITVEG.NAME , SPEC.INFO FROM FRUITVEG JOIN SPEC ON FRUITVEG.ID=SPEC.ID ");
        CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
        resultSet1.populate(pre.executeQuery());
        return resultSet1;
        
        
    }   
    finally{
        conn.close();
    }

   }
   
   
   
   public ResultSet getSweet() throws SQLException{
    
    if (dataSource==null) {
        throw new SQLException("Unable to obtain DataSource");
    }
    
    Connection conn = dataSource.getConnection();
    
     if (conn==null) {
        throw new SQLException("Unable to obtain DataSource");
    }    
    //"SELECT "+tur+".NAME , "+tur+".CALORIE FROM "+tur+" WHERE CALORIE BETWEEN "+min+" AND "+max+" "
    try {
        PreparedStatement pre = conn.prepareStatement("SELECT "+tur+".NAME , "+tur+".CALORIE , SPEC.INFO FROM "+tur+" JOIN SPEC ON "+tur+".ID=SPEC.ID WHERE "+tur+".CALORIE BETWEEN "+min+" AND "+max+" ");
        CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
        resultSet1.populate(pre.executeQuery());
        return resultSet1;
        
        
    }   
    finally{
        conn.close();
    }

   }
   
   
   
   public ResultSet getSkor() throws SQLException{
    int number = Integer.parseInt(phone);
    String tut ;
    if (dataSource==null) {
        throw new SQLException("Unable to obtain DataSource");
    }
    
    Connection conn = dataSource.getConnection();
    
     if (conn==null) {
        throw new SQLException("Unable to obtain DataSource");
    }    
    //"SELECT * FROM USERS INNER JOIN DIET_CHA ON USERS.ID=DIET_CHA.ID ORDER BY DIET DESC" 
    try {
        PreparedStatement pre = conn.prepareStatement("SELECT DIET_CHA.DIET FROM DIET_CHA JOIN KULLANICI ON DIET_CHA.ID=KULLANICI.ID " + " WHERE KULLANICI.ID="+ phone +" " );
        //ResultSet rs= pre.executeQuery();
        CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
        resultSet1.populate(pre.executeQuery());
        
        return  resultSet1 ;
        
    }   
    finally{
        conn.close();
    }
   }
   
    
    // ONUR TABLOSU
public ResultSet getAddresses() throws SQLException{
    int number = Integer.parseInt(phone);
    
    if (dataSource==null) {
        throw new SQLException("Unable to obtain DataSource");
    }
    
    Connection conn = dataSource.getConnection();
    
     if (conn==null) {
        throw new SQLException("Unable to obtain DataSource");
    }    
    //"SELECT * FROM USERS INNER JOIN DIET_CHA ON USERS.ID=DIET_CHA.ID ORDER BY DIET DESC" 
    try {
        PreparedStatement pre = conn.prepareStatement("SELECT KULLANICI.FIRSTNAME,KULLANICI.LASTNAME,KULLANICI.EMAIL,KULLANICI.PASSWORD,KULLANICI.AGE,KULLANICI.HEIGHT,KULLANICI.WEIGHT,KULLANICI.PHONE ,DIET_CHA.DIET FROM KULLANICI JOIN DIET_CHA ON KULLANICI.ID=DIET_CHA.ID ORDER BY DIET DESC" );
       // ResultSet rs= pre.executeQuery();
        CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
        resultSet1.populate(pre.executeQuery());
        return resultSet1;
        
        
    }   
    finally{
        conn.close();
    }
    
    
    
  
} 
    

    public  String save() throws SQLException{
        zero=0;
              
        if(dataSource == null) 
            throw new SQLException("Unable to obtain DataSource" );
        
        Connection connection = dataSource.getConnection();
        
        if(connection == null)
            throw new SQLException("Unable to connect to DataSource");
    try{  
        PreparedStatement pre = connection.prepareStatement("INSERT INTO KULLANICI " + "(ID,FIRSTNAME,LASTNAME,EMAIL,PASSWORD,AGE,HEIGHT,WEIGHT,PHONE,DIYETISYENID)" + "VALUES( ?,?, ?, ?, ?, ?, ?, ?, ?,?)");
        
        pre.setString(1, getPhone());
        pre.setString(2, getFirstName());
        pre.setString(3, getLastName());
        pre.setString(4, getEmail());
        pre.setString(5, getPassword());
        pre.setString(6, getAge());
        pre.setString(7, getHeight());
        pre.setString(8, getWeight());
        pre.setString(9, getPhone());
        pre.setInt(10, 0);
        
        pre.executeUpdate();
        return "signup";
    }
         finally
 {
 connection.close();
 }   
        
        
    }
  
     
}
     
     
    

