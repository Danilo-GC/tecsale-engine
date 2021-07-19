package com.danilo.service.impl

import com.danilo.model.Product
import com.danilo.repository.ProductRepository
import com.danilo.service.ProductService
import java.util.UUID
import javax.inject.Singleton

@Singleton
class ProductServiceImpl (private val productRepository: ProductRepository): ProductService {
    override fun getById(id: UUID): Product? {
        return productRepository.getByIdCql(id)
    }

    override fun getAll(): List<Product> {
        return productRepository.getAllCql(Product())
    }
}