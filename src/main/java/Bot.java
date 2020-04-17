import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Bot {
    private static Robot robot_instance;
    private Tesseract tesseract;
    
    public Bot() throws AWTException {
        tesseract = new Tesseract();
        tesseract.setLanguage("bul");
        robot_instance = new Robot();
    }
    
    public String getQuestion() throws TesseractException {
        BufferedImage image = robot_instance.createScreenCapture(new Rectangle(484, 358, 604,114));
        Color color = new Color(image.getRGB(0, 0));
        if (color.equals(new Color(255,245,176)))
            return readImage(image);
        else
            return null;
    }
    
    public List<String> getChoiceAnswers() throws TesseractException, IOException {
        int[] answerOffset = {505, 586, 669, 746};
        List<String> ret = new ArrayList<>();
        
        for (int y : answerOffset) {
            BufferedImage image = robot_instance.createScreenCapture(new Rectangle(573, y, 433, 54));
            ImageIO.write(image, "png", new File(y + ".png"));
            ret.add(readImage(image));
        }
        return ret;
    }
    
    public String readImage(BufferedImage image) throws TesseractException {
        return tesseract.doOCR(image);
    }
}
