# CALCULAR IMC
Vamos criar um aplicativo que calcula o Índice de Massa Corporal (IMC) com base no peso e altura do usuário. O app terá campos de entrada para o peso e a altura, um botão para calcular o IMC e um TextView para exibir o resultado.

## Passo 1: Criar um Novo Projeto no Android Studio
1. Abra o Android Studio.
2. Clique em "Start a new Android Studio project".
3. Selecione "Empty Activity" e clique em "Next".
4. Nomeie o seu app como "CalculadoraIMC".
5. Verifique se a linguagem está selecionada como "Java".
6. Clique em "Finish".

## Passo 2: Configurar o Layout (XML)
Vamos configurar o layout da atividade principal para ter dois campos de entrada para o peso e a altura, um botão para calcular o IMC e um TextView para exibir o resultado. O arquivo de layout padrão `activity_main.xml` é criado automaticamente em `res/layout/activity_main.xml`.

### Código: `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/editTextPeso"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Peso (kg)"
        android:inputType="numberDecimal"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="50dp"
        android:layout_marginBottom="20dp"/>

    <EditText
        android:id="@+id/editTextAltura"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Altura (m)"
        android:inputType="numberDecimal"
        android:layout_below="@id/editTextPeso"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="20dp"/>

    <Button
        android:id="@+id/buttonCalcular"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Calcular IMC"
        android:layout_below="@id/editTextAltura"
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
O arquivo de código da atividade principal, `MainActivity.java`, é criado automaticamente em `app/src/main/java/com/seu_pacote/MainActivity.java`. Vamos implementar a lógica para calcular o IMC e exibir o resultado.

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

    private EditText editTextPeso;
    private EditText editTextAltura;
    private Button buttonCalcular;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        String pesoText = editTextPeso.getText().toString();
        String alturaText = editTextAltura.getText().toString();

        if (!pesoText.isEmpty() && !alturaText.isEmpty()) {
            double peso = Double.parseDouble(pesoText);
            double altura = Double.parseDouble(alturaText);

            double imc = peso / (altura * altura);

            String resultado;
            if (imc < 18.5) {
                resultado = "Abaixo do peso";
            } else if (imc >= 18.5 && imc < 24.9) {
                resultado = "Peso normal";
            } else if (imc >= 25 && imc < 29.9) {
                resultado = "Sobrepeso";
            } else {
                resultado = "Obesidade";
            }

            textViewResultado.setText(String.format("IMC: %.2f (%s)", imc, resultado));
        } else {
            textViewResultado.setText("Por favor, insira o peso e a altura");
        }
    }
}
```

## Estrutura do Projeto
Seu projeto terá a seguinte estrutura de diretórios:

```
CalculadoraIMC/
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
- **EditText**: Campos de entrada para o peso e a altura do usuário.
- **Button**: Botão que, ao ser clicado, calcula o IMC.
- **TextView**: Componente que exibe o resultado do cálculo do IMC.

### `MainActivity.java`
- **AppCompatActivity**: Classe base para atividades que usam a ActionBar.
- **onCreate**: Método chamado quando a atividade é criada. Aqui, configuramos o layout da atividade usando `setContentView` e inicializamos os componentes `EditText`, `Button` e `TextView`.
- **buttonCalcular.setOnClickListener**: Define um ouvinte para o clique do botão. Quando o botão é clicado, a função `calcularIMC` é chamada.
- **calcularIMC**: Função que realiza o cálculo do IMC e exibe o resultado no `TextView`.

## Compilação e Execução
1. Clique no ícone de "Run" (parece um triângulo verde) ou pressione `Shift + F10`.
2. Escolha um dispositivo virtual (emulador) ou conecte um dispositivo físico.
3. O app será compilado e executado, permitindo que você insira o peso e a altura e clique no botão para calcular e exibir o IMC.

