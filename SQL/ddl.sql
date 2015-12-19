DROP DATABASE IF EXISTS test;
CREATE DATABASE test;

# user
DROP TABLE IF EXISTS test.user;
CREATE TABLE test.user
(
  id       INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255),
  password VARCHAR(255)
)comment'用户表';


# word
DROP TABLE IF EXISTS test.word;
CREATE TABLE test.word (
  id      INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  english VARCHAR(255),
  chinese VARCHAR(255)
) comment'词汇表';

DROP DATABASE IF EXISTS test;
CREATE DATABASE test;

# user
DROP TABLE IF EXISTS test.user;
CREATE TABLE test.user
(
  id       INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255),
  password VARCHAR(255),
  salt     VARCHAR(255)
);

# word
DROP TABLE IF EXISTS test.word;
CREATE TABLE test.word (
  id      INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  english VARCHAR(255),
  chinese VARCHAR(255)
);

USE test;
