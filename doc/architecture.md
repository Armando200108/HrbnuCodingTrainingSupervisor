# HRBNU Coding Training Supervisor

## 整体架构

#### 前端

- VUE + Spring Boot 服务层

#### 后端

- 用户服务：与资源服务器通信，获取用户数据

- 练习&比赛服务：主动练习服务端、比赛服务端

- 评测服务：接收提交的代码、提交评测机，接受评测机返回的评测结果。发送评测结果信息。

- 博客服务：博客服务端。（优先级低）

- 管理服务：用户管理、题目管理、Rejudge、比赛管理、公告管理。

- 评测机：评测代码，返回结果。

#### 服务注册与发现、负载均衡

- Eureka
- Ribbon

#### 断路器

- Resilience4J

#### 消息队列

- Spring for RabbitMQ

####  路由网关

- Gateway

#### 安全框架

- Spring Cloud Security OAuth 2.0
