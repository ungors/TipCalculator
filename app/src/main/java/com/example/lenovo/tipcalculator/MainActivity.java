package com.example.lenovo.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edt;
    SeekBar sb;
    Button btn;
    TextView tv;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt = (EditText) findViewById(R.id.edit_bill);
        sb = (SeekBar)findViewById(R.id.seekbar_percentage);
        btn = (Button) findViewById(R.id.btn_calculate);
        //btn.setOnClickListener((View.OnClickListener) this);
        tv = (TextView) findViewById(R.id.txt_percentage2);


        tv_result = (TextView) findViewById(R.id.txt_result);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            tv.setText(seekBar.getProgress()+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int percentage = seekBar.getProgress();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float totaltip;
                totaltip =(Float.parseFloat(edt.getText().toString())* sb.getProgress())/100 ;
                tv_result.setText("Total Tip: "+totaltip);
            }
        });
    }
}


