CREATE SCHEMA eas; -- Employee Attendance System

CREATE TABLE eas.employee (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(100),
    employee_address VARCHAR(255),
    employee_email VARCHAR(255),
    employee_department VARCHAR(100),
    employee_join_date DATE,
    employee_position VARCHAR(100),
    employee_salary INT,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX pk_employee_id_idx ON eas.employee (employee_id);

CREATE TABLE eas.leave (
    leave_id INT PRIMARY KEY,
    employee_id INT,
    leave_title VARCHAR(100),
    leave_detail TEXT,
    leave_request_date DATE,
    leave_acceptance_date DATE,
    leave_start_date DATE,
    leave_end_date DATE,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX pk_leave_id_idx ON eas.leave (leave_id);
CREATE INDEX fk_leave_employee_id_idx ON eas.leave (employee_id);

CREATE TABLE eas.task (
    task_id INT PRIMARY KEY,
    employee_id INT,
    task_name VARCHAR(100),
    task_date DATE,
    tast_start_time TIME WITHOUT TIME ZONE,
    task_end_time TIME WITHOUT TIME ZONE,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX pk_task_id_idx ON eas.task (task_id);
CREATE INDEX fk_task_employee_id_idx ON eas.task (employee_id);

COMMIT;
