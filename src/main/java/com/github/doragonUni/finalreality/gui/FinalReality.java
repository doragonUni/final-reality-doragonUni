package com.github.doragonUni.finalreality.gui;

import com.github.doragonUni.finalreality.controller.GameController;
import com.github.doragonUni.finalreality.model.character.Enemy;
import com.github.doragonUni.finalreality.model.character.player.IPlayerCharacter;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

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
  private Stage stage;
  Label characterStats;
  Label weaponCreatedLabel;
  Label playerCreatedLabel;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage)  {
    stage = primaryStage;
    Scene scene = mainMenuScene();
    //Scene scene = gameScene();
    primaryStage.setScene(scene);
    primaryStage.setTitle("Final Reality");
    primaryStage.show();


  }

  public Scene mainMenuScene(){
    Label title = new Label("Main menu");
    Button championSelect = new Button("characterMenu");
    Button weaponSelect = new Button("weaponMenu");

    championSelect.setOnAction(actionEvent -> { stage.setScene(characterScene());
    });

    weaponSelect.setOnAction(actionEvent -> { stage.setScene((weaponScene()));
    });

    Group mainMenuGroup = new Group();
    championSelect.setLayoutX(200);
    championSelect.setLayoutY(200);
    weaponSelect.setLayoutX(980);
    weaponSelect.setLayoutY(200);

    title.setLayoutX(640);
    title.setLayoutY(100);

    mainMenuGroup.getChildren().addAll(championSelect, weaponSelect, title);

    return new Scene(mainMenuGroup, 1280, 720);

  }

  public Scene characterScene(){

    Label sceneTitle = new Label("CREATE YOUR CHARACTERS");
    playerCreatedLabel = new Label("");

    GridPane wMageCreator = characterGridPane("WhiteMage");
    GridPane bMageCreator = characterGridPane("BlackMage");
    GridPane thiefCreator = characterGridPane("Thief");
    GridPane knightCreator = characterGridPane("Knight");
    GridPane engineerCreator = characterGridPane("Engineer");
    Button backToMainMenu = new Button("Back");
    Button startGameButton = new Button("StartGame!");

    backToMainMenu.setOnAction(actionEvent -> {
      stage.setScene(mainMenuScene());

    });

    startGameButton.setOnAction(actionEvent -> {
      if(controller.getPartyNum() == controller.getParty().size()){
        controller.loadingGame();
        try {
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        stage.setScene(gameScene());


      }

      });

    GridPane characterRoot = new GridPane();
    characterRoot.setHgap(40);
    characterRoot.setVgap(20);
    characterRoot.setPadding(new Insets(30, 20, 30,20));
    characterRoot.addRow(0, sceneTitle);
    characterRoot.addRow(0,wMageCreator);
    characterRoot.addColumn(2,bMageCreator);
    characterRoot.addRow(1,thiefCreator);
    characterRoot.addColumn(1,knightCreator);
    characterRoot.addColumn(2,engineerCreator);
    characterRoot.addRow(3, backToMainMenu);
    characterRoot.addRow(4, playerCreatedLabel);
    characterRoot.addRow(5, startGameButton);


    startAnimator();
    return new Scene(characterRoot, 1280,720);


  }

  public Scene weaponScene(){

    Label sceneTitle = new Label("CREATE YOUR WEAPONS");
    weaponCreatedLabel = new Label("");

    GridPane axeCreator = weaponGridPane("Axe");
    GridPane bowCreator = weaponGridPane("Bow");
    GridPane staffCreator = weaponGridPane("Staff");
    GridPane knifeCreator = weaponGridPane("Knife");
    GridPane swordCreator = weaponGridPane("Sword");
    Button backToMainMenu = new Button("Back");

    backToMainMenu.setOnAction(actionEvent -> {
      stage.setScene(mainMenuScene());

    });

    GridPane weaponRoot = new GridPane();
    weaponRoot.setHgap(40);
    weaponRoot.setVgap(20);
    weaponRoot.setPadding(new Insets(30, 20, 30,20));
    weaponRoot.addRow(0, sceneTitle);
    weaponRoot.addRow(0,axeCreator);
    weaponRoot.addColumn(2,bowCreator);
    weaponRoot.addRow(1,staffCreator);
    weaponRoot.addColumn(1,knifeCreator);
    weaponRoot.addColumn(2,swordCreator);
    weaponRoot.addRow(3, backToMainMenu);
    weaponRoot.addRow(4, weaponCreatedLabel);

    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(final long now) {

        weaponCreatedLabel.setText("You have created "+ controller.getInventorySpace() + " weapons" );

      }
    };
    timer.start();
    return new Scene(weaponRoot, 1280,720);


  }


  public Scene gameScene()  {



    VBox characterBox = characterVBox();
    VBox enemyBox = enemyVBox();


    GridPane gamePane = new GridPane();
    gamePane.addColumn(0, characterBox);
    gamePane.addColumn(4, enemyBox);
    gamePane.setPadding(new Insets(30,20,30,20));
    gamePane.setHgap(10);
    gamePane.setVgap(10);


    return new Scene(gamePane, 1280,720);
  }


  public GridPane characterGridPane(String type){
    GridPane root = new GridPane();

    Label Name=new Label("Name");
    Label Hp = new Label("Hp");
    Label Defense = new Label("Defense");

    TextField nameInput = new TextField();
    nameInput.setText("");
    TextField hpInput = new TextField();
    hpInput.setText("");
    TextField defenseInput = new TextField();
    defenseInput.setText("");
    Button characterButton = new Button(type);

      if ("BlackMage".equals(characterButton.getText())) {
        characterButton.setOnAction(action -> {
          controller.blackMageCreator(nameInput.getText(), Integer.parseInt(hpInput.getText()),
                  Integer.parseInt(defenseInput.getText()), 10);
         // controller.staffCreator("initial weapon BM", 10, 10, 0);
          //controller.tryToEquip(controller.selectInventoryItem("initial weapon BM"),
            //      controller.getFromParty(controller.getPartySize()-1));
          System.out.println(controller.getParty());

          nameInput.setText("");
          hpInput.setText("");
          defenseInput.setText("");
        });
      } else if ("WhiteMage".equals(characterButton.getText())) {
        characterButton.setOnAction(action -> {
          controller.whiteMageCreator(nameInput.getText(), Integer.parseInt(hpInput.getText()),
                  Integer.parseInt(defenseInput.getText()), 10);
          System.out.println(controller.getParty());

          nameInput.setText("");
          hpInput.setText("");
          defenseInput.setText("");
        });
      } else if ("Knight".equals(characterButton.getText())) {
        characterButton.setOnAction(action -> {
          controller.knightCreator(nameInput.getText(), Integer.parseInt(hpInput.getText()),
                  Integer.parseInt(defenseInput.getText()));
          System.out.println(controller.getParty());

          nameInput.setText("");
          hpInput.setText("");
          defenseInput.setText("");
        });
      } else if ("Thief".equals(characterButton.getText())) {
        characterButton.setOnAction(action -> {
          controller.thiefCreator(nameInput.getText(), Integer.parseInt(hpInput.getText()),
                  Integer.parseInt(defenseInput.getText()));
          System.out.println(controller.getParty());

          nameInput.setText("");
          hpInput.setText("");
          defenseInput.setText("");
        });
      } else if ("Engineer".equals(characterButton.getText())) {
        characterButton.setOnAction(action -> {
          controller.engineerCreator(nameInput.getText(), Integer.parseInt(hpInput.getText()),
                  Integer.parseInt(defenseInput.getText()));
          System.out.println(controller.getParty());

          nameInput.setText("");
          hpInput.setText("");
          defenseInput.setText("");
        });
      }

      for(int i= new Random().nextInt(5); i<5; i++){
        controller.enemyCreator("enemy"+i, new Random().nextInt( 40 )+10,
                new Random().nextInt(100) + 20, new Random().nextInt(30) + 1,new Random().nextInt(40) + 30);
      }

    root.addRow(0, Name, nameInput);
    root.addRow(1, Hp, hpInput);
    root.addRow(2, Defense, defenseInput);
    root.addRow(3, characterButton);

    return root;
  }

  public GridPane weaponGridPane(String type){
    GridPane root = new GridPane();

    Label Name=new Label("Name");


    TextField nameInput = new TextField();
    nameInput.setText("");
    Button weaponButton = new Button(type);


    if ("Axe".equals(weaponButton.getText())) {
      weaponButton.setOnAction(action -> {
        controller.axeCreator(nameInput.getText(), new Random().nextInt(25) + 15,
                new Random().nextInt(30) + 10);
        nameInput.setText("");
      });
    } else if ("Bow".equals(weaponButton.getText())) {
      weaponButton.setOnAction(action -> {
        controller.bowCreator(nameInput.getText(), new Random().nextInt(20) + 10,
                new Random().nextInt(25) + 5);


        nameInput.setText("");

      });
    } else if ("Staff".equals(weaponButton.getText())) {
      weaponButton.setOnAction(action -> {
        controller.staffCreator(nameInput.getText(),10,
                 10, 0);

        nameInput.setText("");

      });
    } else if ("Knife".equals(weaponButton.getText())) {
      weaponButton.setOnAction(action -> {
        controller.knifeCreator(nameInput.getText(), new Random().nextInt(35)+ 10,
                new Random().nextInt(20) + 10);

        nameInput.setText("");

      });
    } else if ("Sword".equals(weaponButton.getText())) {
       weaponButton.setOnAction(action -> {
        controller.swordCreator(nameInput.getText(), new Random().nextInt(100) + 40,
                new Random().nextInt(40) + 30);

        nameInput.setText("");

      });
    }


    root.addRow(0, Name, nameInput);
    root.addRow(2, weaponButton);
    return root;
  }



  public VBox characterVBox(){
    VBox box = new VBox(15);
    Label characterLabel = new Label("player's Line up");
    box.getChildren().add(characterLabel);
    ArrayList<IPlayerCharacter> party = controller.getParty();

    for(var characters: party) {
      String name = controller.getCharacterName(characters);
      int hp = controller.getCharacterHp(characters);
      int def = controller.getCharacterDef(characters);
      characterStats = new Label("Character: " + name + " Hp: " + hp + " Def : " + def);
      box.getChildren().add(characterStats);
    }
    return box;

  }

  public VBox enemyVBox(){
    VBox box = new VBox(15);
    Label characterLabel = new Label("enemies' Line up");
    box.getChildren().add(characterLabel);
    ArrayList<Enemy> enemies = controller.getEnemyParty();

    for(var characters: enemies){
      String name = controller.getCharacterName(characters);
      int hp = controller.getCharacterHp(characters);
      int def = controller.getCharacterDef(characters);
      Label characterStats = new Label("Character: "+ name + " Hp: " + hp + " Def : " + def);
      box.getChildren().add(characterStats);

    }
    return box;

  }


  private void startAnimator() {
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(final long now) {
        playerCreatedLabel.setText("You have created "+ controller.getParty().size()+"/"+controller.getPartyNum());


      }
    };
    timer.start();
  }






}