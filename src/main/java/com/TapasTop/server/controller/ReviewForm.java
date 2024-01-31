package com.TapasTop.server.controller;

public record ReviewForm(Integer rate, String comment, long userId, long dishId) {
}
