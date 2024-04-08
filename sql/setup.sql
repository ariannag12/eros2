DROP TABLE IF EXISTS UserProfile;
DROP TABLE IF EXISTS Users;
 
CREATE TABLE Users (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    Email VARCHAR(255) UNIQUE NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Username VARCHAR(255) UNIQUE NOT NULL,
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    Gender VARCHAR(50),
    BirthDate DATE
);

CREATE TABLE UserProfile (
    UserProfileID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT UNIQUE NOT NULL,
    Bio TEXT,
    Hobbies TEXT,
    Preferences TEXT,
    ProfilePicURL VARCHAR(255),
    Location VARCHAR(255),
    Height INT,
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

 