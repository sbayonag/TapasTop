package com.TapasTop.server.resource;

public record ReviewForm(Integer rate, String comment, Long userId, long dishId) {
}
