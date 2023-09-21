package com.example.joquempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void selecionadoPedra(View viem) {
        this.opcaoSelecionada("PEDRA");
    }

    public void selecionadoPapel(View viem) {
        this.opcaoSelecionada("PAPEL");
    }

    public void selecionadoTesoura(View viem) {
        this.opcaoSelecionada("TESOURA");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {
        ImageView imageResulado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"PEDRA", "PAPEL", "TESOURA"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp) {
            case "PEDRA":
                imageResulado.setImageResource(R.drawable.pedra);
                break;
            case "PAPEL":
                imageResulado.setImageResource(R.drawable.papel);
                break;
            case "TESOURA":
                imageResulado.setImageResource(R.drawable.tesoura);
                break;
        }
        if ((opcaoApp == "TESOURA" && opcaoSelecionada == "PAPEL") ||
            (opcaoApp == "PAPEL" && opcaoSelecionada == "PEDRA") ||
            (opcaoApp == "PEDRA" && opcaoSelecionada == "TESOURA"))
        {
           textResultado.setText("EU GANHEI E VOCÊ PERDEU!");
        }

        else if ((opcaoSelecionada == "TESOURA" && opcaoApp == "PAPEL") ||
                (opcaoSelecionada == "PAPEL" && opcaoApp == "PEDRA") ||
                (opcaoSelecionada == "PEDRA" && opcaoApp == "TESOURA"))
        {
            textResultado.setText("PARABENS! VOCÊ GANHOU DE MIM!");
        }

        else {
            textResultado.setText("HOUVE EMPATE! NINGUÉM GANHOU!");
        }
    }
}