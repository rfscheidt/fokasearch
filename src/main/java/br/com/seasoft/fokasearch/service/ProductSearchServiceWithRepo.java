package br.com.seasoft.fokasearch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.seasoft.fokasearch.dao.ProductRepository;
import br.com.seasoft.fokasearch.entity.Product;

@Service
public class ProductSearchServiceWithRepo {
	
	@Autowired
	private ProductRepository productRepository;

	public void createProductIndexBulk(final List<Product> products) {
		productRepository.saveAll(products);
	}

	public void createProductIndex(final Product product) {
		productRepository.save(product);
	}
	
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}
	
	public List<Product> findByName(String name) {
		return productRepository.findByName(name);
	}
	
	public List<Product> findByDescription(String desc) {
		return productRepository.findByDescription(desc);
	}
	
	public List<String> findByDescriptionString(String desc) {
		List<Product> listProduct = productRepository.findByDescription(desc);

		List<String> descriptions = new ArrayList<String>();
		
		listProduct.forEach(product->{
			descriptions.add(product.getDescription().substring(0, 30));
		});
		
		return descriptions;
	}

}
