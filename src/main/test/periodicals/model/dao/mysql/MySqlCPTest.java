package periodicals.model.dao.mysql;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.Assert;
import org.junit.Test;

public class MySqlCPTest {
    private static HikariDataSource singleton = null;

    @Test
    public void testUnique() throws InterruptedException {
        Thread threadOne = new Thread(new SingletonTestRunnable()),
                threadTwo = new Thread(new SingletonTestRunnable());
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
    }

    private static class SingletonTestRunnable implements Runnable {
        public void run() {
            HikariDataSource instance = MySqlCP.getInstance();
            synchronized (HikariDataSource.class) {
                if (singleton == null) {
                    singleton = instance;
                }
            }
            Assert.assertEquals(true, instance == singleton);
        }

    }
}