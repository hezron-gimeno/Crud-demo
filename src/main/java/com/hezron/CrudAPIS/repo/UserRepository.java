package com.hezron.CrudAPIS.repo;

import com.hezron.CrudAPIS.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    List<User> findAll();

//    Sort by Descending Order
//    Page<User> findAllOrderByIdDesc(Pageable pageable);
//    sort by the latest on
Page<User> findAllByOrderByIdDesc(Pageable pageable);
}
