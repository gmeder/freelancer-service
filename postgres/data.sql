DELETE FROM freelancer_skills;
DELETE FROM freelancer;
DELETE FROM skill;

INSERT INTO freelancer (freelancer_id,email_address,first_name,last_name) values (123,'test@test.com','john','doe');
INSERT INTO skill (skill_id,description,name) values (1,'java miscroservice','java');
INSERT INTO freelancer_skills (freelancer_id,skill_id) values (123,1);