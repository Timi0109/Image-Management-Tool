package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Controller implements sample{
    @FXML
    ImageView imgview;
    @FXML
    Text propertyText;
    @FXML
    Text downloadTips;
    @FXML
    ComboBox imageCombo;
    @FXML
    ComboBox colorCombo;

    @Override
    public void setImage() {
        imgview = new ImageView();
    }

    //Handle Event: Upload Button
    @FXML
    private void buttonClicked(ActionEvent event){
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Images", "*.*"),
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG", "*.png")
            );
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            File selectedFile = fileChooser.showOpenDialog(null);
            Image img = SwingFXUtils.toFXImage(ImageIO.read(selectedFile), null);
            imgview.setImage(img);
            imgview.setFitHeight(100);
            imgview.setFitWidth(100);
            propertyText.setText("Width: "+ imgview.getFitWidth() + ", Height: " + imgview.getFitHeight());
        } catch (IOException e) {

            Logger.getLogger(
                Controller.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Handle Event: Download Button
    @FXML
    private void buttonClickedTwo(ActionEvent event){
        try {
            //-----Color filter-----------------
            //blue filter
            if (colorCombo.getValue().equals("blue")){
                Color targetColor = Color.web("#ff00ffff");
                ColorAdjust colorAdjust = new ColorAdjust();
                double hue = targetColor.getHue();
                colorAdjust.setHue(hue);
                imgview.setEffect(colorAdjust);
            }
            //red filter
            if (colorCombo.getValue().equals("red")){
                ColorAdjust colorAdjust = new ColorAdjust();
                colorAdjust.setHue(-0.2);
                imgview.setEffect(colorAdjust);
            }
            //green filter
            if (colorCombo.getValue().equals("green")){
                ColorAdjust colorAdjust = new ColorAdjust();
                colorAdjust.setHue(0.4);
                imgview.setEffect(colorAdjust);
            }

            //--------Convert Image format, then save to user file-----------------
            BufferedImage image = SwingFXUtils.fromFXImage(imgview.getImage(), null);
            BufferedImage bmpImg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
            if (imageCombo.getValue().equals("PNG")){
                ImageIO.write(image, "png", new File( "converted.png"));
            }
            if (imageCombo.getValue().equals("JPG")){
                ImageIO.write(bmpImg, "jpg",  new File("converted.jpg"));
            }
            if (imageCombo.getValue().equals("GIF")){
                ImageIO.write(image, "gif",  new File("converted.gif"));
            }
            if (imageCombo.getValue().equals("BMP")){
                ImageIO.write(bmpImg, "bmp",  new File( "converted.bmp"));
            }
            if (imageCombo.getValue().equals("TIFF")){
                ImageIO.write(image, "tiff",  new File("converted.tiff"));
            }
            downloadTips.setText("Download successfully");
        }catch (IOException e){
            downloadTips.setText("Download failed! Try another image.");
            Logger.getLogger(
                    Controller.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
