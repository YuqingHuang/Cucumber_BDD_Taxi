package workshop;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class TaxiFareTest {
    private TaxiFareRule taxiFareRule;

    @Before
    public void setUp() {
        TaxiFareRule mockTaxiFareRule = spy(TaxiFareRule.class);
        when(mockTaxiFareRule.getDayStartingFare()).thenReturn(14.0D);

        taxiFareRule = mockTaxiFareRule;
    }

    @Test
    public void should_pay_14_when_taxi_started_at_8am_and_finshed_with_3_km() {
        LocalTime startingTime = LocalTime.parse("08:00");
        int distance = 3;
        Taxi taxi = new Taxi(startingTime, distance, taxiFareRule);

        taxi.calculateTaxiFare();

        assertEquals(14, taxi.fare(), 0.0);
    }


    @Test
    public void should_pay_19_when_taxi_started_at_8am_and_finshed_with_5_km() {
        LocalTime startingTime = LocalTime.parse("08:00");
        int distance = 5;
        Taxi taxi = new Taxi(startingTime, distance, taxiFareRule);

        taxi.calculateTaxiFare();

        assertEquals(19, taxi.fare(), 0.0);
    }

    @Test
    public void should_pay_18_when_taxi_started_at_23pm_and_finshed_with_3_km() {
        LocalTime startingTime = LocalTime.parse("23:00");
        int distance = 3;
        Taxi taxi = new Taxi(startingTime, distance, taxiFareRule);

        taxi.calculateTaxiFare();

        assertEquals(18, taxi.fare(), 0.0);
    }

    @Test
    public void should_pay_18_when_taxi_started_at_half_past_23pm_and_finshed_with_3_km() {
        LocalTime startingTime = LocalTime.parse("23:30");
        int distance = 3;
        Taxi taxi = new Taxi(startingTime, distance, taxiFareRule);

        taxi.calculateTaxiFare();

        assertEquals(18, taxi.fare(), 0.0);
    }

    @Test
    public void should_pay_18_when_taxi_started_at_5am_and_finshed_with_3_km() {
        LocalTime startingTime = LocalTime.parse("05:00");
        int distance = 3;
        Taxi taxi = new Taxi(startingTime, distance, taxiFareRule);

        taxi.calculateTaxiFare();

        assertEquals(18, taxi.fare(), 0.0);
    }

    @Test
    public void should_pay_25_when_taxi_started_at_5am_and_finshed_with_5_km() {
        LocalTime startingTime = LocalTime.parse("05:00");
        int distance = 5;
        Taxi taxi = new Taxi(startingTime, distance, taxiFareRule);

        taxi.calculateTaxiFare();

        assertEquals(25, taxi.fare(), 0.0);
    }
}
