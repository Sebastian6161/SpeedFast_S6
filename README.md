# SpeedFast - Sistema de Gestión de Pedidos

Sistema de gestión de pedidos y asignación de repartidores desarrollado en **Java (Swing)** aplicando el patrón de diseño **MVC (Modelo-Vista-Controlador)** y pruebas unitarias con **JUnit 5**.

---

## 📌 Descripción del Proyecto

**SpeedFast** es una aplicación de escritorio orientada a administrar la recepción, asignación y entrega de pedidos. Hace uso de una estructura de datos tipo cola (`Queue`) para organizar y procesar las entregas de manera secuencial o por lotes.

### Características Principales:
- **Registro de Pedidos**: Ingreso de nuevos pedidos con ID único, dirección y categoría (`comida`, `encomienda`, `express`).
- **Listado Dinámico**: Interfaz con `JTable` para visualizar en tiempo real el estado actual y el repartidor asignado a cada pedido.
- **Asignación de Repartidores**: Vinculación de un pedido pendiente a un repartidor disponible, cambiando su estado a `EN_REPARTO`.
- **Procesamiento en Cola**: Ejecución masiva de la cola de despachos, actualizando el estado de los pedidos a `ENTREGADO`.
- **Pruebas Unitarias Robustas**: Cobertura de pruebas automatizadas y parametrizadas para validar el comportamiento del controlador y el manejo de interrupciones.

---

## Estructura del Proyecto

El proyecto está organizado siguiendo el patrón **MVC**:

```text
src/
 ├── controladores/
 │    └── PedidoController.java      # Lógica de negocio y manejo de la cola
 ├── modelo/
 │    ├── EstadoPedido.java          # Enum (PENDIENTE, EN_REPARTO, ENTREGADO, INTERRUMPIDO)
 │    ├── Pedido.java                # Entidad Pedido
 │    └── Repartidor.java            # Entidad Repartidor
 ├── vista/
 │    ├── VentanaPrincipal.java      # Menú principal con las 4 acciones de navegación
 │    ├── VentanaRegistroPedido.java # Formulario para registrar pedidos
 │    ├── VentanaAsignarEntrega.java # Asignación de repartidores
 │    └── VentanaListaPedidos.java   # Tabla con el estado de todos los pedidos
 └── main/
      └── Main.java                  # Punto de entrada de la aplicación
```
---
## Flujo de Trabajo y Estados del Pedido
```text
[ Registrado ] --> PENDIENTE --(Asignar Repartidor)--> EN_REPARTO --(Procesar Cola)--> ENTREGADO
                                                                  \--(Interrupción)--> INTERRUMPIDO
```
Registrar pedido: El pedido se ingresa con el estado PENDIENTE y se añade a la cola de atención.

Asignar repartidor: Se vincula el repartidor seleccionado y el estado cambia a EN_REPARTO.

Procesar cola de entregas: Al presionar el botón de procesamiento en el menú principal, se vacía la cola mediante procesarCola() y los pedidos cambian su estado final a ENTREGADO.

## Ejecución de Pruebas Unitarias
Pruebas Parametrizadas: Escenarios dinámicos con distintas cantidades de pedidos y repartidores usando @ParameterizedTest y @CsvSource.

Prueba de Cola Vacía: Verificación de que no se generen excepciones al procesar una cola sin elementos.

Prueba de Interrupción: Validación del estado INTERRUMPIDO cuando el proceso se detiene antes del límite establecido.

Para ejecutar las pruebas en tu IDE (IntelliJ IDEA / Eclipse / NetBeans):

Haz clic derecho sobre la clase PedidoControllerTest.java.

```text
Selecciona Run 'PedidoControllerTest' (o Ejecutar como -> Test de JUnit).
```

---
👤 Autor
Desarrollado para la asignatura de programación/evaluación semana 6 del sistema SpeedFast.

