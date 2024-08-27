import java.io.Serializable;

public class ConstructorTeam implements Serializable {

    private String teamName;
    //Constructor Team must know about the driver that it has currently.
    private Driver driver;

    public ConstructorTeam(String teamName){
        this.teamName = teamName;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getTeamName() {
        return teamName;
    }

    public Driver getDriver() {
        return driver;
    }
}
