/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_C4.servicio;

import Reto2_C4.modelo.Order;
import Reto2_C4.repositorio.OrderRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johnpaulvanegas
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderRepositorio orderRepository;
    
    public List<Order> getAll() {
        return orderRepository.getAll();
    }
    
    public Optional<Order> getProduct(Integer id) {
        return orderRepository.getProduct(id);
    }
    
    public Order create(Order product) {
        if (product.getId() == null) {
            return product;
        } else {
            return orderRepository.create(product);
        }
    }
    
    public Order update(Order product) {
         if (product.getId() != null) {
             Optional<Order> productDb = orderRepository.getProduct(product.getId());
             if (!productDb.isEmpty()) {
                 
                if (product.getRegisterDay()!= null) {
                    productDb.get().setRegisterDay(product.getRegisterDay());
                }
                if (product.getStatus() != null) {
                    productDb.get().setStatus(product.getStatus());
                }
                if (product.getSalesMan() != null) {
                    productDb.get().setSalesMan(product.getSalesMan());
                }
                if (product.getProducts() != null) {
                    productDb.get().setProducts(product.getProducts());
                }
                 if (product.getQuantities() != null) {
                    productDb.get().setQuantities(product.getQuantities());
                }
                 
                orderRepository.update(productDb.get());
                return productDb.get();
                
            }else {
                return product;
            } 
        }else {
            return product;
       }
    }
    
    public boolean delete(Integer id) {
        return getProduct(id).map(product -> {
            orderRepository.delete(product);
            return true;
        }).orElse(false);
    }   
    
    public List<Order> getOrderByZone(String zone){
        return orderRepository.getOrderbyZone(zone);
    }
            
}
