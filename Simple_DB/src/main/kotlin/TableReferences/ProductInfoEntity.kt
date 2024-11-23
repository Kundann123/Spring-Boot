package TableReferences

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface ProductInfo : Entity<ProductInfo> {
    var productId: Int
    var productName: String
}

object ProductInfos : Table<ProductInfo>("productinfo") {
    var productId = int("productid").bindTo { it.productId }.primaryKey()
    var productName = varchar("productname").bindTo { it.productName }
}