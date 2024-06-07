# JOQUEMPO
## Passo 1: Criar um Novo Projeto no Android Studio
Siga os passos que mencionei anteriormente para criar um novo projeto Android no Android Studio.

## Passo 2: Configurar o Layout (XML)
Vamos configurar o layout da atividade principal para incluir três botões representando as opções do jogo ("Pedra", "Papel" e "Tesoura"), e um TextView para exibir o resultado do jogo. O arquivo de layout padrão `activity_main.xml` é criado automaticamente em `res/layout/activity_main.xml`.

### Código: `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center">

    <Button
        android:id="@+id/buttonPedra"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Pedra"
        android:layout_marginBottom="16dp"/>

    <Button
        android:id="@+id/buttonPapel"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Papel"
        android:layout_marginBottom="16dp"/>

    <Button
        android:id="@+id/buttonTesoura"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Tesoura"
        android:layout_marginBottom="16dp"/>

    <TextView
        android:id="@+id/textViewResultado"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="24sp"
        android:textStyle="bold"/>
</LinearLayout>
```

## Passo 3: Configurar a Atividade Principal (Java)
Vamos configurar a lógica do jogo na atividade principal. O arquivo de código da atividade principal, `MainActivity.java`, é criado automaticamente em `app/src/main/java/com/seu_pacote/MainActivity.java`.

### Código: `app/src/main/java/com/seu_pacote/MainActivity.java`

```java
package com.seu_pacote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonPedra, buttonPapel, buttonTesoura;
    private TextView textViewResultado;
    private Random random = new Random();
    private int escolhaUsuario, escolhaComputador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPedra = findViewById(R.id.buttonPedra);
        buttonPapel = findViewById(R.id.buttonPapel);
        buttonTesoura = findViewById(R.id.buttonTesoura);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonPedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogar(0);
            }
        });

        buttonPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogar(1);
            }
        });

        buttonTesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogar(2);
            }
        });
    }

    private void jogar(int escolhaUsuario) {
        this.escolhaUsuario = escolhaUsuario;
        this.escolhaComputador = random.nextInt(3);

        String resultado;

        if (this.escolhaUsuario == this.escolhaComputador) {
            resultado = "Empate!";
        } else if ((this.escolhaUsuario == 0 && this.escolhaComputador == 2) ||
                   (this.escolhaUsuario == 1 && this.escolhaComputador == 0) ||
                   (this.escolhaUsuario == 2 && this.escolhaComputador == 1)) {
            resultado = "Você ganhou!";
        } else {
            resultado = "Você perdeu!";
        }

        String escolhaUsuarioStr = escolhaToString(this.escolhaUsuario);
        String escolhaComputadorStr = escolhaToString(this.escolhaComputador);

        textViewResultado.setText("Você escolheu: " + escolhaUsuarioStr +
                                   "\nComputador escolheu: " + escolhaComputadorStr +
                                   "\n" + resultado);
    }

    private String escolhaToString(int escolha) {
        switch (escolha) {
            case 0:
                return "Pedra";
            case 1:
                return "Papel";
            case 2:
                return "Tesoura";
            default:
                return "";
        }
    }
}
```

## Estrutura do Projeto
Seu projeto terá a seguinte estrutura de diretórios:

```
Jokenpo/
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
- **activity_main.xml**: Define a interface do usuário com os botões para cada opção do jogo e um TextView para exibir o resultado.
- **MainActivity.java**: Configura os cliques nos botões e implementa a lógica do jogo. A lógica compara a escolha do usuário com a escolha do computador e determina o resultado com base nas regras do jogo.

## Compilação e Execução
1. Clique no ícone de "Run" (parece um triângulo verde) ou pressione `Shift + F10`.
2. Escolha um dispositivo virtual (emulador) ou conecte um dispositivo físico.
3. O app será compilado e executado, permitindo que você jogue "Pedra, Papel e Tesoura" contra o computador.

