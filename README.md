# springBoot-gradle
springBoot-gradle

## mysql
```
create user app_user@localhost identified by "app_user_password";
create database schema01;
grant all on schema01.* to app_user@localhost;

CREATE TABLE users (
    user_id           int unsigned    NOT NULL    auto_increment    COMMENT 'ユーザID',
    email_address     varchar(128)    NOT NULL    COMMENT 'Emailアドレス',
    user_name         varchar(64)     NOT NULL    COMMENT 'ユーザ名',
    login_password    varchar(64)     NOT NULL    COMMENT 'ログインパスワード',
    PRIMARY KEY (user_id),
    KEY I1 (email_address)
) ENGINE=Innodb DEFAULT CHARSET=utf8 COMMENT 'ユーザ情報';

insert into users values(null,'test01@test.com','テスト 太郎','pwdpwd');
```
