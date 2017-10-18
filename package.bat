@echo off 
echo 开始打包...
set /p env=请输入将要打包的环境(测试环境：test, 预发环境：prepare, 线上环境：production):
call mvn clean package -DskipTests -P %env%
@pause