package com.mycompany.servlet.persistencia;

import com.mycompany.servlet.logica.claseTurno;
import com.mycompany.servlet.persistencia.exceptions.NonexistentEntityException;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class claseTurnoJpaController implements Serializable {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ejemploJavaWebPU");
    public EntityManager getEntityManager() { return emf.createEntityManager(); }

    public void create(claseTurno t) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            claseTurno t = em.getReference(claseTurno.class, id);
            em.remove(t);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public List<claseTurno> findTurnoEntities() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<claseTurno> cq = em.getCriteriaBuilder().createQuery(claseTurno.class);
            cq.select(cq.from(claseTurno.class));
            return em.createQuery(cq).getResultList();
        } finally { em.close(); }
    }

    public claseTurno findTurno(int id) {
        EntityManager em = getEntityManager();
        try { return em.find(claseTurno.class, id); }
        finally { em.close(); }
    }

    public List<claseTurno> findTurnosByOdontologoAndFecha(int idOd, String fecha) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery(
                "SELECT t FROM claseTurno t WHERE t.odontologo.id = :idOd AND t.fecha = :fecha", claseTurno.class
            )
            .setParameter("idOd", idOd)
            .setParameter("fecha", fecha)
            .getResultList();
        } finally { em.close(); }
    }
}