package com.ecommerce.entity;


import com.ecommerce.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private String role;

    @Lob
    private byte[] img;

    public User(String email, String encode, String name, String role) {
    }


    public UserDto mapUsertoUserDto() {
        return new UserDto(id, email, name, role);
    }

    public UserDto getUserDto() {
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setName(name);
        userDto.setEmail(email);
        userDto.setRole(role);
        userDto.setReturnedImg(img);
        return userDto;
    }
}
