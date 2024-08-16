create table tutor(
    id bigint generated always as identity primary key,
    first_name varchar,
    last_name varchar,
    user_name varchar,
    password varchar,
    email varchar
);

create table subject(
    id bigint generated always as identity primary key,
    name varchar
);

create table tutor_subject(
    tutor_id bigint,
    subject_id bigint
);

alter table tutor_subject
    add foreign key (tutor_id)
        references tutor(id);

alter table tutor_subject
    add foreign key (subject_id)
        references subject(id);


create table availability_time(
    id bigint generated always as identity primary key,
    date_time_from timestamp,
    date_time_to timestamp,
    tutor_id bigint
);

alter table availability_time
    add foreign key (tutor_id)
        references tutor(id);