create table zametki
(
	id serial,
	"dateTime" varchar,
	description1 varchar,
	description2 varchar
);

alter table zametki alter column id drop not null;
alter table zametki alter column id drop default;
alter table zametki rename column "dateTime" to datetime;
   --drop index zametki_id_uindex;

