package com.activiti.demo2;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * 删除流程定义  的部署   根据id删除
 *
 *      影响的表：
 *          `act_ge_bytearray`
 *          `act_re_deployment`
 *          `act_re_procdef`
 */
public class DeleteProcessDefinitionQuery1 {

    /**
     * 删除的注意事项：
     *      1.当我们正在执行的这一套流程没有完全审批结束的时候，此时如果要删除流程定义信息就会失败
     *      2.如果公司层面要强制删除，可以使用repositoryService.deleteDeployment("1",true);
     *      //参数true代表级联删除，此时就会删除没有完成的流程节点，最后就可以删除流程定义的信息，false代表不级联删除。
     * @param args
     */
    public static void main(String[] args) {

        //获取到流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //创建repositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //得到部署id 进行删除
        repositoryService.deleteDeployment("1");

    }

}
