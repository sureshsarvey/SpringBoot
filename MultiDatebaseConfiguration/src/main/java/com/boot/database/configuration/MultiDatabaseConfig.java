package com.boot.database.configuration;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "entityManagerFactory",
		  basePackages = {"com.boot.database.test2repository"}
)
@EntityScan(basePackages = {"com.boot.database.model"})
public class MultiDatabaseConfig {
  
  @Primary
  @Bean(name = "dataSource")
  @ConfigurationProperties(prefix = "spring.first.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }
  
  @Primary
  @Bean(name = "entityManagerFactory")
  public LocalContainerEntityManagerFactoryBean 
  entityManagerFactory(
    EntityManagerFactoryBuilder builder,
    @Qualifier("dataSource") DataSource dataSource
  ) {
	  HashMap<String, Object> properties = new HashMap<>();
      properties.put("hibernate.hbm2ddl.auto",
    		  "update");
      properties.put("hibernate.dialect",
        "org.hibernate.dialect.MySQL5Dialect");
      properties.put("show-sql",
    	        "true");
    return builder
      .dataSource(dataSource)
      .packages("com.boot.database.model")
      .persistenceUnit("foo")
      .properties(properties)
      .build();
  }
    
  @Primary
  @Bean(name = "transactionManager")
  public PlatformTransactionManager transactionManager(
    @Qualifier("entityManagerFactory") EntityManagerFactory 
    entityManagerFactory
  ) {
    return new JpaTransactionManager(entityManagerFactory);
  }
}