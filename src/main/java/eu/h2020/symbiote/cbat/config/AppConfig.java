package eu.h2020.symbiote.cbat.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import java.util.Arrays;
import org.bson.Document;


/**
 * MongoDB Configuration
 *
 * @author jamsellem
 */
@Configuration
@EnableMongoRepositories("eu.h2020.symbiote.cbat.repositories")
class AppConfig extends AbstractMongoConfiguration {

    private static Log logger = LogFactory.getLog(AppConfig.class);

    @Value("${spring.data.mongodb.host}")
    private String host;
    @Value("${spring.data.mongodb.port}")
    private Integer port;
    @Value("${spring.data.mongodb.username}")
    private String username;
    @Value("${spring.data.mongodb.database}")
    private String database;
    @Value("${spring.data.mongodb.password}")
    private String password;

    @Override
    public String getDatabaseName() {
        return database;
    }



    @Override
    @Bean
    public Mongo mongo() throws Exception {
        logger.info("#####################################33");
        logger.info("host: "+host + "\n"+
                    "database: "+database + "\n"+
                    "username: "+username + "\n"+
                    "password: "+password + "\n");
        logger.info("#####################################33");
        MongoCredential credential = MongoCredential.createCredential(username,
                database,
                password.toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017),
                Arrays.asList(credential));

        MongoDatabase db = mongoClient.getDatabase(database);

        MongoCollection<Document> collection = db.getCollection("names");
        System.out.println("connecting to host....."+mongoClient);

        System.out.println("connecting to database....."+collection.count());


        return mongoClient;


    }

}