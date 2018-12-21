package com.uinnova.zgdemo.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 模型类
 */
@Entity
@Table(name = "model")
public class Models {
    @Id
    private  String modelId;//模型编号
    @Column
    public String scene;//所属场景
    @Column
    private  String modelType;//模型种类

    @Column
    private  String modelUrl;//模型的路径

    @Column
    private  String positionX;//模型的位置x轴
    @Column
    private  String positionY;//模型的位置y轴
    @Column
    private  String positionZ;//模型的位置z轴

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getModelUrl() {
        return modelUrl;
    }

    public void setModelUrl(String modelUrl) {
        this.modelUrl = modelUrl;
    }

    public String getPositionX() {
        return positionX;
    }

    public void setPositionX(String positionX) {
        this.positionX = positionX;
    }

    public String getPositionY() {
        return positionY;
    }

    public void setPositionY(String positionY) {
        this.positionY = positionY;
    }

    public String getPositionZ() {
        return positionZ;
    }

    public void setPositionZ(String positionZ) {
        this.positionZ = positionZ;
    }
}
