package com.example.noticias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkEconomia, checkEsportes, checkLazer;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkEconomia = findViewById(R.id.checkEconomia);
        checkEsportes = findViewById(R.id.checkEsportes);
        checkLazer = findViewById(R.id.checkLazer);
        textResultado = findViewById(R.id.textResultado);
    }

    public void checkbox() {
        boolean economia = checkEconomia.isChecked();
        boolean esportes = checkEsportes.isChecked();
        boolean lazer = checkLazer.isChecked();

        String texto = "";
        if (economia == true) {
            texto = texto+"\nECONOMIA SELECIONADO!";
        }
        if (esportes == true) {
            texto = texto+"\nESPORTES SELECIONADO!";
        }
        if (lazer == true) {
            texto = texto+"\nLAZER SELECIONADO!";
        }
        textResultado.setText(texto);
    }

    public void enviar(View view) {
        checkbox();
    }
}