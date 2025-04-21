package com.mycompany.servlet.persistencia;

import com.mycompany.servlet.logica.claseOdontologo;
import com.mycompany.servlet.persistencia.exceptions.NonexistentEntityException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class claseOdontologoJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public claseOdontologoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public claseOdontologoJpaController() {
        emf = Persistence.createEntityManagerFactory("ejemploJavaWebPU");
    }

    // CREATE
    public void create(claseOdontologo odontologo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(odontologo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // EDIT
   public void edit(claseOdontologo odontologo) throws NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
        em = getEntityManager();
        em.getTransaction().begin();
        odontologo = em.merge(odontologo);
        em.getTransaction().commit();
    } catch (Exception ex) {
        String msg = ex.getLocalizedMessage();
        if (msg == null || msg.length() == 0) {
            int id = odontologo.getId();
            if (findclaseOdontologo(id) == null) {
                throw new NonexistentEntityException("El odontologo con id " + id + " no existe.");
            }
        }
        throw new Exception("Error al editar el odontologo: " + ex.getMessage(), ex);
    } finally {
        if (em != null) {
            em.close();
        }
    }
}


    // DELETE
    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            claseOdontologo odontologo;
            try {
                odontologo = em.getReference(claseOdontologo.class, id);
                odontologo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The claseOdontologo with id " + id + " no longer exists.", enfe);
            }
            em.remove(odontologo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // FIND ALL
    public List<claseOdontologo> findclaseOdontologoEntities() {
        return findclaseOdontologoEntities(true, -1, -1);
    }

    public List<claseOdontologo> findclaseOdontologoEntities(int maxResults, int firstResult) {
        return findclaseOdontologoEntities(false, maxResults, firstResult);
    }

    private List<claseOdontologo> findclaseOdontologoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(claseOdontologo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // FIND ONE
    public claseOdontologo findclaseOdontologo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(claseOdontologo.class, id);
        } finally {
            em.close();
        }
    }

    // COUNT
    public int getclaseOdontologoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<claseOdontologo> rt = cq.from(claseOdontologo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    // FIND BY DNI (optional if needed)
   public claseOdontologo findOdontologoByDni(String dni) {
    EntityManager em = getEntityManager();
    try {
        Query query = em.createQuery("SELECT o FROM claseOdontologo o WHERE o.dni = :dni");
        query.setParameter("dni", dni);
        List<claseOdontologo> result = query.getResultList();
        if (result.isEmpty()) {
            return null;  // No se encontró el odontólogo con ese DNI
        } else {
            return result.get(0);  // Retorna el primer odontólogo encontrado
        }
    } finally {
        em.close();
    }
}

}
