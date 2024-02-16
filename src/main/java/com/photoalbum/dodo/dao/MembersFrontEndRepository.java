package com.photoalbum.dodo.dao;

import com.photoalbum.dodo.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersFrontEndRepository extends JpaRepository<Members, Integer> {
    Members findByAccount(String account);
}
