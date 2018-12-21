package com.uinnova.zgdemo.Service.impl;

import com.uinnova.zgdemo.Service.IModelService;
import com.uinnova.zgdemo.mapper.ModelMapper;
import com.uinnova.zgdemo.po.Models;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements IModelService {

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public void saveModel(Models models) {
        modelMapper.saveAndFlush(models);
    }

    @Override
    public List<Models> selectAllModels(String scene) {
        return modelMapper.findByScene(scene);
    }

    @Override
    public void delModels(String id) {
      modelMapper.deleteById(id);
    }
}
