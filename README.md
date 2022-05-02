# OO2

Este repositorio al igual que todos los comenzados en POO_ estan hechos con el proposito de mostrar 
ejercicios hechos durante la materia OO2.
En esta materia enseñan y realizan ejercicios relacionados a los patrones de diseño.

Practica 4: Patrones **Wrappers**: **Decorator** y **Proxy**

# Practica 4 Ejercicio 1: Acceso a la base de datos 
Queremos acceder a una base de datos que contiene información sobre cómics. Este acceso está dado por el comportamiento de la clase DatabaseRealAccess con el siguiente protocolo y modelado como muestra la Figura 1.

![Figura1](/Figura1.png)

```java
public interface DatabaseAccess {
   /**
    * Retorna una colección de acuerdo al texto que posee "queryString"
    *
    * @param queryString
    * @return
    */
   public Collection<String> getSearchResults(String queryString);
 
   /**
    * Realiza la inserción de nueva información en la base de datos y 
    * retorna el id que recibe la nueva inserción
    *
    * @param rowData
    * @return
    */
   public int insertNewRow(List<String> rowData);
}
```

En este caso, ustedes recibirán una implementación prototípica de la clase **DatabaseRealAccess** (ver material extra) que simula el uso de una base datos de la siguiente forma (mire el código y los tests para entender cómo está implementada).

```java
// Instancia una base de datos que posee dos filas
   database = new DatabaseRealAccess();
 
   // Retorna el siguiente arreglo: ['Spiderman' 'Marvel'].
   database.getSearchResults("select * from comics where id=1");
  
   // Retorna 3, que es el id que se le asigna
   database.insertNewRow(Arrays.asList("Patoruzú", "La flor"));
 
   // Retorna el siguiente arreglo: ['Patoruzú', 'La flor'], ya que lo insertó antes
   database.getSearchResults("select * from comics where id=3");
```

## Tareas
En esta oportunidad, usted debe proveer un protection proxy para que el acceso a la base de datos lo puedan realizar solamente usuarios que se hayan autenticado previamente. Su tarea es diseñar y programar en Java lo que sea necesario para ofrecer la funcionalidad antes descrita. Se espera que entregue los siguientes productos.
1. Diagrama de clases UML.
2. Implementación en Java de la funcionalidad requerida.
3. Implementación de los tests (JUnit) que considere necesarios.

## SOLUCION

1. ![UML](/dbaccessUML.png)
2. [Implementacion requerida.](/main/java/ar/edu/unlp/info/oo2/accesobd/) Podria mejorar el proxy, en vez de retornando boolean en el checkauth() deberia throwear una excepcion.
3. [Tests en JUnit](/test/java/ar/edu/unlp/info/oo2/accesobd/) que consideré necesarios.
