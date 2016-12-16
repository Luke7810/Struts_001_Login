CREATE DATABASE struts_user;

USE struts_user;

CREATE TABLE `admininfor`(
`id` INT NOT NULL AUTO_INCREMENT,
`username` VARCHAR(20) NOT NULL,
`userpwd` VARCHAR(20) NOT NULL,
PRIMARY KEY(`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `struts_user`.`admininfor` (`id`, `username`, `userpwd`) VALUES (NULL, 'Zhang San', '12345678'); 
INSERT INTO `struts_user`.`admininfor` (`id`, `username`, `userpwd`) VALUES (NULL, 'Li Si', '12345678'); 
INSERT INTO `struts_user`.`admininfor` (`id`, `username`, `userpwd`) VALUES (NULL, 'Wang Wu', '12345678'); 
INSERT INTO `struts_user`.`admininfor` (`id`, `username`, `userpwd`) VALUES (NULL, 'Liu Dehua', '12345678'); 
INSERT INTO `struts_user`.`admininfor` (`id`, `username`, `userpwd`) VALUES (NULL, 'Luke', '12345678');