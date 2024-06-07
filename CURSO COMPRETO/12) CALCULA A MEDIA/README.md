# CALCULA A MEDIA
Vamos criar um aplicativo Android que calcula a média de três notas inseridas pelo usuário. O aplicativo mostrará a média calculada quando o usuário clicar em um botão.

## Passo 1: Criar um Novo Projeto no Android Studio
1. Abra o Android Studio.
2. Clique em "Start a new Android Studio project".
3. Selecione "Empty Activity" e clique em "Next".
4. Nomeie o seu app como "CalculaMedia".
5. Verifique se a linguagem está selecionada como "Java".
6. Clique em "Finish".

## Passo 2: Configurar o Layout (XML)
Vamos configurar o layout da atividade principal para incluir três `EditText` para inserir as notas, um `Button` para calcular a média e um `TextView` para exibir o resultado. O arquivo de layout padrão `activity_main.xml` é criado automaticamente em `res/layout/activity_main.xml`.

### Código: `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editTextNota1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Nota 1"
        android:inputType="numberDecimal" />

    <EditText
        android:id="@+id/editTextNota2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Nota 2"
        android:inputType="numberDecimal"
        android:layout_marginTop="16dp" />

    <EditText
        android:id="@+id/editTextNota3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Nota 3"
        android:inputType="numberDecimal"
        android:layout_marginTop="16dp" />

    <Button
        android:id="@+id/buttonCalcularMedia"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Calcular Média"
        android:layout_marginTop="16dp" />

    <TextView
        android:id="@+id/textViewResultado"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Média: "
        android:layout_marginTop="16dp"
        android:textSize="18sp" />

</LinearLayout>
```

## Passo 3: Configurar a Atividade Principal (Java)
O arquivo de código da atividade principal, `MainActivity.java`, é criado automaticamente em `app/src/main/java/com/seu_pacote/MainActivity.java`. Vamos implementar a lógica para calcular a média das notas.

### Código: `app/src/main/java/com/seu_pacote/MainActivity.java`
```java
package com.seu_pacote;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNota1;
    private EditText editTextNota2;
    private EditText editTextNota3;
    private Button buttonCalcularMedia;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNota1 = findViewById(R.id.editTextNota1);
        editTextNota2 = findViewById(R.id.editTextNota2);
        editTextNota3 = findViewById(R.id.editTextNota3);
        buttonCalcularMedia = findViewById(R.id.buttonCalcularMedia);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonCalcularMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularMedia();
            }
        });
    }

    private void calcularMedia() {
        double nota1 = Double.parseDouble(editTextNota1.getText().toString());
        double nota2 = Double.parseDouble(editTextNota2.getText().toString());
        double nota3 = Double.parseDouble(editTextNota3.getText().toString());

        double media = (nota1 + nota2 + nota3) / 3.0;

        textViewResultado.setText("Média: " + media);
    }
}
```

## Estrutura do Projeto
Seu projeto terá a seguinte estrutura de diretórios:

```
CalculaMedia/
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
│   │   │   └── AndroidManifest.xml
│   └── build.gradle
└── build.gradle
```

## Explicação dos Códigos
### `activity_main.xml`
- **EditText**: Três campos de entrada de texto onde o usuário pode inserir as notas.
- **Button**: Botão que, ao ser clicado, executa a ação de calcular a média.
- **TextView**: Componente que exibe a média calculada.

### `MainActivity.java`
- **AppCompatActivity**: Classe base para atividades que usam a ActionBar.
- **onCreate**: Método chamado quando a atividade é criada. Configura o layout e inicializa os componentes.
- **calcularMedia**: Função que calcula a média das três notas inseridas e exibe o resultado no `TextView`.

## Compilação e Execução
1. Clique no ícone de "Run" (parece um triângulo verde) ou pressione `Shift + F10`.
2. Escolha um dispositivo virtual (emulador) ou conecte um dispositivo físico.
3. O app será compilado e executado, permitindo que você insira as três notas e veja a média calculada.

