package com.example.picturemanager.controller;

import com.example.picturemanager.model.Picture;
import com.example.picturemanager.model.PictureForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.example.picturemanager.service.IPictureService;
import com.example.picturemanager.service.PictureService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/picture")
public class PictureController {
    private final IPictureService pictureService = new PictureService();

    @GetMapping("")
    public String index(Model model) {
        List<Picture> pictures = pictureService.findAll();
        model.addAttribute("pictures", pictures);
        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("pictureForm", new PictureForm());
        return modelAndView;
    }
    @Value("${file-upload}")
    private String fileUpload;
    @PostMapping("/save")
    public ModelAndView savePicture(@ModelAttribute PictureForm pictureForm){
        MultipartFile multipartFile = pictureForm.getImage();
        String fileName = multipartFile.getName();
        try {
            FileCopyUtils.copy(pictureForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Picture picture = new Picture(pictureForm.getId(), pictureForm.getCode(), pictureForm.getHeight(), pictureForm.getWide(),
                pictureForm.getDescription(), pictureForm.getMaterial(), pictureForm.getPrice(), fileName);
        pictureService.save(picture);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("pictureForm", pictureForm);
        modelAndView.addObject("message", "Create new picture successfully!");
        return modelAndView;
    }
}