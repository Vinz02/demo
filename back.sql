--
-- PostgreSQL database cluster dump
--

-- Started on 2020-10-26 19:30:51

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'SCRAM-SHA-256$4096:lWa+BG+NdQ8/r1x99Fr6hQ==$Ev3Se2IUwbgr5p0vP1GVgtuuTWenipJBUiecmTFIonQ=:V8NnRU4nkJaeoXbiXffEfH5sFTUMtW5bBjYWctqxSCI=';






--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 13.0
-- Dumped by pg_dump version 13.0

-- Started on 2020-10-26 19:30:51

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Completed on 2020-10-26 19:30:52

--
-- PostgreSQL database dump complete
--

--
-- Database "postgres" dump
--

\connect postgres

--
-- PostgreSQL database dump
--

-- Dumped from database version 13.0
-- Dumped by pg_dump version 13.0

-- Started on 2020-10-26 19:30:52

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 3002 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 24641)
-- Name: booking; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.booking (
    bid character varying(10) NOT NULL,
    user_id bigint NOT NULL,
    tid character varying(10) NOT NULL
);


ALTER TABLE public.booking OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 24616)
-- Name: schedule; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.schedule (
    tid character varying(10) NOT NULL,
    price double precision NOT NULL,
    st_loc character varying(100) NOT NULL,
    en_loc character varying(100) NOT NULL,
    st_time timestamp without time zone NOT NULL,
    en_time timestamp without time zone NOT NULL
);


ALTER TABLE public.schedule OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 24581)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    user_id bigint NOT NULL,
    name character varying(100) NOT NULL,
    email character varying(100) NOT NULL,
    phone character varying(10) NOT NULL
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- TOC entry 2996 (class 0 OID 24641)
-- Dependencies: 203
-- Data for Name: booking; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2995 (class 0 OID 24616)
-- Dependencies: 202
-- Data for Name: schedule; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.schedule (tid, price, st_loc, en_loc, st_time, en_time) VALUES ('A123', 4000, 'BLR', 'DEL', '2020-10-26 09:00:00', '2020-10-26 12:00:00');
INSERT INTO public.schedule (tid, price, st_loc, en_loc, st_time, en_time) VALUES ('B236', 2000, 'MUM', 'BLR', '2020-10-26 08:00:00', '2020-10-26 09:00:00');
INSERT INTO public.schedule (tid, price, st_loc, en_loc, st_time, en_time) VALUES ('X23', 5000, 'MUM', 'DEL', '2020-10-26 07:00:00', '2020-10-26 09:00:00');
INSERT INTO public.schedule (tid, price, st_loc, en_loc, st_time, en_time) VALUES ('ZYJ', 2500, 'BLR', 'MUM', '2020-10-26 08:30:00', '2020-10-26 11:30:00');
INSERT INTO public.schedule (tid, price, st_loc, en_loc, st_time, en_time) VALUES ('B123', 4000, 'MUM', 'RAN', '2020-10-26 11:00:00', '2020-10-26 13:30:00');
INSERT INTO public.schedule (tid, price, st_loc, en_loc, st_time, en_time) VALUES ('XY3', 2000, 'RAN', 'PAT', '2020-10-26 14:00:00', '2020-10-26 15:00:00');
INSERT INTO public.schedule (tid, price, st_loc, en_loc, st_time, en_time) VALUES ('Z123', 3000, 'MUM', 'DEL', '2020-10-26 11:00:00', '2020-10-26 14:00:00');
INSERT INTO public.schedule (tid, price, st_loc, en_loc, st_time, en_time) VALUES ('C137', 2000, 'DEL', 'PAT', '2020-10-26 15:00:00', '2020-10-26 17:00:00');
INSERT INTO public.schedule (tid, price, st_loc, en_loc, st_time, en_time) VALUES ('A124', 4000, 'BLR', 'DEL', '2020-10-26 11:00:00', '2020-10-26 12:00:00');


--
-- TOC entry 2994 (class 0 OID 24581)
-- Dependencies: 201
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."user" (user_id, name, email, phone) VALUES (1, 'Vineet', 'test@test.com', '9999999999');


--
-- TOC entry 2862 (class 2606 OID 24645)
-- Name: booking booking_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.booking
    ADD CONSTRAINT booking_pkey PRIMARY KEY (bid);


--
-- TOC entry 2860 (class 2606 OID 24654)
-- Name: schedule schedule_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT schedule_pkey PRIMARY KEY (tid, st_time);


--
-- TOC entry 2858 (class 2606 OID 24585)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2863 (class 2606 OID 24646)
-- Name: booking user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.booking
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public."user"(user_id);


-- Completed on 2020-10-26 19:30:53

--
-- PostgreSQL database dump complete
--

-- Completed on 2020-10-26 19:30:53

--
-- PostgreSQL database cluster dump complete
--

