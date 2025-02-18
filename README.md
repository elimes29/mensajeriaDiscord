# 📩 Mensajería - API REST con Java Spring Boot

Bienvenido/a a **Mensajería**, una aplicación desarrollada en **Java Spring Boot** que permite gestionar mensajes de manera eficiente. La API implementa operaciones CRUD (Crear, Leer, Eliminar) y cuenta con una tarea programada que verifica periódicamente los mensajes almacenados.

## 📖 Índice

- [📝 Descripción del Proyecto](#-descripción-del-proyecto)
- [🎯 Funcionalidades](#-funcionalidades)
- [🛠️ Tecnologías Utilizadas](#️-tecnologías-utilizadas)
- [📦 Instalación y Configuración](#-instalación-y-configuración)
- [📑 Documentación de la API](#-documentación-de-la-api)
- [🧪 Pruebas](#-pruebas)
- [🤝 Contribuciones](#-contribuciones)
- [📬 Contacto](#-contacto)

---

## 📝 Descripción del Proyecto

**Mensajería** es una API REST que permite almacenar, consultar y eliminar mensajes en una base de datos. Además, cuenta con un servicio automatizado que revisa cada minuto si existen nuevos mensajes y los muestra en consola.

Esta aplicación incluye:
- **Persistencia de datos** en **MySQL**, utilizando **Spring Data JPA**.
- **Migraciones de base de datos** con **Flyway**.
- **Tareas programadas** con **Spring Scheduling**.
- **Validaciones de entrada** con **Spring Validation**.
- **Paginación** para optimizar consultas.
- **Documentación OpenAPI** con **Springdoc**.
- **Pruebas unitarias** con **JUnit 5 y Mockito**.

---

## 🎯 Funcionalidades

- **📤 CRUD de Mensajes**:
  - **Crear un mensaje** con fecha y contenido.
  - **Listar todos los mensajes** con paginación.
  - **Eliminar un mensaje** de la base de datos.

- **⏳ Tareas Programadas**:
  - Cada minuto revisa si existen nuevos mensajes creados en el último minuto y los muestra en consola.

- **📋 Validaciones**:
  - Verificación de campos obligatorios en las solicitudes.

- **📦 Persistencia de Datos**:
  - Uso de **Spring Data JPA** con **MySQL** y migraciones automáticas con **Flyway**.

- **🧪 Pruebas Unitarias**:
  - Se han implementado pruebas para garantizar la correcta funcionalidad de los servicios y controladores.

---

## 🛠️ Tecnologías Utilizadas

- **Java** - versión 17
- **Spring Boot** - versión 3.4.2
- **Spring Data JPA** - para operaciones de persistencia
- **MySQL** - base de datos relacional
- **Flyway** - para gestión de migraciones
- **Spring Scheduling** - para tareas automatizadas
- **Spring Validation** - para validaciones de entrada
- **Springdoc OpenAPI** - para generación de documentación interactiva
- **Lombok** - para reducir el código boilerplate
- **Maven** - para gestión de dependencias y compilación
- **JUnit 5 y Mockito** - para pruebas unitarias

---

## 📦 Instalación y Configuración

- ** Clona el repositorio:

```bash
git clone (https://github.com/elimes29/mensajeriadiscord)
cd mensajeria
```

- ** Configura la base de datos:

Asegúrate de tener MySQL instalado y crea una base de datos para el proyecto. Luego, configura las credenciales en application.properties:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/mensajeriaDB
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuración de Flyway para migraciones
spring.flyway.enabled=true
spring.flyway.baseline-on-migrate=true
```

- **Ejecuta el proyecto:

Compila y ejecuta la aplicación con Maven:

```bash
./mvnw spring-boot:run
```

## 📑 Documentación de la API
La documentación de la API REST está disponible a través de Swagger/OpenAPI en:

📌 Swagger UI: http://localhost:8080/swagger-ui/index.html

En esta interfaz interactiva podrás explorar y probar los endpoints de la API.

## 🖥️ Uso de la Aplicación

📄 Rutas Disponibles
POST /mensajes - Crear un nuevo mensaje.
GET /mensajes - Listar mensajes con paginación.
DELETE /mensajes/{id} - Eliminar un mensaje por ID.

🌐 Ejemplo de Petición
Crear un mensaje:
```bash
curl -X POST -H "Content-Type: application/json" -d '{
  "mensaje": "Hola, este es un mensaje programado",
  "fecha": "2024-02-17T10:30:00"
}' http://localhost:8080/mensajes
```

## 🧪 Pruebas
Se han implementado pruebas unitarias utilizando JUnit 5 y Mockito para validar la lógica de negocio y los controladores de la API.

Para ejecutar las pruebas:
```bash
./mvnw test
```

✅ Pruebas Implementadas
- ** Pruebas de Servicio (MensajeServicioTest)
- deberiaImprimirMensajesSiHayRecientes()
Verifica que el servicio imprime mensajes si hay mensajes creados en el último minuto.
- deberiaImprimirSinNovedadSiNoHayMensajesRecientes()
Verifica que el servicio no imprime nada si no hay mensajes recientes.
- ** Pruebas de Controlador (MensajeControllerTest)
- deberiaGuardarMensajeCorrectamente()
Valida que se pueda guardar un mensaje correctamente y que devuelva un código 201 (Created).
- deberiaEliminarMensajeExistente()
Verifica que se pueda eliminar un mensaje existente y que devuelva un código 200 (OK).
- deberiaRetornar404SiMensajeNoExiste()
- Verifica que al intentar eliminar un mensaje inexistente se devuelva un código 404 (Not Found).

Estas pruebas aseguran que la API funcione correctamente y detectan posibles errores en la lógica del negocio.

## 🤝 Contribuciones
¡Tu colaboración es bienvenida! Para contribuir, sigue estos pasos:

- 1️⃣ Haz un fork del repositorio.
- 2️⃣ Crea una nueva rama con tu mejora:

```bash
git checkout -b feature/mi-mejora
```

- 3️⃣ Realiza tus cambios y haz un commit:
```bash
git commit -m "Agregada nueva funcionalidad"
```

4️⃣ Envía tus cambios:
```bash
git push origin feature/mi-mejora
```

- 5️⃣ Crea un Pull Request describiendo los cambios.

 ## 📬 Contacto
Si tienes preguntas o sugerencias, puedes contactarme en:
- GitHub: [https://github.com/elimes29]
- LinkedIn: [https://www.linkedin.com/in/elimes-rodriguez]

- ¡Gracias por visitar el proyecto!
