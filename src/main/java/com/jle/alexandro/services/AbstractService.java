package com.jle.alexandro.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AbstractService<T> {
    List<T> findAll();
    Page<T> findAllPageable(Pageable pageable);
    T findById(Integer id);
    T create(T resource);
    T update(T resource);
    void delete(Integer id);
}
