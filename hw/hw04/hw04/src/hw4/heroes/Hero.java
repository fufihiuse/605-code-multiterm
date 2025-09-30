package hw4.heroes;

import hw4.game.Team;
import hw4.heroes.Heroes.Role;

/**
 * The Hero abstract class, used to create different types of hero
 * @author Jackson Majewski     jdm1631@rit.edu
 */
public abstract class Hero {
    /** The max health of the Hero */
    protected int maxHitPoints;
    /** The current health of the Hero */
    protected int hitPoints;
    /** The damage the hero deals per attack */
    protected int atkDamage;
    /** The name of the Hero */
    protected String name;
    /** The hero's role */
    protected Role role;
    /** Whether the hero has died */
    protected boolean hasFallen;

    /**
     * Hero constructor, should only be called by a subclass
     * @param name the hero's name
     * @param maxHitPoints the max health for the hero
     * @param atkDamage the damage the hero deals per-attack
     * @param role the hero's role
     */
    protected Hero(String name, int maxHitPoints, int atkDamage, Role role) {
        this.name = name;
        this.maxHitPoints = maxHitPoints;
        this.hitPoints = maxHitPoints;
        this.atkDamage = atkDamage;
        this.role = role;
    }

    /**
     * Used to attack another hero
     * @param target the hero to attack
     */
    public void attack(Hero target) {
        target.takeDamage(atkDamage);
    }

    /**
     * Gets the hero's name
     * @return the hero's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the hero's role
     * @return the hero's role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Gets whether the hero has died
     * @return true if the hero has died, false if the hero is still alive
     */
    public boolean hasFallen() {
        return hasFallen;
    }

    /**
     * Used to heal the Hero
     * @param amount the amount to heal the hero by (capped at max health)
     */
    public void heal(int amount) {
        System.out.println(name + "heals " + amount + "points");
        hitPoints = Math.min(hitPoints + amount, maxHitPoints);
    }

    /**
     * Used during an attack to decrease the health of the hero
     * @param amount the amount to decrease the hero's health by
     */
    public void takeDamage(int amount) {
        System.out.println(name + " takes " + amount + " damage");
        hitPoints -= amount;

        if (hitPoints > 0) {
            return;
        }

        // If health drops to 0 or below
        System.out.println(name + " has fallen!");
        hasFallen = true;
    }

    /**
     * Builds the Hero's status as a string
     * @return the hero's status
     */
    @Override
    public String toString() {
        return name + ", " + role + ", " + hitPoints + "/" + maxHitPoints;
    }

    /**
     * An abstract factory used to create a Hero of type Berserker, Healer, or Tank
     * @param role the new hero's role
     * @param team the team the new hero is a member of
     * @param party the party the new hero is a member of
     * @return the created hero
     */
    public static Hero create(Role role, Team team, Party party) {
        return switch (role) {
            case Role.BERSERKER -> new Berserker(team);
            case Role.HEALER -> new Healer(team, party);
            case Role.TANK -> new Tank(team);
        };
    }
}
