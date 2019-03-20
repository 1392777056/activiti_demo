package com.activiti.demo2;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;

import java.util.List;

/**
 * 历史流程查询：
 */
public class QueryHistoryTable {

    public static void main(String[] args) {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        HistoryService historyService = processEngine.getHistoryService();

        HistoricActivityInstanceQuery activityInstanceQuery = historyService.createHistoricActivityInstanceQuery();

        // 流程实例
        activityInstanceQuery.processInstanceId("5001");

        //查询并排序
        List<HistoricActivityInstance> list = activityInstanceQuery.orderByHistoricActivityInstanceStartTime().desc().list();

        for (HistoricActivityInstance historicActivityInstance : list) {
            System.out.println("历史id==="+historicActivityInstance.getActivityId());
            System.out.println("历史id名称==="+historicActivityInstance.getActivityName());
            System.out.println("历史定义==="+historicActivityInstance.getProcessDefinitionId());
            System.out.println("历史shil==="+historicActivityInstance.getProcessInstanceId());
            System.out.println("======");
        }

    }

}
