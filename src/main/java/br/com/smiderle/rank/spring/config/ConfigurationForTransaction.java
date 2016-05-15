package br.com.smiderle.rank.spring.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * Created by Ladair Smiderle on 15/05/2016.
 */
@Configuration
@EnableTransactionManagement
@AutoConfigureAfter(ConfigurationForDataSource.class)
public class ConfigurationForTransaction {

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){

        DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource);
        manager.setGlobalRollbackOnParticipationFailure(true);

        return manager;
    }
}
