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
 * @author Edisson
 */
@Entity
@NamedQuery(name = "getBodega", query = "SELECT b FROM  Bodega b")
public class Bodega implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String Cuidad;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "bodega")
    @JoinColumn
    private Collection<Producto> productos;

    
    public Bodega() {
    }
    
    public Bodega(long codigo, String nombre, String Cuidad) {
        this.id = id;
        this.nombre = nombre;
        this.Cuidad = Cuidad;
    }

    public long getCodigo() {
        return id;
    }

    public void setCodigo(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuidad() {
        return Cuidad;
    }

    public void setCuidad(String Cuidad) {
        this.Cuidad = Cuidad;
    }

    public Collection<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Collection<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Bodega{" + "id=" + id + ", nombre=" + nombre + ", Cuidad=" + Cuidad + '}';
    }

    
        
}
