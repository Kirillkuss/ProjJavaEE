package com.itrail.testik;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;



/**
 *
 * @author barysevich_k
 */
public class AppTest {
    private EntityManager em;
  
    @Before
    public void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "RestTest" );
         em = emf.createEntityManager();
         em.getTransaction().begin();
    }
    
    @After
    public void close() {
        if(em.getTransaction().isActive()){
            em.getTransaction().commit();
        }
        em.getEntityManagerFactory().close();
        em.close();
    }
       
}
