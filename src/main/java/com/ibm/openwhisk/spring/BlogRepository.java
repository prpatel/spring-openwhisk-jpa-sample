package com.ibm.openwhisk.spring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogRepository extends JpaRepository<BlogEntry, Integer> {
}
