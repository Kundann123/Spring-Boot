package example.com.plugins

import example.com.config.dbconfig.MongoDBProps.mongoDBProps
import example.com.config.getMongoDbSecrets

fun modifyApplicationEnvConfiguration(){
    mongoDBProps = getMongoDbSecrets()
}