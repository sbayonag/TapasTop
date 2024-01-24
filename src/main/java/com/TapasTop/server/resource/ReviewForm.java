package com.TapasTop.server.resource;

public record ReviewForm(Integer rate, String comment, long userId, long dishId) {
}
