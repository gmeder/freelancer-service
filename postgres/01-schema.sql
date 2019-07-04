drop table if exists freelancer cascade;
drop table if exists freelancer_skills cascade;
drop table if exists skill cascade;
drop sequence if exists hibernate_sequence;   
    

create table freelancer (
       freelancer_id int8 not null,
        email_address varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        primary key (freelancer_id)
    );

    create table freelancer_skills (
       freelancer_id int8 not null,
        skill_id int8 not null
    );


    create table skill (
       skill_id int8 not null,
        description varchar(255),
        name varchar(255),
        primary key (skill_id)
    );


    alter table freelancer_skills
       add constraint freelancer_skills_skills_fkey
       foreign key (skill_id)
       references skill;


    alter table freelancer_skills
       add constraint freelancer_skills_freelancer_fkey
       foreign key (freelancer_id)
       references freelancer;