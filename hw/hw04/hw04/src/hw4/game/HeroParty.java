package hw4.game;

import hw4.heroes.Hero;
import hw4.heroes.Heroes;
import hw4.heroes.Party;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * HeroParty is an implementation of Party that tracks 3 heroes on the same team
 * @author Jackson Majewski     jdm1631@rit.edu
 * @author Vrutant Chaudhari    vc2999@rit.edu
 */
public class HeroParty implements Party {
    /** The team each party is assigned to */
    private final Team team;
    /** The heroes that are part of this party */
    private final ArrayList<Hero> heroes;


    /**
     * Creates a HeroParty containing one BERSERKER, HEALER, and TANK
     * @param team which team there heroes should be on, of type Team
     * @param seed seed used to shuffle the order of the team
     */
    HeroParty(Team team, int seed) {
        // Create heroes
        this.team = team;
        this.heroes = new ArrayList<Hero>(3);
        this.heroes.add(Hero.create(Heroes.Role.BERSERKER, team, this));
        this.heroes.add(Hero.create(Heroes.Role.HEALER, team, this));
        this.heroes.add(Hero.create(Heroes.Role.TANK, team, this));

        // Shuffle by seed
        Collections.shuffle(this.heroes, new Random(seed));
    }

    /**
     * Adds a Hero to the party
     * @param hero the Hero to add
     */
    @Override
    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    /**
     * Removes the first hero in the list of heroes
     * @return the removed hero at index 0
     */
    @Override
    public Hero removeHero() {
        return heroes.removeFirst();
    }

    /**
     * Gives the number of heroes in the party
     * @return the number of Heroes in heroes
     */
    @Override
    public int numHeroes() {
        return heroes.size();
    }

    /**
     * Gives the party's team
     * @return the party's team as type Team
     */
    @Override
    public Team getTeam() {
        return team;
    }

    /**
     * Gets a list of the heroes in the party
     * @return a List of the heroes in the party
     */
    @Override
    public List<Hero> getHeroes() {
        return heroes;
    }

    /**
     * Creates a string containing the team name and stats
     * @return the info string for the party
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(team.toString());
        sb.append(":\n");
        for (Hero hero : heroes) {
            sb.append(hero.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
