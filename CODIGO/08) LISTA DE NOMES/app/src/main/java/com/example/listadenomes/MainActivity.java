package com.example.listadenomes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listNomes;

    private String[] itens = {
        "EMERSON MACHADO", "GUSTAVO GUANABARA", "VILHALVA", "TIAGO AGUIAR", "MATEUS MACHADO"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listNomes = findViewById(R.id.listNomes);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
            getApplicationContext(),
            android.R.layout.simple_list_item_1,
            android.R.id.text1, itens
        );

        listNomes.setAdapter(adapter);

        listNomes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String nomeSelecionado = listNomes.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), nomeSelecionado, Toast.LENGTH_SHORT).show();
            }
        });
    }
}