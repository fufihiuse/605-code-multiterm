package hw4.heroes;

import hw4.game.Team;
import hw4.heroes.Heroes;

/**
 * An extension of the Hero class for the Tank role
 * @author Jackson Majewski     jdm1631@rit.edu
 * @author Vrutant Chaudhari    vc2999@rit.edu
 */
public class Tank extends Hero {
    /** Amount of damage Tank deflects with its shield */
    double defense;

    /**
     * Creates the Tank hero
     * @param team the team to assign the Tank to
     */
    protected Tank(Team team) {
        defense = 0.1;

        super(team == Team.DRAGON ? Heroes.DRAGON_TANK : Heroes.LION_TANK,
                40,
                15,
                Heroes.Role.TANK
        );
    }

    /**
     * Decreases the tanks health, taking the Tank's shield into account
     * @param amount the amount to decrease the hero's health by
     */
    @Override
    public void takeDamage(int amount) {
        // Takes away amount blocked by shield
        amount -= (int) Math.round(amount * defense);
        super.takeDamage(amount);
    }
}
