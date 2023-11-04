create table USR_INFO (
    id bigint not null auto_increment primary key ,
    usr_key varchar(32) not null unique ,
    usr_reg_num varchar(50) not null ,
    usr_nm varchar(20) not null ,
    usr_icm_amt bigint default 0 not null
);

create table LOAN_REVIEW (
                          id bigint not null auto_increment primary key ,
                          usr_key varchar(32) not null unique ,
                          loan_lmt_amt bigint default 0 not null,
                          loan_intrt double default 0 not null
);


create table PRODUCT_INFO(
    id bigint not null auto_increment primary key ,
    org_cd varchar(5) not null unique ,
    prod_cd varchar(3) not null unique ,
    prod_nm varchar(100) not null ,
    prod_min_intr double default 0 not null ,
    prod_max_intr double default 0 not null
)