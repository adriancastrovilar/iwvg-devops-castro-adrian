package es.upm.miw.iwvg_devops.code;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    private User user;

    @BeforeEach
    void before() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 1));
        fractions.add(new Fraction(2, 3));
        user = new User("1" , "adrian" , "castro" , fractions);
    }

    @Test
    void testUserInit() {
        assertEquals("1" , user.getId());
        assertEquals("adrian" , user.getName());
        assertEquals("castro" , user.getFamilyName());
        assertEquals(2, user.getFractions().get(1).getNumerator());
    }

    @Test
    void testUserEmptyConstructor() {
        user = new User();
        assertEquals(new ArrayList<>(), user.getFractions());
    }

    @Test
    void testAddFraction() {
        user = new User();
        user.addFraction(new Fraction(4, 8));
        assertEquals(4, user.getFractions().get(user.getFractions().size() - 1).getNumerator());
        assertEquals(8, user.getFractions().get(user.getFractions().size() - 1).getDenominator());
    }

    @Test
    void testFullName() {
        String expectedFullName = "adrian castro";
        assertEquals(expectedFullName, user.fullName());
    }

    @Test
    void testInitials() {
        String expectedInitials = "a.";
        assertEquals(expectedInitials, user.initials());
    }

    @Test
    void testToString() {
        String expectedString = "User{id='1', name='adrian', familyName='castro', " +
                "fractions=[Fraction{numerator=1, denominator=1}, Fraction{numerator=2, denominator=3}]}";
        assertEquals(expectedString, user.toString());
    }

    @Test
    void testSetters() {
        user.setName("Adrian");
        user.setFamilyName("Castro");
        user.setFractions(new ArrayList<>());
        assertEquals("Adrian" , user.getName());
        assertEquals("Castro" , user.getFamilyName());
        assertEquals(new ArrayList<>(), user.getFractions());
    }
}
