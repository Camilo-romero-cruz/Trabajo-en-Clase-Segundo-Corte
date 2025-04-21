package com.mycompany.servlet.persistencia;

import com.mycompany.servlet.logica.clasePaciente;
import com.mycompany.servlet.persistencia.exceptions.NonexistentEntityException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class clasePacienteJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public clasePacienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public clasePacienteJpaController() {
        emf = Persistence.createEntityManagerFactory("ejemploJavaWebPU"); // Asegúrate que coincida con tu persistence.xml
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(clasePaciente paciente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(clasePaciente paciente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            paciente = em.merge(paciente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = paciente.getId();
                if (findclasePaciente(id) == null) {
                    throw new NonexistentEntityException("El paciente con id " + id + " no existe.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            clasePaciente paciente;
            try {
                paciente = em.getReference(clasePaciente.class, id);
                paciente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El paciente con id " + id + " no existe.", enfe);
            }
            em.remove(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<clasePaciente> findclasePacienteEntities() {
        return findclasePacienteEntities(true, -1, -1);
    }

    public List<clasePaciente> findclasePacienteEntities(int maxResults, int firstResult) {
        return findclasePacienteEntities(false, maxResults, firstResult);
    }

    private List<clasePaciente> findclasePacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<clasePaciente> cq = em.getCriteriaBuilder().createQuery(clasePaciente.class);
            cq.select(cq.from(clasePaciente.class));
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

    public clasePaciente findclasePaciente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(clasePaciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getclasePacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<clasePaciente> rt = cq.from(clasePaciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public clasePaciente findPacienteByDni(String dni) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM clasePaciente p WHERE p.dni = :dni");
            query.setParameter("dni", dni);
            List<clasePaciente> result = query.getResultList();
            if (result.isEmpty()) {
                return null;
            } else {
                return result.get(0);
            }
        } finally {
            em.close();
        }
    }
}
