package br.com.seasoft.fokasearch;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import br.com.seasoft.fokasearch.entity.Product;
import br.com.seasoft.fokasearch.service.ProductSearchServiceWithRepo;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class LoadIndexTest {
	
	@Autowired
	private ProductSearchServiceWithRepo productDao;
	
	private static final String COMMA_DELIMITER = ",";
	
	@Test
	void loadCsvTest() {
		productDao.createProductIndexBulk(prepareDataset());
	}
	
	private List<Product> prepareDataset() {
		Resource resource = new ClassPathResource("fashion-products.csv");
		List<Product> productList = new ArrayList<Product>();

		try (
			InputStream input = resource.getInputStream();
			Scanner scanner = new Scanner(resource.getInputStream());) {
			int lineNo = 0;
			while (scanner.hasNextLine()) {
				++lineNo;				
				String line = scanner.nextLine();
				if(lineNo == 1) continue;
				Optional<Product> product = 
						csvRowToProductMapper(line);
				if(product.isPresent())
				productList.add(product.get());
			}
		} catch (Exception e) {
			log.error("File read error {}",e);;
		}
		return productList;
	}

	private Optional<Product> csvRowToProductMapper(final String line) {
		try (			
			Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);
			while (rowScanner.hasNext()) {
				String name = rowScanner.next();
				String description = rowScanner.next();
				String manufacturer = rowScanner.next();
				return Optional.of(
						Product.builder()
						.name(name)
						.description(description)
						.manufacturer(manufacturer)
						.build());

			}
		}
		return Optional.of(null);
	}

}
