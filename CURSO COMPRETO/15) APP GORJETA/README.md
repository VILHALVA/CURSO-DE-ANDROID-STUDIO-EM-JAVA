# APP GORJETA
Vamos criar um aplicativo simples para calcular gorjetas. Vamos começar com a tela inicial, onde o usuário pode inserir o valor da conta e selecionar a porcentagem da gorjeta. Vou fornecer um trecho de código XML para a tela de layout e um trecho de código Java para a atividade principal que manipula essa tela.

Primeiro, vamos criar o layout XML para a tela inicial. Crie um arquivo XML chamado `activity_main.xml` no diretório `res/layout` do seu projeto. Aqui está um exemplo do código XML:

```xml
<!-- activity_main.xml -->
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/editTextBillAmount"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Valor da conta"
        android:inputType="numberDecimal"
        android:layout_marginBottom="16dp"/>

    <RadioGroup
        android:id="@+id/radioGroupTipPercentage"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/editTextBillAmount">

        <RadioButton
            android:id="@+id/radioButton10Percent"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="10%" />

        <RadioButton
            android:id="@+id/radioButton15Percent"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="15%"
            android:layout_marginStart="16dp"
            android:layout_toEndOf="@id/radioButton10Percent" />

        <RadioButton
            android:id="@+id/radioButton20Percent"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="20%"
            android:layout_marginStart="16dp"
            android:layout_toEndOf="@id/radioButton15Percent" />
    </RadioGroup>

    <Button
        android:id="@+id/buttonCalculate"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Calcular Gorjeta"
        android:layout_below="@id/radioGroupTipPercentage"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="16dp"/>

</RelativeLayout>
```

Este layout contém um EditText para inserir o valor da conta, um RadioGroup com opções de porcentagem de gorjeta e um botão para calcular a gorjeta.

Agora, vamos criar a lógica Java para a atividade principal (`MainActivity.java`). Aqui está um exemplo básico de como você pode implementar isso:

```java
// MainActivity.java
package com.example.tipcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextBillAmount;
    private RadioGroup radioGroupTipPercentage;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referenciar os elementos do layout
        editTextBillAmount = findViewById(R.id.editTextBillAmount);
        radioGroupTipPercentage = findViewById(R.id.radioGroupTipPercentage);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        // Definir um listener de clique para o botão de calcular
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip();
            }
        });
    }

    private void calculateTip() {
        // Obter o valor da conta
        String billAmountString = editTextBillAmount.getText().toString();
        if (billAmountString.isEmpty()) {
            // Se o campo estiver vazio, exibir uma mensagem de erro
            Toast.makeText(this, "Por favor, insira o valor da conta.", Toast.LENGTH_SHORT).show();
            return;
        }

        double billAmount = Double.parseDouble(billAmountString);

        // Obter a porcentagem de gorjeta selecionada
        int selectedRadioButtonId = radioGroupTipPercentage.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

        // Calcular a gorjeta
        double tipPercentage = Double.parseDouble(selectedRadioButton.getText().toString().replace("%", "")) / 100;
        double tipAmount = billAmount * tipPercentage;

        // Formatar a gorjeta para exibir duas casas decimais
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedTipAmount = decimalFormat.format(tipAmount);

        // Exibir a gorjeta calculada
        Toast.makeText(this, "Gorjeta: R$ " + formattedTipAmount, Toast.LENGTH_SHORT).show();
    }
}
```

Certifique-se de substituir `com.example.tipcalculator` pelo pacote correto do seu aplicativo.

Este código Java define a lógica para calcular a gorjeta com base no valor da conta e na porcentagem selecionada pelo usuário. Quando o usuário clica no botão de calcular, a função `calculateTip()` é chamada para realizar os cálculos e exibir a gorjeta calculada em um toast.
