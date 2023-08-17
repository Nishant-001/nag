package com.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.util.Date;

@Getter
@Setter
public class ProductDto {

    private Long id;

    private String name;

    private String code;

    private String discount;

    private Long price;

    private String description;

    private MultipartFile img;

    private byte[] returnedImg;

    private Long categoryId;

    private String categoryName;

}
