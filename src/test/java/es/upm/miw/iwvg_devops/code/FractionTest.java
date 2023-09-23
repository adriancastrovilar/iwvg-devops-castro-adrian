package es.upm.miw.iwvg_devops.code;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {

    private Fraction fraction;

    @BeforeEach
    void before() {
        fraction = new Fraction(2, 3);
    }

    @Test
    void testFractionInit() {
        assertEquals(2, fraction.getNumerator());
        assertEquals(3, fraction.getDenominator());
    }

    @Test
    void testFractionEmptyConstructor() {
        fraction = new Fraction();
        assertEquals(1, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        assertEquals(0.666, fraction.decimal(), 10e-3);
    }

    @Test
    void testSetters() {
        fraction.setNumerator(5);
        fraction.setDenominator(8);
        assertEquals(5, fraction.getNumerator());
        assertEquals(8, fraction.getDenominator());
    }

    @Test
    void testToString() {
        String expectedString = "Fraction{numerator=2, denominator=3}";
        assertEquals(expectedString, fraction.toString());
    }
}
