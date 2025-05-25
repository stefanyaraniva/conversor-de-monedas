Conversor de Monedas 
Esta aplicación permite hacer la conversión entre distintas monedas ejecutando el siguiente cálculo:
(Moneda origen * Cantidad a convertir * Tasa de cambio) / Moneda destino.

Funcionalidad:

Se ha diseñado un menú con 6 opciones de cambio de monedas y una opción para salir del sistema. También tiene una opción por defecto para solicitar al usuario que ingrese una opción válida cuando este digite un número distinto a los disponibles en el menú.
Menú de opciones mostrado al usuario: 1. Dolar americano a peso argentino. 2. Peso argentino a dolar americano. 3. Dolar americano a real brasileño. 4. Real brasileño a dolar americano. 5. Dolar americano a peso colombiano. 6. Peso colombiano a dolar americano. 7. Salir del sistema.

Ejecución:

El debe usuario digitar la opción deseada según las que muestra el menú.
El usuario debe ingresar la cantidad que desea convertir.
La aplicación realiza la búsqueda de la tasa de conversión de la moneda de origen a la moneda de destino en la API ExchangeRate y hace el cálculo indicado anteriormente.
La aplicación indica al usuario el resultado del cálculo y le muestra nuevamente el menú de opciones por si desea realizar otro cálculo.
El usuario debe ingresar los parámetros para la siguiente búsqueda o simplemente seleccionar la opción 7 para salir del sistema.
Tecnologías utilizadas:

Java
API de ExchangeRate
Biblioteca Gson 2.13.1
IDE IntelliJ
Trello
