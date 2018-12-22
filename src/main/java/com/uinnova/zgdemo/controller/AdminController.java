package com.uinnova.zgdemo.controller;

import com.uinnova.zgdemo.Service.IBaseStationService;
import com.uinnova.zgdemo.Service.IModelService;
import com.uinnova.zgdemo.Service.impl.BaseStationServcieImpl;
import com.uinnova.zgdemo.po.BaseStation;
import com.uinnova.zgdemo.po.Models;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 */
@Controller
public class AdminController {

    @Autowired
    public IBaseStationService baseStationService;

    @Autowired
    public IModelService modelService;

    /**
     * 跳转登录页面
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "login.html";
    }

    /**
     * 登录
     *
     * @param name     用户名
     * @param password 用户密码
     * @return
     */
    @RequestMapping("login")
    public String login(String name, String password) {
        if ("zhangsan".equals(name) && "123456".equals(password)) {
            return "index.html";
        }
        return "login.html";
    }

    @RequestMapping("temp")
    public String temp(String name, String password) {
            return "index.html";
    }
    /**
     * 跳转管理页
     *
     * @return
     */
    @RequestMapping("admin")
    public String admin(HttpServletRequest request) {
        List<BaseStation> bsList = baseStationService.selectBaseStaion();
        request.setAttribute("bslist", bsList);
        return "admin.html";
    }


    /**
     * 查询所有基站信息
     *
     * @return
     */
    @RequestMapping("selectBaseStataion")
    @ResponseBody
    public List<BaseStation> selectBaseStataion() {
        List<BaseStation> bsList = baseStationService.selectBaseStaion();
        return bsList;
    }

    /**
     * 复制基站
     */
    @RequestMapping("copyBaseStation")
    @ResponseBody
    public String copyBaseStation(BaseStation baseStation) {
        int count = baseStationService.count();
        baseStation.setBaseId(count + 1);
        baseStationService.insert(baseStation);
        return "ok";
    }

    /**
     * 计算基站数量
     *
     * @param request
     * @return
     */
    @RequestMapping("count")
    public String count(HttpServletRequest request) {
        int title = baseStationService.count();
        request.setAttribute("title", title);
        return "index";
    }

    /**
     * 安id查找基站url
     *
     * @param title 基站id
     * @return
     */
    @RequestMapping("lookOneBS")
    public String lookOneBS(String title,HttpServletRequest request) {
        String url = baseStationService.selectOne(title).getBaseUrl();
        request.setAttribute("t",title);
        return url;
    }

    /**
     * 查询一个基站的信息
     *
     * @param title
     * @return
     */
    @RequestMapping("queryBS")
    @ResponseBody
    public BaseStation queryBS(String title) {
        BaseStation baseStation = baseStationService.selectOne(title);
        return baseStation;
    }

    /**
     * 跳转地图页面
     *
     * @param title   添加基站图标的title
     * @param request
     * @return
     */
    @RequestMapping("addMarker")
    public String addMarker(Integer title, HttpServletRequest request) {
        request.setAttribute("t", title);
        return "index.html";
    }

    /**
     * 设置基站的经纬度
     *
     * @param baseStation
     * @return
     */
    @RequestMapping("addMarkerPosition")
    @ResponseBody
    public String addMarkerPosition(String baseId, BaseStation baseStation) {
        if (""==baseId||null==baseId){
            return "no";
        }
        if (null!=baseStationService.selectOne(baseId)){//判断基站是否已经制定位置
            int baseid=Integer.parseInt(baseId);
            System.out.print(baseStation.getJingdu()+baseStation.getWeidu());
            baseStationService.updateBSPosition(baseid,baseStation.getJingdu(),baseStation.getWeidu());
            return "ok";
        }
        BaseStation bs = baseStationService.selectOne(baseId);
        bs.setJingdu(baseStation.getJingdu());
        bs.setWeidu(baseStation.getWeidu());
        baseStationService.insert(bs);
        return "ok";
    }

    /**
     * 删除基站信息
     *
     * @return
     */
    @RequestMapping("delBS")
    @ResponseBody
    public String delBS(int baseId) {
        if (baseId==1 || baseId==2){
            return "no";
        }
        baseStationService.deleteBS(baseId);
        return "ok";
    }

    /**
     * 模糊查询基站
     * @param name
     * @param request
     * @return
     */
    @RequestMapping("selectLikeName")
    public String selectLikeName(String name,  HttpServletRequest request) {
        List<BaseStation> bsList = baseStationService.selectLikeName(name);
        System.out.print("长度"+bsList.size());
        request.setAttribute("bslist", bsList);
        return "admin.html";
    }

    /**
     * 保存模型
     * @param models
     * @param request
     * @return
     */
    @RequestMapping("saveMode")
    @ResponseBody
    public String saveMode(Models models,HttpServletRequest request){
        String position[]=null;
        position=request.getParameterValues("position");//获取arry类型
        List<Models> modelsList=modelService.selectAllModels(models.getScene());
        for (Models model:modelsList) {
            if (model.getModelId().equals(models.getModelId())){
                modelService.delModels(model.getModelId());
            }
        }
        models.setPositionX(position[0]);
        models.setPositionY(position[1]);
        models.setPositionZ(position[2]);
        modelService.saveModel(models);
        return "ok";
    }

    /**
     * 查询对应场景内的所有模型
     * @param scene
     * @return
     */
    @RequestMapping("selectAllModels")
    @ResponseBody
    public List<Models> selectAllModels(String scene){
        List<Models> modelsList=modelService.selectAllModels(scene);
        return modelsList;
    }

    /**
     * 删除对应场景内的模型
     * @param scene 场景的编号
     * @return
     */
    @RequestMapping("delModelsByScene")
    @ResponseBody
    public String delModelsByScene(String scene){
        List<Models> modelsList=modelService.selectAllModels(scene);
        for (Models model:modelsList) {
                modelService.delModels(model.getModelId());
        }
        return "ok";
    }
}
