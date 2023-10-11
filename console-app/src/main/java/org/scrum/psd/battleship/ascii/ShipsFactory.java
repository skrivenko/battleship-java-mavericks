package org.scrum.psd.battleship.ascii;

import org.scrum.psd.battleship.controller.dto.Color;
import org.scrum.psd.battleship.controller.dto.Letter;
import org.scrum.psd.battleship.controller.dto.Position;
import org.scrum.psd.battleship.controller.dto.Ship;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShipsFactory {

    public static final Map<Integer, List<Ship>> SETUPS = new HashMap<>();

    static {
        SETUPS.put(1, Arrays.asList(
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
                ))));

        SETUPS.put(2, Arrays.asList(
                new Ship("Aircraft Carrier", 5, Color.CADET_BLUE, Arrays.asList(
                        new Position(Letter.C, 1),
                        new Position(Letter.D, 1),
                        new Position(Letter.E, 1),
                        new Position(Letter.F, 1),
                        new Position(Letter.G, 1)
                )),
                new Ship("Battleship", 4, Color.RED, Arrays.asList(
                        new Position(Letter.G, 4),
                        new Position(Letter.G, 5),
                        new Position(Letter.G, 6),
                        new Position(Letter.G, 7)
                )),
                new Ship("Submarine", 3, Color.CHARTREUSE, Arrays.asList(
                        new Position(Letter.E, 4),
                        new Position(Letter.E, 5),
                        new Position(Letter.E, 6)
                )),
                new Ship("Destroyer", 3, Color.YELLOW, Arrays.asList(
                        new Position(Letter.C, 8),
                        new Position(Letter.D, 8),
                        new Position(Letter.E, 8)
                )),
                new Ship("Patrol Boat", 2, Color.ORANGE, Arrays.asList(
                        new Position(Letter.A, 6),
                        new Position(Letter.B, 6)
                ))));

        SETUPS.put(3, Arrays.asList(
                new Ship("Aircraft Carrier", 5, Color.CADET_BLUE, Arrays.asList(
                        new Position(Letter.D, 1),
                        new Position(Letter.E, 1),
                        new Position(Letter.F, 1),
                        new Position(Letter.G, 1),
                        new Position(Letter.H, 1)
                )),
                new Ship("Battleship", 4, Color.RED, Arrays.asList(
                        new Position(Letter.E, 3),
                        new Position(Letter.F, 3),
                        new Position(Letter.G, 3),
                        new Position(Letter.H, 3)
                )),
                new Ship("Submarine", 3, Color.CHARTREUSE, Arrays.asList(
                        new Position(Letter.F, 5),
                        new Position(Letter.F, 6),
                        new Position(Letter.F, 7)
                )),
                new Ship("Destroyer", 3, Color.YELLOW, Arrays.asList(
                        new Position(Letter.B, 2),
                        new Position(Letter.B, 3),
                        new Position(Letter.B, 4)
                )),
                new Ship("Patrol Boat", 2, Color.ORANGE, Arrays.asList(
                        new Position(Letter.B, 7),
                        new Position(Letter.B, 8)
                ))));

        SETUPS.put(4, Arrays.asList(
                new Ship("Aircraft Carrier", 5, Color.CADET_BLUE, Arrays.asList(
                        new Position(Letter.B, 3),
                        new Position(Letter.B, 4),
                        new Position(Letter.B, 5),
                        new Position(Letter.B, 6),
                        new Position(Letter.B, 7)
                )),
                new Ship("Battleship", 4, Color.RED, Arrays.asList(
                        new Position(Letter.D, 1),
                        new Position(Letter.E, 1),
                        new Position(Letter.F, 1),
                        new Position(Letter.G, 1)
                )),
                new Ship("Submarine", 3, Color.CHARTREUSE, Arrays.asList(
                        new Position(Letter.D, 3),
                        new Position(Letter.E, 3),
                        new Position(Letter.F, 3)
                )),
                new Ship("Destroyer", 3, Color.YELLOW, Arrays.asList(
                        new Position(Letter.E, 5),
                        new Position(Letter.E, 6),
                        new Position(Letter.E, 7)
                )),
                new Ship("Patrol Boat", 2, Color.ORANGE, Arrays.asList(
                        new Position(Letter.H, 5),
                        new Position(Letter.H, 6)
                ))));

        SETUPS.put(5, Arrays.asList(
                new Ship("Aircraft Carrier", 5, Color.CADET_BLUE, Arrays.asList(
                        new Position(Letter.A, 2),
                        new Position(Letter.A, 3),
                        new Position(Letter.A, 4),
                        new Position(Letter.A, 5),
                        new Position(Letter.A, 6)
                )),
                new Ship("Battleship", 4, Color.RED, Arrays.asList(
                        new Position(Letter.C, 1),
                        new Position(Letter.D, 1),
                        new Position(Letter.E, 1),
                        new Position(Letter.F, 1)
                )),
                new Ship("Submarine", 3, Color.CHARTREUSE, Arrays.asList(
                        new Position(Letter.F, 3),
                        new Position(Letter.G, 3),
                        new Position(Letter.H, 3)
                )),
                new Ship("Destroyer", 3, Color.YELLOW, Arrays.asList(
                        new Position(Letter.D, 6),
                        new Position(Letter.D, 7),
                        new Position(Letter.D, 8)
                )),
                new Ship("Patrol Boat", 2, Color.ORANGE, Arrays.asList(
                        new Position(Letter.G, 8),
                        new Position(Letter.H, 8)
                ))));

    }

    private SetupGenerator setupGenerator;

    public ShipsFactory(SetupGenerator setupGenerator) {
        this.setupGenerator = setupGenerator;
    }

    public List<Ship> createShips() {
        return SETUPS.get(setupGenerator.generateSetupNumber());
    }
}
