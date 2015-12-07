DROP TABLE IF EXISTS user;

create TABLE "user" (
  id int(10) unsigned not null,
  "user" varchar(255),
  password varchar(255),
  PRIMARY KEY (id)
) COMMENT '用户表';
DROP TABLE IF EXISTS word;
CREATE TABLE test.word (
  id      INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  chinese TEXT,
  english TEXT
)
  COMMENT '词汇表' ;


