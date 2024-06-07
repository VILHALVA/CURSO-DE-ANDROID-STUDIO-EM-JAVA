# SEEKBAR
Vamos criar um aplicativo Android simples que utilize uma `SeekBar` para permitir que o usuário selecione um valor dentro de um intervalo predefinido. Vamos configurar a `SeekBar` para exibir os números de 0 a 100 e exibir o valor selecionado em um `TextView`. 

## Passo 1: Criar um Novo Projeto no Android Studio
Siga os passos que mencionei anteriormente para criar um novo projeto Android no Android Studio.

## Passo 2: Configurar o Layout (XML)
Vamos configurar o layout da atividade principal para incluir uma `SeekBar` e um `TextView` para exibir o valor selecionado. O arquivo de layout padrão `activity_main.xml` é criado automaticamente em `res/layout/activity_main.xml`.

### Código: `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <SeekBar
        android:id="@+id/seekBar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="16dp"
        android:max="100" />

    <TextView
        android:id="@+id/textViewValue"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/seekBar"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="16dp"
        android:text="Valor selecionado: 0"
        android:textSize="18sp" />
</RelativeLayout>
```

## Passo 3: Configurar a Atividade Principal (Java)
Vamos configurar a lógica da atividade principal para atualizar o valor exibido no `TextView` conforme o usuário move o controle da `SeekBar`. O arquivo de código da atividade principal, `MainActivity.java`, é criado automaticamente em `app/src/main/java/com/seu_pacote/MainActivity.java`.

### Código: `app/src/main/java/com/seu_pacote/MainActivity.java`
```java
package com.seu_pacote;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textViewValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        textViewValue = findViewById(R.id.textViewValue);

        // Configurar o valor máximo da SeekBar
        seekBar.setMax(100);

        // Definir um ouvinte de mudança para a SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Atualizar o TextView com o valor selecionado
                textViewValue.setText("Valor selecionado: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Método vazio necessário para implementação
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Método vazio necessário para implementação
            }
        });
    }
}
```

## Estrutura do Projeto
Seu projeto terá a seguinte estrutura de diretórios:

```
SeekBarDemo/
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
- **activity_main.xml**: Define a interface do usuário com uma `SeekBar` e um `TextView`. A `SeekBar` permite que o usuário selecione um valor de 0 a 100, e o `TextView` exibe o valor selecionado.
- **MainActivity.java**: Configura o comportamento da `SeekBar` e atualiza o `TextView` com o valor selecionado pelo usuário.

## Compilação e Execução
1. Clique no ícone de "Run" (parece um triângulo verde) ou pressione `Shift + F10`.
2. Escolha um dispositivo virtual (emulador) ou conecte um dispositivo físico.
3. O app será compilado e executado, permitindo que você mova a `SeekBar` para selecionar um valor entre 0 e 100, e o valor selecionado será exibido no `TextView`.
