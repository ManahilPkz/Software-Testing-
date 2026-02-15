package dalTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dal.TFIDFCalculator;

class TFIDFCalculatorTest {

    private TFIDFCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new TFIDFCalculator();

        calculator.addDocumentToCorpus("apple banana apple");
        calculator.addDocumentToCorpus("banana orange");
        calculator.addDocumentToCorpus("apple orange orange");
    }

    @Test
    void testCalculateDocumentTfIdf_Positive() {

        double result = calculator.calculateDocumentTfIdf("apple banana");

        assertTrue(Double.isFinite(result));
    }

    @Test
    void testCalculateDocumentTfIdf_Empty() {

        double result = calculator.calculateDocumentTfIdf("");

        assertEquals(0.0, result);
    }

    @Test
    void testCalculateDocumentTfIdf_Special() {

        double result = calculator.calculateDocumentTfIdf("@@@ ### $$$");

        assertTrue(result == 0.0 || Double.isFinite(result));
    }
}

