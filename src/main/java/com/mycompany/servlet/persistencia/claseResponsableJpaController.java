package com.mycompany.servlet.persistencia;

import com.mycompany.servlet.logica.claseResponsable;
import com.mycompany.servlet.persistencia.exceptions.NonexistentEntityException;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class claseResponsableJpaController implements Serializable {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ejemploJavaWebPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(claseResponsable r) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void edit(claseResponsable r) throws NonexistentEntityException, Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(r);
            em.getTransaction().commit();
        } catch (Exception ex) {
            int id = r.getId();
            if (findResponsable(id) == null) {
                throw new NonexistentEntityException("El responsable con id " + id + " ya no existe.");
            }
            throw ex;
        } finally {
            em.close();
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            claseResponsable r = em.getReference(claseResponsable.class, id);
            em.remove(r);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public claseResponsable findResponsable(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(claseResponsable.class, id);
        } finally {
            em.close();
        }
    }

    public List<claseResponsable> findResponsableEntities() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<claseResponsable> cq = em.getCriteriaBuilder().createQuery(claseResponsable.class);
            cq.select(cq.from(claseResponsable.class));
            return em.createQuery(cq).getResultList();
        } finally {
            em.close();
        }
    }
}
