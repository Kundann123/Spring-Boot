package Simple_DbConn

import org.ktorm.dsl.from
import org.ktorm.dsl.insert
import org.ktorm.dsl.map
import org.ktorm.dsl.select

val connection= dbConn()
fun get() {
    val res = connection.from(ScreenEntities).select().map { ScreenEntities.createEntity(it) }
    println(res)
}

fun save(id:Int,type:String,screen:String,question:String){
    val res=connection.insert(ScreenEntities){
        set(it.id,id)
        set(it.productType,type)
        set(it.screen,screen)
        set(it.questions,question)
    }
    println(res)
}