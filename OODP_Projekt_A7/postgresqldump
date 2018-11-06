--
-- PostgreSQL database dump
--

-- Dumped from database version 11.0
-- Dumped by pg_dump version 11.0

-- Started on 2018-11-06 23:05:59

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2930 (class 0 OID 16748)
-- Dependencies: 197
-- Data for Name: courses; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.courses (courseid, coursecode, name, description, finalgrade, coursescheduleurl, courseplanurl, startdate) FROM stdin;
11	TST228	Test 228			www.hig.se	http://www.hig.se	2018-10-22
4	DVG320	Programvaruteknik - utveckling och underhåll av programvara			http://schema.hig.se/setup/jsp/Schema.jsp?startDatum=idag&intervallTyp=m&intervallAntal=6&sokMedAND=true&sprak=SV&resurser=k.DVG320.28414.19-%2C	http://utb.hig.se/fafne/app/public/pdf/jasper/course.pdf?identifier=DVG320	2018-08-17
3	DVG328	Databasteknik			http://schema.hig.se/setup/jsp/Schema.jsp?startDatum=idag&intervallTyp=m&intervallAntal=6&sokMedAND=true&sprak=SV&resurser=k.DVG328.18425.18-%2C	http://schema.hig.se/setup/jsp/Schema.jsp?startDatum=idag&intervallTyp=m&intervallAntal=6&sokMedAND=true&sprak=SV&resurser=k.DVG326.18426.18-%2Ck.DVG328.18425.18-%2C	2018-08-20
2	DVG326	Objektorienterad design och programmering			http://schema.hig.se/setup/jsp/Schema.jsp?startDatum=idag&intervallTyp=m&intervallAntal=6&sokMedAND=true&sprak=SV&resurser=k.DVG326.18426.18-%2C	http://utb.hig.se/fafne/app/public/pdf/jasper/course.pdf?identifier=DVG326	2018-09-20
1	ST006A	Dataanalys och statistik för ekonomer			http://schema.hig.se/setup/jsp/Schema.jsp?startDatum=idag&intervallTyp=m&intervallAntal=6&sprak=SV&sokMedAND=true&forklaringar=true&resurser=k.ST006A.18204.18-	http://utb.hig.se/fafne/app/public/pdf/jasper/course.pdf?identifier=ST006A	2018-09-22
\.


--
-- TOC entry 2950 (class 0 OID 16896)
-- Dependencies: 217
-- Data for Name: coursestudents; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.coursestudents (coursestudentid, studentid, courseid) FROM stdin;
\.


--
-- TOC entry 2946 (class 0 OID 16860)
-- Dependencies: 213
-- Data for Name: courseteachers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.courseteachers (courseteacherid, courseid, teacherid) FROM stdin;
6	2	1
19	4	1
20	3	2
21	3	3
23	1	1
24	1	4
38	4	9
39	11	1
40	11	9
41	11	2
\.


--
-- TOC entry 2938 (class 0 OID 16797)
-- Dependencies: 205
-- Data for Name: groups; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.groups (groupid, name, description, momentid) FROM stdin;
3	PM-grupp	Grupp för att samskriva ett PM i datorsystem	21
4	Rapportskrivning	Grupp för att skriva rapport i OODP	21
1	Labbgrupp	Grupp för laborationer i OODP	21
2	Projektgrupp	Grupp för projekt i Databasteknik	21
\.


--
-- TOC entry 2944 (class 0 OID 16842)
-- Dependencies: 211
-- Data for Name: momentgroups; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.momentgroups (momentgroupid, momentid, groupid) FROM stdin;
\.


--
-- TOC entry 2940 (class 0 OID 16808)
-- Dependencies: 207
-- Data for Name: moments; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.moments (momentid, momentcode, type, description, grade, date, credit, place, courseid) FROM stdin;
9	0010	Tenta	\N		\N	5.00		2
10	0020	Laborationer	\N		\N	2.00		2
11	0030	PM	\N		\N	0.50		2
19	0010	Tenta	\N		\N	5.00		11
20	0020	Laborationer			\N	1.50		11
21	0030	PM	\N		\N	1.00		11
22	0010	Tentamen	\N		\N	4.00		3
23	0020	PM	\N		\N	1.00		3
24	0030	Laborationer	\N		\N	2.50		3
\.


--
-- TOC entry 2952 (class 0 OID 16914)
-- Dependencies: 219
-- Data for Name: programcourses; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.programcourses (programcourseid, courseid, programid) FROM stdin;
1	2	1
2	2	2
3	2	3
4	1	4
5	3	4
6	1	4
7	2	4
10	4	3
11	1	1
12	2	6
13	4	6
14	1	2
\.


--
-- TOC entry 2932 (class 0 OID 16759)
-- Dependencies: 199
-- Data for Name: programs; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.programs (programid, programcode, name, description) FROM stdin;
2	HIG-19200	Automationsingenjör (Co-op)	Automatiseringar finns överallt i vår omgivning - från smarta styrsystem för vår inomhusmiljö till industriella produktionsprocesser. Automation gör vår vardag enklare genom att samordna olika tekniska system som elektronik, IT, människa/maskin samt ekonomi och miljö.
4	HIG-29815	Ekonomprogrammet	Att skaffa dig en ekonomutbildning är förmodligen en av de bästa investeringar för framtiden du kan göra.
3	HIG-19108	Maskiningenjör (Co-op) 180 hp	Hur tillverkas en produkt? När du läser till maskiningenjör får du gedigen kunskap om hur en produkt blir till - från grundidé och vidare genom hela tillverkningsprocessen. Du får lära dig att utveckla, konstruera och producera produkter med hjälp av CAD, CAM och FEM-program. Dessutom får du goda beräkningskunskaper och värdefull inblick i logistik- och kvalitetsfrågor.
1	HIG-19104	Dataingenjörsprogrammet	Vårt samhälle och vardag fungerar allt oftare genom olika system och IT-lösningar. Som dataingenjör möter du därför fler utmaningar än ren programmering och ofta handlar det om att hitta lösningar där någon annan kanske upplever ett problem. Här skriver du koden framtiden behöver!
6	TLT-12345	Tiltamejprogrammet	skitprogram
\.


--
-- TOC entry 2948 (class 0 OID 16878)
-- Dependencies: 215
-- Data for Name: programteachers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.programteachers (programteacherid, teacherid, programid) FROM stdin;
\.


--
-- TOC entry 2942 (class 0 OID 16824)
-- Dependencies: 209
-- Data for Name: studentgroups; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.studentgroups (studentgroupid, groupid, studentid) FROM stdin;
1	2	4
6	2	2
10	1	4
11	1	3
12	2	3
\.


--
-- TOC entry 2936 (class 0 OID 16781)
-- Dependencies: 203
-- Data for Name: students; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.students (studentid, name, email, phonenr, city, address, programid) FROM stdin;
4	Fabian	fabian.palmberg@gmail	0734177072	Älvkarleby	Västanåvägen 20	2
2	Felix	felix.palmberg@gmail.com	07033333333	Gävle	södrakungsgatan 56B	1
5	Alfred	Alfred.nilsson@hotmail.se	0764789022	test	test1121	3
3	Marcus Vretling Pistelli	marcus@gmail.com	07072957265	Storvik	Vattencirkeln 4	1
\.


--
-- TOC entry 2934 (class 0 OID 16770)
-- Dependencies: 201
-- Data for Name: teachers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.teachers (teacherid, name, email, phonenr, office) FROM stdin;
1	Åke	ake@hig.se	\N	99530
2	Carina	carina@hig.se	\N	99532
3	Ann-sofie	annsofie@hig.se	\N	99531
9	Marcus	marcus@test.com	0543593459	94234
4	Anders	anders@hig.se	243345	99540
\.


--
-- TOC entry 2970 (class 0 OID 0)
-- Dependencies: 196
-- Name: courses_courseid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.courses_courseid_seq', 11, true);


--
-- TOC entry 2971 (class 0 OID 0)
-- Dependencies: 216
-- Name: coursestudents_coursestudentid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.coursestudents_coursestudentid_seq', 1, false);


--
-- TOC entry 2972 (class 0 OID 0)
-- Dependencies: 212
-- Name: courseteachers_courseteacherid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.courseteachers_courseteacherid_seq', 43, true);


--
-- TOC entry 2973 (class 0 OID 0)
-- Dependencies: 204
-- Name: groups_groupid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.groups_groupid_seq', 9, true);


--
-- TOC entry 2974 (class 0 OID 0)
-- Dependencies: 210
-- Name: momentgroups_momentgroupid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.momentgroups_momentgroupid_seq', 1, false);


--
-- TOC entry 2975 (class 0 OID 0)
-- Dependencies: 206
-- Name: moments_momentid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.moments_momentid_seq', 24, true);


--
-- TOC entry 2976 (class 0 OID 0)
-- Dependencies: 218
-- Name: programcourses_programcourseid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.programcourses_programcourseid_seq', 16, true);


--
-- TOC entry 2977 (class 0 OID 0)
-- Dependencies: 198
-- Name: programs_programid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.programs_programid_seq', 6, true);


--
-- TOC entry 2978 (class 0 OID 0)
-- Dependencies: 214
-- Name: programteachers_programteacherid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.programteachers_programteacherid_seq', 1, false);


--
-- TOC entry 2979 (class 0 OID 0)
-- Dependencies: 208
-- Name: studentgroups_studentgroupid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.studentgroups_studentgroupid_seq', 12, true);


--
-- TOC entry 2980 (class 0 OID 0)
-- Dependencies: 202
-- Name: students_studentid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.students_studentid_seq', 15, true);


--
-- TOC entry 2981 (class 0 OID 0)
-- Dependencies: 200
-- Name: teachers_teacherid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.teachers_teacherid_seq', 13, true);


-- Completed on 2018-11-06 23:05:59

--
-- PostgreSQL database dump complete
--

