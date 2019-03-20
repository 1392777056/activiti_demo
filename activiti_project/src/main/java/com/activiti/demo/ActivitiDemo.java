package com.activiti.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

/**
 * 部署流程定义图
 *      影响了这三张表：
 *          `act_re_deployment`    部署信息
 *          `act_re_procdef`        流程定义的一些信息
 *          `act_ge_bytearray`      流程定义的bpmn或者png文件
 */
public class ActivitiDemo {

    // 使用压缩方式 实现流程定义部署，流程出来后要上传到服务器，zip文件更便于上传
    public static void main(String[] args) {

        // 1.获取processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.获取repositoryService资源
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3.将流程图进行部署    先转换成InputStream 流
        InputStream is = ActivitiDemo.class.getClassLoader().getResourceAsStream("diagram/activitiBPMN.zip");

        // 4. 然后在将InputStream转换成为ZipInputStream
        ZipInputStream zipInputStream = new ZipInputStream(is);
        Deployment deployment = repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                .name("请假流程图")
                .deploy();

        // 4.打印出一些基本信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());
    }

    // XML 方法部署
   /* public static void main(String[] args) {

        // 1.获取processEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        // 2.获取repositoryService资源
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 3.将流程图进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday.bpmn")
                .name("请假流程图")
                .deploy();

        // 4.打印出一些基本信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());
    }*/

}
