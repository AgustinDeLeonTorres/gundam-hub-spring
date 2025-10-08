📝 README

# Gundam Hub - Spring Boot API

API REST para gestión de universos, series y episodios de Gundam construida con Spring Boot y Clean Architecture.

## 🌐 Endpoints Completos

### 📺 SERIES

# Todas las series
http://localhost:8080/api/series

# Serie por ID
http://localhost:8080/api/series/1
http://localhost:8080/api/series/5
http://localhost:8080/api/series/25

# Series por universo
http://localhost:8080/api/series/universe/1  # Universal Century
http://localhost:8080/api/series/universe/2  # Alternate Universe

# Series por era
http://localhost:8080/api/series/era/1       # Pre-Guerra UC
http://localhost:8080/api/series/era/2       # Guerra de Un Año
http://localhost:8080/api/series/era/13      # Cosmic Era (SEED)
http://localhost:8080/api/series/era/18      # Build Series

🌌 UNIVERSOS

# Todos los universos
http://localhost:8080/api/universes

# Universo por ID
http://localhost:8080/api/universes/1
http://localhost:8080/api/universes/2

⏳ ERAS

# Todas las eras
http://localhost:8080/api/eras

# Era por ID
http://localhost:8080/api/eras/1
http://localhost:8080/api/eras/13
http://localhost:8080/api/eras/18

# Eras por universo
http://localhost:8080/api/eras/universe/1    # Eras UC
http://localhost:8080/api/eras/universe/2    # Eras AU

🎬 EPISODIOS

# Todos los episodios
http://localhost:8080/api/episodes

# Episodio por ID
http://localhost:8080/api/episodes/1

# Episodios por serie
http://localhost:8080/api/episodes/series/1

🔧 HERRAMIENTAS DE DESARROLLO

# Consola H2 Database
http://localhost:8080/h2-console

# JDBC URL: jdbc:h2:mem:gundamdb
# User: sa
# Password: password

# Health Check
http://localhost:8080/actuator/health

🎯 Endpoints Clave para Verificación
PRUEBA BÁSICA:

# 1. Series principales UC
http://localhost:8080/api/series/1    # Gundam: The Origin
http://localhost:8080/api/series/5    # Gundam 0079 (original)
http://localhost:8080/api/series/15   # Zeta Gundam

# 2. Series principales AU  
http://localhost:8080/api/series/25   # G Gundam
http://localhost:8080/api/series/27   # Gundam Wing
http://localhost:8080/api/series/33   # Gundam SEED
http://localhost:8080/api/series/43   # Witch from Mercury

# 3. Agrupaciones por universo
http://localhost:8080/api/series/universe/1  # Todas series UC
http://localhost:8080/api/series/universe/2  # Todas series AU

# 4. Agrupaciones por era
http://localhost:8080/api/series/era/2       # Series Guerra Un Año
http://localhost:8080/api/series/era/13      # Series Cosmic Era (SEED)
http://localhost:8080/api/series/era/18      # Series Build
VERIFICACIÓN DE RELACIONES:

# Ver que las relaciones cargan correctamente
http://localhost:8080/api/series/1    # Debe mostrar universe y era
http://localhost:8080/api/universes/1 # Debe cargar sin errores
http://localhost:8080/api/eras/1      # Debe cargar sin errores


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



