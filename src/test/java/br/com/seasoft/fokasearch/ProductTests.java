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

	//@Test
	void createProductIndexTest() {
		Product p1 = new Product();
		p1.setName("Name 2");
		p1.setCategory("Category 2");
		p1.setDescription("Description 2");
		
		productDao.createProductIndex(p1);
	}
	
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
