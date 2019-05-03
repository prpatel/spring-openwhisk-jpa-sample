package com.ibm.openwhisk.spring;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class BlogRepository {

    @PersistenceContext
    private EntityManager em;


    public void add(BlogEntry entry) {
        em.persist(entry);
    }

    public List<BlogEntry> findAll() {
        CriteriaQuery<BlogEntry> criteriaQuery = em.getCriteriaBuilder().createQuery(BlogEntry.class);
        @SuppressWarnings("unused")
        Root<BlogEntry> root = criteriaQuery.from(BlogEntry.class);
        return em.createQuery(criteriaQuery).getResultList();
    }
}
