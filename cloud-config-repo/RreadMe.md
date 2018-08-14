证明配置服务中心可以从远程程序获取配置信息。

http请求地址和资源文件映射如下:

/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties


上面的url会映射{application}-{profile}.properties对应的配置文件，{label}对应git上不同的分支，默认为master。
