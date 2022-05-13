-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: ssmvd34b
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `adminid` bigint(20) DEFAULT NULL COMMENT '管理员id',
  `ask` longtext COMMENT '提问',
  `reply` longtext COMMENT '回复',
  `isreply` int(11) DEFAULT NULL COMMENT '是否回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='知识解答';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES (51,'2021-03-01 07:11:00',1,1,'提问1','回复1',1),(52,'2021-03-01 07:11:00',2,2,'提问2','回复2',2),(53,'2021-03-01 07:11:00',3,3,'提问3','回复3',3),(54,'2021-03-01 07:11:00',4,4,'提问4','回复4',4),(55,'2021-03-01 07:11:00',5,5,'提问5','回复5',5),(56,'2021-03-01 07:11:00',6,6,'提问6','回复6',6);
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','http://localhost:8080/ssmvd34b/upload/picture1.jpg'),(2,'picture2','http://localhost:8080/ssmvd34b/upload/picture2.jpg'),(3,'picture3','http://localhost:8080/ssmvd34b/upload/picture3.jpg'),(6,'homepage',NULL);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussmingshituijian`
--

DROP TABLE IF EXISTS `discussmingshituijian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussmingshituijian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8 COMMENT='名师推荐评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussmingshituijian`
--

LOCK TABLES `discussmingshituijian` WRITE;
/*!40000 ALTER TABLE `discussmingshituijian` DISABLE KEYS */;
INSERT INTO `discussmingshituijian` VALUES (111,'2021-03-01 07:11:00',1,1,'评论内容1','回复内容1'),(112,'2021-03-01 07:11:00',2,2,'评论内容2','回复内容2'),(113,'2021-03-01 07:11:00',3,3,'评论内容3','回复内容3'),(114,'2021-03-01 07:11:00',4,4,'评论内容4','回复内容4'),(115,'2021-03-01 07:11:00',5,5,'评论内容5','回复内容5'),(116,'2021-03-01 07:11:00',6,6,'评论内容6','回复内容6');
/*!40000 ALTER TABLE `discussmingshituijian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussshipinxuexi`
--

DROP TABLE IF EXISTS `discussshipinxuexi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussshipinxuexi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8 COMMENT='视频学习评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussshipinxuexi`
--

LOCK TABLES `discussshipinxuexi` WRITE;
/*!40000 ALTER TABLE `discussshipinxuexi` DISABLE KEYS */;
INSERT INTO `discussshipinxuexi` VALUES (121,'2021-03-01 07:11:00',1,1,'评论内容1','回复内容1'),(122,'2021-03-01 07:11:00',2,2,'评论内容2','回复内容2'),(123,'2021-03-01 07:11:00',3,3,'评论内容3','回复内容3'),(124,'2021-03-01 07:11:00',4,4,'评论内容4','回复内容4'),(125,'2021-03-01 07:11:00',5,5,'评论内容5','回复内容5'),(126,'2021-03-01 07:11:00',6,6,'评论内容6','回复内容6');
/*!40000 ALTER TABLE `discussshipinxuexi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discusszaixianxuexi`
--

DROP TABLE IF EXISTS `discusszaixianxuexi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discusszaixianxuexi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `content` longtext NOT NULL COMMENT '评论内容',
  `reply` longtext COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8 COMMENT='在线学习评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discusszaixianxuexi`
--

LOCK TABLES `discusszaixianxuexi` WRITE;
/*!40000 ALTER TABLE `discusszaixianxuexi` DISABLE KEYS */;
INSERT INTO `discusszaixianxuexi` VALUES (131,'2021-03-01 07:11:00',1,1,'评论内容1','回复内容1'),(132,'2021-03-01 07:11:00',2,2,'评论内容2','回复内容2'),(133,'2021-03-01 07:11:00',3,3,'评论内容3','回复内容3'),(134,'2021-03-01 07:11:00',4,4,'评论内容4','回复内容4'),(135,'2021-03-01 07:11:00',5,5,'评论内容5','回复内容5'),(136,'2021-03-01 07:11:00',6,6,'评论内容6','回复内容6');
/*!40000 ALTER TABLE `discusszaixianxuexi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exampaper`
--

DROP TABLE IF EXISTS `exampaper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exampaper` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `name` varchar(200) NOT NULL COMMENT '试卷名称',
  `time` int(11) NOT NULL COMMENT '考试时长(分钟)',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '试卷状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='试卷表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exampaper`
--

LOCK TABLES `exampaper` WRITE;
/*!40000 ALTER TABLE `exampaper` DISABLE KEYS */;
/*!40000 ALTER TABLE `exampaper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examquestion`
--

DROP TABLE IF EXISTS `examquestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examquestion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `paperid` bigint(20) NOT NULL COMMENT '所属试卷id（外键）',
  `papername` varchar(200) NOT NULL COMMENT '试卷名称',
  `questionname` varchar(200) NOT NULL COMMENT '试题名称',
  `options` longtext COMMENT '选项，json字符串',
  `score` bigint(20) DEFAULT '0' COMMENT '分值',
  `answer` varchar(200) DEFAULT NULL COMMENT '正确答案',
  `analysis` longtext COMMENT '答案解析',
  `type` bigint(20) DEFAULT '0' COMMENT '试题类型，0：单选题 1：多选题 2：判断题 3：填空题（暂不考虑多项填空）',
  `sequence` bigint(20) DEFAULT '100' COMMENT '试题排序，值越大排越前面',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='试题表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examquestion`
--

LOCK TABLES `examquestion` WRITE;
/*!40000 ALTER TABLE `examquestion` DISABLE KEYS */;
/*!40000 ALTER TABLE `examquestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examrecord`
--

DROP TABLE IF EXISTS `examrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examrecord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(200) DEFAULT NULL COMMENT '用户名',
  `paperid` bigint(20) NOT NULL COMMENT '试卷id（外键）',
  `papername` varchar(200) NOT NULL COMMENT '试卷名称',
  `questionid` bigint(20) NOT NULL COMMENT '试题id（外键）',
  `questionname` varchar(200) NOT NULL COMMENT '试题名称',
  `options` longtext COMMENT '选项，json字符串',
  `score` bigint(20) DEFAULT '0' COMMENT '分值',
  `answer` varchar(200) DEFAULT NULL COMMENT '正确答案',
  `analysis` longtext COMMENT '答案解析',
  `myscore` bigint(20) NOT NULL DEFAULT '0' COMMENT '试题得分',
  `myanswer` varchar(200) DEFAULT NULL COMMENT '考生答案',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='考试记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examrecord`
--

LOCK TABLES `examrecord` WRITE;
/*!40000 ALTER TABLE `examrecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `examrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum`
--

DROP TABLE IF EXISTS `forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forum` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) DEFAULT NULL COMMENT '帖子标题',
  `content` longtext NOT NULL COMMENT '帖子内容',
  `parentid` bigint(20) DEFAULT NULL COMMENT '父节点id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(200) DEFAULT NULL COMMENT '用户名',
  `isdone` varchar(200) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='论坛交流';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum`
--

LOCK TABLES `forum` WRITE;
/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
INSERT INTO `forum` VALUES (61,'2021-03-01 07:11:00','帖子标题1','帖子内容1',1,1,'用户名1','开放'),(62,'2021-03-01 07:11:00','帖子标题2','帖子内容2',2,2,'用户名2','开放'),(63,'2021-03-01 07:11:00','帖子标题3','帖子内容3',3,3,'用户名3','开放'),(64,'2021-03-01 07:11:00','帖子标题4','帖子内容4',4,4,'用户名4','开放'),(65,'2021-03-01 07:11:00','帖子标题5','帖子内容5',5,5,'用户名5','开放'),(66,'2021-03-01 07:11:00','帖子标题6','帖子内容6',6,6,'用户名6','开放');
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mingshituijian`
--

DROP TABLE IF EXISTS `mingshituijian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mingshituijian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `kechengmingcheng` varchar(200) DEFAULT NULL COMMENT '课程名称',
  `mingshixingming` varchar(200) DEFAULT NULL COMMENT '名师姓名',
  `jiaoling` varchar(200) DEFAULT NULL COMMENT '教龄',
  `kechengtupian` varchar(200) DEFAULT NULL COMMENT '课程图片',
  `kechengleixing` varchar(200) DEFAULT NULL COMMENT '课程类型',
  `shihezhuanye` varchar(200) DEFAULT NULL COMMENT '适合专业',
  `kechengjiage` int(11) NOT NULL COMMENT '课程价格',
  `kechengjianjie` longtext COMMENT '课程简介',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int(11) DEFAULT '0' COMMENT '点击次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='名师推荐';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mingshituijian`
--

LOCK TABLES `mingshituijian` WRITE;
/*!40000 ALTER TABLE `mingshituijian` DISABLE KEYS */;
INSERT INTO `mingshituijian` VALUES (21,'2021-03-01 07:11:00','课程名称1','名师姓名1','教龄1','http://localhost:8080/ssmvd34b/upload/mingshituijian_kechengtupian1.jpg','课程类型1','适合专业1',1,'课程简介1',1,1,'2021-03-01 15:11:00',1),(22,'2021-03-01 07:11:00','课程名称2','名师姓名2','教龄2','http://localhost:8080/ssmvd34b/upload/mingshituijian_kechengtupian2.jpg','课程类型2','适合专业2',2,'课程简介2',2,2,'2021-03-01 15:11:00',2),(23,'2021-03-01 07:11:00','课程名称3','名师姓名3','教龄3','http://localhost:8080/ssmvd34b/upload/mingshituijian_kechengtupian3.jpg','课程类型3','适合专业3',3,'课程简介3',3,3,'2021-03-01 15:11:00',3),(24,'2021-03-01 07:11:00','课程名称4','名师姓名4','教龄4','http://localhost:8080/ssmvd34b/upload/mingshituijian_kechengtupian4.jpg','课程类型4','适合专业4',4,'课程简介4',4,4,'2021-03-01 15:11:00',4),(25,'2021-03-01 07:11:00','课程名称5','名师姓名5','教龄5','http://localhost:8080/ssmvd34b/upload/mingshituijian_kechengtupian5.jpg','课程类型5','适合专业5',5,'课程简介5',5,5,'2021-03-01 15:11:00',5),(26,'2021-03-01 07:11:00','课程名称6','名师姓名6','教龄6','http://localhost:8080/ssmvd34b/upload/mingshituijian_kechengtupian6.jpg','课程类型6','适合专业6',6,'课程简介6',6,6,'2021-03-01 15:11:00',6);
/*!40000 ALTER TABLE `mingshituijian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipinxuexi`
--

DROP TABLE IF EXISTS `shipinxuexi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipinxuexi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jiaoxuebiaoti` varchar(200) NOT NULL COMMENT '教学标题',
  `tupianfengmian` varchar(200) DEFAULT NULL COMMENT '图片封面',
  `jiaoxueshipin` varchar(200) NOT NULL COMMENT '教学视频',
  `kechengjianjie` longtext COMMENT '课程简介',
  `fabushijian` date DEFAULT NULL COMMENT '发布时间',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int(11) DEFAULT '0' COMMENT '点击次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='视频学习';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipinxuexi`
--

LOCK TABLES `shipinxuexi` WRITE;
/*!40000 ALTER TABLE `shipinxuexi` DISABLE KEYS */;
INSERT INTO `shipinxuexi` VALUES (31,'2021-03-01 07:11:00','教学标题1','http://localhost:8080/ssmvd34b/upload/shipinxuexi_tupianfengmian1.jpg','','课程简介1','2021-03-01',1,1,'2021-03-01 15:11:00',1),(32,'2021-03-01 07:11:00','教学标题2','http://localhost:8080/ssmvd34b/upload/shipinxuexi_tupianfengmian2.jpg','','课程简介2','2021-03-01',2,2,'2021-03-01 15:11:00',2),(33,'2021-03-01 07:11:00','教学标题3','http://localhost:8080/ssmvd34b/upload/shipinxuexi_tupianfengmian3.jpg','','课程简介3','2021-03-01',3,3,'2021-03-01 15:11:00',3),(34,'2021-03-01 07:11:00','教学标题4','http://localhost:8080/ssmvd34b/upload/shipinxuexi_tupianfengmian4.jpg','','课程简介4','2021-03-01',4,4,'2021-03-01 15:11:00',4),(35,'2021-03-01 07:11:00','教学标题5','http://localhost:8080/ssmvd34b/upload/shipinxuexi_tupianfengmian5.jpg','','课程简介5','2021-03-01',5,5,'2021-03-01 15:11:00',5),(36,'2021-03-01 07:11:00','教学标题6','http://localhost:8080/ssmvd34b/upload/shipinxuexi_tupianfengmian6.jpg','','课程简介6','2021-03-01',6,6,'2021-03-01 15:11:00',6);
/*!40000 ALTER TABLE `shipinxuexi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeup`
--

DROP TABLE IF EXISTS `storeup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storeup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `refid` bigint(20) DEFAULT NULL COMMENT '收藏id',
  `tablename` varchar(200) DEFAULT NULL COMMENT '表名',
  `name` varchar(200) NOT NULL COMMENT '收藏名称',
  `picture` varchar(200) NOT NULL COMMENT '收藏图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeup`
--

LOCK TABLES `storeup` WRITE;
/*!40000 ALTER TABLE `storeup` DISABLE KEYS */;
/*!40000 ALTER TABLE `storeup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(200) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `role` varchar(100) DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'abo','abo','管理员','2021-03-01 07:11:00');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yonghu`
--

DROP TABLE IF EXISTS `yonghu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yonghu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhanghao` varchar(200) NOT NULL COMMENT '账号',
  `mima` varchar(200) NOT NULL COMMENT '密码',
  `xingming` varchar(200) DEFAULT NULL COMMENT '姓名',
  `xingbie` varchar(200) DEFAULT NULL COMMENT '性别',
  `shouji` varchar(200) DEFAULT NULL COMMENT '手机',
  `youxiang` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `touxiang` varchar(200) DEFAULT NULL COMMENT '头像',
  `beizhu` longtext COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zhanghao` (`zhanghao`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yonghu`
--

LOCK TABLES `yonghu` WRITE;
/*!40000 ALTER TABLE `yonghu` DISABLE KEYS */;
INSERT INTO `yonghu` VALUES (11,'2021-03-01 07:11:00','用户1','123456','姓名1','男','13823888881','773890001@qq.com','http://localhost:8080/ssmvd34b/upload/yonghu_touxiang1.jpg','备注1'),(12,'2021-03-01 07:11:00','用户2','123456','姓名2','男','13823888882','773890002@qq.com','http://localhost:8080/ssmvd34b/upload/yonghu_touxiang2.jpg','备注2'),(13,'2021-03-01 07:11:00','用户3','123456','姓名3','男','13823888883','773890003@qq.com','http://localhost:8080/ssmvd34b/upload/yonghu_touxiang3.jpg','备注3'),(14,'2021-03-01 07:11:00','用户4','123456','姓名4','男','13823888884','773890004@qq.com','http://localhost:8080/ssmvd34b/upload/yonghu_touxiang4.jpg','备注4'),(15,'2021-03-01 07:11:00','用户5','123456','姓名5','男','13823888885','773890005@qq.com','http://localhost:8080/ssmvd34b/upload/yonghu_touxiang5.jpg','备注5'),(16,'2021-03-01 07:11:00','用户6','123456','姓名6','男','13823888886','773890006@qq.com','http://localhost:8080/ssmvd34b/upload/yonghu_touxiang6.jpg','备注6');
/*!40000 ALTER TABLE `yonghu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zaixianxuexi`
--

DROP TABLE IF EXISTS `zaixianxuexi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zaixianxuexi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jiaoxuemingcheng` varchar(200) DEFAULT NULL COMMENT '教学名称',
  `tupian` varchar(200) DEFAULT NULL COMMENT '图片',
  `jiaoxueshipin` varchar(200) DEFAULT NULL COMMENT '教学视频',
  `jiaoxuewendang` varchar(200) DEFAULT NULL COMMENT '教学文档',
  `jiaoxueneirong` longtext COMMENT '教学内容',
  `fabushijian` date DEFAULT NULL COMMENT '发布时间',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int(11) DEFAULT '0' COMMENT '点击次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='在线学习';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zaixianxuexi`
--

LOCK TABLES `zaixianxuexi` WRITE;
/*!40000 ALTER TABLE `zaixianxuexi` DISABLE KEYS */;
INSERT INTO `zaixianxuexi` VALUES (41,'2021-03-01 07:11:00','教学名称1','http://localhost:8080/ssmvd34b/upload/zaixianxuexi_tupian1.jpg','','','教学内容1','2021-03-01',1,1,'2021-03-01 15:11:00',1),(42,'2021-03-01 07:11:00','教学名称2','http://localhost:8080/ssmvd34b/upload/zaixianxuexi_tupian2.jpg','','','教学内容2','2021-03-01',2,2,'2021-03-01 15:11:00',2),(43,'2021-03-01 07:11:00','教学名称3','http://localhost:8080/ssmvd34b/upload/zaixianxuexi_tupian3.jpg','','','教学内容3','2021-03-01',3,3,'2021-03-01 15:11:00',3),(44,'2021-03-01 07:11:00','教学名称4','http://localhost:8080/ssmvd34b/upload/zaixianxuexi_tupian4.jpg','','','教学内容4','2021-03-01',4,4,'2021-03-01 15:11:00',4),(45,'2021-03-01 07:11:00','教学名称5','http://localhost:8080/ssmvd34b/upload/zaixianxuexi_tupian5.jpg','','','教学内容5','2021-03-01',5,5,'2021-03-01 15:11:00',5),(46,'2021-03-01 07:11:00','教学名称6','http://localhost:8080/ssmvd34b/upload/zaixianxuexi_tupian6.jpg','','','教学内容6','2021-03-01',6,6,'2021-03-01 15:11:00',6);
/*!40000 ALTER TABLE `zaixianxuexi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-01 20:18:30
