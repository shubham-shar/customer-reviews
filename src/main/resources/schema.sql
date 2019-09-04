drop table if exists comment;
drop table if exists review;
drop table if exists product;

create table product (
	id integer not null auto_increment,
	name varchar(255),
	brand varchar(255),
	description varchar(255),
	created_at datetime,
	updated_at datetime,
	primary key (id)
);

create table review (
	id integer not null auto_increment,
	content varchar(255),
	username varchar(255),
	rating bigint,
	product_id integer not null,
	created_at datetime,
	updated_at datetime,
	primary key (id),
  FOREIGN KEY (product_id) REFERENCES product(id)
);

create table comment (
	id integer not null auto_increment,
	content varchar(255),
	username varchar(255),
	review_id integer not null,
	created_at datetime,
	updated_at datetime,
	primary key (id),
  FOREIGN KEY (review_id) REFERENCES review(id)
);