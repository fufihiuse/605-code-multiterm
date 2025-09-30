package hw4.heroes;

import hw4.game.Team;

/**
 * An extension of the Hero class for the Healer role
 * @author Jackson Majewski     jdm1631@rit.edu
 */
public class Healer extends Hero {
    /** Amount of health Healer can restore to living allies (including itself) */
    int healAmount;
    /** The party this healer is a part of */
    Party party;

    /**
     * Creates the Healer hero
     * @param team the team to assign the Healer to
     * @param party the party the healer should heal during its attack
     */
    protected Healer(Team team, Party party) {
        healAmount = 10;
        this.party = party;

        super(team == Team.DRAGON ? Heroes.DRAGON_HEALER : Heroes.LION_HEALER,
                35,
                10,
                Heroes.Role.HEALER
        );
    }

    /**
     * Heals the healer and its party, then attacks
     * @param target the hero to attack
     */
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
