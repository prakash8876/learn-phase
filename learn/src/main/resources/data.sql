INSERT INTO  address (area, city, pin_code) values ('GANDHI NAGAR', 'PUNE', '411011'),
                                                    ('ABC Road', 'Delhi', '011011'),
                                                    ('ACD Lane 2', 'Delhi', '611011');

INSERT INTO  college (address_id,college_name) values (1,'KIDZEE'),(2, 'IIT');

INSERT INTO  student (student_name,student_email,student_class,college_id,address_id,created_at)values ('Rutu','rutu@email.com','PlayGroup',1,2,CURRENT_TIMESTAMP);

COMMIT;