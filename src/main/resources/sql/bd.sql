CREATE TABLE TournamentStates (
                                  TournamentStateId SERIAL PRIMARY KEY,
                                  Name VARCHAR(100) UNIQUE NOT NULL,
                                  Description VARCHAR(500) NULL
);

CREATE TABLE Tournaments (
                             TournamentId SERIAL PRIMARY KEY,
                             TournamentStateId INT NOT NULL,
                             Name VARCHAR(100) NOT NULL,
                             Description VARCHAR(500) NULL,
                             MaxParticipantQuantity INT NOT NULL,
                             MinParticipantQuantity INT NOT NULL,
                             StartDate DATE NOT NULL,
                             EndDate DATE NOT NULL,
                             FOREIGN KEY (TournamentStateId) REFERENCES TournamentStates (TournamentStateId),
                             CONSTRAINT DateCoherence CHECK (StartDate <= EndDate),
                             CONSTRAINT ParticipantQuantityCoherence CHECK (MaxParticipantQuantity >= MinParticipantQuantity),
                             CONSTRAINT MaxParticipantQuantityCoherence CHECK (MaxParticipantQuantity > 0),
                             CONSTRAINT MinParticipantQuantityCoherence CHECK (MinParticipantQuantity > 0)
);

CREATE TABLE Phases (
                        PhaseId SERIAL PRIMARY KEY,
                        TournamentId INT NOT NULL,
                        Name VARCHAR(100) NOT NULL,
                        Description VARCHAR(500) NULL,
                        ConsecutiveNumberWithinTournament INT NOT NULL,
                        StartDate DATE NOT NULL,
                        EndDate DATE NOT NULL,
                        FOREIGN KEY (TournamentId) REFERENCES Tournaments (TournamentId),
                        CONSTRAINT DateCoherence CHECK (StartDate <= EndDate),
                        CONSTRAINT ConsecutiveNumberCoherence UNIQUE (TournamentId, ConsecutiveNumberWithinTournament)
);

CREATE TABLE Pokemons (
                          PokemonId INT PRIMARY KEY
);

CREATE TABLE Teams (
                       TeamId SERIAL PRIMARY KEY
);

CREATE TABLE TeamPokemons (
                              TeamPokemonId SERIAL PRIMARY KEY,
                              TeamId INT NOT NULL,
                              PokemonId INT NOT NULL,
                              FOREIGN KEY (TeamId) REFERENCES Teams (TeamId),
                              FOREIGN KEY (PokemonId) REFERENCES Pokemons (PokemonId)
);

CREATE TABLE Trainers (
                          TrainerId SERIAL PRIMARY KEY,
                          TeamId INT NOT NULL,
                          Name VARCHAR(250) NOT NULL,
                          FOREIGN KEY (TeamId) REFERENCES Teams (TeamId)
);

CREATE TABLE TournamentRegistrations (
                                         TournamentRegistrationId SERIAL PRIMARY KEY,
                                         TournamentId INT NOT NULL,
                                         TrainerId INT NOT NULL,
                                         FOREIGN KEY (TournamentId) REFERENCES Tournaments (TournamentId),
                                         FOREIGN KEY (TrainerId) REFERENCES Trainers (TrainerId),
                                         CONSTRAINT TrainerCoherence UNIQUE (TournamentId, TrainerId)
);

CREATE TABLE Battles (
                         BattleId SERIAL PRIMARY KEY,
                         PhaseId INT NOT NULL,
                         FirstParticipantId INT NOT NULL,
                         SecondParticipantId INT NOT NULL,
                         WinnerId INT NULL,
                         BattleDuration TIME NULL,
                         FOREIGN KEY (PhaseId) REFERENCES Phases (PhaseId),
                         FOREIGN KEY (FirstParticipantId) REFERENCES Trainers (TrainerId),
                         FOREIGN KEY (SecondParticipantId) REFERENCES Trainers (TrainerId),
                         FOREIGN KEY (WinnerId) REFERENCES Trainers (TrainerId)
);