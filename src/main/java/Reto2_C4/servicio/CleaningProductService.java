/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_C4.servicio;

import Reto2_C4.modelo.CleaningProduct;
import Reto2_C4.repositorio.CleaningProductRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author johnpaulvanegas
 */
@Service
public class CleaningProductService {
    
    @Autowired
    private CleaningProductRepositorio cleaningProductRepository;

    public List<CleaningProduct> getAll() {
        return cleaningProductRepository.getAll();
    }
    
    public Optional<CleaningProduct> getProduct(Integer id) {
    return cleaningProductRepository.getProduct(id);
    }

    public CleaningProduct create(CleaningProduct product) {
        if (product.getId() == null) {
            return product;
        } else {
            return cleaningProductRepository.create(product);
        }
    }

    public CleaningProduct update(CleaningProduct product) {

        if (product.getId() != null) {
            Optional<CleaningProduct> productDb = cleaningProductRepository.getProduct(product.getId());
            if (!productDb.isEmpty()) {
                
                if (product.getBrand()!= null) {
                    productDb.get().setBrand(product.getBrand());
                }
                
                if (product.getCategory() != null) {
                    productDb.get().setCategory(product.getCategory());
                }
                 if (product.getPresentation() != null) {
                    productDb.get().setPresentation(product.getPresentation());
                }
                if (product.getDescription() != null) {
                    productDb.get().setDescription(product.getDescription());
                }
                if (product.getPrice() != 0.0) {
                    productDb.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != 0) {
                    productDb.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null) {
                    productDb.get().setPhotography(product.getPhotography());
                }
                productDb.get().setAvailability(product.isAvailability());
                cleaningProductRepository.update(productDb.get());
                return productDb.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }

    public boolean delete(Integer id) {
        Boolean aBoolean = getProduct(id).map(product -> {
            cleaningProductRepository.delete(product);
            return true;
        }).orElse(false);
        return aBoolean;
    }  
}
