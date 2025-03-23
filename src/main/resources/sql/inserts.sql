-- Insertando estados de torneos
INSERT INTO TournamentStates (Name, Description)
VALUES ('En Registro', 'El torneo está en fase de inscripción'),
       ('En Curso', 'El torneo está en progreso'),
       ('Finalizado', 'El torneo ha concluido');

-- Insertando torneos
INSERT INTO Tournaments (TournamentStateId, Name, Description, MaxParticipantQuantity, MinParticipantQuantity,
                         StartDate, EndDate)
VALUES (2, 'Torneo Regional', 'Competencia a nivel regional', 16, 16, '2025-06-01', '2025-06-15'),
       (1, 'Torneo Nacional', 'Competencia a nivel nacional', 16, 16, '2025-07-01', '2025-07-20');
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
INSERT INTO Teams DEFAULT
VALUES;
INSERT INTO Teams DEFAULT
VALUES;


-- Insertando entrenadores
INSERT INTO Trainers (TeamId, Name)
VALUES (1, 'Ash Ketchum'),
       (2, 'Misty Waterflower'),
       (3, 'Brock Harrison'),
       (4, 'Gary Oak'),
       (5, 'Serena'),
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


-- Inscripción de entrenadores en torneos
INSERT INTO TournamentRegistrations (TournamentId, TrainerId)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5),
       (1, 6),
       (1, 7),
       (1, 8),
       (1, 9),
       (1, 10),
       (1, 11),
       (1, 12),
       (1, 13),
       (1, 14),
       (1, 15),
       (1, 16);


-- Insertando batallas
-- Insertando batallas de la fase 1 (Octavos de Final)
-- Insertando batallas de la fase 1 (Octavos de Final)
-- Insertando batallas de la fase 1 (Octavos de Final) con los IDs correctos
INSERT INTO Battles (PhaseId, FirstParticipantId, SecondParticipantId, WinnerId, BattleDuration)
VALUES
    (1, 1, 2, 1, '00:15:30'),   -- Ash vs Misty, gana Ash
    (1, 3, 4, 3, '00:12:45'),   -- Farid vs Diomedes, gana Farid
    (1, 5, 6, 5, '00:13:20'),   -- Serena vs Dawn, gana Serena
    (1, 7, 8, 7, '00:14:10'),   -- May vs Cynthia, gana May
    (1, 9, 10, 9, '00:16:05'),  -- Lance vs Steven, gana Lance
    (1, 11, 12, 11, '00:11:50'),-- Wallace vs Raihan, gana Wallace
    (1, 13, 14, 13, '00:10:35'),-- Leon vs Red, gana Leon
    (1, 15, 16, 15, '00:09:55');-- Blue vs Ethan, gana Blue

-- Farid vs (ID 22), gana Farid

INSERT INTO Battles (PhaseId, FirstParticipantId, SecondParticipantId, WinnerId, BattleDuration)
VALUES
    (2, 1, 3, 1, '00:14:20'),   -- Ash vs Farid, gana Ash
    (2, 5, 7, 5, '00:13:50'),   -- Serena vs May, gana Serena
    (2, 9, 11, 9, '00:15:10'),  -- Lance vs Wallace, gana Lance
    (2, 13, 15, 13, '00:12:30');-- Leon vs Blue, gana Leon
