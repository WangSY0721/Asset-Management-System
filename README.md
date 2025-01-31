# 资产管理系统
## 1.安装mysql、jdk、eclipse、mysql-connector-java，相关软件自行下载，相关设置请自行网上搜索
## 2.mysql中运行“资产管理系统设计--mysql”文件最后的sql语句，创建数据库
## 3.在zichanguanli-mysql\src\Database.java文件中
```
{
  //mysql连接方式
  String strurl="jdbc:mysql://localhost:3306/Assets?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
  String userName = "root"; //默认用户名
  String userPwd = "000000"; //密码
}
```
修改密码为你本机MySQL的密码
