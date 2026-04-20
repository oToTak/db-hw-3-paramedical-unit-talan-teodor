CREATE DATABASE IF NOT EXISTS paramedical_db;
USE paramedical_db;

CREATE TABLE IF NOT EXISTS ambulance (
    licensePlate VARCHAR(10) PRIMARY KEY,
    vehicleModel VARCHAR(45) NOT NULL,
    fuelLevel INT NOT NULL
);

CREATE TABLE IF NOT EXISTS emergency_call (
    callID VARCHAR(10) PRIMARY KEY,
    timestamp DATETIME NOT NULL,
    severity INT NOT NULL,
    incidentLocation VARCHAR(255) NOT NULL,
    estimated_arrival_time TIME
);

CREATE TABLE IF NOT EXISTS paramedical_unit (
    unitNumber VARCHAR(10) PRIMARY KEY,
    unitStatus VARCHAR(20) NOT NULL,
    licensePlate VARCHAR(10),
    FOREIGN KEY (licensePlate) REFERENCES ambulance(licensePlate)
);

CREATE TABLE IF NOT EXISTS medical_emergency_meds (
    call_id VARCHAR(10),
    medication_name VARCHAR(100),
    dosage VARCHAR(50),
    PRIMARY KEY (call_id, medication_name),
    FOREIGN KEY (call_id) REFERENCES emergency_call(callID) ON DELETE CASCADE
);

INSERT INTO ambulance (licensePlate, vehicleModel, fuelLevel)
VALUES ('BC1234ET', 'Mercedes Sprinter', 80);

INSERT INTO paramedical_unit (unitNumber, unitStatus, licensePlate)
VALUES ('UNIT-01', 'Available', 'BC1234ET');

INSERT INTO emergency_call (callID, timestamp, severity, incidentLocation, estimated_arrival_time)
VALUES ('CALL-999', NOW(), 1, 'Lviv, Kozelnytska 2a', '13:30:00');

INSERT INTO medical_emergency_meds (call_id, medication_name, dosage)
VALUES ('CALL-999', 'Epinephrine', '0.3mg');

SELECT * FROM emergency_call;
SELECT * FROM medical_emergency_meds;