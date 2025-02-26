INSERT INTO
  address (id, area, city, pin_code)
values
  (DEFAULT, 'GANDHI NAGAR', 'PUNE', '411011'),
  (DEFAULT, 'ABC Road', 'Delhi', '011011'),
  (DEFAULT, 'ACD Lane 2', 'Delhi', '611011');

INSERT INTO
  college (address_id, id, college_name)
values
  (1, DEFAULT, 'KIDZEE'),
  (2, DEFAULT, 'IIT');

INSERT INTO
  student (
    id,
    student_name,
    student_email,
    student_class,
    college_id,
    address_id,
    created_at
  )
values
  (
    DEFAULT,
    'Rutu',
    'rutu@email.com',
    'PlayGroup',
    2,
    3,
    CURRENT_TIMESTAMP()
  );