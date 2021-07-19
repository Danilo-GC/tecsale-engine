package com.danilo.repository

import com.danilo.model.Product
import java.util.UUID
import javax.inject.Singleton

@Singleton
interface ProductRepository {

    fun getAllCql(product: Product): List<Product>
    fun getByIdCql(id: UUID): Product?
}