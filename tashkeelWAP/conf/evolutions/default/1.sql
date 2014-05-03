# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table digitization (
  session_num               integer auto_increment not null,
  word_id                   integer,
  solver_email              varchar(255),
  digitization              varchar(255),
  constraint pk_digitization primary key (session_num))
;

create table signs (
  session_num               integer auto_increment not null,
  word_id                   integer,
  hinter_email              varchar(255),
  franco                    varchar(255),
  no_of_signs               integer,
  damma                     tinyint(1) default 0,
  fat7a                     tinyint(1) default 0,
  kasra                     tinyint(1) default 0,
  sekon                     tinyint(1) default 0,
  shadda                    tinyint(1) default 0,
  tanween_maftoo7           tinyint(1) default 0,
  tanween_maksoor           tinyint(1) default 0,
  tanween_madmoom           tinyint(1) default 0,
  constraint pk_signs primary key (session_num))
;

create table user (
  email                     varchar(255) not null,
  username                  varchar(255),
  password                  varchar(255),
  score                     integer,
  solver                    tinyint(1) default 0,
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

drop table signs;

drop table user;

drop table words;

SET FOREIGN_KEY_CHECKS=1;

