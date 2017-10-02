package periodicals.dao.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

class MySqlCP {//TODO: МНОГОПОТОЧНЫЙ СИНГЛТОН
    private static HikariDataSource instance = null;

    private MySqlCP() {
    }

    static HikariDataSource getInstance() {
        if (instance == null) {
            String user = "root";//TODO ВЫНЕСТИ В ПРОПЕРТИ
            String password = "PfkegjukfprF";
            String url = "jdbc:mysql://localhost:3306/periodicals?useUnicode=true&characterEncoding=utf-8&useSSL=false";
            String driver = "com.mysql.jdbc.Driver";
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(url);
            config.setUsername(user);
            config.setPassword(password);
            config.setDriverClassName(driver);
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            instance = new HikariDataSource(config);
        }
        return instance;
    }
}
