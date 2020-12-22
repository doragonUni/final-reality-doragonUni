package com.github.doragonUni.finalreality.gui;

import com.github.doragonUni.finalreality.controller.GameController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public class FinalReality extends Application {
  GameController controller = new GameController();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Final reality");
    primaryStage.setResizable(false);
    Group root = new Group();
    int partySize = controller.getParty().size();
    int enemySize = controller.getEnemyParty().size();
    Label partySizeLabel = new Label("Party number is " + partySize);
    partySizeLabel.setAlignment(Pos.CENTER);
    root.getChildren().add(partySizeLabel);

    // This sets the size of the Scene to be 400px wide, 200px high
    Scene scene = new Scene(root, 640, 480);
    primaryStage.setScene(scene);

    primaryStage.show();
  }



}