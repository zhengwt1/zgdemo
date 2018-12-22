package com.uinnova.zgdemo.mapper;

import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.Mapping;
import com.uinnova.zgdemo.po.BaseStation;

import java.util.List;

/**
 * jpa接口
 */
@Repository
public interface BaseStationMapper extends JpaRepository<BaseStation,Integer> {
    /**
     *查询所有基站信息
     * @param title
     * @return
     */
    @Query(value = "select * from basestation where baseId=:title",nativeQuery = true)
    public BaseStation findOne(@Param("title") String title);

    /**
     * 查询基站最大的id
     * @return
     */
    @Query(value = "select MAX(baseId) from basestation",nativeQuery = true)
    public  int countAllByBaseId();

    /**
     * 模糊查询基站信息
     * @return
     */
    @Query(value = "select * from basestation where BaseName like CONCAT('%',:name,'%')",nativeQuery = true)
    public List<BaseStation> selectLikeBSName(@Param("name") String name);

    /**
     *修改基站的地图位置
     * @param id 基站id
     * @param jingdu 经度
     * @param weidu 纬度
     * @return
     */
    @Transactional//开启事务管理
    @Modifying
    @Query(value = "update basestation set jingdu =:jingdu,weidu=:weidu where baseId=:id",nativeQuery = true)
    public int updateBSPosition(@Param("id") int id,@Param("jingdu") String jingdu,@Param("weidu") String weidu);

}
