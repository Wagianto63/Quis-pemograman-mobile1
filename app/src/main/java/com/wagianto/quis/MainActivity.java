package com.wagianto.quis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Nilai_Tugas, Nilai_Quis, Nilai_UTS, Nilai_UAS;
    Button Proses_hitung, Bersih;
    TextView hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nilai_Tugas = (EditText) findViewById(R.id.Nilai_Tugas);
        Nilai_Quis = (EditText) findViewById(R.id.Nilai_Quis);
        Nilai_UTS = (EditText) findViewById(R.id.Nilai_UTS);
        Nilai_UAS = (EditText) findViewById(R.id.Nilai_UAS);

        Proses_hitung = (Button)findViewById(R.id.Proses_hitung);
        Bersih = (Button) findViewById(R.id.Bersih);

        hasil = (TextView) findViewById(R.id.hasil);

        Proses_hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((Nilai_Tugas.getText().length()>0) && (Nilai_Quis.getText().length()>0) && (Nilai_UTS.getText().length()>0) && (Nilai_UAS.getText().length()>0))
                {
                    double tugas = Double.parseDouble(Nilai_Tugas.getText().toString());
                    double quis = Double.parseDouble(Nilai_Quis.getText().toString());
                    double uts = Double.parseDouble(Nilai_UTS.getText().toString());
                    double uas = Double.parseDouble(Nilai_UAS.getText().toString());
                    double result = (tugas*20/100) + (quis*20/100) + (uts*30/100) + (uas*30/100);
                    hasil.setText(Double.toString(result));
                }
                else {
                    Toast toast = Toast.makeText(MainActivity.this, "Mohon Masukkan Nilai", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });


        Bersih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nilai_Tugas.setText("");
                Nilai_Quis.setText("");
                Nilai_UTS.setText("");
                Nilai_UAS.setText("");
                hasil.setText("0");
                Nilai_Tugas.requestFocus();
            }
        });
    }
}
