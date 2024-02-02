# Aplicativo de Login com Firebase
Este diretório contém o código-fonte de um aplicativo de login Android simples que utiliza o Firebase Authentication para autenticar os usuários. O aplicativo demonstra como configurar e integrar o Firebase no Android Studio para autenticação de usuário.

## Requisitos Prévios
Antes de executar o aplicativo, siga os passos abaixo para configurar seu ambiente:

1. **Crie uma Conta no Firebase:**

   Você precisará de uma conta no Firebase para configurar seu projeto. Se ainda não tiver uma conta, vá para [Firebase](https://firebase.google.com/) e crie uma conta gratuita.

2. **Crie um Projeto no Firebase:**

   Após fazer login na sua conta do Firebase, crie um novo projeto. Dê um nome ao seu projeto e siga as etapas para criá-lo.

3. **Adicione um Aplicativo ao Projeto Firebase:**

   No console do Firebase, adicione um aplicativo Android ao seu projeto. Você precisará fornecer o nome do pacote do aplicativo, que geralmente é algo como "com.example.myapp". Isso pode ser encontrado no arquivo `build.gradle` do módulo de app do seu projeto Android.

4. **Baixe o arquivo de configuração do Firebase:**

   Após adicionar o aplicativo ao projeto Firebase, você receberá um arquivo `google-services.json`. Baixe este arquivo e coloque-o na pasta `app` do seu projeto Android.

5. **Habilitar a Autenticação no Firebase:**

   No console do Firebase, vá para a seção "Authentication" e habilite os métodos de autenticação que deseja usar, como e-mail/senha, autenticação com redes sociais, etc.

## Configuração do Projeto no Android Studio
Agora que você configurou seu projeto no Firebase, siga estas etapas para vincular seu projeto Android ao Firebase no Android Studio:

1. **Abra o Projeto no Android Studio:**

   Abra seu projeto Android no Android Studio.

2. **Adicione o Plugin do Firebase:**

   No Android Studio, vá para "Ferramentas" > "Firebase" para abrir a janela do Firebase. Na guia "Authentication", clique em "Configurar o Firebase Authentication".

3. **Conecte seu Projeto ao Firebase:**

   Siga as etapas fornecidas na janela do Firebase para conectar seu projeto Android ao Firebase. Isso incluirá a sincronização do arquivo `google-services.json` e a configuração do SDK do Firebase no seu projeto.

4. **Sincronize o Projeto:**

   Após conectar o projeto ao Firebase, sincronize o projeto no Android Studio clicando em "Sincronizar agora" quando solicitado.

Agora, seu projeto Android está configurado para usar o Firebase Authentication. Você pode executar o aplicativo de login com Firebase em seu emulador ou dispositivo.

## Recursos Adicionais
Este aplicativo de exemplo é uma introdução simples à autenticação Firebase. Você pode personalizá-lo e expandi-lo de acordo com suas necessidades. Para obter informações detalhadas sobre como usar o Firebase Authentication e outros recursos do Firebase, consulte a [documentação oficial do Firebase](https://firebase.google.com/docs).

## ESTÁ COM DÚVIDAS?
* [ASSISTA A PLAYLIST ANTIGA](https://youtube.com/playlist?list=PLZCMLqQ7FqfRplMlYPdaTosvhTKb2w7pD&si=vzDKiWt-WQaGcBWQ)
* [ASSISTA A PLAYLIST NOVA](https://youtube.com/playlist?list=PLZCMLqQ7FqfTMUJfl1gOnMuz6_AUTHmD7&si=kQoYi3J3RjvPMLZX)

