package com.activiti.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

/**
 * 测试类：
 *      创建25张表
 */
public class ActivitiTest {

    /**
     * 以简单的方式去获取表
     */
    @Test
    public void test1() {
        //条件：这两点不能乱写否则报错
        //1.配置文件必须为activiti.cfg.xml
        //2.spring beans 里面的id 一定是processEngineConfiguration
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine);
    }


    /**
     * 以读取配置文件去获取表
     */
    @Test
    public void ActivitiTest() {

        // 1.通过ProcessEngineConfiguration获取配置文件
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");

        // 2.通过buildProcessEngine这个方法去得到ProcessEngine 流程引擎对象
        ProcessEngine processEngine = configuration.buildProcessEngine();

        System.out.println(processEngine);
    }

}
