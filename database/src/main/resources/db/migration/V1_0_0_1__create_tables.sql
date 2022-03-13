-- アカウント

create schema if not exists accounts;

create table accounts.accounts (
    id uuid not null,
    created_at timestamp not null default current_timestamp,
    primary key (id)
);

create table accounts.account_revisions (
    id uuid not null,
    revision bigint not null,
    created_at timestamp not null default current_timestamp,
    primary key (id, revision),
    foreign key (id) references accounts.accounts (id)
);

create table accounts.latest_accounts (
    id uuid not null,
    revision bigint not null,
    created_at timestamp not null default current_timestamp,
    primary key (id),
    foreign key (id) references accounts.accounts (id),
    foreign key (id, revision) references accounts.account_revisions (id, revision)
);

create table accounts.account_revision_values (
    id uuid not null,
    revision bigint not null,
    email varchar(1024) not null,
    created_at timestamp not null default current_timestamp,
    primary key (id, revision),
    foreign key (id, revision) references accounts.account_revisions (id, revision)
);

create table accounts.account_revision_counts (
    id uuid not null,
    revision bigint not null,
    created_at timestamp not null default current_timestamp,
    primary key (id),
    foreign key (id) references accounts.accounts (id)
);

create table accounts.locked_accounts(
    id uuid not null,
    primary key (id),
    created_at timestamp not null default current_timestamp,
    foreign key (id) references accounts.accounts (id)
);

create table accounts.deleted_accounts(
    id uuid not null,
    created_at timestamp not null default current_timestamp,
    primary key (id),
    foreign key (id) references accounts.accounts (id)
);

-- 従業員
create schema if not exists employees;

create table employees.employees(
    id uuid not null,
    created_at timestamp not null default current_timestamp,
    primary key (id),
    foreign key (id) references accounts.accounts (id)
);

create table employees.employee_revisions(
    id uuid not null,
    revision bigint not null,
    created_at timestamp not null default current_timestamp,
    primary key (id, revision),
    foreign key (id) references employees.employees (id)
);

create table employees.latest_employees(
    id uuid not null,
    revision bigint not null,
    created_at timestamp not null default current_timestamp,
    primary key (id),
    foreign key (id) references employees.employees (id),
    foreign key (id, revision) references employees.employee_revisions (id, revision)
);

create table employees.employee_revision_values(
    id uuid not null,
    revision bigint not null,
    account_revision bigint not null,
    created_at timestamp not null default current_timestamp,
    primary key (id, revision),
    foreign key (id) references employees.employees (id),
    foreign key (id, revision) references employees.employee_revisions (id, revision),
    foreign key (id, account_revision) references accounts.account_revisions (id, revision)
);

create table employees.employee_revision_counts (
    id uuid not null,
    revision bigint not null,
    created_at timestamp not null default current_timestamp,
    primary key (id),
    foreign key (id) references employees.employees (id)
);

create table employees.deleted_employees(
    id uuid not null,
    created_at timestamp not null default current_timestamp,
    primary key (id),
    foreign key (id) references employees.employees (id)
);
