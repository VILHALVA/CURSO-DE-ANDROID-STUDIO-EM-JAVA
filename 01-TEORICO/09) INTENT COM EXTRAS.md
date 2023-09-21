# INTENT COM EXTRAS
As "Intents" com extras são usadas para transmitir dados (extras) entre componentes do Android, como entre atividades (Activities). Esses extras são informações adicionais que você deseja passar de uma atividade para outra. Aqui estão os passos básicos para criar uma "Intent" com extras em um aplicativo Android:

Suponha que você tenha uma `ActivityA` que deseja usar para enviar alguns dados para uma `ActivityB`. Aqui está como você faria isso:

**ActivityA (Enviar dados)**:

```java
// Suponha que você queira enviar uma string e um número int para a ActivityB.
String mensagem = "Olá, ActivityB!";
int numero = 42;

// Crie uma Intent
Intent intent = new Intent(ActivityA.this, ActivityB.class);

// Adicione os extras à Intent
intent.putExtra("mensagem_extra", mensagem);
intent.putExtra("numero_extra", numero);

// Inicie a ActivityB
startActivity(intent);
```

Neste exemplo, criamos uma "Intent" chamada `intent` e usamos o método `putExtra()` para adicionar informações extras à `Intent`. Os extras são identificados por chaves (no caso, "mensagem_extra" e "numero_extra").

**ActivityB (Receber dados)**:

```java
// Em ActivityB, recupere os extras da Intent
Intent intent = getIntent();

// Recupere os extras usando as chaves especificadas
String mensagemRecebida = intent.getStringExtra("mensagem_extra");
int numeroRecebido = intent.getIntExtra("numero_extra", 0); // 0 é o valor padrão se a chave não for encontrada

// Agora você pode usar as informações recebidas
```

Na `ActivityB`, você obtém a `Intent` que iniciou a atividade usando `getIntent()`. Em seguida, você pode usar os métodos `getStringExtra()` ou `getIntExtra()` para recuperar os extras com as chaves especificadas. Você também pode fornecer um valor padrão como segundo argumento para `getIntExtra()` para ser usado caso a chave não seja encontrada.

Certifique-se de que as chaves usadas para acessar os extras correspondam entre as atividades. Isso permite que você envie e receba os dados com sucesso.

Lembre-se de que os extras podem conter diferentes tipos de dados, como strings, números inteiros, booleanos, objetos serializáveis, etc., e você deve usar o método apropriado (por exemplo, `getStringExtra()` para strings) para recuperar os dados conforme necessário.