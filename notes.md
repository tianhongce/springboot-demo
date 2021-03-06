# mybatis笔记：
- @MapperScan("package")等同于在package包内的每个mapper的dao文件添加@Mapper注解
- mapper文件应该放在resource目录下，如果将mapper的xml文件放在任意的包中，需要在pom.xml文件的<build>标签下添加以下内容： 
```xml
        <!-- ......用于扫描 dao 文件下的mapper 文件................. start -->
        <resources>
            <!-- 编译 src/main/java 目录下的 mapper 文件 -->
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
        </resources>
        <!-- ......用于扫描 dao 文件下的mapper 文件................. end -->
```
- 如果出现错误`org.apache.ibatis.binding.BindingException: Invalid bound statement (not found)` 则需要检查第一条或者第二条的设置，如果两者没问题，检查dao接口与xml是否一一对应。

# serialVersionUID的作用及生成方法
- 作用 

序列化是将对象的状态信息转换为可存储或传输的形式的过程。我们都知道，Java对象是保存在JVM的堆内存中的，也就是说，如果JVM堆不存在了，那么对象也就跟着消失了。

而序列化提供了一种方案，可以让你在即使JVM停机的情况下也能把对象保存下来的方案。就像我们平时用的U盘一样。把JAVA对象序列化成可存储或传输的形式（如二进制流），比如保存在文件中。这样，当再次需要这个对象的时候，从文件中读取出二进制流，再从二进制流中反序列化出对象。

但是，虚拟机是否允许反序列化，不仅取决于类路径和功能代码是否一致，一个非常重要的一点是两个类的序列化ID是否一致，即serialVersionUID要求一致。

在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体类的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常，即使InvalidCastException。这样做是为了保证安全，因为文件存储中的内容可能被篡改。

当实现java.io.Serializable接口的类没有显式地定义一个serialVersionUID变量时候，JAVA序列化机制会根据编译的Class自动生成一个serialVersionUID作序列化版本比较用，这种情况下，如果Class文件没有发生变化，就算再编译多次，serialVersionUID也不会变化的。但是，如果发生了变化，那么这个文件对应的serialVersionUID也就会发生变化。

基于以上原理，如果我们一个类实现了Serializable接口，但是没有定义serialVersionUID，然后序列化。在序列化之后，由于某些原因，我们对该类做了变更，重新启动应用后，我们相对之前序列化过的对象进行反序列化的话就会报错。

- 生成方法

一个是默认的1L，比如：private static final long aLong = 1L;

一个是根据类名、接口名、成员方法及属性等来生成一个64位的哈希字段，比如：private static final long aLong = -8940196742313994740L;之类的。


# Java序列化和反序列化

# Echarts

# thymeleaf使用注意事项

# 枚举类
# baomidou.mybatisplus.core.metadata.ipage
# !!!注意：java对象转成json成立的基本条件只需要有get方法！！！
java对象转换成json字符串，若想要获得key、alue键值对，只需要对象中有getXxx(  )方法即可！！！！
# JS闭包

# git使用
git -- Authentication failed for 

Git rebase使用

git ssh-keygen权限问题