# springBoot-gradle
springBoot-gradle

## mysql
```
-- create schema and user
create user app_user@localhost identified by "app_user_password";
create database schema01;
grant all on schema01.* to app_user@localhost;
create database schema02;
grant all on schema02.* to app_user@localhost;

-- ddl and dml
mysql -uapp_user -papp_user_password schema01 < tools/ddl_schema01.sql
mysql -uapp_user -papp_user_password schema01 < tools/dml_schema01.sql
mysql -uapp_user -papp_user_password schema02 < tools/ddl_schema02.sql
mysql -uapp_user -papp_user_password schema02 < tools/dml_schema02.sql
```
