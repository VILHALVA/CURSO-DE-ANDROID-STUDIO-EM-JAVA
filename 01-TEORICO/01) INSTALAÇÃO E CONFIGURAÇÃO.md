# COMO INSTALAÇÃO E CONFIGURAÇÃO
## INSTALANDO O ANDROID STUDIO
Aqui está um guia passo a passo sobre como instalar o Android Studio:

1. **Requisitos de Sistema**:

   Antes de instalar o Android Studio, verifique se o seu sistema atende aos requisitos mínimos. Geralmente, você precisará de um sistema com as seguintes especificações:

   - Sistema operacional: Windows, macOS ou Linux.
   - 8 GB de RAM ou mais.
   - Espaço em disco rígido livre de pelo menos 4 GB (para a instalação do Android Studio e dos componentes SDK).
   - Processador Intel i5 ou equivalente.
   - Resolução de tela de 1280x800 pixels ou superior.

2. **Baixar o Android Studio**:

   Acesse o site oficial do Android Studio em [https://developer.android.com/studio](https://developer.android.com/studio).

   - Clique no botão "Download do Android Studio" para baixar o instalador.

3. **Instalar o Android Studio**:

   - **Windows**: Execute o arquivo `.exe` baixado e siga as instruções do instalador.

   - **macOS**: Abra o arquivo `.dmg` baixado e arraste o ícone do Android Studio para a pasta "Aplicativos". Depois, abra o Android Studio a partir da pasta "Aplicativos".

   - **Linux**: Extraia o arquivo `.zip` baixado para uma pasta de sua escolha. Dentro dessa pasta, você encontrará um arquivo `studio.sh`. Execute esse arquivo no terminal usando o comando `./studio.sh` e siga as instruções de configuração.

4. **Configurar o Android Studio**:

   - Na primeira execução, o Android Studio solicitará que você configure suas preferências iniciais. Isso inclui a escolha de um tema, configuração de teclas de atalho e a instalação de componentes adicionais.

   - Siga as instruções na tela para aceitar as configurações padrão ou personalizá-las de acordo com suas preferências.

5. **Baixar SDK do Android**:

   O Android Studio irá sugerir que você baixe o SDK do Android necessário para o desenvolvimento. Certifique-se de aceitar essa sugestão e aguarde o download dos componentes do SDK.

6. **Configurar Dispositivos Virtuais (AVDs)**:

   Para testar seus aplicativos, você pode configurar Dispositivos Virtuais Android (AVDs). O Android Studio oferecerá a opção de criar um AVD durante o processo de configuração inicial ou você pode fazê-lo posteriormente na seção "AVD Manager".

7. **Concluir a Configuração**:

   Depois de seguir todas essas etapas, o Android Studio estará pronto para uso. Você pode criar novos projetos, abrir projetos existentes e começar a desenvolver aplicativos Android.

Lembre-se de que o processo de instalação pode variar um pouco com base no sistema operacional que você está usando, mas as etapas básicas são semelhantes. Certifique-se de ler e seguir as instruções fornecidas durante o processo de instalação.

## CRIANDO O EMULADOR:
Para criar um emulador (Dispositivo Virtual Android - AVD) no Android Studio, siga estas etapas:

1. **Abra o Android Studio**:

   Inicie o Android Studio e certifique-se de que o ambiente está totalmente carregado.

2. **Acesse o AVD Manager**:

   Vá para a barra de ferramentas superior e clique no ícone "AVD Manager" ou acesse por meio do menu "Tools" > "AVD Manager".

3. **Crie um Novo Dispositivo Virtual (AVD)**:

   Clique no botão "Create Virtual Device".

4. **Selecione um Dispositivo**:

   Escolha o tipo de dispositivo que deseja emular. O Android Studio oferece uma variedade de dispositivos pré-configurados para escolher.

5. **Escolha uma Versão do Android**:

   Selecione uma versão do Android para o dispositivo virtual. Você pode optar por baixar versões adicionais caso não tenha sido baixada anteriormente.

6. **Configure o AVD**:

   - **Nome do AVD**: Dê um nome ao seu dispositivo virtual.
   - **Configurações de Hardware**: Personalize as configurações de hardware, como a quantidade de RAM e armazenamento interno.
   - **Imagem do Sistema**: Selecione a imagem do sistema Android que você deseja usar.
   - **Configurações Avançadas**: Configure configurações adicionais, se necessário.

7. **Crie o AVD**:

   Clique no botão "Finish" para criar o dispositivo virtual.

8. **Inicie o Dispositivo Virtual**:

   No AVD Manager, selecione o dispositivo virtual que você acabou de criar e clique no botão "Play" para iniciá-lo.

   Aguarde até que o dispositivo virtual seja iniciado e, em seguida, você poderá testar e executar seus aplicativos Android no emulador.

Lembre-se de que o processo de criação do AVD pode variar ligeiramente dependendo da versão específica do Android Studio que você está usando. Certifique-se de seguir as instruções exibidas na tela durante o processo de criação do dispositivo virtual.