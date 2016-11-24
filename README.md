# 欢迎使用 Gather Platform 数据抓取平台

------

Gather Platform 数据抓取平台是一套基于Webmagic内核的,具有Web任务配置和任务管理界面的数据采集与搜索平台.具有以下功能

> * 根据配置的模板进行数据采集
> * 对采集的数据进行NLP处理,包括:抽取关键词,抽取摘要,抽取实体词
> * 在不配置采集模板的情况下自动检测网页正文,自动抽取文章发布时间
> * 动态字段抽取与静态字段植入
> * 已抓取数据的管理,包括:搜索,增删改查,按照新的数据模板重新抽取数据

## Windows/Mac/Linux 全平台支持

本系统需要如下依赖:

 - JDK 8 及以上
 - Tomcat 8.3 及以上
 - Elasticsearch 5.1

## 部署方式

本系统提供一份预编译版本和配置好的依赖环境,只需从百度云下载,按照步骤安装即可使用.

### 1. 使用预编译版本抓取数据

 - 从百度云下载预编译安装包和依赖环境
 - 安装JDK 8
 - 解压Elasticsearch并运行
 - 解压Tomcat将spider.war放入Tomcat下面的webapp文件夹
 - 运行Tomcat

### 2. 手工编译安装

 - 安装 JDK 8 以上版本
 - 安装Elasticsearch 5.1
 - 安装ansj-elasticsearch插件
 - 运行Elasticsearch
 - 安装Tomcat 8
 - 下载本项目源码包
 - 执行 `mvn package` 编译打包
 - 将spider.war放入Tomcat下面的webapp文件夹
 - 运行tomcat

## 使用方法

  部署完成后打开浏览器,访问 `http://localhost:8080/spider` 打开采集平台首页,点击导航栏的下拉菜单选择功能.

### 配置爬虫模板

  在导航栏的下拉菜单中点击 `编辑模板`  按钮,在这个页面中可完成一个爬虫的所有配置,具体每一个配置项的说明见每一个输入框的提示.

  爬虫模板配置完成后,点击下面的 `采集样例数据` 按钮,稍等片刻即可在下方展示根据刚刚配置的模板抓取的数据,如果数据有误在上面的模板中进行修改,然后再次点击 `采集样例数据` 按钮即可重新抓取.

  注意,在对于爬虫模板没有完全的把握之前请勿选择爬虫模板下方的几个 `是否网页必须有XXX` 的配置项.以文章的标题为例,因为如果文章标题的配置项(即为title)配置有误,爬虫就无法抓取到网页的标题,如果这时再选中了 `是否网页必须有标题` 的话,就会导致爬虫无限制的进行抓取.

  当模板配置完毕,即可点击下方的 `导出模板` 按钮,这时下方的大输入框中显示的Json格式的文字即为爬虫模板,可以将段文字保存到文本文件中,以便以后使用,也可以点击 `存储此模板` 对这个模板进行存储,以后可在本平台的 `爬虫模板管理系统` 中查找.

### 爬虫监控

