USE `sakila`;
DROP procedure IF EXISTS `openv_sp_one`;
DELIMITER $$
USE `sakila`$$
DELIMITER $$
CREATE  PROCEDURE  `openv_sp_one`(IN p_in VARCHAR(100),OUT p_out VARCHAR(100))
BEGIN
     SELECT last_name into p_out FROM customer where email=p_In;
END$$
DELIMITER ;


USE `sakila`;
DROP procedure IF EXISTS `openv_sp_many`;
DELIMITER $$
USE `sakila`$$
CREATE PROCEDURE `sakila`.`openv_sp_many` ()
BEGIN
       SELECT first_name ,last_name,email  FROM customer;
END
$$
DELIMITER ;
