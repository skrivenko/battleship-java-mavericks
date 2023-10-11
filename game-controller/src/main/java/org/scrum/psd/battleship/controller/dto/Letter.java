package org.scrum.psd.battleship.controller.dto;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public enum Letter {
    A, B, C, D, E, F, G, H;

    public static Letter nextLetter(Letter letter) {
        char c = letter.toString().charAt(0);
        return Letter.valueOf(String.valueOf(++c));
    }
}
