package br.com.smiderle.rank.spring.jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * Created by ladair smiderle on 13/05/2016.
 */
public interface RepositoryTemplate {

    // ------------------------ named parameter
    <T> List<T> query(String sql, Map<String, Object> parameters, RowMapper<T> rowMapper);

    //<T> List<T> query(String sql, Map<String, Object> parameters, RowMapper<T> rowMapper, IPaginacaoDTO paginacao);

    <T> T query(String sql, Map<String, ?> parameters, ResultSetExtractor<T> rse);

    //<T> T query(String sql, Map<String, ?> parameters, ResultSetExtractor<T> rse, IPaginacaoDTO paginacao);

    <T> T queryForObject(String sql, Map<String, Object> parameters, RowMapper<T> rowMapper);

    NamedParameterJdbcTemplate createNamedParameterJdbcTemplate();

    // ------------------------ template query
    <T> List<T> query(String sql, RowMapper<T> rowMapper) throws DataAccessException;

    //<T> List<T> query(String sql, RowMapper<T> rowMapper, IPaginacaoDTO paginacao) throws DataAccessException;

    <T> T query(String sql, ResultSetExtractor<T> extractor) throws DataAccessException;

    //<T> T query(String sql, ResultSetExtractor<T> extractor, IPaginacaoDTO paginacao) throws DataAccessException;

    List<Map<String, Object>> queryForList(String sql);

    //List<Map<String, Object>> queryForList(String sql, IPaginacaoDTO paginacao);

    //List<Map<String, Object>> queryForList(String sql, Map<String, Object> parameters, IPaginacaoDTO paginacao);

    <T> T queryForObject(String sql, Object[] args, RowMapper<T> rowMapper) throws DataAccessException;

    <T> T queryForObject(String sql, Map<String, Object> parameters, Class<T> requiredType);

    // ------------------------ template insert, update and delete
    Long insert(String sql, Map<String, Object> parameters);

    Map<String, Object> insert(String sql, Map<String, Object> parameters, String[] keys);

    Long insert(String sql, Map<String, Object> parameters, String key);

    /**
     * Efetua um insert, sem retornar a chave primária que foi gerada.
     * Utilizado para fazer insert em:
     * * tabelas sem chave primária;
     * * que não tenha geração automática de chave. (Poder)
     * * Casos em que tenha geração de chave automáticamente, mas não precisa do retorno da chave.
     * @param sql - SQL com o Insert.
     * @param parameters - Parâmetros para ser subtituido no insert.
     */
    void insertWihtoutGeneratedKey(String sql, Map<String, Object> parameters);

    void update(String sql, Map<String, Object> parameters);

    void delete(String sql, Map<String, Object> parameters);

    // ------------------------ data source
    DataSource getDataSource();

    ResultSet getViews(String viewPattern);

    ResultSet getTables(String tableNamePattern);

    ResultSet getColumns(String tableNamePattern);

    // ------------------------ execute
    void execute(String sql);

    // ------------------------ sql
    //String transformSql(String sql, IPaginacaoDTO paginacao);

    String getSql(String nomeTabela);

    // ------------------------ function
    boolean isOlapFunction(String texto);

    boolean isAggregateFunction(String texto);

    String[] getAggregateValues();

    int countAggregateFunction(String texto);

    String adicionaOverBy(String expressao, String... overBy);
}
