# Tournaments-DevOps
Backend del primer proyecto correspondiente a la asignatura de DevOps. En este caso, se desarolla el módulo de Torneos, que muestra la evolución de las llaves de enfrentamiento hasta la final del torneo, permite a los entrenadores seguir los resultados de las batallas en tiempo real, permite el registro de un entrenador a un torneo y permite la visualización del estado de los torneos.

## Tecnologías utilizadas:
- **Spring Boot** - Framework principal del backend.
- **Hibernate** - Implementación de JPA para el manejo de la base de datos.
- **Lombok** - Reducción de código repetitivo en las entidades por medio de anotaciones.
- **JPA** - API para la gestión de datos.
- **Docker** -Contenerización de la aplicación y de la base de datos.


## Requisitos previos
Antes de ejecutar la aplicación, asegúrate de tener instalado:

- **Java 17**
- **Docker Desktop(Windows)**

## Endpoints de la aplicación
- **Principales servicios que provee el modulo de tornos**
    - `GET /api/tournament` - Obtener lista de torneos.
    - `GET /api/tournament/{id}` -Obtener torneo por su identificador.
    - `GET /api/phase"/tournament/{id}` -Obtener la fase de un torneo por su identificador.
    - `GET /api/tournament/register/participants/{id}` -Obtener lista de los entrenadores registrados en un torneo.
    - `GET /api/tournament/matches/{id}` -Obtener enfrentamientos de un torneo.
    - `POST /api/tournament` -Agregar torneo.
    - `POST /api/tournament/matches/{id}` -Generar los enfrentamientos de un torneo por su identificador.
    - `POST /api/tournament/register/{id}` -Registrar un entrenador a un torneo.
    - `PUT /api/tournament/{id}` -Actualizar un torneo por su identificador.
    - `DELETE /api/tournament/{id}` -Eliminar torneo por su identificador.
    








    
