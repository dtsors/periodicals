create table orders
(
  id int auto_increment
    primary key,
  user_id int not null,
  periodical_id int not null,
  count int not null
)
;

create table periodicals
(
  id int auto_increment
    primary key,
  name varchar(255) not null,
  description varchar(1024) not null,
  issuesPerMonth int not null,
  cost decimal(5,2) not null,
  constraint periodicals_name_uindex
  unique (name)
)
;

create table users
(
  id int auto_increment
    primary key,
  login varchar(255) not null,
  password varchar(60) not null,
  email varchar(255) not null,
  token varchar(255) default '' not null,
  role set('admin', 'subscriber') default 'subscriber' not null,
  constraint users_login_uindex
  unique (login),
  constraint users_email_uindex
  unique (email)
)
;

create index users_token_index
  on users (token)
;

