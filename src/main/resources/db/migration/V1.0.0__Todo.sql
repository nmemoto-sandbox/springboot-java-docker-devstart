create table todo (
  id serial primary key,
  name varchar(255) not null,
  done boolean not null default false,
  updated_time timestamp not null default current_timestamp,
  created_time timestamp not null default current_timestamp
);