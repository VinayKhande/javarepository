package com.example.springweb.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springweb.model.Product;
import com.example.springweb.repositories.ProductRepository;

@RestController
public class ProductRestController {
	
	@Autowired
	ProductRepository repo;
	
	private static Logger LOGGER=LoggerFactory.getLogger(ProductRestController.class);

	@RequestMapping(value="/products/",method=RequestMethod.GET)
	public List<Product> getProducts() {
		return repo.findAll();
	}
	
	@RequestMapping(value="/products/{id}",method=RequestMethod.GET)
	@Transactional(readOnly=true)
	@Cacheable("product-cache")
	public Product getProduct(@PathVariable("id") int id) {
		LOGGER.info("Finding Product by ID "+id);
		return repo.findById(id).get();
	}
	
	@RequestMapping(value="/products/",method=RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return repo.save(product);
	}
	
	@RequestMapping(value="/products/",method=RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		return repo.save(product);
	}
	
	@RequestMapping(value="/products/{id}",method=RequestMethod.DELETE)
	@CacheEvict("product-cache")
	public void deleteProduct(@PathVariable("id") int id) {
		repo.deleteById(id);
	}

}
