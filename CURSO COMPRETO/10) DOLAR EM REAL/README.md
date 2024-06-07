# DOLAR EM REAL
Vamos criar um aplicativo Android que converte dólares americanos (USD) para reais brasileiros (BRL). O usuário pode digitar um valor em dólares, clicar em um botão e ver o valor convertido em reais.

## Passo 1: Criar um Novo Projeto no Android Studio
1. Abra o Android Studio.
2. Clique em "Start a new Android Studio project".
3. Selecione "Empty Activity" e clique em "Next".
4. Nomeie o seu app como "DolarParaReal".
5. Verifique se a linguagem está selecionada como "Java".
6. Clique em "Finish".

## Passo 2: Configurar o Layout (XML)
Vamos configurar o layout da atividade principal para incluir um `EditText` para inserir o valor em dólares, um `Button` para realizar a conversão e um `TextView` para exibir o valor convertido em reais. O arquivo de layout padrão `activity_main.xml` é criado automaticamente em `res/layout/activity_main.xml`.

### Código: `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editTextDolar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Digite o valor em dólares"
        android:inputType="numberDecimal"
        android:layout_marginTop="16dp" />

    <Button
        android:id="@+id/buttonConverter"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Converter para Real"
        android:layout_marginTop="16dp" />

    <TextView
        android:id="@+id/textViewResultado"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Valor em reais: "
        android:layout_marginTop="16dp"
        android:textSize="18sp" />

</LinearLayout>
```

## Passo 3: Configurar a Atividade Principal (Java)
O arquivo de código da atividade principal, `MainActivity.java`, é criado automaticamente em `app/src/main/java/com/seu_pacote/MainActivity.java`. Vamos implementar a lógica para converter o valor de dólares para reais.

### Código: `app/src/main/java/com/seu_pacote/MainActivity.java`
```java
package com.seu_pacote;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextDolar;
    private Button buttonConverter;
    private TextView textViewResultado;

    // Taxa de conversão fixa. Em um aplicativo real, você provavelmente obteria essa taxa de uma API.
    private static final double TAXA_CONVERSAO = 5.0; // Exemplo: 1 USD = 5 BRL

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDolar = findViewById(R.id.editTextDolar);
        buttonConverter = findViewById(R.id.buttonConverter);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                converterDolarParaReal();
            }
        });
    }

    private void converterDolarParaReal() {
        String valorDolarStr = editTextDolar.getText().toString().trim();
        if (!valorDolarStr.isEmpty()) {
            double valorDolar = Double.parseDouble(valorDolarStr);
            double valorReal = valorDolar * TAXA_CONVERSAO;

            // Formatar o valor em reais para exibição
            NumberFormat formatador = NumberFormat.getCurrencyInstance();
            String valorRealFormatado = formatador.format(valorReal);

            textViewResultado.setText("Valor em reais: " + valorRealFormatado);
        } else {
            textViewResultado.setText("Por favor, insira um valor em dólares.");
        }
    }
}
```

## Estrutura do Projeto
Seu projeto terá a seguinte estrutura de diretórios:

```
DolarParaReal/
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
- **EditText**: Campo de entrada de texto onde o usuário pode digitar o valor em dólares.
- **Button**: Botão que, ao ser clicado, executa a ação de conversão.
- **TextView**: Componente que exibe o valor convertido em reais.

### `MainActivity.java`
- **AppCompatActivity**: Classe base para atividades que usam a ActionBar.
- **onCreate**: Método chamado quando a atividade é criada. Configura o layout e inicializa os componentes.
- **converterDolarParaReal**: Função que realiza a conversão de dólares para reais usando uma taxa de conversão fixa.

## Compilação e Execução
1. Clique no ícone de "Run" (parece um triângulo verde) ou pressione `Shift + F10`.
2. Escolha um dispositivo virtual (emulador) ou conecte um dispositivo físico.
3. O app será compilado e executado, permitindo que você insira um valor em dólares e veja o valor convertido em reais.

