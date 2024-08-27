import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Formula1ChampionshipManager implements ChampionshipManager{

    //Scanner to receive the inputs from the user
    private static Scanner myScanner = new Scanner(System.in);

    //ArrayList that maintains all the Drivers of Formula1Championship
    private ArrayList<Formula1Driver> formula1DriverList = new ArrayList<>();

    //ArrayList that maintains all the ConstructorTeams Associated with Formula1Championship
    private ArrayList<ConstructorTeam> constructorTeams = new ArrayList<>();

    //ArrayList that maintains all the Races Associated with Formula1Championship
    private ArrayList<Race> raceList = new ArrayList<>();


    public static void main(String[] args) {

        //Creating the Formula1ChampionshipManager who can interact with the System
        Formula1ChampionshipManager f1Manager = new Formula1ChampionshipManager();

        //Retrieving all the data that has been stored in the "F1Championship.txt" File.
        System.out.println();
        f1Manager.retrieveData();

        while (true) {

            System.out.println();
            System.out.println("       *...*...*     ");
            System.out.println("       MENU LIST     ");
            System.out.println("       *...*...*     ");

            //Menu Options.
            System.out.println
                    (
                            "100 0r CND : Create A New Driver \n" +
                            "101 Or DAD : Delete A Driver And The Related Constructor Team \n" +
                            "102 Or CDC : Change The Driver For An Existing Constructor Team \n" +
                            "103 Or DSD : Display Statistics For An Existing Driver \n" +
                            "104 Or DFT : Display Formula 1 Driver Table \n" +
                            "105 Or ARC : Add A Race \n" +
                            "106 Or SPD : Store Program Data Into File \n" +
                            "107 Or DGI : Display \"Formula 1 Championship\" UI \n" +
                            "999 or EXT : Exit the Program"


                    );


            System.out.println();
            System.out.print("Enter a action to perform : ");
            String operation = myScanner.next();

            if (operation.equals("100") || operation.equalsIgnoreCase("CND")) {
                f1Manager.createNewDriver();
            }else if (operation.equals("101") || operation.equalsIgnoreCase("DAD")){
                f1Manager.deleteDriver();
            }else if (operation.equals("102") || operation.equalsIgnoreCase("CDC")){
                f1Manager.changeDriver();
            }else if (operation.equals("103") || operation.equalsIgnoreCase("DSD")){
                f1Manager.displayStatisticsOfDriver();
            }else if (operation.equals("104") || operation.equalsIgnoreCase("DFT")) {
                f1Manager.displayFormula1DriverTable();
            }else if (operation.equals("105") || operation.equalsIgnoreCase("ARC")){
                f1Manager.addRaceCompleted();
            }else if (operation.equals("106") || operation.equalsIgnoreCase("SPD")){
                f1Manager.saveInFile();
            }else if (operation.equals("107") || operation.equalsIgnoreCase("DGI")){
                f1Manager.displayGUI();
            } else if (operation.equals("999") || operation.equalsIgnoreCase("EXT")) {
                System.out.println("Program is exiting...");
                break;
            } else{
                System.out.println("Re-enter the Correct Value.");
            }

        }
    }


    public void createNewDriver() {
        System.out.println();
        System.out.println("................................");
        System.out.println("    Driver Personal Details    ");
        System.out.println("................................");
        System.out.println();

        System.out.print("Enter the name of the Driver      : ");
        String driverName = myScanner.next();

        System.out.print("Enter the location of the Driver  : ");
        String driverLocation = myScanner.next();


        System.out.println();
        System.out.println("...............................................");
        System.out.println("    Formula1 Championship Seasonal Details    ");
        System.out.println("...............................................");
        System.out.println();

        HashMap<Integer, Integer> statistics = new HashMap<>();

        //This is to check that the right value is entered in the response1.
        while(true) {
            System.out.print("Did driver " + "\"" + driverName + "\"" + " compete in a Race before ? If yes press \" Y \" else press \" N \" : ");
            String response1 = myScanner.next();

            if(response1.equalsIgnoreCase("Y")) {


                while(true) {

                    System.out.println();
                    System.out.print("Enter the Position                                    : ");

                    int position = 0;

                    //to confirm that a numerical value is being given by the user
                    boolean flag4 = true;

                    try {
                        Scanner myScanner1 = new Scanner(System.in);
                        position = myScanner1.nextInt();


                    } catch (InputMismatchException e) {
                        System.out.println("Enter a Numerical value.");
                        flag4 = false;
                    }

                    if(!flag4){
                        continue;
                    }


                    //Controlling the position overridden.
                    boolean flag1 = true;

                    //This is to check whether the position entered is already being recorded or not.
                    for (int key : statistics.keySet()) {

                        if (key == position) {

                            //This is to check that the right value is entered in the response2.
                            while(true) {
                                System.out.print("Position " + "\"" + position + "\"" + " has already been entered. Do you want to edit it ? If yes press \" Y \" else press \" N \" : ");
                                String response2 = myScanner.next();

                                if(response2.equalsIgnoreCase("Y")){
                                    break;

                                }else if(response2.equalsIgnoreCase("N")){
                                    flag1 = false;
                                    break;

                                }else{
                                    System.out.println("Re-enter the correct value {\"Y/y\" or \"N/n\"}");
                                    System.out.println();
                                }
                            }

                            break;
                        }
                    }

                    //If "flag1 == false -> break" that means you are not allowing to override an existing position .
                    if(!flag1){
                        System.out.println("Re-enter the Position");
                        continue;
                    }


                    int times;

                    //To confirm that a numerical value is being given by the user.
                    while(true) {
                        System.out.print("How many times " + "\"" + driverName + "\"" +  " have achieved position \"" + position + "\" : ");

                        try {
                            Scanner myScanner2 = new Scanner(System.in);
                            times = myScanner2.nextInt();
                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Enter a Numerical value.");
                            System.out.println();

                        }

                    }

                    System.out.println();
                    statistics.put(position, times);



                    //This flag1 is responsible to control whether to enter another position or not.
                    boolean flag2 = true;

                    //This is to check that the right value is entered in the response3.
                    while (true) {
                        System.out.print("Would you like to add another position ? If yes press \" Y \" else press \" N \" : ");
                        String response3 = myScanner.next();

                        if (response3.equalsIgnoreCase("Y")) {
                            break;
                        } else if (response3.equalsIgnoreCase("N")) {
                            flag2 = false;
                            break;
                        } else {
                            System.out.println("Re-enter the correct value {\"Y/y\" or \"N/n\"}");
                            System.out.println();
                        }
                    }

                    //If "flag2 == false -> break" that means you can't enter another position.
                    if(!flag2){
                        break;
                    }

                }

                break;

            }else if(response1.equalsIgnoreCase("N")) {
                break;

            } else {
                System.out.println("Re-enter the correct value {\"Y/y\" or \"N/n\"}");
                System.out.println();
            }
        }

        System.out.println();
        System.out.println(".................................");
        System.out.println("    Constructor Team Details    ");
        System.out.println(".................................");
        System.out.println();

        //This is to check that the right value is entered in the response4.
        while(true) {
            System.out.print("Does driver " + "\"" + driverName + "\"" + " has a Constructor Team ? If yes press \" Y \" else press \" N \" : ");
            String response4 = myScanner.next();

            if(response4.equalsIgnoreCase("Y")){

                String teamName;
                while (true) {
                    System.out.println();
                    System.out.print("Enter the Name of the Team : ");
                    teamName = myScanner.next();

                    //Controlling that no duplicate Teams are to be added.
                    boolean flag3 = true;

                    //This is to check whether the Team entered is already being recorded or not.
                    for (ConstructorTeam team : constructorTeams) {
                        if (team.getTeamName().equalsIgnoreCase(teamName)) {
                            System.out.println("Sorry, Team " + "\"" + teamName + "\"" + " has already been registered. Enter a different Team.");
                            flag3 = false;
                            break;
                        }
                    }

                    //If "flag3 == true -> break" that means you don't have a duplicate Team.
                    if (flag3) {
                        break;
                    }
                }

                //Creating a ConstructorTeam object.
                ConstructorTeam team = new ConstructorTeam(teamName);

                //Creating a Formula1Driver Object along with the ConstructorTeam.
                Formula1Driver driver = new Formula1Driver(driverName, driverLocation, team, statistics);

                //Setting the Driver of the ConstructorTeam so in both way it knows......
                team.setDriver(driver);

                //Adding it to the ArrayList.
                formula1DriverList.add(driver);
                constructorTeams.add(team);

                successfulMessage();

                System.out.println("Driver " + "\"" + driverName + "\"" + " has been Successfully added to the Formula1 Championship." );


                break;

            }else if(response4.equalsIgnoreCase("N")) {

                //Creating a Formula1Driver Object without a ConstructorTeam.
                Formula1Driver driver = new Formula1Driver(driverName, driverLocation, statistics);

                //Adding it to the ArrayList.
                formula1DriverList.add(driver);

                successfulMessage();

                System.out.println("Driver " + "\"" + driverName + "\"" + " has been Successfully added to the Formula1 Championship." );

                break;
            }else{
                System.out.println("Re-enter the correct value {\"Y/y\" or \"N/n\"}");
                System.out.println();
            }
        }
    }



    private void createNewDriver(ConstructorTeam team, String oldDriverName) {

        System.out.println();
        System.out.println("................................");
        System.out.println("    Driver Personal Details    ");
        System.out.println("................................");
        System.out.println();

        System.out.print("Enter the name of the Driver      : ");
        String driverName = myScanner.next();

        System.out.print("Enter the location of the Driver  : ");
        String driverLocation = myScanner.next();

        System.out.println();
        System.out.println("...............................................");
        System.out.println("    Formula1 Championship Seasonal Details    ");
        System.out.println("...............................................");
        System.out.println();

        HashMap<Integer, Integer> statistics = new HashMap<>();

        //This is to check that the right value is entered in the response1.
        while(true) {
            System.out.print("Did driver " + "\"" + driverName + "\"" + " compete in a Race before ? If yes press \" Y \" else press \" N \" : ");
            String response1 = myScanner.next();

            if(response1.equalsIgnoreCase("Y")) {


                while(true) {

                    System.out.println();
                    System.out.print("Enter the Position                                    : ");

                    int position = 0;

                    //to confirm that a numerical value is being given by the user
                    boolean flag4 = true;

                    try {
                        Scanner myScanner1 = new Scanner(System.in);
                        position = myScanner1.nextInt();


                    } catch (InputMismatchException e) {
                        System.out.println("Enter a Numerical value.");
                        flag4 = false;
                    }

                    if(!flag4){
                        continue;
                    }


                    //Controlling the position overridden.
                    boolean flag1 = true;

                    //This is to check whether the position entered is already being recorded or not.
                    for (int key : statistics.keySet()) {

                        if (key == position) {

                            //This is to check that the right value is entered in the response2.
                            while(true) {
                                System.out.print("Position " + "\"" + position + "\"" + " has already been entered. Do you want to edit it ? If yes press \" Y \" else press \" N \" : ");
                                String response2 = myScanner.next();

                                if(response2.equalsIgnoreCase("Y")){
                                    break;

                                }else if(response2.equalsIgnoreCase("N")){
                                    flag1 = false;
                                    break;

                                }else{
                                    System.out.println("Re-enter the correct value {\"Y/y\" or \"N/n\"}");
                                    System.out.println();
                                }
                            }

                            break;
                        }
                    }

                    //If "flag1 == false -> break" that means you are not allowing to override an existing position .
                    if(!flag1){
                        System.out.println("Re-enter the Position");
                        continue;
                    }


                    int times;

                    //To confirm that a numerical value is being given by the user.
                    while(true) {
                        System.out.print("How many times " + "\"" + driverName + "\"" +  " have achieved position \"" + position + "\" : ");

                        try {
                            Scanner myScanner2 = new Scanner(System.in);
                            times = myScanner2.nextInt();
                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Enter a Numerical value.");
                            System.out.println();

                        }

                    }

                    System.out.println();
                    statistics.put(position, times);



                    //This flag1 is responsible to control whether to enter another position or not.
                    boolean flag2 = true;

                    //This is to check that the right value is entered in the response3.
                    while (true) {
                        System.out.print("Would you like to add another position ? If yes press \" Y \" else press \" N \" : ");
                        String response3 = myScanner.next();

                        if (response3.equalsIgnoreCase("Y")) {
                            break;
                        } else if (response3.equalsIgnoreCase("N")) {
                            flag2 = false;
                            break;
                        } else {
                            System.out.println("Re-enter the correct value {\"Y/y\" or \"N/n\"}");
                            System.out.println();
                        }
                    }

                    //If "flag2 == false -> break" that means you can't enter another position.
                    if(!flag2){
                        break;
                    }

                }

                break;

            }else if(response1.equalsIgnoreCase("N")) {
                break;

            } else {
                System.out.println("Re-enter the correct value {\"Y/y\" or \"N/n\"}");
                System.out.println();
            }
        }


        //creating new driver and assigning the existing team/ applying a new driver to a team.
        Formula1Driver driver = new Formula1Driver(driverName, driverLocation, team, statistics);
        formula1DriverList.add(driver);

        //assigning the driver to the constructor team.
        team.setDriver(driver);

        successfulMessage();

        System.out.println("For team " +"\""+ team.getTeamName() +"\"" + " Old Driver " + "\"" + oldDriverName + "\""  + " has been Successfully Replaced by a New Driver called " + "\"" + driverName + "\".");

    }


    public void deleteDriver(){
        System.out.println();
        System.out.println("    Action List    ");
        System.out.println("....................");
        System.out.println();

        for(int i = 0; i < formula1DriverList.size(); i++){
            System.out.println(i + " => " + formula1DriverList.get(i).getDriverName());
        }


        int count = formula1DriverList.size();
        int number;

        //To confirm that a numerical value is being given by the user.
        while (true) {
            System.out.println();
            System.out.print("Enter the corresponding number of which Driver that you want to remove : ");

            try {
                Scanner myScanner1 = new Scanner(System.in);
                number = myScanner1.nextInt();

                //controlling that the number entered is in the range of drivers existing in the ArrayList.
                if ((number >= count) || (number < 0)){
                    System.out.println("The entered value should be in the range of 0 and " + (count-1) + ".");
                    System.out.println("Re-enter the value.");
                    continue;
                }

                break;

            } catch (InputMismatchException e) {
                System.out.println("Enter a Numerical value.");
            }

        }

        String driverName = formula1DriverList.get(number).getDriverName();

        //checking the drivers who have a constructor team and removing that specified team along with its driver from the both ArrayLists.
        if(formula1DriverList.get(number).getTeam() != null) {
            String teamName = formula1DriverList.get(number).getTeam().getTeamName();
            ConstructorTeam team = formula1DriverList.get(number).getTeam();
            constructorTeams.remove(team);

            formula1DriverList.remove(number);

            successfulMessage();

            System.out.println("Driver " + "\"" + driverName + "\"" + " and his Team " + "\"" + teamName + "\"" + " have been successfully removed from \"Formula 1 Championship\".");

            //deleting the drivers who don't have a constructor team.
        }else{
            formula1DriverList.remove(number);

            successfulMessage();

            System.out.println("Driver " + "\"" + driverName + "\"" + " has been successfully removed from \"Formula 1 Championship\".");
        }

    }


    public void changeDriver() {
        System.out.println();
        System.out.println("    Existing ConstructorTeam List    ");
        System.out.println("......................................");
        System.out.println();

        //To get the total number of currently available constructor teams.
        int count = 0;
        //Showing all the existing constructor teams.
        for(int i = 0; i < constructorTeams.size(); i++){
            System.out.println(i + " => " + constructorTeams.get(i).getTeamName());
            count = count + 1;
        }

        int number;
        //To confirm that a numerical value is being given by the user.
        while(true) {
            System.out.println();
            System.out.print("Enter the corresponding number of which constructor team that you want to change the driver : ");

            try {
                Scanner myScanner1 = new Scanner(System.in);
                number = myScanner1.nextInt();

                //controlling that the number entered is in the range of drivers existing in the ArrayList.
                if ((number >= count) || (number < 0)){
                    System.out.println("The entered value should be in the range of 0 and " + (count-1) + ".");
                    System.out.println("Re-enter the value.");
                    continue;
                }

                break;

            }catch (InputMismatchException e) {
                System.out.println("Enter a Numerical value.");
            }

        }

        System.out.println();
        System.out.println("1 => To Create New Driver and add it to the Team " + "\"" + constructorTeams.get(number).getTeamName() + "\"" +
                "\n2 => To add an Existing Driver who is currently without a team to Team " + "\"" + constructorTeams.get(number).getTeamName() + "\"" +
                "\n3 => To add an Existing Driver who is currently with a team to Team " + "\"" + constructorTeams.get(number).getTeamName() + "\"" );


        int response4;
        //To confirm that a numerical value is being given by the user.
        while(true) {
            System.out.println();
            System.out.print("Enter the corresponding number of which action to be performed : ");

            try {
                Scanner myScanner2 = new Scanner(System.in);
                response4 = myScanner2.nextInt();

                //controlling that the number entered is in the range of .
                if ((response4 > 3) || (response4 <= 0)){
                    System.out.println("The entered value should be 1 or 2");
                    System.out.println("Re-enter the value.");
                    continue;
                }

                break;

            }catch (InputMismatchException e) {
                System.out.println("Enter a Numerical value.");
            }

        }

        //creating new driver
        if(response4 == 1){
            //setting the team attribute of the corresponding driver as null
            Driver driver = constructorTeams.get(number).getDriver();
            String oldDriverName = driver.getDriverName();
            driver.setTeam(null);

            createNewDriver(constructorTeams.get(number), oldDriverName);



            //adding an existing driver who is without a team
        }else if(response4 == 2){

            //to hold the drivers who exist without a team.
            ArrayList<Formula1Driver> driversWithOutTeamList = new ArrayList<>();

            for(Formula1Driver driver : formula1DriverList){
                if(driver.getTeam() == null){
                    driversWithOutTeamList.add(driver);
                }
            }

            //Have to confirm that there is at least 1 driver without a team.
            if(driversWithOutTeamList.size() != 0) {

                System.out.println();
                System.out.println("    List of Drivers Without a Team    ");
                System.out.println("......................................");
                System.out.println();

                for (int i = 0; i < driversWithOutTeamList.size(); i++) {

                    System.out.println(i + " => " + driversWithOutTeamList.get(i).getDriverName());

                }


                int number1;
                //To confirm that a numerical value is being given by the user.
                while(true) {
                    System.out.println();
                    System.out.print("Enter the corresponding number of which driver you need to assign for the team " + "\"" + constructorTeams.get(number).getTeamName() + "\"" + " : ");

                    try {
                        Scanner myScanner3 = new Scanner(System.in);
                        number1 = myScanner3.nextInt();

                        //controlling that the number entered is in the range of .
                        if ((number1 >= driversWithOutTeamList.size()) || (number1 < 0)) {
                            System.out.println("The entered value should be in the range of 0 and " + (driversWithOutTeamList.size()-1) + ".");
                            System.out.println("Re-enter the value.");
                            continue;
                        }

                        break;

                    } catch (InputMismatchException e) {
                        System.out.println("Enter a Numerical value.");
                    }

                }


                //setting the team attribute of the corresponding driver as null
                constructorTeams.get(number).getDriver().setTeam(null);
                String oldDriverName = constructorTeams.get(number).getDriver().getDriverName();

                //setting the existing driver who doesn't have any team to a specific team
                constructorTeams.get(number).setDriver(driversWithOutTeamList.get(number1));

                //setting the team attribute of the specific driver
                driversWithOutTeamList.get(number1).setTeam(constructorTeams.get(number));
                String newDriverName = driversWithOutTeamList.get(number1).getDriverName();

                successfulMessage();

                System.out.println("For team " + "\"" + constructorTeams.get(number).getTeamName() + "\"" + " Old Driver " + "\"" + oldDriverName + "\"" + " has been Successfully Replaced by an Existing Driver called " + "\"" + newDriverName + "\".");

            }else {
                System.out.println();
                System.out.println("This function won't be currently applicable. Because All the Drivers have a Team.");
            }

            //adding an existing driver who is with a team.
        }else {

            //to hold the drivers who currently exist with a team.
            ArrayList<Formula1Driver> driversWithTeamList = new ArrayList<>();

            for(Formula1Driver driver : formula1DriverList){
                if(driver.getTeam() != null){

                    //Controlling the same driver won't be assigned again.
                    if(driver != constructorTeams.get(number).getDriver()) {
                        driversWithTeamList.add(driver);
                    }
                }
            }




            //Have to confirm that there is at least 1 driver with a team.
            if(driversWithTeamList.size() != 0) {

                System.out.println();
                System.out.println("    List of Drivers With a Team    ");
                System.out.println("...................................");
                System.out.println();

                for (int i = 0; i < driversWithTeamList.size(); i++) {

                    System.out.println(i + " => " + driversWithTeamList.get(i).getDriverName());

                }


                int number1;
                //To confirm that a numerical value is being given by the user.
                while(true) {
                    System.out.println();
                    System.out.print("Enter the corresponding number of which driver you need to assign for the team " + "\"" + constructorTeams.get(number).getTeamName() + "\"" + " : ");

                    try {
                        Scanner myScanner3 = new Scanner(System.in);
                        number1 = myScanner3.nextInt();

                        //controlling that the number entered is in the range of .
                        if ((number1 >= driversWithTeamList.size()) || (number1 < 0)) {
                            System.out.println("The entered value should be in the range of 0 and " + (driversWithTeamList.size()-1) + ".");
                            System.out.println("Re-enter the value.");
                            continue;
                        }

                        break;

                    } catch (InputMismatchException e) {
                        System.out.println("Enter a Numerical value.");
                    }

                }


                //setting the team attribute of the corresponding driver as null
                constructorTeams.get(number).getDriver().setTeam(null);
                String oldDriverName = constructorTeams.get(number).getDriver().getDriverName();

                //setting the existing driver who have the team to the specific team.
                constructorTeams.get(number).setDriver(driversWithTeamList.get(number1));

                //setting the other driver teams driver attribute to null.
                driversWithTeamList.get(number1).getTeam().setDriver(null);

                //getting the team ref in order to remove it once it jas no driver in it.
                ConstructorTeam teamRefWithoutDriver = driversWithTeamList.get(number1).getTeam();
                String removableTeam = teamRefWithoutDriver.getTeamName();

                //setting the team attribute of the specific driver.
                driversWithTeamList.get(number1).setTeam(constructorTeams.get(number));
                String newDriverName = driversWithTeamList.get(number1).getDriverName();

                successfulMessage();

                System.out.println("For team " + "\"" + constructorTeams.get(number).getTeamName() + "\"" + " Driver " + "\"" + oldDriverName + "\"" + " has been Successfully Replaced by the Driver called " + "\"" + newDriverName + "\"  who is From Team " + "\"" + removableTeam + "\"" + ".");

                //removing the team which has no driver.
                constructorTeams.remove(teamRefWithoutDriver);

            }else {
                System.out.println();
                System.out.println("This function won't be currently applicable. Because All the Drivers exist without a Team.");
            }

        }
    }


    public void displayStatisticsOfDriver(){
        System.out.println();
        System.out.println("    Action List    ");
        System.out.println("....................");
        System.out.println();

        for(int i = 0; i < formula1DriverList.size(); i++){
            System.out.println(i + " => " + formula1DriverList.get(i).getDriverName());
        }


        int count = formula1DriverList.size();
        int number;

        //To confirm that a numerical value is being given by the user.
        while (true) {
            System.out.println();
            System.out.print("Enter the corresponding number of which Driver that you want to Display the Statistics : ");

            try {
                Scanner myScanner1 = new Scanner(System.in);
                number = myScanner1.nextInt();

                //controlling that the number entered is in the range of drivers existing in the ArrayList.
                if ((number >= count) || (number < 0)){
                    System.out.println("The entered value should be in the range of 0 and " + (count-1) + ".");
                    System.out.println("Re-enter the value.");
                    continue;
                }

                break;

            } catch (InputMismatchException e) {
                System.out.println("Enter a Numerical value.");
            }

        }


        System.out.println();
        System.out.println(".............................");
        System.out.println("   Driver Personal Details   ");
        System.out.println(".............................");

        System.out.println("Name Of The Driver           : " + formula1DriverList.get(number).getDriverName());
        System.out.println("Location Where He Lives      : " + formula1DriverList.get(number).getDriverLocation());

        System.out.println();
        System.out.println(".............................");
        System.out.println("    Professional Details     ");
        System.out.println(".............................");

        if(formula1DriverList.get(number).getTeam() != null) {
            System.out.println("Team Name                    : " + formula1DriverList.get(number).getTeam().getTeamName());
        }else{
            System.out.println("Team Name                    : " + "No Teams Assigned Yet");
        }

        System.out.println("Current Points               : " + formula1DriverList.get(number).getCurrentPoints());
        System.out.println("Number Of Races Participated : " + formula1DriverList.get(number).getNoOfRaces());

        if(formula1DriverList.get(number).getStatistics().get(1) != null) {
            System.out.println("Number Of 1st Places         : " + formula1DriverList.get(number).getStatistics().get(1));
        }else{
            System.out.println("Number Of 1st Places         : " + 0);
        }

        if(formula1DriverList.get(number).getStatistics().get(2) != null) {
            System.out.println("Number Of 2nd Places         : " + formula1DriverList.get(number).getStatistics().get(2));
        }else{
            System.out.println("Number Of 2nd Places         : " + 0);
        }

        if(formula1DriverList.get(number).getStatistics().get(3) != null) {
            System.out.println("Number Of 3rd Places         : " + formula1DriverList.get(number).getStatistics().get(3));
        }else{
            System.out.println("Number Of 3rd Places         : " + 0);
        }


        //Showing statistics only for those who participated in a race before in this season.
        if(formula1DriverList.get(number).getStatistics().keySet().size() != 0) {

            System.out.println();
            System.out.println(".............................");
            System.out.println("       Race Statistics       ");
            System.out.println(".............................");


            // have to sort the hashmap keys... for extra clarity
            for (int key : formula1DriverList.get(number).getStatistics().keySet()) {
                System.out.println("Position  \"" + key + "\" : " + formula1DriverList.get(number).getStatistics().get(key) + "  times");
            }
        }
    }

    public void displayFormula1DriverTable(){

        System.out.println();

        int sizeArraylist = formula1DriverList.size();

        //copying and storing it in the arrays to make the execution even faster.
        Formula1Driver[] sortedRacers = new Formula1Driver[sizeArraylist];

        for (int i = 0; i < sortedRacers.length; i++)
        {
            sortedRacers[i] = formula1DriverList.get(i);
        }

        //To hold Temporary Driver.
        Formula1Driver temporaryDriver;

        for (int i = 0; i < sortedRacers.length; i++) {
            for (int j = i + 1; j < sortedRacers.length; j++)
            {
                if (sortedRacers[i].getCurrentPoints() < sortedRacers[j].getCurrentPoints()) {
                    temporaryDriver = sortedRacers[i];
                    sortedRacers[i] = sortedRacers[j];
                    sortedRacers[j] = temporaryDriver;

                    //If the points are equal then the driver who won the most 1 st places should come first.
                }else if (sortedRacers[i].getCurrentPoints() == sortedRacers[j].getCurrentPoints()){

                    int timesI = 0;
                    if (sortedRacers[i].getStatistics().get(1) != null){
                        timesI = sortedRacers[i].getStatistics().get(1);
                    }


                    int timesJ = 0;
                    if (sortedRacers[j].getStatistics().get(1) != null){
                        timesJ = sortedRacers[j].getStatistics().get(1);
                    }

                    if(timesI < timesJ){
                        temporaryDriver = sortedRacers[i];
                        sortedRacers[i] = sortedRacers[j];
                        sortedRacers[j] = temporaryDriver;
                    }
                }
            }
        }

        //Display the Table Heading.
        System.out.println("+--------------------+---------------------+---------------------+--------------------------+---------------------+--------------------------+---------------------+");
        System.out.printf("|%-20s| %-20s| %-20s| %-25s| %-20s| %-25s| %-20s|", "      Position", "    DriverName", "     Location", "     ConstructorTeam", "     NoOFRaces", "     NoOf 1st Places", "   CurrentPoints");
        System.out.println();
        System.out.println("+--------------------+---------------------+---------------------+--------------------------+---------------------+--------------------------+---------------------+");


        for(int i = 0; i < sortedRacers.length; i++){

            //Storing the teamName.
            String teamName;
            if(sortedRacers[i].getTeam() != null) {
                teamName = sortedRacers[i].getTeam().getTeamName();
            }else{
                teamName = "Not Assigned Yet";
            }

            //Storing the number of how many 1st positions.
            int timesOfPosition1 = 0;
            if (sortedRacers[i].getStatistics().get(1) != null){
                timesOfPosition1 = sortedRacers[i].getStatistics().get(1);
            }

            System.out.printf("|%-20s| %-20s| %-20s| %-25s| %-20s| %-25s| %-20s|","          " + (i+1), sortedRacers[i].getDriverName(), sortedRacers[i].getDriverLocation(), teamName, "         " + sortedRacers[i].getNoOfRaces(), "            " + timesOfPosition1, "         " + sortedRacers[i].getCurrentPoints());
            System.out.println();

        }

        System.out.println("+--------------------+---------------------+---------------------+--------------------------+---------------------+--------------------------+---------------------+");
    }


    public void addRaceCompleted() {

        //Race Date Details
        System.out.println();
        System.out.println(".................................");
        System.out.println("    Race Name & Date Details    ");
        System.out.println(".................................");
        System.out.println();

        System.out.print("Race Name  : ");
        String raceName = myScanner.next();
        System.out.println();

        LocalDate raceDate;

        while (true) {

            Scanner myScanner1 = new Scanner(System.in);

            System.out.print("Year   : ");
            int year = myScanner1.nextInt();

            System.out.print("Month  : ");
            int month = myScanner1.nextInt();

            System.out.print("Date   : ");
            int date = myScanner1.nextInt();

            try {
                //Here setting the race date. with cleaned values.
                raceDate = LocalDate.of(year, month, date);
                break;

            } catch (Exception e) {
                System.out.println("\""+ e.getMessage() + "\"");
                System.out.println("Re-enter the Correct Date");
                System.out.println();

            }
        }

        System.out.println("......................................................................................");
        System.out.println("    The List of Drivers who participated in this Race along with their Team Names    ");
        System.out.println("......................................................................................");
        System.out.println();

        //System.out.printf("%-15s %-15s", "DriverName", "ConstructorTeam\n\n");
        System.out.println("................... ...................");
        System.out.printf("%-1s %-15s %-1s %-1s %-15s %-1s", "|", "DriverName", "|", "|", "ConstructorTeam", "|\n");
        System.out.println("................... ...................\n");


        //counting how many drivers participating in the Race.
        int count = 0;
        for(Formula1Driver driver : formula1DriverList){
            if (driver.getTeam() != null) {
                count = count + 1;
                //System.out.printf("%-15s %-15s", driver.getDriverName(), driver.getTeam().getTeamName());

                System.out.printf("%-1s %-15s %-1s %-1s %-15s %-1s", "|", driver.getDriverName(), "|", "|", driver.getTeam().getTeamName(), "|");

                System.out.println();
            }
        }
        System.out.println();

        System.out.println("Enter the Positions of Each Driver");

        System.out.println(".........................");
        System.out.printf("%-15s %-15s", "DriverName", "Position");
        System.out.println();
        System.out.println(".........................");
        System.out.println();

        //to stop the position overridden...
        ArrayList<Integer> positionList = new ArrayList<>();

        //To store the raceDetails like Position and the Driver who got that Position.
        HashMap<Integer, String> raceDetails = new HashMap<>();

        int position = 0;
        for (Formula1Driver driver : formula1DriverList){

            if (driver.getTeam() != null){

                while (true) {
                    System.out.printf("%-15s %-2s", driver.getDriverName(), ": " );

                    //To check that a numerical value is being passed by the user.
                    boolean flag6 = true;

                    try {
                        Scanner myScanner1 = new Scanner(System.in);
                        position = myScanner1.nextInt();

                    }catch (InputMismatchException e) {
                        System.out.println("Enter a Numerical value.");
                        flag6 = false;

                    }

                    if(!flag6){
                        continue;
                    }

                    //make sure that position is valid...
                    if (position > count || position <= 0){
                        System.out.println("Re-Enter the correct position in the range of 1 and " + (count) + ".");
                        continue;
                    }
                    int index = positionList.indexOf(position);

                    if (index != -1) {
                        System.out.println("Position \"" + position + "\" has been occupied. Re-Enter the correct position");

                    } else {
                        positionList.add(position);

                        //changing the statistics of a driver
                        int value;
                        if(driver.getStatistics().get(position) != null){
                            value = driver.getStatistics().get(position);
                            value = value + 1;
                        }else{
                            value = 1;
                        }
                        driver.updateStatistics(position, value);
                        driver.calculatePointsAndNoOfRaces();
                        break;
                    }
                }

                //save all the driver details in the hashmap position and their names.
                raceDetails.put(position, driver.getDriverName());

            }
        }

        //adding the race to the raceList in order maintain all the details of a race.
        raceList.add(new Race(raceName, raceDate, raceDetails));

        successfulMessage();

        System.out.println("Race " + "\"" + raceName + "\"" + "Details and Driver's Statistics have been stored and updated successfully.");
    }

    public void saveInFile(){

        try {
            FileOutputStream fos = new FileOutputStream("F1Championship.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(formula1DriverList);
            oos.writeObject(new endOfFile());

            oos.writeObject(constructorTeams);
            oos.writeObject(new endOfFile());

            oos.writeObject(raceList);
            oos.writeObject(new endOfFile());

            //Closing the Resource.
            oos.close();

            successfulMessage();

            System.out.println("All the Details have been Successfully Stored in \" F1Championship.txt \" File.");

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private void retrieveData(){

        try {

            FileInputStream fis = new FileInputStream("F1Championship.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object obj;
            while(!((obj = ois.readObject()) instanceof endOfFile)){

                this.formula1DriverList = (ArrayList<Formula1Driver>) obj;
            }

            while(!((obj = ois.readObject()) instanceof endOfFile)){

                this.constructorTeams = (ArrayList<ConstructorTeam>) obj;
            }

            while(!((obj = ois.readObject()) instanceof endOfFile)){

                this.raceList = (ArrayList<Race>) obj;
            }

            //Closing the Resource.
            ois.close();

            successfulMessage();

            System.out.println("All the Data From the \" F1Championship.txt \" File have been Restored Successfully.");



        }catch(FileNotFoundException fnf){
            System.out.println("There Is No Pre-stored Data in the \"F1Championship.txt\" File\".");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //Java GUI SWING Parts will come here.
    public void displayGUI(){

        //Formula1GUI object to do the GUI based manipulations.
        //Anonymous Object.
        new Formula1GUI(formula1DriverList, raceList);

        successfulMessage();

        System.out.println("The GUI has been Successfully Generated.");

    }

    private void successfulMessage(){
        System.out.println();
        System.out.println("    ....................    ");
        System.out.println("    * SUCCESSFUL MESSAGE *  ");
        System.out.println("    ....................    ");
        System.out.println();
    }

}
