package dalTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dal.HashCalculator;

class HashCalculatorTest {

    @Test
    void testSameInputProducesSameHash() throws Exception {

        String text = "Hello World";

        String hash1 = HashCalculator.calculateHash(text);
        String hash2 = HashCalculator.calculateHash(text);

        assertEquals(hash1, hash2);
    }

    @Test
    void testDifferentInputProducesDifferentHash() throws Exception {

        String text1 = "Hello World";
        String text2 = "Hello World Edited";

        String hash1 = HashCalculator.calculateHash(text1);
        String hash2 = HashCalculator.calculateHash(text2);

        assertNotEquals(hash1, hash2);
    }

    @Test
    void testHashIsNotNullOrEmpty() throws Exception {

        String text = "Test";

        String hash = HashCalculator.calculateHash(text);

        assertNotNull(hash);
        assertFalse(hash.isEmpty());
        assertEquals(32, hash.length()); // MD5 = 32 hex chars
    }
}
