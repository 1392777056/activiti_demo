package com.activiti.demo2;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * 流程定义的基本信息查询
 */
public class ProcessDefinitionQuery1 {

    public static void main(String[] args) {

        //获取到流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //创建repositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //得到ProcessDefinitionQuery,可以把他认为一个查询器
        org.activiti.engine.repository.ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        //设置查询条件，并且根据当前的流程定义，查询条件 流程以引擎key = holiday
        // orderByProcessDefinitionVersion 根据版本号排序
        List<ProcessDefinition> list = processDefinitionQuery.processDefinitionKey("holiday")
                .orderByProcessDefinitionVersion()
                .desc().list();

        //输出信息
        for (ProcessDefinition processDefinition : list) {
            System.out.println("流程定义id：--"+processDefinition.getId());
            System.out.println("流程定义名称：--"+processDefinition.getName());
            System.out.println("流程定义key：--"+processDefinition.getKey());
            System.out.println("流程定义的版本号：--"+processDefinition.getVersion());
            System.out.println("流程部署id：--"+processDefinition.getDeploymentId());
        }

    }

}
