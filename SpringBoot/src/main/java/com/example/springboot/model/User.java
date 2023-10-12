package com.example.springboot.model;

public record User(
        Rights rights,
        String name,
        Dojo dojo,
        Rank rank
) {
}
