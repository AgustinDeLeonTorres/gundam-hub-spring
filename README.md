📝 README

# Gundam Hub - Spring Boot API

API REST para gestión de universos, series y episodios de Gundam construida con Spring Boot y Clean Architecture.

## 🚀 Endpoints Disponibles

### API Principal
- **🌌 Universos:** `http://localhost:8080/api/universes`
- **📺 Series:** `http://localhost:8080/api/series`  
- **🎬 Episodios:** `http://localhost:8080/api/episodes`
- **❤️ Health Check:** `http://localhost:8080/api/health`

### Base de Datos H2 (Consola)
- **URL Consola:** `http://localhost:8080/h2-console`
- **JDBC URL:** `jdbc:h2:mem:gundamdb`
- **Usuario:** `sa`
- **Contraseña:** `password`

## ⚙️ Requisitos Previos

- **Java 17** o superior
- **Maven** (incluido en el proyecto via Maven Wrapper)
- Puerto **8080** disponible

## 🛠️ Instalación y Ejecución

### 1. Clonar y posicionarse en carpeta correcta

git clone https://github.com/AgustinDeLeonTorres/gundam-hub-spring.git
cd gundam-hub-spring/gundam-hub-spring
2. Verificar que estás en la carpeta correcta
Debes ver estos archivos:

mvnw y mvnw.cmd

pom.xml

Carpeta src/

3. Ejecutar la aplicación

# Windows
.\mvnw.cmd clean spring-boot:run

# Linux/Mac
./mvnw clean spring-boot:run

### 4. Verificar que funciona

La terminal debe mostrar: Tomcat started on port 8080

Abrir: http://localhost:8080/api/universes

🗄️ Base de Datos

Tipo: H2 en memoria

Datos: Se cargan automáticamente desde src/main/resources/data.sql

Contiene: Universos, series y episodios de muestra

📋 Métodos HTTP Disponibles

Para cada recurso (universes, series, episodes):
GET /api/{recurso} - Obtener todos

GET /api/{recurso}/{id} - Obtener por ID

POST /api/{recurso} - Crear nuevo

DELETE /api/{recurso}/{id} - Eliminar

🐛 Solución de Problemas Comunes

Error: "No se reconoce mvnw"
Usar .\mvnw.cmd en lugar de ./mvnw

Verificar que estás en la carpeta con mvnw.cmd

Error: "Puerto 8080 en uso"

# Encontrar proceso
netstat -ano | findstr :8080

# Ejecutar en puerto diferente agregando al application.yml:
server.port=8081
Error: "Whitelabel Error Page"
Verificar que el endpoint sea exacto: /api/universes (no /universos)

Confirmar que la aplicación inició correctamente

🏗️ Estructura del Proyecto

src/
├── main/java/com/agustindlg/gundam_hub_spring/
│   ├── domain/          # Entidades y modelos
│   ├── application/     # Casos de uso y servicios
│   └── infrastructure/  # Controladores y configuración
└── main/resources/
    ├── application.yml  # Configuración
    └── data.sql         # Datos iniciales

📝 Notas
La base de datos se reinicia cada vez que la aplicación se detiene

Los datos de prueba se cargan automáticamente al iniciar

API diseñada para ser consumida por frontend o aplicaciones móviles



