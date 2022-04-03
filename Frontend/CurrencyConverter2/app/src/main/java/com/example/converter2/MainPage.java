package com.example.converter2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Spinner Convert = (Spinner) findViewById(R.id.spinner); // spinner that will let the user choose the convertion he wants
        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(MainPage.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Convertion));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Convert.setAdapter(myadapter);
    }
}