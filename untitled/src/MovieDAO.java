import java.sql.*;

public class MovieDAO {
    private Connection connect;
    private Statement state;
    private PreparedStatement preState;
    private ResultSet res;
    private int intRes;

    public MovieDAO(){
        try{
            // set up connection
            String url = "jdbc:db2://neptunium.cs.umanitoba.ca:50000/cs3380";
            String username = "tiamiyao";
            String password = "7900143";
            //connect to database
            connect = DriverManager.getConnection(url, username,password);
            System.out.println("Successfully connected to "+ url);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }




    public void insertToMovies(String mID, String title, String date, String runtime, String budget){
        int runtimeInt;
        int budgetInt;
        int mIDInt = Integer.parseInt(mID);

        try {
            //1--when only mID and title are given
            if (date.isEmpty() && runtime.isEmpty() && budget.isEmpty()) {
                preState = connect.prepareStatement("INSERT INTO MOVIES (ID, Title) VALUES (?, ?)");
                preState.setInt(1,mIDInt);
                preState.setString(2,title );
            }

            //2--when mid,title and date are given
            if(!date.isEmpty() && runtime.isEmpty() && budget.isEmpty()){
                preState = connect.prepareStatement
                        ("INSERT INTO MOVIES (ID, Title,ReleaseDate) VALUES (?, ?,?)");
                preState.setInt(1,mIDInt);
                preState.setString(2,title );
                preState.setString(3,date );
            }

            //3--when mid,title and runtime are given
            if(date.isEmpty() && !runtime.isEmpty() && budget.isEmpty()){
                runtimeInt = Integer.parseInt(runtime);
                preState = connect.prepareStatement
                        ("INSERT INTO MOVIES (ID, Title,Runtime) VALUES (?, ?,?)");
                preState.setInt(1,mIDInt);
                preState.setString(2,title );
                preState.setInt(3,runtimeInt );

            }

            //4--when mid,title and budget are given
            if(date.isEmpty() && runtime.isEmpty() && !budget.isEmpty()){
                budgetInt = Integer.parseInt(budget);
                preState = connect.prepareStatement
                        ("INSERT INTO MOVIES (ID, Title,Budget) VALUES (?, ?,?)");
                preState.setInt(1,mIDInt);
                preState.setString(2,title );
                preState.setInt(3,budgetInt );
            }

            //5-- when mid,title and date, runtime are given
            if(!date.isEmpty() && !runtime.isEmpty() && budget.isEmpty()){
                runtimeInt = Integer.parseInt(runtime);
                preState = connect.prepareStatement
                        ("INSERT INTO MOVIES (ID, Title,ReleaseDate,Runtime) VALUES (?, ?,?,?)");
                preState.setInt(1,mIDInt);
                preState.setString(2,title );
                preState.setString(3,date );
                preState.setInt(4,runtimeInt );
            }

            //6-- when mid,title and date, budget are given
            if(!date.isEmpty() && runtime.isEmpty() && !budget.isEmpty()){
                budgetInt = Integer.parseInt(budget);
                preState = connect.prepareStatement
                        ("INSERT INTO MOVIES (ID, Title,ReleaseDate,Budget) VALUES (?, ?,?,?)");
                preState.setInt(1,mIDInt);
                preState.setString(2,title );
                preState.setString(3,date );
                preState.setInt(4,budgetInt );
            }

            //7-- when mid,title and runtime, budget are given
            if(date.isEmpty() && !runtime.isEmpty() && !budget.isEmpty()){
                budgetInt = Integer.parseInt(budget);
                runtimeInt = Integer.parseInt(runtime);
                preState = connect.prepareStatement
                        ("INSERT INTO MOVIES (ID, Title,Runtime,Budget) VALUES (?, ?,?,?)");
                preState.setInt(1,mIDInt);
                preState.setString(2,title );
                preState.setInt(3,runtimeInt );
                preState.setInt(4,budgetInt );

            }

            //8-- when mid,title and date, runtime, budget are given
            if(!date.isEmpty() && !runtime.isEmpty() && !budget.isEmpty()){
                budgetInt = Integer.parseInt(budget);
                runtimeInt = Integer.parseInt(runtime);
                preState = connect.prepareStatement
                        ("INSERT INTO MOVIES (ID, Title,ReleaseDate, Runtime,Budget) VALUES (?, ?,?,?,?)");
                preState.setInt(1,mIDInt);
                preState.setString(2,title );
                preState.setString(3,date );
                preState.setInt(3,runtimeInt );
                preState.setInt(4,budgetInt );
            }

            intRes = preState.executeUpdate();

        }

        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertToActors(String aID, String name){
        int aIDInt = Integer.parseInt(aID);

        try{
            preState = connect.prepareStatement("INSERT INTO actors VALUES (?,?)");
            preState.setInt(1, aIDInt);
            preState.setString(2, name);
            intRes = preState.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertToStaff(String cID, String name){
        int cIDInt = Integer.parseInt(cID);

        try{
            preState = connect.prepareStatement("INSERT INTO staff VALUES (?,?)");
            preState.setInt(1, cIDInt);
            preState.setString(2, name);
            intRes = preState.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertToActor(String cID, String name){
        int cIDInt = Integer.parseInt(cID);

        try{
            preState = connect.prepareStatement("INSERT INTO actor VALUES (?,?)");
            preState.setInt(1, cIDInt);
            preState.setString(2, name);
            intRes = preState.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertToDept(String name){


        try{
            preState = connect.prepareStatement("INSERT INTO department VALUES (?)");
            preState.setString(1, name);
            intRes = preState.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConnect(){
        return connect;
    }

}
