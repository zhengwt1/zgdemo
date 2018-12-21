package com.uinnova.zgdemo.Service.impl;

import com.uinnova.zgdemo.Service.IBaseStationService;
import com.uinnova.zgdemo.mapper.BaseStationMapper;
import com.uinnova.zgdemo.po.BaseStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 基站service层实现类
 *
 */
@Service
public class BaseStationServcieImpl implements IBaseStationService {
    @Autowired
    public BaseStationMapper baseStationMapper;

    /**
     *查找所有基站
     * @return 返回基站集合
     */
    @Override
    public List<BaseStation> selectBaseStaion() {
        return baseStationMapper.findAll();
    }

    @Override
    public BaseStation selectOne(String title) {
        return baseStationMapper.findOne(title);
    }

    @Override
    public void insert( BaseStation baseStation) {
        baseStationMapper.saveAndFlush(baseStation);
    }

    @Override
    public int count() {
        return baseStationMapper.countAllByBaseId();
    }

    @Override
    public void deleteBS(int id) {
        baseStationMapper.deleteById(id);
    }

    @Override
    public List<BaseStation> selectLikeName(String name) {
        System.out.print("name"+name);
        return baseStationMapper.selectLikeBSName(name);
    }


}
