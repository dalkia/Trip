# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table match (
  id                        bigint not null,
  status                    integer,
  name                      varchar(255),
  attacker_id               bigint,
  defender_id               bigint,
  attacker_data             blob,
  defender_data             blob,
  constraint pk_match primary key (id))
;

create table player (
  id                        bigint not null,
  username                  varchar(255),
  password                  varchar(255),
  constraint pk_player primary key (id))
;

create sequence match_seq;

create sequence player_seq;

alter table match add constraint fk_match_attacker_1 foreign key (attacker_id) references player (id) on delete restrict on update restrict;
create index ix_match_attacker_1 on match (attacker_id);
alter table match add constraint fk_match_defender_2 foreign key (defender_id) references player (id) on delete restrict on update restrict;
create index ix_match_defender_2 on match (defender_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists match;

drop table if exists player;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists match_seq;

drop sequence if exists player_seq;

