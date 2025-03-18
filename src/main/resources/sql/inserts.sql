-- Insertando estados de torneos
INSERT INTO TournamentStates (Name, Description)
VALUES ('En Registro', 'El torneo está en fase de inscripción'),
       ('En Curso', 'El torneo está en progreso'),
       ('Finalizado', 'El torneo ha concluido');

-- Insertando torneos
INSERT INTO Tournaments (TournamentStateId, Name, Description, MaxParticipantQuantity, MinParticipantQuantity,
                         StartDate, EndDate)
VALUES (3, 'Torneo Nacional', 'Competencia a nivel nacional', 16, 16, '2025-07-01', '2025-07-20');

-- Insertando fases
INSERT INTO Phases (TournamentId, Name, Description, ConsecutiveNumberWithinTournament, StartDate, EndDate)
VALUES (1, 'Octavos de Final', 'Primera ronda eliminatoria', 1, '2025-06-01', '2025-06-03'),
       (1, 'Cuartos de Final', 'Segunda ronda eliminatoria', 2, '2025-06-04', '2025-06-06'),
       (1, 'Semifinal', 'Tercera ronda eliminatoria', 3, '2025-06-07', '2025-06-09'),
       (1, 'Final', 'Ronda final del torneo', 4, '2025-06-10', '2025-06-15');
-- Insertando equipos
INSERT INTO Teams DEFAULT
VALUES;
INSERT INTO Teams DEFAULT
VALUES;
INSERT INTO Teams DEFAULT
VALUES;
INSERT INTO Teams DEFAULT
VALUES;
INSERT INTO Teams DEFAULT
VALUES;
INSERT INTO Teams DEFAULT
VALUES;
INSERT INTO Teams DEFAULT
VALUES;
INSERT INTO Teams DEFAULT
VALUES;
INSERT INTO Teams DEFAULT
VALUES;
INSERT INTO Teams DEFAULT
VALUES;
INSERT INTO Teams DEFAULT
VALUES;
INSERT INTO Teams DEFAULT
VALUES;
INSERT INTO Teams DEFAULT
VALUES;
INSERT INTO Teams DEFAULT
VALUES;


-- Insertando entrenadores
INSERT INTO Trainers (TeamId, Name)
VALUES (5, 'Serena'),
       (6, 'Dawn Berlitz'),
       (7, 'May Maple'),
       (8, 'Cynthia'),
       (9, 'Lance'),
       (10, 'Steven Stone'),
       (11, 'Wallace'),
       (12, 'Raihan'),
       (13, 'Leon'),
       (14, 'Red'),
       (15, 'Blue'),
       (16, 'Ethan');

INSERT INTO PokemonTypes (Name, Description)
VALUES ('Eléctrico', 'Pokémon de tipo eléctrico'),
       ('Fuego', 'Pokémon de tipo fuego'),
       ('Agua', 'Pokémon de tipo agua'),
       ('Psíquico', 'Pokémon de tipo psíquico');


INSERT INTO Pokemons (Name, PokemonTypeId, Level)
VALUES ('Pikachu', 1, 35),
       ('Charizard', 2, 50),
       ('Starmie', 3, 42),
       ('Psyduck', 3, 30);

-- Insertando Pokémon en equipos
INSERT INTO TeamPokemons (TeamId, PokemonId)
VALUES (1, 5), -- Pikachu en el equipo 1
       (1, 5), -- Charizard en el equipo 1
       (2, 7), -- Starmie en el equipo 2
       (2, 7);
-- Psyduck en el equipo 2

-- Inscripción de entrenadores en torneos
INSERT INTO TournamentRegistrations (TournamentId, TrainerId)
VALUES (1, 3),
       (1, 4);
-- Misty en Torneo Regional

-- Insertando batallas
INSERT INTO Battles (PhaseId, FirstParticipantId, SecondParticipantId, WinnerId, BattleDuration)
VALUES (1, 1, 2, 1, '00:15:30'), -- Ash vs Misty, gana Ash
       (2, 2, 1, 2, '00:12:45'); -- Misty vs Ash, gana Misty
