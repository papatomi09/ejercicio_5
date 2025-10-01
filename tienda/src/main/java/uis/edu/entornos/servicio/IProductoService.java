package uis.edu.entornos.servicio;

import java.util.List;
import uis.edu.entornos.modelo.Producto;

public interface IProductoService {

    // Obtener la lista de todos los productos
    List<Producto> getProductos();

    // Crear o actualizar un nuevo producto
    // Se usa el mismo método 'save' o 'guardar' para crear y actualizar en la
    // implementación
    Producto guardarProducto(Producto producto);

    // Buscar un producto por su ID
    Producto buscarProducto(Long id);

    // Eliminar un producto por su ID
    // Retorna un entero (o void/boolean) para indicar el resultado de la operación
    void borrarProducto(Long id);
    // o
    // int borrarProducto(Long id); // Como en tu ejemplo
}
