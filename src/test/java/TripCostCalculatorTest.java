import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TripCostCalculatorTest {


    @Test
    void addTrainingSession() {

        assertEquals(20.0, TripCostCalculator.CalculateTripCost(200, 2, 5));

        assertEquals(0.0, TripCostCalculator.CalculateTripCost(200, 0, 50));

        assertEquals(0.0, TripCostCalculator.CalculateTripCost(0, 2, 5));

        assertEquals(18.0, TripCostCalculator.CalculateTripCost(200, 1.8, 5));


    }

}