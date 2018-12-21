package com.uinnova.zgdemo.po;

import javax.persistence.*;

/**
 * 基站类
 */
@Entity
@Table(name = "basestation")
public class BaseStation {
    @Id
    private Integer baseId;//基站编号
    @Column
    private  String BaseName;//基站名称
    @Column
    private  String BaseImg;//基站配图
    @Column
    private  String BaseKind;//基站种类
    @Column
    private  String BaseUrl;//基站url
    @Column
    private  String jingdu;//基站经度
    @Column
    private  String weidu;//基站纬度

    public String getBaseImg() {
        return BaseImg;
    }

    public void setBaseImg(String baseImg) {
        BaseImg = baseImg;
    }

    public String getBaseKind() {
        return BaseKind;
    }

    public void setBaseKind(String baseKind) {
        BaseKind = baseKind;
    }

    public String getBaseUrl() {
        return BaseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        BaseUrl = baseUrl;
    }

    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    public String getBaseName() {
        return BaseName;
    }

    public void setBaseName(String baseName) {
        BaseName = baseName;
    }

    public String getJingdu() {
        return jingdu;
    }

    public void setJingdu(String jingdu) {
        this.jingdu = jingdu;
    }

    public String getWeidu() {
        return weidu;
    }

    public void setWeidu(String weidu) {
        this.weidu = weidu;
    }
}
