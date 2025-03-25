# Tournaments-DevOps

Backend del primer proyecto correspondiente a la asignatura de DevOps. Este módulo de Torneos permite:

- Visualizar la evolución de las llaves de enfrentamiento hasta la final del torneo.
- Seguir los resultados de las batallas en tiempo real.
- Registrar entrenadores en un torneo.
- Consultar el estado de los torneos.

## Tecnologías Utilizadas

- **Spring Boot** - Framework principal del backend.
- **Hibernate** - Implementación de JPA para la gestión de la base de datos.
- **Lombok** - Reducción de código repetitivo mediante anotaciones.
- **JPA** - API para la manipulación de datos.
- **Docker** - Contenerización de la aplicación y de la base de datos.

## Requisitos Previos

Antes de ejecutar la aplicación, asegúrate de tener instalado:

- **Java 17**
- **Docker Desktop (Windows)**

## Endpoints de la Aplicación

A continuación, se describen los principales servicios del módulo de torneos:

### `GET /api/tournament` - Obtener lista de torneos

**Ejemplo de Respuesta (200 OK)**

```json
[
  {
    "id": 1,
    "tournamentState": "Finalizado",
    "name": "Torneo Nacional",
    "description": "Competencia a nivel nacional",
    "maxParticipantQuantity": 16,
    "minParticipantQuantity": 16,
    "startDate": "2025-07-01",
    "endDate": "2025-07-20"
  },
  {
    "id": 2,
    "tournamentState": "En Registro",
    "name": "Torneo Nacional Dos",
    "description": "Competencia a nivel nacional",
    "maxParticipantQuantity": 16,
    "minParticipantQuantity": 16,
    "startDate": "2025-07-01",
    "endDate": "2025-10-20"
  }
]
```

---

### `GET /api/tournament/{id}` - Obtener torneo por su identificador

**Ejemplo de Respuesta (200 OK)**

```json
{
  "id": 1,
  "tournamentState": "Finalizado",
  "name": "Torneo Nacional",
  "description": "Competencia a nivel nacional",
  "maxParticipantQuantity": 16,
  "minParticipantQuantity": 16,
  "startDate": "2025-07-01",
  "endDate": "2025-07-20"
}
```

### `GET /api/phase/tournament/{id}` - Obtener la fase de un torneo por su identificador

**Ejemplo de Respuesta (200 OK)**

```json
{
  "id": 1,
  "tournamentState": "Finalizado",
  "name": "Torneo Nacional",
  "description": "Competencia a nivel nacional",
  "maxParticipantQuantity": 16,
  "minParticipantQuantity": 16,
  "startDate": "2025-07-01",
  "endDate": "2025-07-20"
}
```

---

### `GET /api/tournament/register/participants/{id}` - Obtener lista de entrenadores registrados en un torneo.

**Ejemplo de Respuesta (200 OK)**

```json
[
    {
        "id": 25,
        "team": 5,
        "name": "Serena"
    },
    {
        "id": 26,
        "team": 6,
        "name": "Dawn Berlitz"
    }
]
```

---
## `GET /api/tournament/matches/{id}` - Obtener enfrentamientos de un torneo.

**Ejemplo de Respuesta (200 OK)**

```json

[
    {
        "id": 1,
        "phase": 13,
        "firstParticipant": 10,
        "secondParticipant": 4,
        "winner": null,
        "battleDuration": null
    },
    {
        "id": 2,
        "phase": 13,
        "firstParticipant": 16,
        "secondParticipant": 1,
        "winner": null,
        "battleDuration": null
    },
    {
        "id": 3,
        "phase": 13,
        "firstParticipant": 3,
        "secondParticipant": 6,
        "winner": null,
        "battleDuration": null
    },
    {
        "id": 4,
        "phase": 13,
        "firstParticipant": 5,
        "secondParticipant": 9,
        "winner": null,
        "battleDuration": null
    },
    {
        "id": 5,
        "phase": 13,
        "firstParticipant": 12,
        "secondParticipant": 13,
        "winner": null,
        "battleDuration": null
    },
    {
        "id": 6,
        "phase": 13,
        "firstParticipant": 11,
        "secondParticipant": 2,
        "winner": null,
        "battleDuration": null
    },
    {
        "id": 7,
        "phase": 13,
        "firstParticipant": 8,
        "secondParticipant": 7,
        "winner": null,
        "battleDuration": null
    },
    {
        "id": 8,
        "phase": 13,
        "firstParticipant": 14,
        "secondParticipant": 15,
        "winner": null,
        "battleDuration": null
    }
]
```

---

## `POST /api/tournament` - Agregar un nuevo torneo.

**Ejemplo cuerpo de la petición**

```json
{
        "tournamentState": "En Registro",
        "name": "NINTENDO Pokemon",
        "description": "test",
        "maxParticipantQuantity": 8,
        "minParticipantQuantity": 8,
        "startDate": "2025-03-20",
        "endDate": "2025-03-21"
}
```

---
**Ejemplo de Respuesta (200 OK)**

```json
[
    {
        "id": 1,
        "tournamentState": "Finalizado",
        "name": "Torneo Nacional",
        "description": "Competencia a nivel nacional",
        "maxParticipantQuantity": 16,
        "minParticipantQuantity": 16,
        "startDate": "2025-07-01",
        "endDate": "2025-07-20"
    },
    {
        "id": 2,
        "tournamentState": "En Registro",
        "name": "Torneo Nacional Dos",
        "description": "Competencia a nivel nacional",
        "maxParticipantQuantity": 16,
        "minParticipantQuantity": 16,
        "startDate": "2025-07-01",
        "endDate": "2025-10-20"
    }
]
```
Se puede observar que da como respuesta una lista de los torneos que están en la base de datos.


---

## `POST /api/tournament/matches/{tournamentId}` - Generar enfrentamientos para un torneo específico.

**Ejemplo de Respuesta (200 OK)**

```json

[
    {
        "id": null,
        "phase": 13,
        "firstParticipant": 10,
        "secondParticipant": 4,
        "winner": null,
        "battleDuration": null
    },
    {
        "id": null,
        "phase": 13,
        "firstParticipant": 16,
        "secondParticipant": 1,
        "winner": null,
        "battleDuration": null
    },
    {
        "id": null,
        "phase": 13,
        "firstParticipant": 3,
        "secondParticipant": 6,
        "winner": null,
        "battleDuration": null
    },
    {
        "id": null,
        "phase": 13,
        "firstParticipant": 5,
        "secondParticipant": 9,
        "winner": null,
        "battleDuration": null
    },
    {
        "id": null,
        "phase": 13,
        "firstParticipant": 12,
        "secondParticipant": 13,
        "winner": null,
        "battleDuration": null
    },
    {
        "id": null,
        "phase": 13,
        "firstParticipant": 11,
        "secondParticipant": 2,
        "winner": null,
        "battleDuration": null
    },
    {
        "id": null,
        "phase": 13,
        "firstParticipant": 8,
        "secondParticipant": 7,
        "winner": null,
        "battleDuration": null
    },
    {
        "id": null,
        "phase": 13,
        "firstParticipant": 14,
        "secondParticipant": 15,
        "winner": null,
        "battleDuration": null
    }
]
```
---

## `POST /api/tournament/register/{id}` - Registrar un entrenador en un torneo.

**Ejemplo de cuerpo del Request**

```json
{
    "trainerId":66
}
```
---

**Response (200 OK)**
Trainer registered successfully

---

## `PUT /api/tournament/{id}` - Actualizar un torneo existente.

**Ejemplo de cuerpo del Request**

```json
{
    "tournamentState": "En Registro",
    "name": "PokeDevOps",
    "description": "test",
    "maxParticipantQuantity": 8,
    "minParticipantQuantity": 8,
    "startDate": "2025-03-30",
    "endDate": "2025-03-21"
}
```
---

**Ejemplo de Respuesta (200 OK)**

```json
{
    "id": 3,
    "tournamentState": "En Registro",
    "name": "PokeDevOps",
    "description": "test",
    "maxParticipantQuantity": 8,
    "minParticipantQuantity": 8,
    "startDate": "2025-03-30",
    "endDate": "2025-03-21"
}
```

---

## `DELETE /api/tournament/{id}` - Eliminar un torneo por su identificador.


---

## `PUT /api/tournament/matches/{matchId}` - Editar una batalla por su id.

**Ejemplo de cuerpo del Request**

```json

{
    "id": 13,
    "phase": 1,
    "firstParticipant": 8,
    "secondParticipant": 11,
    "winner": 8,
    "battleDuration": "00:14:20"
}
```

---
