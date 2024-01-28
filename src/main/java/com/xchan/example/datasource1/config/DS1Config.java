package com.xchan.example.datasource1.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.xchan.example.datasource1", sqlSessionFactoryRef = "sqlSessionFactory1")
public class DS1Config {
    @Primary
    @Bean(name = "dataSource1")
    @ConfigurationProperties(prefix = "datasource.one")
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sqlSessionFactory1")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource1") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/xchan/example/datasource1/xml/*.xml"));
        return sessionFactory.getObject();
    }

    @Bean(name = "sqlSessionTemplate1")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
