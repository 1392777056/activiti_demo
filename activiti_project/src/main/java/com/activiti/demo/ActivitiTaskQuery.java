package com.activiti.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 执行任务
 */
public class ActivitiTaskQuery {


    public static void main(String[] args) {

        //1.获取processEngine流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.得到taskService对象
        TaskService taskService = processEngine.getTaskService();

        //3.根据流程定义的key，负责人assignee来实现当前用户任务列表的查询
        Task task = taskService.createTaskQuery().
                processDefinitionKey("holiday").
                taskAssignee("lisi").
                singleResult();

        //4.任务列表展示
            System.out.println("流程实例的id————"+task.getProcessInstanceId());
            System.out.println("任务id————"+task.getId());
            System.out.println("任务负责人————"+task.getAssignee());
            System.out.println("任务名称————"+task.getName());

    }

    // 张三任务
    /*public static void main(String[] args) {

        //1.获取processEngine流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.得到taskService对象
        TaskService taskService = processEngine.getTaskService();

        //3.根据流程定义的key，负责人assignee来实现当前用户任务列表的查询
        List<Task> taskList = taskService.createTaskQuery().
                processDefinitionKey("holiday").
                taskAssignee("zhangsan").
                list();

        //4.任务列表展示
        for (Task task : taskList) {
            System.out.println("流程实例的id————"+task.getProcessInstanceId());
            System.out.println("任务id————"+task.getId());
            System.out.println("任务负责人————"+task.getAssignee());
            System.out.println("任务名称————"+task.getName());
        }

    }*/

}
