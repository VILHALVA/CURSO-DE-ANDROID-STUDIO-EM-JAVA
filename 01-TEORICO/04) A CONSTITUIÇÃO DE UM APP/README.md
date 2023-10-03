# A CONSTITUIÇÃO DE UM APP
A criação de um aplicativo Android envolve a configuração de vários arquivos, incluindo o arquivo Manifest e os arquivos Gradle (build.gradle). Esses arquivos são fundamentais para definir as configurações e funcionalidades do seu aplicativo. Aqui está uma visão geral de como esses arquivos são constituídos:

## Arquivo Manifest (AndroidManifest.xml):
O arquivo Manifest é essencial para qualquer aplicativo Android. Ele descreve as informações essenciais do seu aplicativo e suas configurações. Aqui estão os principais elementos que constituem um arquivo Manifest:

```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.myapp"> <!-- O nome do pacote do seu aplicativo -->

    <!-- Permissões necessárias -->
    <uses-permission android:name="android.permission.INTERNET" />

    <!-- Componentes do aplicativo -->
    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">

        <!-- Atividade principal do aplicativo -->
        <activity
            android:name=".MainActivity"
            android:label="@string/app_name"
            android:theme="@style/AppTheme.NoActionBar">

            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

        <!-- Outras atividades, serviços, receptores, etc., se aplicável -->
    </application>

</manifest>
```

- `<manifest>`: Define o namespace e o nome do pacote do aplicativo.
- `<uses-permission>`: Especifica permissões necessárias para o aplicativo.
- `<application>`: Configurações gerais do aplicativo, como o ícone, o tema e a atividade principal.
- `<activity>`: Define uma atividade (tela) do aplicativo, incluindo o ponto de entrada (MAIN/LAUNCHER).

## Arquivos Gradle (build.gradle):
Os arquivos Gradle são usados para configurar as dependências e configurações de compilação do seu projeto Android. Existem dois principais arquivos Gradle em um projeto Android:

1. **build.gradle (Projeto)**: Este arquivo está localizado na pasta raiz do projeto e define configurações globais do projeto, como a versão do Gradle e os repositórios Maven. Exemplo:

```gradle
// build.gradle (Projeto)
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath "com.android.tools.build:gradle:7.0.0"
    }
}
```

2. **build.gradle (App)**: Este arquivo está localizado na pasta do módulo do aplicativo e define as configurações específicas do aplicativo, incluindo as dependências do Android e as configurações de compilação. Exemplo:

```gradle
// build.gradle (App)
apply plugin: 'com.android.application'

android {
    compileSdkVersion 30
    defaultConfig {
        applicationId "com.example.myapp"
        minSdkVersion 16
        targetSdkVersion 30
        versionCode 1
        versionName "1.0"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'com.google.android.material:material:1.2.1'
    // Outras dependências do seu aplicativo
}
```

- `apply plugin`: Define os plugins aplicados ao projeto (por exemplo, 'com.android.application' para aplicativos Android).
- `android`: Configurações específicas do Android, como versão de compilação, configurações de compilação e dependências.
- `dependencies`: Lista as dependências do seu aplicativo, como bibliotecas AndroidX e outras bibliotecas de terceiros.

Certifique-se de personalizar esses arquivos de acordo com as necessidades do seu projeto, incluindo o nome do pacote, as permissões, as dependências e as configurações de compilação.

## ARQUIVOS E DIRETÓRIOS:
Dentro de um projeto típico do Android Studio, você encontrará vários arquivos e diretórios. Aqui estão os principais arquivos e diretórios e para que serve cada um:

1. **app**: Este é o diretório do módulo do aplicativo e contém a maior parte do código-fonte e recursos relacionados ao seu aplicativo. Dentro deste diretório, você encontrará os seguintes subdiretórios e arquivos:

   - **src**: Contém o código-fonte do aplicativo, separado em diretórios para diferentes variantes de compilação (por exemplo, `main` para a variante principal e `debug` para a variante de depuração).
   
   - **res**: Contém recursos do aplicativo, como layouts XML, strings, imagens e ícones.

   - **manifests**: Contém o arquivo AndroidManifest.xml, que descreve a estrutura do seu aplicativo, suas atividades, permissões, etc.

   - **java**: Contém os arquivos Java (ou Kotlin) que constituem a lógica do aplicativo. A estrutura dos pacotes geralmente segue o nome do pacote do aplicativo.

   - **assets**: Contém arquivos de recursos brutos, como arquivos de texto ou bancos de dados que você deseja incluir no aplicativo.

   - **libs**: É onde você pode colocar bibliotecas (JARs) que não estão disponíveis por meio do sistema de dependências do Gradle.

2. **build**: Este diretório é gerado pelo sistema de construção Gradle e contém arquivos temporários e gerados durante o processo de compilação. Você geralmente não precisa se preocupar com o conteúdo deste diretório, pois ele é gerado automaticamente.

3. **gradle**: Este diretório contém os arquivos relacionados à configuração do Gradle para o projeto. O arquivo `gradle-wrapper.properties` define a versão do Gradle usada no projeto e o wrapper Gradle.

4. **.gradle**: Este diretório é usado pelo Gradle para armazenar caches e outros arquivos temporários relacionados à compilação.

5. **build.gradle (Projeto)**: Este arquivo na raiz do projeto define as configurações globais do projeto, como as versões do Gradle e os repositórios Maven.

6. **build.gradle (App)**: Este arquivo dentro do diretório do módulo do aplicativo define as configurações específicas do aplicativo, como versão de compilação, configurações de compilação e dependências do aplicativo.

7. **local.properties**: Este arquivo contém informações de configuração locais, como o SDK do Android usado pelo projeto. Geralmente, é gerado automaticamente e não deve ser modificado manualmente.

8. **settings.gradle**: Este arquivo na raiz do projeto lista os módulos do projeto que serão incluídos no build.

9. **gradlew e gradlew.bat**: São scripts de linha de comando usados para executar tarefas Gradle sem a necessidade de uma instalação global do Gradle. No Windows, você usará `gradlew.bat`, e no Linux ou macOS, `./gradlew`.

10. **.gitignore**: Este arquivo lista os arquivos e diretórios que devem ser ignorados pelo Git ao controlar as versões do projeto. É útil para evitar que arquivos temporários e gerados sejam incluídos no controle de versão.

11. **Proguard-rules.pro**: Este arquivo define regras de obfuscação e minimização do ProGuard, que são usadas para ofuscar o código do aplicativo durante a compilação de lançamento.

12. **gradle.properties**: Este arquivo pode ser usado para definir variáveis de configuração do Gradle, como chaves de API secretas, que podem ser usadas nas configurações de compilação.

Esses são os principais arquivos e diretórios que você encontrará em um projeto típico do Android Studio. Cada um desempenha um papel importante na estrutura e configuração do projeto Android.