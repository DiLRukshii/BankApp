package com.example.mybank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txt_Loanamount;
    private TextView txt_InterestAmount,txt_TotalAmount;
    private Button btn_calculate;
    private Spinner spn_rate,spn_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_Loanamount=findViewById(R.id.txt_loanamount);
        txt_InterestAmount=findViewById(R.id.txt_interestamount);
        txt_TotalAmount=findViewById(R.id.txt_paybleamount);
        btn_calculate=findViewById(R.id.btn_cal);

        Spinner spinner1=(spn_rate);
        ArrayAdapter adapter1=ArrayAdapter.createFromResource(this,R.array.interestrate, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter1);

        Spinner spinner2=(spn_time);
        ArrayAdapter adapter2=ArrayAdapter.createFromResource(this,R.array.periode, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter2);

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int loanAmount,RateAmount,TotalAmount;
                int Rate,period;
                Rate=Integer.parseInt(spinner1.getSelectedItem().toString());
                period=Integer.parseInt(spinner2.getSelectedItem().toString());
                loanAmount=Integer.parseInt(txt_Loanamount.getText().toString());

                RateAmount=loanAmount*(Rate/100);
                txt_InterestAmount.setText(String.valueOf(RateAmount));

                TotalAmount=loanAmount+(RateAmount*period);
                txt_TotalAmount.setText(String.valueOf(TotalAmount));


            }
        });
    }
}