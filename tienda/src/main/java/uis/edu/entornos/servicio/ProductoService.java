package uis.edu.entornos.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uis.edu.entornos.modelo.Producto;
import uis.edu.entornos.repositorio.ProductoRepositorio;

import java.util.List;

// Indica que esta clase es un bean de servicio de Spring
@Service
// @Transactional asegura que los métodos se ejecuten dentro de una transacción
// de DB
@Transactional
public class ProductoService implements IProductoService {

    // Inyección de dependencias del repositorio para acceder a la DB
    @Autowired
    private ProductoRepositorio productoRepository;

    // --- Implementación de IProductoService ---

    @Override
    @Transactional(readOnly = true) // Optimiza las consultas de solo lectura
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        // Usa el método save() del JpaRepository, que inserta o actualiza
        return productoRepository.save(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto buscarProducto(Long id) {
        // findById devuelve un Optional, usamos orElse(null) para devolver null si no
        // se encuentra
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void borrarProducto(Long id) {
        // No necesitamos devolver un entero (como en tu ejemplo de Usuario),
        // pero podemos mantener la lógica de tu ejemplo si prefieres un int.
        // Si usamos 'void', simplemente eliminamos:
        productoRepository.deleteById(id);
    }

    /*
     * // Si quieres mantener el retorno int (como en tu ejemplo de UsuarioService):
     * 
     * @Override
     * public int borrarProducto(Long id) {
     * try {
     * productoRepository.deleteById(id);
     * return 1; // 1 = Éxito
     * } catch (Exception e) {
     * // Manejar la excepción si el ID no existe o hay otro error
     * return 0; // 0 = Fallo
     * }
     * }
     */
}
