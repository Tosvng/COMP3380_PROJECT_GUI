import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        MovieDAO m = new MovieDAO();
        boolean end = false;
        System.out.println("Enter \"help\" to show instruction.");

        while(!end) {
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();

            if (input.equalsIgnoreCase("movies")) {
                m.showAll("movies");
            } else if (input.equalsIgnoreCase("actors")) {
                m.showAll("actors");
            } else if (input.equalsIgnoreCase("characters")) {
                m.showAll("characters");
            } else if (input.equalsIgnoreCase("departments")) {
                m.showDept();
            } else if (input.equalsIgnoreCase("genres")) {
                m.showAll("genres");
            } else if (input.equalsIgnoreCase("Companies")) {
                m.showAll("Companies");
            } else if (input.equalsIgnoreCase("Production_Country")) {
                m.showAll("location");
            }
            //_________________QUERIES_____________________________
            else if(input.equalsIgnoreCase("Q1")){
                m.query1();
            }else if(input.equalsIgnoreCase("Q2")){
                m.query2();
            }else if(input.equalsIgnoreCase("Q3")){
                m.query3();
            }
            else if(input.equalsIgnoreCase("Q4")){
                m.query4();
            }
            else if(input.equalsIgnoreCase("Q5")){
                m.query5();
            }
            else if(input.equalsIgnoreCase("Q6")){
                m.query6();
            }
            else if(input.equalsIgnoreCase("Q7")){
                m.query7();
            }
            else if(input.equalsIgnoreCase("Q8")){
                m.query8();
            }
            else if(input.equalsIgnoreCase("Q9")){
                m.query9();
            }
            else if(input.equalsIgnoreCase("Q10")){
                m.query10();
            }
            else if(input.equalsIgnoreCase("q")){
                end = true;
            }
            else if(input.equalsIgnoreCase("help")){
                m.showHelp();
            }

        }
        System.out.println("Program terminated successfully.");

    }
}
