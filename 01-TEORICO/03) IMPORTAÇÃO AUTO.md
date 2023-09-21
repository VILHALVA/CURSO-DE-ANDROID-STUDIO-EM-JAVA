# ATIVANDO IMPORTAÇÃO AUTOMATICA
Para ativar a importação automática (também conhecida como importação automática de classes) no Android Studio, siga estas etapas:

1. **Abra o Android Studio**:

   Certifique-se de que o Android Studio esteja aberto e o projeto esteja carregado.

2. **Acesse as Configurações do Android Studio**:

   - No Windows ou Linux, vá para o menu "File" e selecione "Settings".
   - No macOS, vá para o menu "Android Studio" e selecione "Preferences".

3. **Configurar as Preferências do Editor**:

   No painel esquerdo das configurações, expanda a categoria "Editor" e clique em "General".

4. **Ativar a Importação Automática**:

   Dentro das configurações gerais do editor, você verá uma opção chamada "Auto Import". Certifique-se de que as seguintes opções estejam marcadas:

   - "Add unambiguous imports on the fly"
   - "Optimize imports on the fly (for current project)"

   Certifique-se de que essas opções estejam marcadas para ativar a importação automática.

5. **Aplicar as Configurações**:

   Clique no botão "Apply" ou "OK" para salvar as configurações.

Agora, o Android Studio deve importar automaticamente classes e pacotes quando você usar um símbolo que não está importado no seu código. Isso facilitará o desenvolvimento, pois você não precisará se preocupar em importar manualmente todas as classes que utilizar em seu código.

Lembre-se de que a importação automática só funciona quando o símbolo que você está usando é inequívoco, ou seja, quando não há ambiguidade sobre a qual classe ou pacote deve ser importado. Se houver ambiguidade, o Android Studio pode solicitar que você escolha a importação correta.