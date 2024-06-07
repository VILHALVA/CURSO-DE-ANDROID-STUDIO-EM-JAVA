# APP DE SORTEIO 2
Vamos criar um app de sorteio que gera números aleatórios entre 1 e 10. Vou fornecer os trechos de código em Java e XML, com explicações detalhadas e os diretórios correspondentes.

## Passo 1: Criar um Novo Projeto no Android Studio
1. Abra o Android Studio.
2. Clique em "Start a new Android Studio project".
3. Selecione "Empty Activity" e clique em "Next".
4. Nomeie o seu app como "AppDeSorteio".
5. Verifique se a linguagem está selecionada como "Java".
6. Clique em "Finish".

## Passo 2: Configurar o Layout (XML)
Vamos configurar o layout da atividade principal para ter um botão que gera um número aleatório e um TextView para exibir o número gerado. O arquivo de layout padrão `activity_main.xml` é criado automaticamente em `res/layout/activity_main.xml`.

### Código: `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textViewNumber"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Clique no botão para gerar um número"
        android:layout_centerInParent="true"
        android:textSize="18sp"
        android:textColor="#000000"/>

    <Button
        android:id="@+id/buttonGenerate"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Gerar Número"
        android:layout_below="@id/textViewNumber"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="20dp"/>
</RelativeLayout>
```

## Passo 3: Configurar a Atividade Principal (Java)
O arquivo de código da atividade principal, `MainActivity.java`, é criado automaticamente em `app/src/main/java/com/seu_pacote/MainActivity.java`. Vamos implementar a lógica para gerar o número aleatório quando o botão for clicado.

### Código: `app/src/main/java/com/seu_pacote/MainActivity.java`
```java
package com.seu_pacote;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textViewNumber;
    private Button buttonGenerate;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewNumber = findViewById(R.id.textViewNumber);
        buttonGenerate = findViewById(R.id.buttonGenerate);
        random = new Random();

        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomNumber = random.nextInt(10) + 1; // Gera número entre 1 e 10
                textViewNumber.setText(String.valueOf(randomNumber));
            }
        });
    }
}
```

## Estrutura do Projeto
Seu projeto terá a seguinte estrutura de diretórios:

```
AppDeSorteio/
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
- **RelativeLayout**: Layout que organiza os elementos relativos uns aos outros.
- **TextView**: Componente que exibe texto na tela. Configuramos o texto inicial para "Clique no botão para gerar um número".
- **Button**: Botão que, ao ser clicado, gera um número aleatório e o exibe no `TextView`.

### `MainActivity.java`
- **AppCompatActivity**: Classe base para atividades que usam a ActionBar.
- **onCreate**: Método chamado quando a atividade é criada. Aqui, configuramos o layout da atividade usando `setContentView` e inicializamos os componentes `TextView`, `Button` e `Random`.
- **buttonGenerate.setOnClickListener**: Define um ouvinte para o clique do botão. Quando o botão é clicado, um número aleatório entre 1 e 10 é gerado e exibido no `TextView`.

## Compilação e Execução
1. Clique no ícone de "Run" (parece um triângulo verde) ou pressione `Shift + F10`.
2. Escolha um dispositivo virtual (emulador) ou conecte um dispositivo físico.
3. O app será compilado e executado, permitindo que você clique no botão para gerar e exibir números aleatórios.

