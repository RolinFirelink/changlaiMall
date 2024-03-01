# ⛰项目依赖



后端：JDK8、SpringBoot4.1.4、Mybatis3.2.8、MySQL8.0.24、slf4j1.7.7、log4j1.2.17

前端：HTML、CSS、JSP、JS



# 🏃快速开始



## 数据库配置



首先在本地创建 `shop` 数据库，选择好字符集：`utf8mb4`，排序规则：`utf8mb8_general_ci` 。然后在数据库下执行项目携带的SQL文件即可（包含各个表和表结构）

# 😀介绍



该项目以SpringBoot为基础框架，使用Tomcat作为服务器，是基于淘宝的简单实现，可以实现图片上传、购买商品、添加商品到购物车、全部购买等功能



## 🏭系统功能



### 管理端



-  商品管理
-  图片上传
-  报表统计
-  套餐管理
-  订单完成



### 移动端



-  登录功能
-  购物车管理
-  个人中心
-  我的订单
-  商品收藏
-  修改密码



## 🧱注意



常来淘宝系统管理端：

账号密码请自己在数据库中定义，其地址是将管理端地址中的uLogin改为mLogin即可跳转到指定页面

[本地管理端入口](http://localhost:8080/1_war_exploded/login/mLogin)

生猪售卖管理系统移动端：

移动端打开Tomcat即会跳转，若没注册，则登录之后会进入注册页面，支付功能未实现

[本地移动端入口](http://localhost:8080/1_war_exploded/login/uLogin)



### 答辩笔记



1、什么时候mybatis 使用@param

①方法有两个参数

where  s_name= #{aaaa} and class_id = #{bbbb} 表示sql语句要接受2个参数

一个参数名是aaaa,一个参数名是bbbb,如果要正确的传入参数,那么就要给参数命名

因为不用xml配置文件,那么我们就要用别的方式来给参数命名,这个方式就是@Param注解

②方法参数名不同于sql语句里的参数名

在方法参数的前面写上@Param("参数名"),表示给参数命名,名称就是括号中的内容

public Student select(@Param("aaaa") String name,@Param("bbbb")int class_id);

给入参 String name 命名为aaaa,然后sql语句

....where  s_name= #{aaaa} 中就可以根据aaaa得到参数值了



2、Serializable id

标示接口， 可以序列化

java的包装类型 （Integer,Long,String,Double...）几乎都实现了这个接口.

用Serializable来定义id的类型，是使用的接口类型

实际调用这个方法时候 可以传递 Integer ,Long ,String 等类型，或者实现了Serializable接口的类

多态和面向接口编程的体现

其实就是为了减少代码，提高代码利用率。

就比如：你不用Serializable，你使用String类型数据，

就必须拿String类型接受，你使用Integer数据，也就必须拿Integer接受。

那为啥不用泛型呢？如果用泛型那么父类必须要实现并传递泛型，

没有这样简便轻巧。在这里使用泛型太过繁琐。



3、BaseServiceImpl为什么使用abstract

①最大的原因还是因为提高代码复用率，在mapper里的各个实体类接口直接继承后就可以使用父类方法

不用像接口一样一个一个重写

②实现单继承多实现的java多态思想，可以基于此方法为主实现其他拓展功能的implements



4、base类

base类封装了所有增删查改的方法以及控制层的一些功能

绝妙之处在于所有形参类型除了id和map以及sql外都是泛型，而且此泛型是基于父类的传递继承

用抽象类封装完mapper直接调用根据各个实体类型套入就可以直接使用



5、mapper.xml中的resultMap字段

MyBatis的创建基于这样一个思想：

数据库并不是您想怎样就怎样的。

虽然我们希望所有的数据库遵守第三范式或BCNF（修正的第三范式），但它们不是。

如果有一个数据库能够完美映射到所有应用程序，也将是非常棒的，但也没有。

结果集映射就是MyBatis为解决这些问题而提供的解决方案。

简而言之就是自定义一个你想要的的集合类型映射，就不用一直写各种实体类出来



6、mapper中的SQL

sql元素标签用来定义可重复使用的SQL代码片段，

使用时只需要用include元素标签引用即可，最终达到SQL语句重用的目的；

同时它可以被静态地(在加载参数) 参数化，不同的属性值通过包含的实例变化



7、在mapper中的insert使用 useGeneratedKeys="true" keyProperty="id"

官方的说法是该参数的作用是：“允许JDBC支持自动生成主键，需要驱动兼容”

其本意是说：对于支持自动生成记录主键的数据库（这里就是自增字段）

如：MySQL，SQL Server，此时设置useGeneratedKeys参数值为true，

在执行添加记录之后可以获取到数据库自动生成的主键ID。



8、关于批量新增的foreach

\<insert/>标签中的 parameterType="java.util.List"  代表方法的入参类型，是个list集合。

\<foreach/> 是循环标签；

在使用foreach的时候最关键的也是最容易出错的就是collection属性，

该属性是必须指定的，但是在不同情况 下，该属性的值是不一样的，

主要有一下3种情况：

1. 如果传入的是单参数且参数类型是一个List的时候，collection属性值为list
2. 如果传入的是单参数且参数类型是一个array数组的时候，collection的属性值为array
3. 如果传入的参数是多个的时候，我们就需要把它们封装成一个Map了，
   当然单参数也可以封装成map，实际上如果你在传入参数的时候，
   在breast里面也是会把它封装成一个Map的，map的key就是参数名，
   所以这个时候collection属性值就是传入的List或array对象在自己封装的map里面的key ；

item：集合中每一个元素进行迭代时的别名

separator在每次进行迭代之间以什么符号作为分隔符

另外，还有两个参数 open该语句以什么开始  close以什么结束



9、封装纯sql语法${sql}
 由于mysql可以实现纯手工的sql语句书写，

 并且可以通过sqlSessionTemplate类来实现将sql语句进行注入，

 查询的结果可以封装成Map集合进行接收，那么所有的问题就在sql串的拼接了。

 由于数据库的表结构和实体机构相同，

 所以我们完全可以通过实体得到实体的属性名和属性值来进行sql串的拼接。



10、二级标题

用到了ajax技术



11、为什么用Integer不用int

因为int如果设为空的话默认为0

而Integer为Null.. Null对于程序来说比较好控制，

可以做空值判断以及对数据做统一处理



12、用@Autowired的原理是什么？

其实在启动spring IoC时，容器自动装载了一个

AutowiredAnnotationBeanPostProcessor后置处理器，

当容器扫描到@Autowied、@Resource

(是CommonAnnotationBeanPostProcessor后置处理器处理的)或@Inject时，

就会在IoC容器自动查找需要的bean，并装配给该对象的属性

在使用@Autowired时，首先在容器中查询对应类型的bean

如果查询结果刚好为一个，就将该bean装配给@Autowired指定的数据

如果查询的结果不止一个，那么@Autowired会根据名称来查找。

如果查询的结果为空，那么会抛出异常。解决方法时，使用required=false



13、<context:component-scan>使用说明

在XML中配置了这个标签后，spring可以自动扫描base-package下面

或者子包下面的java文件，如果扫描有@Component @Service @Controller等这些注解的类，

则把这些类注册为bean。

注意：如果配置了<context:component-scan>那么<context:annotation-config/>标签就可以不用再xml中配置了，

因为前者包含了后者。另外<context:annotation-config/>还提供了两个子标签



# ❤️贡献者

RolinFirelink、JingChengMai等



项目截图：

![image-20240301153123684](https://rolin-typora.oss-cn-guangzhou.aliyuncs.com/image-20240301153123684.png)



![image-20240301153147294](https://rolin-typora.oss-cn-guangzhou.aliyuncs.com/image-20240301153147294.png)



![image-20240301153200406](https://rolin-typora.oss-cn-guangzhou.aliyuncs.com/image-20240301153200406.png)