
    drop table if exists CHARGER;

    create table CHARGER (
        ID varchar(42) not null comment 'chargerID',
        STATIONID varchar(42) comment 'stationID',
        POWERLEFT float comment 'powerLeft',
        CHARGERSTATUS varchar(255) comment '0  1  2  ',
        CHARGERCAPACITY float comment 'chargerCapacity',
        BATTERYTYPE varchar(255) comment 'batteryType',
        DEPLOYDATE varchar(255) comment 'deployDate',
        MANUFACTURER varchar(255) comment 'manufacturer',
        REMARK varchar(255) comment '备注',
        primary key (ID)
    ) comment='Charger';
