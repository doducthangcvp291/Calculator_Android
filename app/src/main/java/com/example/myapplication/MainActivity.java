package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {
    EditText rs ;
    EditText cal ;
    boolean isNewOp = true ;
    String oldNumber="";
    String calstring="";
    String op ="+";
    private EditText displayrs ;
    private EditText displaycal ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayrs = findViewById(R.id.result);
        displayrs.setShowSoftInputOnFocus(false);
        displaycal = findViewById(R.id.calculation);
        displaycal.setShowSoftInputOnFocus(false);
        rs= findViewById(R.id.result);
        cal=findViewById(R.id.calculation);
    }

    public void numberEvent(View view){
        if(isNewOp){
            rs.setText("");
            //cal.setText("");
        }
        isNewOp =false ;
        String number = rs.getText().toString();
        switch (view.getId()){
            case R.id.button_1:
                number += "1";
                    break;
            case R.id.button_2:
                number += "2";
                    break ;
            case R.id.button_3:
                number += "3";
                break;
            case R.id.button_4:
                number += "4";
                break ;
            case R.id.button_5:
                number += "5";
                break;
            case R.id.button_6:
                number += "6";
                break ;
            case R.id.button_7:
                number += "7";
                break;
            case R.id.button_8:
                number += "8";
                break ;
            case R.id.button_9:
                number += "9";
                break;
            case R.id.button_0:
                number += "0";
                break;
            case R.id.button_plusminus:
                number = "-"+number;
                break ;
            case R.id.button_dot:
                number += ".";
                break;
        }
        rs.setText(number);
    }
    public void operatorEvent(View view){
        isNewOp = true;
        oldNumber = rs.getText().toString();
        switch (view.getId()){
            case R.id.button_divide: op = "/"; break;
            case R.id.button_plus: op = "+"; break;
            case R.id.button_x: op = "*"; break;
            case R.id.button_minus: op = "-";break ;
        }
        calstring = oldNumber+" "+op ;
        cal.setText(calstring);
    }

    public void equalEvent(View view) {
        String newNumber = rs.getText().toString();
        calstring = calstring + " " + newNumber + " "+"=" ;
        cal.setText(calstring);
        double result = 0.0 ;
        switch (op){
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);break;
        }
        rs.setText(result+"");
    }

    public void C_Event(View view) {
        rs.setText("0");
        cal.setText("");
        isNewOp = true ;
    }

    public void backspaceEvent(View view) {
        int cursorPos = rs.getSelectionStart();
        int textLen = rs.getText().length();
        if (cursorPos !=0 && textLen !=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) rs.getText();
            selection.replace(cursorPos-1, cursorPos,"");
            rs.setText(selection);
            rs.setSelection(cursorPos-1);
        }
    }

    public void CE_Event(View view) {
        rs.setText("0");
        isNewOp = true ;
    }
}