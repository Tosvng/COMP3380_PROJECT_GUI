import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        run();
        System.out.println("Program terminated successfully.");

    }

    public static void run(){
        MovieDAO m = new MovieDAO();
        System.out.println("Enter \"help\" to show instruction.");
        System.out.print("\n");
        System.out.print("db > ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        for(String var=""; input != null && !input.equalsIgnoreCase("q");
            input = scan.nextLine() ){

            String[] temp = input.split("\\s+");
            if (input.indexOf(" ") > 0){
                var = input.substring(input.indexOf(" ")).trim();
            }

            if (temp[0].equalsIgnoreCase("movies")) {
                m.showAll("movies");
            } else if (temp[0].equalsIgnoreCase("actors")) {
                m.showAll("actors");
            } else if (temp[0].equalsIgnoreCase("characters")) {
                m.showAll("characters");
            } else if (temp[0].equalsIgnoreCase("departments")) {
                m.showDept();
            } else if (temp[0].equalsIgnoreCase("genres")) {
                m.showAll("genres");
            } else if (temp[0].equalsIgnoreCase("Companies")) {
                m.showAll("Companies");
            } else if (temp[0].equalsIgnoreCase("locations")) {
                m.showLoc();
            }
            else if (temp[0].equalsIgnoreCase("staffs")) {
                m.showAll("staffs");
            }
            //_________________QUERIES_____________________________
            else if(temp[0].equalsIgnoreCase("Q1")){
                m.query1();
            }else if(temp[0].equalsIgnoreCase("Q2")){

                if(temp.length >= 3) {
                    m.query2(temp[1], temp[2]);
                }
                else{
                    System.out.println("Not enough argument for this command");
                    System.out.println("Using Defaults:\nCountry -- FR\nGenre -- Comedy");
                    m.query2("FR", "Comedy");
                }
            }else if(temp[0].equalsIgnoreCase("Q3")){
                m.query3();
            }
            else if(temp[0].equalsIgnoreCase("Q4")){
                m.query4();
            }
            else if(temp[0].equalsIgnoreCase("Q5")){
                m.query5();
            }
            else if(temp[0].equalsIgnoreCase("Q6")){
                if(temp.length >=2) {
                    m.query6(var);
                }
                else{
                    System.out.println("Not enough argument for this command");
                    System.out.println("Using Defaults:\nTitle --Toy Story");
                    m.query6("Toy Story");
                }
            }
            else if(temp[0].equalsIgnoreCase("Q7")){
                if(temp.length >=2) {
                    m.query7(var);
                }
                else{
                    System.out.println("Not enough argument for this command");
                    System.out.println("Using Defaults:\nTitle --Toy Story");
                    m.query7("Toy Story");
                }
            }
            else if(temp[0].equalsIgnoreCase("Q8")){
                if(temp.length >= 2) {
                    m.query8(temp[1]);
                }
                else{
                    System.out.println("Not enough argument for this command");
                    System.out.println("Using Defaults:\nGenre --Comedy");
                    m.query8("Comedy");
                }
            }
            else if(temp[0].equalsIgnoreCase("Q9")){
                m.query9();
            }
            else if(temp[0].equalsIgnoreCase("Q10")){
                if(temp.length >= 2) {
                    m.query10(temp[1]);
                }
                else{
                    System.out.println("Not enough argument for this command");
                    System.out.println("Using Defaults:\nDepartment --Writing");
                    m.query10("Writing");
                }
            }
            else if(temp[0].equalsIgnoreCase("Q11")){
                m.query11();
            }
            else if(temp[0].equalsIgnoreCase("Q12")){
                m.query12();
            }

            else if(temp[0].equalsIgnoreCase("help")){
                m.showHelp();
            }
            else{
                System.out.println("Read the help with \"help\"");
            }

            System.out.print("\n");
            System.out.print("db > ");

        }



    }
}
