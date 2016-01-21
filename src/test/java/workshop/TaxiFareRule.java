package workshop;

import java.time.LocalTime;

/**
 * Created by twer on 1/21/16.
 */
public class TaxiFareRule {
    double DAY_STARTING_FARE = 14.0D;
    double DAY_AFTER_RATE = 2.5;
    int STARTING_DISTANCE = 3;
    double NIGHT_STARTING_FARE = 18.0D;
    LocalTime NIGHT_STARTING_TIME = LocalTime.parse("23:00");
    LocalTime NIGHT_END_TIME = LocalTime.parse("06:00");
    double NIGHT_AFTER_RATE = 3.5D;

    public double getDayStartingFare() {
        return 0;
    }

    public double getDayAfterRate() {
        return DAY_AFTER_RATE;
    }

    public int getStartingDistance() {
        return STARTING_DISTANCE;
    }

    public double getNightStartingFare() {
        return NIGHT_STARTING_FARE;
    }

    public LocalTime getNightStartingTime() {
        return NIGHT_STARTING_TIME;
    }

    public LocalTime getNightEndTime() {
        return NIGHT_END_TIME;
    }

    public double getNightAfterRate() {
        return NIGHT_AFTER_RATE;
    }
}
