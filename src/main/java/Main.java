import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        try {
            Bot bot = new Bot();
            String question;
            while (true) {
                if ((question = bot.getQuestion()) != null)
                System.out.println(question);
                System.out.println(bot.getChoiceAnswers());
                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
