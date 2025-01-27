CREATE DATABASE IF NOT EXISTS pruebadocker;
USE pruebadocker;

CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    precio DOUBLE NOT NULL,
    cantidad INT NOT NULL
);

INSERT INTO productos (nombre, precio, cantidad) 
VALUES 
('producto 1', 10.50, 5),
('producto 2', 25.00, 3);
