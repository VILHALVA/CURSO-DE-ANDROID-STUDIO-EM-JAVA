# MANUAL
## 1. INSTALAÇÃO DO ANDROID STUDIO
Android Studio é a IDE oficial para o desenvolvimento de aplicativos Android. 

### WINDOWS:
1. Acesse o [site oficial do Android Studio](https://developer.android.com/studio).
2. Clique em "Download Android Studio" e siga as instruções para baixar o instalador.
3. Execute o instalador e siga as instruções na tela para concluir a instalação. Certifique-se de marcar a opção para instalar o Android Virtual Device (AVD).
4. Após a instalação, abra o Android Studio e siga as instruções do assistente de configuração.

### MACOS:
1. Acesse o [site oficial do Android Studio](https://developer.android.com/studio).
2. Clique em "Download Android Studio" e siga as instruções para baixar o instalador.
3. Abra o arquivo `.dmg` e arraste o Android Studio para a pasta "Applications".
4. Abra o Android Studio e siga as instruções do assistente de configuração.

### LINUX:
1. Acesse o [site oficial do Android Studio](https://developer.android.com/studio).
2. Clique em "Download Android Studio" e siga as instruções para baixar o arquivo `.zip`.
3. Extraia o arquivo `.zip` para um diretório de sua escolha.
4. Navegue até o diretório extraído e execute `studio.sh`:
   ```sh
   cd android-studio/bin
   ./studio.sh
   ```
5. Siga as instruções do assistente de configuração.

## 2. CONFIGURAÇÃO DO AMBIENTE DE DESENVOLVIMENTO
### CONFIGURAR O ANDROID STUDIO:
1. Após a instalação, abra o Android Studio.
2. O assistente de configuração solicitará que você baixe componentes adicionais como o Android SDK. Siga as instruções para completar a configuração.
3. Crie ou faça login na sua conta do Google para acessar mais funcionalidades, se necessário.

### CONFIGURAR O EMULADOR ANDROID:
1. No Android Studio, vá para "Tools" > "AVD Manager".
2. Clique em "Create Virtual Device".
3. Selecione um dispositivo (por exemplo, Pixel 4) e clique em "Next".
4. Escolha uma imagem do sistema (recomenda-se a versão mais recente) e clique em "Next".
5. Verifique as configurações do AVD e clique em "Finish".

## 3. CRIANDO O PRIMEIRO PROJETO ANDROID
### PASSO A PASSO PARA CRIAR UM PROJETO NO ANDROID STUDIO:
1. Abra o Android Studio.
2. Clique em "Start a new Android Studio project".
3. Selecione "Empty Activity" e clique em "Next".
4. Configure os detalhes do projeto:
   - Nome do Projeto: `HelloWorld`
   - Nome do Pacote: `com.example.helloworld`
   - Local de Salvamento: escolha um diretório
   - Linguagem: Java ou Kotlin (para este exemplo, usaremos Java)
   - API mínima: selecione a versão mínima do Android suportada
5. Clique em "Finish".

### CRIANDO O ARQUIVO JAVA:
1. No painel do lado esquerdo (Project), navegue até `app > java > com.example.helloworld`.
2. Abra o arquivo `MainActivity.java`.

### ESCREVENDO O CÓDIGO:
No arquivo `MainActivity.java`, verifique se o código é semelhante a este:
```java
package com.example.helloworld;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text_view);
        textView.setText("Hello, World!");
    }
}
```

### CONFIGURANDO O LAYOUT:
1. No painel do lado esquerdo (Project), navegue até `app > res > layout`.
2. Abra o arquivo `activity_main.xml`.
3. Verifique se o código do layout é semelhante a este:
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello, World!"
        android:layout_centerInParent="true"/>
</RelativeLayout>
```

### EXECUTANDO O PROJETO:
1. Clique no ícone de execução (um triângulo verde) na barra de ferramentas superior ou pressione `Shift + F10`.
2. Selecione o dispositivo (emulador) onde deseja executar o aplicativo e clique em "OK".
3. O emulador abrirá e exibirá o aplicativo com a mensagem "Hello, World!".

## CONCLUSÃO:
Agora você tem o Android Studio instalado e configurado, além de um ambiente de desenvolvimento Android pronto. Você criou e executou seu primeiro projeto Android. A partir daqui, você pode explorar mais sobre a linguagem Java, APIs do Android e outras ferramentas para expandir suas habilidades de desenvolvimento de aplicativos móveis.