package com.example.pslrestful.controller;

import com.example.pslrestful.dto.BlogRequestDto;
import com.example.pslrestful.entity.Blog;
import com.example.pslrestful.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogController {

    private final BlogService memoService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @PostMapping("/api/posts")
    public Blog createBlog(@RequestBody BlogRequestDto requestDto) {
        return memoService.createBlog(requestDto); //memoService.
    } // 글 작성

    @GetMapping("/api/posts")
    public List<Blog> getBlogs() {
        return memoService.getBlogs();
    } // 모든 글 불러오기 (작성일 내림차순)


    //선택된 글 RUD
    @GetMapping("/api/posts/{id}")
    public List<Blog> getBlog(Long id) {
        return memoService.getBlog(id);
    } // 특정 글만 불러오기


    @PutMapping("/api/posts/{id}")
    public Long updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto,@PathVariable String pwd ) {
        return memoService.update(id, requestDto);
    } // 글 작성시 비밀번호 부여 , 저장된 게시글을 Client로 반환 한다.

    @DeleteMapping("/api/posts/{id}")
    public Long deleteBlog(@PathVariable Long id, @PathVariable String pwd) {
        return memoService.deleteBlog(id, pwd);
    } // 글 삭제 시 비밀번호 기입

}