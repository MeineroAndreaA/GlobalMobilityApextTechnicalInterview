


# Rick & Morty App 

### Funcionalidades

- Listado de personajes: Al abrir la aplicación, se muestra un listado de todos los personajes de la serie de Rick and Morty. Este listado puede incluir la imagen del personaje y su nombre.

- Selección de un personaje: Cuando el usuario hace clic en uno de los personajes de la lista, se abre una nueva pantalla que muestra información detallada sobre ese personaje. Esta información podría incluir detalles como el nombre, la especie, el género, el estado (vivo, muerto, desconocido), y una descripción del personaje.

- Manejo de errores UI: La aplicación maneja los posibles errores que pueden ocurrir durante la carga de datos desde la API o durante la navegación entre pantallas. Por ejemplo, si hay un error al cargar la lista de personajes o al intentar ver los detalles de un personaje específico, la aplicación muestra un mensaje de error en la interfaz de usuario para informar al usuario sobre el problema. Asi como tambien manejo de errores HTTTP.

## Caracteristicas del proyecto

- Arquitectura MVVM
- Inyeccion de dependencias con Hilt
- Coil para la carga de imagenes
- GSON para el parseo de Json
- Retrofit para las llamadas a la API
- Jetpack
    - Compose
    - Navigation

    

## API Reference

#### Lista de todos los personajes

```http
  GET https://rickandmortyapi.com/api/character
```

#### Paginado via query param page

```http
  GET https://rickandmortyapi.com/api/character/?page=3
```

#### Obtener un unico personaje

```http
  GET https://rickandmortyapi.com/api/character/{id}
```

#### Obtener lista de personajes por filtro

```http
  GET https://rickandmortyapi.com/api/character/?name=rick&status=alive
```

