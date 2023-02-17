# Hrbnu Coding Training Supervisor - 编码培训监督员

![Development progress](https://img.shields.io/badge/progress-20%25-yellow)
![platform](https://img.shields.io/badge/platform-linux--64%20%7C%20osx--64%20%7C%20win--64-lightgrey)
[![contact-img]][mail-link]

[contact-img]: https://img.shields.io/badge/contact-email-brightgreen
[mail-link]: mailto://l.dzh@163.com

CTS专为高校算法训练、校内竞赛、算法大赛准备，采用高并发分布式架构，支持任何组件热插拔，集群创建，后期将支持代码查重服务。

![项目简要结构图](https://cos.aa.pdteam.cn/test/Project%20Architecture%20Diagram.png)

## 分支

### master

这是包含最新版本的分支 - 不应直接对该分支做出任何贡献。


本项目基于Spring Cloud Alibaba 生态开发，启动时应先部署Nacos Server集群，确保正常运转后，导入微服务配置文件后，方可启动业务服务及网关。

因数据库及文件系统均采用腾讯云 云端数据库及对象存储，故无需配置本地数据库及文件系统。

具体使用流程如下：

1. 业务服务支持全平台，评测机要求为CentOS 7.6 及以上，同时配置所有服务器环境为OpenJDK 17及以上版本。
2. 启动业务相关微服务
3. 启动网关
4. 启动客户端

## 项目结构

### 框架依赖

整个项目基于Spring Cloud Alibaba 生态的分布式项目。

* Spring Cloud 生态依赖包：Spring Cloud Dependencies » 2022.0.0
* 分布式服务生态依赖包：Spring Cloud Alibaba Dependencies » 2022.0.0.0 RC1
* 应用框架依赖包：Spring Boot Dependencies » 3.0.0
* 服务注册中心客户端：Spring Cloud Starter Alibaba Nacos Discovery
* 服务配置中心客户端：Spring Cloud Starter Alibaba Nacos Config
* 负载均衡：Spring Cloud Starter Loadbalancer
* 路由网关：Spring Cloud Starter Gateway
* 断路器、熔断器：Spring Cloud Starter Circuitbreaker Resilience4j
* 数据库连接接口：Spring Boot Starter JDBC
* 数据库驱动：MySQL Connector/J » 8.0.31
* 持久层框架：MyBatis Spring Boot Starter
* 其他相关框架：
    * Project Lombok
    * Fastjson2 » 2.0.21
    * Spring Boot Starter Web

## 代码结构

最后更新时间： 2023/2/9 21:03

### service

存放 后端、评测机相关代码。

#### cts-api

后端应用的相关对象

#### cts-provider-problemSet-4001

题目集合服务提供者

#### cts-provider-contest-4002

竞赛相关服务提供者

### web-client

前端代码

## 开发日志

### 2023/2/8

1. 新增竞赛服务

## 亟待解决的问题

### 未解决的问题

1. 获取竞赛列表时获取的题目提交数据仍为题目集合数据

### 已解决的问题

## 贡献者

李东璋