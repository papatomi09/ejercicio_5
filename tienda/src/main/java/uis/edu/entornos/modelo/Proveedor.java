package uis.edu.entornos.modelo;

import jakarta.persistence.*; // O javax.persistence.* si usas Spring Boot 2
import java.util.Set;

@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nit; // Usando String para el NIT/Tax ID por ser alfanumérico o largo

    private String nombre;

    private String direccion;

    private String ciudad;

    private String telefono;

    // Relación One-to-Many: Un proveedor puede tener muchos productos
    // El 'mappedBy' indica el campo en la entidad Producto que gestiona la relación
    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Producto> productos;

    // Getters y Setters
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Constructor sin argumentos
    public Proveedor() {
    }

    // Constructor con campos
    public Proveedor(String nit, String nombre, String direccion, String ciudad, String telefono) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    // --- Getters y Setters (Ejemplo para id) ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ... otros getters y setters
}
