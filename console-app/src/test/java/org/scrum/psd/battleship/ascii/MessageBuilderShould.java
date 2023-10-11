package org.scrum.psd.battleship.ascii;

import com.diogonunes.jcolor.Attribute;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageBuilderShould {

    @Test
    public void showGreenMessageOnHit() {
        MessageBuilder messageBuilder = new MessageBuilder();
        Message message = messageBuilder.hitMessage();

        assertEquals(new Message("Yeah ! Nice hit !", Attribute.GREEN_TEXT()), message);
    }

    @Test
    public void showGreenMessageOnBlow() {
        MessageBuilder messageBuilder = new MessageBuilder();
        Message message = messageBuilder.blowMessage();

        assertEquals(new Message("                   \\  .  .  /\n" +
                "              \\   .:\" \";'.:..\" \"   /\n" +
                "                 (M^^.^~~:.'\" \")." +
                "            -   (/  .    . . \\ \\)  -\n" +
                "               ((| :. ~ ^  :. .|))\n" +
                "            -   (\\- |  \\ /  |  /)  -\n" +
                "                 -\\  \\     /  /-\n" +
                "                   \\  \\   /  /", Attribute.GREEN_TEXT()), message);
    }

    @Test
    public void showRedMessageOnMiss() {
        MessageBuilder messageBuilder = new MessageBuilder();
        Message message = messageBuilder.missMessage();

        assertEquals(new Message("Miss", Attribute.RED_TEXT()), message);
    }

    @Test
    public void showRedMessageOnComputerHit() {
        MessageBuilder messageBuilder = new MessageBuilder();
        Message message = messageBuilder.computerHitMessage();

        assertEquals(new Message("Hit your ship !", Attribute.RED_TEXT()), message);
    }

    @Test
    public void showGreenMessageOnComputerMiss() {
        MessageBuilder messageBuilder = new MessageBuilder();
        Message message = messageBuilder.computerMissMessage();

        assertEquals(new Message("Miss", Attribute.GREEN_TEXT()), message);
    }

    @Test
    public void showGreenMessageOnComputerBlow() {
        MessageBuilder messageBuilder = new MessageBuilder();
        Message message = messageBuilder.computerBlowMessage();

        assertEquals(new Message("                   \\  .  .  /\n" +
                "              \\   .:\" \";'.:..\" \"   /\n" +
                "                 (M^^.^~~:.'\" \")." +
                "            -   (/  .    . . \\ \\)  -\n" +
                "               ((| :. ~ ^  :. .|))\n" +
                "            -   (\\- |  \\ /  |  /)  -\n" +
                "                 -\\  \\     /  /-\n" +
                "                   \\  \\   /  /", Attribute.RED_TEXT()), message);
    }

    @Test
    public void showMissWaterMessage() {
        MessageBuilder messageBuilder = new MessageBuilder();
        Message message = messageBuilder.missPictureMessage();

        assertEquals(new Message(
                "      ~~~~   ~~~~   ~~~~\n" +
                        "  ~~~~~   ~~~~   ~~~~   ~~~~~\n" +
                        "~~~~~  ~~~~   ~~~~   ~~~~  ~~~~~\n" +
                        " ~~~~  ~  _  ~~~~   _  ~~~~  ~~~\n" +
                        "   ~~~~~  (_)    ~ (_)  ~~~~~\n" +
                        "           ~~~~~~~~~", Attribute.BLUE_TEXT()), message);
    }

}
