package com.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
public class CategoryDto {

    private Long id;

    private String name;

    private String description;

}
