## Pokedex API

API desarrollada con Spring boot, que permite exponer de forma mucho más simplificada la información de <b>Pokemones</b> existente en el API <a href="https://pokeapi.co/">https://pokeapi.co/</a> 

## Ejecución Local
Para ejecutar el proyecto localmente, se debe ejecutar el siguiente comando estando situado dentro de la carpeta raiz del proyecto: mvn spring-boot:run, generando los siguientes endpoints:
* http://localhost:8080/pokemon/all
* http://localhost:8080/pokemon/{name}


## Probar API

El API se encuentra publicado en google cloud, se puede probar directamente en las siguientes URLs:

* <a href="https://pokedex-api-370404.rj.r.appspot.com/pokemon/all">https://pokedex-api-370404.rj.r.appspot.com/pokemon/all</a>
     , Este endpoint recibe dos parámetros en la URL que permiten definir la paginación 
     * <b>limit</b>: permite definir la cantidad de registros por consulta
     * <b>offset</b>: permite definir desde que registro se quiere consultar, el valor por defecto es 0
     Si no se definen parámetros, el API tomará por defecto limit=20 y offset=0, generando el siguiente endpoint: https://pokedex-api-370404.rj.r.appspot.com/pokemon/all?limit=20&offset=0
* <a href="https://pokedex-api-370404.rj.r.appspot.com/pokemon/{name}">https://pokedex-api-370404.rj.r.appspot.com/pokemon/{name}</a>
     , Este endpoint requiere que se defina el <b>nombre</b> del pokemon a consultar. Se puede ver un listado completo <a href="https://www.wikidex.net/wiki/Lista_de_Pok%C3%A9mon">aquí</a>
