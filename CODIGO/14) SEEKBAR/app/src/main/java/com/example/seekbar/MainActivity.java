package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBarProgresso;
    TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarProgresso = findViewById(R.id.seekBarProgresso);
        textResultado = findViewById(R.id.textResultado);

        seekBarProgresso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //textResultado.setText("PROGRSSO: "+progress+" DE "+seekBarProgresso.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void progresso(View view) {
        textResultado.setText("PROGRSSO: "+seekBarProgresso.getProgress()+" DE "+seekBarProgresso.getMax());
    }
}