# BUNDLE DE EXTRAS
Um `Bundle` é uma estrutura de dados no Android que é frequentemente usada para armazenar e transmitir dados entre componentes, como entre atividades (Activities), serviços e receptores de broadcast. Ele permite que você empacote vários tipos de dados, como strings, números inteiros, objetos serializáveis e muito mais, para serem passados entre componentes do Android. O uso de `Bundle` é comum ao lidar com extras em `Intents`, como ao enviar e receber dados entre atividades.

Aqui estão os passos básicos para usar um `Bundle` para passar extras entre atividades:

**Activity A (Enviar dados)**:

```java
// Crie um Bundle para armazenar os extras
Bundle extras = new Bundle();

// Adicione dados ao Bundle
String nome = "John";
int idade = 30;
extras.putString("nome_extra", nome);
extras.putInt("idade_extra", idade);

// Crie uma Intent e associe o Bundle a ela
Intent intent = new Intent(ActivityA.this, ActivityB.class);
intent.putExtras(extras);

// Inicie a ActivityB com a Intent contendo o Bundle
startActivity(intent);
```

Neste exemplo, estamos criando um `Bundle` chamado `extras` e adicionando dados a ele usando os métodos apropriados, como `putString()` e `putInt()`. Em seguida, associamos o `Bundle` à `Intent` usando `putExtras()` e iniciamos a `ActivityB` com essa `Intent`.

**Activity B (Receber dados)**:

```java
// Dentro da ActivityB, recupere os dados do Bundle
Bundle extras = getIntent().getExtras();

if (extras != null) {
    String nomeRecebido = extras.getString("nome_extra");
    int idadeRecebida = extras.getInt("idade_extra");

    // Faça algo com os dados recebidos
}
```

Na `ActivityB`, recuperamos o `Bundle` associado à `Intent` usando `getIntent().getExtras()`. Verificamos se o `Bundle` não é nulo e, em seguida, usamos os métodos `getString()` e `getInt()` para extrair os dados do `Bundle`.

É importante que as chaves usadas para adicionar e recuperar dados do `Bundle` correspondam entre as atividades. Isso garante que você possa enviar e receber os dados com sucesso.

O uso de `Bundle` é uma maneira eficaz de transmitir dados entre atividades e outros componentes do Android de maneira estruturada e flexível. Você pode armazenar e recuperar vários tipos de dados usando as funções apropriadas no `Bundle`.