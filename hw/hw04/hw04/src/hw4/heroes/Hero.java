package hw4.heroes;

import hw4.game.Team;
import hw4.heroes.Heroes.Role;

public abstract class Hero {
    protected int maxHitPoints;
    protected int hitPoints;
    protected int atkDamage;
    protected String name;
    protected Role role;
    protected boolean hasFallen;

    protected Hero(String name, int maxHitPoints, int atkDamage, Role role) {
        this.name = name;
        this.maxHitPoints = maxHitPoints;
        this.hitPoints = maxHitPoints;
        this.atkDamage = atkDamage;
        this.role = role;
    }

    public void attack(Hero target) {
        target.takeDamage(atkDamage);
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public boolean hasFallen() {
        return hasFallen;
    }

    public void heal(int amount) {
        System.out.println(name + "heals " + amount + "points");
        hitPoints = Math.min(hitPoints + amount, maxHitPoints);
    }

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

    @Override
    public String toString() {
        return name + ", " + role + ", " + hitPoints + "/" + maxHitPoints;
    }


    public static Hero create(Role role, Team team, Party party) {
        return switch (role) {
            case Role.BERSERKER -> new Berserker(team);
            case Role.HEALER -> new Healer(team, party);
            case Role.TANK -> new Tank(team);
        };
    }
}
