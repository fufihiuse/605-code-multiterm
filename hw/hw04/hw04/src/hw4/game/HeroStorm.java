package hw4.game;

import hw4.game.HeroParty;
import hw4.heroes.Hero;

/**
 * the HeroStorm class controls the main operation of the program
 * and includes the main method
 *
 * @author Jackson Majewski     jdm1631@rit.edu
 */
public class HeroStorm {
    private final HeroParty dragonParty;
    private final HeroParty lionParty;
    private int battleNumber;
    private boolean dragonFirst;

    public HeroStorm(int dragonSeed, int lionSeed) {
        dragonParty = new HeroParty(Team.DRAGON, dragonSeed);
        lionParty = new HeroParty(Team.LION, lionSeed);
        battleNumber = 0;
        dragonFirst = true;
    }

    void play() {
        while (dragonParty.numHeroes() > 0 && lionParty.numHeroes() > 0) {
            // Create Heroes
            Hero firstHero;
            Hero secondHero;

            // Current battle number
            System.out.println("Battle #" + ++battleNumber);
            System.out.println("==========");

            // Print out current stats
            System.out.println(dragonParty);
            System.out.println(lionParty);

            // Get current dragon and lion
            if (dragonFirst) {
                firstHero = dragonParty.removeHero();
                secondHero = lionParty.removeHero();
            } else {
                firstHero = lionParty.removeHero();
                secondHero = dragonParty.removeHero();
            }

            // Begin fight
            System.out.println("*** " + firstHero.getName() + " vs " + secondHero.getName() + "!\n");

            firstHero.attack(secondHero);

            // If second hero is still alive, attack and re-add
            if (!secondHero.hasFallen()) {
                secondHero.attack(firstHero);
                if (dragonFirst) {
                    lionParty.addHero(secondHero);
                } else {
                    dragonParty.addHero(secondHero);
                }
            }

            // Re-add first hero if they're still alive
            if (!firstHero.hasFallen()) {
                if (dragonFirst) {
                    dragonParty.addHero(firstHero);
                } else {
                    lionParty.addHero(firstHero);
                }
            }
            // Toggle who goes first
            dragonFirst = !dragonFirst;

            // Print empty line for spacing
            System.out.println();
        }

        if(dragonParty.numHeroes() > 0) {
            System.out.println("Team Dragon wins!");
        }
        else {
            System.out.println("Team Lion wins!");
        }

    }

    /**
     * The main method
     *
     * @param args dragon_seed_# and lion_seed_#
     */
    public static void main(String[] args) {
        // Check number of arguments
        if (args.length != 2) {
            System.err.println("Usage: java HeroStorm dragon_seed_# lion_seed_#");
            System.exit(1);
        }

        // Create and start game loop
        HeroStorm game = new HeroStorm(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        game.play();
    }
}
