package com.photoalbum.dodo.service;


import com.photoalbum.dodo.model.Members;
import com.photoalbum.dodo.model.Photos;

import java.util.List;

public interface PhotosService {

    List<Photos> getAllPhotos(Members member);

    Photos InsertPhoto(Photos photo);
}
