package com.danilo.repository.impl

import com.danilo.model.Product
import com.danilo.repository.ProductRepository
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.UUID
import javax.inject.Singleton

@Singleton
class ProductRepositoryImpl (private val cqlSession: CqlSession): ProductRepository {


    override fun getAllCql(product: Product): List<Product> {
        val selectResult = cqlSession.execute(
            (
                    SimpleStatement
                        .newInstance(
                            "SELECT * FROM product.Product",
                        )
                    )
        )
        return selectResult.map {
            Product(
                it.getUuid("id"),
                it.getString("name")!!,
                it.getBigDecimal("price")!!,
                it.getString("type")!!,
                it.getString("description")!!
            )
        }.toList()

    }
    override fun getByIdCql(id: UUID): Product? {
        val selectResult = cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "SELECT * FROM product.Product WHERE id = ?",
                    id
                )
        )
        return selectResult
            .map { product ->
                Product(
                    product.getUuid("id")!!, product.getString("name")!!,
                    product.getBigDecimal("price")!!,
                    product.getString("description")!!,
                    product.getString("type")!!
                )
            }.firstOrNull()
    }
}
