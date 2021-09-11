-- spu表
CREATE TABLE Spu (
id INT ( 11 ) NOT NULL AUTO_INCREMENT,
create_time datetime NOT NULL,
update_time datetime NULL,
creator_id INT ( 11 ) NOT NULL,
updator_id INT ( 11 ),
NAME VARCHAR ( 60 ) NOT NULL,
remark VARCHAR ( 255 ),
pic_url VARCHAR ( 512 ),
delete_version datetime NULL,
delete_time datetime NULL,
version INT ( 11 ),
PRIMARY KEY ( id ),
INDEX ( NAME )
);

-- sku表
CREATE TABLE Sku (
id INT ( 11 ) NOT NULL AUTO_INCREMENT,
create_time datetime NOT NULL,
update_time datetime NULL,
creator_id INT ( 11 ) NOT NULL,
updator_id INT ( 11 ),
STATUS VARCHAR ( 60 ) NOT NULL,
NAME VARCHAR ( 60 ) NOT NULL,
spu_id INT ( 11 ) NOT NULL,
pic_url VARCHAR ( 512 ),
delete_version INT ( 11 ),
delete_time datetime NULL,
version INT ( 11 ),
PRIMARY KEY ( id ),
INDEX ( NAME ),
INDEX ( spu_id )
);

-- specification表
CREATE TABLE sku_specifications (
id INT ( 11 ) NOT NULL AUTO_INCREMENT,
create_time datetime NOT NULL,
update_time datetime NULL,
creator_id INT ( 11 ) NOT NULL,
updator_id INT ( 11 ),
spec_name VARCHAR ( 255 ) NOT NULL,
spec_value VARCHAR ( 255 ) NOT NULL,
sku_id INT ( 11 ) NOT NULL,
delete_version INT ( 11 ),
delete_time datetime NULL,
version INT ( 11 ),
PRIMARY KEY ( id ),
INDEX ( sku_id )
);

-- soh表
CREATE TABLE Soh (
id INT ( 11 ) NOT NULL AUTO_INCREMENT,
create_time datetime NOT NULL,
update_time datetime NULL,
creator_id INT ( 11 ) NOT NULL,
updator_id INT ( 11 ),
order_time datetime NOT NULL,
CODE VARCHAR ( 60 ) NOT NULL UNIQUE,
STATUS datetime NOT NULL,
buyer_name VARCHAR ( 60 ) NOT NULL,
buyer_province VARCHAR ( 60 ) NOT NULL,
buyer_city VARCHAR ( 60 ) NOT NULL,
buyer_county VARCHAR ( 60 ) NOT NULL,
buyer_detail_addr VARCHAR ( 360 ) NOT NULL,
seller_name VARCHAR ( 60 ),
seller_province VARCHAR ( 60 ),
seller_city VARCHAR ( 60 ),
seller_county VARCHAR ( 60 ),
seller_detail_addr VARCHAR ( 360 ),
delete_version INT ( 11 ),
delete_time datetime NULL,
version INT ( 11 ),
PRIMARY KEY ( id )
);

-- sod表
CREATE TABLE Sod (
id INT ( 11 ) NOT NULL AUTO_INCREMENT,
create_time datetime NOT NULL,
update_time datetime NULL,
creator_id INT ( 11 ) NOT NULL,
updator_id INT ( 11 ),
STATUS VARCHAR ( 60 ) NOT NULL,
soh_id INT ( 11 ) NOT NULL,
sku_name VARCHAR ( 60 ) NOT NULL,
qty INT ( 11 ) NOT NULL,
sku_specifications VARCHAR ( 512 ) NOT NULL,
delete_version INT ( 11 ),
delete_time datetime NULL,
version INT ( 11 ),
PRIMARY KEY ( id ),
INDEX ( soh_id ),
INDEX ( sku_name )
);

-- user表
CREATE TABLE `User` (
id INT ( 11 ) NOT NULL AUTO_INCREMENT,
NAME INT ( 11 ) NOT NULL,
province INT ( 11 ) NOT NULL,
city INT ( 11 ) NOT NULL,
detail_addr INT ( 11 ) NOT NULL,
STATUS VARCHAR ( 30 ) NOT NULL,
version INT ( 11 ),
PRIMARY KEY ( id ),
INDEX ( NAME )
);