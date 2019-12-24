# springmvc 学习整合

## 本项目：spring + springmvc + mybatis

#### 版本信息：
- jdk:1.8
- maven:3.3.9
- tomcat 8.0.531
- spring
- springmvc
- mybatis 

> 分布式 开发 与 分模块开发的区别:
- 分布式：是一个项目拆分成不同的项目进行、开发、部署，通过HTTP协议进行通信---微服务
- 分模块：一个项目 拆分成子工程、父工程，通过jar通讯

> spirngmvc 执行流程：通过dispatcherServlet 转发

#### 分模块开发项目结构：
- springmvc_finish  父类工程
- commons  工具类
- entity 实体类
- dao 数据库访问层
- service 服务层
- web web层

---

