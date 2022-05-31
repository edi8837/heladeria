/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Jonny
 */
@Entity
@NamedQuery(name = "getProducto", query = "SELECT p FROM  Producto p")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private int stock;
    private Double precio;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private Collection<Bodega> bodega;

    public Producto() {

    }

    public Producto(long id, String nombre, int stock, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public long getCodigo() {
        return id;
    }

    public void setCodigo(long id) {
        this.id = id;
    }

    public Collection<Bodega> getBodega() {
        return bodega;
    }

    public void setBodega(Collection<Bodega> bodega) {
        this.bodega = bodega;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", stock=" + stock + ", precio=" + precio + ", bodega=" + bodega + '}';
    }

}
