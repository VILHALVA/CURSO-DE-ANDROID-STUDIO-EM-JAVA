#  RETORNAR EXTRA

Para retornar um resultado (extra) de uma atividade para outra, você pode usar o método `setResult()` na atividade de destino e, em seguida, chamar `finish()` para encerrar a atividade. Na atividade que iniciou a segunda atividade, você pode usar `startActivityForResult()` para iniciar a atividade de destino e esperar um resultado de volta. Aqui está um exemplo de como fazer isso:

**ActivityA (Iniciar a ActivityB e esperar um resultado):**

```java
// Dentro da ActivityA, onde você deseja iniciar a ActivityB e esperar um resultado
public static final int REQUEST_CODE_ACTIVITY_B = 1; // Um código de solicitação personalizado

// ...

// Em algum lugar da ActivityA, inicie a ActivityB usando startActivityForResult
Intent intent = new Intent(ActivityA.this, ActivityB.class);
startActivityForResult(intent, REQUEST_CODE_ACTIVITY_B);
```

Neste exemplo, estamos usando `startActivityForResult()` para iniciar a ActivityB com um código de solicitação personalizado `REQUEST_CODE_ACTIVITY_B`.

**ActivityB (Retornar um resultado para a ActivityA):**

```java
// Dentro da ActivityB, onde você deseja retornar um resultado para a ActivityA
// Suponha que você deseja retornar uma string como resultado
String resultado = "Isso é um resultado!";

// Crie uma Intent para armazenar o resultado
Intent resultadoIntent = new Intent();
resultadoIntent.putExtra("resultado_extra", resultado);

// Defina o resultado e encerre a ActivityB
setResult(RESULT_OK, resultadoIntent);
finish();
```

Na ActivityB, você cria uma `Intent` chamada `resultadoIntent` para armazenar o resultado (um extra) que deseja retornar. Em seguida, você chama `setResult()` para definir o resultado como "RESULT_OK" (indicando que tudo correu bem) e anexa a `Intent` com o resultado usando `putExtra()`. Finalmente, você chama `finish()` para encerrar a ActivityB.

**ActivityA (Receber o resultado de volta):**

```java
// Dentro da ActivityA, onde você deseja receber o resultado da ActivityB
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == REQUEST_CODE_ACTIVITY_B) {
        if (resultCode == RESULT_OK) {
            // O resultado foi bem-sucedido, você pode recuperar os dados da Intent
            String resultadoRecebido = data.getStringExtra("resultado_extra");

            // Faça algo com o resultado
        } else {
            // O resultado foi cancelado ou houve um erro
        }
    }
}
```

Na ActivityA, você substitui o método `onActivityResult()` para receber o resultado da ActivityB. Verifique se o `requestCode` corresponde ao código de solicitação personalizado que você usou ao iniciar a ActivityB (`REQUEST_CODE_ACTIVITY_B`). Se o `resultCode` for igual a `RESULT_OK`, isso significa que o resultado foi bem-sucedido, e você pode recuperar os dados da `Intent` usando `getStringExtra()`. Se `resultCode` não for igual a `RESULT_OK`, algo pode ter acontecido para cancelar ou interromper a atividade.

Essa é a maneira de retornar um resultado (extra) de uma atividade para outra no Android. Isso é útil quando você precisa obter informações ou resultados específicos de uma atividade secundária para a atividade principal.