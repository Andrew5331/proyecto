# Proyecto
## Taller final: Fundamentos de Programación :)

**Tienda de Videojuegos de Ken**
Opciones del Menú Principal:
1. Ingresar como vendedor
   - Consultar Juego
   - Realizar Venta
   - Generar Factura
   - Cargar/Actualizar Juego
   - Cargar Cliente
   - Consultar Cliente
   - Volver Atrás
2. Comprar Membresía
   - Seleccionar Membresía
   -  Consultar Beneficios
   -  Procesar Pago
   -  Volver Atrás
3. Consultar Fecha
4. Salir

## Descripción


***Descripción del Menú de Membresía***


Este menú permite a los clientes adquirir una membresía que les otorga descuentos especiales en todas sus compras. Aquí se detallan las opciones disponibles:
1. Seleccionar Membresía (2.1):
El cliente puede elegir entre las siguientes opciones de membresía:
  * Membresía Gold ($140,000): Ofrece un 10% de descuento en todas las compras de videojuegos.
  * Membresía Silver ($100,000): Ofrece un 5% de descuento en todas las compras de videojuegos.
  * Membresía Bronze ($30,000): Ofrece un 3% de descuento en todas las compras de videojuegos.
2. Consultar Beneficios (2.2):
Proporciona información sobre los beneficios de cada tipo de membresía, incluyendo:
  * Descuentos aplicables.
  * Acceso a promociones exclusivas.
  * Posibilidad de acumular descuentos adicionales en función de otras condiciones (como ser estudiante o mujer).
3. Procesar Pago (2.3):
Una vez seleccionada la membresía, se solicitará la información del cliente (nombre, cédula, etc.) y se procesará el pago correspondiente. Se generará un recibo de compra que confirmará la adquisición de la membresía.
Membresías: 
  * Gold
  * Silver
  * Bronze
Descuentos:
  * Descuento por ser estudiante: Si estás matriculado/a en una institución educativa, recibes un 5% de descuento en todas tus compras.
  * Descuentos por membresía activa:
    - Membresía Silver ($100,000): 5% de descuento.
    - Membresía Gold ($140,000): 10% de descuento.
    - Membresía Bronze ($30,000): 3% de descuento.
  * Descuento por género: Si eres mujer, recibes un 10% adicional en todas tus compras. (Este descuento es acumulable con otros descuentos, a menos que se indique lo contrario).
  * Descuentos por edad:
    - Menores de 18 años: 30% de descuento en todas las compras, independientemente de tu membresía.
    - Entre 18 y 25 años:
        + Si eres estudiante: 60% de descuento en cualquier juego.
        + Si no eres estudiante:
          * Membresía Silver: 30% de descuento.
          * Membresía Gold: 60% de descuento.
          * Membresía Bronze: 80% de descuento.
    - Más de 25 años:
        + Si eres estudiante:
          - Membresía Silver: 30% de descuento.
          - Membresía Gold: 60% de descuento.
        + Si no eres estudiante:
          - Membresía Silver: 30% de descuento.
          - Membresía Gold: 60% de descuento.
            
> [!IMPORTANT] 
>* Los descuentos son acumulables, a menos que se especifique lo contrario. Por ejemplo, una mujer estudiante de 20 años podría recibir un 60% de descuento en un juego más un 10% adicional por ser mujer.
>* Para cualquier duda sobre la aplicación de los descuentos, consulta con nuestro personal de atención al cliente.

  
**Inventario**

Contiene la edad mínima, existencias y precio del juego
| Juego | Edad mínima | Unidades | Precio |
|-------|-------------|----------|--------|
|GTA| 18 | 10 | $120,000|
|FIFA| 10| 1 | $180,000|
|Minecraft| 0| 10 | $50,000|
|Resident| 10 | 0 | $110,000|



***Ingreso como Vendedor***


Esta opción permitirá al usuario ingresar al sistema como vendedor. Debe solicitar un nombre de usuario y una contraseña. El sistema verificará si las credenciales son correctas y permitirá el acceso al menú principal del vendedor. La contraseña es: BARBIE.

Si se ingresan 3 veces la clave incorrecta, el sistema se bloquea.


**Funciones del Vendedor**
1. Consultar Juego (1.1):
El vendedor puede buscar un juego en la base de datos de la tienda. Debe ingresar el nombre del juego y el sistema mostrará la información relacionada, como el precio y la disponibilidad en inventario.
2. Realizar Venta (1.2):
Esta opción permitirá al vendedor registrar una venta. Debe ingresar la cédula del cliente, el juego vendido y la cantidad. El sistema actualizará el inventario y generará una factura con un ID único.
Si el cliente no existe, se debe crear un nuevo registro. Si ya existe, se utilizará su información.
3. Generar Factura (1.3):
Permite al vendedor generar una factura por ID para una venta específica. Debe ingresar el número de factura y el sistema mostrará los detalles de la venta, como el nombre del cliente, los juegos comprados y el total a pagar.
4. Cargar/Actualizar Juego (1.4):
Permite cargar un nuevo juego al inventario o actualizar un juego existente. El vendedor deberá especificar si se trata de un nuevo registro o una actualización.
5. Cargar Cliente (1.5):
Registra un nuevo cliente en el sistema. Al cargar el cliente, se le preguntará si desea adquirir una membresía. Se explicarán los beneficios de cada membresía en el momento de la carga.
6. Consultar Cliente (1.6):
Permite consultar por nombre o cédula. Si se consulta por cédula, se devuelve un cliente exacto; si se consulta por nombre, se mostrarán todos los clientes que contengan ese nombre, junto con su cédula.
7. Volver Atrás (1.7):
Permite al vendedor salir del sistema de ventas. Para volver a ingresar, debe introducir la contraseña.
