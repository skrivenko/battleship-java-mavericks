package org.scrum.psd.battleship.ascii;

public class RandomSetupGenerator implements SetupGenerator {
    private static final int MIN = 1;
    private static final int MAX = 5;

    @Override
    public int generateSetupNumber() {
        return MIN + (int)(Math.random() * ((MAX - MIN) + 1));
    }
}
