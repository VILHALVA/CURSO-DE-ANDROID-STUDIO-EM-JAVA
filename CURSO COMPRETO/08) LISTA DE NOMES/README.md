# LISTA DE NOMES
Vamos criar um aplicativo Android que exibe uma lista de nomes usando um `ListView`. O usuário poderá adicionar novos nomes à lista através de um campo de texto e um botão.

## Passo 1: Criar um Novo Projeto no Android Studio
1. Abra o Android Studio.
2. Clique em "Start a new Android Studio project".
3. Selecione "Empty Activity" e clique em "Next".
4. Nomeie o seu app como "ListaDeNomes".
5. Verifique se a linguagem está selecionada como "Java".
6. Clique em "Finish".

## Passo 2: Configurar o Layout (XML)
Vamos configurar o layout da atividade principal para incluir um `EditText` para adicionar nomes, um `Button` para adicionar o nome à lista e um `ListView` para exibir os nomes. O arquivo de layout padrão `activity_main.xml` é criado automaticamente em `res/layout/activity_main.xml`.

### Código: `res/layout/activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <EditText
        android:id="@+id/editTextNome"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Digite um nome"
        android:inputType="textPersonName" />

    <Button
        android:id="@+id/buttonAdicionar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Adicionar"
        android:layout_marginTop="16dp" />

    <ListView
        android:id="@+id/listViewNomes"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp" />

</LinearLayout>
```

## Passo 3: Configurar a Atividade Principal (Java)
O arquivo de código da atividade principal, `MainActivity.java`, é criado automaticamente em `app/src/main/java/com/seu_pacote/MainActivity.java`. Vamos implementar a lógica para adicionar nomes à lista.

### Código: `app/src/main/java/com/seu_pacote/MainActivity.java`
```java
package com.seu_pacote;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private Button buttonAdicionar;
    private ListView listViewNomes;
    private ArrayList<String> nomes;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        buttonAdicionar = findViewById(R.id.buttonAdicionar);
        listViewNomes = findViewById(R.id.listViewNomes);

        nomes = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nomes);
        listViewNomes.setAdapter(adapter);

        buttonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString().trim();
                if (!nome.isEmpty()) {
                    nomes.add(nome);
                    adapter.notifyDataSetChanged();
                    editTextNome.setText("");
                }
            }
        });
    }
}
```

## Estrutura do Projeto
Seu projeto terá a seguinte estrutura de diretórios:

```
ListaDeNomes/
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
- **EditText**: Campo de entrada de texto onde o usuário pode digitar um nome.
- **Button**: Botão que, ao ser clicado, adiciona o nome digitado à lista.
- **ListView**: Componente que exibe a lista de nomes.

### `MainActivity.java`
- **AppCompatActivity**: Classe base para atividades que usam a ActionBar.
- **onCreate**: Método chamado quando a atividade é criada. Configura o layout e inicializa os componentes.
- **ArrayList**: Lista dinâmica usada para armazenar os nomes.
- **ArrayAdapter**: Adaptador usado para preencher o `ListView` com os nomes da lista.
- **buttonAdicionar.setOnClickListener**: Define um ouvinte para o clique do botão. Quando o botão é clicado, a função coleta o nome do `EditText`, adiciona à lista e atualiza o `ListView`.

## Compilação e Execução
1. Clique no ícone de "Run" (parece um triângulo verde) ou pressione `Shift + F10`.
2. Escolha um dispositivo virtual (emulador) ou conecte um dispositivo físico.
3. O app será compilado e executado, permitindo que você adicione nomes à lista e veja-os exibidos no `ListView`.

