package hw4.heroes;

import hw4.game.Team;
import hw4.heroes.Heroes;

public class Tank extends Hero {
    /** Amount of damage Tank deflects with its shield */
    double defense;

    protected Tank(Team team) {
        defense = 0.1;

        super(team == Team.DRAGON ? Heroes.DRAGON_TANK : Heroes.LION_TANK,
                40,
                15,
                Heroes.Role.TANK
        );
    }

    @Override
    public void takeDamage(int amount) {
        // Takes away amount blocked by shield
        amount -= (int) (amount - (amount * defense));
        super.takeDamage(amount);
    }
}
