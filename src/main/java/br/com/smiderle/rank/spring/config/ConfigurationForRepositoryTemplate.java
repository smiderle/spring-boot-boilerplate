package br.com.smiderle.rank.spring.config;

import br.com.smiderle.rank.spring.jdbc.PostrgresAbstractTemplate;
import br.com.smiderle.rank.spring.jdbc.RepositoryTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

/**
 * Created by diego.lovison on 15/09/2015.
 */
@Configuration
@AutoConfigureAfter(ConfigurationForDataSource.class)
public class ConfigurationForRepositoryTemplate {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    RepositoryTemplate repositoryTemplate() throws SQLException {

        PostrgresAbstractTemplate producer = new PostrgresAbstractTemplate(jdbcTemplate);

        return producer;
    }
}
