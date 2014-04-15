# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table hinter (
  email                     varchar(255) not null,
  name                      varchar(255),
  password                  varchar(255),
  score                     integer,
  constraint pk_hinter primary key (email))
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

create sequence hinter_seq;

create sequence words_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists hinter;

drop table if exists words;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists hinter_seq;

drop sequence if exists words_seq;

