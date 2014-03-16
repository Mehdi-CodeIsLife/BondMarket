
    create table Asset (
        id integer not null auto_increment,
        strike float,
        company integer,
        primary key (id)
    );

    create table BondMarket.Administrator (
        id integer not null,
        primary key (id)
    );

    create table BondMarket.AssetOption (
        settlement date,
        id integer not null,
        primary key (id)
    );

    create table BondMarket.Auction (
        auction_price float,
        id integer not null,
        primary key (id)
    );

    create table BondMarket.Company (
        id integer not null auto_increment,
        category varchar(255),
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table BondMarket.Investisor (
        id integer not null,
        profile integer,
        primary key (id)
    );

    create table BondMarket.Member (
        id integer not null,
        company integer,
        primary key (id)
    );

    create table BondMarket.Portfolio (
        id integer not null auto_increment unique,
        title varchar(255),
        owner integer,
        primary key (id)
    );

    create table BondMarket.PortfolioLine (
        id integer not null auto_increment,
        quantity integer,
        asset_id integer,
        pf_id integer,
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

    create table BondMarket.StockOption (
        cote float,
        id integer not null,
        primary key (id)
    );

    create table BondMarket.Transaction (
        id integer not null,
        primary key (id)
    );

    create table Trad (
        id integer not null auto_increment,
        calledAt date,
        price float,
        puttedAt date,
        quantity integer,
        asset integer,
        buyer integer,
        owner integer,
        primary key (id)
    );

    create table User (
        id integer not null auto_increment,
        createdAt date,
        email varchar(255),
        isActive bit,
        password varchar(255),
        username varchar(255),
        primary key (id)
    );

    create table User_Role (
        user_id integer not null,
        role_id integer not null,
        primary key (user_id, role_id)
    );

    alter table Asset 
        add index FK3C9FAD01E422029 (company), 
        add constraint FK3C9FAD01E422029 
        foreign key (company) 
        references BondMarket.Company (id);

    alter table BondMarket.Administrator 
        add index FK8BEF2ADEA3D3817 (id), 
        add constraint FK8BEF2ADEA3D3817 
        foreign key (id) 
        references User (id);

    alter table BondMarket.AssetOption 
        add index FKA72613655C4E9EFA (id), 
        add constraint FKA72613655C4E9EFA 
        foreign key (id) 
        references Asset (id);

    alter table BondMarket.Auction 
        add index FK3BC57623EA3CBF6D (id), 
        add constraint FK3BC57623EA3CBF6D 
        foreign key (id) 
        references Trad (id);

    alter table BondMarket.Investisor 
        add index FKE9CA7222EA3D3817 (id), 
        add constraint FKE9CA7222EA3D3817 
        foreign key (id) 
        references User (id);

    alter table BondMarket.Investisor 
        add index FKE9CA72228810BA81 (profile), 
        add constraint FKE9CA72228810BA81 
        foreign key (profile) 
        references BondMarket.Profile (id);

    alter table BondMarket.Member 
        add index FK892776BAEA3D3817 (id), 
        add constraint FK892776BAEA3D3817 
        foreign key (id) 
        references User (id);

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

    alter table BondMarket.PortfolioLine 
        add index FK68C753C460FF2A9 (asset_id), 
        add constraint FK68C753C460FF2A9 
        foreign key (asset_id) 
        references Asset (id);

    alter table BondMarket.PortfolioLine 
        add index FK68C753C87DDB4BB (pf_id), 
        add constraint FK68C753C87DDB4BB 
        foreign key (pf_id) 
        references BondMarket.Portfolio (id);

    alter table BondMarket.StockOption 
        add index FK1697EB0B5C4E9EFA (id), 
        add constraint FK1697EB0B5C4E9EFA 
        foreign key (id) 
        references Asset (id);

    alter table BondMarket.Transaction 
        add index FKE30A7ABEEA3CBF6D (id), 
        add constraint FKE30A7ABEEA3CBF6D 
        foreign key (id) 
        references Trad (id);

    alter table Trad 
        add index FK27E74161DB7CCF (asset), 
        add constraint FK27E74161DB7CCF 
        foreign key (asset) 
        references Asset (id);

    alter table Trad 
        add index FK27E741F78DF26 (owner), 
        add constraint FK27E741F78DF26 
        foreign key (owner) 
        references BondMarket.Investisor (id);

    alter table Trad 
        add index FK27E741EC0EE26 (buyer), 
        add constraint FK27E741EC0EE26 
        foreign key (buyer) 
        references BondMarket.Investisor (id);

    alter table User_Role 
        add index FK8B9F886A3C4D552B (role_id), 
        add constraint FK8B9F886A3C4D552B 
        foreign key (role_id) 
        references BondMarket.Role (id);

    alter table User_Role 
        add index FK8B9F886AE178190B (user_id), 
        add constraint FK8B9F886AE178190B 
        foreign key (user_id) 
        references User (id);
