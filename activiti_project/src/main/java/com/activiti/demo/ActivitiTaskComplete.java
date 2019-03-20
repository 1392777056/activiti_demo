package com.activiti.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * 执行当前用户的任务:
 *      背后操作的表：
 *      `act_hi_actinst`
 *      `act_hi_identitylink`
 *      `act_hi_taskinst`
 *      `act_ru_execution`
 *      `act_ru_identitylink`
 *      `act_ru_task`
 */
public class ActivitiTaskComplete {

    public static void main(String[] args) {

        //1.获取processEngine流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.得到taskService对象
        TaskService taskService = processEngine.getTaskService();

        Task task = taskService.createTaskQuery().
                processDefinitionKey("holiday").
                taskAssignee("wuwang").
                singleResult();    // singleResult() 这个方法只能对于一个任务操作人来说，要是多个还的用list

        //3.处理任务，结合当前用户任务列表的查询操作的话，   任务id————5002
        //taskService.complete("5002");   李四的任务id
        taskService.complete(task.getId());

        System.out.println(task.getId());

    }


    // 张三
    /*public static void main(String[] args) {

        //1.获取processEngine流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.得到taskService对象
        TaskService taskService = processEngine.getTaskService();

        //3.处理任务，结合当前用户任务列表的查询操作的话，   任务id————2505
        taskService.complete("2505");

    }*/

}
