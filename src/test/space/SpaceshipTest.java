package space;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpaceshipTest {

    private Spaceship spaceship;

    @BeforeEach
    public void setUp() {
        spaceship = new Spaceship();
    }

    @Test
    public void hitAsteroidDamage() {
        double fuel = spaceship.getFuel();
        double health = spaceship.getHealth();

        spaceship.hit(Spaceship.Obstacles.ASTEROID);

        assertEquals(health - 15.0, spaceship.getHealth());
        assertEquals(fuel, spaceship.getFuel());
    }

    @Test
    public void hitPlanetDamage() {
        double fuel = spaceship.getFuel();
        double health = spaceship.getHealth();

        spaceship.hit(Spaceship.Obstacles.PLANET);

        assertEquals(health - 75.0, spaceship.getHealth());
        assertEquals(fuel, spaceship.getFuel());
    }

    @Test
    public void hitSpaceshipDamage() {
        double fuel = spaceship.getFuel();
        double health = spaceship.getHealth();

        spaceship.hit(Spaceship.Obstacles.SPACESHIP);

        assertEquals(health - 55.0, spaceship.getHealth());
        assertEquals(fuel, spaceship.getFuel());
    }

    @Test
    public void accelerateWithEnoughFuel() {
        double fuel = spaceship.getFuel();
        double health = spaceship.getHealth();

        try {
            spaceship.accelerate(2);
        } catch (OutOfFuelException ignored) {}

        assertEquals(fuel - 15.0, spaceship.getFuel());
        assertEquals(health, spaceship.getHealth());
    }

    @Test
    public void accelerateWithoutEnoughFuel() {
        double health = spaceship.getHealth();

        assertThrows(OutOfFuelException.class, () -> spaceship.accelerate(1000));

        assertEquals(0, spaceship.getFuel());
        assertEquals(health, spaceship.getHealth());
    }

    @Test
    public void crashShouldEmptyFuelAndHealth() {
        spaceship.crash();

        assertEquals(0, spaceship.getFuel());
        assertEquals(0, spaceship.getHealth());
    }

}
