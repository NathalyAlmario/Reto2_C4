/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto2_C4.interfaces;

import Reto2_C4.modelo.Order;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author johnpaulvanegas
 */
public interface InterfaceOrder extends MongoRepository<Order, Integer> {
    
    List<Order> findBySalesManZone(String zone);
    
}
