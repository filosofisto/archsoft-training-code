--
-- PostgreSQL database dump
--

-- Dumped from database version 10.12
-- Dumped by pg_dump version 12.4

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
-- Name: postgres; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';


ALTER DATABASE postgres OWNER TO postgres;

\connect postgres

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
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- Name: gen_permission; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.gen_permission
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.gen_permission OWNER TO postgres;

--
-- Name: gen_person; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.gen_person
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.gen_person OWNER TO postgres;

--
-- Name: gen_user; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.gen_user
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.gen_user OWNER TO postgres;

SET default_tablespace = '';

--
-- Name: tb01_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb01_user (
    user_id bigint NOT NULL,
    account_non_expired boolean NOT NULL,
    account_non_locked boolean NOT NULL,
    credentials_non_expired boolean NOT NULL,
    enabled boolean NOT NULL,
    password character varying(255) NOT NULL,
    user_name character varying(255) NOT NULL
);


ALTER TABLE public.tb01_user OWNER TO postgres;

--
-- Name: tb02_person; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb02_person (
    person_id bigint NOT NULL,
    person_age integer NOT NULL,
    person_name character varying(50) NOT NULL
);


ALTER TABLE public.tb02_person OWNER TO postgres;

--
-- Name: tb03_permission; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb03_permission (
    permission_id bigint NOT NULL,
    description character varying(50) NOT NULL
);


ALTER TABLE public.tb03_permission OWNER TO postgres;

--
-- Name: user_permission; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_permission (
    user_id bigint NOT NULL,
    permission_id bigint NOT NULL
);


ALTER TABLE public.user_permission OWNER TO postgres;

--
-- Data for Name: tb01_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb01_user VALUES (1, true, true, true, true, '$2a$10$0PnU8CBeLym0k7xd71zJ.OmM8A9ixm93HaIhCau1Vi0rXtH1Exbim', 'admin');


--
-- Data for Name: tb02_person; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb02_person VALUES (102, 50, 'Joao da Silva');
INSERT INTO public.tb02_person VALUES (852, 33, 'Francisco Vieira');
INSERT INTO public.tb02_person VALUES (853, 55, 'Luciano de Souza');
INSERT INTO public.tb02_person VALUES (854, 45, 'Amanda Silva');
INSERT INTO public.tb02_person VALUES (855, 76, 'Waldisney Clemente');
INSERT INTO public.tb02_person VALUES (856, 23, 'Jose Lima e Silva');
INSERT INTO public.tb02_person VALUES (857, 54, 'Edson de Souza');
INSERT INTO public.tb02_person VALUES (858, 22, 'EDUARDO RIBEIRO');
INSERT INTO public.tb02_person VALUES (859, 22, 'asdsdasd');
INSERT INTO public.tb02_person VALUES (860, 22, 'wqeqwe');
INSERT INTO public.tb02_person VALUES (861, 99, 'Eduardo');
INSERT INTO public.tb02_person VALUES (902, 33, 'Fulano de Tal');


--
-- Data for Name: tb03_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb03_permission VALUES (1, 'admin');


--
-- Data for Name: user_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_permission VALUES (1, 1);


--
-- Name: gen_permission; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.gen_permission', 51, true);


--
-- Name: gen_person; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.gen_person', 951, true);


--
-- Name: gen_user; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.gen_user', 51, true);


--
-- Name: tb01_user tb01_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb01_user
    ADD CONSTRAINT tb01_user_pkey PRIMARY KEY (user_id);


--
-- Name: tb02_person tb02_person_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb02_person
    ADD CONSTRAINT tb02_person_pkey PRIMARY KEY (person_id);


--
-- Name: tb03_permission tb03_permission_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb03_permission
    ADD CONSTRAINT tb03_permission_pkey PRIMARY KEY (permission_id);


--
-- Name: tb01_user uk_idf22mxl08kadctdyiwm5n6jl; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb01_user
    ADD CONSTRAINT uk_idf22mxl08kadctdyiwm5n6jl UNIQUE (user_name);


--
-- Name: user_permission user_permission_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_permission
    ADD CONSTRAINT user_permission_pkey PRIMARY KEY (user_id, permission_id);


--
-- Name: user_permission fk96f2mggp48rfj9lnx3eva0q63; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_permission
    ADD CONSTRAINT fk96f2mggp48rfj9lnx3eva0q63 FOREIGN KEY (user_id) REFERENCES public.tb01_user(user_id);


--
-- Name: user_permission fkf466v8t5bv06ljp9mtctag22; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_permission
    ADD CONSTRAINT fkf466v8t5bv06ljp9mtctag22 FOREIGN KEY (permission_id) REFERENCES public.tb03_permission(permission_id);


--
-- PostgreSQL database dump complete
--

