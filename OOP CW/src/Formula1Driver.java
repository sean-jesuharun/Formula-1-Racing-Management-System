import java.util.HashMap;

public class Formula1Driver extends Driver {

    //To store all the statistics about the position in the Races.
    private HashMap<Integer, Integer> statistics;
    private int currentPoints;
    private int noOfRaces;

    //constructor 1 with a Team.
    public Formula1Driver(String driverName, String driverLocation, ConstructorTeam team, HashMap<Integer, Integer> statistics){
        super(driverName,driverLocation,team);
        this.statistics = statistics;
        calculatePointsAndNoOfRaces();
    }
    //constructor 2 without a Team.
    public Formula1Driver(String driverName, String driverLocation, HashMap<Integer, Integer> statistics){
        super(driverName,driverLocation);
        this.statistics = statistics;
        calculatePointsAndNoOfRaces();
    }


    public void calculatePointsAndNoOfRaces(){

        //Setting the currentPoints and noOfRaces values as 0. So we can calculate it again.
        this.currentPoints = 0;
        this.noOfRaces = 0;

        for(int key : statistics.keySet()){

            int times = this.statistics.get(key);

            switch (key){
                case 1:
                    this.currentPoints = this.currentPoints + 25 * times;
                    break;
                case 2:
                    this.currentPoints = this.currentPoints + 18 * times;
                    break;
                case 3:
                    this.currentPoints = this.currentPoints + 15 * times;
                    break;
                case 4:
                    this.currentPoints = this.currentPoints + 12 * times;
                    break;
                case 5:
                    this.currentPoints = this.currentPoints + 10 * times;
                    break;
                case 6:
                    this.currentPoints = this.currentPoints + 8 * times;
                    break;
                case 7:
                    this.currentPoints = this.currentPoints + 6 * times;
                    break;
                case 8:
                    this.currentPoints = this.currentPoints + 4 * times;
                    break;
                case 9:
                    this.currentPoints = this.currentPoints + 2 * times;
                    break;
                case 10:
                    this.currentPoints = this.currentPoints + times;
                    break;
                default:
            }

            this.noOfRaces = this.noOfRaces + times;
        }
    }

    public HashMap<Integer, Integer> getStatistics() {
        return statistics;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public int getNoOfRaces() {
        return noOfRaces;
    }

    public void updateStatistics(int position, int times){
        this.statistics.put(position, times);
    }
}
