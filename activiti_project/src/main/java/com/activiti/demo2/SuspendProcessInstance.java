package com.activiti.demo2;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;

/**
 * 挂起和激活
 */
public class SuspendProcessInstance {

    public static void main(String[] args) {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 查询流程定义的对象
        ProcessDefinition holiday = repositoryService.createProcessDefinitionQuery().processDefinitionKey("holiday")
                .singleResult();

        // 判断是否是挂起和激活的状态
        boolean suspended = holiday.isSuspended();

        String id = holiday.getId();
        if (suspended) {
            //如果为true为挂起状态，暂停，就可以去激活
            repositoryService.activateProcessDefinitionById(id,true,null);
            System.out.println("流程定义id+"+id+"激活");
        } else {
            repositoryService.suspendProcessDefinitionById(id,true,null);
            System.out.println("流程定义id+"+id+"挂起");
        }
    }

}
