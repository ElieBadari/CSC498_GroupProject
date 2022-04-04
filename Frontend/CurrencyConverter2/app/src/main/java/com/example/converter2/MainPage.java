package com.example.converter2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainPage extends AppCompatActivity {

    EditText cash;
    TextView text;
    Spinner spinner;
    String money;
    String amount;

    public class DownloadTask extends AsyncTask<String, Void, String> {

        public String rate = "";
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection http;

            try {
                url = new URL(urls[0]);
                http = (HttpURLConnection) url.openConnection();
                InputStream in = http.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();

                }

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

            return result;
        }


        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i("res", s);
            try {
                JSONObject json = new JSONObject(s);
                amount = json.getString("amount");//gets the converted amount from the db using the api
                String daily_rate = json.getString("rate");
                Log.i("result ", s);

            } catch (Exception e) {
                e.printStackTrace();

            }

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        cash = findViewById(R.id.amount); //amount entered by the user to be converted

        String url = "http://localhost/csc498x/CSC498X_GroupProject/Backend/get_values.php";
        DownloadTask task = new DownloadTask();
        task.execute(url);

        Spinner Convert = (Spinner) findViewById(R.id.spinner); // spinner that will let the user choose the convertion he wants
        ArrayAdapter<String> my_adapter = new ArrayAdapter<String>(MainPage.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Convertion));
        my_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Convert.setAdapter(my_adapter);



    }

    public void convert(View view) {   //this function will check the value of the spinner and will convert the amount entered by the user accordingly
        spinner = (Spinner) findViewById(R.id.spinner);
        text = findViewById(R.id.amount_Converted);
        money = cash.getText().toString();         //takes the number entered by the user in the plain text and convert in to a string
        float amount = Float.parseFloat(money);          // convert the string to a float so we can use this variable to do the convertion

        if (spinner.getSelectedItemId() == 0) {// if the user chose USD to LBP the amount entered will be multiplied by the daily rate
             text.setText(String.valueOf(amount));
        } else if (spinner.getSelectedItemId() == 1) {// if the user chose LBP to USD the amount entered will be divided by the daily rate
            //amount * daily rate = newAmount;
            // text.setText(new amount.toString);
        }
    }
}