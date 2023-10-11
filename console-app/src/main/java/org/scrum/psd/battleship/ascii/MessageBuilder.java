package org.scrum.psd.battleship.ascii;

import com.diogonunes.jcolor.Attribute;

public class MessageBuilder {
    public Message hitMessage() {
        return new Message("Yeah! Nice hit!", Attribute.RED_TEXT());
    }

    public Message missMessage() {
        return new Message("You miss", Attribute.BLUE_TEXT());
    }

    public Message blowMessage() {
        return new Message(
                "                   \\  .  .  /\n" +
                        "              \\   .:\" \";'.:..\" \"   /\n" +
                        "                 (M^^.^~~:.'\" \").\n" +
                        "            -   (/  .    . . \\ \\)  -\n" +
                        "               ((| :. ~ ^  :. .|))\n" +
                        "            -   (\\- |  \\ /  |  /)  -\n" +
                        "                 -\\  \\     /  /-\n" +
                        "                   \\  \\   /  /", Attribute.RED_TEXT());
    }

    public Message computerHitMessage() {
        return new Message("Hit your ship!", Attribute.RED_TEXT());
    }

    public Message computerMissMessage() {
        return new Message("Computer miss", Attribute.BLUE_TEXT());
    }

    public Message computerBlowMessage() {
        return new Message(
                "                   \\  .  .  /\n" +
                "              \\   .:\" \";'.:..\" \"   /\n" +
                "                 (M^^.^~~:.'\" \").\n" +
                "            -   (/  .    . . \\ \\)  -\n" +
                "               ((| :. ~ ^  :. .|))\n" +
                "            -   (\\- |  \\ /  |  /)  -\n" +
                "                 -\\  \\     /  /-\n" +
                "                   \\  \\   /  /", Attribute.RED_TEXT());
    }
}
