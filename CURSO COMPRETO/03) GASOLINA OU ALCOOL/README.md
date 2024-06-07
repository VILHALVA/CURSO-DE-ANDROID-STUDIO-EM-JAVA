# GASOLINA OU ALCOOL
Vamos criar um app que ajuda o usuário a decidir entre abastecer o carro com gasolina ou álcool (etanol) com base nos preços de ambos os combustíveis. O app calculará o custo-benefício e mostrará qual combustível é mais vantajoso.

## Passo 1: Criar um Novo Projeto no Android Studio
1. Abra o Android Studio.
2. Clique em "Start a new Android Studio project".
3. Selecione "Empty Activity" e clique em "Next".
4. Nomeie o seu app como "GasolinaOuAlcool".
5. Verifique se a linguagem está selecionada como "Java".
6. Clique em "Finish".

## Passo 2: Configurar o Layout (XML)
Vamos configurar o layout da atividade principal para ter dois campos de entrada para os preços dos combustíveis, um botão para calcular e um TextView para exibir o resultado. O arquivo de layout padrão `activity_main.xml` é criado automaticamente em `res/layout/activity_main.xml`.

### Código: `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/editTextGasolina"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Preço da Gasolina"
        android:inputType="numberDecimal"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="50dp"
        android:layout_marginBottom="20dp"/>

    <EditText
        android:id="@+id/editTextAlcool"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Preço do Álcool"
        android:inputType="numberDecimal"
        android:layout_below="@id/editTextGasolina"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="20dp"/>

    <Button
        android:id="@+id/buttonCalcular"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Calcular"
        android:layout_below="@id/editTextAlcool"
        android:layout_centerHorizontal="true"/>

    <TextView
        android:id="@+id/textViewResultado"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text=""
        android:layout_below="@id/buttonCalcular"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="20dp"
        android:textSize="18sp"
        android:textColor="#000000"/>
</RelativeLayout>
```

## Passo 3: Configurar a Atividade Principal (Java)
O arquivo de código da atividade principal, `MainActivity.java`, é criado automaticamente em `app/src/main/java/com/seu_pacote/MainActivity.java`. Vamos implementar a lógica para calcular o custo-benefício e exibir o resultado.

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

    private EditText editTextGasolina;
    private EditText editTextAlcool;
    private Button buttonCalcular;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextGasolina = findViewById(R.id.editTextGasolina);
        editTextAlcool = findViewById(R.id.editTextAlcool);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularMelhorCombustivel();
            }
        });
    }

    private void calcularMelhorCombustivel() {
        String gasolinaText = editTextGasolina.getText().toString();
        String alcoolText = editTextAlcool.getText().toString();

        if (!gasolinaText.isEmpty() && !alcoolText.isEmpty()) {
            double precoGasolina = Double.parseDouble(gasolinaText);
            double precoAlcool = Double.parseDouble(alcoolText);

            double resultado = precoAlcool / precoGasolina;

            if (resultado <= 0.7) {
                textViewResultado.setText("É melhor abastecer com Álcool");
            } else {
                textViewResultado.setText("É melhor abastecer com Gasolina");
            }
        } else {
            textViewResultado.setText("Por favor, insira os preços de ambos os combustíveis");
        }
    }
}
```

## Estrutura do Projeto
Seu projeto terá a seguinte estrutura de diretórios:

```
GasolinaOuAlcool/
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
- **EditText**: Campos de entrada para os preços da gasolina e do álcool.
- **Button**: Botão que, ao ser clicado, calcula qual combustível é mais vantajoso.
- **TextView**: Componente que exibe o resultado do cálculo.

### `MainActivity.java`
- **AppCompatActivity**: Classe base para atividades que usam a ActionBar.
- **onCreate**: Método chamado quando a atividade é criada. Aqui, configuramos o layout da atividade usando `setContentView` e inicializamos os componentes `EditText`, `Button` e `TextView`.
- **buttonCalcular.setOnClickListener**: Define um ouvinte para o clique do botão. Quando o botão é clicado, a função `calcularMelhorCombustivel` é chamada.
- **calcularMelhorCombustivel**: Função que realiza o cálculo de custo-benefício e exibe o resultado no `TextView`.

## Compilação e Execução
1. Clique no ícone de "Run" (parece um triângulo verde) ou pressione `Shift + F10`.
2. Escolha um dispositivo virtual (emulador) ou conecte um dispositivo físico.
3. O app será compilado e executado, permitindo que você insira os preços dos combustíveis e clique no botão para ver qual é mais vantajoso.

