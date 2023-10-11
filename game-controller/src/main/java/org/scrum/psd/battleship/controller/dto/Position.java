package org.scrum.psd.battleship.controller.dto;

import java.util.Objects;

public class Position {
    private Letter column;
    private int row;
    private boolean isHit = false;

    public Position() {
        super();
    }

    public Position(Letter column, int row) {
        this();

        this.column = column;
        this.row = row;
    }

    public static Position nextPosition(Position position, Direction direction) {
        return position;
    }

    public Letter getColumn() {
        return column;
    }

    public void setColumn(Letter column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override public boolean equals(Object o) {
        if(o instanceof Position) {
            Position position = (Position) o;

            if(position == null) {
                return false;
            }

            return position.column.equals(column) && position.row == row;
        }

        return false;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row, isHit);
    }

    @Override
    public String toString() {
        return "Position{" +
                "column=" + column +
                ", row=" + row +
                ", isHit=" + isHit +
                '}';
    }
}
