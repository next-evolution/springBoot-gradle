SET NAMES utf8;
DROP TABLE IF EXISTS todo CASCADE;

CREATE TABLE todo (
	id                int unsigned    NOT NULL    auto_increment    COMMENT 'ユーザID',
	user_id           int             NOT NULL    COMMENT 'ユーザID',
	title             varchar(128)    NOT NULL    COMMENT 'タイトル',
	memo              text            NOT NULL    COMMENT 'メモ',
	delete_flag       bit             NOT NULL    DEFAULT 0    COMMENT '削除フラグ(0:有効/1:削除)',
	updated_at        datetime        NOT NULL    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP    COMMENT 'レコード更新日時',
	PRIMARY KEY (id),
	KEY I1 (user_id),
	KEY I2 (title)
) ENGINE=Innodb DEFAULT CHARSET=utf8 COMMENT 'TODO情報';
