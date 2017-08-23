package com.okres.springjdbc.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan({"com.okres.springjdbc.*"})
@EnableTransactionManagement

//Load to Environment
@PropertySources({@PropertySource("classpath:ds/datasource-cfg.properties")})
public class AppConfiguration {

    //class Environment
    @Autowired
    private Environment env;


    @Bean(name = "dataSource")
    public DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
        dataSource.setUrl(env.getProperty("ds.url"));
        dataSource.setUsername(env.getProperty("ds.username"));
        dataSource.setPassword(env.getProperty("ds.password"));

        System.out.println("## DataSource" + dataSource);

        return dataSource;
    }

}
