package hw4.heroes;

import hw4.game.Team;
import java.util.List;

/**
 * An interface used as a blueprint for Party
 * @author Jackson Majewski     jdm1631@rit.edu
 * @author Vrutant Chaudhari    vc2999@rit.edu
 */
public interface Party {
    /**
     * Adds a hero to the party
     * @param hero the hero to add
     */
    void addHero(Hero hero);

    /**
     * Removes a hero from the party
     * @return the hero that was removed
     */
    Hero removeHero();

    /**
     * Gets the number of heroes in the party
     * @return the number of heroes in the party
     */
    int numHeroes();

    /**
     * Gets the Team the party is fighting for
     * @return the party's Team
     */
    Team getTeam();

    /**
     * Gets the list of heroes in the party
     * @return a List of heroes in the party
     */
    List<Hero> getHeroes();
}
