package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.text.style.TtsSpan;
import android.view.View;
import android.view.textclassifier.TextClassification;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;



public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView time= (TextView) findViewById(R.id.Time);
        num1= (EditText) findViewById(R.id.num1);
        result= (TextView) findViewById(R.id.sum);

        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyyy h:mm a");
        String dateString = sdf.format(date);
        time.setText(dateString);

        num1.setRawInputType(InputType.TYPE_NULL);

    }

    public void addCharacter(View view) {
        Button temp= (Button) view;
        num1.setText(num1.getText().toString() + temp.getText().toString());
    }

    public void clearBoxes(View view){
        num1.setText("");
        num1.setHint("Enter Input Here");
        result.setText("");
        result.setHint("Result Here");
    }

    public void compute(View view){
        Button temp= (Button) view;
        if(num1.getText().toString().length() ==0 ){
            num1.setError("FIELD CANNOT BE EMPTY");
        }else{
            try{
                Expression expression = new ExpressionBuilder(num1.getText().toString()).build();
                double answer=expression.evaluate();
                result.setText(answer+"");
            }catch (Exception e){
                result.setText("INPUT ERROR, RE ENTER YOUR QUERY");
            }
        }
    }


}