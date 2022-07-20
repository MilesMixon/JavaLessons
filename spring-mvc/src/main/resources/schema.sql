-- Format Spring is expecting for tables
-- Needs a table called Users with these values
create table users(
	username varchar(50) not null primary key,
	password varchar(100) not null,
	enabled boolean not null
	);
insert into users values('dan', 'pickles', true); 

-- needs an authorities table with these values
create table authorities (
		username varchar(50) not null,
		authority varchar(50) not null,
		constraint fk_authorities_users foreign key(username) references users(username)
	);
create unique index ix_auth_username on authorities (username,authority);
insert into authorities values('dan', 'ROLE_USER');
insert into authorities values('dan', 'ROLE_ADMIN');