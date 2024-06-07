package com.example.appgorgeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textGorjeta;
    private TextView textTotal;
    private TextView textPorcentagem;
    private SeekBar seekBarGorjeta;
    private EditText editValor;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textGorjeta = findViewById(R.id.textGorjeta);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textTotal = findViewById(R.id.textTotal);
        editValor = findViewById(R.id.editValor);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textPorcentagem.setText(porcentagem + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public void calcular() {
        String valorRecuperado = editValor.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")) {
            Toast.makeText(getApplicationContext(),"ERRO: DIGITE O VALOR!",Toast.LENGTH_SHORT).show();
        }
        else {
            double valorDigitado = Double.parseDouble(valorRecuperado);
            double gorjeta = valorDigitado * (porcentagem / 100);
            double total = gorjeta + valorDigitado;

            textGorjeta.setText("R$ "+gorjeta);
            textTotal.setText("R$ "+total);
        }
    }
}