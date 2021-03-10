package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Currency;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
public Spinner mySpinner;
public TextView myTextView;
public EditText currency;
public Double  total,num=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTextView = findViewById(R.id.data);
        currency = findViewById(R.id.currencyId);
        mySpinner = findViewById(R.id.mySpinnerID);
        ArrayAdapter<CharSequence> myAdapter = ArrayAdapter.createFromResource(this,R.array.countryName, android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String Text=parent.getItemAtPosition(position).toString();
        //String Currency = currency.getText().toString();
       // num = Double.parseDouble(currency.getText().toString());
       // myTextView.setText(""+convertCurrency);
       Double Currency = 10.0;
        if(Text.equals("BDT to USD")){
        total = Currency*0.012;
        }
        else if(Text.equals("USD to BDT")){
            total = Currency*84.94;

        }
        else if(Text.equals("BDT to SD")){
            total = Currency*0.016;

        }else{
           total = Currency*63.08;
        }
        myTextView.setText(""+total);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        myTextView.setText("0");
    }
}