package com.itrail.test.rest.impl;

import com.itrail.test.exception.mapper.ItException;
import com.itrail.test.domain.BaseResponse;
import com.itrail.test.domain.Order;
import com.itrail.test.domain.OrderRequest;
import com.itrail.test.domain.OrderResponse;
import com.itrail.test.rest.BuyResource;
import com.itrail.test.service.BuyService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 * API for BuyService
 *
 * @author barysevich_k
 */

@Path("em")
public class BuyAPI implements BuyResource {

    @EJB
    private BuyService service;

    /**
     * Метод для
     *
     * @return <code> BaseResponse </code>
     */
    @Override
    public BaseResponse getListOrder() {
        BaseResponse bs = new BaseResponse(200, "success");
        bs.setData(service.getAllOrders());
        return bs;
    }

    @Override
    public BaseResponse getBuyAnimal(Integer idAnimal, Integer idUser, String key) throws ItException {
        BaseResponse bs = new BaseResponse(200, "success");
        if (null == key || key.isEmpty()) {
            throw new ItException(401, "Значение ключа не может быть равным нулю или пустым, повторите попытку!");
        }
        if (!"1".equals(key)) {
            throw new ItException(403, "Неверный ключ, повторите попытку!");
        }
//       if("1".equals(key)){}         
//        if(Objects.isNull(key)) throw new ItException(401, "Поле не может быть null!"); 
        if (Objects.equals("1", key)) {
            service.getBuyAnimal(idAnimal, idUser);
            bs.setData("Animal = " + idAnimal + " User = " + idUser + " TimeOrder: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
        }
        return bs;
    }

    @Override
    public Order getOrder(OrderRequest req) throws ItException {
        BaseResponse<Order> bs = service.getOrder(req);
        if (bs.getCode() != 0) {
            throw new ItException(bs.getCode(), bs.getMessage());
        }
        return service.getOrder(req).getData();
    }

    @Override
    public OrderResponse getOrders(OrderRequest req) throws ItException {
        return new OrderResponse(service.getOrders(req).getData());
    }
}
