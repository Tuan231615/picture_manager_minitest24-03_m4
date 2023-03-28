package com.example.picturemanager.model;

import org.springframework.web.multipart.MultipartFile;

public class PictureForm {
    private int id;
    private String code;
    private String height;
    private String wide;
    private String material;
    private String description;
    private double price;
    private MultipartFile image;

    public PictureForm() {
    }

    public PictureForm(int id, String code, String height, String wide, String material, String description, double price, MultipartFile image) {
        this.id = id;
        this.code = code;
        this.height = height;
        this.wide = wide;
        this.material = material;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWide() {
        return wide;
    }

    public void setWide(String wide) {
        this.wide = wide;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
