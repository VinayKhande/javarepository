package com.example.springweb;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.example.springweb.model.Product;

@SpringBootTest
class ProductrestapiApplicationTests {
	@Value("${productrestapi.services.url}")
	private String baseUrl;
	@Test
	void testGetProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseUrl+"3", Product.class);
		assertNotNull(product);
		assertEquals("Iphone",product.getName());
	}
	
	@Test
	public void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product= new Product();
		product.setName("Samsung");
		product.setDescription("sjdf");
		product.setPrice(76543);
		Product product2 = restTemplate.postForObject(baseUrl, product, Product.class);
		assertNotNull(product2);
		assertNotNull(product2.getId());
		assertEquals("Samsung",product.getName());
	}
	
	@Test
	void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseUrl+"1", Product.class);
		product.setPrice(12000);
		product.setName("qwerty");
		restTemplate.put(baseUrl, product);
		
	}

}
