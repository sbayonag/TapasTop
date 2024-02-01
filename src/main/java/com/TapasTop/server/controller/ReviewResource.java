package com.TapasTop.server.controller;

import com.TapasTop.server.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;

@BasePathAwareController("/reviews")
public class ReviewResource {

  @Autowired
  ReviewService reviewService;

}
