package br.com.seasoft.fokasearch.service;

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

}
