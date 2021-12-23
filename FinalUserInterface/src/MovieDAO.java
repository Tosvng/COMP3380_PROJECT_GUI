import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.Scanner;

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

    public void showDept(){

        try{
            state = connect.createStatement();
            res = state.executeQuery("SELECT departmentName FROM departments ORDER BY departmentName ");

            System.out.println("Name");
            while (res.next()){
                System.out.println(res.getString(1));

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

    public void query2(String country, String genre){
        try {

            preState = connect.prepareStatement("select Title, CountryName, GenreName " +
                    "from Movies " +
                    " natural join Category " +
                    " natural join Genres " +
                    " natural join Produced_in " +
                    " natural join Locations " +
                    " where CountryID = ? " +
                    " and GenreName = ? ");
            preState.setString(1,country);
            preState.setString(2,genre);
            res = preState.executeQuery();
            System.out.println("Title"+ ", "+"CountryID" + ", "+ " GenreName");
            while (res.next()){
                System.out.println(res.getString(1)+ ", "+ res.getString(2)+", "+res.getString(3));

            }

        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("All input should be text");
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


    // Find all actors and characters in Toy Story
    public void query6(String title){
        try{
            preState = connect.prepareStatement("select actorName, characterName from Actors natural join "+
                    " Cast natural join Characters "+
                            " natural join Play " +
                            "natural join Movies " +
                            " where Movies.title = ? ");
            preState.setString(1,title);
            res = preState.executeQuery();
            System.out.println("ActorName"+", "+"CharacterName");
            while (res.next()){
                System.out.println(res.getString(1)+ ", "+ res.getString(2));

            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("All input should be text");
        }
    }

    //Find all actors who played more than 1 character in the movie Toy Story
    public void query7(String title){
        try{

            preState = connect.prepareStatement("select ActorName, count(CharacterName) as numCharacters" +
                    " from Actors" +
                    " natural join Cast" +
                    " natural join Characters " +
                    " natural join Play " +
                    " natural join Movies " +
                    " where Movies.title = ? " +
                    " group by ActorName having numCharacters > 1");
            preState.setString(1,title);
            res = preState.executeQuery();
            System.out.println("ActorName"+", "+"numCharacter");
            while (res.next()){
                System.out.println(res.getString(1)+ ", "+ res.getInt(2));

            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("All input should be text");
        }
    }

    //Find companies produce the most comedy movies
    public void query8(String genre){
        try{

            preState = connect.prepareStatement("select CompanyName, count(genreName) as numComedyMovies "+
                    "from Companies "+
                    "natural join Produced_by "+
                    "natural join Category "+
                    "natural join Genres " +
                    " where GenreName = ? "+
                    "group by CompanyName order by numComedyMovies desc limit 5");

            preState.setString(1,genre);
            res = preState.executeQuery();

            System.out.println("CompanyName"+", "+"numComedyMovies");
            while (res.next()){
                System.out.println(res.getString(1)+ ", "+ res.getInt(2));

            }

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("All input should be text");
        }
    }

    // Find the total average run time for all movie genres
    public void query9(){
        try{
            state = connect.createStatement();
            res = state.executeQuery("select genreName, avg(Runtime) as 'averageRuntime' "+
                    "from Movies "+
                    "natural join Category "+
                    "natural join Genres" +
                    " group by GenreName order by averageRuntime desc"
            );
            System.out.println("GenreName"+", "+"averageRuntime");
            while (res.next()){
                System.out.println(res.getString(1)+ ", "+ res.getInt(2));

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Find the total average run time for all movie genres
    public void query10(String dept){
        try{

            preState = connect.prepareStatement("select  StaffID, StaffName, title, DepartmentName "+
                    "from Staffs "+
                    "natural join Belong "+
                    "natural join Movies" +
                    " natural join work " +
                    "where departmentName = ? "+
                    " and title in ( "+
                    " select title from Movies where revenue - Budget < 0)"+
                    " order by title ");

            preState.setString(1,dept);
            res = preState.executeQuery();


            System.out.println("StaffID"+ ", "+ "StaffName"+", "+"Title"+ ", "+ "DepartmentName");
            while (res.next()){
                System.out.println(res.getInt(1)+ ", "+ res.getString(2)+ ", "+ res.getString(3)
                        + ", "+ res.getString(4));

            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("All input should be text");
        }
    }

    public void showHelp(){
        try {
            FileReader reader = new FileReader("Help.txt");
            BufferedReader buff = new BufferedReader(reader);
            String line = buff.readLine();

            while(line != null) {
                Scanner scan = new Scanner(line);

                System.out.println(line);

                line = buff.readLine();

            }
            reader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
