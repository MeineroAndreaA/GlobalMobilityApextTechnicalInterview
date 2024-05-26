


# Rick & Morty App 

### Funcionalidades

- Listado de personajes: Al abrir la aplicación, se muestra un listado de todos los personajes de la serie de Rick and Morty. Este listado puede incluir la imagen del personaje y su nombre.

- Selección de un personaje: Cuando el usuario hace clic en uno de los personajes de la lista, se abre una nueva pantalla que muestra información detallada sobre ese personaje. Esta información podría incluir detalles como el nombre, la especie, el género, el estado (vivo, muerto, desconocido), y una descripción del personaje.

- Manejo de errores UI: La aplicación maneja los posibles errores que pueden ocurrir durante la carga de datos desde la API o durante la navegación entre pantallas. Por ejemplo, si hay un error al cargar la lista de personajes o al intentar ver los detalles de un personaje específico, la aplicación muestra un mensaje de error en la interfaz de usuario para informar al usuario sobre el problema. Asi como tambien manejo de errores HTTTP.

## Caracteristicas del proyecto

- Arquitectura MVVM
- Inyeccion de dependencias con Dagger/Hilt
- Coil para la carga de imagenes
- GSON para el parseo de Json
- Retrofit para las llamadas a la API
- Jetpack
    - Compose
    - Navigation

    

## API Reference y evidencia

#### Lista de todos los personajes

```http
  GET https://rickandmortyapi.com/api/character
```

https://github.com/MeineroAndreaA/GlobalMobilityApextTechnicalInterview/assets/42178965/a27beccc-a03c-403a-acac-bf3f40e2547a

#### Paginado via query param page

```http
  GET https://rickandmortyapi.com/api/character/?page=3
```


https://github.com/MeineroAndreaA/GlobalMobilityApextTechnicalInterview/assets/42178965/e7082add-fd03-46af-9a98-bf213a568ae5


#### Obtener un unico personaje

```http
  GET https://rickandmortyapi.com/api/character/{id}
```


https://github.com/MeineroAndreaA/GlobalMobilityApextTechnicalInterview/assets/42178965/46134ad6-fe96-4d51-8f7f-435829890d9b


#### Obtener lista de personajes por filtro

```http
  GET https://rickandmortyapi.com/api/character/?name=rick&status=alive
```
##### Nombre


https://github.com/MeineroAndreaA/GlobalMobilityApextTechnicalInterview/assets/42178965/a8640a37-f6a7-4a91-8837-0feb55107912


##### Estado


https://github.com/MeineroAndreaA/GlobalMobilityApextTechnicalInterview/assets/42178965/1b52918a-c63c-409b-a7f6-51ca41010ce6


##### Especie



https://github.com/MeineroAndreaA/GlobalMobilityApextTechnicalInterview/assets/42178965/bcdd76cc-4a88-4637-9849-f8119185aa86

## Manejo de flujo con pantallas para informar errores o falta de resultados

 En esta secion se realizaron las siguientes pruebas, correspondientes a la visualizacion de pantallas del tipo respuesta.

- Caso 1 : Manejo de falta de respuesta de API por desconexion de internet.


https://github.com/MeineroAndreaA/GlobalMobilityApextTechnicalInterview/assets/42178965/68c34ab1-9c41-4b60-b771-c23e90abead1

- Caso 2 : El filtro no devolvio valores



https://github.com/MeineroAndreaA/GlobalMobilityApextTechnicalInterview/assets/42178965/9b235135-e5ae-4864-bf15-7d47331dbfb8



https://github.com/MeineroAndreaA/GlobalMobilityApextTechnicalInterview/assets/42178965/83bbbf75-12c8-4c47-8830-b10044d967ce




