package net.codejava.ProductManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
	@Autowired
	ProductRepository repo;

	public List<Product> getAll() {
		return repo.findAll();
	}

	public void save(Product product) {
		repo.save(product);
	}

	public Product getById(int id) {
		return repo.findById(id).get();
	}
	public void delete(int id) {
		repo.deleteById(id);
	}
}
