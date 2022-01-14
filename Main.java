package sample;


import javafx.scene.control.Label;
import javafx.scene.control.Button;

import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        var sp = SerialPortService.getSerialPort("/dev/cu.usbserial-0001");
        var outputStream = sp.getOutputStream();
        var buttonb = new Button("Blue");
        var pane = new BorderPane();
        var label = new Label("LED STRIP CONTROLLER!");
        primaryStage.setTitle("LED STRIP CONTROLLER!");
        var buttongreen = new Button("Green");
        var buttonred = new Button(" Red ");
        var buttonwhite = new Button("Chasing white");
        var rainbow = new Button("Rainbow");
        var off1 = new Button("OFF");

        buttongreen.setStyle("-fx-background-color: \n" +
                "\n" +
                " #99ff66");
        buttonb.setStyle("-fx-background-color:#33ccff");
        buttonred.setStyle("-fx-background-color: #ff3300");
        var slider = new Slider();
        slider.setMin(0.0);
        slider.setMax(100.0);

        slider.valueProperty().addListener((observableValue, oldValue, newValue)->{
            try{
                outputStream.write(newValue.byteValue());
                if(newValue.byteValue()<50){
                    outputStream.write(7);
                }else{
                    outputStream.write(9);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        off1.setOnMousePressed(value->{
            try {
                outputStream.write(23);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        off1.setOnMouseReleased(value-> {
            try {
                outputStream.write(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buttonwhite.setOnMousePressed(value->{
            try {
                outputStream.write(15);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buttonwhite.setOnMouseReleased(value-> {
            try {
                outputStream.write(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buttonb.setOnMousePressed(value->{
            try {
                outputStream.write(255);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buttonb.setOnMouseReleased(value-> {
            try {
                outputStream.write(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buttonred.setOnMousePressed(value->{
            try {
                outputStream.write(127);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buttonred.setOnMouseReleased(value-> {
            try {
                outputStream.write(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buttongreen.setOnMousePressed(value->{
            try {
                outputStream.write(63);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buttongreen.setOnMouseReleased(value-> {
            try {
                outputStream.write(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        rainbow.setOnMousePressed(value->{
            try {
                outputStream.write(31);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        rainbow.setOnMouseReleased(value-> {
            try {
                outputStream.write(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        var vbox = new VBox();
        vbox.setSpacing(10.0);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(buttonb,buttonred ,buttongreen,buttonwhite,rainbow,off1,slider);

        var scene = new Scene(vbox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}






