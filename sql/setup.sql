DROP TABLE IF EXISTS UserProfile;
DROP TABLE IF EXISTS Users;

--tabelle 
CREATE TABLE Users (
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
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);