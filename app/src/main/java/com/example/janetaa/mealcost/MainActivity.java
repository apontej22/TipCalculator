package com.example.janetaa.mealcost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double mealCost;
    double tipPercentage;
    double tipAmount;
    String tipChoice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText cost = (EditText) findViewById(R.id.txtCost);
        final Spinner group = (Spinner) findViewById(R.id.txtGroup);
        group.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (group.getSelectedItemPosition() == 0) {
                    tipPercentage = 0.5;
                } else if (group.getSelectedItemPosition() == 1) {
                    tipPercentage = 0.10;
                } else if (group.getSelectedItemPosition() == 2) {
                    tipPercentage = 0.15;
                } else if (group.getSelectedItemPosition() == 3) {
                    tipPercentage = 0.20;
                }
                if (group.getSelectedItemPosition() == 4) {
                    tipPercentage = 0.25;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button tip = (Button)findViewById(R.id.btnTip);
            tip.setOnClickListener(new View.OnClickListener(){
                final TextView result = ((TextView)findViewById(R.id.txtResult));

                @Override
                public void onClick(View view){
                    mealCost = Double.parseDouble(cost.getText().toString());
                    tipChoice = group.getSelectedItem().toString();
                    DecimalFormat currency = new DecimalFormat("$###,###.##");
                    tipAmount = mealCost * tipPercentage;

                    result.setText("The tip amount is: "
                    + currency.format(tipAmount));
                }
            });

    }
}
