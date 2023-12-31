package org.scrum.psd.battleship.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ship {
    private boolean isPlaced;
    private String name;
    private int size;
    private List<Position> positions;
    private Color color;

    public Ship() {
        this.positions = new ArrayList<>();
    }

    public Ship(String name, int size) {
        this();

        this.name = name;
        this.size = size;
    }

    public Ship(String name, int size, List<Position> positions) {
        this(name, size);

        this.positions = positions;
    }

    public Ship(String name, int size, Color color, List<Position> positions) {
        this(name, size);
        this.color = color;
        this.positions = positions;
    }

    public Ship(String name, int size, Color color) {
        this(name, size);

        this.color = color;
    }

    public void addPosition(String input) {
        if (positions == null) {
            positions = new ArrayList<>();
        }

        Letter letter = Letter.valueOf(input.toUpperCase().substring(0, 1));
        int number = Integer.parseInt(input.substring(1));

        positions.add(new Position(letter, number));
    }

    // TODO: property change listener implementieren

    public boolean isPlaced() {
        return isPlaced;
    }

    public void setPlaced(boolean placed) {
        isPlaced = placed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isDestroyed() {
        boolean destroyed = true;
        for (Position position : positions) {
            if (!position.isHit()) {
                destroyed = false;
            }
        }
        return destroyed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ship)) return false;
        Ship ship = (Ship) o;
        return isPlaced == ship.isPlaced && size == ship.size && Objects.equals(name, ship.name) && Objects.equals(positions, ship.positions) && color == ship.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isPlaced, name, size, positions, color);
    }

    public boolean placeLeftTopCorner(String input) {
        if (positions == null) {
            positions = new ArrayList<>();
        }

        Letter letter = Letter.valueOf(input.toUpperCase().substring(0, 1));
        int number = Integer.parseInt(input.substring(1, 2));
        Direction direction = Direction.valueOf(input.toUpperCase().substring(2));

        if (direction == Direction.R) {
            while (positions.size() < this.size - 1) {
                positions.add(new Position(letter, number));
                number++;
            }
        } else {
            while (positions.size() < this.size -1) {
                positions.add(new Position(letter, number));
                letter = Letter.nextLetter(letter);
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "isPlaced=" + isPlaced +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", positions=" + positions +
                ", color=" + color +
                '}';
    }
}
