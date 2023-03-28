package com.example.picturemanager.service;

import com.example.picturemanager.model.Picture;

import java.util.ArrayList;
import java.util.List;

public class PictureService implements IPictureService {
    List<Picture> pictures = new ArrayList<>();
    @Override
    public List<Picture> findAll() {
        return pictures;
    }

    @Override
    public void save(Picture picture) {
        pictures.add(picture);
    }

    @Override
    public Picture findById(int id) {
        return pictures.get(id);
    }

    @Override
    public void update(int id, Picture picture) {
        for (Picture p:
             pictures) {
            if (p.getId() == id){
                p=picture;
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < pictures.size(); i++) {
            if (pictures.get(id).getId() == id){
                pictures.remove(i);
                break;
            }
        }
    }
}
