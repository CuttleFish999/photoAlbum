package com.photoalbum.dodo.dao;

import com.photoalbum.dodo.model.Photos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PhotoFrontEndRepository extends JpaRepository<Photos, Integer> {
    // Generic pagination method for all photos
    Page<Photos> findAll(Pageable pageable);
}

