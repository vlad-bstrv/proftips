package ru.vladbstrv.proftips.service;


import ru.vladbstrv.proftips.model.Image;
import ru.vladbstrv.proftips.repository.ImageRepository;
import ru.vladbstrv.proftips.utils.ImageUtils;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.Optional;

//@Service
public class ImageService {
//    private final ImageRepository imageRepository;
//
//    public ImageService(ImageRepository imageRepository) {
//        this.imageRepository = imageRepository;
//    }
//
//    public String uploadImage(MultipartFile file) throws IOException {
//        byte[] scale = ImageUtils.scale(file.getBytes());
//        imageRepository.save(Image.builder()
//                .name(file.getOriginalFilename())
//                .type(file.getContentType())
//                .imageData(ImageUtils.compressImage(scale))
//                .build());
//        return "file uploaded success : " + file.getOriginalFilename();
//    }
//
//    public byte[] downloadImage(String fileName) {
//        Optional<Image> dbImageData = imageRepository.findByName(fileName);
//        return ImageUtils.decompressImage(dbImageData.get().getImageData());
//    }
}
