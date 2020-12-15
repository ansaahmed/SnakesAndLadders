package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;

public class DiceRollSnake extends Application {

    public int rand; //for generating random dice number
    public Label randResult;

    /*for debugging and monitoring game*/

    public int cirPos[][] = new int [10][10];
    public int ladderPosition[][] = new int [6][3];  //6 ladders and 3 snakes for now


    public static final int Tile_Size = 80;
    public static final int width = 10;
    public static final int height = 10;


    /*creating pawns for the game for 2 players*/

    public Circle player1;
    public Circle player2;
    public int playerPosition1 =1;
    public int playerPosition2=1;

    /*boolean variables to check if it's player 1's turn or 2's*/

    public boolean player1Turn = true;
    public boolean player2Turn = true;

    /*4 variables to put 2 player positions and move pawns*/


    /*player 1 positions*/
    public static int player1XPos =40;
    public static int player1YPos =760; //game starts from bottom
    /*player 2 positions*/
    public static int player2XPos =40;
    public static int player2YPos =740;

    /*player 1 positions*/
    public boolean gameStart = false; //set to false as we want them to press start button to start game

    public Button gameButton;


    private Group tileGroup = new Group(); /*for adding root to main scene*/

    private Parent createContent(){
            Pane root = new Pane();
            root.setPrefSize( (width * Tile_Size), ((height* Tile_Size)+80)); /* dynamic, extra +80 row to add user buttons and stuff */
            root.getChildren().addAll(tileGroup); /*anything that we add to tileGroup gets added to main*/

            for(int i = 0; i< height; i++)
                    for(int j=0; j< width; j++){

                            Tile tile = new Tile(Tile_Size, Tile_Size);   //creates a new tile using constructor from Tile class initialized with x,y
                            tile.setTranslateX(j * Tile_Size);     //changes values 0,0 to 80, 80 to 160, 160 on the basis of i, j values
                            tile.setTranslateY(i * Tile_Size);
                            tileGroup.getChildren().add(tile);
                    }

            /*create 2 circles*/

            player1 = new Circle(40 );  //created object of circle shape
            player1.setId("player1");  //options to style things using style.css
            player1.getStyleClass().add("style.css");
            /*translate circle positions*/
            player1.setTranslateX(player1XPos);
            player1.setTranslateY(player1YPos);


            player2 = new Circle(40 );   //created object of circle shape
            player2.setId("player1");  //options to style things using style.css
            player2.getStyleClass().add("style.css");
            /*translate circle positions*/
            player2.setTranslateX(player2XPos);
            player2.setTranslateY(player2YPos);

            /*creating buttons*/
            Button button1 = new Button("Player1");
            button1.setTranslateX(80);
            button1.setTranslateY(820);   //calculations on basis of grid system of Java
            button1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    /*first check if we've started the game only then run code*/
                    if(gameStart){
                        if(player1Turn){
                            /*get the value from rand num generator and then print out text.. method*/

                        }
                    }

                }
            }); //it will trigger circle 1 or 2 player to move, we use lambda expression to use the action on event

            //player 2 button
            Button button2 = new Button("Player2");
            button2.setTranslateX(700);
            button2.setTranslateY(820);
            button2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(gameStart){
                        if(player2Turn){
                            /*get the value from rand num generator and then print out text.. method*/
                        }
                    }
                }
            });

            /*global variable game button for starting game*/
            gameButton = new Button("Start Game");
            gameButton.setTranslateX(380);
            gameButton.setTranslateY(820);
            gameButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                        gameButton.setText("Game Started"); //ONCE WE PRESS BUTTON, EVERYTHING IS RESET
                        player1XPos = 40;
                        player1YPos = 760;

                        player2XPos = 40;
                        player2YPos = 760;

                        //will now set circle according to these values
                        player1.setTranslateX(player1XPos);
                        player1.setTranslateY(player1YPos);
                        player2.setTranslateX(player2XPos);
                        player2.setTranslateY(player2YPos);


                }
            });

            /*graphical stuff*/
            randResult = new Label("0");
            randResult.setTranslateX(300);
            randResult.setTranslateY(820);

            /*add image java.fx not awt*/
            Image img = new Image("sl2.png");
            ImageView bgImage = new ImageView(); //img view to show that image
            bgImage.setImage(img);
            bgImage.setFitHeight(800);
            bgImage.setFitWidth(800);


            /*add to tilegroup node gets added to pane*/
            tileGroup.getChildren().addAll(player1, player2, bgImage, button1, button2, gameButton);

            return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(createContent());
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); not creating application, creating game
        primaryStage.setTitle("Snake and Ladders");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
