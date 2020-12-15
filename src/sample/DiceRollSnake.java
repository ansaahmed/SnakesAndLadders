package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DiceRollSnake extends Application {

    public static final int Tile_Size = 80;
    public static final int width = 10;
    public static final int height = 10;

    private Group tileGroup = new Group(); /*for adding root to main scene*/

    private Parent createContent(){
        StackPane root = new StackPane();
        root.setPrefSize( (width * Tile_Size), ((height* Tile_Size)+80)); /* dynamic, extra +80 row to add user buttons and stuff */
        root.getChildren().addAll(tileGroup); /*anything that we add to tileGroup gets added to main*/

        for(int i = 0; i< height; i++)
            for(int j=0; j< width; j++){

                Tile tile = new Tile(Tile_Size, Tile_Size);
                tile.setTranslateX(j * Tile_Size);
                tile.setTranslateY(i * Tile_Size);
                tileGroup.getChildren().add(tile);
            }

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
