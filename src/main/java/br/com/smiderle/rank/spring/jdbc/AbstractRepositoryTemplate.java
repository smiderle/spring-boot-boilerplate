package br.com.smiderle.rank.spring.jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by ladair smiderle on 13/05/2016.
 */
public abstract class AbstractRepositoryTemplate implements RepositoryTemplate {

    private JdbcTemplate jdbcTemplate;

    public AbstractRepositoryTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <T> List<T> query(String sql, Map<String, Object> parameters, RowMapper<T> rowMapper) {

        return createNamedParameterJdbcTemplate().query(sql, parameters, rowMapper);
    }

 /*   @Override
    public <T> List<T> query( String sql, Map<String, Object> parameters, RowMapper<T> rowMapper, IPaginacaoDTO paginacao ) {

        return query( transformSql( sql, paginacao ), parameters, rowMapper );
    }*/

    @Override
    public <T> T query(String sql, Map<String, ?> parameters, ResultSetExtractor<T> rse) {

        return createNamedParameterJdbcTemplate().query(sql, parameters, rse);
    }

 /*   @Override
    public <T> T query( String sql, Map<String, ?> parameters, ResultSetExtractor<T> rse, IPaginacaoDTO paginacao ) {

        return query( transformSql( sql, paginacao ), parameters, rse );
    }*/

    @Override
    public <T> T queryForObject(String sql, Map<String, Object> parameters, RowMapper<T> rowMapper) {

        try {
            return createNamedParameterJdbcTemplate().queryForObject(sql, parameters, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public <T> T queryForObject(String sql, Map<String, Object> parameters, Class<T> requiredType) {

        try {
            return createNamedParameterJdbcTemplate().queryForObject(sql, parameters, requiredType);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public NamedParameterJdbcTemplate createNamedParameterJdbcTemplate() {

        return new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper) throws DataAccessException {

        return jdbcTemplate.query(sql, rowMapper);
    }

    /*  @Override
      public <T> List<T> query( String sql, RowMapper<T> rowMapper, IPaginacaoDTO paginacao ) throws DataAccessException {

          return query( transformSql( sql, paginacao ), rowMapper );
      }
  */
    @Override
    public <T> T query(String sql, ResultSetExtractor<T> extractor) throws DataAccessException {

        return jdbcTemplate.query(sql, extractor);
    }

    /*@Override
    public <T> T query( String sql, ResultSetExtractor<T> extractor, IPaginacaoDTO paginacao ) throws DataAccessException {

        return query( transformSql( sql, paginacao ), extractor );
    }
*/
    @Override
    public List<Map<String, Object>> queryForList(String sql) {

        return jdbcTemplate.queryForList(sql);
    }
/*
    @Override
    public List<Map<String, Object>> queryForList( String sql, IPaginacaoDTO paginacao ) {

        return queryForList( transformSql( sql, paginacao ) );
    }*/

  /*  @Override
    public List<Map<String, Object>> queryForList( String sql, Map<String, Object> parameters, IPaginacaoDTO paginacao ) {

        return createNamedParameterJdbcTemplate().queryForList( transformSql( sql, paginacao ), parameters );
    }*/

    @Override
    public <T> T queryForObject(String sql, Object[] args, RowMapper<T> rowMapper) throws DataAccessException {

        return jdbcTemplate.queryForObject(sql, args, rowMapper);
    }

    // ------------------------ template insert
    @Override
    public Long insert(String sql, Map<String, Object> parameters) {

        MapSqlParameterSource parameterSource = new MapSqlParameterSource(parameters);

        final KeyHolder keyHolder = new GeneratedKeyHolder();

        createNamedParameterJdbcTemplate().update(sql, parameterSource, keyHolder);

        Long id = keyHolder.getKey().longValue();

        return id;
    }

    @Override
    public Map<String, Object> insert(String sql, Map<String, Object> parameters, String[] fields) {

        MapSqlParameterSource parameterSource = new MapSqlParameterSource(parameters);

        final KeyHolder keyHolder = new GeneratedKeyHolder();

        createNamedParameterJdbcTemplate().update(sql, parameterSource, keyHolder, fields);

        return keyHolder.getKeys();

    }

    @Override
    public Long insert(String sql, Map<String, Object> parameters, String id) {

        MapSqlParameterSource parameterSource = new MapSqlParameterSource(parameters);

        final KeyHolder keyHolder = new GeneratedKeyHolder();

        createNamedParameterJdbcTemplate().update(sql, parameterSource, keyHolder, new String[]{id});

        return keyHolder.getKey().longValue();
    }

    @Override
    public void insertWihtoutGeneratedKey(String sql, Map<String, Object> parameters) {

        MapSqlParameterSource parameterSource = new MapSqlParameterSource(parameters);

        createNamedParameterJdbcTemplate().update(sql, parameterSource);

    }

    @Override
    public void update(String sql, Map<String, Object> parameters) {

        MapSqlParameterSource parameterSource = new MapSqlParameterSource(parameters);

        createNamedParameterJdbcTemplate().update(sql, parameterSource);
    }

    @Override
    public void delete(String sql, Map<String, Object> parameters) {

        MapSqlParameterSource parameterSource = new MapSqlParameterSource(parameters);

        createNamedParameterJdbcTemplate().update(sql, parameterSource);
    }

    // ------------------------ data source
    @Override
    public DataSource getDataSource() {
        return jdbcTemplate.getDataSource();
    }

    @Override
    public ResultSet getViews(String viewPattern) {

        try {
            return getDatabaseMetaData().getTables(null, getCurrentSchema(), viewPattern, new String[]{"VIEW"});
        } catch (SQLException e) {
            throw new RuntimeException("impossivel.recuperar.views.do.banco", e);
        }
    }

    @Override
    public ResultSet getTables(String tableNamePattern) {

        try {
            return getDatabaseMetaData().getTables(null, getCurrentSchema(), tableNamePattern, new String[]{"TABLE"});
        } catch (SQLException e) {
            throw new RuntimeException("impossivel.recuperar.tabelas.do.banco", e);
        }
    }

    @Override
    public ResultSet getColumns(String tableNamePattern) {

        try {
            return getDatabaseMetaData().getColumns(null, getCurrentSchema(), tableNamePattern, null);
        } catch (SQLException e) {
            throw new RuntimeException("impossivel.recuperar.colunas.da.view");
        }
    }

    protected DatabaseMetaData getDatabaseMetaData() {
        try {
            return getConnection().getMetaData();
        } catch (SQLException e) {
            throw new RuntimeException("impossivel.recuperar.metadados.do.banco", e);
        }
    }

    protected Connection getConnection() {
        try {
            return DataSourceUtils.getConnection(getDataSource());
        } catch (CannotGetJdbcConnectionException e) {
            throw new RuntimeException("impossivel.recuperar.conexao.com.banco.de.dados", e);
        }
    }


    protected String getCurrentSchema() {

        try {
            return getConnection().getMetaData().getUserName().toUpperCase();
        } catch (SQLException e) {
            throw new RuntimeException("impossivel.recuperar.schema", e);
        }
    }

    @Override
    public void execute(String sql) {

        jdbcTemplate.execute(sql);
    }

}
