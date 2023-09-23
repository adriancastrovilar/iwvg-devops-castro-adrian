package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SearchesTest {

    @Test
    void testfindUserFamilyNameInitialBySomeProperFraction() {
        assertEquals(List.of("Fernandez", "Blanco", "López"), new Searches().findUserFamilyNameInitialBySomeProperFraction()
                .distinct()
                .collect(Collectors.toList()));
    }

    @Test
    void testFindDecimalImproperFractionByUserName() {
        assertEquals(List.of(2d, 1.3333333333333333d), new Searches().findDecimalImproperFractionByUserName("Ana").collect(Collectors.toList()));
    }

    @Test
    void testSuccessFindFirstProperFractionByUserId() {
        Fraction fraction = new Searches().findFirstProperFractionByUserId("1");
        assertEquals(0, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());

    }

    @Test
    void testFailFindFirstProperFractionByUserId() {
        assertThrows(IllegalArgumentException.class, () -> new Searches().findFirstProperFractionByUserId("-1"));
    }
}
