ALTER TABLE paciente
ADD activo TINYINT;
UPDATE medico set activo = 1;