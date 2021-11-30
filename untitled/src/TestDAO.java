import java.sql.*;
import java.util.ArrayList;

public class TestDAO {

    private Connection myConn;
    private Statement myStat;
    private PreparedStatement preStat;
    private int res;
    private ResultSet myRs;

    public TestDAO(){
        try {
            // set up connection
            String url = "jdbc:db2://neptunium.cs.umanitoba.ca:50000/cs3380";
            String username = "tiamiyao";
            String password = "7900143";
            //connect to database
            myConn = DriverManager.getConnection(url, username,password);
            System.out.println("Successfully connected to "+ url);


        }
        catch(Exception e){

            e.printStackTrace();
        }
    }


    //method to insert values into the database
    public void insert(String sin , String  aid) {

        //convert values to integers
        int sinInt = Integer.parseInt(sin);
        int aidInt = Integer.parseInt(aid);

        //do query
        try {
            preStat = myConn.prepareStatement("INSERT INTO temp VALUES (?,?)");
            preStat.setInt(1,sinInt );
            preStat.setInt(2, aidInt);
            res = preStat.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();

        }

    }

    public static void main (String[] args){

        //TestDAO t = new TestDAO();
        //t.insert("11","14");
        String str = "";
        int strInt= Integer.parseInt(str);
    }
}

