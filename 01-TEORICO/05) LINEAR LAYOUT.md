# LINEAR LAYOUT
`LinearLayout` é um dos layouts disponíveis no Android que permite organizar elementos de interface do usuário em uma única direção, seja na vertical ou na horizontal. É um dos layouts mais simples e amplamente usados no desenvolvimento Android.

Os principais atributos do `LinearLayout` são `android:orientation` e `android:layout_weight`:

- `android:orientation`: Define a orientação do `LinearLayout`, que pode ser "vertical" (padrão) ou "horizontal". Se definido como "vertical", os elementos são empilhados verticalmente, um abaixo do outro. Se definido como "horizontal", os elementos são alinhados horizontalmente, um ao lado do outro.

- `android:layout_weight`: É usado para atribuir um peso aos elementos dentro do `LinearLayout`. O peso determina a distribuição do espaço disponível entre os elementos. Por exemplo, se você tiver três elementos com pesos de 1, 2 e 1, o segundo elemento ocupará o dobro do espaço em relação aos outros dois.

Exemplo de um `LinearLayout` vertical simples:

```xml
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Texto 1" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Botão 1" />

    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/imagem1" />

</LinearLayout>
```

Neste exemplo, os elementos (um `TextView`, um `Button` e um `ImageView`) são empilhados verticalmente no `LinearLayout`.

Exemplo de um `LinearLayout` horizontal simples:

```xml
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal">

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Botão 1" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Botão 2" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Botão 3" />

</LinearLayout>
```

Neste exemplo, os elementos (três `Button`s) são alinhados horizontalmente no `LinearLayout`.

O `LinearLayout` é uma escolha comum para criar interfaces de usuário simples e alinhadas verticalmente ou horizontalmente, mas para layouts mais complexos, outros layouts, como `RelativeLayout`, `ConstraintLayout`, e `GridLayout`, podem ser mais adequados.