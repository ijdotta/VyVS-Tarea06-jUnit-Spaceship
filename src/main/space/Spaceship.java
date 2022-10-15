package space;

public class Spaceship {

    private static class DamageConstants {
        public static final double ASTEROID_DAMAGE = 15.0;
        public static final double PLANET_DAMAGE = 75.0;
        public static final double SPACESHIP_DAMAGE = 55.0;
    }

    public enum Obstacles {ASTEROID, PLANET, SPACESHIP}
    private static final double INITIAL_FUEL = 100.0;
    private static final double INITIAL_HEALTH = 100.0;
    private static final double FUEL_COST_PER_METER = 7.5;
    private double fuel;
    private double health;

    public Spaceship() {
        this.fuel = Spaceship.INITIAL_FUEL;
        this.health = Spaceship.INITIAL_HEALTH;
    }

    public double getFuel() {
        return fuel;
    }

    public double getHealth() {
        return health;
    }

    public void hit(Obstacles obstacle) {
        switch (obstacle) {
            case ASTEROID -> health -= Spaceship.DamageConstants.ASTEROID_DAMAGE;
            case PLANET -> health -= Spaceship.DamageConstants.PLANET_DAMAGE;
            case SPACESHIP -> health -= Spaceship.DamageConstants.SPACESHIP_DAMAGE;
        }
    }

    public void accelerate(double meters) throws OutOfFuelException {
        fuel -= meters * Spaceship.FUEL_COST_PER_METER;
        if (fuel <= 0) {
            fuel = 0;
            throw new OutOfFuelException("Out of fuel.");
        }
    }

    public void crash() {
        health = 0;
        fuel = 0;
    }

}
