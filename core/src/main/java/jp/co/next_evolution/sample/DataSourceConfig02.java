package jp.co.next_evolution.sample;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"jp.co.next_evolution.sample.mapper.db02"}, sqlSessionFactoryRef = "sqlSessionFactory02")
public class DataSourceConfig02 {

    public static final String TX_MANAGER = "txManager02";

    @Bean(name = {"dataSourceProperties02"})
    @ConfigurationProperties(prefix = "spring.datasource.db02")
    public HikariConfig dataSourceProperties() {
        return new HikariConfig();
    }

    @Bean(name = {"dataSource02"})
    public DataSource dataSource(@Qualifier("dataSourceProperties02") HikariConfig properties) {
        return new HikariDataSource(properties);
    }

    @Bean(name = {TX_MANAGER})
    public PlatformTransactionManager txManager(@Qualifier("dataSource02") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = {"sqlSessionFactory02"})
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource02") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

}
