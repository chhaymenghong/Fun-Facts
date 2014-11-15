package menghong.funfacts;

import android.graphics.Color;

import java.util.Random;

public class ColorWheel {
    public String[] colors = {"#39add1", "#3079ab", "#c25975", "#e15258",
                              "#f9845b","#838cc7", "#7d669e" , "#53bbb4" ,
                              "#51b46d" , "#e0ab18", "#637a91", "#f092b0"};
    public int getColor() {
        // Randomly selects question
        Random randomGenerator = new Random();
        int randNum = randomGenerator.nextInt(colors.length);
        //Converts hexadecimal string into hexadecimal color as integer
        return Color.parseColor(colors[randNum]);
    }

}
