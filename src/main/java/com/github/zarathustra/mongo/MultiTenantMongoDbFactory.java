package com.github.zarathustra.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.HashMap;

public class MultiTenantMongoDbFactory extends SimpleMongoDbFactory {

    private static final Logger logger = LoggerFactory.getLogger(MultiTenantMongoDbFactory.class);
    private static final ThreadLocal<String> dbName = new ThreadLocal<>();
    private static final HashMap<String, Object> databaseIndexMap = new HashMap<>();
    private final String defaultName;

    public MultiTenantMongoDbFactory(final MongoClient mongo, final String defaultDatabaseName) {
        super(mongo, defaultDatabaseName);
        logger.debug("Instantiating " + MultiTenantMongoDbFactory.class.getName() + " with default database name: "
                     + defaultDatabaseName);
        this.defaultName = defaultDatabaseName;
    }

    public static void setDatabaseNameForCurrentThread(final String databaseName) {
        logger.debug("Switching to database: " + databaseName);
        dbName.set(databaseName);
    }

    public static void clearDatabaseNameForCurrentThread() {
        if (logger.isDebugEnabled()) {
            logger.debug("Removing database [" + dbName.get() + "]");
        }
        dbName.remove();
    }

    @Override
    public MongoDatabase getDb() {
        final String tlName = dbName.get();
        final String dbToUse = (tlName != null ? tlName : this.defaultName);
        logger.debug("Acquiring database: " + dbToUse);
        return super.getDb(dbToUse);
    }
}
