package com.photoalbum.dodo.dao;

import com.photoalbum.dodo.model.Photos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PhotoFrontEndRepository extends JpaRepository<Photos,Integer> {
}
