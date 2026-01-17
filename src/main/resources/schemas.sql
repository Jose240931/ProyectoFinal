-- =========================
-- TABLA USUARIO
-- =========================
CREATE TABLE IF NOT EXISTS usuario (
                                       id_usuario INTEGER PRIMARY KEY AUTOINCREMENT,
                                       nombre TEXT NOT NULL,
                                       email TEXT NOT NULL UNIQUE
);

-- =========================
-- TABLA CATEGORIA
-- =========================
CREATE TABLE IF NOT EXISTS categoria (
                                         id_categoria INTEGER PRIMARY KEY AUTOINCREMENT,
                                         nombre_categoria TEXT NOT NULL UNIQUE
);

-- =========================
-- TABLA PRODUCTO
-- =========================
CREATE TABLE IF NOT EXISTS producto (
                                        id_producto INTEGER PRIMARY KEY AUTOINCREMENT,
                                        nombre_producto TEXT NOT NULL,
                                        descripcion TEXT,
                                        id_categoria INTEGER NOT NULL,
                                        FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
    );

-- =========================
-- TABLA LISTA
-- =========================
CREATE TABLE IF NOT EXISTS lista (
                                     id_lista INTEGER PRIMARY KEY AUTOINCREMENT,
                                     id_usuario INTEGER NOT NULL,
                                     nombre_lista TEXT NOT NULL,
                                     fecha_creacion TEXT NOT NULL,
                                     fecha_modificacion TEXT,
                                     FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
    );

-- =========================
-- TABLA LISTA_CATEGORIA
-- =========================
CREATE TABLE IF NOT EXISTS lista_categoria (
                                               id_lista INTEGER NOT NULL,
                                               id_categoria INTEGER NOT NULL,
                                               PRIMARY KEY (id_lista, id_categoria),
    FOREIGN KEY (id_lista) REFERENCES lista(id_lista),
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
    );
