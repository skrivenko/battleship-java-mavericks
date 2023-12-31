package org.scrum.psd.battleship.ascii;

import org.scrum.psd.battleship.controller.GameController;
import org.scrum.psd.battleship.controller.dto.Letter;
import org.scrum.psd.battleship.controller.dto.Position;
import org.scrum.psd.battleship.controller.dto.Ship;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.MAGENTA_TEXT;

public class Main {
    private static List<Ship> myFleet;
    private static List<Ship> enemyFleet;

    private static final Telemetry telemetry = new Telemetry();
    private static final ShipsFactory shipsFactory = new ShipsFactory(new RandomSetupGenerator());

    public static void main(String[] args) {
        telemetry.trackEvent("ApplicationStarted", "Technology", "Java");
        System.out.println(colorize("                                     |__", MAGENTA_TEXT()));
        System.out.println(colorize("                                     |\\/", MAGENTA_TEXT()));
        System.out.println(colorize("                                     ---", MAGENTA_TEXT()));
        System.out.println(colorize("                                     / | [", MAGENTA_TEXT()));
        System.out.println(colorize("                              !      | |||", MAGENTA_TEXT()));
        System.out.println(colorize("                            _/|     _/|-++'", MAGENTA_TEXT()));
        System.out.println(colorize("                        +  +--|    |--|--|_ |-", MAGENTA_TEXT()));
        System.out.println(colorize("                     { /|__|  |/\\__|  |--- |||__/", MAGENTA_TEXT()));
        System.out.println(colorize("                    +---------------___[}-_===_.'____                 /\\", MAGENTA_TEXT()));
        System.out.println(colorize("                ____`-' ||___-{]_| _[}-  |     |_[___\\==--            \\/   _", MAGENTA_TEXT()));
        System.out.println(colorize(" __..._____--==/___]_|__|_____________________________[___\\==--____,------' .7", MAGENTA_TEXT()));
        System.out.println(colorize("|                        Welcome to Battleship                         BB-61/", MAGENTA_TEXT()));
        System.out.println(colorize(" \\_________________________________________________________________________|", MAGENTA_TEXT()));
        System.out.println("");

        InitializeGame();

        StartGame();
    }

    private static void StartGame() {
        Scanner scanner = new Scanner(System.in);
        MessageBuilder messageBuilder = new MessageBuilder();

        System.out.print("\033[2J\033[;H");
        System.out.println("                  __");
        System.out.println("                 /  \\");
        System.out.println("           .-.  |    |");
        System.out.println("   *    _.-'  \\  \\__/");
        System.out.println("    \\.-'       \\");
        System.out.println("   /          _/");
        System.out.println("  |      _  /\" \"");
        System.out.println("  |     /_\'");
        System.out.println("   \\    \\_/");
        System.out.println("    \" \"\" \"\" \"\" \"");

        do {
            System.out.println("");
            System.out.println("Player, it's your turn");
            System.out.println("Enter coordinates for your shot:");
            Position position = parsePosition(scanner.next());
            boolean isHit = GameController.checkIsHit(enemyFleet, position);
            if (isHit) {
                beep();
                System.out.println(messageBuilder.blowMessage().colorizedMessage());
                System.out.println(messageBuilder.hitMessage().colorizedMessage());

            } else {
                System.out.println(messageBuilder.missMessage().colorizedMessage());
                System.out.println(messageBuilder.missPictureMessage().colorizedMessage());
            }

            telemetry.trackEvent("Player_ShootPosition", "Position", position.toString(), "IsHit", Boolean.valueOf(isHit).toString());

            position = getRandomPosition();
            isHit = GameController.checkIsHit(myFleet, position);
            System.out.println("");

            System.out.println(String.format("Computer shoot in %s%s", position.getColumn(), position.getRow()));
            if (isHit) {
                System.out.println(messageBuilder.computerHitMessage().colorizedMessage());
                beep();
                System.out.println(messageBuilder.computerBlowMessage().colorizedMessage());
            } else {
                System.out.println(messageBuilder.computerMissMessage().colorizedMessage());
                System.out.println(messageBuilder.missPictureMessage().colorizedMessage());
            }

            telemetry.trackEvent("Computer_ShootPosition", "Position", position.toString(), "IsHit", Boolean.valueOf(isHit).toString());

        } while (true);
    }

    private static void beep() {
        System.out.print("\007");
    }

    protected static Position parsePosition(String input) {
        Letter letter = Letter.valueOf(input.toUpperCase().substring(0, 1));
        int number = Integer.parseInt(input.substring(1));
        return new Position(letter, number);
    }

    private static Position getRandomPosition() {
        int rows = 8;
        int lines = 8;
        Random random = new Random();
        Letter letter = Letter.values()[random.nextInt(lines)];
        int number = random.nextInt(rows);
        Position position = new Position(letter, number);
        return position;
    }

    private static void InitializeGame() {
        InitializeMyFleet();

        InitializeEnemyFleet();
    }

    private static void InitializeMyFleet() {
        Scanner scanner = new Scanner(System.in);
        myFleet = GameController.initializeShips();

        System.out.println("Please position your fleet (Game board has size from A to H and 1 to 8) :");

        for (Ship ship : myFleet) {
            System.out.println("");
            System.out.printf("Please enter the positions for the %s (size: %s). Please start from left top corner%n", ship.getName(), ship.getSize());

            System.out.println("Enter coordinates of left top corner and direction for right or down (i.e A3R or A3D):");
            String positionInput = scanner.next();
            ship.placeLeftTopCorner(positionInput);
            telemetry.trackEvent("Player_PlaceLeftTopShipPosition", "Position", positionInput, "Ship", ship.getName(), "PositionInShip");

            System.out.println("Your ship is ready");

        }
    }

    private static void InitializeEnemyFleet() {
        enemyFleet = shipsFactory.createShips();
    }
}
