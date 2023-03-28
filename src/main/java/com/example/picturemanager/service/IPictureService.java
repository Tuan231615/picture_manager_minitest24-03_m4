package com.example.picturemanager.service;

import com.example.picturemanager.model.Picture;

import java.util.List;

public interface IPictureService {
    List<Picture> findAll();
    void save(Picture picture);
    Picture findById(int id);
    void update(int id, Picture picture);
    void remove(int id);
}
