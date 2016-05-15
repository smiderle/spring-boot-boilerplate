package br.com.smiderle.rank.spring.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by diego.lovison on 04/03/2016.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan({"br.com.smiderle.rank"})
public class ConfigurationForComponentScan {
}
