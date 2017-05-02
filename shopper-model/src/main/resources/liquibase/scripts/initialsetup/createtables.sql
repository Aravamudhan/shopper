DROP TABLE IF EXISTS payment;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS order_item;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category;
DROP TYPE IF EXISTS order_status_enum;
DROP TYPE IF EXISTS address_type_enum;
DROP TYPE IF EXISTS payment_type_enum;
DROP EXTENSION IF EXISTS citext;

CREATE EXTENSION citext;

CREATE TYPE order_status_enum AS ENUM(
	'PENDING','ORDER_PLACED','SHIPPED','DELIVERED','CANCELED'
);

CREATE TYPE address_type_enum AS ENUM(
	'HOME','WORK','PUBLIC','OTHER'
);

CREATE TYPE payment_type_enum AS ENUM(
	'CREDIT_CARD','DEBIT_CARD','NET_BANKING','CASH_ON_DELIVERY'
);
CREATE TABLE category (
    id serial PRIMARY KEY,
    name character varying(50) NOT NULL,
    description character varying(100)
);

CREATE TABLE product (
    id bigserial PRIMARY KEY,
    name character varying(100) NOT NULL,
    category_id integer NOT NULL REFERENCES category(id),
    price numeric NOT NULL,
    discount numeric,
    image character varying(100),
    description character varying(3000),
    available_quantity integer NOT NULL,
    CONSTRAINT price_discount CHECK (price > discount),
    CONSTRAINT valid_price CHECK (price > 0),
    CONSTRAINT valid_quantity CHECK (available_quantity >= 0)
);

CREATE TABLE customer (
    id serial PRIMARY KEY,
    first_name character varying(100) NOT NULL,
    last_name character varying(100) NOT NULL,
    email citext NOT NULL,
    phone_number text NOT NULL
);

CREATE TABLE address (
    id serial PRIMARY KEY,
    building character varying(40) NOT NULL,
    street character varying(20) NOT NULL,
    town character varying(40),
    city character varying(40),
    state character varying(40) NOT NULL,
    country character varying(30) NOT NULL,
    zipcode character varying(16) NOT NULL,
    customer_id integer NOT NULL REFERENCES customer(id),
    address_type address_type_enum NOT NULL,
    CONSTRAINT valid_location CHECK ((town IS NOT NULL) OR (city IS NOT NULL))
);

CREATE TABLE orders (
    id bigserial PRIMARY KEY,
    order_number text NOT NULL UNIQUE,
    ordered_date timestamp with time zone NOT NULL,
    delivery_date timestamp with time zone,
    order_status order_status_enum NOT NULL,
    customer_id integer NOT NULL REFERENCES customer(id),
    comments character varying(200),
    total_price numeric NOT NULL,
    CONSTRAINT valid_total_price CHECK (total_price > 0)
);

CREATE TABLE order_item (
    id bigserial PRIMARY KEY,
    product_id bigint NOT NULL REFERENCES product(id),
    quantity integer NOT NULL,
    price numeric NOT NULL,
    order_id bigint NOT NULL REFERENCES orders(id),
    CONSTRAINT valid_order_quantity CHECK (quantity > 0),
    CONSTRAINT valid_price CHECK (price > 0)
);

CREATE TABLE payment (
    id bigserial NOT NULL,
    payment_type payment_type_enum NOT NULL,
    payment_amount numeric NOT NULL,
    order_id bigint NOT NULL REFERENCES orders(id)
);




