
package com.itrail.test.service;

import com.itrail.test.exception.mapper.ItException;
import com.itrail.test.domain.Animal;
import com.itrail.test.domain.BaseResponse;
import com.itrail.test.domain.Order;
import com.itrail.test.domain.OrderRequest;
import com.itrail.test.domain.User;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
/**
 * Сервисный класс для покупи питомцев и формирования заказов 
 *
 * @version 1.0
 * @author barysevich_k
 */
@Stateless
public class BuyService {
    @PersistenceContext
    private EntityManager em; 
    
    @PostConstruct
    protected void init(){ 
    }
 
    @PreDestroy
    protected void destroy(){   
    }
    
    /**
     * Этот метод для получения списка всех заказов за сегодняшний день в промежутке врмени с 00:00 по настоящее время.
     * @return <code> List </code>
     * список все заказов
     * @see #getOrdrs()
     * @see #em
     */
    
    public List <Order> getAllOrders(){      
      LocalDate localDate = LocalDate.now();
      return  em.createQuery("SELECT e FROM Order e WHERE e.time BETWEEN :daystart AND :dayend")
                .setParameter("daystart",localDate.atStartOfDay())
                .setParameter("dayend", LocalDateTime.now())
                .getResultList();
    }
    /**
     * Этот метод для получения списка заказов
     * @param rq - входные параметры для поиска заказов 
     * @return<code> Order </code>
     * список заказов
     * @see #getOrdrs() 
     * @see  com.itrail.test.domain.BaseResponse#BaseResponse()
     * @see com.itrail.test.domain.Order
     * @see com.itrail.test.domain.OrderRequest#OrderRequest() 
     * 
     */
    
    public BaseResponse<List<Order>> getOrders(OrderRequest rq){
        BaseResponse<List<Order>> bs = new BaseResponse<>(0,"success");
        try{
            bs.setData(getOrdrs());
            return bs;
        }catch(Exception ex){
            ex.printStackTrace(System.err);
            return BaseResponse.error(910, ex);
        }  
    }
    
    /**
     * Этот метод для получения 1-го заказа
     * @param rq - входные параметры для поиска заказа
     * @return <code>  getOrdrs()  </code>
     * 1-н заказ
     * @see #getOrdrs() 
     * @see  com.itrail.test.domain.BaseResponse#error(int, java.lang.Throwable) 
     * @see com.itrail.test.domain.Order
     * @see com.itrail.test.domain.OrderRequest
     */
    public BaseResponse<Order> getOrder(OrderRequest rq){
        BaseResponse r = new BaseResponse<>(0,"success"); 
        try{
            Order order = getOrdrs().stream().findFirst().orElse(null);
            r.setData(order);
            return r;
        } catch(Exception ex){    
            ex.printStackTrace(System.err);
            return BaseResponse.error(905, ex);   
        }
    }
     /**
      * Запрос на получение списка  по 3-м параметрам:
      * 1. ИД заказа
      * 2. ИД клиента
      * 3. Время заказа
      * @return <code> List <Order> </code>
      * список заказов
      * @see #em
      * 
      */
    private List<Order> getOrdrs(){
        OrderRequest rq = new OrderRequest();
        return em.createQuery("select o FROM Order o where :userid is null or o.userID = :userid"
                                                + " AND :timeOrder is null or o.time = :timeOrder"
                                                + " AND :olderid is null or o.idOrder = :olderid")
                                   .setParameter("userid", rq.getIdUser())
                                   .setParameter("timeOrder", rq.getTime())
                                   .setParameter("olderid", rq.getIdOrderRq()).getResultList();
             //   return em.createQuery("select o FROM Order o").getResultList(); 
    }
    /**
     *Формирование неограниченого количество заказов
     * @param or - неограниченное количество заказов 
     */
    public void createOrder(Order...or){
          createOrder(Arrays.asList(or));
      }
      
    /**
     *Формировавние списка заказов
     * @param or - список заказов
     */
    @Transactional
      public void createOrder(List<Order> or){
          or.stream().forEach(s->em.merge(s));
      }
      
    /**
     * Формирование 1-го заказа
     * @param or - заказ
     */
    public void createOrder(Order or){
          em.merge(or);
      }
      
      /**
       * Метод для покупки клиентом питомца 
       * @param idAnimal - питомец 
       * @param idUser - клиент 
       * @throws ItException - 50 - недостаточно денег у покупателя, 51 - нет питомцев в магазине
       * @see #BuyService()
       */
    public void getBuyAnimal(Integer idAnimal, Integer idUser) throws ItException{ 
        
        Animal ani = em.find(Animal.class, idAnimal);
        User us = em.find(User.class, idUser);
        Integer a = ani.getCoat().compareTo(us.getWallet());
        if (a > -1) throw new ItException(50," Not enough money to buy an animal ");    
        if( ani.getCount() <= 0) throw new ItException(51,"No animals in the store");
        
        ani.setCount(ani.getCount()-1);
        us.setWallet(us.getWallet().subtract(ani.getCoat())) ;
        List<Animal> animal =  us.getAnimal();
        animal.add(ani);
        us.setAnimal(animal);
        
        List<Order> orders = new LinkedList<>(Arrays.asList(new Order(null,us.getIdUser(),ani.getIdAnimal(),ani.getCoat(), LocalDateTime.now())));
        orders.stream().forEach(s->em.merge(s));
        em.merge(us);   
    }

}

