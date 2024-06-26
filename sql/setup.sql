DROP TABLE IF EXISTS Chat;
DROP TABLE IF EXISTS UserProfile;
DROP TABLE IF EXISTS eros.Users;

--tabelle 
CREATE TABLE eros.Users (
    UserID SERIAL PRIMARY KEY,
    Email VARCHAR(255) UNIQUE NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Username VARCHAR(255) UNIQUE NOT NULL,
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    Gender VARCHAR(50),
    BirthDate DATE
   );

CREATE TABLE UserProfile (
    UserProfileID SERIAL PRIMARY KEY,
    UserID INT UNIQUE NOT NULL,
    Bio TEXT,
    ProfilePicURL VARCHAR(255),
    Location VARCHAR(255),
    Sport BOOLEAN DEFAULT FALSE,
    Viaggiare BOOLEAN DEFAULT FALSE,
    Lettura BOOLEAN DEFAULT FALSE,
    Fumatore VARCHAR(50),  -- "Si", "No", "Indifferente", "Solo la mattina", "Solo il pomeriggio"

    FOREIGN KEY (UserID) REFERENCES eros.Users(UserID)
);

CREATE TABLE Chat (
    ChatID SERIAL PRIMARY KEY,
    Message TEXT NOT NULL,
    Timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    SenderUserID INT NOT NULL,
    ReceiverUserID INT NOT NULL,  
   
    FOREIGN KEY (SenderUserID) REFERENCES Users(UserID),
    FOREIGN KEY (ReceiverUserID) REFERENCES Users(UserID)
);

INSERT INTO eros.Users (Email, Password, Username, FirstName, LastName, Gender, BirthDate)
VALUES 
    ('mario@gmail.com', 'mario123', 'mario_r', 'Mario', 'Rossi', 'Maschio', '1990-05-15'),
    ('laura@gmail.com', 'laura456', 'laura_b', 'Laura', 'Bianchi', 'Femmina', '1993-10-20');

-- Inserire dati nella tabella UserProfile
INSERT INTO UserProfile (UserID, Bio, ProfilePicURL, Location, Sport, Viaggiare, Lettura, Fumatore)
VALUES
    (1, 'Sono Mario Rossi, un appassionato di tecnologie web.', 'https://example.com/mario.jpg', 'Roma', TRUE, FALSE, TRUE, 'No'),
    (2, 'Ciao! Sono Laura Bianchi e amo viaggiare.', 'https://example.com/laura.jpg', 'Milano', FALSE, TRUE, TRUE, 'Si');
   --Inserire dati nella tabella Chat
   
   INSERT INTO Chat (SenderUserID, ReceiverUserID, Message)
   VALUES 
    (1, 2, 'Ciao, come va?'),
    (2, 1, 'Oggi ho un gran mal di testa! E tu?');

--dati inseriti---
   