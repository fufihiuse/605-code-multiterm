package hw4.heroes;

import hw4.game.Team;
import hw4.heroes.Heroes;

public class Berserker extends Hero {

    protected Berserker(Team team) {
        super(team == Team.DRAGON ? Heroes.DRAGON_BERSERKER : Heroes.LION_BERSERKER,
                30,
                20,
                Heroes.Role.BERSERKER
        );
    }
}
