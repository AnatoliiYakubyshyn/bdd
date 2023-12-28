package com.yakubt.carina.demo.db.mappers;

import com.yakubt.carina.demo.db.models.Order;

public interface OrderMapper {

    void create(Order order);

    Order findById(int id);


    void update(Order order);

    void delete(Order order);

}
