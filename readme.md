# maven runner 设置
`-Dfile.encoding=UTF-8 -DarchetypeCatalog=internal`

# 父工程pom文件  
spring全家桶推荐的插件配置
```xml
<pluginRepositories>
    <pluginRepository>
        <id>spring-snapshots</id>
        <name>Spring Snapshots</name>
        <url>https://repo.spring.io/snapshot</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </pluginRepository>
    <pluginRepository>
        <id>spring-milestones</id>
        <name>Spring Milestones</name>
        <url>https://repo.spring.io/milestone</url>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
    </pluginRepository>
</pluginRepositories>
```     
>十次方00、总目录: 
https://blog.csdn.net/amingccc/article/details/84260613