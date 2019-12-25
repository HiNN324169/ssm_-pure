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
##### 注意事项：
- pom.xml
  - 父:需要使用 dependencyManagement 标签包裹，进行依赖管理
  - 子：继承父，直接引用依赖，不需要写版本号
- 父级 作为 依赖管理，子级 各层 只需要引入本层所需依赖即可
- 配置文件存放位置：哪里加载 放哪里（一般放在 web 层）；
````
父：
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>xxx</groupId>
            <artifactId>aaa</artifactId>
            <version>xxxxx</version>
        </dependency>
    </dependencies>
<dependencyManagement>

子：
<dependencies>
    <dependency>
        <groupId>xxx</groupId>
        <artifactId>aaa</artifactId>
    </dependency>
</dependencies>
````
  
## 其他

#### 1、整合 log4j 的一般使用

- 引入 依赖：
```
<!-- log4j-->
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>${log4j.version}</version>
</dependency>
<!-- https://mvnrepository.com/artifact/javax.activation/activation -->
<dependency>
    <groupId>javax.activation</groupId>
    <artifactId>activation</artifactId>
    <version>${activation.version}</version>
</dependency>
<!-- https://mvnrepository.com/artifact/javax.mail/mail -->
<dependency>
    <groupId>javax.mail</groupId>
    <artifactId>mail</artifactId>
    <version>${mail.version}</version>
</dependency>
<!-- log4j-->
```
- log4j.properties
  - 打印参数
 ```$xslt
%m   输出代码中指定的消息
%p   输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL 
%r   输出自应用启动到输出该log信息耗费的毫秒数 
%c   输出所属的类目，通常就是所在类的全名 
%t   输出产生该日志事件的线程名 
%n   输出一个回车换行符，Windows平台为“/r/n”，Unix平台为“/n” 
%d   输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，比如：%d{yyy MMM dd HH:mm:ss ,SSS}，输出类似：2002年10月18日 22:10:28,921  
%l   输出日志事件的发生位置，包括类目名、发生的线程，以及在代码中的行数。举例：Testlog4.main(TestLog4.java: 10 ) 
%M   输出方法的名字、%m是输出代码指定的日志信息。
%x   输出和当前线程相关联的NDC(嵌套诊断环境),尤其用到像java servlets这样的多客户多线程的应用中。 
%%   输出一个”%”字符 
%F   输出日志消息产生时所在的文件名称 
%M   输出执行方法 
%L   输出代码中的行号 
 ```
- 配置文件（略：请查看：web resources/properties/log4j.properties）

- 配置 log4j 监听器 web.xml
```
<!-- 配置 log4j 的配置文件位置-->
<context-param>
    <param-name>log4jConfigLocation</param-name>
    <param-value>classpath:properties/log4j.properties</param-value>
</context-param>

<!-- 使用监听器 加载 log4j 的配置文件-->
<listener>
    <listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>
</listener>
```

- 使用
```$xslt
// 日志 输出
private static Logger logger = Logger.getLogger(当前类.class);
logger.info(...);
logger.debug(...);
```


#### 2、pageHelper 分页插件
##### https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md

- 第一步：添加 maven依赖
```$xslt
<!--  分页助手 -->
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper</artifactId>
    <version>${pagehelper.version}</version>
</dependency>
<!-- 分页助手 -->
```


- 第二步 配置 pageHelper 插件：版本 不同配置也不一样
  - v ：4.0.0
    - 在 spring 配置文件 SQLSessionFactoryBean 中添加 pageHelper 插件
```$xslt
<!-- 3、读取 书写 sql 语句 的 xml 文件的位置：SQLSessionFactoryBean-->
    <bean id="sqlSessionFactoryBean" class="org.mybatis.spring.SqlSessionFactoryBean">
        <!-- 注入数据源 -->
        <property name="dataSource" ref="dataSource"></property>

        <!-- 制定mapper 映射文件的存放位置-->
        <property name="mapperLocations">
            <list>
                <value>classpath:mapping/*.xml</value>
            </list>
        </property>

        <!-- 指定 mybatis 主要配置文件-->
        <property name="configLocation" value="classpath:mybatis/mybatis-config.xml"></property>

        <property name="plugins">
            <array>
                <bean class="com.github.pagehelper.PageHelper">
                    <property name="properties">
                        <value>
                            dialect=mysql
                        </value>
                    </property>
                </bean>
            </array>
        </property>
    </bean>
```
  - v : 5.1.2
    - 在 mybatis-config.xml 中配置
```
<!-- 分页插件 -->
<!--<plugins>-->
    <!--<plugin interceptor="com.github.pagehelper.PageInterceptor">-->
        <!--&lt;!&ndash; 该参数默认为false-->
        <!--设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用-->
        <!--和startPage中的pageNum效果一样 &ndash;&gt;-->
        <!--<property name="offsetAsPageNum" value="true"/>-->
        <!--&lt;!&ndash; 该参数默认为false-->
        <!--设置为true是，使用RowBounds分页会进行count查询 &ndash;&gt;-->
        <!--<property name="rowBoundsWithCount" value="true"/>-->
        <!--&lt;!&ndash; 设置为true时，如果pageSize=0或者ROwRounds.limit=0就会查询出全部的结果-->
        <!--（相当于每一偶执行分页查询，但是返回结果仍然是page类型） &ndash;&gt;-->
        <!--<property name="pageSizeZero" value="true"/>-->

        <!--&lt;!&ndash; 设置数据库类型&ndash;&gt;-->
        <!--&lt;!&ndash;<property name="dialect" value="mysql"></property>&ndash;&gt;-->
    <!--</plugin>-->
<!--</plugins>-->
```

- 第三部：使用 pageHelper
```$xslt
// 参数一：需要查询的页（底层公式：（当前页 - 1）* 每页记录数）
// 参数二：每页记录数
Page<Object> startPage = PageHelper.startPage(pageIndex, 2);

// 注意：pageHelper 的调用 必须放在 数据库查询之前
```