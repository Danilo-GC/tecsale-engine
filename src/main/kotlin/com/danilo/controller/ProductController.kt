package com.danilo.controller

import com.danilo.model.Product
import com.danilo.service.ProductService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import java.util.UUID

@Controller (value = "/v1/iupp/product")
class ProductController (private val productService: ProductService) {

    @Get
    fun getAll(): HttpResponse<List<Product>> {
        return HttpResponse.ok(productService.getAll())
    }

    @Get(value = "/{id}")
    fun getById(@PathVariable id: UUID): HttpResponse<Product?> {
        return HttpResponse.ok(this.productService.getById(id))
    }
}