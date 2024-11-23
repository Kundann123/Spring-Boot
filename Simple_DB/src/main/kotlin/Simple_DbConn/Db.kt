package Simple_DbConn

import org.ktorm.database.Database

//lateinit var connection: Database
fun dbConn():Database{
    return Database.connect(
        url = "jdbc:postgresql://localhost:5432/gauranteedsavings",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "root"
    )
}
