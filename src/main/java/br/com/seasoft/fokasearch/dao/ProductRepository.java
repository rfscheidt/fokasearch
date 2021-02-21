package br.com.seasoft.fokasearch.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import br.com.seasoft.fokasearch.entity.Product;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {

	List<Product> findByName(String name);

	List<Product> findByNameContaining(String name);

	List<Product> findByManufacturerAndCategory(String manufacturer, String category);
	
	List<Product> findByDescription(String desc);

}
