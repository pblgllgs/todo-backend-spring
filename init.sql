drop table if exists todo;
drop table if exists todo_seq;
create table todo (id integer not null, description varchar(255), done bit not null, target_date date, username varchar(255), primary key (id));
create table todo_seq (next_val bigint);
insert into todo_seq values ( 1 );

INSERT INTO todo (id, description,done, target_date, username) VALUES (10001,'Learn Docker', false, CURRENT_DATE(),'pblgllgs');
INSERT INTO todo (id, description,done, target_date, username) VALUES (10002,'Learn AWS', false, CURRENT_DATE(),'pblgllgs');
INSERT INTO todo (id, description,done, target_date, username) VALUES (10003,'Learn Node', false, CURRENT_DATE(),'pblgllgs');