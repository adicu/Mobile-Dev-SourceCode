package me.donyu.nuggetfinder;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class NuggetFinderActivity extends ActionBarActivity {

    private Button searchButton;
    private TextView resultText;
    private EditText searchEditText;
    private ArrayList<Professor> professors;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nugget_finder);
        professors = new ArrayList<Professor>();
        Professor p = new Professor("Jae", "Lee", "gold");
        professors.add(p);
        
        searchButton = (Button) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String searchQuery = searchEditText.getText().toString();
                for (Professor p : professors) {
                    String result = p.checkSearch(searchQuery);
                    if (result != null) {
                        if (result.equals("gold")) {
                            resultText.setText("You got gold!");
                        } else if (result.equals("silver")) {
                            resultText.setText("You scored silver");
                        } else {
                            resultText.setText("No name professor");
                        }
                        return;
                    }
                }
                resultText.setText("You clicked me");
            }
        });
        
        resultText = (TextView) findViewById(R.id.result);
        searchEditText = (EditText) findViewById(R.id.editText1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nugget_finder, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
