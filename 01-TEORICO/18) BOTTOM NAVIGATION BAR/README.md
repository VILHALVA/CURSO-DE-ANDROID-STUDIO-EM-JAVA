# BOTTOM DE NAVIGATION BAR
A Bottom Navigation Bar é uma parte comum da interface do usuário em aplicativos Android que permite que os usuários naveguem entre diferentes seções ou telas do aplicativo. Geralmente, é usado em conjunto com fragments para alternar entre os conteúdos de diferentes telas. Aqui estão os passos básicos para criar uma Bottom Navigation Bar junto com fragments em um layout:

**1. Adicione a Bottom Navigation Bar ao seu Layout:**

Primeiro, você precisa adicionar a Bottom Navigation Bar ao layout da sua atividade ou fragmento. Você pode fazer isso diretamente no arquivo XML de layout. Aqui está um exemplo de como você pode definir uma Bottom Navigation Bar no XML:

```xml
<com.google.android.material.bottomnavigation.BottomNavigationView
    android:id="@+id/bottom_navigation"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_gravity="bottom"
    app:menu="@menu/bottom_navigation_menu" />
```

Neste exemplo, estamos usando o componente `BottomNavigationView` do Material Design e vinculando-o a um menu `bottom_navigation_menu`.

**2. Crie o Menu da Bottom Navigation:**

Você precisa criar um arquivo de menu que define os itens da Bottom Navigation Bar. Cada item representa uma tela ou fragmento diferente. Aqui está um exemplo de como você pode definir um menu (`res/menu/bottom_navigation_menu.xml`):

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/action_home"
        android:icon="@drawable/ic_home"
        android:title="Home" />
    <item
        android:id="@+id/action_search"
        android:icon="@drawable/ic_search"
        android:title="Search" />
    <item
        android:id="@+id/action_profile"
        android:icon="@drawable/ic_profile"
        android:title="Profile" />
</menu>
```

Neste exemplo, temos três itens representando as telas "Home", "Search" e "Profile".

**3. Configurar a Navegação entre Fragments:**

Para alternar entre os fragments quando um item da Bottom Navigation Bar é selecionado, você precisa configurar um `FragmentManager`. Geralmente, você implementará um `OnNavigationItemSelectedListener` para gerenciar a seleção de itens e atualizar o conteúdo do fragmento correspondente. Aqui está um exemplo de código em Kotlin:

```kotlin
val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
val fragmentManager = supportFragmentManager

// Define o fragment inicial
var selectedFragment: Fragment = HomeFragment()

bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
    when (menuItem.itemId) {
        R.id.action_home -> selectedFragment = HomeFragment()
        R.id.action_search -> selectedFragment = SearchFragment()
        R.id.action_profile -> selectedFragment = ProfileFragment()
    }

    val transaction = fragmentManager.beginTransaction()
    transaction.replace(R.id.fragment_container, selectedFragment)
    transaction.commit()

    true
}
```

Neste exemplo, estamos definindo um `OnNavigationItemSelectedListener` para alternar entre os fragments quando os itens da Bottom Navigation Bar são selecionados. Os fragments são substituídos no `fragment_container`, que é o `FrameLayout` onde o conteúdo do fragmento será exibido.

Certifique-se de criar os fragments correspondentes (por exemplo, `HomeFragment`, `SearchFragment`, `ProfileFragment`) e vinculá-los corretamente à interface do usuário.

Com essas etapas, você deve ser capaz de criar uma Bottom Navigation Bar que permite a navegação entre fragments em seu aplicativo Android. Certifique-se de ajustar o código de acordo com a estrutura e os requisitos do seu aplicativo.

## Bottom Navigation Bar | Fragments - navegação
Para implementar a navegação entre fragments usando a Bottom Navigation Bar no Android, você pode usar a biblioteca de navegação do Android, que simplifica o gerenciamento da navegação entre telas e fragments. Aqui estão os passos para configurar a navegação entre fragments usando a Bottom Navigation Bar:

**1. Configurar a Biblioteca de Navegação:**

Certifique-se de que você adicionou a biblioteca de navegação ao seu projeto. Você pode fazê-lo no arquivo `build.gradle` do módulo de aplicativo:

```gradle
implementation "androidx.navigation:navigation-fragment-ktx:2.3.5"
implementation "androidx.navigation:navigation-ui-ktx:2.3.5"
```

Certifique-se de substituir a versão pela versão mais recente disponível.

**2. Criar um Grafo de Navegação:**

Você precisa criar um grafo de navegação que descreva as conexões entre os fragments do seu aplicativo. Isso é feito em um arquivo XML. Suponha que você tenha três fragments: `HomeFragment`, `SearchFragment` e `ProfileFragment`. Crie um arquivo `nav_graph.xml` em res/navigation com as conexões entre eles:

```xml
<?xml version="1.0" encoding="utf-8"?>
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/nav_graph"
    app:startDestination="@id/homeFragment">

    <fragment
        android:id="@+id/homeFragment"
        android:name="com.example.app.HomeFragment"
        android:label="Home Fragment"
        tools:layout="@layout/fragment_home" />

    <fragment
        android:id="@+id/searchFragment"
        android:name="com.example.app.SearchFragment"
        android:label="Search Fragment"
        tools:layout="@layout/fragment_search" />

    <fragment
        android:id="@+id/profileFragment"
        android:name="com.example.app.ProfileFragment"
        android:label="Profile Fragment"
        tools:layout="@layout/fragment_profile" />
</navigation>
```

Neste exemplo, definimos os três fragments no grafo de navegação e especificamos qual fragment deve ser a tela inicial (`app:startDestination`).

**3. Configurar a Bottom Navigation Bar:**

No layout da sua atividade principal, adicione a Bottom Navigation Bar. Certifique-se de que ele tenha IDs que correspondam aos IDs definidos no grafo de navegação.

```xml
<com.google.android.material.bottomnavigation.BottomNavigationView
    android:id="@+id/bottom_navigation"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:menu="@menu/bottom_navigation_menu" />
```

Neste exemplo, estamos usando um menu definido em `res/menu/bottom_navigation_menu.xml`, semelhante ao exemplo anterior.

**4. Configurar a Navegação na Atividade:**

No código da sua atividade principal, configure a navegação com a Bottom Navigation Bar:

```kotlin
val navController = findNavController(R.id.nav_host_fragment)
val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

bottomNavigationView.setupWithNavController(navController)
```

Certifique-se de que `R.id.nav_host_fragment` corresponde ao ID do `FragmentContainerView` que contém seus fragments. Isso conectará automaticamente a Bottom Navigation Bar ao controlador de navegação, permitindo que ela gerencie a navegação entre fragments.

**5. Lidar com o Back Stack (Pilha de Retrocesso):**

A biblioteca de navegação gerencia automaticamente a pilha de retrocesso para você. Portanto, quando um usuário pressionar o botão "Voltar", ele será levado de volta ao fragment anterior na pilha.

Com essas etapas, você configurou a navegação entre fragments usando a Bottom Navigation Bar e a biblioteca de navegação do Android. Certifique-se de ajustar os IDs dos fragments e as definições do menu de acordo com a estrutura do seu aplicativo. Isso facilitará a implementação da navegação e tornará seu código mais organizado.