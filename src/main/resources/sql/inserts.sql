-- Insertando estados de torneos
INSERT INTO TournamentStates (Name, Description)
VALUES ('En Registro', 'El torneo está en fase de inscripción'),
       ('En Curso', 'El torneo está en progreso'),
       ('Finalizado', 'El torneo ha concluido');

-- Insertando torneos
INSERT INTO Tournaments (TournamentStateId, Name, Description, MaxParticipantQuantity, MinParticipantQuantity,
                         StartDate, EndDate)
VALUES (2, 'Torneo Regional', 'Competencia a nivel regional', 16, 16, '2025-06-01', '2025-06-15'),
       (1, 'Torneo Nacional', 'Competencia a nivel nacional', 16, 16, '2025-07-01', '2025-07-20'),
       (1, 'Torneo Universitario', 'Competencia entre universidades', 16, 16, '2025-05-05', '2025-05-25'),
       (1, 'Copa Anual', 'Competencia que se realiza cada año', 16, 16, '2025-11-01', '2025-11-20');


-- Insertando fases
INSERT INTO Phases (TournamentId, Name, Description, ConsecutiveNumberWithinTournament, StartDate, EndDate)
VALUES (1, 'Octavos de Final', 'Primera ronda eliminatoria', 1, '2025-06-01', '2025-06-03'),
       (1, 'Cuartos de Final', 'Segunda ronda eliminatoria', 2, '2025-06-04', '2025-06-06'),
       (1, 'Semifinal', 'Tercera ronda eliminatoria', 3, '2025-06-07', '2025-06-09'),
       (1, 'Final', 'Ronda final del torneo', 4, '2025-06-10', '2025-06-15');

INSERT INTO Team (teamid) VALUES
                              ('1lheKJXBVs9Qz3NYBQxn'),
                              ('2mduPLZTAs8Ry7MVCRyp'),
                              ('3nxvWQYHCt5Jk6BZAFzo'),
                              ('4pjrMKXBLs2Vq9NYDQwm'),
                              ('5tbwPYZJHC7Kx3LVARno'),
                              ('6lveWQXBVs8Jm2NYCRyz'),
                              ('7kdjMKZTAs5Vq6BZAFxp'),
                              ('8tnwPYHCJX9Kx3LVBRyo'),
                              ('9lhrWQZJVs7Jm6NYCAPx'),
                              ('10mduPKXBLs2Ry7MVQYn'),
                              ('11nxvWQZJHC5Kx3LVARYo'),
                              ('12pjrMKXBTs8Vq9NYDCwm'),
                              ('13tbwPYZJHC7Kx3LVBRyn'),
                              ('14lveWQXJVs9Jm2NYCAPz'),
                              ('15kdjMKZTAs5Vq6BZAFyx'),
                              ('16tnwPYHCJX8Kx3LVBRzp');


-- Insertando entrenadores
INSERT INTO Trainers (TeamId, Name)
VALUES ('1lheKJXBVs9Qz3NYBQxn', 'Ash Ketchum'),
       ('2mduPLZTAs8Ry7MVCRyp', 'Misty Waterflower'),
       ('3nxvWQYHCt5Jk6BZAFzo', 'Brock Harrison'),
       ('4pjrMKXBLs2Vq9NYDQwm', 'Gary Oak'),
       ('5tbwPYZJHC7Kx3LVARno', 'Serena'),
       ('6lveWQXBVs8Jm2NYCRyz', 'Dawn Berlitz'),
       ('7kdjMKZTAs5Vq6BZAFxp', 'May Maple'),
       ('8tnwPYHCJX9Kx3LVBRyo', 'Cynthia'),
       ('9lhrWQZJVs7Jm6NYCAPx', 'Lance'),
       ('10mduPKXBLs2Ry7MVQYn', 'Steven Stone'),
       ('11nxvWQZJHC5Kx3LVARYo', 'Wallace'),
       ('12pjrMKXBTs8Vq9NYDCwm', 'Raihan'),
       ('13tbwPYZJHC7Kx3LVBRyn', 'Leon'),
       ('14lveWQXJVs9Jm2NYCAPz', 'Red'),
       ('15kdjMKZTAs5Vq6BZAFyx', 'Blue'),
       ('16tnwPYHCJX8Kx3LVBRzp', 'Ethan');


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


