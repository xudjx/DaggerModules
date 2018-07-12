# DaggerModules


详细说明请见系列文章：
[Android 模块化探索和实践（1）：基本思路](https://www.jianshu.com/p/a2382dfb76ed)

[Android模块化探索和实践(2)：Dagger2在模块化中的应用](https://www.jianshu.com/p/581a7d8fc35a)

[Android模块化探索和实践（3）：模块间彻底隔离](https://www.jianshu.com/p/5ca845d2e9d7)

项目结构说明：

Module app
Module modulea
Module moduleb

目前只实现了通过Dagger2注入retrofit接口，其他注入读者可以自行扩展

关于gradle.properties中的isBuildModule说明：

isBuildModule=false : Build 主APP
isBuildModule=true  : 可单独Build modulea 和 moduleb

实例图如下：

![](http://7xopuh.dl1.z0.glb.clouddn.com/WechatIMG187.jpeg)
![](http://7xopuh.dl1.z0.glb.clouddn.com/WechatIMG186.jpeg)

