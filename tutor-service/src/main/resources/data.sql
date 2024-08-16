insert into tutor(first_name, last_name, user_name, password, email)
values ('First', 'Tutor', 'ftutor', '123', 'ftutor@domain.com'),
       ('Second', 'Tutor', 'stutor', '321', 'stutor@domain.com'),
       ('Third', 'Tutor', 'ttutor', '456', 'ttutor@domain.com');

insert into subject(name)
values ('Math'),
       ('Physics');

insert into tutor_subject(tutor_id, subject_id)
values (1, 1),
       (1, 2),
       (2, 1),
       (3, 2);

insert into availability_time(date_time_from, date_time_to, tutor_id)
values ('2024-01-01 10:00:00', '2024-01-01 12:00:00', 1),
       ('2024-01-02 10:00:00', '2024-01-02 12:00:00', 2),
       ('2024-01-03 10:00:00', '2024-01-03 12:00:00', 3);