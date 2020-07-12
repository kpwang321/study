package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author kpwang
 * @create 2020-07-08 1:52
 */
//@Configuration
public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.url1}")
    private String url1;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;


    @Bean(name = "queryRunner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(@Qualifier("ds2") DataSource dataSource) {
        return new QueryRunner(dataSource);

    }
    @Bean(name = "ds2")
    public DataSource createDataSource(){
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(driver);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    @Bean(name = "ds1")
    public DataSource createDataSource1(){
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(driver);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setJdbcUrl(url1);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
