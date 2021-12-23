import java.sql.*;
import java.util.ArrayList;

public class MovieDAO {
    private Connection connect;
    private Statement state;
    private PreparedStatement preState;
    private ResultSet res;
    private int intRes;

    public MovieDAO(){
        try{
            // set up connection to the database
            Class.forName("org.sqlite.JDBC");
            connect= DriverManager.getConnection("jdbc:sqlite:Movie.db");
            System.out.println("Successfully connected to the Movie database");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /*// show the movies table
    public void showAllMovies(){
        state=null;
        try{
            state = connect.createStatement();// create a statement
            res = state.executeQuery("SELECT movieID,title FROM movies ORDER BY movieID ");
            while (res.next()){
                System.out.println(res.getInt(1)+ ","+ res.getString(2));

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }*/

    //show all
    public void showAll(String entity){
        try{
            state = connect.createStatement();

            if(entity.equalsIgnoreCase("genres")){//select all genres
                res = state.executeQuery("SELECT genreID,genreName FROM genres ORDER BY genreID ");
            }else if(entity.equalsIgnoreCase("characters")){//select all character
                res = state.executeQuery("SELECT characterID,characterName FROM " +
                        "characters ORDER BY characterID ");
            }else if(entity.equalsIgnoreCase("locations")){//select all location
                res = state.executeQuery("SELECT countryName,country FROM " +
                        "locations ORDER BY countryName ");
            }else if(entity.equalsIgnoreCase("companies")){//select all company
                res = state.executeQuery("SELECT companyID,companyName FROM " +
                        "companies ORDER BY companyID ");
            }else if(entity.equalsIgnoreCase("actors")){//select all actor
                res = state.executeQuery("SELECT actorID,actorName FROM " +
                        "actors ORDER BY actorID ");
            }
            else if(entity.equalsIgnoreCase("staffs")){//select all staff
                res = state.executeQuery("SELECT staffID,staffName FROM " +
                        "staffs ORDER BY staffID ");
            }
            else if(entity.equalsIgnoreCase("movies")){
                res = state.executeQuery("SELECT movieID,title FROM movies ORDER BY movieID ");
            }

            System.out.println("ID"+ ", "+ "Name");
            while (res.next()){
                System.out.println(res.getInt(1)+ ", "+ res.getString(2));

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    //__________________________QUERIES________________________
    public void query1(){
        try {
            state = connect.createStatement();
            res = state.executeQuery("select Title, ReleaseDate, revenue - budget as profit " +
                    " from Movies " +
                    " where releaseDate like '1995%' " +
                    " and profit > 0 " +
                    " order by profit desc " +
                    " limit 5 ");

            System.out.println("Title"+ ", "+"ReleaseDate" + ", "+ " Profit");
            while (res.next()){
                System.out.println(res.getString(1)+ ", "+ res.getString(2)+", "+res.getInt(3));

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void query2(){
        try {
            state = connect.createStatement();
            res = state.executeQuery("select Title, CountryName, GenreName " +
                    "from Movies " +
                    " natural join Category " +
                    " natural join Genres " +
                    " natural join Produced_in " +
                    " natural join Locations " +
                    " where CountryID = 'FR' " +
                    " and GenreName = 'Comedy' ");

            System.out.println("Title"+ ", "+"CountryID" + ", "+ " GenreName");
            while (res.next()){
                System.out.println(res.getString(1)+ ", "+ res.getString(2)+", "+res.getString(3));

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public void query3(){
        try {
            state = connect.createStatement();
            res = state.executeQuery("select title, budget from Movies " +
                    "order by Budget");

            System.out.println("Title"+ ", "+"Budget");
            while (res.next()){
                System.out.println(res.getString(1)+ ", "+ res.getInt(2));

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void query4(){
        try {
            state = connect.createStatement();
            res = state.executeQuery("select title, revenue - budget as profit from Movies " +
                    " where profit < 0 " +
                    " order by profit desc");

            System.out.println("Title"+ ", "+"Loss");
            while (res.next()){
                System.out.println(res.getString(1)+ ", "+ res.getInt(2));

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void query5(){/// titanic's revenue is too large for int
        try {
            state = connect.createStatement();
            res = state.executeQuery("select title, revenue from Movies " +
                    "order by revenue");

            System.out.println("Title"+ ", "+"Revenue");
            while (res.next()){
                System.out.println(res.getString(1)+ ", "+ res.getInt(2));

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
