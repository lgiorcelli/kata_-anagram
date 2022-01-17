## Bitacora de resolución
### Primera lectura
#### Algunas dudas:
**2-worded anagram**: Significa algo mas que anagramas? revise un poco y me incline porq basicamente habla de anagramas. Nada particular para tener en cuenta  
Primeras consideraciones:
- La performance no puede dejarse de lado, el archivo de palabras tiene 33k de entradas
- Los anagramas tienen q tener la misma longitud, asi que es un buen primer filtro para buscar coincidencias
- Todas las letras deben estar contenidas, asi q puede ser un segundo filtro

### Primer bosquejo de solucion
- Seleccionar palabras a evaluar
- Buscar candidatos
  - Largo para un filtrado rapido
  - Que contengan (o no contengan) las letras del candidato
- buscar anagramas en detalle
### Observacion
Creo q seria mas eficiente hacer un todos contra todos que hacer palabra por palabra
Los tests deberian considerar tiempos?

### Iteracion 1
- reducir la complejidad de la prueba tomando grupos reducidos de palabras  
- buscar agrupar candidatos, en principio, palabras del mismo largo  
- Todas las palabras son validas, porque salen de un archivo validado  
- Cuando tenga las listas con igual tamaño de palabras, voy a agrupar por anagramas. Puedo agrupar dependiendo q letras contiene cada palabra  
Descubro una necesidad, matchear por letra o grupo de letras. Creo un objeto para q encapsule esa responsabilidad
### Insight
Puedo tener "traits" o caracteristicas de las palabras, y luego matchear por caracteristicas. Con esto generalizo un poco los atributos de las palabras y puedo buscar anagramas mas facilmente
Cambio entonces Matcher por Traits

### Iteración 2
- Una vez implementados los traits, el desafío ahora pasa por las operaciones de colecciones propias de Kotlin
Por otro lado, pase a usar mas prueba y error sobre un subconjunto de elementos de la lista de palabras
Esto se dio mas q nada porque me resulto mas facil ir a verificar en un resultado si estaba bien el algoritmo o no, que armar un set de datos para realizar tests. =(
- Para agrupar valores y sus traits cree la clase ClassifiedWord.
#### Cosas a mejorar
- Operar sobre el archivo completo
- Revisar tiempos de ejecucion y recursos consumidos
- Armar un ejecutable para darle cierre a la kata

### Iteracion 3
#### Cosas a mejorar
- Si bien se esta resolviendo la igualdad y el agrupamiento, dependemos directamente de las herramientas de kotlin, haciendo complejo algun cambio de estrategia. Encapsularlo haria mas facil proximos cambios
- Organizar los pasos para poder encapsular las partes y mejorar el entendimiento. 