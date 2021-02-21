package br.com.seasoft.fokasearch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.seasoft.fokasearch.entity.Product;
import br.com.seasoft.fokasearch.service.ProductSearchServiceWithRepo;

@SpringBootTest
class ProductTests {
	
	@Autowired
	private ProductSearchServiceWithRepo productDao;

	/*
	@Test
	void createProductIndexTest() {
		Product p1 = null;
		for (int i = 0; i < 100; i++) {
			p1 = new Product();
			p1.setName("Name " + i);
			p1.setCategory("Category " + i);
			p1.setDescription("Ainda assim, existem dúvidas a respeito de como o desafiador cenário globalizado possibilita uma melhor visão global das condições inegavelmente apropriadas. " + i);
			
			productDao.createProductIndex(p1);
		}
	}
	*/
	
	//@Test
	void findAllTest() {
		Iterable<Product> listProducts = productDao.findAll();
		for (Product product : listProducts) {
			System.out.println(product.getName());
		}
	}
	
	@Test
	void findByNameTest() {
		Iterable<Product> listProducts = productDao.findByName("Name");
		for (Product product : listProducts) {
			System.out.println(product.getName());
		}
	}

}
