# Proyecto Contador
## Bloc 1. Contador
### Estructura del proyecto
Los ficheros y carpetas mas importantes de este proyecto son, la carpeta layout con los ficheros activity_main.xml y activity_mostra_comptador.xml, y la carpeta src/main con los ficheros MainActivity.kt y MostraComptadorActivity.kt

![alt text](image.png)

### Modificaciones
Las primeras modificaciones fueron añadir dos botones, una para decrementar el contador y otro para resetearlo. Para esto hay que modificar los ficheros activity_main.xml para crear los botones, como te eneseño en esta imagen,

![alt text](image-1.png)

y el fichero MainActivity.kt para darle funcionalidad a esos botones.

![alt text](image-2.png)

### Guardado de estado
Ahora tenemos que añadir varios metodos para guardar el estado del contador, asi cuando giremos la pantalla del dispositivo móvil, el número del contador quedara guardado.

![alt text](image-3.png)
![alt text](image-4.png)

### Intents
En este apartado tenemos que mostrar un segundo contador en otra ventana, el cual mantendrá el estado del primer contador y que en esta tengamos los botones para volver al contador anterior y un boton para cerrar la aplicación.
Para esto modificaremos los fichero activity_mostra_comptador.xml: 

![alt text](image-5.png)
![alt text](image-6.png)
![alt text](image-7.png)

Y MostraComptadorActivity.kt:

![alt text](image-8.png)
![alt text](image-9.png)

#### Pregunta
Para crear una nueva actividad, seria suficiente con solo crear un fichero xml con el layout y un fichero Kotlin con el codigo para gestionarla?
Si, seria suficiente.

## Bloc 2. Contador con MVVM
En este apartado tenemos que crear los botones para decrementar y resetear el contador. En este caso modificaremos el fichero activity_main.xml, donde creamos los botones para mostrarlos:

![alt text](image-10.png)

el fichero MainActivity.kt, donde creamos sus variables y llamamos a sus funciones:
![alt text](image-11.png)
![alt text](image-12.png)

y el fichero ComptadorViewModel.kt, donde creamos sus funciones:

![alt text](image-13.png)

#### Pregunta
Para mostrar el valor del contador en la actividad MostraComptadorActivity, creamos una Intent y le añadimos como parámetro el valor del contador de ViewModel.

Con la arquitectura MVVM, ¿este seguiría siendo necesario? ¿No podemos lanzar la Intento sin proporcionar ningún argumento? Si modificamos la segunda actividad para que haga uso también de ViewModel, ¿no podríamos acceder directamente al valor? Investiga sobre esa posibilidad.

Si, se puede evitar accediendo directamente a MostraComptadorActivity mediante un ViewModel compartido.

## Bloc 3. Contador con Compose
En este apartado tenemos que añadir los botones de decrementar y resetear al contador.
Tendremos que utilizar la funcion composable Row, para organizar los botones en una fila.

En este proyecto modificaremos el fichero MainActivity.kt, tal que asi:

![alt text](image-14.png)

