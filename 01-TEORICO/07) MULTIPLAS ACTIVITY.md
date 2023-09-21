# INTENT E MULTIPLAS ACTIVITY
As "Intents" e o uso de múltiplas "Activity" são conceitos fundamentais no desenvolvimento de aplicativos Android para a criação de interfaces de usuário interativas e a navegação entre diferentes telas do aplicativo. Vou explicar ambos os conceitos:

## Intent:
Uma "Intent" é um objeto fundamental no Android que representa uma intenção ou ação a ser realizada. Ela é usada para iniciar componentes do Android, como atividades, serviços e receptores de broadcast. As "Intents" são usadas para:

1. **Iniciar Atividades (Activities)**: Uma das principais funções das "Intents" é iniciar uma atividade, que é uma tela de interface do usuário em um aplicativo Android. Por exemplo, ao clicar em um botão, você pode criar uma "Intent" para iniciar uma nova atividade.

2. **Iniciar Serviços**: "Intents" também podem ser usadas para iniciar serviços em segundo plano que executam tarefas sem uma interface do usuário visível.

3. **Enviar e Receber Dados**: "Intents" podem transportar dados entre componentes do aplicativo, seja para iniciar uma atividade com informações específicas ou para receber dados de um serviço em segundo plano.

Existem dois tipos principais de "Intents" no Android:

- **Explicit Intents**: São usadas para iniciar componentes específicos dentro do seu próprio aplicativo. Você especifica o nome da classe do componente que deseja iniciar.

- **Implicit Intents**: São usadas para solicitar a execução de uma ação por um componente de outro aplicativo. Você especifica uma ação e, possivelmente, um tipo de dados, e o sistema Android escolhe o componente apropriado para executar a ação.

## Múltiplas Activity:
As "Activity" são os blocos de construção básicos de uma interface do usuário em um aplicativo Android. Elas representam telas individuais do aplicativo e geralmente correspondem a uma única tela visível para o usuário. Você pode ter várias atividades em um aplicativo, e cada uma delas representa uma parte específica da funcionalidade do aplicativo.

O uso de múltiplas "Activity" é comum em aplicativos Android para:

- **Organizar o Fluxo do Aplicativo**: Você pode usar diferentes atividades para organizar o fluxo de navegação do aplicativo, de modo que os usuários possam passar de uma tela para outra de forma lógica.

- **Isolar Funcionalidades**: Cada atividade pode se concentrar em uma funcionalidade específica do aplicativo, tornando o código mais organizado e gerenciável.

- **Reutilização de Código**: Você pode reutilizar código comum em várias atividades, melhorando a eficiência do desenvolvimento.

- **Gerenciamento de Estado**: Cada atividade mantém seu próprio estado, o que pode ser útil para salvar informações quando o usuário navega entre as telas.

A transição entre atividades é geralmente feita usando "Intents". Você cria uma "Intent" para iniciar a próxima atividade e, assim, o usuário pode navegar entre as diferentes partes do aplicativo.

Para resumir, "Intents" são usadas para iniciar componentes do Android, enquanto as "Activity" são componentes que representam telas visíveis do aplicativo. O uso de múltiplas "Activity" é comum para organizar a interface do usuário e o fluxo do aplicativo em partes lógicas e funcionais.