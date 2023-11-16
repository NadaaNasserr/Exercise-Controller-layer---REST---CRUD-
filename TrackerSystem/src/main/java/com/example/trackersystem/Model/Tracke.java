package com.example.trackersystem.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tracke {
    private String id;
    private String title;
    private String description;
    private String status;

}
