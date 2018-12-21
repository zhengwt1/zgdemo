package com.uinnova.zgdemo.Service;

import com.uinnova.zgdemo.po.Models;

import java.util.List;

/**
 * 模型Service接口
 */
public interface IModelService {
    /**
     * 保存模型
     * @param models
     */
   public void saveModel(Models models);

    /**
     * 查询对应场景的模型
     * @param scene
     * @return
     */
   public List<Models> selectAllModels(String scene);

    /**
     * 根据模型id删除模型
     * @param id 模型id
     */
   public void delModels(String id);
}
