CREATE USER 'coursedb_user'@'localhost' IDENTIFIED BY 'coursedb_pswd';

GRANT ALL PRIVILEGES ON cs532_coursedb_ex.* TO 'coursedb_user'@'localhost' WITH GRANT OPTION;

SHOW GRANTS FOR 'coursedb_user'@'localhost';