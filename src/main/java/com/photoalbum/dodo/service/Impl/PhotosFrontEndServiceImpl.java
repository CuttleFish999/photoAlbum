package com.photoalbum.dodo.service.Impl;

import com.photoalbum.dodo.dao.PhotoFrontEndRepository;
import com.photoalbum.dodo.model.Members;
import com.photoalbum.dodo.model.Photos;
import com.photoalbum.dodo.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotosFrontEndServiceImpl implements PhotosService {

    @Autowired
    private PhotoFrontEndRepository photoFrontEndRepository;
    @Override
    public List<Photos> getAllPhotos(Members member) {
        return photoFrontEndRepository.findAll();
    }

    @Override
    public Photos InsertPhoto(Photos photo) {
        return photoFrontEndRepository.save(photo);
    }



    public Page<Photos> getAllPhotos(Pageable pageable) {
        return photoFrontEndRepository.findAll(pageable);
    }

    @Override
    public byte[] PhotosByID(Integer photoId) {

        byte[] image = photoFrontEndRepository.findById(photoId).get().getFilepath();

        return image;
    }

}
