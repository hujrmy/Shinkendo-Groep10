package com.example.springboot.auth;


import com.example.springboot.model.Dojo;
import com.example.springboot.model.Rank;
import com.example.springboot.model.Rights;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequeset {
    private String username;
    private String password;
    private String name;
    private Rank rank;
    private Dojo dojo;
    private Rights rights;

}
