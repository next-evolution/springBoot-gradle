SET NAMES utf8;
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users (
	user_id           int unsigned    NOT NULL    auto_increment    COMMENT 'ユーザID',
	email_address     varchar(128)    NOT NULL    COMMENT 'Emailアドレス',
	user_name         varchar(64)     NOT NULL    COMMENT 'ユーザ名',
	login_password    varchar(64)     NOT NULL    COMMENT 'ログインパスワード',
	PRIMARY KEY (user_id),
	KEY I1 (email_address)
) ENGINE=Innodb DEFAULT CHARSET=utf8 COMMENT 'ユーザ情報';
