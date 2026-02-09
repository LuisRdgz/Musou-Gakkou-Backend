INSERT INTO Usuarios (nombre_usuario, apellido_usuario, correo_usuario, telefono_usuario, contraseña_usuario, rol_usuario)
VALUES ('Hibeth', 'Torres', 'hibeth@correo.com', '8332918237', 'contraIb123', 'admin');

SELECT * FROM Usuarios;

INSERT INTO Usuarios (nombre_usuario, apellido_usuario, correo_usuario, telefono_usuario, contraseña_usuario, rol_usuario)
VALUES ('José Carlos','Velasco López','jcvl0611@gmail.com','3411012935','password1234','admin'),
('Luis Rivaldo', 'Rodriguez', 'luisrdgz@gmail.com', '8134489572', 'luis12345', 'alumno'),
('Andrea', 'Estrada', 'andreaestradafelix@gmail.com', '6421164170', 'hola123', 'profesor'),
('Juan','Perez','alumno@ittai.com','018001234','password','alumno');

INSERT INTO Usuarios (nombre_usuario, apellido_usuario, correo_usuario, telefono_usuario, contraseña_usuario, rol_usuario)
VALUES ('Hilda','Alcantar','adlih@correo.com', 3387569647,'contra123','alumno');

INSERT INTO Cursos (fecha_inicio_curso, fecha_cierre_curso, costo_curso, descripcion_curso, detalle_curso, modalidad_curso, nombre_curso)
VALUES ('2026-01-23', '2026-04-23', 2000, 'Conoces los kanjis', 'En este nivel inicial, desarrollarás la capacidad de comprender expresiones básicas y frases hechas de la vida cotidiana. Aprenderás a leer y escribir los alfabetos Hiragana, Katakana y aproximadamente 100 Kanjis esenciales.', 'Sabatino', 'N5 Principiante');

SELECT * FROM Cursos;

INSERT INTO Cursos (fecha_inicio_curso, fecha_cierre_curso, costo_curso, descripcion_curso, detalle_curso, modalidad_curso, nombre_curso)
VALUES ('2026-01-23', '2026-02-23', 1800, 'Conoces los kanjis', 'Curso enfocado en la gramática elemental y la comprensión auditiva de conversaciones lentas. Al finalizar, el alumno podrá entender instrucciones sencillas y participar en diálogos breves.', 'Intensivo', 'N5 Principiante'),
('2026-01-23', '2026-04-23', 1700, 'Puedes escribir utilizando kanjis', 'Este nivel profundiza en la gramática de nivel básico-medio. El estudiante adquiere la habilidad de leer y comprender pasajes sobre temas cotidianos utilizando un vocabulario de unos 300 Kanjis.', 'Sabatino', 'N4 Semi intermedio'),
('2026-01-23', '2026-02-23', 1400, 'Puedes escribir utilizando kanjis', 'Al completar este curso, el alumno será capaz de entender conversaciones fluidas en situaciones diarias. Se desarrollan habilidades para narrar experiencias pasadas y expresar deseos o planes a futuro.', 'Intensivo', 'N4 Semi intermedio'),
('2026-01-23', '2026-02-23', 1600, 'Puedes entablar una conversación sencilla', 'El nivel N3 es el puente entre el japonés básico y el avanzado. Aprenderás a entender puntos específicos en artículos sobre temas generales y a captar ideas principales en noticias.', 'Intensivo', 'N3 Intermedio'),
('2026-01-23', '2026-04-23', 1900, 'Puedes entablar una conversación sencilla', 'Se enfoca en la transición hacia un lenguaje más abstracto. El alumno aprenderá a parafrasear y explicar conceptos cuando no conoce la palabra exacta, además de comprender la cohesión de textos.', 'Sabatino', 'N3 Intermedio'),
('2026-01-26', '2026-02-26', 1500, 'Eres capaz de mantener una conversación y manejar textos complejos', 'Nivel de suficiencia para trabajar en entornos profesionales japoneses. Aprenderás a leer críticamente artículos, comentarios y críticas. Dominarás aproximadamente 1,000 Kanjis.', 'Intensivo', 'N2 Avanzado'),
('2026-01-26', '2026-04-26', 1800, 'Eres capaz de mantener una conversación y manejar textos complejos', 'Desarrolla la capacidad de comprender el flujo lógico de un discurso en diversos contextos, desde presentaciones hasta noticias de actualidad. Conversaciones con fluidez y naturalidad.', 'Sabatino', 'N2 Avanzado'),
('2026-01-26', '2026-02-26', 1200, 'Puedes utilizar el idioma en cualquier contexto', 'El nivel más alto del JLPT. Se centra en la capacidad de leer textos con profundidad lógica o abstracción en temas complejos como filosofía, economía y política. Dominio de 2,000 Kanjis.', 'Intensivo', 'N1 Profesional'),
('2026-01-26', '2026-04-26', 1500, 'Puedes utilizar el idioma en cualquier contexto', 'Perfeccionamiento de la comprensión auditiva en situaciones académicas y laborales de alta complejidad. Capacidad de seguir conferencias y debates a velocidad nativa captando ironías.', 'Sabatino', 'N1 Profesional');


INSERT INTO Recursos (costo_recurso, titulo_recurso, detalle_recurso, descripcion_recurso)
VALUES (0, 'Planillas Kanji para N5', 'Este recurso educativo incluye los kanjis fundamentales para aprobar el examen JLPT N5. Cada ficha presenta el orden de trazos, lecturas onyomi y kunyomi, y ejemplos prácticos de uso. Es la guía perfecta para que principiantes construyan una base sólida en la caligrafía y reconocimiento visual del japonés.', 'Domina los caracteres esenciales del nivel N5 con estas planillas de Kanji diseñadas para facilitar tu aprendizaje y escritura.'),
(0, 'Guía Básica de Hiragana', 'Este material es el punto de partida esencial para todo estudiante de japonés. Incluye la tabla completa de los 46 caracteres del silabario Hiragana, con guías visuales sobre el orden de los trazos, los sonidos puros, los sonidos derivados (dakuten/handakuten) y las combinaciones de diptongos. Es la herramienta ideal para comenzar a leer y escribir palabras nativas desde el primer día.', 'Aprende a leer y escribir el primer silabario japonés con esta guía completa que incluye el orden de trazos y ejemplos de vocabulario básico.'),
(0, 'Guía Básica de Katakana', 'Este material visual está diseñado para dominar la lectura y escritura del segundo silabario japonés. Incluye una guía detallada de las vocales y consonantes principales, con énfasis especial en las variaciones fonéticas como shi, chi y tsu, permitiendo al estudiante escribir palabras extranjeras correctamente.', 'Aprende los fundamentos del Katakana con esta tabla clara y organizada que muestra las sílabas básicas y sus excepciones fonéticas.'),
(0, 'Guía de partículas japonesas', 'Este material gramatical ofrece una tabla detallada de las partículas fundamentales, sus estructuras y ejemplos prácticos. Cubre desde marcadores de sujeto y objeto hasta indicadores de lugar, tiempo y dirección, siendo un recurso indispensable para entender la lógica detrás de la sintaxis japonesa.', 'Comprende el uso de conectores esenciales como ga, wa, ni y de para estructurar oraciones correctamente en japonés básico.'),
(0, 'Guía de clasificadores numéricos', 'Este material explica la estructura fundamental de ''número + clasificador'' necesaria para cuantificar en japonés. Incluye tablas comparativas para objetos planos (-mai), alargados (-hon), libros (-satsu), objetos pequeños (-ko/-tsu), así como personas (-nin) y edades (-sai).', 'Aprende a contar objetos, personas y edades correctamente utilizando los sufijos específicos según la forma y categoría de cada elemento.');


SELECT * FROM Recursos;

ALTER TABLE Recursos
MODIFY COLUMN detalle_recurso MEDIUMTEXT;

SELECT * FROM Ordenes;

INSERT INTO Ordenes (total_orden, fecha_orden, usuarios_id_usuario)
VALUES (0, '2026-02-09', 3),
(2000, '2026-02-09', 3),
(1800, '2026-02-09', 3),
(1600, '2026-02-09', 5),
(1200, '2026-02-09', 6);

RENAME TABLE `reseñas` TO `resenas`;

SELECT * FROM Resenas;


INSERT INTO usuarios (nombre_usuario, apellido_usuario, correo_usuario, telefono_usuario, contraseña_usuario, rol_usuario) 
VALUES
('Blanca', 'Perez', 'blanca.perez@email.com', '5551234567', 'password123', 'alumno'),
('Tania', 'Gayosso', 'tania.gayosso@email.com', '5552345678', 'password123', 'alumno'),
('Ricardo', 'Mendoza', 'ricardo.mendoza@email.com', '5553456789', 'password123', 'alumno'),
('Elena', 'Soto', 'elena.soto@email.com', '5554567890', 'password123', 'alumno'),
('Jorge', 'Luna', 'jorge.luna@email.com', '5555678901', 'password123', 'alumno'),
('Lucía', 'Herrera', 'lucia.herrera@email.com', '5556789012', 'password123', 'alumno'),
('Sofía', 'Díaz', 'sofia.diaz@email.com', '5557890123', 'password123', 'alumno'),
('Mateo', 'Rojas', 'mateo.rojas@email.com', '5558901234', 'password123', 'alumno'),
('Andrés', 'Palacios', 'andres.palacios@email.com', '5559012345', 'password123', 'alumno'),
('Valeria', 'Cisneros', 'valeria.cisneros@email.com', '5550123456', 'password123', 'alumno'),
('Daniela', 'Gutiérrez', 'daniela.gutierrez@email.com', '5551122334', 'password123', 'alumno'),
('Tomás', 'Vargas', 'tomas.vargas@email.com', '5552233445', 'password123', 'alumno'),
('Brenda', 'Lara', 'brenda.lara@email.com', '5553344556', 'password123', 'alumno'),
('Hugo', 'Morales', 'hugo.morales@email.com', '5554455667', 'password123', 'alumno'),
('Mónica', 'Torres', 'monica.torres@email.com', '5555566778', 'password123', 'alumno'),
('Paola', 'Fuentes', 'paola.fuentes@email.com', '5556677889', 'password123', 'alumno'),
('Samuel', 'Figueroa', 'samuel.figueroa@email.com', '5557788990', 'password123', 'alumno'),
('Karina', 'Beltrán', 'karina.beltran@email.com', '5558899001', 'password123', 'alumno'),
('Inés', 'Miranda', 'ines.miranda@email.com', '5559900112', 'password123', 'alumno'),
('Felipe', 'Guzmán', 'felipe.guzman@email.com', '5551010101', 'password123', 'alumno'),
('Carla', 'Ramírez', 'carla.ramirez@email.com', '5552020202', 'password123', 'alumno'),
('Marcos', 'Paredes', 'marcos.paredes@email.com', '5553030303', 'password123', 'alumno'),
('Ricardo', 'Trejo', 'ricardo.trejo@email.com', '5554040404', 'password123', 'alumno'),
('Elena', 'Valle', 'elena.valle@email.com', '5555050505', 'password123', 'alumno'),
('Sofía', 'López', 'sofia.lopez@email.com', '5556060606', 'password123', 'alumno'),
('Daniel', 'Kuri', 'daniel.kuri@email.com', '5557070707', 'password123', 'alumno');

INSERT INTO Resenas (valoracion_reseña, fecha_reseña, contenido_reseña, titulo_reseña, cursos_id_curso)
VALUES 
-- Reseñas para N5 Principiante (Sabatino)
(5, '2025-12-10', 'Contenido excelente, el maestro hizo la clase muy amena', 'Clase muy amena', 1),
(5, '2025-01-10', 'Me gustó mucho el material didáctico', 'Excelente material', 1),

-- Reseñas para N5 Principiante (Intensivo)
(5, '2025-11-20', 'Excelente para empezar desde cero.', 'Ideal para principiantes', 2),
(5, '2025-11-25', 'Muy dinámico y bien estructurado.', 'Dinámico y claro', 2),

-- Reseñas para N4 Semi intermedio (Sabatino)
(4.6, '2025-10-05', 'Buen curso, aunque la gramática es intensa.', 'Gramática intensa', 3),
(4.0, '2025-10-12', 'Me ayudó mucho con los kanjis del N4.', 'Útil para Kanjis', 3),

-- Reseñas para N4 Semi intermedio (Intensivo)
(4.8, '2025-09-15', 'El formato intensivo es lo mejor para avanzar.', 'Avance rápido', 4),
(4.8, '2025-09-20', 'Increíble la rapidez con la que aprendes.', 'Aprendizaje veloz', 4),

-- Reseñas para N3 Intermedio (Intensivo)
(3.6, '2025-08-10', 'Falta un poco de tiempo para conversación.', 'Más conversación', 5),
(4.0, '2025-08-15', 'Sólido pero requiere mucho estudio autónomo.', 'Estudio autónomo', 5),

-- Reseñas para N3 Intermedio (Sabatino)
(4.2, '2025-07-05', 'Muy buen material de apoyo.', 'Material de apoyo', 6),
(4.2, '2025-07-12', 'El profesor explica muy bien los puntos difíciles.', 'Explicaciones claras', 6),

-- Reseñas para N2 Avanzado (Intensivo)
(4.7, '2025-11-01', 'Nivel avanzado real, muy útil para el examen.', 'Útil para examen', 7),
(4.7, '2025-11-05', 'Excelente contenido técnico.', 'Contenido técnico', 7),

-- Reseñas para N2 Avanzado (Sabatino)
(4.4, '2025-12-15', 'Gran enfoque en lectura comprensiva.', 'Lectura comprensiva', 8),
(4.4, '2025-12-20', 'Clases sabatinas muy productivas.', 'Sábados productivos', 8),

-- Reseñas para N1 Profesional (Intensivo)
(4.0, '2025-06-15', 'Un resto total, pero el profesor es un experto.', 'Reto total', 9),
(4.0, '2025-06-20', 'Perfecto para pulir los últimos detalles del idioma.', 'Pulir detalles', 9),

-- Reseñas para N1 Profesional (Sabatino)
(3.8, '2025-05-10', 'Contenido sólido, el ritmo sabatino ayuda a digerir los temas.', 'Ritmo adecuado', 10),
(3.8, '2025-05-15', 'Dificultad alta, ideal para traductores.', 'Para expertos', 10);


-- Linking Orders to Courses
-- Order 2 ($2000) -> Course 1 (N5 Principiante Sabatino)
-- Order 3 ($1800) -> Course 2 (N5 Principiante Intensivo)
-- Order 4 ($1600) -> Course 5 (N3 Intermedio Intensivo)
-- Order 5 ($1200) -> Course 9 (N1 Profesional Intensivo)
INSERT INTO ordenes_has_cursos (ordenes_id_orden, ordenes_usuarios_id_usuario, cursos_id_curso)
VALUES 
(2, 3, 1),
(3, 3, 2),
(4, 5, 5),
(5, 6, 9),
(5, 6, 10); -- Adding a second course to Order 5 to show multiple items per order


SELECT * FROM ordenes_has_cursos;


-- Linking Orders to Resources
-- Order 1 was $0, perfect for free resources!
INSERT INTO ordenes_has_recursos (ordenes_id_orden, ordenes_usuarios_id_usuario, recursos_id_recurso)
VALUES 
(1, 3, 1),
(1, 3, 2),
(2, 3, 3),
(4, 5, 4),
(5, 6, 5);

SELECT * FROM ordenes_has_recursos;

-- Enrollment (usuarios_has_cursos)
-- Linking some of your new students (IDs 7-11) to the N5 course
INSERT INTO usuarios_has_cursos (usuarios_id_usuario, cursos_id_curso)
VALUES 
(7, 1),  -- Blanca Perez in N5 Sabatino
(8, 1),  -- Tania Gayosso in N5 Sabatino
(9, 2),  -- Ricardo Mendoza in N5 Intensivo
(10, 3), -- Elena Soto in N4 Sabatino
(11, 4); -- Jorge Luna in N4 Intensivo


SELECT * FROM usuarios_has_cursos;

-- Library Access (usuarios_has_recursos)
-- Giving students access to their study guides
INSERT INTO usuarios_has_recursos (usuarios_id_usuario, recursos_id_recurso)
VALUES 
(7, 1), -- Blanca has Kanji N5 guide
(7, 2), -- Blanca has Hiragana guide
(8, 2), -- Tania has Hiragana guide
(9, 3), -- Ricardo has Katakana guide
(10, 4); -- Elena has Particles guide

SELECT * FROM usuarios_has_recursos;