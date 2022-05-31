package ec.edu.ups.facade;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import ec.edu.ups.entidades.Bodega;
import ec.edu.ups.entidades.Producto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Gabus
 */
@Stateless 
public class BodegaFacade extends AbstractFacade<Bodega> {
    @PersistenceContext(name="TestJpa")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BodegaFacade() {
        super(Bodega.class);
    }
    
    public List<Bodega> listar() {
        return em.createQuery("select p from Bodega p left outer join fetch p.producto", Bodega.class).getResultList();
    }
    
    public void guardar(Producto producto) {
       
            em.merge(producto);
        
    }
    
    public Bodega porId(Long id) {
        //return em.find(Producto.class, id);
        return em.createQuery("select p from bodega p left outer join fetch p.producto where p.id=:id", Bodega.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    public void eliminar(Long id) {
        Bodega bodega = porId(id);
        em.remove(bodega);
    }
    
    public Optional<Bodega> opcional(Long id) {
        return Optional.ofNullable(porId(id));
    }
}
