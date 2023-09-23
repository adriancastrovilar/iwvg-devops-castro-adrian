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

    @Test
    void testIsProper() {
        Fraction properFraction = new Fraction(1, 2);
        Fraction improperFraction = new Fraction(2, 1);
        assertTrue(properFraction.isProper());
        assertFalse(improperFraction.isProper());
    }

    @Test
    void testIsImproper() {
        Fraction properFraction = new Fraction(1, 2);
        Fraction improperFraction = new Fraction(2, 1);
        assertTrue(improperFraction.isImproper());
        assertFalse(properFraction.isImproper());
    }

    @Test
    void testIsEquivalent() {
        Fraction equivalentFraction = new Fraction(fraction.getNumerator(), fraction.getDenominator());
        assertTrue(fraction.isEquivalent(equivalentFraction));
        assertFalse(fraction.isEquivalent(new Fraction()));
    }

    @Test
    void testAddEqualDenominators() {
        Fraction addedFraction = fraction.add(fraction);
        assertEquals(fraction.getNumerator() * 2, addedFraction.getNumerator());
        assertEquals(fraction.getDenominator(), addedFraction.getDenominator());
    }

    @Test
    void testAddDifferentDenominators() {
        Fraction fractionToAdd = new Fraction();
        Fraction addedFraction = fraction.add(fractionToAdd);
        assertEquals(5, addedFraction.getNumerator());
        assertEquals(fraction.getDenominator() * fractionToAdd.getDenominator(), addedFraction.getDenominator());
    }

    @Test
    void testMultiply() {
        Fraction multipliedFraction = fraction.multiply(fraction);
        assertEquals(4, multipliedFraction.getNumerator());
        assertEquals(9, multipliedFraction.getDenominator());
    }

    @Test
    void testDivide() {
        Fraction fractionToDivide = new Fraction(5, 6);
        Fraction dividedFraction = fraction.divide(fractionToDivide);
        assertEquals(4, dividedFraction.getNumerator());
        assertEquals(5, dividedFraction.getDenominator());
    }
}
