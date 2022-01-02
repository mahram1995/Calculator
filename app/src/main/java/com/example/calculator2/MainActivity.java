package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView display, display1;
    private Button power, squar, sqroot, clear, delete, dots, parcentage, division, multiple, plus, minus, equal, zero, doublezero, one, two, three, four, five, six, seven, eight, nine;
    long n1;
    long n2;
    long result;
    long preResult = 0;
    double result1=1.0;
    double preResult1 =1.0;
    String displayValue = "";
    String operator;
    StringBuilder statements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // get all button;
        power = findViewById(R.id.power);
        squar = findViewById(R.id.squar);
        sqroot = findViewById(R.id.squarRoot);
        clear = findViewById(R.id.clear);
        delete = findViewById(R.id.delete);
        dots = findViewById(R.id.dots);
        parcentage = findViewById(R.id.parcentage);
        division = findViewById(R.id.division);
        multiple = findViewById(R.id.multiply);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        equal = findViewById(R.id.equal);
        zero = findViewById(R.id.zero);
        doublezero = findViewById(R.id.doubleZero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        display = findViewById(R.id.display);
        display1 = findViewById(R.id.display1);

        // set button onClick method;
        power.setOnClickListener(this);
        squar.setOnClickListener(this);
        sqroot.setOnClickListener(this);
        clear.setOnClickListener(this);
        delete.setOnClickListener(this);
        dots.setOnClickListener(this);
        parcentage.setOnClickListener(this);
        division.setOnClickListener(this);
        multiple.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        equal.setOnClickListener(this);
        zero.setOnClickListener(this);
        doublezero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);


        statements = new StringBuilder();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.clear) {
            result = 0;
            n1 = 0;
            n2 = 0;
            displayValue = "";
            preResult = 0;
            display.setText(displayValue);
            display1.setText("");
            statements = statements.delete(0, statements.length());
        }
        if (v.getId() == R.id.delete) {
            if (displayValue.length() > 0) {
                StringBuffer sb = new StringBuffer(displayValue);
                displayValue = sb.deleteCharAt(sb.length() - 1).toString();
                display.setText(displayValue);
            }
            if (statements.length() > 0) {
                statements.deleteCharAt(statements.length() - 1);
                display1.setText(statements);
            }
        }

        if (v.getId() == R.id.one) {
            displayValue = displayValue + 1;
            display.setText(displayValue);

        }
        if (v.getId() == R.id.two) {
            displayValue = displayValue + 2;
            display.setText(displayValue);
        }
        if (v.getId() == R.id.three) {
            displayValue = displayValue + 3;
            display.setText(displayValue);
        }
        if (v.getId() == R.id.four) {
            displayValue = displayValue + 4;
            display.setText(displayValue);
        }
        if (v.getId() == R.id.five) {
            displayValue = displayValue + 5;
            display.setText(displayValue);
        }
        if (v.getId() == R.id.six) {
            displayValue = displayValue + 6;
            display.setText(displayValue);
        }
        if (v.getId() == R.id.seven) {
            displayValue = displayValue + 7;
            display.setText(displayValue);
        }
        if (v.getId() == R.id.eight) {
            displayValue = displayValue + 8;
            display.setText(displayValue);
        }
        if (v.getId() == R.id.nine) {
            displayValue = displayValue + 9;
            display.setText(displayValue);
        }
        if (v.getId() == R.id.zero) {
            displayValue = displayValue + 0;
            display.setText(displayValue);
        }
        if (v.getId() == R.id.doubleZero) {
            displayValue = displayValue + 0 + 0;
            display.setText(displayValue);
        }
        if (v.getId() == R.id.dots) {
            displayValue = displayValue + ".";
            display.setText(displayValue);
        }
        if (v.getId() == R.id.plus) {
            n1 = 0;
            if (!displayValue.isEmpty()) {
                n1 = Long.parseLong(displayValue);
            }
            statements.append(displayValue + "+");
            preResult = preResult + n1;
            display.setText(String.valueOf(preResult));


            operator = "+";

            display1.setText(statements);
            displayValue = "";
        }
        if (v.getId() == R.id.minus) {
            n1 = 0;
            if (!displayValue.isEmpty()) {
                n1 = Long.parseLong(displayValue);
            }
            statements.append(displayValue + "-");
            if (preResult > 0) {
                preResult = preResult - n1;
                display.setText(String.valueOf(preResult));
            } else {
                preResult = n1;
            }

            operator = "-";

            display1.setText(statements);
            displayValue = "";
        }
        if (v.getId() == R.id.multiply) {
            if (!displayValue.isEmpty()) {
                n1 = Long.parseLong(displayValue);
            }
            statements.append(displayValue + "x");
            if (preResult == 0) {
                preResult = 1;
            }
            preResult = preResult * n1;
            display.setText(String.valueOf(preResult));

            operator = "*";

            display1.setText(statements);
            displayValue = "";
        }

        if (v.getId() == R.id.division) {
            if (!displayValue.isEmpty()) {
                n1 = Long.parseLong(displayValue);
            }
            statements.append(displayValue + "/");
            preResult = preResult / n1;
            display.setText(String.valueOf(preResult));

            operator = "/";

            display1.setText(statements);
            displayValue = "";
        }
        if (v.getId() == R.id.parcentage) {

            if (!displayValue.isEmpty()) {
                n1 = Long.parseLong(displayValue);
            }
            statements.append(displayValue + "%");
            display.setText("");
            operator = "%";
            display1.setText(statements);
            displayValue = "";
        }
        if (v.getId() == R.id.power) {
            if (!displayValue.isEmpty()) {
                n1 = Long.parseLong(displayValue);
            }
            statements.append(displayValue + "^");
            display.setText("");
            operator = "^";
            display1.setText(statements);
            displayValue = "";
        }
        if (v.getId() == R.id.squar) {
            if(statements.length()>0){
                statements = statements.delete(0, statements.length());
            }
            if (!displayValue.isEmpty()) {
                n1 = Long.parseLong(displayValue);
            }
            statements.append(displayValue + " ^ 2");
            result=n1*n1;
            display.setText(String.valueOf(result));
            operator = "squar";
            display1.setText(statements);
            displayValue = "";
        }
        if (v.getId() == R.id.squarRoot) {
            Double result;
            Double n1=0.0;
            if(statements.length()>0){
                statements = statements.delete(0, statements.length());
            }
            if (!displayValue.isEmpty()) {
                n1 = Double.parseDouble(displayValue);
            }
            statements.append(displayValue + " sqrt");
            result=  Math.sqrt(n1);
            display.setText(String.valueOf(result));
            operator = "squar";
            display1.setText(statements);
            displayValue = "";
        }
        if (v.getId() == R.id.equal) {
            equal();

        }
    }

    public void equal() {
        if (!displayValue.isEmpty() & !operator.isEmpty()) {
            n2 = Long.parseLong(displayValue);
            statements.append(displayValue);
            display1.setText(statements);
            if (preResult > 0) {
                if (operator.equals("+")) {
                    result = preResult + n2;
                    n1 = 0;
                    n2 = 0;
                }
                if (operator.equals("-")) {
                    result = preResult - n2;
                    n1 = 0;
                    n2 = 0;
                }
                if (operator.equals("*")) {
                    result = preResult * n2;
                    n1 = 1;
                    n2 = 1;
                }
                if (operator.equals("/")) {
                    result = preResult / n2;
                    n1 = 1;
                    n2 = 1;
                }
                if (operator.equals("%")) {
                    result = preResult * (n2/100);
                    n1 = 1;
                    n2 = 1;
                }
                if (operator.equals("^")) {
                    int power=(int)n2;
                    for(int i=1; i<=n2; i++){
                        result=preResult*i;
                    }
                    n1 = 1;
                    n2 = 1;
                }
            } else {
                if (operator.equals("+")) {
                    result = preResult + n1 + n2;
                    n1 = 0;
                    n2 = 0;
                }
                if (operator.equals("-")) {
                    result = preResult - n1 - n2;
                    n1 = 0;
                    n2 = 0;
                }
                if (operator.equals("*")) {
                    if (preResult == 0) {
                        preResult = 1;
                    }
                    result = preResult * n1 * n2;
                    n1 = 1;
                    n2 = 1;
                }
                if (operator.equals("/")) {
                    result = n1 / n2;
                    n1 = 1;
                    n2 = 1;
                }
                if (operator.equals("%")) {
                    DecimalFormat df = new DecimalFormat("####0.000");
                    result1=Double.parseDouble(df.format((double)(n1*n2/100)));
                    n1 = 0;
                    n2 = 0;
                }
                if (operator.equals("^")) {
                    result = n1;
                    for(int i=1; i<n2; i++){
                        result=result*n1;
                    }
                    n1 = 1;
                    n2 = 1;
                }
            }
           operator="";
            if(result>0){
                preResult = result;
                displayValue = "";
                display.setText(String.valueOf(result));
            }else{
                preResult1 = result1;
                displayValue = "";
                display.setText(String.valueOf(result1));
            }
        }
    }
}