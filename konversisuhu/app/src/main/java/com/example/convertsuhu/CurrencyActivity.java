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

import java.text.DecimalFormat;

public class CurrencyActivity extends AppCompatActivity {

    EditText etMatauang;
    Spinner Opsi;
    Button btnConvert, btnClear;
    TextView tvhasilKonversi;
    private String Pilihan[] = {"-ConverCurrency Option-", "IDR to USD", "IDR to GBP", "IDR to EUR", "IDR to JPY",
            "IDR to SGD", "IDR to CNY", "IDR to KRW", "IDR to INR",
            " IDR to MYR", "IDR to MXN", " IDR to CAD", " IDR to AUD"};

    double kursUSD = 16361.0;
    double kursGBP = 21036.0;
    double kursEUR = 17489.0;
    double kursJPY = 1174.0;
    double kursSGD = 11174.0;
    double kursCNY = 2315.0;
    double kursKRW = 12.40;
    double kursINR = 194.0;
    double kursMYR = 3537.0;
    double kursMXN = 207.0;
    double kursCAD = 12164.0;
    double kursAUD = 11128.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        etMatauang = findViewById(R.id.etMatauang);
        Opsi = findViewById(R.id.Opsi);
        btnConvert = findViewById(R.id.btnConvert);
        btnClear = findViewById(R.id.btnClear);
        tvhasilKonversi = findViewById(R.id.tvhasilKonversi);

        ArrayAdapter adapter = new ArrayAdapter(
                CurrencyActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                Pilihan
        );

        Opsi.setAdapter(adapter);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etMatauang.setText("");
                tvhasilKonversi.setText("");
            }
        });


        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getMatauang = etMatauang.getText().toString();

                if (getMatauang.isEmpty()) {
                    Toast.makeText(CurrencyActivity.this, "Maaf, Jumlah Uang Masih Kosong!!", Toast.LENGTH_SHORT).show();
                } else {
                    double uang = Double.valueOf(etMatauang.getText().toString());
                    double hasil;
                    int Spinner = Opsi.getSelectedItemPosition();
                    switch (Spinner) {
                        case 0:
                            Toast.makeText(CurrencyActivity.this, "Maaf, Silahkan Pilih Opsi Konversinya!!", Toast.LENGTH_SHORT).show();
                            break;
                        case 1: // IDR ke USD
                            hasil = uang / kursUSD;
                            tvhasilKonversi.setText("US$ " + formatDesimal(hasil));
                            break;
                        case 2: // IDR ke GBP
                            hasil = uang / kursGBP;
                            tvhasilKonversi.setText("£" + formatDesimal(hasil));
                            break;
                        case 3: // IDR ke EUR
                            hasil = uang / kursEUR;
                            tvhasilKonversi.setText("€" + formatDesimal(hasil));
                            break;
                        case 4: // IDR ke JPY
                            hasil = uang / kursJPY;
                            tvhasilKonversi.setText("¥" + formatDesimal(hasil));
                            break;
                        case 5: // IDR ke SGD
                            hasil = uang / kursSGD;
                            tvhasilKonversi.setText("SG$ " + formatDesimal(hasil));
                            break;
                        case 6: // IDR ke CNY
                            hasil = uang / kursCNY;
                            tvhasilKonversi.setText("¥" + formatDesimal(hasil));
                            break;
                        case 7: // IDR ke KRW
                            hasil = uang / kursKRW;
                            tvhasilKonversi.setText("₩" + formatDesimal(hasil));
                            break;
                        case 8: // IDR ke INR
                            hasil = uang / kursINR;
                            tvhasilKonversi.setText("₹" + formatDesimal(hasil));
                            break;
                        case 9: // IDR ke MYR
                            hasil = uang / kursMYR;
                            tvhasilKonversi.setText("RM " + formatDesimal(hasil));
                            break;
                        case 10: // IDR ke MXN
                            hasil = uang / kursMXN;
                            tvhasilKonversi.setText("Mex$ " + formatDesimal(hasil));
                            break;
                        case 11: // IDR ke CAD
                            hasil = uang / kursCAD;
                            tvhasilKonversi.setText("C$ " + formatDesimal(hasil));
                            break;
                        case 12: // IDR ke AUD
                            hasil = uang / kursAUD;
                            tvhasilKonversi.setText("A$ " + formatDesimal(hasil));
                            break;

                    }

                }
            }
        });

    }

    private String formatDesimal(double nilai) {
        DecimalFormat df = new DecimalFormat("#.###");
        return df.format(nilai);
    }

    public void pindahHome(View view) {
        Intent intent = new Intent(CurrencyActivity.this, MainActivity.class);
        startActivity(intent);
    }
}