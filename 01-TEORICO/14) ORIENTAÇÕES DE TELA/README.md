# ORIENTAÇÕES DE TELA
O Android oferece várias orientações de tela que você pode configurar para sua atividade, dependendo das necessidades do seu aplicativo. Aqui estão as principais orientações de tela disponíveis:

1. **Portrait (Retrato)**:
   - `android:screenOrientation="portrait"` ou `ActivityInfo.SCREEN_ORIENTATION_PORTRAIT`
   - Esta é a orientação padrão em dispositivos Android. A tela é exibida na posição vertical, com a parte mais alta no topo e a parte mais baixa na parte inferior.

2. **Landscape (Paisagem)**:
   - `android:screenOrientation="landscape"` ou `ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE`
   - Nesta orientação, a tela é exibida na posição horizontal, com a largura sendo maior que a altura. É frequentemente usada para jogos ou aplicativos de vídeo.

3. **Reverse Portrait (Retrato Invertido)**:
   - `android:screenOrientation="reversePortrait"` ou `ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT`
   - Semelhante ao retrato padrão, mas a tela está invertida em 180 graus. A parte superior da tela está voltada para baixo.

4. **Reverse Landscape (Paisagem Invertida)**:
   - `android:screenOrientation="reverseLandscape"` ou `ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE`
   - Similar à orientação paisagem, mas a tela está invertida em 180 graus. A parte esquerda da tela está voltada para a direita.

5. **Sensor (Sensor)**:
   - `android:screenOrientation="sensor"` ou `ActivityInfo.SCREEN_ORIENTATION_SENSOR`
   - Essa opção permite que o sistema escolha automaticamente a orientação com base nos sensores do dispositivo. A tela muda de acordo com a rotação física do dispositivo.

6. **User (Usuário)**:
   - `android:screenOrientation="user"` ou `ActivityInfo.SCREEN_ORIENTATION_USER`
   - Esta opção permite que o usuário escolha a orientação da tela manualmente por meio das configurações do sistema.

7. **Full Sensor (Sensor Completo)**:
   - `android:screenOrientation="fullSensor"` ou `ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR`
   - Semelhante ao sensor, mas permite que a tela gire em qualquer orientação, incluindo reverso. A rotação é determinada pelos sensores do dispositivo.

8. **No Sensor (Sem Sensor)**:
   - `android:screenOrientation="nosensor"` ou `ActivityInfo.SCREEN_ORIENTATION_NOSENSOR`
   - Bloqueia a orientação da tela no estado atual e impede que os sensores alterem a orientação.

9. **Unspecified (Não Especificado)**:
   - `android:screenOrientation="unspecified"` ou `ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED`
   - Permite que o sistema escolha automaticamente a melhor orientação com base em critérios internos.

10. **Behind (Atrás)**:
    - `android:screenOrientation="behind"` ou `ActivityInfo.SCREEN_ORIENTATION_BEHIND`
    - Normalmente usado para atividades de vídeo que estão por trás de outras atividades. A orientação é determinada pela atividade que está à frente.

Você pode definir a orientação de tela em seu arquivo "AndroidManifest.xml" usando o atributo `android:screenOrientation` dentro da declaração da atividade. Você também pode configurar a orientação programaticamente em seu código Java ou Kotlin usando o método `setRequestedOrientation()` na atividade.

A escolha da orientação de tela depende das necessidades do seu aplicativo. É importante fornecer uma experiência de usuário consistente e adequada para diferentes dispositivos e situações. Certifique-se de testar seu aplicativo em várias orientações para garantir que ele funcione corretamente em todos os cenários.