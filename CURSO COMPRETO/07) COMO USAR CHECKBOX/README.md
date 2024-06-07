# COMO USAR CHECKBOX
Vamos criar um exemplo simples para mostrar como usar um CheckBox no Android Studio. O exemplo será um aplicativo que permite ao usuário selecionar suas frutas favoritas e exibir as escolhas em um TextView.

## Passo 1: Criar um Novo Projeto no Android Studio
1. Abra o Android Studio.
2. Clique em "Start a new Android Studio project".
3. Selecione "Empty Activity" e clique em "Next".
4. Nomeie o seu app como "CheckBoxExample".
5. Verifique se a linguagem está selecionada como "Java".
6. Clique em "Finish".

## Passo 2: Configurar o Layout (XML)
Vamos configurar o layout da atividade principal para incluir alguns CheckBoxes e um botão para exibir as seleções em um TextView. O arquivo de layout padrão `activity_main.xml` é criado automaticamente em `res/layout/activity_main.xml`.

### Código: `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <CheckBox
        android:id="@+id/checkBoxApple"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Apple" />

    <CheckBox
        android:id="@+id/checkBoxBanana"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Banana" />

    <CheckBox
        android:id="@+id/checkBoxOrange"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Orange" />

    <Button
        android:id="@+id/buttonShowSelection"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Show Selection"
        android:layout_marginTop="16dp" />

    <TextView
        android:id="@+id/textViewSelection"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:text="Selected fruits will appear here"
        android:textSize="18sp" />

</LinearLayout>
```

## Passo 3: Configurar a Atividade Principal (Java)
O arquivo de código da atividade principal, `MainActivity.java`, é criado automaticamente em `app/src/main/java/com/seu_pacote/MainActivity.java`. Vamos implementar a lógica para manipular os CheckBoxes.

### Código: `app/src/main/java/com/seu_pacote/MainActivity.java`
```java
package com.seu_pacote;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxApple;
    private CheckBox checkBoxBanana;
    private CheckBox checkBoxOrange;
    private Button buttonShowSelection;
    private TextView textViewSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxApple = findViewById(R.id.checkBoxApple);
        checkBoxBanana = findViewById(R.id.checkBoxBanana);
        checkBoxOrange = findViewById(R.id.checkBoxOrange);
        buttonShowSelection = findViewById(R.id.buttonShowSelection);
        textViewSelection = findViewById(R.id.textViewSelection);

        buttonShowSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelectedFruits();
            }
        });
    }

    private void showSelectedFruits() {
        StringBuilder selectedFruits = new StringBuilder("Selected fruits: ");

        if (checkBoxApple.isChecked()) {
            selectedFruits.append("\nApple");
        }
        if (checkBoxBanana.isChecked()) {
            selectedFruits.append("\nBanana");
        }
        if (checkBoxOrange.isChecked()) {
            selectedFruits.append("\nOrange");
        }

        textViewSelection.setText(selectedFruits.toString());
    }
}
```

## Estrutura do Projeto
Seu projeto terá a seguinte estrutura de diretórios:

```
CheckBoxExample/
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
- **CheckBox**: Componentes que permitem selecionar ou desmarcar uma opção.
- **Button**: Botão que, ao ser clicado, executa a ação definida.
- **TextView**: Componente que exibe texto.

### `MainActivity.java`
- **AppCompatActivity**: Classe base para atividades que usam a ActionBar.
- **onCreate**: Método chamado quando a atividade é criada. Configura o layout e inicializa os componentes.
- **buttonShowSelection.setOnClickListener**: Define um ouvinte para o clique do botão. Quando o botão é clicado, a função `showSelectedFruits` é chamada.
- **showSelectedFruits**: Função que verifica quais CheckBoxes estão selecionados e exibe o resultado no `TextView`.

## Compilação e Execução
1. Clique no ícone de "Run" (parece um triângulo verde) ou pressione `Shift + F10`.
2. Escolha um dispositivo virtual (emulador) ou conecte um dispositivo físico.
3. O app será compilado e executado, permitindo que você selecione as frutas e clique no botão para exibir as seleções.

