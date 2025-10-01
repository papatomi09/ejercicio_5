package uis.edu.entornos.modelo;

import jakarta.persistence.*; // O javax.persistence.* si usas Spring Boot 2
import java.math.BigDecimal; // Recomendado para valores monetarios

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación Many-to-One: Muchos productos a un solo proveedor
    @ManyToOne(fetch = FetchType.LAZY) // Lazy loading es común para ManyToOne
    @JoinColumn(name = "idProveedor", nullable = false) // 'idProveedor' es la columna FK en la DB
    private Proveedor proveedor; // Aquí se mapea el objeto Proveedor

    private String nombre;

    private BigDecimal ivaCompra; // Tasa o porcentaje del IVA de compra

    private BigDecimal precioCompra;

    private BigDecimal precioVenta;

    // Constructor sin argumentos
    public Producto() {
    }

    // Constructor con campos (sin ID)
    public Producto(Proveedor proveedor, String nombre, BigDecimal ivaCompra, BigDecimal precioCompra,
            BigDecimal precioVenta) {
        this.proveedor = proveedor;
        this.nombre = nombre;
        this.ivaCompra = ivaCompra;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    // --- Getters y Setters---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getIvaCompra() {
        return ivaCompra;
    }

    public void setIvaCompra(BigDecimal ivaCompra) {
        this.ivaCompra = ivaCompra;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }
}
