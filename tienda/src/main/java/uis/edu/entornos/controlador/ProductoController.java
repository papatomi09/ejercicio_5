package uis.edu.entornos.controlador;

import uis.edu.entornos.modelo.Producto; // Asume que Producto está en este paquete
import uis.edu.entornos.repositorio.ProductoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoRepositorio productoRepository;

    // Inyección de dependencias a través del constructor (práctica recomendada)
    @Autowired
    public ProductoController(ProductoRepositorio productoRepository) {
        this.productoRepository = productoRepository;
    }

    // --- 1. OBTENER TODOS LOS PRODUCTOS (READ All) ---
    // GET /api/productos
    @GetMapping
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    // --- 2. OBTENER UN PRODUCTO POR ID (READ One) ---
    // GET /api/productos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        Optional<Producto> productoData = productoRepository.findById(id);

        return productoData.map(producto -> new ResponseEntity<>(producto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // --- 3. CREAR UN NUEVO PRODUCTO (CREATE) ---
    // POST /api/productos
    // El cuerpo de la solicitud debe contener un objeto Producto (incluyendo el
    // Proveedor ID)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto createProducto(@RequestBody Producto producto) {
        // Spring Data JPA guarda la entidad y devuelve la versión con el ID generado.
        return productoRepository.save(producto);
    }

    // --- 4. ACTUALIZAR UN PRODUCTO EXISTENTE (UPDATE) ---
    // PUT /api/productos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
        Optional<Producto> productoData = productoRepository.findById(id);

        if (productoData.isPresent()) {
            Producto producto = productoData.get();

            // Actualizar campos
            producto.setNombre(productoDetails.getNombre());
            producto.setIvaCompra(productoDetails.getIvaCompra());
            producto.setPrecioCompra(productoDetails.getPrecioCompra());
            producto.setPrecioVenta(productoDetails.getPrecioVenta());

            // Importante: También actualiza el proveedor si es necesario,
            // aunque en un entorno real esto puede requerir más validación/lógica.
            // Si el JSON incluye el objeto Proveedor, JPA lo manejará.
            if (productoDetails.getProveedor() != null) {
                producto.setProveedor(productoDetails.getProveedor());
            }

            return new ResponseEntity<>(productoRepository.save(producto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // --- 5. ELIMINAR UN PRODUCTO (DELETE) ---
    // DELETE /api/productos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProducto(@PathVariable Long id) {
        try {
            productoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content para eliminación exitosa
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
