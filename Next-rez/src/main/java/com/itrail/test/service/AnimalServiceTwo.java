
package com.itrail.test.service;

import com.itrail.test.domain.Animal;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author barysevich_k
 */
@Stateless
public class AnimalServiceTwo {
    
    @PersistenceContext
    private EntityManager entitymanager;
    
    @PostConstruct
    protected void init(){ 
    }
 
    @PreDestroy
    protected void destroy(){   
    }
    
    public Animal getAnimalById(Integer idAnimal){
        return entitymanager.find(Animal.class, idAnimal);
    }
    
    public List<Animal> getAnimalByList(){
        return entitymanager.createQuery("SELECT e FROM Animal e").getResultList();
    }
    
    public void saveAnaimal(Animal animal){
        entitymanager.persist(animal);
    }
    
    public void createAnimal(Animal...us4){
        createAnimal(Arrays.asList(us4));
    }
    @Transactional
    public void createAnimal(List<Animal> us4){
        us4.stream().forEach(d-> entitymanager.merge(d));
    }
    public void createUser(Animal us4){
        entitymanager.merge(us4);
    }
    
    public void deleteAnimal(Integer idAnimal){
        Animal d = entitymanager.find(Animal.class, idAnimal);
        entitymanager.remove(d);
    }
    
    public List<Animal> withoutOwner(){
        return entitymanager.createQuery("SELECT e FROM Animal e WHERE e.owner = null and e.count <> 0 ").getResultList();
    }     
}
