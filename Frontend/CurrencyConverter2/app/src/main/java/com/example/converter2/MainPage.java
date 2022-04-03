package com.example.converter2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    EditText cash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cash = findViewById(R.id.amount); //amount entered by the user to be converted
        setContentView(R.layout.activity_main_page);
        Spinner Convert = (Spinner) findViewById(R.id.spinner); // spinner that will let the user choose the convertion he wants
        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(MainPage.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Convertion));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Convert.setAdapter(myadapter);
    }

    public void convert(View view) {   //this function will check the value of the spinner and will convert the amount entered by the user accordingly
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        TextView text = findViewById(R.id.amount_Converted);
        String money = cash.getText().toString();         //takes the number entered by the user in the plain text and convert in to a string
        float amount = Float.parseFloat(money);          // convert the string to a float so we can use this variable to do the convertion

        if (spinner.getSelectedItemId() == 0) {// if the user chose USD to LBP the amount entered will be multiplied by the daily rate
            //amount * daily rate = newAmount;
            // text.setText(new amount.toString);
        } else if (spinner.getSelectedItemId() == 1) {// if the user chose LBP to USD the amount entered will be divided by the daily rate
            //amount * daily rate = newAmount;
            // text.setText(new amount.toString);
        }
    }
}