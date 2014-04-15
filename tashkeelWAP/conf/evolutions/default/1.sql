# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  score                     integer,
  constraint pk_user primary key (email))
;

create table words (
  id                        integer not null,
  word                      varchar(255),
  image_link                varchar(255),
  franco                    varchar(255),
  no_of_signs               integer,
  tashkeel                  varchar(255),
  constraint pk_words primary key (id))
;

create sequence user_seq;

create sequence words_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists user;

drop table if exists words;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists user_seq;

drop sequence if exists words_seq;

