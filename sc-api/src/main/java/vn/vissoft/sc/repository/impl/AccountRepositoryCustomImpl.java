package vn.vissoft.sc.repository.impl;

import org.springframework.stereotype.Repository;
import vn.vissoft.sc.repository.AccountRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AccountRepositoryCustomImpl implements AccountRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;


}
