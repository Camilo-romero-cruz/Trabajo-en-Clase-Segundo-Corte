package com.mycompany.servlet.persistencia;

import com.mycompany.servlet.logica.claseUsuario;
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

public class claseUsuarioJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public claseUsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public claseUsuarioJpaController() {
        emf = Persistence.createEntityManagerFactory("ejemploJavaWebPU");
    }

    public void create(claseUsuario claseUsuario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(claseUsuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(claseUsuario claseUsuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            claseUsuario = em.merge(claseUsuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = claseUsuario.getId();
                if (findclaseUsuario(id) == null) {
                    throw new NonexistentEntityException("The claseUsuario with id " + id + " no longer exists.");
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
            claseUsuario claseUsuario;
            try {
                claseUsuario = em.getReference(claseUsuario.class, id);
                claseUsuario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The claseUsuario with id " + id + " no longer exists.", enfe);
            }
            em.remove(claseUsuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<claseUsuario> findclaseUsuarioEntities() {
        return findclaseUsuarioEntities(true, -1, -1);
    }

    public List<claseUsuario> findclaseUsuarioEntities(int maxResults, int firstResult) {
        return findclaseUsuarioEntities(false, maxResults, firstResult);
    }

    private List<claseUsuario> findclaseUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(claseUsuario.class));
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

    public claseUsuario findclaseUsuario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(claseUsuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getclaseUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<claseUsuario> rt = cq.from(claseUsuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public claseUsuario findUsuarioByDni(String dni) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT u FROM claseUsuario u WHERE u.dni = :dni");
            query.setParameter("dni", dni);
            List<claseUsuario> result = query.getResultList();
            if (result.isEmpty()) {
                return null;  // No se encontró el usuario con ese DNI
            } else {
                return result.get(0);  // Retorna el primer usuario encontrado
            }
        } finally {
            em.close();
        }
    }
}
