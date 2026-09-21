# SpeedFast - Gestión de Pedidos

Proyecto desarrollado en Java para la gestión y simulación de entregas de pedidos de SpeedFast.

El proyecto incorpora una interfaz gráfica desarrollada con Java Swing, junto con un sistema de gestión de pedidos, repartidores, estados de entrega y una cola de procesamiento.

Además, se incorporaron pruebas automatizadas para validar el procesamiento con distintas cantidades de pedidos y repartidores, el comportamiento de una cola vacía y los estados finales cuando ocurre una interrupción.

---

## Tecnologías utilizadas

- Java 26
- Java Swing
- Maven
- JUnit 5
- IntelliJ IDEA
- Git y GitHub

---

## Estructura del proyecto

El proyecto se encuentra organizado en los siguientes paquetes:

```text
src
├── main
│   └── java
│       ├── controladores
│       │   └── PedidoController.java
│       │
│       ├── main
│       │   └── Main.java
│       │
│       ├── modelo
│       │   ├── EstadoPedido.java
│       │   ├── Pedido.java
│       │   └── Repartidor.java
│       │
│       └── vista
│           ├── VentanaPrincipal.java
│           ├── VentanaRegistroPedido.java
│           ├── VentanaListaPedidos.java
│           └── VentanaAsignarEntrega.java
│
└── test
    └── java
        └── controladores
            └── PedidoControllerTest.java


```

# Funcionalidades Principales

1. Registrar pedidos

La aplicación permite registrar nuevos pedidos mediante una ventana gráfica.

Para cada pedido se ingresan:

ID
Dirección
Tipo de pedido

Los tipos disponibles son:

comida
encomienda
express

El sistema valida que los campos obligatorios estén completos y que el ID sea un número mayor que 0.

Al registrar un pedido, este queda inicialmente en estado:
```
PENDIENTE
```

Además, el pedido es agregado a la lista general de pedidos y a la cola de procesamiento.

# Listar pedidos

La aplicación cuenta con una ventana que permite visualizar los pedidos registrados mediante una tabla ```JTable```.

La tabla muestra:

ID
Dirección
Tipo
Estado
Repartidor

La información puede actualizarse mediante el botón:

```Actualizar```

Esto permite visualizar los cambios producidos en los pedidos después de asignar repartidores o procesar la cola.

# Asignar repartidores

La aplicación permite seleccionar:

Un pedido pendiente.
Un repartidor disponible.

Los repartidores iniciales son:

Carlos
María
Pedro

Al asignar un repartidor, el pedido cambia al estado:

``` EN_REPARTO ```

La información del repartidor queda asociada al pedido.

# Cola de pedidos

Los pedidos registrados son almacenados también en una cola utilizando:

```  Queue<Pedido> ``` 

La cola permite procesar los pedidos en el orden en que fueron agregados.

El sistema cuenta con una opción:

```  Procesar cola de entregas ``` 

Cuando se procesa la cola, los pedidos son asignados a los repartidores disponibles y posteriormente pasan al estado:

```  ENTREGADO ``` 

La asignación de repartidores durante el procesamiento se realiza de manera rotativa.

# Estados de los pedidos

Los pedidos pueden utilizar los siguientes estados:

``` 
PENDIENTE
EN_REPARTO
ENTREGADO
INTERRUMPIDO
PENDIENTE
``` 

Estado inicial de un pedido recién registrado.

 EN_REPARTO 

Se establece cuando un repartidor es asignado al pedido.

ENTREGADO

Se establece cuando el pedido es procesado correctamente mediante la cola.

INTERRUMPIDO

Se utiliza cuando el procesamiento de la cola es interrumpido antes de completar todos los pedidos.

# Procesamiento con interrupción

El controlador también permite simular una interrupción durante el procesamiento de la cola.

El método:

``` procesarConInterrupcion() ``` 

permite definir una cantidad máxima de pedidos que serán procesados antes de producir la interrupción.

Los pedidos procesados antes del límite quedan en:

``` ENTREGADO``` 

Los pedidos restantes quedan en:

``` INTERRUMPIDO``` 

Finalmente, la cola queda vacía.

# Pruebas automatizadas

El proyecto incluye pruebas unitarias desarrolladas con JUnit 5.

Las pruebas se encuentran en:

``` src/test/java/controladores/PedidoControllerTest.java``` 

Prueba con distintas cantidades

Se utiliza una prueba parametrizada para verificar el procesamiento con diferentes cantidades de pedidos y repartidores.

Los casos utilizados son:


| Pedidos | Repartidores |
| :---: | :---: |
| 1 | 1 |
| 10 | 2 |
| 50 | 5 |
| 100 | 10 |


En cada caso se verifica que:
- Los pedidos sean agregados correctamente.
- La cantidad de pedidos en la cola sea correcta.
- La cola quede vacía después del procesamiento.
- Todos los pedidos finalicen como `ENTREGADO`.
- Cada pedido tenga un repartidor asignado.

También se verifica el comportamiento cuando no existen pedidos pendientes.

Se comprueba que:

- La cola comience vacía.
- El procesamiento no genere excepciones.
- La cola permanezca vacía.
- Prueba de interrupción

Se utilizan 10 pedidos y se establece un límite de procesamiento de 4 pedidos.

El resultado esperado es:

``` 
4 pedidos → ENTREGADO
6 pedidos → INTERRUMPIDO
```

**También se comprueba que la cola quede vacía y que todos los pedidos tengan un estado final válido.**


# Cómo ejecutar el proyecto

IntelliJ IDEA
Abrir el proyecto en IntelliJ IDEA.
Esperar a que Maven cargue las dependencias.
Abrir:
src/main/java/main/Main.java
Ejecutar el método:
main()

Se abrirá la ventana principal de SpeedFast.

# Ejecutar las pruebas
Para ejecutar las pruebas automatizadas desde IntelliJ IDEA:

Abrir:
```  src/test/java/controladores/PedidoControllerTest.java ``` 
Hacer clic derecho sobre la clase.
Seleccionar Run 'PedidoControllerTest'.

# Mejoras incorporadas a partir de la retroalimentación

A partir de la retroalimentación recibida en la evaluación anterior, se incorporaron mejoras orientadas a comprobar el funcionamiento del sistema en diferentes escenarios.

Entre ellas:

Pruebas repetibles con diferentes cantidades de pedidos y repartidores.
Validación de una cola inicialmente vacía.
Validación de los estados finales de los pedidos.
Simulación de interrupciones durante el procesamiento.
Verificación de que la cola quede vacía después del procesamiento.
Pruebas automatizadas mediante JUnit 5.
Documentación de la ejecución y de las pruebas disponibles.

Estas mejoras permiten comprobar el comportamiento del sistema en diferentes escenarios de procesamiento.

# Autor
Sebastián Ávila


