# SHARED PREFERENCES
`SharedPreferences` é uma maneira de armazenar pequenas quantidades de dados em pares de chave-valor no Android. Isso é útil para armazenar configurações do aplicativo, preferências do usuário e outras informações simples que precisam ser mantidas entre sessões do aplicativo.

Aqui está uma visão geral de como usar `SharedPreferences` no Android:

1. **Obtendo uma referência ao `SharedPreferences`**:

   Você pode obter uma referência ao `SharedPreferences` associado ao seu aplicativo usando o contexto da atividade:

   ```java
   SharedPreferences sharedPreferences = getSharedPreferences("nome_do_arquivo", Context.MODE_PRIVATE);
   ```

   Substitua "nome_do_arquivo" por um nome significativo para o arquivo de preferências.

2. **Gravando dados no `SharedPreferences`**:

   Você pode usar o `SharedPreferences.Editor` para adicionar, atualizar ou remover valores no arquivo de preferências. Aqui está como adicionar um valor:

   ```java
   SharedPreferences.Editor editor = sharedPreferences.edit();
   editor.putString("chave", "valor"); // Substitua "chave" e "valor" pelos seus próprios dados
   editor.apply(); // Para salvar as alterações
   ```

   Você pode usar métodos como `putString()`, `putInt()`, `putBoolean()`, etc., dependendo do tipo de dado que deseja armazenar.

3. **Lendo dados do `SharedPreferences`**:

   Para ler dados armazenados no `SharedPreferences`, use os métodos `getTipo("chave", valor_padrão)`, onde "Tipo" pode ser `String`, `Int`, `Boolean`, etc. Se a chave não for encontrada, o valor padrão será retornado.

   ```java
   String valorLido = sharedPreferences.getString("chave", "valor_padrão");
   ```

4. **Removendo dados do `SharedPreferences`**:

   Para remover um valor do `SharedPreferences`, use o `SharedPreferences.Editor`:

   ```java
   SharedPreferences.Editor editor = sharedPreferences.edit();
   editor.remove("chave");
   editor.apply(); // Para salvar as alterações
   ```

   Isso remove o valor associado à chave especificada.

5. **Exemplo completo**:

   Aqui está um exemplo completo de como usar o `SharedPreferences`:

   ```java
   // Obtendo uma referência ao SharedPreferences
   SharedPreferences sharedPreferences = getSharedPreferences("configuracoes", Context.MODE_PRIVATE);

   // Gravando um valor no SharedPreferences
   SharedPreferences.Editor editor = sharedPreferences.edit();
   editor.putString("nome", "João");
   editor.putInt("idade", 30);
   editor.apply();

   // Lendo dados do SharedPreferences
   String nome = sharedPreferences.getString("nome", "");
   int idade = sharedPreferences.getInt("idade", 0);

   // Removendo um valor do SharedPreferences
   SharedPreferences.Editor editor = sharedPreferences.edit();
   editor.remove("idade");
   editor.apply();
   ```

`SharedPreferences` é uma maneira conveniente de lidar com preferências e configurações do usuário em seu aplicativo Android. Lembre-se de que ele é mais adequado para pequenas quantidades de dados, como configurações do aplicativo. Para armazenar grandes quantidades de dados estruturados, você pode considerar o uso de bancos de dados SQLite ou outras soluções de armazenamento.