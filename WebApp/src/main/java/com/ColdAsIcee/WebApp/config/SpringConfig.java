package com.ColdAsIcee.WebApp.config;

import com.ColdAsIcee.WebApp.dao.UserDao;
import com.ColdAsIcee.WebApp.dao.UserDaoImpl;
import com.ColdAsIcee.WebApp.service.UserService;
import com.ColdAsIcee.WebApp.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://VH254.spaceweb.ru/jurliquema?userSll=false&?createDatabaseIfNotExist=true");
        dataSource.setUsername("jurliquema");
        dataSource.setPassword("jurliquema");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public UserDao getUserDao() {
        return new UserDaoImpl(getJdbcTemplate());
    }

    @Bean
    public UserService getUserService() {
        return new UserServiceImpl();
    }

}
