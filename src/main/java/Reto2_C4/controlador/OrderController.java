/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_C4.controlador;

import Reto2_C4.modelo.Order;
import Reto2_C4.servicio.OrderService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author johnpaulvanegas
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {
    
    @Autowired
    private  OrderService orderService;
    
    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Order> getProduct(@PathVariable("id") Integer id) {
        return orderService.getProduct(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order gadget) {
        return orderService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order gadget) {
        return orderService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return orderService.delete(id);
    } 
    
    @GetMapping("/zona/{zone}")
    public List<Order> getOrdersByZone (@PathVariable("zone") String zone){
        return orderService.getOrderByZone(zone);
    }
    
}
