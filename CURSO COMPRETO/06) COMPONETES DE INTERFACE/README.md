# COMPONETES DE INTERFACE
Vamos criar um aplicativo simples que demonstra o uso de diferentes componentes de interface no Android, como EditText, Button, TextView, Checkbox, RadioButton e Spinner. 

## Passo 1: Criar um Novo Projeto no Android Studio
1. Abra o Android Studio.
2. Clique em "Start a new Android Studio project".
3. Selecione "Empty Activity" e clique em "Next".
4. Nomeie o seu app como "ComponentesDeInterface".
5. Verifique se a linguagem está selecionada como "Java".
6. Clique em "Finish".

## Passo 2: Configurar o Layout (XML)
Vamos configurar o layout da atividade principal para incluir diferentes componentes de interface. O arquivo de layout padrão `activity_main.xml` é criado automaticamente em `res/layout/activity_main.xml`.

### Código: `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="16dp">

        <EditText
            android:id="@+id/editText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Digite algo" />

        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Clique em mim"
            android:layout_marginTop="16dp" />

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Texto aqui"
            android:layout_marginTop="16dp" />

        <CheckBox
            android:id="@+id/checkBox"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Checkbox"
            android:layout_marginTop="16dp" />

        <RadioGroup
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:layout_marginTop="16dp">
            <RadioButton
                android:id="@+id/radioButton1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Opção 1" />
            <RadioButton
                android:id="@+id/radioButton2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Opção 2" />
        </RadioGroup>

        <Spinner
            android:id="@+id/spinner"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="16dp" />

    </LinearLayout>
</ScrollView>
```

## Passo 3: Configurar a Atividade Principal (Java)
O arquivo de código da atividade principal, `MainActivity.java`, é criado automaticamente em `app/src/main/java/com/seu_pacote/MainActivity.java`. Vamos implementar a lógica para manipular os componentes de interface.

### Código: `app/src/main/java/com/seu_pacote/MainActivity.java`
```java
package com.seu_pacote;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private TextView textView;
    private CheckBox checkBox;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        checkBox = findViewById(R.id.checkBox);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        spinner = findViewById(R.id.spinner);

        // Configurando o Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Selecionado: " + selectedItem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoDigitado = editText.getText().toString();
                StringBuilder resultado = new StringBuilder("Texto digitado: " + textoDigitado + "\n");

                if (checkBox.isChecked()) {
                    resultado.append("Checkbox marcado\n");
                } else {
                    resultado.append("Checkbox desmarcado\n");
                }

                if (radioButton1.isChecked()) {
                    resultado.append("Opção 1 selecionada\n");
                } else if (radioButton2.isChecked()) {
                    resultado.append("Opção 2 selecionada\n");
                }

                String selectedSpinnerItem = spinner.getSelectedItem().toString();
                resultado.append("Spinner: ").append(selectedSpinnerItem);

                textView.setText(resultado.toString());
            }
        });
    }
}
```

## Passo 4: Adicionar os Itens ao Spinner
Para adicionar os itens ao Spinner, vamos criar um arquivo de recursos de string. Crie um arquivo chamado `arrays.xml` na pasta `res/values` e adicione os itens para o Spinner.

### Código: `res/values/arrays.xml`
```xml
<resources>
    <string-array name="spinner_items">
        <item>Item 1</item>
        <item>Item 2</item>
        <item>Item 3</item>
    </string-array>
</resources>
```

## Estrutura do Projeto
Seu projeto terá a seguinte estrutura de diretórios:

```
ComponentesDeInterface/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── seu_pacote/
│   │   │   │           └── MainActivity.java
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   └── activity_main.xml
│   │   │   │   ├── values/
│   │   │   │   │   └── arrays.xml
│   │   │   └── AndroidManifest.xml
│   └── build.gradle
└── build.gradle
```

## Explicação dos Códigos
### `activity_main.xml`
- **ScrollView**: Permite a rolagem do conteúdo se ele exceder o tamanho da tela.
- **LinearLayout**: Layout vertical que contém todos os componentes de interface.
- **EditText**: Campo de entrada de texto.
- **Button**: Botão que, ao ser clicado, executa a ação definida.
- **TextView**: Componente que exibe texto.
- **CheckBox**: Componente que permite marcar ou desmarcar uma opção.
- **RadioGroup e RadioButton**: Componentes que permitem selecionar uma única opção entre várias.
- **Spinner**: Componente de seleção de item em uma lista suspensa.

### `MainActivity.java`
- **AppCompatActivity**: Classe base para atividades que usam a ActionBar.
- **onCreate**: Método chamado quando a atividade é criada. Configura o layout e inicializa os componentes.
- **ArrayAdapter**: Adaptador usado para preencher o Spinner com os itens definidos em `arrays.xml`.
- **button.setOnClickListener**: Define um ouvinte para o clique do botão. Quando o botão é clicado, a função coleta os dados dos componentes e exibe o resultado no `TextView`.

## Compilação e Execução
1. Clique no ícone de "Run" (parece um triângulo verde) ou pressione `Shift + F10`.
2. Escolha um dispositivo virtual (emulador) ou conecte um dispositivo físico.
3. O app será compilado e executado, permitindo que você interaja com os componentes de interface.

