/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;



import ec.edu.ups.entidades.Bodega;
import ec.edu.ups.entidades.Producto;
import ec.edu.ups.facade.BodegaFacade;
import ec.edu.ups.facade.ProductoFacade;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edwin
 */
@Named
@SessionScoped
public class ProductoBeans implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private ProductoFacade productoFacade;
    @EJB
    private BodegaFacade bodegaFacade;

    private List<Producto> listp = new ArrayList<>();
    private List<Bodega> listb = new ArrayList<>();
    private Bodega bodega;
    private int id;
    private String nombre;
    private int stock;
    private double precio;

    @PostConstruct
    public void init() {
        this.bodega = new Bodega();
        listp = productoFacade.findAll();
        listb = bodegaFacade.findAll();
    }

    public ProductoFacade getProductoFacade() {
        return productoFacade;
    }

    public void setProductoFacade(ProductoFacade productoFacade) {
        this.productoFacade = productoFacade;
    }

    public List<Producto> getListp() {
        return listp;
    }

    public void setListp(List<Producto> listp) {
        this.listp = listp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public BodegaFacade getBodegaFacade() {
        return bodegaFacade;
    }

    public void setBodegaFacade(BodegaFacade bodegaFacade) {
        this.bodegaFacade = bodegaFacade;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public List<Bodega> getListb() {
        return listb;
    }

    public void setListb(List<Bodega> listb) {
        this.listb = listb;
    }

    public String add() {
        Producto p = new Producto(id, nombre, stock, precio);
        productoFacade.create(p);
        listp = productoFacade.findAll();
        this.limpiar();
        return "producto.xhtml?faces-redirect=true";
    }

    public void limpiar() {

        this.nombre = "";
        this.stock = 0;
        this.precio = 0;

    }

    public String edit(Producto s) {
        productoFacade.edit(s);

        listp = productoFacade.findAll();
        return "producto.xhtml?faces-redirect=true";
    }

    public String delete(Producto s) {
        productoFacade.remove(s);
        listp = productoFacade.findAll();
        return "producto.xhtml?faces-redirect=true";
    }

    public double sumar(Producto p) {
        double i = p.getPrecio() * p.getStock();
        return i;
    }
}
