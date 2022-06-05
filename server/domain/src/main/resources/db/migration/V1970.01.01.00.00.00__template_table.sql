create table template(
    id bigserial not null primary key,
    name varchar(128) not null,
    value varchar(2048)
);

create index idx__template__name on template(name);
