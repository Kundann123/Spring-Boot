package TableReferences

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface PlanInfo: Entity<PlanInfo> {
    var planId: Int
    var planType: String
    var productId: ProductInfo
}

object PlanInfos: Table<PlanInfo>("planinfo"){
    var productId=int("productid").references(ProductInfos){ it.productId }
    var planId=int("planid").bindTo { it.planId }
    var planType=varchar("plantype").bindTo { it.planType}


}