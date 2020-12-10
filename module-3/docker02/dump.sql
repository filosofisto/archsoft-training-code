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
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.person (person_id, person_age, person_name) FROM stdin;
752	34	Joao da Silva
425	24	Hiago Bronnemann Pauli
422	50	Eduardo Ribeiro da Silva
424	40	Djovana Sarita Bronnemann da Silva
652	88	EDUARDO RIBEIRO
653	88	EDUARDO RIBEIRO
654	88	Eduardo
\.


--
-- Data for Name: tb01_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tb01_user (user_id, account_non_expired, account_non_locked, credentials_non_expired, enabled, password, user_name) FROM stdin;
1	t	t	t	t	$2a$10$0PnU8CBeLym0k7xd71zJ.OmM8A9ixm93HaIhCau1Vi0rXtH1Exbim	admin
\.


--
-- Data for Name: tb02_person; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tb02_person (person_id, person_age, person_name) FROM stdin;
102	50	Joao da Silva
852	33	Francisco Vieira
853	55	Luciano de Souza
854	45	Amanda Silva
855	76	Waldisney Clemente
856	23	Jose Lima e Silva
857	54	Edson de Souza
858	22	EDUARDO RIBEIRO
859	22	asdsdasd
860	22	wqeqwe
861	99	Eduardo
902	33	Fulano de Tal
\.


--
-- Data for Name: tb03_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tb03_permission (permission_id, description) FROM stdin;
1	admin
\.


--
-- Data for Name: user_permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_permission (user_id, permission_id) FROM stdin;
1	1
\.


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
-- PostgreSQL database dump complete
--

