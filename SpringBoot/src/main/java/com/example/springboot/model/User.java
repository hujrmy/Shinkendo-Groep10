package com.example.springboot.model;

public record User(
        int rights,
        String name,
        Dojo dojo,
        String rank
) {
}
