package com.example.convertsuhu;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TemperatureActivity extends AppCompatActivity {

    EditText etSuhu;
    Spinner Opsi;
    Button btnConvert, btnClear;
    TextView tvhasilKonversi;
    private String Pilihan[] = {"-ConverTemp Option-","\u00B0Celsius to Kelvin", "\u00B0Celsius to \u00B0Fahrenheit", "\u00B0Celsius to \u00B0Reamur", "Kelvin to \u00B0Celsius",
            "Kelvin to \u00B0Fahrenheit", "Kelvin to \u00B0Reamur", "\u00B0Fahrenheit to \u00B0Celsius", "\u00B0Fahrenheit to Kelvin",
            " \u00B0Fahrenheit to \u00B0Reamur", "\u00B0Reamur to \u00B0Celsius", " \u00B0Reamur to Kelvin", " \u00B0Reamur to \u00B0Fahrenheit"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        etSuhu = findViewById(R.id.etSuhu);
        Opsi = findViewById(R.id.Opsi);
        btnConvert = findViewById(R.id.btnConvert);
        btnClear = findViewById(R.id.btnClear);
        tvhasilKonversi = findViewById(R.id.tvhasilKonversi);

        ArrayAdapter adapter = new ArrayAdapter(
                TemperatureActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                Pilihan
        );

        Opsi.setAdapter(adapter);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSuhu.setText("");
                tvhasilKonversi.setText("");
            }
        });

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getSuhu = etSuhu.getText().toString();

                if(getSuhu.isEmpty()){
                    Toast.makeText(TemperatureActivity.this, "Maaf, Suhu Awal Masih Kosong!!", Toast.LENGTH_SHORT).show();
                }else{
                    double suhu = Double.valueOf(etSuhu.getText().toString());
                    double hasil;
                    int Spinner = Opsi.getSelectedItemPosition();
                    switch (Spinner){
                        case 0 :
                            Toast.makeText(TemperatureActivity.this, "Maaf, Silahkan Pilih Opsi Konversinya!!", Toast.LENGTH_SHORT).show();
                            break;
                        case 1://\u00B0Celsius to Kelvin
                            hasil = suhu + 273;
                            tvhasilKonversi.setText(String.valueOf(hasil) + " °K");
                            break;
                        case 2://\u00B0Celsius to \u00B0Fahrenheit
                            hasil = 9.0/5.0 * suhu + 32;
                            tvhasilKonversi.setText(String.valueOf(hasil) + " °F");
                            break;
                        case 3://\u00B0Celsius to \u00B0Reamur
                            hasil = 4.0/5.0 * suhu;
                            tvhasilKonversi.setText(String.valueOf(hasil) + " °R");
                            break;
                        case 4://Kelvin to \u00B0Celsius
                            hasil = suhu - 273;
                            tvhasilKonversi.setText(String.valueOf(hasil) + " °C");
                            break;
                        case 5://Kelvin to \u00B0Fahrenheit
                            hasil = 9.0/5.0 * (suhu - 273) + 32;
                            tvhasilKonversi.setText(String.valueOf(hasil) + " °F");
                            break;
                        case 6://Kelvin to \u00B0Reamur
                            hasil = 4.0/5.0 * (suhu - 273);
                            tvhasilKonversi.setText(String.valueOf(hasil) + " °R");
                            break;
                        case 7://\u00B0Fahrenheit to \u00B0Celsius
                            hasil = 5.0/9.0 * (suhu - 32);
                            tvhasilKonversi.setText(String.valueOf(hasil) + " °C");
                            break;
                        case 8://\u00B0Fahrenheit to Kelvin
                            hasil = 5.0/9.0 * (suhu - 32) + 273;
                            tvhasilKonversi.setText(String.valueOf(hasil) + " °K");
                            break;
                        case 9://\u00B0Fahrenheit to \u00B0Reamur
                            hasil = 4.0/9.0 * (suhu - 32);
                            tvhasilKonversi.setText(String.valueOf(hasil) + " °R");
                            break;
                        case 10://\u00B0Reamur to \u00B0Celsius
                            hasil = 5.0/4.0 * suhu;
                            tvhasilKonversi.setText(String.valueOf(hasil) + " °C");
                            break;
                        case 11://\u00B0Reamur to Kelvin
                            hasil = 5.0/4.0 * suhu + 273;
                            tvhasilKonversi.setText(String.valueOf(hasil) + " °K");
                            break;
                        case 12://\u00B0Reamur to \u00B0Fahrenheit
                            hasil = (9.0/4.0 * suhu) + 32;
                            tvhasilKonversi.setText(String.valueOf(hasil) + " °F");
                            break;
                    }

                }
            }
        });

    }

    public void pindahHome(View view) {
        Intent intent = new Intent(TemperatureActivity.this, MainActivity.class);
        startActivity(intent);
    }
}