package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SearchesTest {

    @Test
    void testfindUserFamilyNameInitialBySomeProperFraction() {
        assertEquals(List.of("Fernandez", "Blanco", "López"), new Searches().findUserFamilyNameInitialBySomeProperFraction()
                .distinct()
                .collect(Collectors.toList()));
    }
}
