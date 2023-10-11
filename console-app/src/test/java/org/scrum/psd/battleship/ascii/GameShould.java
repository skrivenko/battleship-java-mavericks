package org.scrum.psd.battleship.ascii;

import org.junit.Test;
import org.scrum.psd.battleship.controller.dto.Color;
import org.scrum.psd.battleship.controller.dto.Letter;
import org.scrum.psd.battleship.controller.dto.Position;
import org.scrum.psd.battleship.controller.dto.Ship;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameShould {

    @Test
    public void createFirtFieldIfSetupNumberIs1() {
        List<Ship> ships = Arrays.asList(
                new Ship("Aircraft Carrier", 5, Color.CADET_BLUE, Arrays.asList(
                        new Position(Letter.C, 2),
                        new Position(Letter.D, 2),
                        new Position(Letter.E, 2),
                        new Position(Letter.F, 2),
                        new Position(Letter.G, 2)
                )),
                new Ship("Battleship", 4, Color.RED, Arrays.asList(
                        new Position(Letter.H, 4),
                        new Position(Letter.H, 5),
                        new Position(Letter.H, 6),
                        new Position(Letter.H, 7)
                )),
                new Ship("Submarine", 3, Color.CHARTREUSE, Arrays.asList(
                        new Position(Letter.A, 1),
                        new Position(Letter.B, 1),
                        new Position(Letter.C, 1)
                )),
                new Ship("Destroyer", 3, Color.YELLOW, Arrays.asList(
                        new Position(Letter.C, 8),
                        new Position(Letter.D, 8),
                        new Position(Letter.E, 8)
                )),
                new Ship("Patrol Boat", 2, Color.ORANGE, Arrays.asList(
                        new Position(Letter.C, 5),
                        new Position(Letter.C, 6)
                )));

        ShipsFactory shipsFactory = new ShipsFactory(new SetupGenerator() {
            @Override
            public int generateSetupNumber() {
                return 1;
            }
        });
        assertArrayEquals(ships.toArray(), shipsFactory.createShips().toArray());
    }

    @Test
    public void showCorrectRandomSetups() {
        RandomSetupGenerator generator = new RandomSetupGenerator();
        for (int i = 0; i < 10; i++) {
            int setupNumber = generator.generateSetupNumber();
            assertTrue(setupNumber <= 5);
            assertTrue(setupNumber >= 1);
        }
    }

    @Test
    public void showCreateOneOfTheRandomSetups() {

        RandomSetupGenerator generator = new RandomSetupGenerator();
        ShipsFactory factory = new ShipsFactory(generator);

        for (int i = 0; i < 10; i++) {
           assertTrue(ShipsFactory.SETUPS.containsValue(factory.createShips()));
        }
    }
}
