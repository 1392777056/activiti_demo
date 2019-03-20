package com.activiti.demo2;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * 需求：将数据库中的 读取bpmn文件和png文件，并保存到本地的某一路径下
 *
 *      1、用activiti的api实现
 *      2、就是底层原理，可以使用jdbc的对blob类型，clob类型的读取，并保存
 *      3、IO流的转换，最后commons-io.jar解决IO操作
 *
 * 真实场景：用户想查看这个流程具体有哪些步骤？
 *
 */
public class QueryBpmn {

    public static void main(String[] args) throws IOException {

        //1.获取流程引擎对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //2.获取repositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.获取查询器  流程定义对象
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        //4.设置查询条件
        processDefinitionQuery.processDefinitionKey("holiday");

        //5.执行查询操作，查询想要的流程定义
        ProcessDefinition processDefinition = processDefinitionQuery.singleResult();

        //6.通过流程定义信息，得到部署ID
        String deploymentId = processDefinition.getDeploymentId();

        //7.通过repositoryService的方法，实现读取图片和bpmn文件信息（输入流）
        // 参数1 是流程部署id, 参数2 是流程定义资源
        // processDefinition.getResourceName() ---获取bpmn文件
        // processDefinition.getDiagramResourceName()  ---获取png文件
        InputStream io = repositoryService.getResourceAsStream(deploymentId, processDefinition.getResourceName());

        //8.outputstream流
        OutputStream out = new FileOutputStream("E:\\test\\123.txt");

        //9.输入流和输出流的转换
        IOUtils.copy(io,out);

        //关流
        out.close();
        io.close();
    }
}
