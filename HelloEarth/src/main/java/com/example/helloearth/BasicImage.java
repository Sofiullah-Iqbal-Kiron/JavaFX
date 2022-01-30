/*
 * We can render graphical images inside a javafx application.
 * Supported image formats: BMP, JPEG, PNG, GIF
 * Load images from specified URL.
 * Use image host like websites while using URL specified path.
 * Use javafx.scene.image.ImageView class to view image on the scene.
 * ImageView is a node used for painting images loaded with javafx.scene.image.Image class.
 */

package com.example.helloearth;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;

public class BasicImage extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        URL url_myFBProfile = new URL("https://scontent.fdac31-1.fna.fbcdn.net/v/t39.30808-1/p240x240/259971450_2731388383831289_7892444486849337075_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=7206a8&_nc_eui2=AeGRnt1PaYP4z5dxl7K_sumvO2v-RlgQ77Y7a_5GWBDvtt3HDU4y6TAnGoujM33jNWcv-U3v69MXCW3zuGDjR7Lj&_nc_ohc=75Ook6wP6tcAX_3AnKx&_nc_ht=scontent.fdac31-1.fna&oh=00_AT_HzGbakWD7U18su2pyz-uZtU73SS4C7yAAt8AChi7kMA&oe=61F8A725");
        Image image_myFBProfile = new Image(String.valueOf(url_myFBProfile));
        ImageView imageView_myFBProfile = new ImageView(image_myFBProfile);

        Group root = new Group();
        root.getChildren().add(imageView_myFBProfile);
        Scene scene = new Scene(root);

        stage.setTitle("ImageVIEW: Kiron");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}
