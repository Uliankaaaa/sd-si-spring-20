create database ncProject;

use ncProject;

create table nc_object_types(
		object_type_id int unsigned auto_increment primary key,
        name varchar(50) not null,
        parent_id int unsigned not null,
        description varchar(200));
        
create table nc_objects(
		object_id int unsigned auto_increment primary key,
        name varchar(50) not null,
        object_type_id int unsigned,
        description varchar(200),
		foreign key (object_type_id) references nc_object_types(object_type_id));    

create table nc_attr_type_defs(
			attr_type_def_id int unsigned auto_increment primary key,
            type int not null,
            object_type_id int unsigned,
            description varchar (200),
            foreign key (object_type_id) references nc_object_types(object_type_id));		

create table nc_attributes(
			attr_id int unsigned auto_increment primary key,
            name varchar(50) not null,
            attr_type_def_id int unsigned,
            foreign key (attr_type_def_id) references nc_attr_type_defs(attr_type_def_id));

create table nc_attr_object_types(
			attr_id int unsigned,
            object_type_id int unsigned,
            foreign key	(attr_id) references nc_attributes(attr_id),
            foreign key (object_type_id) references nc_object_types(object_type_id));                    
            
create table nc_references(
            object_id int unsigned,
            attr_id int unsigned,
            reference int unsigned,
            foreign key (object_id) references nc_objects(object_id),
            foreign key (attr_id) references nc_attributes(attr_id));

create table nc_list_values(
		list_value_id int unsigned auto_increment primary key,
        value varchar(50) not null,
        attr_type_def_id int unsigned,
        foreign key (attr_type_def_id) references nc_attr_type_defs(attr_type_def_id));
        
create table nc_params(
			object_id int unsigned,
            attr_id int unsigned,
            list_value_id int unsigned,
			value varchar(50),
			foreign key (object_id) references nc_objects(object_id),
            foreign key (attr_id) references nc_attributes(attr_id),
            foreign key (list_value_id) references nc_list_values(list_value_id));
        
insert into nc_object_types
values  
	(null, 'All', 0, 'Based Object Type'),
    (null, 'Abstract Order Object Type', 1, 'Abstract Object Type for all Porduct Orders'),
	(null, 'Abstract Instance Object Types', 1, 'Abstract Object Type for all Porduct Instances'),
	(null, 'Internet Order Object Type', 2, null),
	(null, 'Video Order Object Type', 2, null),
	(null, 'Mobile Order Object Type', 2, null),
	(null, 'Internet Instance Object Types', 3, null),
	(null, 'Video Instance Object Types', 3, null),
    (null, 'Mobile Order Object Type', 3, null),
	(null, 'Phone number', 1, 'Phone Number Object Type');

insert into nc_attr_type_defs
values
	(null, 0, null, 'For ane Text attribute'),
    (null, 2, null, 'For any Number attribute'),
    (null, 3, null, 'For any decimal attribute'),
    (null, 4, null, 'For any Date attribute'),
    (null, 6, null, 'Access Type Values'),
    (null, 6, null, 'Service Type Values'),
    (null, 6, null, 'Order Status Values'),
    (null, 9, 10, 'For any Reference to Phone Number OT');
    
insert into  nc_list_values
values
	(null, 'XDSL', 5),
	(null, 'GPON', 5),
	(null, 'Postpaid', 6),
	(null, 'Prepaid', 6),
    (null, 'Entering', 7),
    (null, 'Completed', 7),
    (null, 'Cancelled', 7),
    (null, 'Processing', 7);

insert into nc_attributes
values
	(null, 'Due Date', 4),
	(null, 'Phone Number', 8),
	(null, 'Access Type', 5),
	(null, 'Download Speed', 1),
	(null, 'Service Type', 6),
	(null, 'Suspend Reason', 1),
    (null, 'Activation Period', 2),
    (null, 'Product Price', 3),
    (null, 'Order Status', 7);

insert into nc_attr_object_types
values
	(1, 2),
    (2, 6),
    (3, 4),
    (4, 4),
    (5, 6),
    (6, 5),
    (7, 2),
    (8, 2),
    (9, 2);

create table nc_id_keeper(
	id int unsigned not null);
insert into nc_id_keeper values(12);
