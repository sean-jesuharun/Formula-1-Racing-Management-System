import java.io.Serializable;

public abstract class Driver implements Serializable{

    private String driverName;
    private String driverLocation;
    //Driver Should know about the current Constructor team that he belongs.
    private ConstructorTeam team;

    public Driver(String driverName, String driverLocation, ConstructorTeam team){
        this.driverName = driverName;
        this.driverLocation = driverLocation;
        this.team = team;
    }
    public Driver(String driverName, String driverLocation){
        this.driverName = driverName;
        this.driverLocation = driverLocation;
    }

    public ConstructorTeam getTeam() {
        return team;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setTeam(ConstructorTeam team) {
        this.team = team;
    }

    public String getDriverLocation() {
        return driverLocation;
    }
}
