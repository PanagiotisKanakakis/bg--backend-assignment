insert into users values ('pk','','','$2a$12$.eNfQVZf1JxUGosbhZMXW.gq1CvD1HWs9CRyxARQ4GxtgF3TjFl/a','','') on duplicate key update username=username;
insert into users values ('pk1','','','$2a$12$.eNfQVZf1JxUGosbhZMXW.gq1CvD1HWs9CRyxARQ4GxtgF3TjFl/a','','') on duplicate key update username=username;

insert into unit values ('1',0,'','',120,'paris','one') on duplicate key update unit_id=unit_id;
insert into unit values ('2',0,'','',120,'athens','two') on duplicate key update unit_id=unit_id;
insert into unit values ('3',0,'','',120,'rome','three') on duplicate key update unit_id=unit_id;
insert into unit values ('4',0,'','',90,'athens','four') on duplicate key update unit_id=unit_id;
insert into unit values ('5',0,'','',80,'athens','one') on duplicate key update unit_id=unit_id;
insert into unit values ('6',0,'','',70,'paris','two') on duplicate key update unit_id=unit_id;
insert into unit values ('7',0,'','',80,'rome','four') on duplicate key update unit_id=unit_id;
insert into unit values ('8',0,'','',90,'rome','five') on duplicate key update unit_id=unit_id;
insert into unit values ('9',0,'','',90,'athens','one') on duplicate key update unit_id=unit_id;
insert into unit values ('10',0,'','',100,'paris','one') on duplicate key update unit_id=unit_id;
insert into unit values ('11',0,'','',123,'paris','one') on duplicate key update unit_id=unit_id;
