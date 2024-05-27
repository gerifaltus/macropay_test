### MACROPAY TEST 

#### 1.- Procedimiento de instalación, ejecución y pruebas de la aplicación

#### 2.- Instrucciones para instalar y ejecutar la aplicación:
- Instalar Java 17 jdk.
- Instalar algún IDE para revisar el código (STS/Intell Idea).
- Instalar Docker Desktop mínimo la versión 4.27.

#### 3.- Clonar repositorio
- Clonar  el repositorio con **git clone https://github.com/gerifaltus/macropay_test**.

#### 4.- Entrar a la carpeta "bd"
1. Ejecutar los siguientes comandos:
2. docker network create net_macropay
3. docker build -t i_bd_macropay . 
4. docker run -d --network net_macropay --name bd_macropay i_bd_macropay

#### 5.- Salir de la carpeta "bd" y entrar a la carpeta "test-macropay-ms-app"
1. Ejecutar los siguientes comando en el siguiente orden:
2. docker build -t i_api_macropay .
3. docker run -d --network net_macropay --name api_macropay -p 8080:8080 -e host=bd_macropay i_api_macropay

#### 6.- Importar el archivo json a postman y realizar las siguientes pruebas. El archivo para postman tiene por nombre: MacroPay.postman_collection.json y se encuentra dentro del mismo repositorio de github:
1. Consultar los adeudos: **getPagos (POST)**. Deberá aparecer 4 items por lista (pagos y cuentas)
2. Realizar un pago: **updatePagos (PUT)**. El endpoint devuelve un 200 y se deberá volver a consultar el endpoint del punto 1, entonces la aplicación solo devolverá 3 items por lista (pagos y cuentas) por que un pago ya fue actualizado de Pendiente a Pagado.
3. Obtener el menu: **getMenu (GET)**. El endopoint devolverá un array vacio.
4. Guardar el menu: **saveMenu (GET)**. La aplicación guardar el menu en la tabla menu desde el archivo menu.json. Se deberá volver a consultar el endpoint del punto 3 y se deberá mostrar el árbol del menu en formato json.