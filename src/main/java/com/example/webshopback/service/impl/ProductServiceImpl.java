package com.example.webshopback.service.impl;

import com.example.webshopback.model.ItemCart;
import com.example.webshopback.model.Product;
import com.example.webshopback.repository.ItemCartRepository;
import com.example.webshopback.repository.ProductRepository;
import com.example.webshopback.service.ProductService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
@Data
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ItemCartRepository itemCartRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product createNew(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    @Override
    public Product getOne(long id) {
        return productRepository.findById(id).orElseThrow(() -> {
            return new NotFoundException("Product not found");
        });
    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void update(Product product) {
        product.setId(product.getId());
        productRepository.save(product);
    }


    @Override
    public Long sunQuantities() {
        return productRepository.sumQuantities();
    }

    @Override
    public Double total() {
        return productRepository.total();
    }


}
