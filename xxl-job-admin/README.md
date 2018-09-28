# Docker

#### 镜像构建
```
$ docker build -t xxl-job-admin:2-alpine -t xxl-job-admin:latest .
```

#### 测试容器
```
# 镜像已推送到Docker中央仓库：zlikun/xxl-job-admin:latest，可以直接使用
$ docker run --rm --link mysql \
--name xxl-job-admin -p 8080:8080 \
-e MYSQL_HOST=mysql \
-e MYSQL_PORT=3306 \
-e MYSQL_USERNAME=root \
-e MYSQL_PASSWORD=123456 \
-e EMAIL_HOST='smtp.qiye.163.com' \
-e EMAIL_PORT=25 \
-e EMAIL_SSL=false \
-e EMAIL_USERNAME='' \
-e EMAIL_PASSWORD='' \
-e EMAIL_SENDER='XXL-JOB' \
-e LOGIN_USERNAME=admin \
-e LOGIN_PASSWORD=123456 \
zlikun/xxl-job-admin:latest
```

#### 初始化配置
```
将 doc/tables_xxl_job.sql 脚本导入到MySQL中即可
```