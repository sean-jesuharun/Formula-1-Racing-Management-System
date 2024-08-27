import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

public class Race implements Serializable {

    private String raceName;
    private LocalDate raceDate;
    //To hold all the details about the positions and the driver who got that position in a Race.
    private HashMap<Integer, String> raceDetails;

    public Race(String raceName, LocalDate raceDate, HashMap<Integer, String> raceDetails){
        this.raceName = raceName;
        this.raceDate = raceDate;
        this.raceDetails = raceDetails;
    }

    public LocalDate getRaceDate() {
        return raceDate;
    }

    public String getRaceName() {
        return raceName;
    }

    public HashMap<Integer, String> getRaceDetails() {
        return raceDetails;
    }
}
