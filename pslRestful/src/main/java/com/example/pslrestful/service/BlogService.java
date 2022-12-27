package com.example.pslrestful.service;

import com.example.pslrestful.dto.BlogRequestDto;
import com.example.pslrestful.entity.Blog;
import com.example.pslrestful.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    @Transactional
    public Blog createBlog(BlogRequestDto requestDto) {
        Blog memo = new Blog(requestDto);
        blogRepository.save(memo);
        return memo;
    } //블로그 글 생성



    @Transactional(readOnly = true)
    public List<Blog> getBlogs() { //return memoRepository.findAllByOrderByModifiedAtDesc();
                      return blogRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt")); }
    //글 불러올 때, 내림차순으로 정렬해서 불러오기.

    @Transactional(readOnly = true)
    public List<Blog> getBlog(Long id) { //return memoRepository.findAllByOrderByModifiedAtDesc();
        return (List<Blog>) blogRepository.getOne(id); }
    //특정 id만 불러오기.


    @Transactional
    public Long update(Long id, BlogRequestDto requestDto) { //BlogRequestDto > pwd
        Blog memo = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }
    // 글 수정

    @Transactional
    public Long deleteBlog(Long id, String pwd) {
        blogRepository.deleteById(id);
        return id;
    }
    // 글 삭제



}
