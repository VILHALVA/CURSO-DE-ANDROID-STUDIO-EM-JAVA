# SPLASHSCREEN E HANDLER
Uma SplashScreen (tela de inicialização) é a primeira tela que os usuários veem quando iniciam um aplicativo. Ela geralmente exibe o logotipo ou o nome do aplicativo e serve para dar uma primeira impressão visual aos usuários enquanto o aplicativo é carregado em segundo plano. O uso de um `Handler` é uma técnica comum para controlar o tempo de exibição da SplashScreen antes de redirecionar o usuário para a tela principal do aplicativo. Vou explicar como criar uma SplashScreen usando um `Handler`:

1. **Crie uma Activity para a SplashScreen**:

   Crie uma nova `Activity` no seu projeto Android para representar a SplashScreen. Esta Activity será responsável por exibir a tela de inicialização.

2. **Layout da SplashScreen**:

   Crie o layout da SplashScreen usando XML. Este layout pode conter uma imagem do logotipo do aplicativo, um nome ou qualquer outra coisa que você desejar mostrar aos usuários. Salve essa imagem no diretório "res/drawable" do seu projeto.

3. **Configurando a SplashScreen**:

   Na classe da SplashScreen (`SplashScreenActivity`), defina o layout da Activity no método `onCreate` e configure qualquer outra personalização necessária. Por exemplo:

   ```java
   public class SplashScreenActivity extends AppCompatActivity {

       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_splash_screen);
           
           // Outras configurações da SplashScreen, se necessário
       }
   }
   ```

4. **Adicione um Handler para a SplashScreen**:

   Agora, você usará um `Handler` para controlar o tempo de exibição da SplashScreen antes de redirecionar o usuário para a tela principal do aplicativo. No método `onCreate`, adicione o seguinte código:

   ```java
   new Handler().postDelayed(new Runnable() {
       @Override
       public void run() {
           // Intent para a tela principal do aplicativo
           Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
           startActivity(intent);
           finish(); // Encerra a SplashScreen
       }
   }, 3000); // Tempo de exibição da SplashScreen em milissegundos (por exemplo, 3 segundos)
   ```

   Neste exemplo, a SplashScreen será exibida por 3 segundos (3000 milissegundos) antes de redirecionar o usuário para a `MainActivity`. Você pode ajustar o tempo de exibição conforme necessário.

5. **Defina a SplashScreen como Atividade de Inicialização**:

   No arquivo `AndroidManifest.xml`, defina a SplashScreenActivity como a atividade de inicialização (aquela que será exibida quando o aplicativo for aberto pela primeira vez) adicionando um elemento `<intent-filter>` com a ação "MAIN" e a categoria "LAUNCHER" à atividade.

   ```xml
   <activity
       android:name=".SplashScreenActivity"
       android:theme="@style/AppTheme">
       <intent-filter>
           <action android:name="android.intent.action.MAIN" />
           <category android:name="android.intent.category.LAUNCHER" />
       </intent-filter>
   </activity>
   ```

Agora, quando você iniciar o aplicativo, a SplashScreen será exibida por um período definido e, em seguida, o usuário será redirecionado para a `MainActivity` ou qualquer outra tela principal do aplicativo que você especificar na `Intent`. Certifique-se de ajustar o tempo de exibição da SplashScreen e personalizá-la de acordo com as necessidades do seu aplicativo.