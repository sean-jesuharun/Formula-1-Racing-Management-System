public interface ChampionshipManager {

    /* By default, in interfaces all the undefined methods will be public and abstract */

    //To create a new Driver.
    void createNewDriver();

    //To delete a Driver and the related constructor Team.
    void deleteDriver();

    //To change the Driver for an Existing Constructor Team.
    void changeDriver();

    //To show the statistics for a selected Driver.
    void displayStatisticsOfDriver();

    //To display the Formula1 Championship Table.
    void displayFormula1DriverTable();

    //To add a Race.
    void addRaceCompleted();

    //To save all the details to the file "F1Championship.txt"
    void saveInFile();

    //To view all the details in a GUI.
    void displayGUI();

}
