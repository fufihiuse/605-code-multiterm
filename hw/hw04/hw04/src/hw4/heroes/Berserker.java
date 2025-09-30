package hw4.heroes;

import hw4.game.Team;
import hw4.heroes.Heroes;

/**
 * An extension of the Hero class for the Berserker role
 * @author Jackson Majewski     jdm1631@rit.edu
 */
public class Berserker extends Hero {

    /**
     * Creates the Berserker hero
     * @param team the team to assign the Berserker to
     */
    protected Berserker(Team team) {
        super(team == Team.DRAGON ? Heroes.DRAGON_BERSERKER : Heroes.LION_BERSERKER,
                30,
                20,
                Heroes.Role.BERSERKER
        );
    }
}
