证明配置服务中心可以从远程程序获取配置信息。

http请求地址和资源文件映射如下:

/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties


上面的url会映射{application}-{profile}.properties对应的配置文件，{label}对应git上不同的分支，默认为master。

spring.application.name：对应{application}部分
spring.cloud.config.profile：对应{profile}部分
spring.cloud.config.label：对应git的分支。如果配置中心使用的是本地存储，则该参数无用
spring.cloud.config.uri：配置中心的具体地址
spring.cloud.config.discovery.service-id：指定配置中心的service-id，便于扩展为高可用配置集群。
特别注意：上面这些与spring-cloud相关的属性必须配置在bootstrap.properties中，config部分内容才能被正确加载。因为config的相关配置会先于application.properties，而bootstrap.properties的加载也是先于application.properties。





配置文件访问地址：
http://localhost:7001/cloud-config/dev
http://localhost:7001/order-config/test
http://localhost:7001/sku-config/test
http://localhost:7001/spu-config/test



