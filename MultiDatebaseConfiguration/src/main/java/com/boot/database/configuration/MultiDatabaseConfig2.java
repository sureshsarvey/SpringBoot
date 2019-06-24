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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "barentityManagerFactory",
  basePackages = {"com.boot.database.testrepo"}
)
@EntityScan(basePackages = {"com.boot.database.test.model"})
public class MultiDatabaseConfig2 {
  
  @Bean(name = "bardataSource")
  @ConfigurationProperties(prefix = "spring.second.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }
  
  @Bean(name = "barentityManagerFactory")
  public LocalContainerEntityManagerFactoryBean 
  entityManagerFactory(
    EntityManagerFactoryBuilder builder,
    @Qualifier("bardataSource") DataSource dataSource
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
      .packages("com.boot.database.test.model")
      .persistenceUnit("bar")
      .properties(properties)
      .build();
  }
    
  @Bean(name = "bartransactionManager")
  public PlatformTransactionManager transactionManager(
    @Qualifier("barentityManagerFactory") EntityManagerFactory 
    entityManagerFactory
  ) {
    return new JpaTransactionManager(entityManagerFactory);
  }
}