package hw4.heroes;

import hw4.game.Team;

public class Healer extends Hero {
    /** Amount of health Healer can restore to living allies (including itself) */
    int healAmount;
    /** The party this healer is a part of */
    Party party;

    protected Healer(Team team, Party party) {
        healAmount = 10;
        this.party = party;

        super(team == Team.DRAGON ? Heroes.DRAGON_HEALER : Heroes.LION_HEALER,
                35,
                10,
                Heroes.Role.HEALER
        );
    }

    @Override
    public void attack(Hero target) {
        // Heal self first
        this.heal(healAmount);

        // Then rest of party
        for (Hero hero : party.getHeroes()) {
            hero.heal(healAmount);
        }

        // Finally, attack target
        super.attack(target);
    }
}
