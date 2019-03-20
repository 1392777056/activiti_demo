package com.activiti.demo2;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 单个流程实例挂起和激活
 */
public class SuspendProcessInstance11 {

    public static void main(String[] args) {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 查询流程定义的对象
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId("2501").singleResult();

        // 判断是否是挂起和激活的状态
        boolean suspended = processInstance.isSuspended();

        String id = processInstance.getId();
        if (suspended) {
            //如果为true为挂起状态，暂停，就可以去激活
            runtimeService.activateProcessInstanceById(id);
            System.out.println("流程定义id+"+id+"激活");
        } else {
            runtimeService.suspendProcessInstanceById(id);
            System.out.println("流程定义id+"+id+"挂起");
        }
    }

}
