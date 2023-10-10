package org.scrum.psd.battleship.ascii;

import com.diogonunes.jcolor.Attribute;

public class MessageBuilder {
    public Message hitMessage() {
        return new Message("Yeah ! Nice hit !", Attribute.GREEN_TEXT());
    }

    public Message missMessage() {
        return new Message("Miss", Attribute.RED_TEXT());
    }

    public Message blowMessage() {
        return new Message(
                "                \\         .  ./\n" +
                "              \\      .:\" \";'.:..\" \"   /\n" +
                "                  (M^^.^~~:.'\" \").\n" +
                "            -   (/  .    . . \\ \\)  -\n" +
                "               ((| :. ~ ^  :. .|))\n" +
                "            -   (\\- |  \\ /  |  /)  -\n" +
                "                 -\\  \\     /  /-\n" +
                "                   \\  \\   /  /", Attribute.GREEN_TEXT());
    }

    public Message computerHitMessage() {
        return new Message("Hit your ship !", Attribute.RED_TEXT());
    }

    public Message computerMissMessage() {
        return new Message("Miss", Attribute.GREEN_TEXT());
    }

    public Message computerBlowMessage() {
        return new Message("                \\         .  ./\n" +
                "              \\      .:\" \";'.:..\" \"   /\n" +
                "                  (M^^.^~~:.'\" \").\n" +
                "            -   (/  .    . . \\ \\)  -\n" +
                "               ((| :. ~ ^  :. .|))\n" +
                "            -   (\\- |  \\ /  |  /)  -\n" +
                "                 -\\  \\     /  /-\n" +
                "                   \\  \\   /  /", Attribute.RED_TEXT());
    }
}
