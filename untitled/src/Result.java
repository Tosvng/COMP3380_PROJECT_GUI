
/*
Every query result will need to be transformed into a Result object so that it can be displayed on the table
There are multiple Result constructors to accommodate for different number of columns we get from a query result
Atmost 4
 */
public class Result {

    private  int id;
    private String title;
    private String name;

    public Result(int id, String title){
        this.id = id;
        this.title = title;
    }

    public Result(int id, String title, String name){
        this.id = id;
        this.title = title;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }
}
