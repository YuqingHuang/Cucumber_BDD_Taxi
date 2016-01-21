package workshop;

import java.time.LocalTime;

/**
 * Created by twer on 1/21/16.
 */
public class Taxi {

    private LocalTime startingTime;
    private int distance;
    private TaxiFareRule taxiFareRule;
    private double taxiFare;

    public Taxi(LocalTime startingTime, int distance, TaxiFareRule taxiFareRule) {
        this.startingTime = startingTime;
        this.distance = distance;
        this.taxiFareRule = taxiFareRule;
    }

    public void calculateTaxiFare() {
        taxiFare = calculateStartingFare() + calculateBeyondStartingFare(calculateAfterRate());
    }

    private double calculateStartingFare() {
        double startingFare = taxiFareRule.getDayStartingFare();
        if (inNightRange(startingTime)) {
            startingFare = taxiFareRule.getNightStartingFare();
        }
        return startingFare;
    }

    private boolean inNightRange(LocalTime startingTime) {
        return startingTime.equals(taxiFareRule.getNightStartingTime()) || startingTime.isAfter(taxiFareRule.getNightStartingTime())
                || startingTime.isBefore(taxiFareRule.getNightEndTime());
    }

    private double calculateBeyondStartingFare(double afterRate) {
        double beyondStartingFare = afterRate * (distance - taxiFareRule.getStartingDistance());
        if (distance <= taxiFareRule.getStartingDistance()) {
            beyondStartingFare = 0;
        }

        return beyondStartingFare;
    }

    private double calculateAfterRate() {
        double afterRate = taxiFareRule.getDayAfterRate();
        if (inNightRange(startingTime)) {
            afterRate = taxiFareRule.getNightAfterRate();
        }
        return afterRate;
    }

    public double fare() {
        return taxiFare;
    }
}
