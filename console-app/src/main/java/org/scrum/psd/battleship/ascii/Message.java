package org.scrum.psd.battleship.ascii;

import com.diogonunes.jcolor.Attribute;

import java.util.Objects;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Message {
    private String text;
    private Attribute color;

    public Message(String text, Attribute color) {

        this.text = text;
        this.color = color;
    }

    public String colorizedMessage() {
        return colorize(text, color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return Objects.equals(text, message.text) && Objects.equals(color.toString(), message.color.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, color.toString());
    }
}
