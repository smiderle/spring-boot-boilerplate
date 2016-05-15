package br.com.smiderle.rank.spring.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by ladairsmiderle on 13/05/2016.
 */
public class PostrgresAbstractTemplate extends AbstractRepositoryTemplate {

    public PostrgresAbstractTemplate(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public String getSql(String nomeTabela) {
        return null;
    }

    @Override
    public boolean isOlapFunction(String texto) {
        return false;
    }

    @Override
    public boolean isAggregateFunction(String texto) {
        return false;
    }

    @Override
    public String[] getAggregateValues() {
        return new String[0];
    }

    @Override
    public int countAggregateFunction(String texto) {
        return 0;
    }

    @Override
    public String adicionaOverBy(String expressao, String... overBy) {
        return null;
    }
}