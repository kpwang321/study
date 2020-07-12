package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author kpwang
 * @create 2020-07-07 21:07
 * 该类是一个配置类，它的作用和bean.xml是一样的
 * @Configuration
 *     作用：指定当前类是一个配置类
 * @ComponnentScan
 *     用于通过注解指定spring在创建容器时需要扫描的包
 */
@Configuration
@PropertySource("classpath:jdbcConfig.properties")
@Import(JdbcConfig.class)
//@ComponentScan(basePackages = {"com.itheima","config"})
@ComponentScan(basePackages = {"com.itheima"})
public class SpringConfiguration {

}
