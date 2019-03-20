package com.activiti.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 启动流程实例：
 *      前提条件:必须要先执行流程定义部署之后
 * 影响的表：
 *      `act_hi_actinst`           已完成的活动信息
 *      `act_hi_identitylink`      参与者信息
 *      `act_hi_procinst`          流程实例
 *      `act_hi_taskinst`          任务实例
 *      `act_ru_execution`         执行表
 *      `act_ru_identitylink`      参与者信息
 *      `act_ru_task`              任务
 */
public class ActivitiStartIntrance {

    public static void main(String[] args) {

        // 1.获取流程引擎对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.获取流程执行实例
        RuntimeService runtimeService = processEngine.getRuntimeService();

        // 3.根据流程定义的唯一key  去获取processInstance
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday");

        //  打印一些processInstance的 流程执行实例的信息
        System.out.println("流程部署ID——————"+processInstance.getDeploymentId());
        System.out.println("流程定义的ID——————"+processInstance.getProcessDefinitionId());
        System.out.println("流程执行实例ID——————"+processInstance.getId());
        System.out.println("流程活动ID——————"+processInstance.getActivityId());

    }

}
