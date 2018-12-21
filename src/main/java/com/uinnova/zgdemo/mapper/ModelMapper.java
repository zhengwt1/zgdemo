package com.uinnova.zgdemo.mapper;

import com.uinnova.zgdemo.po.Models;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ModelMapper extends JpaRepository<Models,String> {

    /**
     * 根据场景查找模型
     * @param scene 场景编号
     * @return
     */
    @Query(value = "select * from model where scene=:scene",nativeQuery = true)
    public List<Models> findByScene(@Param("scene") String scene);

}
