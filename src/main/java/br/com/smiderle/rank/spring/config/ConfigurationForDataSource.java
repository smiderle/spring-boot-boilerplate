package br.com.smiderle.rank.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by diego.lovison on 15/09/2015.
 */
@Configuration
public class ConfigurationForDataSource {

    @Value("${datasource.name}")
    String datasource;

    @Bean(name = "dataSource", destroyMethod = "")
    public DataSource jndiDataSource() throws IllegalArgumentException, NamingException, SQLException {

        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName(datasource);
        bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();

        DataSource ds = (DataSource) bean.getObject();

        Connection connection = DataSourceUtils.getConnection(ds);

        connection.close();

        return ds;
    }
}
