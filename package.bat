@echo off 
echo ��ʼ���...
set /p env=�����뽫Ҫ����Ļ���(���Ի�����test, Ԥ��������prepare, ���ϻ�����production):
call mvn clean package -DskipTests -P %env%
@pause