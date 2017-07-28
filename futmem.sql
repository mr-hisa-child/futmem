
/* Drop Tables */

DROP TABLE IF EXISTS t_assist;
DROP TABLE IF EXISTS t_attend;
DROP TABLE IF EXISTS t_goal;
DROP TABLE IF EXISTS m_member;
DROP TABLE IF EXISTS t_match;
DROP TABLE IF EXISTS t_user_team;
DROP TABLE IF EXISTS m_team;
DROP TABLE IF EXISTS m_user;




/* Create Tables */

CREATE TABLE m_member
(
	member_id serial NOT NULL,
	member_name varchar(100) NOT NULL,
	no int NOT NULL,
	team_id int NOT NULL,
	PRIMARY KEY (member_id)
) WITHOUT OIDS;


CREATE TABLE m_team
(
	team_id serial NOT NULL,
	team_name varchar(100) NOT NULL,
	PRIMARY KEY (team_id)
) WITHOUT OIDS;


CREATE TABLE m_user
(
	user_id serial NOT NULL,
	user_name varchar(100) NOT NULL,
	mailaddress varchar(100) NOT NULL UNIQUE,
	password varchar(64) NOT NULL,
	PRIMARY KEY (user_id)
) WITHOUT OIDS;


CREATE TABLE t_assist
(
	match_id int NOT NULL,
	member_id int NOT NULL,
	score int NOT NULL,
	team_id int NOT NULL,
	PRIMARY KEY (match_id, member_id)
) WITHOUT OIDS;


CREATE TABLE t_attend
(
	attend_id serial NOT NULL,
	attend_date date NOT NULL,
	member_id int NOT NULL,
	team_id int NOT NULL,
	PRIMARY KEY (attend_id)
) WITHOUT OIDS;


CREATE TABLE t_goal
(
	match_id int NOT NULL,
	member_id int NOT NULL,
	score int NOT NULL,
	team_id int NOT NULL,
	PRIMARY KEY (match_id, member_id)
) WITHOUT OIDS;


CREATE TABLE t_match
(
	match_id serial NOT NULL,
	enemy_team_name varchar(100) NOT NULL,
	goals int NOT NULL,
	goals_against int NOT NULL,
	match_date date NOT NULL,
	team_id int NOT NULL,
	PRIMARY KEY (match_id)
) WITHOUT OIDS;


CREATE TABLE t_user_team
(
	user_id int NOT NULL,
	team_id int NOT NULL,
	PRIMARY KEY (user_id, team_id)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE t_assist
	ADD FOREIGN KEY (member_id)
	REFERENCES m_member (member_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE t_attend
	ADD FOREIGN KEY (member_id)
	REFERENCES m_member (member_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE t_goal
	ADD FOREIGN KEY (member_id)
	REFERENCES m_member (member_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE m_member
	ADD FOREIGN KEY (team_id)
	REFERENCES m_team (team_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE t_assist
	ADD FOREIGN KEY (team_id)
	REFERENCES m_team (team_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE t_attend
	ADD FOREIGN KEY (team_id)
	REFERENCES m_team (team_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE t_goal
	ADD FOREIGN KEY (team_id)
	REFERENCES m_team (team_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE t_match
	ADD FOREIGN KEY (team_id)
	REFERENCES m_team (team_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE t_user_team
	ADD FOREIGN KEY (team_id)
	REFERENCES m_team (team_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE t_user_team
	ADD FOREIGN KEY (user_id)
	REFERENCES m_user (user_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE t_assist
	ADD FOREIGN KEY (match_id)
	REFERENCES t_match (match_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE t_goal
	ADD FOREIGN KEY (match_id)
	REFERENCES t_match (match_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



