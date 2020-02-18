#mybatis笔记：
- @MapperScan("package")等同于在package包内的每个mapper的dao文件添加@Mapper注解
- mapper文件应该放在resource目录下，如果将mapper的xml文件放在任意的包中，需要在pom.xml文件的<build>标签下添加以下内容： 
```xml
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