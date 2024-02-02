package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editPeso;
    private EditText editAltura;
    private TextView textResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        textResultado = findViewById(R.id.textResultado);
    }
    public void calcularImc(View view) {
        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());
        double imc = peso / (altura * altura);

        if (imc < 18.5f) {
            textResultado.setText("SEU IMC É "+imc+ "\nVOCÊ É DESNUTRIDO");
        }
        else if (imc >= 18.5f && imc < 24.9f) {
            textResultado.setText("SEU IMC É "+imc+ "\nPESO NORMAL");
        }
        else if (imc >= 25 && imc < 29.99f) {
            textResultado.setText("SEU IMC É "+imc+ "\nVOCÊ ESTÁ NO SOBREPESO");
        }
        else if (imc >= 30 && imc < 35.99f) {
            textResultado.setText("SEU IMC É "+imc+ "\nOBESIDADE LEVE");
        }
        else if (imc >= 35 && imc > 39.99f) {
            textResultado.setText("SEU IMC É "+imc+ "\nOBESIDADE SEVERA");
        }
        else {
            textResultado.setText("SEU IMC É "+imc+ " \nOBESIDADE MORBITA");
        }
    }
}