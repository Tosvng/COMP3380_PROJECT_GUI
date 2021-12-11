/*
This class interacts directly with the database. It executes queries
and preps the result for processing for the resultsTable class
 */
import java.sql.*;
import java.util.ArrayList;

public class SearchMovieDAO {

    private Connection connect;
    private Statement state;
    private PreparedStatement preState;
    private ResultSet res;
    private int intRes;
    private  ArrayList<Result> list;


    public SearchMovieDAO(){
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

    //shows all the movies in the database
    /*
    runs the sql query then returns the query result as an arraylist
     */
    public ArrayList<Result> showAllMovies(){
        list = new ArrayList<Result>();
        state=null;
        try{
            state = connect.createStatement();
            res = state.executeQuery("SELECT movieID,title FROM movie");
            //System.out.println("done!");

            //convert each row from the query to a result object
            //then add each row to an array list then return the array list
            while (res.next()){
                Result row = convertTwoColumn(res);
                list.add(row);

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    //movies join actors---------------------------------------------------
    public ArrayList<Result> moviesXactors(){
        list = new ArrayList<Result>();
        state=null;
        try{
            state = connect.createStatement();
            res = state.executeQuery("SELECT movie.movieID,title,actorName FROM cast inner join movie on cast.movieId = movie.movieID" +
                    " inner join actor on cast.actorid = actor.actorid");
            //System.out.println("done!");

            //convert each row from the query to a result object
            //then add each row to an array list then return the array list
            while (res.next()){
                Result row = convertThreeColumn(res);
                list.add(row);

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Result> producedBy(){
        list = new ArrayList<Result>();
        state=null;
        try{
            state = connect.createStatement();
            res = state.executeQuery("SELECT movie.movieID,title,companyName FROM produced_by " +
                    "inner join movie on produced_by.movieID= movie.movieID inner join company on  company.companyID = produced_by.companyID");
            //System.out.println("done!");

            //convert each row from the query to a result object
            //then add each row to an array list then return the array list
            while (res.next()){
                Result row = convertThreeColumn(res);
                list.add(row);

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    // convert when we are only returning 2 columns
    public Result convertTwoColumn(ResultSet r){
        Result temp = null;
        try{
            temp = new Result(r.getInt(1), r.getString(2));
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println();
        return temp;


    }

    //convert when we are returning 3 columns
    public Result convertThreeColumn(ResultSet r) {
        Result temp = null;
        try {
            temp = new Result(r.getInt(1), r.getString(2), r.getString(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

}
