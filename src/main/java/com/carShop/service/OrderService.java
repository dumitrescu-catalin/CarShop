package com.carShop.service;
import com.carShop.model.Order;
import com.carShop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    //GET
    public List<Order> getAllOrders() {
        List<Order> ordersList = orderRepository.findAll();
        return ordersList;
    }

    //GET
    public Optional<Order> getOrderById(int id) {
        Optional<Order> ord = orderRepository.findById(id);
        return ord;
    }

    //GET
    public List<Order> getOrdersByDate(LocalDate date) {
        List<Order> orderList = orderRepository.findOrderByDate(date);
        return orderList;
    }

    //POST
    public Order addNewOrder(Order order) {
        return orderRepository.save(order);
    }

    //Update
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    //Delete
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }


}
