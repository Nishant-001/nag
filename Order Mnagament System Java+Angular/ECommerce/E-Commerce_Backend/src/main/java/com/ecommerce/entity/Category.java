package com.ecommerce.entity;

import com.ecommerce.dto.CategoryDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    public void getCategoryEntity(CategoryDto categoryDto) {
        this.name = categoryDto.getName();
        this.description = categoryDto.getDescription();
    }

    public CategoryDto getCategoryDto() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(id);
        categoryDto.setName(name);
        categoryDto.setDescription(description);
        return categoryDto;
    }

}
