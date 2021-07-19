package com.danilo.service

import com.danilo.model.Product
import java.util.UUID
import javax.inject.Singleton

@Singleton
interface ProductService {

    fun getById(id: UUID): Product?
    fun getAll(): List<Product>
}