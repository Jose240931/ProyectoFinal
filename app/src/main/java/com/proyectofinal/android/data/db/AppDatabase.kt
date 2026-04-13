package com.proyectofinal.android.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.proyectofinal.android.data.db.dao.CategoriaDao
import com.proyectofinal.android.data.db.dao.ListaDao
import com.proyectofinal.android.data.db.dao.ProductoDao
import com.proyectofinal.android.data.db.entity.Categoria
import com.proyectofinal.android.data.db.entity.Lista
import com.proyectofinal.android.data.db.entity.ListaItem
import com.proyectofinal.android.data.db.entity.Producto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [Categoria::class, Producto::class, Lista::class, ListaItem::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun categoriaDao(): CategoriaDao
    abstract fun productoDao(): ProductoDao
    abstract fun listaDao(): ListaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "lista_ordenada.db"
                )
                    .addCallback(SeedCallback())
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    private class SeedCallback : Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            CoroutineScope(Dispatchers.IO).launch {
                seedDatabase(db)
            }
        }

        private fun seedDatabase(db: SupportSQLiteDatabase) {
            val categories = listOf(
                "Fruteria", "Comida preparada", "Congelados", "Pescaderia",
                "Panaderia", "Conservas", "Charcuteria", "Carniceria",
                "Quesos", "Especias", "Pasta", "Legumbres", "Galletas",
                "Aperitivos", "Limpieza y hogar", "Lacteos", "Higiene",
                "Maquillaje", "Bebidas alcoholicas", "Refrescos y agua", "Encurtidos"
            )
            categories.forEach { cat ->
                db.execSQL("INSERT OR IGNORE INTO categoria (nombre_categoria) VALUES (?)", arrayOf(cat))
            }

            val productos = mapOf(
                "Fruteria" to listOf(
                    "Plátano", "Uva", "Manzana", "Pera", "Melón", "Sandía", "Limón", "Mandarina",
                    "Naranjas", "Pomelo", "Lima", "Kiwi", "Aguacate", "Piña", "Mango", "Papaya",
                    "Cerezas", "Fresas", "Fresón", "Frambuesas", "Moras", "Arándanos",
                    "Lechuga", "Ensalada", "Canónigos", "Cogollos", "Rúcula", "Espinacas",
                    "Patata", "Batata", "Cebolla", "Ajo", "Tomate", "Pepino", "Pimiento",
                    "Zanahoria", "Calabacín", "Berenjena", "Coliflor", "Brócoli", "Champiñones",
                    "Puerro", "Apio", "Rábanos", "Espárragos", "Judías verdes", "Guisantes",
                    "Alcachofas", "Maíz", "Remolacha"
                ),
                "Comida preparada" to listOf(
                    "Pizza", "Lasaña", "Croquetas", "Empanadas", "Tortilla de patata",
                    "Paella", "Gazpacho", "Salmorejo", "Hummus", "Guacamole", "Sushi",
                    "Rollitos de primavera", "Gyozas", "Kebab", "Hamburguesa preparada",
                    "Nuggets", "Albóndigas", "Canelones", "Macarrones con tomate"
                ),
                "Congelados" to listOf(
                    "Guisantes congelados", "Espinacas congeladas", "Judías congeladas",
                    "Maíz congelado", "Edamame", "Patatas congeladas", "Croquetas congeladas",
                    "Pizza congelada", "Lasaña congelada", "Pollo congelado", "Merluza congelada",
                    "Gambas congeladas", "Calamares congelados", "Pulpo congelado",
                    "Helado", "Tarta helada"
                ),
                "Pescaderia" to listOf(
                    "Merluza", "Dorada", "Lubina", "Salmón", "Atún", "Bacalao", "Lenguado",
                    "Sardinas", "Boquerones", "Caballa", "Trucha", "Pez espada", "Rape",
                    "Gambas", "Langostinos", "Mejillones", "Almejas", "Berberechos",
                    "Calamares", "Sepia", "Pulpo", "Navajas", "Percebes", "Cangrejo", "Bogavante"
                ),
                "Panaderia" to listOf(
                    "Pan barra", "Pan de molde", "Pan integral", "Baguette", "Chapata",
                    "Pan de semillas", "Pan de centeno", "Pan de espelta", "Pan sin gluten",
                    "Croissant", "Napolitana", "Berlina", "Donuts", "Palmera", "Muffin",
                    "Bizcocho", "Magdalenas", "Tostadas"
                ),
                "Conservas" to listOf(
                    "Atún en lata", "Sardinillas", "Mejillones en escabeche", "Berberechos en lata",
                    "Pimientos del piquillo", "Tomate frito", "Tomate natural triturado",
                    "Espárragos blancos", "Maíz en lata", "Judías blancas", "Garbanzos cocidos",
                    "Lentejas cocidas", "Aceitunas", "Pepinillos", "Anchoas"
                ),
                "Charcuteria" to listOf(
                    "Jamón serrano", "Jamón cocido", "Salchichón", "Chorizo", "Fuet",
                    "Mortadela", "Pavo cocido", "Bacon", "Lomo embuchado", "Morcilla",
                    "Sobrasada", "Paté", "Cecina", "Salami"
                ),
                "Carniceria" to listOf(
                    "Pollo entero", "Pechuga de pollo", "Muslos de pollo", "Alitas de pollo",
                    "Ternera", "Filete de ternera", "Carne picada", "Cerdo", "Lomo de cerdo",
                    "Costillas", "Cordero", "Chuletas", "Conejo", "Pavo", "Salchicha fresca",
                    "Hamburguesa fresca", "Butifarra"
                ),
                "Quesos" to listOf(
                    "Queso manchego", "Queso brie", "Queso camembert", "Queso gouda",
                    "Queso emmental", "Queso mozzarella", "Queso parmesano", "Queso azul",
                    "Queso de cabra", "Queso fresco", "Queso ricotta", "Queso philadelphia",
                    "Queso provolone", "Queso havarti", "Queso babybel"
                ),
                "Especias" to listOf(
                    "Sal", "Pimienta negra", "Pimentón dulce", "Pimentón picante", "Comino",
                    "Orégano", "Tomillo", "Romero", "Laurel", "Canela", "Curry", "Cúrcuma",
                    "Jengibre", "Ajo en polvo", "Cebolla en polvo", "Perejil seco",
                    "Nuez moscada", "Cardamomo", "Clavo", "Azafrán"
                ),
                "Pasta" to listOf(
                    "Espaguetis", "Macarrones", "Penne", "Fusilli", "Farfalle", "Linguine",
                    "Rigatoni", "Tallarines", "Lasaña seca", "Canelones secos", "Fideos",
                    "Arroz blanco", "Arroz integral", "Arroz basmati", "Arroz para paella",
                    "Quinoa", "Cuscús", "Bulgur"
                ),
                "Legumbres" to listOf(
                    "Garbanzos", "Lentejas", "Judías blancas", "Judías pintas", "Judías negras",
                    "Alubias rojas", "Habas secas", "Guisantes secos", "Soja", "Azuki"
                ),
                "Galletas" to listOf(
                    "Galletas María", "Galletas integrales", "Galletas de chocolate",
                    "Galletas rellenas", "Oreos", "Digestive", "Crackers", "Tortitas de arroz",
                    "Barquillos", "Galletas de avena", "Galletas de mantequilla"
                ),
                "Aperitivos" to listOf(
                    "Patatas fritas", "Nachos", "Palomitas", "Frutos secos", "Almendras",
                    "Cacahuetes", "Pistachos", "Nueces", "Anacardos", "Mix de frutos secos",
                    "Aceitunas", "Pipas", "Ganchitos", "Cheetos", "Doritos"
                ),
                "Limpieza y hogar" to listOf(
                    "Detergente lavadora", "Suavizante", "Lavavajillas", "Bayeta",
                    "Papel de cocina", "Papel higiénico", "Bolsas de basura", "Fregona",
                    "Limpiador multiusos", "Lejía", "Ambientador", "Limpiacristales",
                    "Pastillas lavavajillas", "Quitamanchas", "Fregaplatos"
                ),
                "Lacteos" to listOf(
                    "Leche entera", "Leche semidesnatada", "Leche desnatada", "Leche sin lactosa",
                    "Bebida de avena", "Bebida de soja", "Bebida de almendras",
                    "Yogur natural", "Yogur griego", "Yogur de frutas", "Kéfir",
                    "Mantequilla", "Margarina", "Nata para cocinar", "Nata montada",
                    "Queso fresco batido", "Cuajada", "Flan", "Natillas"
                ),
                "Higiene" to listOf(
                    "Gel de ducha", "Champú", "Acondicionador", "Jabón de manos",
                    "Pasta de dientes", "Cepillo de dientes", "Hilo dental", "Enjuague bucal",
                    "Desodorante", "Colonia", "Crema hidratante", "Crema solar",
                    "Maquinilla de afeitar", "Espuma de afeitar", "Compresas", "Tampones", "Pañales"
                ),
                "Maquillaje" to listOf(
                    "Base de maquillaje", "Corrector", "Máscara de pestañas", "Eyeliner",
                    "Sombra de ojos", "Perfilador de labios", "Pintalabios", "Brillo de labios",
                    "Colorete", "Iluminador", "Polvo compacto", "Desmaquillante",
                    "Agua micelar", "Sérum", "Contorno de ojos"
                ),
                "Bebidas alcoholicas" to listOf(
                    "Cerveza", "Vino tinto", "Vino blanco", "Vino rosado", "Cava", "Champán",
                    "Whisky", "Ron", "Vodka", "Gin", "Tequila", "Vermut", "Licor de naranja",
                    "Sidra", "Cerveza sin alcohol", "Sangría"
                ),
                "Refrescos y agua" to listOf(
                    "Agua mineral", "Agua con gas", "Coca-Cola", "Coca-Cola Zero", "Pepsi",
                    "Fanta naranja", "Fanta limón", "Sprite", "7UP", "Red Bull", "Nestea",
                    "Zumo de naranja", "Zumo de piña", "Zumo multivitamínico", "Batido de chocolate",
                    "Horchata", "Té frío", "Limonada"
                ),
                "Encurtidos" to listOf(
                    "Pepinillos", "Cebolletas", "Aceitunas manzanilla", "Aceitunas negras",
                    "Pimientos en vinagre", "Berenjenas en vinagre", "Coliflor encurtida",
                    "Zanahoria en vinagre", "Jalapeños", "Alcaparras", "Banderillas"
                )
            )

            val catIds = mutableMapOf<String, Int>()
            val cursor = db.query("SELECT id_categoria, nombre_categoria FROM categoria")
            while (cursor.moveToNext()) {
                catIds[cursor.getString(1)] = cursor.getInt(0)
            }
            cursor.close()

            productos.forEach { (catName, prods) ->
                val catId = catIds[catName] ?: return@forEach
                prods.forEach { prod ->
                    db.execSQL(
                        "INSERT OR IGNORE INTO producto (nombre_producto, id_categoria) VALUES (?, ?)",
                        arrayOf(prod, catId)
                    )
                }
            }
        }
    }
}
