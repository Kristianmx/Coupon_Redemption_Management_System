package com.riwi.Sistema_Gestion_Redencion_Cupones.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.entities.Product;
import com.riwi.Sistema_Gestion_Redencion_Cupones.domain.repositories.ProductRepository;

import jakarta.transaction.Transactional;

@Component
public class DataBaseSeeder implements CommandLineRunner {
  @Autowired
  private ProductRepository productRepository;

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    if (productRepository.count() == 0) {
      Product product1 = new Product();
      product1.setName("Product 1");
      product1.setPrice(10.99);
      productRepository.save(product1);

      Product product2 = new Product();
      product2.setName("Product 2");
      product2.setPrice(5.99);
      productRepository.save(product2);

      Product product3 = new Product();
      product3.setName("Product 3");
      product3.setPrice(7.99);
      productRepository.save(product3);

      Product product4 = new Product();
      product4.setName("Product 4");
      product4.setPrice(3.99);
      productRepository.save(product4);

      Product product5 = new Product();
      product5.setName("Product 5");
      product5.setPrice(9.99);
      productRepository.save(product5);

      Product product6 = new Product();
      product6.setName("Product 6");
      product6.setPrice(6.99);
      productRepository.save(product6);

      Product product7 = new Product();
      product7.setName("Product 7");
      product7.setPrice(8.99);
      productRepository.save(product7);

      Product product8 = new Product();
      product8.setName("Product 8");
      product8.setPrice(4.99);
      productRepository.save(product8);

      Product product9 = new Product();
      product9.setName("Product 9");
      product9.setPrice(2.99);
      productRepository.save(product9);

      Product product10 = new Product();
      product10.setName("Product 10");
      product10.setPrice(1.99);
      productRepository.save(product10);
    }
    System.out.println("DataBase seeding completed");
  }

}
