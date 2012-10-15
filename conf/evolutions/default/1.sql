# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table match (
  id                        bigint not null,
  status                    integer,
  name                      varchar(255),
  data                      blob,
  constraint pk_match primary key (id))
;

create sequence match_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists match;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists match_seq;

