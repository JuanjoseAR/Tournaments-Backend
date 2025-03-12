CREATE TABLE EliminationFormats (
    EliminationFormatId SERIAL PRIMARY KEY,
    Name VARCHAR(100) UNIQUE NOT NULL,
    Description VARCHAR(500) NULL
);

CREATE TABLE TournamentStates (
    TournamentStateId SERIAL PRIMARY KEY,
    Name VARCHAR(100) UNIQUE NOT NULL,
    Description VARCHAR(500) NULL
);

CREATE TABLE Tournaments (
    TournamentId SERIAL PRIMARY KEY,
    TournamentStateId INT NOT NULL,
    EliminationFormatId INT NOT NULL,
    Name VARCHAR(100) NOT NULL,
    Description VARCHAR(500) NULL,
    MaxParticipantQuantity INT NOT NULL,
    MinParticipantQuantity INT NOT NULL,
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL,
    FOREIGN KEY (TournamentStateId) REFERENCES TournamentStates (TournamentStateId),
    FOREIGN KEY (EliminationFormatId) REFERENCES EliminationFormats (EliminationFormatId),
    CONSTRAINT DateCoherence CHECK (StartDate >= EndDate),
    CONSTRAINT ParticipantQuantityCoherence CHECK (MaxParticipantQuantity >= MinParticipantQuantity),
    CONSTRAINT MaxParticipantQuantityCoherence CHECK (MaxParticipantQuantity > 0),
    CONSTRAINT MinParticipantQuantityCoherence CHECK (MinParticipantQuantity > 0)
);

CREATE TABLE ConfigurationParameters (
    ConfigurationParameterId SERIAL PRIMARY KEY,
    Name VARCHAR(100) UNIQUE NOT NULL,
    DataType VARCHAR(50) NOT NULL,
    Description VARCHAR(500) NULL,
    IsMandatory BOOLEAN NOT NULL DEFAULT '0',
    IsUnique BOOLEAN NOT NULL DEFAULT '0'  
);

CREATE TABLE TournamentConfigurationParameterValues (
    TournamentConfigurationParameterValueId SERIAL PRIMARY KEY,
    TournamentId INT NOT NULL,
    ConfigurationParameterId INT NOT NULL,
    Value VARCHAR(1000) NOT NULL,
    FOREIGN KEY (TournamentId) REFERENCES TournamentStates (TournamentStateId),
    FOREIGN KEY (ConfigurationParameterId) REFERENCES ConfigurationParameters (ConfigurationParameterId),
    CONSTRAINT ConfigurationParameterCoherence UNIQUE (TournamentId, ConfigurationParameterId)
);

CREATE TABLE Phases (
    PhaseId SERIAL PRIMARY KEY,
    TournamentId INT NOT NULL,
    EliminationFormatId INT NOT NULL,
    Name VARCHAR(100) NOT NULL,
    Description VARCHAR(500) NULL,
    ConsecutiveNumberWithinTournament INT NOT NULL,
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL,
    FOREIGN KEY (TournamentId) REFERENCES Tournaments (TournamentId),
    FOREIGN KEY (EliminationFormatId) REFERENCES EliminationFormats (EliminationFormatId),
    CONSTRAINT DateCoherence CHECK (StartDate >= EndDate),
    CONSTRAINT ConsecutiveNumberCoherence UNIQUE (TournamentId, ConsecutiveNumberWithinTournament)
);

CREATE TABLE PokemonTypes (
    PokemonTypeId SERIAL PRIMARY KEY,
    Name VARCHAR(100) UNIQUE NOT NULL,
    Description VARCHAR(500) NULL
);

CREATE TABLE Pokemons (
    PokemonId SERIAL PRIMARY KEY,
    Name VARCHAR(250) NOT NULL,
    PokemonTypeId INT NOT NULL,
    Level INT NOT NULL,
    FOREIGN KEY (PokemonTypeId) REFERENCES PokemonTypes (PokemonTypeId),
    CONSTRAINT LevelCoherence CHECK (Level >= 1 AND Level <= 100)
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