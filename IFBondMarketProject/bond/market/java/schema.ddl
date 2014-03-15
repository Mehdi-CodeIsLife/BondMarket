
    create table BondMarket.Administrator (
        id integer not null unique,
        createdAt date,
        email varchar(255),
        isActive bit,
        password varchar(255),
        username varchar(255),
        role integer,
        primary key (id)
    );

    create table BondMarket.AssetOption (
        id integer not null unique,
        settlement date,
        strike float,
        company integer,
        primary key (id)
    );

    create table BondMarket.Auction (
        id integer not null unique,
        asset integer,
        auction_price float,
        calledAt date,
        price float,
        puttedAt date,
        quantity integer,
        buyer integer,
        owner integer,
        primary key (id)
    );

    create table BondMarket.Company (
        id integer not null auto_increment unique,
        category varchar(255),
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table BondMarket.Investisor (
        id integer not null unique,
        createdAt date,
        email varchar(255),
        isActive bit,
        password varchar(255),
        username varchar(255),
        profile integer,
        role integer,
        primary key (id)
    );

    create table BondMarket.Member (
        id integer not null unique,
        createdAt date,
        email varchar(255),
        isActive bit,
        password varchar(255),
        username varchar(255),
        company integer,
        role integer,
        primary key (id)
    );

    create table BondMarket.Portfolio (
        id integer not null auto_increment unique,
        asset integer,
        quantity integer,
        owner integer,
        primary key (id)
    );

    create table BondMarket.Profile (
        id integer not null auto_increment unique,
        derivatives varchar(255),
        firstname varchar(255),
        lastname varchar(255),
        capitalization varchar(255),
        term_trading varchar(255),
        primary key (id)
    );

    create table BondMarket.Role (
        id integer not null auto_increment unique,
        name varchar(255),
        primary key (id)
    );

    create table BondMarket.SecurityAsset (
        id integer not null unique,
        information varchar(255),
        strike float,
        company integer,
        primary key (id)
    );

    create table BondMarket.StockOption (
        id integer not null unique,
        cote float,
        strike float,
        company integer,
        primary key (id)
    );

    create table BondMarket.Transaction (
        id integer not null unique,
        asset integer,
        calledAt date,
        price float,
        puttedAt date,
        quantity integer,
        buyer integer,
        owner integer,
        primary key (id)
    );

    alter table BondMarket.Administrator 
        add index FK8BEF2ADEA71401D (role), 
        add constraint FK8BEF2ADEA71401D 
        foreign key (role) 
        references BondMarket.Role (id);

    alter table BondMarket.AssetOption 
        add index FKA72613651E422029 (company), 
        add constraint FKA72613651E422029 
        foreign key (company) 
        references BondMarket.Company (id);

    alter table BondMarket.Auction 
        add index FK3BC57623F78DF26 (owner), 
        add constraint FK3BC57623F78DF26 
        foreign key (owner) 
        references BondMarket.Investisor (id);

    alter table BondMarket.Auction 
        add index FK3BC57623EC0EE26 (buyer), 
        add constraint FK3BC57623EC0EE26 
        foreign key (buyer) 
        references BondMarket.Investisor (id);

    alter table BondMarket.Investisor 
        add index FKE9CA7222EA71401D (role), 
        add constraint FKE9CA7222EA71401D 
        foreign key (role) 
        references BondMarket.Role (id);

    alter table BondMarket.Investisor 
        add index FKE9CA72228810BA81 (profile), 
        add constraint FKE9CA72228810BA81 
        foreign key (profile) 
        references BondMarket.Profile (id);

    alter table BondMarket.Member 
        add index FK892776BAEA71401D (role), 
        add constraint FK892776BAEA71401D 
        foreign key (role) 
        references BondMarket.Role (id);

    alter table BondMarket.Member 
        add index FK892776BA1E422029 (company), 
        add constraint FK892776BA1E422029 
        foreign key (company) 
        references BondMarket.Company (id);

    alter table BondMarket.Portfolio 
        add index FKBA4F2528F78DF26 (owner), 
        add constraint FKBA4F2528F78DF26 
        foreign key (owner) 
        references BondMarket.Investisor (id);

    alter table BondMarket.SecurityAsset 
        add index FK3FF3B701E422029 (company), 
        add constraint FK3FF3B701E422029 
        foreign key (company) 
        references BondMarket.Company (id);

    alter table BondMarket.StockOption 
        add index FK1697EB0B1E422029 (company), 
        add constraint FK1697EB0B1E422029 
        foreign key (company) 
        references BondMarket.Company (id);

    alter table BondMarket.Transaction 
        add index FKE30A7ABEF78DF26 (owner), 
        add constraint FKE30A7ABEF78DF26 
        foreign key (owner) 
        references BondMarket.Investisor (id);

    alter table BondMarket.Transaction 
        add index FKE30A7ABEEC0EE26 (buyer), 
        add constraint FKE30A7ABEEC0EE26 
        foreign key (buyer) 
        references BondMarket.Investisor (id);
