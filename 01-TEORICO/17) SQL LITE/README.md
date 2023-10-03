# BASE DE DADOS SQL LITE
No desenvolvimento de aplicativos Android, o SQLite é frequentemente usado como um banco de dados local para armazenar e gerenciar dados estruturados. Duas funções importantes que você precisa entender ao trabalhar com o SQLite em um aplicativo Android são `onCreate` e `onUpgrade`. Elas estão relacionadas à criação e atualização do banco de dados. Vamos ver como funcionam essas funções:

## onCreate:
   
   A função `onCreate` é chamada quando o banco de dados SQLite é criado pela primeira vez. Isso geralmente ocorre quando o aplicativo é instalado pela primeira vez no dispositivo ou quando o banco de dados não existe.

   Você deve sobrescrever a função `onCreate` em uma classe que estende `SQLiteOpenHelper`. Dentro dela, você define a estrutura do banco de dados, ou seja, cria tabelas e define as colunas que deseja armazenar. Aqui está um exemplo de como você pode implementar o método `onCreate`:

   ```java
   @Override
   public void onCreate(SQLiteDatabase db) {
       String createTableQuery = "CREATE TABLE tabela_exemplo ("
               + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
               + "nome TEXT,"
               + "idade INTEGER)";
       db.execSQL(createTableQuery);
   }
   ```

   Neste exemplo, estamos criando uma tabela chamada "tabela_exemplo" com duas colunas: "nome" e "idade".

## onUpgrade:

   A função `onUpgrade` é chamada quando uma nova versão do seu aplicativo é instalada e a estrutura do banco de dados precisa ser atualizada para acomodar as mudanças. Isso pode incluir adição de novas tabelas, alteração de esquemas de tabelas existentes, entre outras modificações no banco de dados.

   Você deve sobrescrever a função `onUpgrade` e, dentro dela, implementar a lógica para realizar as atualizações necessárias. Aqui está um exemplo de como você pode implementar o método `onUpgrade`:

   ```java
   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       if (oldVersion < 2) {
           // Código de atualização para a versão 2 do banco de dados
           db.execSQL("ALTER TABLE tabela_exemplo ADD COLUMN sobrenome TEXT");
       }
       if (oldVersion < 3) {
           // Código de atualização para a versão 3 do banco de dados
           db.execSQL("CREATE TABLE nova_tabela (_id INTEGER PRIMARY KEY, novo_valor TEXT)");
       }
   }
   ```

   Neste exemplo, estamos verificando a versão antiga do banco de dados e aplicando as atualizações necessárias para cada versão subsequente.

É importante gerenciar as atualizações do banco de dados com cuidado, pois as alterações na estrutura do banco de dados podem afetar a integridade dos dados armazenados. Certifique-se de testar suas atualizações de banco de dados em vários cenários antes de lançar uma nova versão do seu aplicativo.

Para gerenciar o banco de dados SQLite no Android, é recomendável criar uma classe auxiliar que estende `SQLiteOpenHelper` e use-a para criar e atualizar o banco de dados, bem como executar operações de leitura e gravação. Isso ajuda a manter o código organizado e fácil de gerenciar.

## SELECT:
O comando `SELECT` é usado em SQL para recuperar dados de um banco de dados. No contexto do Android e do SQLite, você pode usar o `SELECT` para recuperar informações armazenadas no banco de dados local. Aqui estão as etapas básicas para realizar uma consulta `SELECT` no Android:

1. **Criar uma Instância do Banco de Dados**:

   Primeiro, você precisa criar uma instância do banco de dados SQLite ou obter acesso a uma instância existente. Isso geralmente é feito por meio de uma classe que estende `SQLiteOpenHelper`. Suponha que você tenha uma classe `DatabaseHelper` que gerencia seu banco de dados:

   ```java
   DatabaseHelper dbHelper = new DatabaseHelper(context); // Substitua 'context' pelo contexto do seu aplicativo.
   SQLiteDatabase db = dbHelper.getReadableDatabase(); // Abre o banco de dados em modo de leitura.
   ```

2. **Executar a Consulta SELECT**:

   Você pode usar o método `rawQuery()` da classe `SQLiteDatabase` para executar a consulta SQL. Este método permite que você execute consultas SQL brutas e recupere os resultados. Aqui está um exemplo de como executar uma consulta `SELECT` simples:

   ```java
   String query = "SELECT * FROM tabela_exemplo"; // Substitua 'tabela_exemplo' pelo nome da sua tabela.
   Cursor cursor = db.rawQuery(query, null);
   ```

3. **Processar os Resultados**:

   O resultado da consulta `SELECT` é retornado como um objeto `Cursor`. Você pode usar o `Cursor` para iterar pelos resultados e recuperar os dados. Por exemplo, para iterar por todas as linhas retornadas pela consulta:

   ```java
   if (cursor != null) {
       while (cursor.moveToNext()) {
           int id = cursor.getInt(cursor.getColumnIndex("_id")); // Recupera o valor da coluna "_id".
           String nome = cursor.getString(cursor.getColumnIndex("nome")); // Recupera o valor da coluna "nome".
           int idade = cursor.getInt(cursor.getColumnIndex("idade")); // Recupera o valor da coluna "idade".

           // Faça algo com os dados recuperados, como exibi-los na interface do usuário.
       }
       cursor.close(); // Não esqueça de fechar o cursor quando terminar de usá-lo.
   }
   ```

   Certifique-se de substituir os nomes de tabela e coluna pelos nomes reais usados em seu banco de dados.

4. **Fechar o Banco de Dados**:

   Após concluir as operações no banco de dados, é importante fechar a conexão para liberar recursos:

   ```java
   db.close();
   ```

Lembre-se de que o código de acesso ao banco de dados deve ser executado em uma thread separada (não na thread principal) para evitar bloqueios na interface do usuário. Em aplicativos Android, é comum usar bibliotecas como o "Android Room" para facilitar o acesso ao banco de dados SQLite de maneira segura e eficiente.

Além disso, para evitar problemas de segurança, é recomendável usar consultas parametrizadas ou consultas preparadas em vez de construir consultas SQL diretamente concatenando strings. Isso ajuda a prevenir ataques de injeção de SQL e garante que seus dados estejam seguros.

## Inserção de Dados (INSERT):
Para inserir dados em uma tabela, você pode usar o método `insert()` da classe `SQLiteDatabase`. Aqui está um exemplo de como inserir um novo registro em uma tabela:

```java
ContentValues values = new ContentValues();
values.put("nome", "João");
values.put("idade", 30);

long newRowId = db.insert("tabela_exemplo", null, values);

if (newRowId != -1) {
    // Inserção bem-sucedida, o newRowId contém o ID da nova linha inserida.
} else {
    // Ocorreu um erro durante a inserção.
}
```

Substitua "tabela_exemplo" pelo nome da tabela onde você deseja inserir os dados. O objeto `ContentValues` é usado para mapear os valores das colunas.

## Atualização de Dados (UPDATE):
Para atualizar dados em uma tabela, use o método `update()` da classe `SQLiteDatabase`. Aqui está um exemplo de como atualizar um registro existente em uma tabela:

```java
ContentValues values = new ContentValues();
values.put("idade", 31); // Novo valor para a coluna "idade".

String whereClause = "_id = ?"; // A cláusula WHERE para identificar o registro a ser atualizado.
String[] whereArgs = {"1"}; // Os valores dos argumentos da cláusula WHERE.

int rowsAffected = db.update("tabela_exemplo", values, whereClause, whereArgs);

if (rowsAffected > 0) {
    // Atualização bem-sucedida.
} else {
    // Nenhum registro foi atualizado (registro não encontrado ou erro).
}
```

Neste exemplo, estamos atualizando o valor da coluna "idade" para 31 onde o "_id" é igual a 1.

## Exclusão de Dados (DELETE):
Para excluir dados de uma tabela, use o método `delete()` da classe `SQLiteDatabase`. Aqui está um exemplo de como excluir um registro de uma tabela:

```java
String whereClause = "_id = ?"; // A cláusula WHERE para identificar o registro a ser excluído.
String[] whereArgs = {"1"}; // Os valores dos argumentos da cláusula WHERE.

int rowsDeleted = db.delete("tabela_exemplo", whereClause, whereArgs);

if (rowsDeleted > 0) {
    // Exclusão bem-sucedida.
} else {
    // Nenhum registro foi excluído (registro não encontrado ou erro).
}
```

Neste exemplo, estamos excluindo o registro onde o "_id" é igual a 1.

Lembre-se de que, ao executar operações de inserção, atualização ou exclusão no SQLite, é importante garantir que você tenha as permissões adequadas para acessar o banco de dados e que esteja executando essas operações em uma thread separada para não bloquear a interface do usuário.

Além disso, é altamente recomendável usar consultas parametrizadas ou consultas preparadas ao construir cláusulas WHERE para evitar vulnerabilidades de injeção de SQL e garantir a segurança dos seus dados.