package menghong.funfacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class FunFactsActivity extends Activity {
    private FactBook factBook = new FactBook();
    private ColorWheel colorWheel = new ColorWheel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set this xml as layout
        setContentView(R.layout.activity_fun_facts);
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
                factLabel.setText(factBook.getFact());
                int colorForBoth = colorWheel.getColor();
                overallLayOut.setBackgroundColor(colorForBoth);
                showFactButton.setTextColor(colorForBoth);
            }
        };
        // Add onClickListener to button
        // It takes in a view Listener
        showFactButton.setOnClickListener(listener);
    }
}
