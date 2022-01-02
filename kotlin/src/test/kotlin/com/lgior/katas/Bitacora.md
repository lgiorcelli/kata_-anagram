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