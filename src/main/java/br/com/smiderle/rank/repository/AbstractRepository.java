package br.com.smiderle.rank.repository;

import br.com.smiderle.rank.spring.jdbc.RepositoryTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ladairsmiderle on 12/05/2016.
 */
public abstract class AbstractRepository {

    @Autowired
    RepositoryTemplate repositoryTemplate;
}
