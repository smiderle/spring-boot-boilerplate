package br.com.smiderle.rank.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by diego.lovison on 24/09/2015.
 */
@Configuration
@AutoConfigureAfter(ConfigurationForDataSource.class)
public class ConfigurationForJdbcTemplate {

    @Value("${jdbc.fetch.size}")
    private Integer fetchSize;

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setFetchSize(fetchSize);

        return jdbcTemplate;
    }
}
