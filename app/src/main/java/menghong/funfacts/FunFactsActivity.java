package menghong.funfacts;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class FunFactsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set this xml as layout
        setContentView(R.layout.activity_fun_facts);
        AssetManager assetManager = getAssets();
        InputStream iS = null;
        try {
            iS = assetManager.open("funfacts.json");
            System.out.println(iS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        final JsonParserOperation factsBook = new JsonParserOperation(iS);
        final ColorWheel colorWheel = new ColorWheel();

        // R is the auto generated class containing references to all ids
        // Required casting coz findView returns super class View
        final TextView factLabel = (TextView)findViewById(R.id.factTextView);
        final Button showFactButton = (Button) findViewById(R.id.showFactButton);
        final RelativeLayout overallLayOut = (RelativeLayout)findViewById(R.id.overallLayOut);

        // create a view Listener for passing to button
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            // This method will get executed when user clicks on this button
            public void onClick(View view) {
                // Update the factLabel
                factLabel.setText(factsBook.getFact());
                int colorForBoth = colorWheel.getColor();
                overallLayOut.setBackgroundColor(colorForBoth);
                showFactButton.setTextColor(colorForBoth);
            }
        };
        // Add onClickListener to button
        // It takes in a view Listener
        showFactButton.setOnClickListener(listener);
        //for outputting toast message
//        String message = System.getProperty("user.dir");
//        Toast welcomeToast = Toast.makeText(this, message, Toast.LENGTH_LONG);
//        welcomeToast.show();
    }
}
