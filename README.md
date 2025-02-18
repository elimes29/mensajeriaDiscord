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
git clone https://github.com/tu-usuario/mensajeria.git
cd mensajeria

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

