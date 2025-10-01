package uis.edu.entornos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uis.edu.entornos.modelo.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
    // Puedes agregar métodos de búsqueda personalizados aquí, por ejemplo:
    // List<Producto> findByProveedor(Proveedor proveedor);
}
