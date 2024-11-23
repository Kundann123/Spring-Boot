package Simple_DbConn

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

interface ScreenEntity : Entity<ScreenEntity> {
    val id: Int
    val productType: String
    val screen: String
    val questions: String
}

object ScreenEntities : Table<ScreenEntity>("screen_db") {
    val id = int("id").bindTo { it.id }.primaryKey()
    val productType = varchar("product_type").bindTo { it.productType }
    val screen = varchar("screen").bindTo { it.screen }
    val questions = varchar("questions").bindTo { it.questions }
}
