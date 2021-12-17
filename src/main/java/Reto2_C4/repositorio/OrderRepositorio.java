/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_C4.repositorio;

import Reto2_C4.interfaces.InterfaceOrder;
import Reto2_C4.modelo.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author johnpaulvanegas
 */
@Repository
public class OrderRepositorio {
    @Autowired
    private InterfaceOrder orderCrudRepository;
    
    public List<Order> getAll() {
        return orderCrudRepository.findAll();
    }
    
    public Optional<Order> getProduct(Integer id) {
        return orderCrudRepository.findById(id);
    }
    
    public Order create(Order product) {
        return orderCrudRepository.save(product);
    }

    public void update(Order product) {
        orderCrudRepository.save(product);
    }
    
    public void delete(Order product) {
        orderCrudRepository.delete(product);
    }
    
    public List<Order> getOrderbyZone(String zone){
        return orderCrudRepository.findBySalesManZone(zone);
    }
    
}
    