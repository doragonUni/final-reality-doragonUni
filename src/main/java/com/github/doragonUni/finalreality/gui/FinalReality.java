package com.github.doragonUni.finalreality.gui;

import com.github.doragonUni.finalreality.controller.GameController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Flow;

/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author <Lung Pang>
 */
public class FinalReality extends Application {
  GameController controller = new GameController();
  private Stage stage;
  Label weaponCreatedLabel;
  Label playerCreatedLabel;
  Label enemyCreatedLabel;
  Map<String, Integer> playerMask = new HashMap<String, Integer>();
  Map<String, Integer> enemyMask = new HashMap<String, Integer>();
  private boolean takengameOver = false;

  public static void main(String[] args) {
    launch(args);
  }

  /**
   * start the game!
   * @param primaryStage
   * @throws FileNotFoundException
   */
  @Override
  public void start(Stage primaryStage) throws FileNotFoundException {
    stage = primaryStage;
    Scene scene = mainMenuScene();
    //Scene scene = gameScene();
    primaryStage.setScene(scene);
    primaryStage.setTitle("Final Reality");
    primaryStage.setResizable(false);

    primaryStage.show();


  }

  /**
   * scene For the MENU OF THE GAME
   * @return
   * @throws FileNotFoundException
   */
  public Scene mainMenuScene() throws FileNotFoundException {
    Label title = new Label("Main menu \nFinal Reality \nBeta ");
    Label easterEgg = new Label("desenho grafico minha paixao");
    Label credits = new Label("Made by Lung Pang Wang ");
    Button championSelect = new Button("Character Menu");
    Button weaponSelect = new Button("Weapon Menu");
    Button startGameButton = new Button("Start Game!");

    Label cantstartLabel = new Label("you can't start the game");
    cantstartLabel.setVisible(false);
    cantstartLabel.setLayoutX(610);
    cantstartLabel.setLayoutY(330);
    cantstartLabel.setFont(new Font("Eras Demi Itc", 12));


    Image sakuraPetals = new Image(new FileInputStream("src/main/resources/MenuBackground.jpg"));
    ImageView background = new ImageView(sakuraPetals);
    background.setMouseTransparent(true);
    background.isPreserveRatio();
    background.fitWidthProperty().bind(stage.widthProperty());
    background.setViewOrder(0.4);

    championSelect.setOnAction(actionEvent -> {

      try {
        stage.setScene(characterScene());
        playSound();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    });

    weaponSelect.setOnAction(actionEvent -> {
      try {
        gunSound();
        stage.setScene((weaponScene()));

      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    });

    startGameButton.setOnAction(actionEvent -> {
      if(controller.getPartyNum() == controller.getPartySize() && !controller.getEnemyParty().isEmpty()){
        for(var character: controller.getParty()){
          if(character.getEquippedWeapon() != null){
            try {
              startSound();
              stage.setScene(mainGameScene());
            } catch (FileNotFoundException e) {
              e.printStackTrace();
            }
            controller.loadingGame();
          }
        }
      }
    });

    Group mainMenuGroup = new Group();

    championSelect.setLayoutX(500);
    championSelect.setLayoutY(250);
    championSelect.setPrefSize(120,30);
    championSelect.setFont(new Font("Eras Demi Itc", 12));

    weaponSelect.setLayoutX(720);
    weaponSelect.setLayoutY(250);
    weaponSelect.setPrefSize(120,30);
    weaponSelect.setFont(new Font("Eras Demi Itc", 12));

    startGameButton.setLayoutX(610);
    startGameButton.setLayoutY(320);
    startGameButton.setPrefSize(120,30);
    startGameButton.setFont(new Font("Eras Demi Itc", 12));



    title.setLayoutX(640);
    title.setLayoutY(100);
    title.setTextFill(Color.HOTPINK);
    title.setFont(new Font("Eras Demi Itc", 18));
    title.setScaleX(3);
    title.setScaleY(3);

    easterEgg.setLayoutX(50);
    easterEgg.setLayoutY(690);
    easterEgg.setFont(new Font("Comic Sans MS", 20));
    easterEgg.setTextFill(Color.BLUE);

    credits.setLayoutX(1040);
    credits.setLayoutY(690);
    credits.setFont(new Font("Comic Sans MS", 20));
    credits.setTextFill(Color.MEDIUMPURPLE);

    mainMenuGroup.getChildren().addAll(championSelect, weaponSelect, title, easterEgg, credits, background,startGameButton,
            cantstartLabel);

    return new Scene(mainMenuGroup, 1280, 720);

  }

  /**
   * scene for the character creation
   * @return
   * @throws FileNotFoundException
   */
  public Scene characterScene() throws FileNotFoundException {
    Label sceneTitle = new Label("CREATE YOUR CHARACTERS \n ");
    sceneTitle.setFont(new Font("MS Gothic", 20));
    playerCreatedLabel = new Label("");
    enemyCreatedLabel = new Label("");
    GridPane titlePane = new GridPane();
    titlePane.addRow(0, sceneTitle);
    titlePane.addRow(1, playerCreatedLabel);
    titlePane.addRow(2, enemyCreatedLabel);

    Image kimetsu = new Image(new FileInputStream("src/main/resources/CharacterBackground.jpg"));
    ImageView background = new ImageView(kimetsu);
    background.setMouseTransparent(true);
    background.isPreserveRatio();
    background.fitWidthProperty().bind(stage.widthProperty());
    background.setViewOrder(0.4);
    background.setOpacity(0.7);

    GridPane wMageCreator = characterGridPane("Create WhiteMage");
    GridPane bMageCreator = characterGridPane("Create BlackMage");
    GridPane thiefCreator = characterGridPane("Create Thief");
    GridPane knightCreator = characterGridPane("Create Knight");
    GridPane engineerCreator = characterGridPane("Create Engineer");
    Button backToMainMenu = new Button("Back");
    Button createInputEnemies = new Button("Create Enemies");
    Button characterLineUp = new Button("view LineUp");

    characterLineUp.setLayoutX(20);
    characterLineUp.setLayoutY(480);
    characterLineUp.setPrefSize(100,50);
    characterLineUp.setFont(new Font("Yu Gothic UI Semilight",14));

    backToMainMenu.setLayoutX(20);
    backToMainMenu.setLayoutY(580);
    backToMainMenu.setPrefSize(100,50);
    backToMainMenu.setFont(new Font("Yu Gothic UI Semilight",14));


    GridPane enemyCreatorPane = new GridPane();

    Label enemyLabel = new Label("Create your enemies! Limit 5");
    enemyLabel.setTextFill(Color.DARKSLATEGRAY);
    enemyLabel.setFont(new Font("MS Gothic", 18));
    TextField enemyTextField = new TextField();
    enemyTextField.setPromptText("How many enemies?");
    enemyCreatorPane.addRow(2, enemyTextField);
    enemyCreatorPane.addRow(3, createInputEnemies);
    enemyCreatorPane.addRow(1, enemyLabel);

    backToMainMenu.setOnAction(actionEvent -> {
      try {
        stage.setScene(mainMenuScene());
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }

    });

    characterLineUp.setOnAction(actionEvent -> {
      try {
        stage.setScene(preGameScene());
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    });




    createInputEnemies.setOnAction(actionEvent -> {
      for(int j = 0; j< Integer.parseInt(enemyTextField.getText()); j++){
        controller.enemyCreator("enemy"+j, new Random().nextInt( 40-15 ) +  15,
                new Random().nextInt(200-70) + 70, new Random().nextInt(40-10) + 10,
                new Random().nextInt(70-30) + 30);
        enemyMask.put(controller.getFromEnemy(j).getName(), controller.getEnemySize());

      }
      enemyTextField.setText("");
    });

    GridPane characterRoot = new GridPane();
    characterRoot.setHgap(40);
    characterRoot.setVgap(20);
    characterRoot.setPadding(new Insets(30, 20, 30,20));
    characterRoot.addRow(0, titlePane);
    characterRoot.addRow(0,wMageCreator);
    characterRoot.addColumn(2,bMageCreator);
    characterRoot.addColumn(1,knightCreator);
    characterRoot.addColumn(2,engineerCreator);
    characterRoot.addColumn(3,thiefCreator);
    characterRoot.addRow(1, enemyCreatorPane);

    Group characterSceneGroup = new Group();
    characterSceneGroup.getChildren().addAll(characterRoot, background, backToMainMenu, characterLineUp);



    startAnimator();
    return new Scene(characterSceneGroup, 1280,720);


  }

  /**
   * scene for the weapon creation
   * @return
   * @throws FileNotFoundException
   */
  public Scene weaponScene() throws FileNotFoundException {

    Label sceneTitle = new Label("CREATE YOUR WEAPONS");
    sceneTitle.setFont(new Font("MS Gothic", 20));
    sceneTitle.setTextFill(Color.ANTIQUEWHITE);
    weaponCreatedLabel = new Label("");

    GridPane titlePane = new GridPane();
    titlePane.addRow(0, sceneTitle);
    titlePane.addRow(1, weaponCreatedLabel);

    Image palace = new Image(new FileInputStream("src/main/resources/WeaponBackground.png"));
    ImageView background = new ImageView(palace);
    background.setMouseTransparent(true);
    background.isPreserveRatio();
    background.fitWidthProperty().bind(stage.widthProperty());
    background.setViewOrder(0.4);
    background.setOpacity(0.9);

    GridPane axeCreator = weaponGridPane("Create Axe");
    GridPane bowCreator = weaponGridPane("Create Bow");
    GridPane staffCreator = weaponGridPane("Create Staff");
    GridPane knifeCreator = weaponGridPane("Create Knife");
    GridPane swordCreator = weaponGridPane("Create Sword");
    Button backToMainMenu = new Button("Back");
    Button lineUpButton = new Button("View line up");

    lineUpButton.setLayoutX(20);
    lineUpButton.setLayoutY(480);
    lineUpButton.setPrefSize(100,50);
    lineUpButton.setFont(new Font("Yu Gothic UI Semilight",14));

    backToMainMenu.setLayoutX(20);
    backToMainMenu.setLayoutY(580);
    backToMainMenu.setPrefSize(100,50);
    backToMainMenu.setFont(new Font("Yu Gothic UI Semilight",14));

    backToMainMenu.setOnAction(actionEvent -> {
      try {
        stage.setScene(mainMenuScene());
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }

    });

    lineUpButton.setOnAction(actionEvent -> {
      try {
        stage.setScene(preGameScene());
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    });



    GridPane weaponRoot = new GridPane();
    weaponRoot.setHgap(40);
    weaponRoot.setVgap(20);
    weaponRoot.setPadding(new Insets(30, 20, 30,20));
    weaponRoot.addRow(0, titlePane);
    weaponRoot.addRow(0,axeCreator);
    weaponRoot.addColumn(2,bowCreator);
    weaponRoot.addRow(1,staffCreator);
    weaponRoot.addColumn(1,knifeCreator);
    weaponRoot.addColumn(2,swordCreator);


    Group weaponGroup = new Group();

    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(final long now) {
        weaponCreatedLabel.setText("You have created "+ controller.getInventorySpace() + " weapons" );
        weaponCreatedLabel.setTextFill(Color.ANTIQUEWHITE);
        weaponCreatedLabel.setFont(new Font("Franklin Gothic Medium Cond", 18));
      }
    };
    timer.start();

    weaponGroup.getChildren().addAll(weaponRoot, background, lineUpButton, backToMainMenu);
    return new Scene(weaponGroup, 1280,720);

  }

  /**
   * scene of the pregame to equip weapons to start the game
   * @return
   * @throws FileNotFoundException
   */
  public Scene preGameScene() throws FileNotFoundException {

    VBox characterBox = characterVBox(true, 0,0,0);
    VBox enemyBox = enemyVBox(true,0,0,0 );
    FlowPane inventoryBox = inventoryBox();
    GridPane equipGroup = equipGroup(true);
    Button backToCharacter = new Button("Back to Character");
    Button backToWeapon = new Button("Back to Weapon");
    Button backToManu = new Button("Back to Main Menu");

    Image kiminonawa = new Image(new FileInputStream("src/main/resources/pregameBackground.jpg"));
    ImageView background = new ImageView(kiminonawa);
    background.setFitHeight(720);
    background.setFitWidth(1280);
    background.setMouseTransparent(true);
    background.isPreserveRatio();
    background.fitWidthProperty().bind(stage.widthProperty());
    background.setViewOrder(0.4);


    backToCharacter.setLayoutX(20);
    backToCharacter.setLayoutY(680);
    backToCharacter.setPrefSize(150,30);
    backToCharacter.setFont(new Font("Yu Gothic UI Semilight",14));


    backToWeapon.setLayoutX(200);
    backToWeapon.setLayoutY(680);
    backToWeapon.setPrefSize(150,30);
    backToWeapon.setFont(new Font("Yu Gothic UI Semilight",14));

    backToManu.setLayoutX(400);
    backToManu.setLayoutY(680);
    backToManu.setPrefSize(150,30);
    backToManu.setFont(new Font("Yu Gothic UI Semilight",14));



    backToCharacter.setOnAction(actionEvent -> {
      try {
        stage.setScene(characterScene());
        playSound();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }

    });

    backToWeapon.setOnAction(actionEvent -> {
      try {
        stage.setScene(weaponScene());
        gunSound();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }

    });

    backToManu.setOnAction(actionEvent -> {
      try {
        stage.setScene(mainMenuScene());
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }

    });



    Group gameGroup = new Group();
    characterBox.setLayoutX(200);
    characterBox.setLayoutY(50);

    enemyBox.setLayoutX(900);
    enemyBox.setLayoutY(50);

    equipGroup.setLayoutX(210);
    equipGroup.setLayoutY(350);

    inventoryBox.setLayoutX(700);
    inventoryBox.setLayoutY(330);
    gameGroup.getChildren().addAll(background, characterBox, enemyBox, backToCharacter, inventoryBox, backToWeapon, equipGroup,
            backToManu);


    return new Scene(gameGroup, 1280,720);
  }

  /**
   * scene for the main game
   * @return
   * @throws FileNotFoundException
   */
  public Scene mainGameScene() throws FileNotFoundException {

    Image hanamura = new Image(new FileInputStream("src/main/resources/maingameBackground.jpg"));
    ImageView background = new ImageView(hanamura);
    background.setMouseTransparent(true);
    background.isPreserveRatio();
    background.fitWidthProperty().bind(stage.widthProperty());
    background.setViewOrder(0.4);

    Image boxesImg = new Image(new FileInputStream("src/main/resources/maingameBox.png"));
    ImageView boxback = new ImageView(boxesImg);
    boxback.setMouseTransparent(true);
    boxback.isPreserveRatio();
    boxback.fitWidthProperty().bind(stage.widthProperty());
    boxback.setViewOrder(0.4);
    boxback.setOpacity(0.5);

    VBox characterBox = characterVBox(false, 1,1,1);
    VBox enemyBox = enemyVBox(false, 1, 1, 1);

    characterBox.setLayoutX(200);
    characterBox.setLayoutY(50);

    enemyBox.setLayoutX(900);
    enemyBox.setLayoutY(50);

    Label onTurnLabel = new Label("Now is: " + controller.getActualName() + "'s turn");
    onTurnLabel.setFont(new Font("Arial rounded Mt Bold", 16));
    onTurnLabel.setLayoutX(580);
    onTurnLabel.setLayoutY(30);

    Label pastEnemyAttack = new Label("");
    pastEnemyAttack.setFont(new Font("Arial rounded Mt Bold", 16));
    pastEnemyAttack.setLayoutX(580);
    pastEnemyAttack.setLayoutY(50);

    GridPane playerPane = new GridPane();

    Button backToInventoryButton = new Button("Go to inventory");

    Button AttackButton = new Button("Attack");



    TextField selectTargetField = new TextField("");
    selectTargetField.setPromptText("Select your target");

    playerPane.addRow(1, backToInventoryButton);
    playerPane.addRow(2, AttackButton);
    playerPane.addColumn(0, selectTargetField);
    playerPane.setHgap(20);
    playerPane.setVgap(20);

    playerPane.setLayoutX(500);
    playerPane.setLayoutY(500);

    AttackButton.setOnAction(actionEvent -> {
      if(controller.getActualCharacter().getCharacter() == 1) {
        int enemyPos = enemyMask.get(selectTargetField.getText());
        if(controller.getFromEnemy(enemyPos - 1).isAlive()) {
          controller.tryToAttack(controller.getActualCharacter(), controller.getFromEnemy(enemyPos - 1));
        }

        if (controller.winner()) {
          try {
            stage.setScene(gameOverScene("src/main/resources/victorybackground.png"));
            winSound();
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
        } else {
          try {

            stage.setScene(mainGameScene());

          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
        }
      }
    });

    backToInventoryButton.setOnAction(actionEvent -> {
      if(controller.getActualCharacter().getCharacter() == 1){
        try {
          stage.setScene(inGameInventory());
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
      }

    });

    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(final long now) {
        onTurnLabel.setText("now is: " + controller.getActualName() + " turn");
        pastEnemyAttack.setText(controller.getLog());

        if(controller.looser() && !takengameOver){
          takengameOver = true;
          try {
            stage.setScene(gameOverScene("src/main/resources/loserbackground.png"));
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
        }


      }
    };
    timer.start();

    Group mainGameGroup = new Group();
    mainGameGroup.getChildren().addAll(background,characterBox, enemyBox, playerPane, onTurnLabel,
            boxback, pastEnemyAttack);
    return new Scene(mainGameGroup, 1280,720);

  }

  /**
   * scene when the game is over
   * 2 variants, if lose choose the file with the losebackground path
   * if win, use the winbackground path
   * @param path
   * @return
   * @throws FileNotFoundException
   */
  public Scene gameOverScene(String path) throws FileNotFoundException {

    Image victoryRoyale = new Image(new FileInputStream(path));
    ImageView background = new ImageView(victoryRoyale);
    background.setMouseTransparent(true);

    background.setViewOrder(0.4);

    Button exitButton = new Button("Exit");
    exitButton.setLayoutX(500);
    exitButton.setLayoutY(370);
    exitButton.setPrefSize(120,30);
    exitButton.setFont(new Font("Yu Gothic UI Semilight",14));

    Button resetButton = new Button("Play Again");
    resetButton.setLayoutX(680);
    resetButton.setLayoutY(370);
    resetButton.setPrefSize(120,30);
    resetButton.setFont(new Font("Yu Gothic UI Semilight",14));



    exitButton.setOnAction(actionEvent -> {
      Platform.exit();
    });

    resetButton.setOnAction(actionEvent -> {
      this.controller = new GameController();
      try {
        stage.setScene(mainMenuScene());
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    });

    Group victoryGroup = new Group();
    victoryGroup.getChildren().addAll(background, exitButton, resetButton);


    return new Scene(victoryGroup, 1280, 720);

  }


  /**
   * grid pane for the character scene creator
   * @param type
   * @return
   */
  public GridPane characterGridPane(String type){
    GridPane root = new GridPane();

    Label Name=new Label("Name");
    Name.setTextFill(Color.PURPLE);
    Name.setFont(new Font("MS Gothic", 18));
    Label Hp = new Label("Hp");
    Hp.setTextFill(Color.PURPLE);
    Hp.setFont(new Font("MS Gothic", 18));
    Label Defense = new Label("Defense");
    Defense.setTextFill(Color.PURPLE);
    Defense.setFont(new Font("MS Gothic", 18));


    TextField nameInput = new TextField();
    nameInput.setText("");
    TextField hpInput = new TextField();
    hpInput.setText("");
    TextField defenseInput = new TextField();
    defenseInput.setText("");



    Button characterButton = new Button(type);

      if ("Create BlackMage".equals(characterButton.getText())) {
        characterButton.setOnAction(action -> {
          controller.blackMageCreator(nameInput.getText(), Integer.parseInt(hpInput.getText()),
                  Integer.parseInt(defenseInput.getText()), 10);
          playerMask.put(nameInput.getText(), controller.getPartySize());
          nameInput.setText("");
          hpInput.setText("");
          defenseInput.setText("");
        });
      } else if ("Create WhiteMage".equals(characterButton.getText())) {
        characterButton.setOnAction(action -> {
          controller.whiteMageCreator(nameInput.getText(), Integer.parseInt(hpInput.getText()),
                  Integer.parseInt(defenseInput.getText()), 10);
          playerMask.put(nameInput.getText(), controller.getPartySize());
          nameInput.setText("");
          hpInput.setText("");
          defenseInput.setText("");
        });
      } else if ("Create Knight".equals(characterButton.getText())) {
        characterButton.setOnAction(action -> {
          controller.knightCreator(nameInput.getText(), Integer.parseInt(hpInput.getText()),
                  Integer.parseInt(defenseInput.getText()));
          playerMask.put(nameInput.getText(), controller.getPartySize());
          nameInput.setText("");
          hpInput.setText("");
          defenseInput.setText("");
        });
      } else if ("Create Thief".equals(characterButton.getText())) {
        characterButton.setOnAction(action -> {
          controller.thiefCreator(nameInput.getText(), Integer.parseInt(hpInput.getText()),
                  Integer.parseInt(defenseInput.getText()));
          playerMask.put(nameInput.getText(), controller.getPartySize());
          nameInput.setText("");
          hpInput.setText("");
          defenseInput.setText("");
        });
      } else if ("Create Engineer".equals(characterButton.getText())) {
        characterButton.setOnAction(action -> {
          controller.engineerCreator(nameInput.getText(), Integer.parseInt(hpInput.getText()),
                  Integer.parseInt(defenseInput.getText()));
          playerMask.put(nameInput.getText(), controller.getPartySize());
          nameInput.setText("");
          hpInput.setText("");
          defenseInput.setText("");
        });
      }



    root.addRow(0, Name, nameInput);
    root.addRow(1, Hp, hpInput);
    root.addRow(2, Defense, defenseInput);
    root.addRow(3, characterButton);

    return root;
  }

  /**
   * grid pane for the weapon scene creator
   * @param type
   * @return
   */
  public GridPane weaponGridPane(String type){
    GridPane root = new GridPane();

    Label Name=new Label("Name");
    Name.setTextFill(Color.ANTIQUEWHITE);


    TextField nameInput = new TextField();
    nameInput.setText("");

    Button weaponButton = new Button(type);
    weaponButton.setPrefSize(110,30);
    weaponButton.setFont(new Font("Yu Gothic UI Semilight",14));

    if ("Create Axe".equals(weaponButton.getText())) {
      weaponButton.setOnAction(action -> {
        nameInput.setPromptText("Axe name");
        controller.axeCreator(nameInput.getText(), new Random().nextInt(75-40) + 40,
                new Random().nextInt(30) + 10);
        nameInput.setText("");
      });
    } else if ("Create Bow".equals(weaponButton.getText())) {
      weaponButton.setOnAction(action -> {
        nameInput.setPromptText("Bow name");
        controller.bowCreator(nameInput.getText(), new Random().nextInt(70-50) + 50,
                new Random().nextInt(40-15) + 15);


        nameInput.setText("");

      });
    } else if ("Create Staff".equals(weaponButton.getText())) {
      weaponButton.setOnAction(action -> {
        nameInput.setPromptText("Staff name");
        controller.staffCreator(nameInput.getText(),30,
                 10, 0);

        nameInput.setText("");

      });
    } else if ("Create Knife".equals(weaponButton.getText())) {
      weaponButton.setOnAction(action -> {
        nameInput.setPromptText("Knife name");
        controller.knifeCreator(nameInput.getText(), new Random().nextInt(80-20)+ 40,
                new Random().nextInt(20) + 10);

        nameInput.setText("");

      });
    } else if ("Create Sword".equals(weaponButton.getText())) {
       weaponButton.setOnAction(action -> {
         nameInput.setPromptText("Sword name");
        controller.swordCreator(nameInput.getText(), new Random().nextInt(140-120) + 120,
                new Random().nextInt(50-10) + 30);
        nameInput.setText("");
      });
    }


    root.addRow(0, Name, nameInput);
    root.addRow(2, weaponButton);
    return root;
  }

  /**
   * Scene for the ingame Inventory
   * @param
   * @return
   */
  public Scene inGameInventory() throws FileNotFoundException {


    VBox characterBox = characterVBox(true, 0,0,0);
    FlowPane inventoryBox = inventoryBox();
    GridPane equipGroup = equipGroup(false);

    Image kiminonawa = new Image(new FileInputStream("src/main/resources/pregameBackground.jpg"));
    ImageView background = new ImageView(kiminonawa);
    background.setFitHeight(720);
    background.setFitWidth(1280);
    background.setMouseTransparent(true);
    background.isPreserveRatio();
    background.fitWidthProperty().bind(stage.widthProperty());
    background.setViewOrder(0.4);

    Button backToGame = new Button("Back to Game");
    backToGame.setLayoutX(20);
    backToGame.setLayoutY(680);
    backToGame.setPrefSize(150,30);
    backToGame.setFont(new Font("Yu Gothic UI Semilight",14));

    backToGame.setOnAction(actionEvent -> {
      try {
        stage.setScene(mainGameScene());
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    });



    Group gameGroup = new Group();
    characterBox.setLayoutX(200);
    characterBox.setLayoutY(50);


    equipGroup.setLayoutX(210);
    equipGroup.setLayoutY(350);

    inventoryBox.setLayoutX(700);
    inventoryBox.setLayoutY(330);
    gameGroup.getChildren().addAll(background, characterBox, inventoryBox, equipGroup, backToGame);


    return new Scene(gameGroup, 1280,720);

  }


  /**
   * vbox for the character layout
   * @param
   * @return
   */
  public VBox characterVBox(boolean bool, double r, double g, double b){
    VBox box = new VBox(15);
    Label characterLabel = new Label("Player's Line up");
    characterLabel.setScaleX(3);
    characterLabel.setScaleY(3);
    box.getChildren().add(characterLabel);

    if(bool == false){
      characterLabel.setVisible(false);
    }

    for(var characters: controller.getParty()) {
      String name = controller.getCharacterName(characters);
      int hp = controller.getCharacterHp(characters);
      final int totalHp = characters.getTotalHp();
      int def = controller.getCharacterDef(characters);
      Label characterStats = new Label("");
      characterStats.setFont(new Font("Gill Sans MT", 14));
      characterStats.setTextFill(Color.color(r,g,b));
      if(characters.isAlive()) {
         characterStats.setText("Character: " + name + " Hp: " + hp + "/" + totalHp + " Def : " + def + "\n"
                + "Weapon: " + controller.getCharacterWeaponName(characters)
                + "\ndamage: " + controller.getCharacterAttack(characters));
        box.getChildren().add(characterStats);
      }
      else{
        characterStats.setText("Character: " + name + " is dead");
        box.getChildren().add(characterStats);
      }
    }
    return box;

  }


  /**
   * vbox for the enemy layout
   * @param
   * @return
   */
  public VBox enemyVBox(Boolean bool, double r, double g, double b){
    VBox box = new VBox(15);
    Label enemyLabel = new Label("Enemies' Line up");
    enemyLabel.setScaleX(3);
    enemyLabel.setScaleY(3);
    box.getChildren().add(enemyLabel);

    if(bool == false){
      enemyLabel.setVisible(false);
    }


    for(var characters: controller.getEnemyParty()){

        String name = controller.getCharacterName(characters);
        int hp = controller.getCharacterHp(characters);
        final int totalHp = characters.getTotalHp();
        int def = controller.getCharacterDef(characters);
        Label enemyStats = new Label("");
        enemyStats.setFont(new Font("Gill Sans MT", 14));
        enemyStats.setTextFill(Color.color(r,g,b));
      if(characters.isAlive()) {
        enemyStats.setText("Enemy: " + name + " Hp: " + hp + "/" + totalHp + " Def : " + def + "\n"
                + "damage: " + controller.getCharacterAttack(characters));
        box.getChildren().add(enemyStats);
      }
      else {
        enemyStats.setText("Enemy: " + name + " is dead");
        box.getChildren().add(enemyStats);
      }

    }

    return box;

  }
  /**
   * Flowpane for the inventory layour
   * @param
   * @return
   */
  public FlowPane inventoryBox(){
    FlowPane box = new FlowPane();
    box.setAlignment(Pos.CENTER);
    box.setPadding(new Insets(30,20,30,20));
    box.setHgap(20);
    box.setVgap(20);
    Label inventoryLabel = new Label("Inventory");

    inventoryLabel.setScaleX(3);
    inventoryLabel.setScaleY(3);
    inventoryLabel.setLayoutX(10);
    box.getChildren().add(inventoryLabel);


    FlowPane fullInventory = new FlowPane();
    fullInventory.setHgap(20);
    fullInventory.setVgap(10);

    for(var weapons: controller.getInventory().entrySet()) {
      String name = weapons.getKey();
      int damage = weapons.getValue().getDamage();
      GridPane grid = new GridPane();
      Label weaponName = new Label("Weapon : " + name );
      weaponName.setFont(new Font("Gill Sans MT", 14));
      Label weaponDmg = new Label("Damage: " + damage);
      weaponDmg.setFont(new Font("Gill Sans MT", 14));

      grid.addRow(0, weaponName);
      grid.addRow(1, weaponDmg);
      grid.setLayoutX(30);
      grid.setLayoutY(30);
      grid.setHgap(10);
      grid.setVgap(5);
      fullInventory.getChildren().add(grid);
    }
    box.getChildren().add(fullInventory);
    return box;

  }


  /**
   * GridPpane for the equip group
   * @param
   * @return
   */
  public GridPane equipGroup(boolean bool){

    GridPane equipGroup = new GridPane();

    Label title = new Label("Equip your weapons");
    title.setScaleX(2.5);
    title.setScaleY(2.5);
    Button equipButton = new Button("Equip Weapon");
    equipButton.setPrefSize(150,30);
    equipButton.setLayoutX(150);
    equipButton.setLayoutY(70);
    equipButton.setFont(new Font("Yu Gothic UI Semilight",14));

    TextField characterTextField = new TextField();
    TextField weaponTextField = new TextField();
    characterTextField.setPromptText("Character name");

    weaponTextField.setPromptText("Weapon Name");

    equipButton.setOnAction(actionEvent -> {
      int charPos = playerMask.get(characterTextField.getText());
      controller.tryToEquip(controller.selectInventoryItem(weaponTextField.getText()),
              controller.getFromParty(charPos-1));
      characterTextField.setText("");
      weaponTextField.setText("");
      try {
        if(bool == true){
          stage.setScene(preGameScene());
        }
        else{
          stage.setScene(inGameInventory());
        }

      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    });
    equipGroup.setVgap(20);
    equipGroup.setHgap(20);
    equipGroup.addRow(0, title);
    equipGroup.addRow(2,characterTextField);
    equipGroup.addRow(3,weaponTextField);
    equipGroup.addColumn(0,equipButton);
    return equipGroup;

  }




  /**
   * animator to refresh layouts
   * @param
   * @return
   */
  private void startAnimator() {
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(final long now) {
        playerCreatedLabel.setText("There are "+ controller.getPartySize()+"/"+controller.getPartyNum() +
                " characters in the party");
        playerCreatedLabel.setFont(new Font("Franklin Gothic Medium Cond", 18));
        playerCreatedLabel.setTextFill(Color.LIGHTYELLOW);
        enemyCreatedLabel.setText("There are "+ controller.getEnemyParty().size()+ " enemies");
        enemyCreatedLabel.setTextFill(Color.LIGHTYELLOW);
        enemyCreatedLabel.setFont(new Font("Franklin Gothic Medium Cond", 18));



      }
    };
    timer.start();
  }

  /**
   * sound for the character Scene
   * @param
   * @return
   */
  private static void playSound() {
    String audioFilePath = "src/main/resources/chooseyourcharacter.wav";
    try {
      Clip sound = AudioSystem.getClip();
      try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
              new File(audioFilePath))) {
        sound.open(audioInputStream);
        sound.start();
      }
    } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * sound for the weapon Scene
   * @param
   * @return
   */
  private static void gunSound() {
    String audioFilePath = "src/main/resources/weapon.wav";
    try {
      Clip sound = AudioSystem.getClip();
      try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
              new File(audioFilePath))) {
        sound.open(audioInputStream);
        sound.start();
      }
    } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
      e.printStackTrace();
    }
  }
  /**
   * sound when the player wins
   * @param
   * @return
   */
  private static void winSound() {
    String audioFilePath = "src/main/resources/fortnite.wav";
    try {
      Clip sound = AudioSystem.getClip();
      try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
              new File(audioFilePath))) {
        sound.open(audioInputStream);
        sound.start();

      }
    } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * sound when the game start
   * @param
   * @return
   */
  private static void startSound() {
    String audioFilePath = "src/main/resources/321go.wav";
    try {
      Clip sound = AudioSystem.getClip();
      try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
              new File(audioFilePath))) {
        sound.open(audioInputStream);
        sound.start();

      }
    } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
      e.printStackTrace();
    }
  }




}