# Clase 07

En esta clase se ve la arquitectura de MVVM

Se transformaron todas las actividades a Fragment quedando con single Activity(MainActivity)

Recuerda que se agregaron las siguientes librerias de android

```
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"
    implementation "androidx.fragment:fragment-ktx:1.3.2"
    //Esta no la estamos usando pero para que sepan que hay una para actividad
    implementation "androidx.activity:activity-ktx:1.2.2"
```

En el viewModel se aplica un `AndroidViewModel`  es lo mismo que el `ViewModel` pero tiene acceso al contexto

Recuerden que para compartir data entre dos fragment tambien pueden usar un `viewmodel` y no el `bundle`

