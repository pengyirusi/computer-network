# JavaWeb

## 1 基本概念

### 1.1 前言

web 开发：

+ web 网页 资源的访问
  

+ 静态 web：
  + html css 
  + 提供给所有人看的数据始终不会变化
    

+ 动态 web
    + 提供给所有人看到的数据都不一样，每个人看到的信息也会发生改变
    + servlet jsp asp php
    

在 java 中，动态 web 资源开发的技术统称为 JavaWeb

### 1.2 web 应用程序

可以提供浏览器访问的程序

+ a.html b.html ... 多个 web 资源，这些 web 资源可以被外界访问，对外界提供服务


+ URL 统一资源定位符


+ 这些统一的 web 资源会被放到一个文件夹下 --> web 应用 --> tomcat 服务器


+ 一个 web 应用由多部分组成
    + html css js
    + jsp servlet
    + java 程序
    + jar 包
    + properties
    

+ web 程序写完后需要服务器统一管理才能被外部访问


### 1.3 静态 web

+ *.htm *.html 能通过浏览器直接读取

+ 请求 request ~ 响应 response

+ 缺点
    + web 页面无法动态更新，所有用户看到的都是同一个页面
        + 轮播图，点击特效：伪动态
        + javaScript
        + VBScript
    + 无法和数据库交互（数据无法持久化，用户无法交互），注册都费劲
    

### 1.4 动态 web

页面会动态展示，千人千面

+ 缺点
    + 如果 web 动态资源错误，我们需要重新编写后台程序，重新发布，停机维护
    

+ 优点
    + 可以动态更新
    + 可以与数据库交互，数据持久化（用户信息、商品信息 ...）
  
  
## 2 web 服务器

### 2.1 几个技术

+ ASP：在 html 中嵌入了 VB 的脚本
```html
<h1>
    <% java 代码 %>
</h1>
```
+ C#


+ IIS


+ php：开发速度快，功能强大，跨平台，代码很简单，缺点是无法承载大访问量


+ JSP / Servlet
    + sun 公司主推的 bs 架构 
    + 基于 java 语言
    + 可以承载高并发高可用高性能
    + 语法像 ASP
    

### 2.2 web 服务器

是一种被动的操作，用来处理用户的一些请求和给用户一些响应信息

+ IIS
  
微软的，windows 中自带的


+ Tomcat (>^ω^<)

Apache、免费、性能稳定、处理静态和动态、最新版本为 10.0

下载 tomcat：
1. 安装 / 解压
2. 了解配置文件和目录结构
3. 了解它的作用

## 3 Tomcat

### 3.1 安装

[tomcat 官网](http://tomcat.apache.org/)

[download tomcat10](https://tomcat.apache.org/download-10.cgi)

这里是 windows 系统，所以下载 [64-bit Windows zip (pgp, sha512)](https://mirrors.tuna.tsinghua.edu.cn/apache/tomcat/tomcat-10/v10.0.10/bin/apache-tomcat-10.0.10-windows-x64.zip)

无需安装 解压之后直接就能使用

### 3.2 启动

+ 启动

apache-tomcat-10.0.10/bin/startup.bat

成功访问 http://localhost:8080/ 说明 启动完毕

但是启动之后控制台出现乱码，默认不支持汉字？

将 apache-tomcat-10.0.10/conf/logging.properties 中所有的的 `encoding = UTF-8` 的都改为 `encoding = GBK`，问题解决

+ 关闭

apache-tomcat-10.0.10/bin/shutdown.bat 或 直接点 × 关闭 tomcat 窗口

+ 可能遇到的问题
    + 闪退
        1. java 环境变量没有配置
        2. 需要配置兼容性
    + 乱码：已解决

### 3.3 配置

核心配置文件：apache-tomcat-10.0.10/conf/server.xml

可以配置：
1. host 和 webapp
```xml
<Host name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true" />
```
系统文件 etc/hosts 也要对应添加修改

2. port
```xml
<Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />
```

3. 