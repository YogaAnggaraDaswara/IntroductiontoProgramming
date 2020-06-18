package com.yad.introductiontoprogrammingtk1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_hasil;
    EditText tb_nilai;
    Button button_hitung,button_clear;
    String nilai;
    double  pon, ons, gram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_hasil = (TextView) findViewById(R.id.textView_hasil);
        tb_nilai = (EditText) findViewById(R.id.tb_nilai);
        button_hitung = (Button) findViewById(R.id.button_hitung);
        button_clear= (Button) findViewById(R.id.button_clear);

        button_hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilai = tb_nilai.getText().toString();

                if (nilai.equals("")) {
                    tb_nilai.setError("Kolom Kg Tidak Boleh Kosong!!");
                    tb_nilai.setFocusable(true);
                }else{
                    tb_nilai.setError(null);
                    tv_hasil.setText(Hasil(Double.parseDouble(nilai)));
                }

            }
        });
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearData();
            }
        });
    }
    private String Hasil(double kilogram){
        //Compute pon
        pon = kilogram * 2;
        //Compute ons
        ons = pon * 5;
        //Compute gram
        gram = ons * 100;
        //Show Output
        return kilogram + " kg sama dengan = " + pon + " pon atau " + ons + " ons atau " + gram + " gram";
    }
    private void   clearData(){
        tv_hasil.setText("-");
        tb_nilai.setText("");
        tb_nilai.setError(null);

    }
}
