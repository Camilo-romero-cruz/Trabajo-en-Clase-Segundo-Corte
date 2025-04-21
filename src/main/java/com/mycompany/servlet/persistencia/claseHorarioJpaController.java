package com.mycompany.servlet.persistencia;

import com.mycompany.servlet.logica.claseHorario;
import com.mycompany.servlet.persistencia.exceptions.NonexistentEntityException;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class claseHorarioJpaController implements Serializable {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ejemploJavaWebPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(claseHorario h) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(h);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            claseHorario h = em.getReference(claseHorario.class, id);
            em.remove(h);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<claseHorario> findHorarioEntities() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<claseHorario> cq = em.getCriteriaBuilder().createQuery(claseHorario.class);
            cq.select(cq.from(claseHorario.class));
            return em.createQuery(cq).getResultList();
        } finally {
            em.close();
        }
    }

    public claseHorario findHorario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(claseHorario.class, id);
        } finally {
            em.close();
        }
    }
}