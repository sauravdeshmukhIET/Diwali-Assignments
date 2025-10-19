1. Display top 5 highest salary earners in each dept 

SELECT emp_id, emp_name, dept_id, salary
FROM (
    SELECT *,
           RANK() OVER (PARTITION BY dept_id ORDER BY salary DESC) AS rnk
    FROM Emp
) ranked
WHERE rnk <= 5;

===================================================
2. Write a stored function getWorkingDays which accepts joining data and returns 
the no of working days 

DELIMITER $

CREATE FUNCTION getWorkingDays(join_date DATE) 
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE total_days INT;
    DECLARE working_days INT DEFAULT 0;
    DECLARE current_day DATE;
    SET total_days = DATEDIFF(CURDATE(), join_date);
    SET current_day = join_date;
    WHILE total_days >= 0 DO
    IF DAYOFWEEK(current_day) BETWEEN 2 AND 6 THEN
    SET working_days = working_days + 1;
    END IF;
    SET current_day = DATE_ADD(current_day, INTERVAL 1 DAY);
    SET total_days = total_days - 1;
    END WHILE;
    RETURN working_days;
END$
DELIMITER ;
==============================================================
3. Write a stored procedure which updates the salary of a given emp based on no of working days. Give differential salary rise based on no of working days. 

DELIMITER $

CREATE PROCEDURE updateSalaryBasedOnWorkingDays(IN p_emp_id INT)
BEGIN
    DECLARE w_days INT;
    DECLARE current_salary DECIMAL(10,2);
    DECLARE new_salary DECIMAL(10,2);
    DECLARE emp_join_date DATE;
    SELECT joining_date INTO emp_join_date FROM employees WHERE emp_id = p_emp_id;
    SET w_days = getWorkingDays(emp_join_date);
   SELECT salary INTO current_salary FROM employees WHERE emp_id = p_emp_id;
    IF w_days > 250 THEN
        SET new_salary = current_salary * 1.20;
    ELSEIF w_days > 200 THEN
        SET new_salary = current_salary * 1.15;
    ELSEIF w_days > 150 THEN
        SET new_salary = current_salary * 1.10;
    ELSE
        SET new_salary = current_salary * 1.05;
    END IF;
    UPDATE employees SET salary = new_salary WHERE emp_id = p_emp_id;
    SELECT CONCAT('Updated salary for emp_id ', p_emp_id, ' to ', new_salary) AS Result;
END$
DELIMITER ;
