


创建表语句:
Mysql:
CREATE TABLE `apm_user` (
  `id` int(11) NOT NULL,
  `apm_user_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
=========================================

Oracle:
create table apm_user (
id number(16) primary key,
apm_user_name varchar2(100)
);

=========================================

Postgresql:
CREATE DATABASE app;
CREATE TABLE apm_user(
   id INT PRIMARY KEY      NOT NULL,
   apm_user_name           CHAR(100) NOT NULL
);
=========================================

SqlServer:
-- ----------------------------
-- Table structure for apm_user
-- ----------------------------
DROP TABLE [dbo].[apm_user]
GO
CREATE TABLE [dbo].[apm_user] (
[id] int NULL ,
[apm_user_name] varchar(255) NULL 
)
GO
=========================================


