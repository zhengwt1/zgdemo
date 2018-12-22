package com.uinnova.zgdemo.Service;

import com.uinnova.zgdemo.po.BaseStation;

import java.util.List;

/**
 * 基站接口
 */
public interface IBaseStationService {
    /**
     * 查询所有图标
     * @return
     */
    public List<BaseStation> selectBaseStaion();

    /**
     * 查看一个基站
     * @param title 基站id
     * @return 返回一个基站对象
     */
    public BaseStation selectOne(String title);

    /**
     * 插入基站信息
     * @param baseStation 基站对象
     */
    public void insert(BaseStation baseStation);

    /**
     * 查询基站id的最大值
     * @return
     */
    public int count();

    /**
     * 删除基站信息
     * @param id
     */
    public void deleteBS(int id);

    /**
     * 模糊查询
     * @param name 基站的名称
     * @return
     */
    public List<BaseStation> selectLikeName(String name);
}
