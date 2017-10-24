package periodicals.model.dao.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import periodicals.model.config.MySqlProperties;

class MySqlCP {
    private static HikariDataSource instance = null;

    static {
        HikariConfig config = new HikariConfig();
        MySqlProperties prop = new MySqlProperties();
        config.setJdbcUrl(prop.getUrl());
        config.setUsername(prop.getUser());
        config.setPassword(prop.getPassword());
        config.setDriverClassName(prop.getDriver());
        config.addDataSourceProperty("cachePrepStmts", prop.getCachePrepStmts());
        config.addDataSourceProperty("prepStmtCacheSize", prop.getPrepStmtCacheSize());
        config.addDataSourceProperty("prepStmtCacheSqlLimit", prop.getPrepStmtCacheSqlLimit());
        instance = new HikariDataSource(config);
    }

    private MySqlCP() {
    }

    static HikariDataSource getInstance() {
        return instance;
    }
}
