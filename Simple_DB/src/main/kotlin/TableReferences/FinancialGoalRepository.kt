package TableReferences

import Simple_DbConn.dbConn
import org.ktorm.dsl.*

class FinancialGoalRepository {
    val connection= dbConn()
    fun getApplicationData(applicationData: PlanRequest){
        if (applicationData.productId != null) {
            val result=connection.from(PlanInfos).joinReferencesAndSelect()
                    .where { (applicationData.productId!! eq PlanInfos.productId) }
                    .map { PlanInfos.createEntity(it) }.map {
                    ApplicationResponse(
                        it.planId,
                        it.planType
                    )
                }
            println(result)
        } else {
            println(connection.from(PlanInfos).joinReferencesAndSelect()
                .map { PlanInfos.createEntity(it) })
        }

    }
}