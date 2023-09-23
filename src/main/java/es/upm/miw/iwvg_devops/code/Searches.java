package es.upm.miw.iwvg_devops.code;

import java.util.List;
import java.util.stream.Stream;

public class Searches {

    public Stream<String> findUserFamilyNameInitialBySomeProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream().anyMatch(Fraction::isProper))
                .map(User::getFamilyName);
    }
}
