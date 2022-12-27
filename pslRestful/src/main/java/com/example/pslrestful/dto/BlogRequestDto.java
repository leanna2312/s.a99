package com.example.pslrestful.dto;

import lombok.Getter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
public class BlogRequestDto {

    private String username;

    private String title;
    private String contents;

   // private BigInteger blogging_date;

    private String pwd;

   // public LocalDateTime createdAt;

  //  public LocalDateTime modifiedAt;


}