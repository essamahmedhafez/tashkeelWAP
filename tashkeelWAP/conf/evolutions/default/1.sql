# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table digitization (
  session_num               integer auto_increment not null,
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
  id                        integer,
  name                      varchar(255),
  password                  varchar(255),
  score                     integer,
  constraint pk_user primary key (email))
;

create table words (
  id                        integer auto_increment not null,
  word                      varchar(255),
  image_link                varchar(255),
  repetition_num            integer,
  tashkeel                  varchar(255),
  constraint pk_words primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table digitization;

drop table user;

drop table words;

SET FOREIGN_KEY_CHECKS=1;

