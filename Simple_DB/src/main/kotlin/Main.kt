import Simple_DbConn.get
import TableReferences.FinancialGoalRepository
import TableReferences.PlanRequest

fun main() {
//    dbConn()
//    get()
//    save(9,"abc","Screen","Question")

    FinancialGoalRepository().getApplicationData(PlanRequest(productId = 2))
}
