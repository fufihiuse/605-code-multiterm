package hw4.game;

import hw4.heroes.Berserker;
import hw4.heroes.Hero;
import hw4.heroes.Heroes;
import hw4.heroes.Party;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HeroParty implements Party {
    /** The team each party is assigned to */
    private final Team team;
    private final ArrayList<Hero> heroes;


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

    @Override
    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    @Override
    public Hero removeHero() {
        return heroes.removeFirst();
    }

    @Override
    public int numHeroes() {
        return heroes.size();
    }

    @Override
    public Team getTeam() {
        return team;
    }

    @Override
    public List<Hero> getHeroes() {
        return heroes;
    }

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
