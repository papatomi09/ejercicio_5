package uis.edu.entornos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uis.edu.entornos.modelo.Proveedor;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long> {
    // Puedes agregar métodos de búsqueda personalizados aquí, por ejemplo:
    // Proveedor findByNit(String nit);
}
