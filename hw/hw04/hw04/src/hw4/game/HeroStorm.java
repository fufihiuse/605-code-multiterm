package hw4.game;

import hw4.heroes.Hero;

/**
 * The HeroStorm class controls the main operation of the program
 * and includes the main method
 *
 * @author Jackson Majewski     jdm1631@rit.edu
 * @author Vrutant Chaudhari    vc2999@rit.edu
 */
public class HeroStorm {
    /** The party for team Dragon */
    private final HeroParty dragonParty;
    /** The party for team Lion */
    private final HeroParty lionParty;
    /** The number of the current battle */
    private int battleNumber;
    /** Toggle that tracks whether the dragon party goes first*/
    private boolean dragonFirst;

    /**
     * The constructor for the HeroStorm game
     * @param dragonSeed the seed used to shuffle the dragon's team order
     * @param lionSeed the seed used to shuffle the lion's team order
     */
    public HeroStorm(int dragonSeed, int lionSeed) {
        dragonParty = new HeroParty(Team.DRAGON, dragonSeed);
        lionParty = new HeroParty(Team.LION, lionSeed);
        battleNumber = 0;
        dragonFirst = true;
    }

    /**
     * The main gameplay loop for HeroStrom
     */
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

            // If second hero is still alive, attack and re-add, otherwise print death message
            if (!secondHero.hasFallen()) {
                secondHero.attack(firstHero);
                if (dragonFirst) {
                    lionParty.addHero(secondHero);
                } else {
                    dragonParty.addHero(secondHero);
                }
            }
            else {
                System.out.println(secondHero.getName() + " has fallen!");
            }

            // Re-add first hero if they're still alive, otherwise print death message
            if (!firstHero.hasFallen()) {
                if (dragonFirst) {
                    dragonParty.addHero(firstHero);
                } else {
                    lionParty.addHero(firstHero);
                }
            }
            else {
                System.out.println(firstHero.getName() + " has fallen!");
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
     * The main method, used to parse arguments and start the gameplay loop
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
