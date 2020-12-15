package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle { //props of rect class are now available here


    public Tile(int x, int y){

        setWidth(DiceRollSnake.Tile_Size);  //as tile_size is static variable
        setHeight(DiceRollSnake.Tile_Size);

        setFill(Color.PINK);
        setStroke(Color.BLACK);


    }

}
