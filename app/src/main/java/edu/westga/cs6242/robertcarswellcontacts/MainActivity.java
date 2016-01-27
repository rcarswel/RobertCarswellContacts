package edu.westga.cs6242.robertcarswellcontacts;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String name;
    private String email;
    private String phone;
    private String phoneType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        this.name = "";
        this.email = "";
        this.phone = "";
        this.phoneType = "Cell";
        this.setResults();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void saveOnClick(View v) {
        // do something when the button is clicked
        this.setResults();
    }



    private void setResults() {
        this.name = ((EditText)findViewById(R.id.nameEditText)).getText().toString();
        this.email = ((EditText)findViewById(R.id.emailEditText)).getText().toString();
        this.phone = ((EditText)findViewById(R.id.phoneEditText)).getText().toString();
        this.phoneType = getPhoneType();


        TextView resultsTextView = (TextView) findViewById(R.id.resultTextView);
        resultsTextView.setText("Name: " + this.name + "\n"
                + "eMail: " + this.email + "\n"
                + this.phoneType + ": " + this.phone);
    }

    private String getPhoneType() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioPhone);
        RadioButton land = (RadioButton) findViewById(R.id.landlineRadio);
        RadioButton cell = (RadioButton) findViewById(R.id.cellRadio);

        int selectedID = radioGroup.getCheckedRadioButtonId();
        if (selectedID == land.getId()) {
            return "Landline";
        } else if (selectedID == cell.getId()) {
            return "Cell";
        } else {
            return "Error";
        }
    }
}
