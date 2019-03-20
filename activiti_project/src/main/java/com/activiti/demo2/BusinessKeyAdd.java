package com.activiti.demo2;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * `act_ru_execution`  本质就是将业务标识存到businessKey
 */
public class BusinessKeyAdd {

    public static void main(String[] args) {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 启动流程实例，同时还要指定业务标识和bussinesskey   它本身就是请假单的id
        // 第一个参数： 是指业务定义key
        // 第二个参数： 业务标识businessKey    --- 业务的外键
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday", "3001");

        System.out.println(processInstance.getBusinessKey());

    }

}
