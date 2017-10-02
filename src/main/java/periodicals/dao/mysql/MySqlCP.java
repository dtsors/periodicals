package periodicals.dao.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

class MySqlCP {//TODO: МНОГОПОТОЧНЫЙ СИНГЛТОН
    private static HikariDataSource instance = null;

    private MySqlCP() {
    }

    static HikariDataSource getInstance() {
        if (instance == null) {
            HikariConfig config = new HikariConfig();
            MySqlProperties prop = new MySqlProperties("db.properties");
            config.setJdbcUrl(prop.getUrl());
            config.setUsername(prop.getUser());
            config.setPassword(prop.getPassword());
            config.setDriverClassName(prop.getDriver());
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            instance = new HikariDataSource(config);
        }
        return instance;
    }
}