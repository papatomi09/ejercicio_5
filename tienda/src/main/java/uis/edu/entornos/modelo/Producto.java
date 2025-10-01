package uis.edu.entornos.modelo;

import jakarta.persistence.*; // O javax.persistence.* si usas Spring Boot 2
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal; // Recomendado para valores monetarios

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación Many-to-One
    // No usamos @NotNull aquí, sino en el ID del proveedor en caso de DTO,
    // pero @JoinColumn con nullable = false ya es una restricción DB
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProveedor", nullable = false)
    private Proveedor proveedor;

    // Nombre del Producto
    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Column(length = 100, nullable = false)
    private String nombre;

    // IVA de Compra (Usamos BigDecimal para precisión financiera)
    @NotNull(message = "El IVA de compra es obligatorio")
    @DecimalMin(value = "0.00", message = "El IVA no puede ser negativo")
    @DecimalMax(value = "1.00", message = "El IVA debe ser como máximo 1.00 (100%)")
    @Column(precision = 5, scale = 2) // Ejemplo: 0.19
    private BigDecimal ivaCompra;

    // Precio de Compra
    @NotNull(message = "El precio de compra es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio de compra debe ser mayor a cero")
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal precioCompra;

    // Precio de Venta
    @NotNull(message = "El precio de venta es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio de venta debe ser mayor a cero")
    // Opcional: Validación para que el precio de venta sea mayor o igual al de
    // compra (requiere lógica personalizada o validación a nivel de servicio)
    @Column(precision = 10, scale = 2, nullable = false)
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
