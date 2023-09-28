ALTER TABLE medico
ADD activo TINYINT;
UPDATE medico set activo = 1;