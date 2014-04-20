# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table digitization (
  session_num               integer not null,
  digitization              varchar(255),
  word_id                   integer,
  franco                    varchar(255),
  no_of_signs               integer,
  hinter_id                 integer,
  solver_id                 integer,
  constraint pk_digitization primary key (session_num))
;

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
  repetition_num            integer,
  tashkeel                  varchar(255),
  constraint pk_words primary key (id))
;

create sequence digitization_seq;

create sequence user_seq;

create sequence words_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists digitization;

drop table if exists user;

drop table if exists words;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists digitization_seq;

drop sequence if exists user_seq;

drop sequence if exists words_seq;

