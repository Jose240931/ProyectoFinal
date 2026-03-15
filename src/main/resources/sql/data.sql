--Insercion de categorias

INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Fruteria');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Comida preparada');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Congelados');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Pescaderia');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Panaderia');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Conservas');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Charcuteria');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Carniceria');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Quesos');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Especias');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Pasta');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Legumbres');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Galletas');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Aperitivos');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Limpieza y hogar');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Lacteos');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Higiene');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Maquillaje');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Bebidas alcoholicas');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Refrescos y agua');
INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES ('Encurtidos');

--Insercion de productos
-- =========================
-- INSERCIÓN DE PRODUCTOS - FRUTERÍA (ID: 1)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
-- Frutas
('Plátano', NULL, 1),
('Uva', NULL, 1),
('Manzana', NULL, 1),
('Pera', NULL, 1),
('Melón', NULL, 1),
('Sandía', NULL, 1),
('Limón', NULL, 1),
('Mandarina', NULL, 1),
('Naranjas', NULL, 1),
('Pomelo', NULL, 1),
('Lima', NULL, 1),
('Kiwi', NULL, 1),
('Aguacate', NULL, 1),
('Piña', NULL, 1),
('Mango', NULL, 1),
('Papaya', NULL, 1),
('Cerezas', NULL, 1),
('Fresas', NULL, 1),
('Fresón', NULL, 1),
('Frambuesas', NULL, 1),
('Moras', NULL, 1),
('Arándanos', NULL, 1),

-- Ensaladas
('Lechuga', NULL, 1),
('Ensalada', NULL, 1),
('Canónigos', NULL, 1),
('Cogollos', NULL, 1),
('Endibias', NULL, 1),
('Rúcula', NULL, 1),
('Ensalada Mixta', NULL, 1),
('Espinacas', NULL, 1),
('Romanescu', NULL, 1),
('Escarola', NULL, 1),
('Ensalada César', NULL, 1),
('Ensalada California', NULL, 1),
('Ensalada de la casa', NULL, 1),
('Wrap Texas', NULL, 1),
('Ensalada Ensatun', NULL, 1),
('Ensalada de pasta', NULL, 1),
('Ensalada queso de cabra', NULL, 1),

-- Verduras y Hortalizas
('Patata', NULL, 1),
('Batata', NULL, 1),
('Yuca', NULL, 1),
('Cebolla', NULL, 1),
('Ajo', NULL, 1),
('Picada', NULL, 1),
('Tomate', NULL, 1),
('Zanahorias', NULL, 1),
('Pepino', NULL, 1),
('Pimiento rojo', NULL, 1),
('Pimientos', NULL, 1),
('Calabacín', NULL, 1),
('Coliflor', NULL, 1),
('Repollo', NULL, 1),
('Col', NULL, 1),
('Champiñones', NULL, 1),
('Setas', NULL, 1),
('Perejil', NULL, 1),
('Jengibre', NULL, 1),
('Cilantro', NULL, 1),
('Albahaca', NULL, 1),
('Hierbabuena', NULL, 1),
('Cebollino', NULL, 1),
('Brócoli', NULL, 1),
('Berenjena', NULL, 1),
('Judía verde', NULL, 1),
('Acelgas', NULL, 1),
('Puerros', NULL, 1),
('Alcachofa', NULL, 1),
('Calabaza', NULL, 1),
('Apio', NULL, 1),
('Espárragos', NULL, 1),
('Rábanos', NULL, 1),
('Remolacha', NULL, 1),
('Maíz', NULL, 1),
('Mazorca de maíz', NULL, 1),
('Verdura', NULL, 1),
('Preparado de verdura', NULL, 1),
('Habas', NULL, 1),
('Salteado de verduras', NULL, 1);

-- =========================
-- INSERCIÓN DE PRODUCTOS - COMIDA PREPARADA (ID: 2)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
                                                                      ('Pollo teriyaki', NULL, 2),
                                                                      ('Ensaladilla rusa', NULL, 2),
                                                                      ('Sushi', NULL, 2),
                                                                      ('Rosca', NULL, 2),
                                                                      ('Focaccia', NULL, 2),
                                                                      ('Lasaña', NULL, 2),
                                                                      ('Spaghetti', NULL, 2),
                                                                      ('Pollo asado', NULL, 2),
                                                                      ('Hummus', NULL, 2),
                                                                      ('Tabulé', NULL, 2),
                                                                      ('Sandwich', NULL, 2),
                                                                      ('Gazpacho', NULL, 2),
                                                                      ('Salmorejo', NULL, 2),
                                                                      ('Puré', NULL, 2),
                                                                      ('Sopa', NULL, 2),
                                                                      ('Caldo', NULL, 2),
                                                                      ('Caldo en pastillas', NULL, 2),
                                                                      ('Avecrem', NULL, 2),
                                                                      ('Tomate triturado', NULL, 2),
                                                                      ('Tomate frito', NULL, 2),
                                                                      ('Pizza', NULL, 2),
                                                                      ('Base de pizza', NULL, 2),
                                                                      ('San jacobos', NULL, 2),
                                                                      ('Carne de kebab', NULL, 2),
                                                                      ('Pescado rebozado', NULL, 2),
                                                                      ('Verdura rebozada', NULL, 2),
                                                                      ('Tarta', NULL, 2),
                                                                      ('Churros', NULL, 2),
                                                                      ('Crepes', NULL, 2),
                                                                      ('Mix fruta', NULL, 2),
                                                                      ('Mix verdura', NULL, 2),
                                                                      ('Parrillada', NULL, 2),
                                                                      ('Salteado', NULL, 2),
                                                                      ('Flautas', NULL, 2),
                                                                      ('Tortilla de patatas', NULL, 2);

-- =========================
-- INSERCIÓN DE PRODUCTOS - CONGELADOS (ID: 3)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
                                                                      ('Helado', NULL, 3),
                                                                      ('Cucuruchos', NULL, 3),
                                                                      ('Granizada', NULL, 3),
                                                                      ('Tarrina de helado', NULL, 3),
                                                                      ('Hielo', NULL, 3),
                                                                      ('Nuggets', NULL, 3),
                                                                      ('Croquetas', NULL, 3),
                                                                      ('Brochetas', NULL, 3),
                                                                      ('Pinchos', NULL, 3),
                                                                      ('Callos', NULL, 3),
                                                                      ('Flamenquín', NULL, 3),
                                                                      ('Filetes empanados', NULL, 3),
                                                                      ('Fritura de pescado', NULL, 3),
                                                                      ('Gyozas', NULL, 3),
                                                                      ('Patatas fritas', NULL, 3);

-- =========================
-- INSERCIÓN DE PRODUCTOS - PESCADERÍA (ID: 4)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
                                                                      ('Hueso', NULL, 4),
                                                                      ('Gambón', NULL, 4),
                                                                      ('Marisco', NULL, 4),
                                                                      ('Gamba', NULL, 4),
                                                                      ('Atún', NULL, 4),
                                                                      ('Langostinos', NULL, 4),
                                                                      ('Camarón', NULL, 4),
                                                                      ('Bogavante', NULL, 4),
                                                                      ('Buey de mar', NULL, 4),
                                                                      ('Palitos de surimi', NULL, 4),
                                                                      ('Mejillones', NULL, 4),
                                                                      ('Almejas', NULL, 4),
                                                                      ('Merluza', NULL, 4),
                                                                      ('Bacalao', NULL, 4),
                                                                      ('Pota', NULL, 4),
                                                                      ('Sepia', NULL, 4),
                                                                      ('Salmón', NULL, 4),
                                                                      ('Calamar', NULL, 4),
                                                                      ('Pulpo', NULL, 4),
                                                                      ('Tintorera', NULL, 4),
                                                                      ('Rape', NULL, 4),
                                                                      ('Pescadilla', NULL, 4),
                                                                      ('Atún', NULL, 4),
                                                                      ('Rosada', NULL, 4),
                                                                      ('Marrajo', NULL, 4),
                                                                      ('Lenguado', NULL, 4),
                                                                      ('Lubina', NULL, 4),
                                                                      ('Dorada', NULL, 4),
                                                                      ('Corvina', NULL, 4),
                                                                      ('Trucha', NULL, 4),
                                                                      ('Boquerón', NULL, 4),
                                                                      ('Sarina', NULL, 4),
                                                                      ('Rodaballo', NULL, 4),
                                                                      ('Anchoa', NULL, 4),
                                                                      ('Boquerones en vinagre', NULL, 4),
                                                                      ('Salmón ahumado', NULL, 4),
                                                                      ('Ventresca', NULL, 4),
                                                                      ('Bonito', NULL, 4),
                                                                      ('Caballa', NULL, 4),
                                                                      ('Melva', NULL, 4),
                                                                      ('Sardinas', NULL, 4),
                                                                      ('Berberecho', NULL, 4),
                                                                      ('Concha fina', NULL, 4),
                                                                      ('Navajas', NULL, 4),
                                                                      ('Cañailla', NULL, 4),
                                                                      ('Chirla', NULL, 4);

-- =========================
-- INSERCIÓN DE PRODUCTOS - PANADERÍA (ID: 5)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
-- Bollería
('Croissant', NULL, 5),
('Pastel de crema', NULL, 5),
('Bizcocho', NULL, 5),
('Berlina', NULL, 5),
('Donut', NULL, 5),
('Magdalenas', NULL, 5),
('Trenzas', NULL, 5),
('Napolitanas', NULL, 5),
('Muffin', NULL, 5),
('Susos', NULL, 5),
('Empanada', NULL, 5),
('Hojaldre', NULL, 5),
('Empanadilla', NULL, 5),
('Bollería', NULL, 5),
('Pan de leche', NULL, 5),
('Palmeritas', NULL, 5),
('Gofres', NULL, 5),
('Ensaimadas', NULL, 5),
('Tortas', NULL, 5),
('Tortas de aceite', NULL, 5),
('Cortadillos', NULL, 5),
('Roscos', NULL, 5),
('Rosquillas', NULL, 5),
-- Pan
('Pan', NULL, 5),
('Barras de pan', NULL, 5),
('Baguette', NULL, 5),
('Pan de bocadillo', NULL, 5),
('Pan de molde', NULL, 5),
('Hogaza', NULL, 5),
('Pan de migas', NULL, 5),
('Tortillas de trigo', NULL, 5),
('Pan hot dog', NULL, 5),
('Pan de perrito caliente', NULL, 5),
('Pan de hamburguesa', NULL, 5),
('Pan de pita', NULL, 5),
('Pan tostado', NULL, 5),
('Biscotes', NULL, 5),
('Pan rallado', NULL, 5),
('Crackers', NULL, 5),
('Tostadas de arroz', NULL, 5),
('Picos', NULL, 5),
('Palillos', NULL, 5),
('Regaña', NULL, 5),
('Palitos de pan', NULL, 5),
('Picatostes', NULL, 5),
-- Ingredientes de repostería
('Harina', NULL, 5),
('Preparado para repostería', NULL, 5),
('Levadura', NULL, 5),
('Preparado de flan', NULL, 5),
('Preparado de natillas', NULL, 5),
('Preparado de gelatina', NULL, 5),
('Masa de hojaldre', NULL, 5),
('Masa', NULL, 5),
('Velas de cumpleaños', NULL, 5),
('Almendra molida', NULL, 5),
('Coco rallado', NULL, 5);

-- =========================
-- INSERCIÓN DE PRODUCTOS - CONSERVAS (ID: 6)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
                                                                      ('Maíz dulce', NULL, 6),
                                                                      ('Espárragos', NULL, 6),
                                                                      ('Champiñones', NULL, 6),
                                                                      ('Guisantes', NULL, 6),
                                                                      ('Judías verdes', NULL, 6),
                                                                      ('Melva', NULL, 6),
                                                                      ('Atun', NULL, 6),
                                                                      ('Caballa', NULL, 6),
                                                                      ('Corazones de alcachofa', NULL, 6),
                                                                      ('Zanahoria troceada', NULL, 6),
                                                                      ('Remolacha troceada', NULL, 6),
                                                                      ('Palmito', NULL, 6),
                                                                      ('Piña', NULL, 6),
                                                                      ('Cabello de ángel', NULL, 6),
                                                                      ('Membrillo', NULL, 6),
                                                                      ('Macedonia', NULL, 6);

-- =========================
-- INSERCIÓN DE PRODUCTOS - CHARCUTERÍA (ID: 7)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
                                                                      ('Jamón York', NULL, 7),
                                                                      ('Salchichón', NULL, 7),
                                                                      ('Bacon', NULL, 7),
                                                                      ('Panceta', NULL, 7),
                                                                      ('Chopped', NULL, 7),
                                                                      ('Mortadela', NULL, 7),
                                                                      ('Fuet', NULL, 7),
                                                                      ('Espetec', NULL, 7),
                                                                      ('Fuet espetec', NULL, 7),
                                                                      ('Salami', NULL, 7),
                                                                      ('Mini salchichón', NULL, 7),
                                                                      ('Pepperoni', NULL, 7),
                                                                      ('Mini chorizo', NULL, 7),
                                                                      ('Caña de lomo', NULL, 7),
                                                                      ('Lomo embuchado', NULL, 7),
                                                                      ('Jamón serrano', NULL, 7),
                                                                      ('Jamón', NULL, 7),
                                                                      ('Paté', NULL, 7),
                                                                      ('Chorizo', NULL, 7),
                                                                      ('Morcilla', NULL, 7),
                                                                      ('Butifarra', NULL, 7),
                                                                      ('Sobrasada', NULL, 7);

-- =========================
-- INSERCIÓN DE PRODUCTOS - CARNICERÍA (ID: 8)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
                                                                      ('Cerdo', NULL, 8),
                                                                      ('Ternera', NULL, 8),
                                                                      ('Pollo', NULL, 8),
                                                                      ('Carne vacuno', NULL, 8),
                                                                      ('Carne ternera', NULL, 8),
                                                                      ('Carne de cerdo', NULL, 8),
                                                                      ('Carne de pollo', NULL, 8),
                                                                      ('Tocino', NULL, 8),
                                                                      ('Filetes', NULL, 8),
                                                                      ('Muslos', NULL, 8),
                                                                      ('Hígados', NULL, 8),
                                                                      ('Alitas', NULL, 8),
                                                                      ('Paletilla', NULL, 8),
                                                                      ('Zurrapa de lomo', NULL, 8),
                                                                      ('Manteca de cerdo', NULL, 8),
                                                                      ('Conejo', NULL, 8),
                                                                      ('Hamburguesas', NULL, 8),
                                                                      ('Salchichas', NULL, 8),
                                                                      ('Longaniza', NULL, 8),
                                                                      ('Chistorra', NULL, 8),
                                                                      ('Carne picada', NULL, 8),
                                                                      ('Albóndigas', NULL, 8),
                                                                      ('Carpaccio', NULL, 8);

-- =========================
-- INSERCIÓN DE PRODUCTOS - QUESOS (ID: 9)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
                                                                      ('Queso curado', NULL, 9),
                                                                      ('Queso semicurado', NULL, 9),
                                                                      ('Queso tierno', NULL, 9),
                                                                      ('Lonchas de queso', NULL, 9),
                                                                      ('Queso rallado', NULL, 9),
                                                                      ('Quesitos', NULL, 9),
                                                                      ('Queso de untar', NULL, 9),
                                                                      ('Filadelfia', NULL, 9),
                                                                      ('Philadelphia', NULL, 9),
                                                                      ('Queso fresco', NULL, 9),
                                                                      ('Mozzarella', NULL, 9),
                                                                      ('Mozarella', NULL, 9),
                                                                      ('Requesón', NULL, 9),
                                                                      ('Rulo de cabra', NULL, 9),
                                                                      ('Camembert', NULL, 9),
                                                                      ('Queso azul', NULL, 9),
                                                                      ('Cabrales', NULL, 9);

-- =========================
-- INSERCIÓN DE PRODUCTOS - ESPECIAS (ID: 10)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
-- Especias y condimentos
('Aceite', NULL, 10),
('Vinagre', NULL, 10),
('Sal', NULL, 10),
('Bicarbonato', NULL, 10),
('Orégano', NULL, 10),
('Perejil', NULL, 10),
('Laurel', NULL, 10),
('Albahaca', NULL, 10),
('Tomillo', NULL, 10),
('Eneldo', NULL, 10),
('Cilantro', NULL, 10),
('Romero', NULL, 10),
('Colorante', NULL, 10),
('Pimentón', NULL, 10),
('Azafrán', NULL, 10),
('Pimienta', NULL, 10),
('Ajo (molido)', NULL, 10),
('Cebolla (molida)', NULL, 10),
('Canela', NULL, 10),
('Comino', NULL, 10),
('Curry', NULL, 10),
('Nuez moscada', NULL, 10),
('Cayena', NULL, 10),
('Cúrcuma', NULL, 10),
('Ñoras', NULL, 10),
('Clavo', NULL, 10),
('Piñones', NULL, 10),
('Sazonador', NULL, 10),
-- Salsas
('Mayonesa', NULL, 10),
('Ketchup', NULL, 10),
('Mostaza', NULL, 10),
('Alioli', NULL, 10),
('Salsa para carnes', NULL, 10),
('Salsa para pasta', NULL, 10),
('Salsa de soja', NULL, 10),
('Guacamole', NULL, 10),
('Bechamel', NULL, 10),
('Salsa', NULL, 10),
('Pasta de sésamo', NULL, 10);

-- =========================
-- INSERCIÓN DE PRODUCTOS - PASTA (ID: 11)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
                                                                      ('Fideos', NULL, 11),
                                                                      ('Macarrones', NULL, 11),
                                                                      ('Espaguetis', NULL, 11),
                                                                      ('Tallarines', NULL, 11),
                                                                      ('Pasta', NULL, 11),
                                                                      ('Tortellini', NULL, 11),
                                                                      ('Ravioli', NULL, 11),
                                                                      ('Fideos orientales', NULL, 11),
                                                                      ('Placas lasaña', NULL, 11),
                                                                      ('Noodles', NULL, 11);

-- =========================
-- INSERCIÓN DE PRODUCTOS - LEGUMBRES (ID: 12)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
-- Legumbres
('Arroz', NULL, 12),
('Quinoa', NULL, 12),
('Garbanzos', NULL, 12),
('Lentejas', NULL, 12),
('Habichuelas', NULL, 12);


-- =========================
-- INSERCIÓN DE PRODUCTOS - GALLETAS (ID: 13)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
-- Galletas
('Galletas saladas', NULL, 13),
('Gusanitos', NULL, 13),
('Galletas', NULL, 13),
('Galletas de chocolate', NULL, 13),
('Galletas digestive', NULL, 13),
('Barquillos', NULL, 13),
('Obleas', NULL, 13),
('Surtido', NULL, 13),
('Tortitas', NULL, 13),
('Barritas de cereales', NULL, 13),
-- Dulces y azúcares
('Azúcar', NULL, 13),
('Edulcorante', NULL, 13),
('Chicles', NULL, 13),
('Caramelos', NULL, 13),
('Chocolate', NULL, 13),
('Chocolatinas', NULL, 13),
('Bombones', NULL, 13),
('Nutella', NULL, 13),
('Crema de cacao', NULL, 13),
('Mermelada', NULL, 13),
('Miel', NULL, 13),
('Confitura', NULL, 13),
('Turrón', NULL, 13),
-- Cereales
('Cereales', NULL, 13),
('Muesli', NULL, 13),
('Avena', NULL, 13);

-- =========================
-- INSERCIÓN DE PRODUCTOS - APERITIVOS (ID: 14)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
                                                                      ('Nueces', NULL, 14),
                                                                      ('Almendra', NULL, 14),
                                                                      ('Pistacho', NULL, 14),
                                                                      ('Pipas', NULL, 14),
                                                                      ('Cacahuete', NULL, 14),
                                                                      ('Anacardo', NULL, 14),
                                                                      ('Palomitas', NULL, 14),
                                                                      ('Avellanas', NULL, 14),
                                                                      ('Maíz frito', NULL, 14),
                                                                      ('Semillas chía', NULL, 14),
                                                                      ('Cocktail', NULL, 14),
                                                                      ('Pasas', NULL, 14),
                                                                      ('Fruta deshidratada', NULL, 14),
                                                                      ('Dátiles', NULL, 14),
                                                                      ('Patatas fritas', NULL, 14),
                                                                      ('Nachos', NULL, 14),
                                                                      ('Golosinas', NULL, 14),
                                                                      ('Chuches', NULL, 14),
                                                                      ('Snacks', NULL, 14);

-- =========================
-- INSERCIÓN DE PRODUCTOS - LIMPIEZA Y HOGAR (ID: 15)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
                                                                      ('Detergente', NULL, 15),
                                                                      ('Quitamanchas', NULL, 15),
                                                                      ('Antical', NULL, 15),
                                                                      ('Limpia lavadoras', NULL, 15),
                                                                      ('Suavizante', NULL, 15),
                                                                      ('Agua destilada', NULL, 15),
                                                                      ('Perfumador de ropa', NULL, 15),
                                                                      ('Estropajo', NULL, 15),
                                                                      ('Bayeta', NULL, 15),
                                                                      ('Guantes', NULL, 15),
                                                                      ('Insecticida', NULL, 15),
                                                                      ('Repelente de mosquitos', NULL, 15),
                                                                      ('Bolsas antipolillas', NULL, 15),
                                                                      ('Recambio insecticida', NULL, 15),
                                                                      ('Matacucarachas', NULL, 15),
                                                                      ('Mata ratas', NULL, 15),
                                                                      ('Raticida', NULL, 15),
                                                                      ('Ambientador', NULL, 15),
                                                                      ('Recambio ambientador', NULL, 15),
                                                                      ('Difusor ambientador', NULL, 15),
                                                                      ('Ambientador de coche', NULL, 15),
                                                                      ('Ambientador varitas', NULL, 15),
                                                                      ('Velas', NULL, 15),
                                                                      ('Absorbe olores', NULL, 15),
                                                                      ('Antihumedad', NULL, 15),
                                                                      ('Recambio antihumedad', NULL, 15),
                                                                      ('Lejía', NULL, 15),
                                                                      ('Pastillas desinfectantes', NULL, 15),
                                                                      ('Amoniaco', NULL, 15),
                                                                      ('Salfumán', NULL, 15),
                                                                      ('Desatascador', NULL, 15),
                                                                      ('Sosa cáustica', NULL, 15),
                                                                      ('Limpiador de fosa séptica', NULL, 15),
                                                                      ('Alguicida', NULL, 15),
                                                                      ('Cloro', NULL, 15),
                                                                      ('Reductor de Ph', NULL, 15),
                                                                      ('Incrementador de Ph', NULL, 15),
                                                                      ('Limpiacristales', NULL, 15),
                                                                      ('Limpia gafas', NULL, 15),
                                                                      ('Lavaparabrisas', NULL, 15),
                                                                      ('Friegasuelos', NULL, 15),
                                                                      ('Abrillantador', NULL, 15),
                                                                      ('Cera', NULL, 15),
                                                                      ('Limpiahogar', NULL, 15),
                                                                      ('Desinfectante', NULL, 15),
                                                                      ('Limpiador WC', NULL, 15),
                                                                      ('Colgador WC', NULL, 15),
                                                                      ('Pastillas cisterna', NULL, 15),
                                                                      ('Quitagrasas', NULL, 15),
                                                                      ('Limpiador de hornos', NULL, 15),
                                                                      ('Limpiador vitrocerámicas', NULL, 15),
                                                                      ('Limpiador de muebles', NULL, 15),
                                                                      ('Vinagre de limpieza', NULL, 15),
                                                                      ('Multiusos', NULL, 15),
                                                                      ('Algodón mágico', NULL, 15),
                                                                      ('Fairy', NULL, 15),
                                                                      ('Lavavajillas ultra concentrado', NULL, 15),
                                                                      ('Pastillas lavavajillas', NULL, 15),
                                                                      ('Sal lavavajillas', NULL, 15),
                                                                      ('Ambientador lavavajillas', NULL, 15),
                                                                      ('Molde de aluminio', NULL, 15),
                                                                      ('Tupper', NULL, 15),
                                                                      ('Papel de aluminio', NULL, 15),
                                                                      ('Film transparente', NULL, 15),
                                                                      ('Papel vegetal', NULL, 15),
                                                                      ('Bolsas congelación', NULL, 15),
                                                                      ('Bolsas isotermo', NULL, 15),
                                                                      ('Bolsas de rafia', NULL, 15),
                                                                      ('Vasos de plástico', NULL, 15),
                                                                      ('Platos de plástico', NULL, 15),
                                                                      ('Cucharas de plástico', NULL, 15),
                                                                      ('Tenedores de plástico', NULL, 15),
                                                                      ('Cuchillos de plástico', NULL, 15),
                                                                      ('Palillos', NULL, 15),
                                                                      ('Pajitas', NULL, 15),
                                                                      ('Mantel', NULL, 15),
                                                                      ('Bandeja de cartón', NULL, 15),
                                                                      ('Pastillas encendedoras', NULL, 15),
                                                                      ('Pastilla barbacoa', NULL, 15),
                                                                      ('Carbón vegetal', NULL, 15),
                                                                      ('Fósforos', NULL, 15),
                                                                      ('Cerillas', NULL, 15),
                                                                      ('Mechero', NULL, 15),
                                                                      ('Encendedor', NULL, 15),
                                                                      ('Servilletas', NULL, 15),
                                                                      ('Rollo de cocina', NULL, 15),
                                                                      ('Papel de cocina', NULL, 15),
                                                                      ('Papel higiénico', NULL, 15),
                                                                      ('Pañuelos', NULL, 15),
                                                                      ('Pilas', NULL, 15),
                                                                      ('Bolsas de basura', NULL, 15),
                                                                      ('Escoba', NULL, 15),
                                                                      ('Fregona', NULL, 15),
                                                                      ('Mopa', NULL, 15),
                                                                      ('Recogedor', NULL, 15),
                                                                      ('Cubo de basura', NULL, 15),
                                                                      ('Barreño', NULL, 15),
                                                                      ('Pinzas de la ropa', NULL, 15),
                                                                      ('Alfileres', NULL, 15),
                                                                      ('Rodillo quitapelusas', NULL, 15),
                                                                      ('Cepillo para lavar', NULL, 15),
                                                                      ('Plumero', NULL, 15),
                                                                      ('Recambios de plumero', NULL, 15),
                                                                      ('Limpieza de calzado', NULL, 15),
                                                                      ('Comida de gato', NULL, 15),
                                                                      ('Comida de perro', NULL, 15),
                                                                      ('Alpiste', NULL, 15),
                                                                      ('Comida de pájaro', NULL, 15),
                                                                      ('Comida de conejo', NULL, 15),
                                                                      ('Comida de hámster', NULL, 15),
                                                                      ('Desodorante de calzado', NULL, 15);

-- =========================
-- INSERCIÓN DE PRODUCTOS - LÁCTEOS (ID: 16)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
                                                                      ('Huevos', NULL, 16),
                                                                      ('Claras de huevo', NULL, 16),
                                                                      ('Leche', NULL, 16),
                                                                      ('Leche de avena', NULL, 16),
                                                                      ('Leche de soja', NULL, 16),
                                                                      ('Leche de almendra', NULL, 16),
                                                                      ('Leche de coco', NULL, 16),
                                                                      ('Horchata', NULL, 16),
                                                                      ('Leche de avellana', NULL, 16),
                                                                      ('Leche condensada', NULL, 16),
                                                                      ('Crema de leche', NULL, 16),
                                                                      ('Leche evaporada', NULL, 16),
                                                                      ('Mantequilla', NULL, 16),
                                                                      ('Margarina', NULL, 16),
                                                                      ('Nata', NULL, 16),
                                                                      ('Nata montada', NULL, 16),
                                                                      ('Crema de soja', NULL, 16),
                                                                      ('Yogures', NULL, 16),
                                                                      ('Bifidus', NULL, 16),
                                                                      ('Flan', NULL, 16),
                                                                      ('Natillas', NULL, 16),
                                                                      ('Gelatina', NULL, 16),
                                                                      ('Arroz con leche', NULL, 16),
                                                                      ('Coulant', NULL, 16),
                                                                      ('Tarta de queso', NULL, 16),
                                                                      ('Crema catalana', NULL, 16),
                                                                      ('Yogur griego', NULL, 16),
                                                                      ('Yogur líquido', NULL, 16),
                                                                      ('Actimel', NULL, 16),
                                                                      ('Kefir', NULL, 16),
                                                                      ('Batidos', NULL, 16),
                                                                      ('Petit suisse', NULL, 16),
                                                                      ('Leche en polvo', NULL, 16);

-- =========================
-- INSERCIÓN DE PRODUCTOS - HIGIENE (ID: 17)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
-- Higiene bebé
('Biberón', NULL, 17),
('Limpiador de biberón', NULL, 17),
('Chupete', NULL, 17),
('Gel', NULL, 17),
('Crema', NULL, 17),
('Colonia', NULL, 17),
('Polvos de talco', NULL, 17),
('Bastoncillos', NULL, 17),
('Gasas', NULL, 17),
('Toallitas', NULL, 17),
('Pañales', NULL, 17),
('Papilla para bebé', NULL, 17),
-- Cuidado del cabello
('Acondicionador', NULL, 17),
('Mascarilla', NULL, 17),
('Serum', NULL, 17),
('Ampollas', NULL, 17),
('Champú', NULL, 17),
('Tinte para el pelo', NULL, 17),
('Quita manchas', NULL, 17),
('Laca', NULL, 17),
('Espuma de cabello', NULL, 17),
('Protector térmico', NULL, 17),
('Gomina', NULL, 17),
-- Afeitado
('Espuma de afeitar', NULL, 17),
('After shave', NULL, 17),
('Maquinillas de afeitar', NULL, 17),
-- Cuidado corporal
('Aceite corporal', NULL, 17),
('Crema corporal', NULL, 17),
('Exfoliante', NULL, 17),
('Crema de manos', NULL, 17),
('Crema de pies', NULL, 17),
-- Cuidado facial
('Desmaquillador', NULL, 17),
('Esponja', NULL, 17),
('Mascarilla facial', NULL, 17),
('Limpiador', NULL, 17),
('Tónico facial', NULL, 17),
('Crema de cara', NULL, 17),
-- Depilación
('Bandas de cera', NULL, 17),
('Crema depilatoria', NULL, 17),
('Gel para depilar', NULL, 17),
('Pinzas de cejas', NULL, 17),
('Cera facial', NULL, 17),
('Maquinillas', NULL, 17),
-- Higiene personal
('Desodorante', NULL, 17),
('Jabón de manos', NULL, 17),
('Esponjas', NULL, 17),
('Turbante', NULL, 17),
-- Higiene bucal
('Pasta de dientes', NULL, 17),
('Cepillo de dientes', NULL, 17),
('Enjuague bucal', NULL, 17),
('Tabletas limpiadoras', NULL, 17),
('Cepillos interdentales', NULL, 17),
-- Higiene femenina
('Compresas', NULL, 17),
('Protegeslip', NULL, 17),
('Tampones', NULL, 17),
('Pañales para adulto', NULL, 17),
-- Cuidado de uñas
('Laca de uñas', NULL, 17),
('Quitaesmalte', NULL, 17),
('Tijeras', NULL, 17),
('Corta cutículas', NULL, 17),
('Lima', NULL, 17),
('Cepillo', NULL, 17),
('Alicates', NULL, 17),
-- Perfumería
('Agua de colonia', NULL, 17),
('Perfume', NULL, 17),
('Colonia hombre', NULL, 17),
('Colonia mujer', NULL, 17),
('Lotes de higiene de baño', NULL, 17),
-- Protección solar
('Crema solar', NULL, 17),
('Protector solar', NULL, 17),
-- Farmacia y parafarmacia
('Colágeno', NULL, 17),
('Aceite de árbol de té', NULL, 17),
('Barritas de proteína', NULL, 17),
('Comprimidos', NULL, 17),
('Cápsulas', NULL, 17),
('Alcohol 96º', NULL, 17),
('Agua oxigenada', NULL, 17),
('Tiritas', NULL, 17),
('Vaselina', NULL, 17),
('Esparadrapo', NULL, 17),
('Algodón', NULL, 17),
('Povidona', NULL, 17),
('Bálsamo', NULL, 17),
('Apósitos', NULL, 17),
('Vendas', NULL, 17),
('Protectores de oídos', NULL, 17),
('Spray desinfectante', NULL, 17),
('Gel hidroalcohólico', NULL, 17),
('Preservativos', NULL, 17);

-- =========================
-- INSERCIÓN DE PRODUCTOS - MAQUILLAJE (ID: 18)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
                                                                      ('Maquillaje', NULL, 18),
                                                                      ('Corrector', NULL, 18),
                                                                      ('Rímel', NULL, 18),
                                                                      ('Rimmel', NULL, 18),
                                                                      ('Bronceador', NULL, 18),
                                                                      ('Bruma', NULL, 18),
                                                                      ('Colorete', NULL, 18),
                                                                      ('Iluminador', NULL, 18),
                                                                      ('Perfilador de labios', NULL, 18),
                                                                      ('Pintalabios', NULL, 18),
                                                                      ('Bálsamo labial', NULL, 18),
                                                                      ('Brillo de labios', NULL, 18),
                                                                      ('Perfilador de ojos', NULL, 18),
                                                                      ('Máscara de cejas', NULL, 18),
                                                                      ('Rizador de pestañas', NULL, 18),
                                                                      ('Sombra de ojos', NULL, 18),
                                                                      ('Sacapuntas', NULL, 18),
                                                                      ('Esponja de maquillaje', NULL, 18),
                                                                      ('Pinceles', NULL, 18),
                                                                      ('Kit de pinceles', NULL, 18);

-- =========================
-- INSERCIÓN DE PRODUCTOS - BEBIDAS ALCOHÓLICAS (ID: 19)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
                                                                      ('Cerveza', NULL, 19),
                                                                      ('Cerveza con limón', NULL, 19),
                                                                      ('Radler', NULL, 19),
                                                                      ('Cerveza sin alcohol', NULL, 19),
                                                                      ('Vermouth', NULL, 19),
                                                                      ('Ginebra', NULL, 19),
                                                                      ('Brandy', NULL, 19),
                                                                      ('Whisky', NULL, 19),
                                                                      ('Ron', NULL, 19),
                                                                      ('Licor crema', NULL, 19),
                                                                      ('Vodka', NULL, 19),
                                                                      ('Anís', NULL, 19),
                                                                      ('Licor', NULL, 19),
                                                                      ('Sidra', NULL, 19),
                                                                      ('Cava', NULL, 19),
                                                                      ('Tinto de verano', NULL, 19),
                                                                      ('Sangría', NULL, 19),
                                                                      ('Vino blanco', NULL, 19),
                                                                      ('Rioja', NULL, 19),
                                                                      ('Vino', NULL, 19),
                                                                      ('Lambrusco', NULL, 19),
                                                                      ('Vino tinto', NULL, 19);

-- =========================
-- INSERCIÓN DE PRODUCTOS - REFRESCOS Y AGUA (ID: 20)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
-- Refrescos
('Agua', NULL, 20),
('Agua con gas', NULL, 20),
('Gaseosa', NULL, 20),
('Aquarius', NULL, 20),
('Bebida energética', NULL, 20),
('Coca Cola', NULL, 20),
('Fanta', NULL, 20),
('7up', NULL, 20),
('Tónica', NULL, 20),
('Té', NULL, 20),
('Limonada', NULL, 20),
('Zumo de naranja', NULL, 20),
('Refrescos', NULL, 20),
-- Zumos
('Zumos', NULL, 20),
('Smoothie', NULL, 20),
('Bebida de fruta', NULL, 20),
('Zumo de piña', NULL, 20),
('Zumo de bifrutas', NULL, 20),
('Zumo de tomate', NULL, 20),
-- Bebidas calientes
('Cola cao', NULL, 20),
('Nesquik', NULL, 20),
('Cacao soluble', NULL, 20),
('Chocolate a la taza', NULL, 20),
('Café de cápsulas', NULL, 20),
('Café molido', NULL, 20),
('Café en grano', NULL, 20),
('Café soluble', NULL, 20),
('Capuccino', NULL, 20),
('Filtros de café', NULL, 20),
('Infusión', NULL, 20);

-- =========================
-- INSERCIÓN DE PRODUCTOS - ENCURTIDOS (ID: 21)
-- =========================
INSERT INTO producto (nombre_producto, descripcion, id_categoria) VALUES
                                                                      ('Aceitunas', NULL, 21),
                                                                      ('Banderillas', NULL, 21),
                                                                      ('Pepinillos', NULL, 21),
                                                                      ('Altramuces', NULL, 21),
                                                                      ('Alcaparras', NULL, 21),
                                                                      ('Guindillas', NULL, 21),
                                                                      ('Ajos', NULL, 21);