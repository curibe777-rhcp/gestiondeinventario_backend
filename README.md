# Sistema de Gestión de Inventario - Maquillaje y Cosméticos

# Integrantes
- Cristhian Uribe Auqui
- Angela Vergara Tejada
- Yrahi Quispe Reyna

# Alcance del Proyecto
Este sistema permite gestionar el inventario de productos de maquillaje y cosméticos de una empresa.  
Con él se busca mantener un control eficiente del stock, proveedores y categorías de productos, optimizando la administración del negocio.  

Las funcionalidades principales son:
- Registrar, editar y eliminar productos de maquillaje y cosméticos.
- Clasificar productos por categorías (labiales, bases, sombras, etc.) y subcategorías (líquidos, en polvo, mate, etc.).
- Gestionar proveedores de marcas de maquillaje.
- Controlar el stock mínimo de cada producto para evitar quiebres de inventario.
- Visualizar reportes de inventario y movimientos de productos.
- Administrar usuarios del sistema (empleados o responsables de almacén).

# Diseño de la Base de Datos
<p align="center">
  <img src="https://github.com/user-attachments/assets/d65f6128-be46-4f3d-95a1-2f2cb3ffb244" alt="Diseño de la BD" width="600">
</p>

# Endpoints

## Endpoints - Producto

| Método | URL       | Request DTO                     | Response DTO                     | Función                                      |
|--------|-----------|---------------------------------|---------------------------------|---------------------------------------------|
| POST   | /productos | InsertarProductoRequestDto       | InsertarProductoResponseDto      | Crea un nuevo producto en la base de datos. |
| PUT    | /productos | EditarProductoRequestDto         | EditarProductoResponseDto        | Actualiza un producto existente.            |
| DELETE | /productos | EliminarProductoRequestDto       | EliminarProductoResponseDto      | Marca un producto como desactivado (soft delete). |
| GET    | /productos| (vacío)                          | List<ListarProductosResponseDto> | Lista los productos activos (`esDesactivado = 0`). |

## Endpoints - Categoría

| Método | URL        | Request DTO                     | Response DTO                     | Función                                     |
|--------|------------|---------------------------------|---------------------------------|--------------------------------------------|
| POST   | /categorias | InsertarCategoriaRequestDto      | InsertarCategoriaResponseDto     | Crea una nueva categoría.                  |
| PUT    | /categorias | EditarCategoriaRequestDto        | EditarCategoriaResponseDto       | Actualiza una categoría existente.         |
| DELETE | /categorias | EliminarCategoriaRequestDto      | EliminarCategoriaResponseDto     | Marca una categoría como desactivada.      |
| GET    | /categorias | (vacío)                          | List<ListarCategoriaResponseDto> | Lista las categorías activas (`esDesactivado = 0`). |

## Endpoints - Marca

| Método | URL    | Request DTO                  | Response DTO                 | Función                                     |
|--------|--------|------------------------------|------------------------------|--------------------------------------------|
| POST   | /marcas | InsertarMarcaRequestDto      | InsertarMarcaResponseDto     | Crea una nueva marca de productos.         |
| PUT    | /marcas | EditarMarcaRequestDto        | EditarMarcaResponseDto       | Actualiza una marca existente.             |
| DELETE | /marcas | EliminarMarcaRequestDto      | EliminarMarcaResponseDto     | Marca una marca como desactivada.          |
| GET    | /marcas | (vacío)                      | List<ListarMarcaResponseDto> | Lista las marcas activas (`esDesactivado = 0`). |

## Endpoints - Subcategoría

| Método | URL            | Request DTO                    | Response DTO                        | Función                                                |
| ------ | -------------- | ------------------------------ | ----------------------------------- | ------------------------------------------------------ |
| POST   | /subcategorias | InsertarSubcategoriaRequestDto | InsertarSubcategoriaResponseDto     | Crea una nueva subcategoría.                           |
| PUT    | /subcategorias | EditarSubcategoriaRequestDto   | EditarSubcategoriaResponseDto       | Actualiza una subcategoría existente.                  |
| DELETE | /subcategorias | EliminarSubcategoriaRequestDto | EliminarSubcategoriaResponseDto     | Marca una subcategoría como desactivada (soft delete). |
| GET    | /subcategorias | (vacío)                        | List<ListarSubcategoriaResponseDto> | Lista las subcategorías activas (`esDesactivado = 0`). |





# Documentación de la API con Swagger

## Integrantes
- **Angela Vergara Tejada**  
- **Cristhian Uribe Auqui**  
- **Yrahi Quispe Reyna**  

## Descripción
La API cuenta con integración de **Swagger** para la generación automática de documentación interactiva.  
Esto permite a los desarrolladores y usuarios visualizar de forma clara todos los endpoints disponibles, junto con sus parámetros, modelos de datos y posibles respuestas.  

## Acceso a la Documentación
1. Levantar el proyecto (ejecutar la aplicación Spring Boot).  
2. Abrir en el navegador la siguiente URL:
3. http://localhost:8080/swagger-ui/index.html

## Funcionalidades de Swagger
Con Swagger podrás:  
- Explorar todos los **endpoints de la API** clasificados por módulo.  
- Consultar la **estructura de las peticiones y respuestas** (DTOs).  
- Realizar **pruebas en tiempo real** de los endpoints directamente desde la interfaz gráfica.  
- Obtener ejemplos de **códigos de respuesta HTTP** (200, 400, 404, 500, etc.).  
- Facilitar la comunicación entre desarrolladores gracias a la documentación centralizada.  

## Ventajas
- Documentación **siempre actualizada** de la API.  
- Interfaz intuitiva y fácil de usar.  
- Permite **probar la API sin necesidad de herramientas externas** como Postman o cURL.  

