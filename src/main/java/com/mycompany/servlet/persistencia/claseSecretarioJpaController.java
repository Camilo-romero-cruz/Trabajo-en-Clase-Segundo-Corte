package com.mycompany.servlet.persistencia;

import com.mycompany.servlet.logica.claseSecretario;
import com.mycompany.servlet.persistencia.exceptions.NonexistentEntityException;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class claseSecretarioJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public claseSecretarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public claseSecretarioJpaController() {
        emf = Persistence.createEntityManagerFactory("ejemploJavaWebPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(claseSecretario secretario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(secretario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(claseSecretario secretario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            secretario = em.merge(secretario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = secretario.getId_secretario();
                if (findclaseSecretario(id) == null) {
                    throw new NonexistentEntityException("El secretario con ID " + id + " ya no existe.");
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
            claseSecretario secretario;
            try {
                secretario = em.getReference(claseSecretario.class, id);
                secretario.getId_secretario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El secretario con ID " + id + " no existe.", enfe);
            }
            em.remove(secretario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<claseSecretario> findclaseSecretarioEntities() {
        return findclaseSecretarioEntities(true, -1, -1);
    }

    public List<claseSecretario> findclaseSecretarioEntities(int maxResults, int firstResult) {
        return findclaseSecretarioEntities(false, maxResults, firstResult);
    }

    private List<claseSecretario> findclaseSecretarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(claseSecretario.class));
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

    public claseSecretario findclaseSecretario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(claseSecretario.class, id);
        } finally {
            em.close();
        }
    }

    public int getclaseSecretarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<claseSecretario> rt = cq.from(claseSecretario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public claseSecretario findSecretarioByDni(String dni) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT s FROM claseSecretario s WHERE s.dni = :dni");
            query.setParameter("dni", dni);
            List<claseSecretario> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } finally {
            em.close();
        }
    }
}
