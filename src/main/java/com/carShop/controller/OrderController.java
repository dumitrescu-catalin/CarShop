package com.carShop.controller;


import com.carShop.exception.ResourceNotFoundException;
import com.carShop.model.Order;
import com.carShop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    //GetEndpoint
    //localhost:8080/api/orders
    @GetMapping("/allOrders")       //localhost:8080/api/orders/allOrders
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orderList = orderService.getAllOrders();
        if (orderList.size() == 0) {
            throw new ResourceNotFoundException("There are no orders in the database");
        }
        return ResponseEntity.ok(orderList);
    }

    //GETEndpoint
    @GetMapping("/getOrderById/{id}")  //localhost:8080/api/orders/getOrderById/
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        Order order = orderService.getOrderById(id).orElseThrow(() -> new ResourceNotFoundException("Order with id: " + id + " not found"));
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    //GET EndPoint

    @GetMapping("/getOrderByDate")    //localhost:8080/api/orders/getOrderByDate?date= ...
    public ResponseEntity<List<Order>> getOrderByDate(@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Order> orderList = orderService.getOrdersByDate(date);
        if (orderList.size() == 0) {
            throw new ResourceNotFoundException("Orders on date " + date + " not found!");
        }
        return ResponseEntity.ok(orderList);
    }

    //Post EndPoint
    @PostMapping("/addNewOrder")    //localhost:8080/api/orders/addNewOrder
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        Order newOrder = orderService.addNewOrder(order);
        return ResponseEntity.ok(newOrder);
    }

    //PUT ENDPOINT
    @PutMapping("/updateOrder")     //localhost:8080/api/orders/updateOrder
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        Order updateOrder = orderService.updateOrder(order);
        return ResponseEntity.ok(updateOrder);
    }

    //DELETE ENDPOINT
    @DeleteMapping("/deleteOrderById/{id}")     //localhost:8080/api/orders/deleteOrderById
    public ResponseEntity<?> deleteOrderById(@PathVariable int id) {
        orderService.getOrderById(id).orElseThrow(() -> new ResourceNotFoundException("Order with id: " + id + " not found"));
        orderService.deleteOrder(id);
        return new ResponseEntity<>("Order with id " + id + " deleted " +
                "successfully", HttpStatus.OK);
    }


}
