package ru.vladbstrv.proftips.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name= "image")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class Image {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
//    @Lob
//    @Column(name = "imageData", length = 10000)
    private byte[] imageData;
//    @OneToOne(mappedBy = "image")
    private User user;
}