--
-- PostgreSQL database dump
--

\restrict badmLHvor3b1xcSwQwaCMMbtXVhfm6HCPPDkrecAGb6Q1koVec5bBNr6nddNMTt

-- Dumped from database version 17.9 (Debian 17.9-1.pgdg13+1)
-- Dumped by pg_dump version 17.9 (Debian 17.9-1.pgdg13+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: alimentos; Type: TABLE; Schema: public; Owner: myuser
--

CREATE TABLE public.alimentos (
    id integer NOT NULL,
    carbohydrates double precision,
    dietary_fiber double precision,
    kcal double precision,
    lipids double precision,
    name character varying(255),
    protein double precision
);


ALTER TABLE public.alimentos OWNER TO myuser;

--
-- Data for Name: alimentos; Type: TABLE DATA; Schema: public; Owner: myuser
--

COPY public.alimentos (id, carbohydrates, dietary_fiber, kcal, lipids, name, protein) FROM stdin;
1	25.8	2.7	124	1	Arroz, integral, cozido	2.6
2	77.5	4.8	360	1.9	Arroz, integral, cru	7.3
3	28.1	1.6	128	0.2	Arroz, tipo 1, cozido	2.5
4	78.8	1.6	358	0.3	Arroz, tipo 1, cru	7.2
5	28.2	1.1	130	0.4	Arroz, tipo 2, cozido	2.6
6	78.9	1.7	358	0.3	Arroz, tipo 2, cru	7.2
7	66.6	9.1	394	8.5	Aveia, flocos, crua	13.9
8	75.2	2.1	443	12	Biscoito, doce, maisena	8.1
9	70.5	3	472	19.6	Biscoito, doce, recheado com chocolate	6.4
10	71	1.5	471	19.6	Biscoito, doce, recheado com morango	5.7
11	67.5	1.8	502	24.7	Biscoito, doce, wafer, recheado de chocolate	5.6
12	67.4	0.8	513	26.4	Biscoito, doce, wafer, recheado de morango	4.5
13	68.7	2.5	432	14.4	Biscoito, salgado, cream cracker	10.1
14	84.7	1.7	419	6.1	Bolo, mistura para	6.2
15	47.9	0.7	324	12.7	Bolo, pronto, aipim	4.4
16	54.7	1.4	410	18.5	Bolo, pronto, chocolate	6.2
17	52.3	1.1	333	11.3	Bolo, pronto, coco	5.7
18	45.1	0.7	311	12.4	Bolo, pronto, milho	4.8
19	78.1	5.5	358	1	Canjica, branca, crua	7.2
20	23.6	1.2	112	1.2	Canjica, com leite integral	2.4
21	80.8	5.3	370	1.6	Cereais, milho, flocos, com sal	7.3
22	80.4	1.8	363	1.2	Cereais, milho, flocos, sem sal	6.9
23	87.3	3.2	394	1.1	Cereais, mingau, milho, infantil	6.4
24	81.6	5	381	2.1	Cereais, mistura para vitamina, trigo, cevada e aveia	8.9
25	83.8	4.1	365	1	Cereal matinal, milho	7.2
26	88.8	2.1	377	0.7	Cereal matinal, milho, açúcar	4.7
27	83.9	1.1	386	1.2	Creme de arroz, pó	7
28	86.1	3.7	333	1.6	Creme de milho, pó	4.8
29	13.9	0.5	78	1.6	Curau, milho verde	2.4
30	79.8	2.5	402	13.4	Curau, milho verde, mistura para	2.2
31	85.5	0.6	363	0.3	Farinha, de arroz, enriquecida	1.3
32	73.3	15.5	336	1.8	Farinha, de centeio, integral	12.5
33	79.1	5.5	351	1.5	Farinha, de milho, amarela	7.2
34	75.8	4.8	371	1.5	Farinha, de rosca	11.4
35	75.1	2.3	360	1.4	Farinha, de trigo	9.8
36	77.8	1.9	415	5.8	Farinha, láctea, de cereais	11.9
37	32.5	1.6	164	1.2	Lasanha, massa fresca, cozida	5.8
38	45.1	1.6	220	1.3	Lasanha, massa fresca, crua	7
39	62.4	5.6	436	17.2	Macarrão, instantâneo	8.8
40	77.9	2.9	371	1.3	Macarrão, trigo, cru	10
41	76.6	2.3	371	2	Macarrão, trigo, cru, com ovos	10.3
42	87.1	0.7	361	0	Milho, amido, cru	0.6
43	78.9	4.7	353	1.9	Milho, fubá, cru	7.2
44	28.6	3.9	138	0.6	Milho, verde, cru	6.6
45	17.1	4.6	98	2.4	Milho, verde, enlatado, drenado	3.2
46	89.3	0.9	373	0.4	Mingau tradicional, pó	0.6
47	30.7	2.4	171	4.8	Pamonha, barra para cozimento, pré-cozida	2.6
48	59.6	6	343	5.7	Pão, aveia, forma	12.4
49	56.5	5.7	309	3.6	Pão, de soja	11.3
50	44.1	2.5	253	2.7	Pão, glúten, forma	12
51	56.4	4.3	292	3.1	Pão, milho, forma	8.3
52	49.9	6.9	253	3.7	Pão, trigo, forma, integral	9.4
53	58.6	2.3	300	3.1	Pão, trigo, francês	8
54	61.5	2.4	311	2.8	Pão, trigo, sovado	8.4
55	42	1	289	8.8	Pastel, de carne, cru	10.7
56	43.8	1	388	20.1	Pastel, de carne, frito	10.1
57	45.9	1.1	308	9.6	Pastel, de queijo, cru	9.9
58	48.1	0.9	422	22.7	Pastel, de queijo, frito	8.7
59	57.4	1.4	310	5.5	Pastel, massa, crua	6.9
60	49.3	1.3	570	40.9	Pastel, massa, frita	6
61	70.3	14.3	448	15.9	Pipoca, com óleo de soja, sem sal	9.9
62	23.3	2.4	103	0.3	Polenta, pré-cozida	2.3
63	74.6	3.4	377	3.3	Torrada, pão francês	10.5
64	10.8	2.5	48	0.7	Abóbora, cabotian, cozida	1.4
65	8.4	2.2	39	0.5	Abóbora, cabotian, crua	1.7
66	3.3	1.2	14	0	Abóbora, menina brasileira, crua	0.6
67	2.7	1.7	12	0.1	Abóbora, moranga, crua	1
68	6	1.5	29	0.8	Abóbora, moranga, refogada	0.4
69	6.1	2.3	24	0.1	Abóbora, pescoço, crua	0.7
70	3	1.6	15	0.2	Abobrinha, italiana, cozida	1.1
71	4.3	1.4	19	0.1	Abobrinha, italiana, crua	1.1
72	4.2	1.4	24	0.8	Abobrinha, italiana, refogada	1.1
73	7.9	2.6	31	0.1	Abobrinha, paulista, crua	0.6
74	4.6	1.1	21	0.1	Acelga, crua	1.4
75	2.3	2.1	17	0.2	Agrião, cru	2.7
76	4.3	1	19	0.1	Aipo, cru	0.8
77	1.7	1	9	0.1	Alface, americana, crua	0.6
78	1.7	1.8	11	0.2	Alface, crespa, crua	1.3
79	2.4	2.3	14	0.1	Alface, lisa, crua	1.7
80	2.5	2	13	0.2	Alface, roxa, crua	0.9
81	5.2	4.1	29	0.5	Alfavaca, crua	2.7
82	23.9	4.3	113	0.2	Alho, cru	7
83	6.9	2.5	32	0.1	Alho-poró, cru	1.4
84	3.3	2.6	18	0.2	Almeirão, cru	1.8
85	5.7	3.4	65	4.8	Almeirão, refogado	1.7
86	18.9	1.8	80	0.2	Batata, baroa, cozida	0.9
87	24	2.1	101	0.2	Batata, baroa, crua	1
88	18.4	2.2	77	0.1	Batata, doce, cozida	0.6
89	28.2	2.6	118	0.1	Batata, doce, crua	1.3
90	51.2	2.5	543	36.6	Batata, frita, tipo chips, industrializada	5.6
91	11.9	1.3	52	0	Batata, inglesa, cozida	1.2
92	14.7	1.2	64	0	Batata, inglesa, crua	1.8
93	35.6	8.1	267	13.1	Batata, inglesa, frita	5
94	14.1	1.4	68	0.9	Batata, inglesa, sauté	1.3
95	4.5	2.5	19	0.1	Berinjela, cozida	0.7
96	4.4	2.9	20	0.1	Berinjela, crua	1.2
97	7.2	1.9	32	0.1	Beterraba, cozida	1.3
98	11.1	3.4	49	0.1	Beterraba, crua	1.9
99	80.5	1.2	438	12.2	Biscoito, polvilho doce	1.3
100	4.4	3.4	25	0.5	Brócolis, cozido	2.1
101	4	2.9	25	0.3	Brócolis, cru	3.6
102	18.9	2.6	78	0.1	Cará, cozido	1.5
103	23	7.3	96	0.1	Cará, cru	2.3
104	6	4.5	34	0.6	Caruru, cru	3.2
105	4.8	2	24	0.3	Catalonha, crua	1.9
106	4.8	3.7	63	4.8	Catalonha, refogada	2
107	8.9	2.2	39	0.1	Cebola, crua	1.7
108	3.4	3.6	20	0.4	Cebolinha, crua	1.9
109	6.7	2.6	30	0.2	Cenoura, cozida	0.8
110	7.7	3.2	34	0.2	Cenoura, crua	1.3
111	2.9	2.2	14	0.1	Chicória, crua	1.1
112	4.8	1	19	0	Chuchu, cozido	0.4
113	4.1	1.3	17	0.1	Chuchu, cru	0.7
114	48	37.3	309	10.4	Coentro, folhas desidratadas	20.9
115	4.3	3.1	27	0.5	Couve, manteiga, crua	2.9
116	8.7	5.7	90	6.6	Couve, manteiga, refogada	1.7
117	4.5	2.4	23	0.2	Couve-flor, crua	1.9
118	3.9	2.1	19	0.3	Couve-flor, cozida	1.2
119	2.6	2.1	16	0.2	Espinafre, Nova Zelândia, cru	2
120	4.2	2.5	67	5.4	Espinafre, Nova Zelândia, refogado	2.7
121	87.9	6.4	361	0.3	Farinha, de mandioca, crua	1.6
122	89.2	6.5	365	0.3	Farinha, de mandioca, torrada	1.2
123	87.3	4.2	360	0.5	Farinha, de puba	1.6
124	81.1	0.6	331	0.3	Fécula, de mandioca	0.5
125	7.8	2	39	0.1	Feijão, broto, cru	4.2
126	23.2	1.7	97	0.2	Inhame, cru	2.1
127	6.2	4.8	27	0.2	Jiló, cru	1.4
128	23.1	23.9	126	3.9	Jurubeba, crua	4.4
129	30.1	1.6	125	0.3	Mandioca, cozida	0.6
130	36.2	1.9	151	0.3	Mandioca, crua	1.1
131	80.3	7.8	406	9.1	Mandioca, farofa, temperada	2.1
132	50.3	1.9	300	11.2	Mandioca, frita	1.4
133	3.6	3.3	21	0.4	Manjericão, cru	2
134	2.7	2.2	14	0.1	Maxixe, cru	1.4
135	3.2	1.9	18	0.2	Mostarda, folha, crua	2.1
136	36.8	1.8	181	1.9	Nhoque, batata, cozido	5.9
137	4.1	2.6	18	0.1	Nabo, cru	1.2
138	4.3	3.2	23	0.4	Palmito, juçara, em conserva	1.8
139	5.5	2.6	29	0.5	Palmito, pupunha, em conserva	2.5
140	34.2	0.6	363	24.6	Pão, de queijo, assado	5.1
141	38.5	1	295	14	Pão, de queijo, cru	3.6
142	2	1.1	10	0	Pepino, cru	0.9
143	6	1.9	28	0.4	Pimentão, amarelo, cru	1.2
144	4.9	2.6	21	0.2	Pimentão, verde, cru	1.1
145	5.5	1.6	23	0.1	Pimentão, vermelho, cru	1
146	86.8	0.2	351	0	Polvilho, doce	0.4
147	6.4	4.6	30	0.3	Quiabo, cru	1.9
148	2.7	2.2	14	0.1	Rabanete, cru	1.4
149	3.9	1.9	17	0.1	Repolho, branco, cru	0.9
150	7.2	2	31	0.1	Repolho, roxo, cru	1.9
151	7.6	1.8	42	1.2	Repolho, roxo, refogado	1.8
152	2.2	1.7	13	0.1	Rúcula, crua	1.8
153	5.7	1.9	33	0.6	Salsa, crua	3.3
154	12.7	3.1	57	0.4	Seleta de legumes, enlatada	3.4
155	4.9	3.5	30	0.7	Serralha, crua	2.7
156	5.4	4.5	34	0.9	Taioba, crua	2.9
157	3.1	1.2	15	0.2	Tomate, com semente, cru	1.1
158	15	2.8	61	0.2	Tomate, extrato	2.4
159	7.7	3.1	38	0.9	Tomate, molho industrializado	1.4
160	6.9	1	28	0	Tomate, purê	1.4
161	5.1	2.3	21	0	Tomate, salada	0.8
162	5.3	2.4	25	0.2	Vagem, crua	1.8
163	6	6.3	96	8.4	Abacate, cru	1.2
164	12.3	1	48	0.1	Abacaxi, cru	0.9
165	7.8	0.3	31	0.1	Abacaxi, polpa, congelada	0.5
166	14.9	1.7	62	0.7	Abiu, cru	0.8
167	21.5	1.7	110	3.7	Açaí, polpa, com xarope de guaraná e glucose	0.7
168	6.2	2.6	58	3.9	Açaí, polpa, congelada	0.8
169	8	1.5	33	0.2	Acerola, crua	0.9
170	5.5	0.7	22	0	Acerola, polpa, congelada	0.6
171	46.9	0.5	183	0	Ameixa, calda, enlatada	0.4
172	13.9	2.4	53	0	Ameixa, crua	0.8
173	47.7	4.5	177	0.3	Ameixa, em calda, enlatada, drenada	1
174	25.3	2.1	97	0.3	Atemóia, crua	1
175	33.7	1.5	128	0.2	Banana, da terra, crua	1.4
176	75.7	3.8	280	0.1	Banana, doce em barra	2.2
177	27.8	2.8	105	0.1	Banana, figo, crua	1.1
178	22.3	2.6	87	0.1	Banana, maçã, crua	1.8
179	23.8	1.9	92	0.1	Banana, nanica, crua	1.4
180	29.3	2	112	0.2	Banana, ouro, crua	1.5
181	20.3	2	78	0.1	Banana, pacova, crua	1.2
182	26	2	98	0.1	Banana, prata, crua	1.3
183	19.4	2.2	74	0.1	Cacau, cru	1
184	11.4	2.6	46	0	Cajá-Manga, cru	1.3
185	6.4	1.4	26	0.2	Cajá, polpa, congelada	0.6
186	10.3	1.7	43	0.3	Caju, cru	1
187	9.4	0.8	37	0.2	Caju, polpa, congelada	0.5
188	10.7	0.6	45	0.2	Caju, suco concentrado, envasado	0.4
189	19.3	6.5	71	0.1	Caqui, chocolate, cru	0.4
190	11.5	2	46	0.2	Carambola, crua	0.9
191	18.9	3.9	76	0.4	Ciriguela, crua	1.4
192	10.4	3.1	49	1	Cupuaçu, cru	1.2
193	11.4	1.6	49	0.6	Cupuaçu, polpa, congelada	0.8
194	10.2	1.8	41	0.2	Figo, cru	1
195	50.3	2	184	0.2	Figo, enlatado, em calda	0.6
196	17.2	5.5	67	0.2	Fruta-pão, crua	1.1
197	12.4	6.3	52	0.5	Goiaba, branca, com casca, crua	0.9
198	74.1	3.7	269	0	Goiaba, doce em pasta	0.6
199	78.7	4.4	286	0.1	Goiaba, doce, cascão	0.4
200	13	6.2	54	0.4	Goiaba, vermelha, com casca, crua	1.1
201	15.8	1.9	62	0.2	Graviola, crua	0.8
202	9.8	1.2	38	0.1	Graviola, polpa, congelada	0.6
203	15.3	2.3	58	0.1	Jabuticaba, crua	0.6
204	22.5	2.4	88	0.3	Jaca, crua	1.4
205	6.5	5.1	27	0.1	Jambo, cru	0.9
206	10.6	1.8	41	0.1	Jamelão, cru	0.5
207	11.5	2.7	51	0.6	Kiwi, cru	1.3
208	11.5	1.1	45	0.1	Laranja, baía, crua	1
209	8.7	0	37	0	Laranja, baía, suco	0.7
210	12.9	4	51	0.2	Laranja, da terra, crua	1.1
211	9.6	1	41	0.1	Laranja, da terra, suco	0.7
212	11.5	1.8	46	0.1	Laranja, lima, crua	1.1
213	9.2	0.4	39	0.1	Laranja, lima, suco	0.7
214	8.9	0.8	37	0.1	Laranja, pêra, crua	1
215	7.6	0	33	0.1	Laranja, pêra, suco	0.7
216	11.7	1.7	46	0.2	Laranja, valência, crua	0.8
217	8.6	0.4	36	0.1	Laranja, valência, suco	0.5
218	5.2	0	14	0	Limão, cravo, suco	0.3
219	7.3	0	22	0.1	Limão, galego, suco	0.6
220	11.1	1.2	32	0.1	Limão, tahiti, cru	0.9
221	16.6	2	63	0.2	Maçã, Argentina, com casca, crua	0.2
222	15.2	1.3	56	0	Maçã, Fuji, com casca, crua	0.3
223	13.9	13.4	404	40.7	Macaúba, crua	2.1
224	54	1.3	196	0.1	 Mamão, doce em calda, drenado	0.2
225	11.6	1.8	45	0.1	Mamão, Formosa, cru	0.8
226	10.4	1	40	0.1	Mamão, Papaia, cru	0.5
227	57.6	1.2	209	0.1	 Mamão verde, doce em calda, drenado	0.3
228	16.7	1.6	64	0.3	Manga, Haden, crua	0.4
229	19.4	1.6	72	0.2	Manga, Palmer, crua	0.4
230	12.5	1.1	48	0.2	Manga, polpa, congelada	0.4
231	12.8	2.1	51	0.2	Manga, Tommy Atkins, crua	0.9
232	12.3	1.1	68	2.1	Maracujá, cru	2
233	9.6	0.5	39	0.2	Maracujá, polpa, congelada	0.8
234	9.6	0.4	42	0.2	Maracujá, suco concentrado, envasado	0.8
235	8.1	0.1	33	0	Melancia, crua	0.9
236	7.5	0.3	29	0	Melão, cru	0.7
237	14.9	3.1	58	0.1	Mexerica, Murcote, crua	0.9
238	9.3	2.7	37	0.1	Mexerica, Rio, crua	0.7
239	6.8	1.7	30	0.3	Morango, cru	0.9
240	11.5	3	43	0	Nêspera, crua	0.3
241	13	19	205	18	Pequi, cru	2.3
242	16.1	3	61	0.2	Pêra, Park, crua	0.2
243	14	3	53	0.1	Pêra, Williams, crua	0.6
244	9.3	1.4	36	0	Pêssego, Aurora, cru	0.8
245	16.9	1	63	0	Pêssego, enlatado, em calda	0.7
246	22.4	3.4	88	0.3	Pinha, crua	1.5
247	10.2	3.2	41	0.2	Pitanga, crua	0.9
248	4.8	0.7	19	0.1	Pitanga, polpa, congelada	0.3
249	15.1	0.4	56	0	Romã, crua	0.4
250	72.5	6.4	276	0.5	Tamarindo, cru	3.2
251	9.6	0.9	38	0.1	Tangerina, Poncã, crua	0.8
252	8.8	0	36	0	Tangerina, Poncã, suco	0.5
253	26.5	12.7	262	19.1	Tucumã, cru	2.1
254	9.4	2	37	0	Umbu, cru	0.8
255	8.8	1.3	34	0.1	Umbu, polpa, congelada	0.5
256	13.6	0.9	53	0.2	Uva, Itália, crua	0.7
257	12.7	0.9	49	0.2	Uva, Rubi, crua	0.6
258	14.7	0.2	58	0	Uva, suco concentrado, envasado	0
259	\N	\N	884	100	Azeite, de dendê	\N
260	\N	\N	884	100	Azeite, de oliva, extra virgem	\N
261	0.1	\N	726	82.4	Manteiga, com sal	0.4
262	0	\N	758	86	Manteiga, sem sal	0.4
263	0	\N	596	67.4	Margarina, com óleo hidrogenado, com sal (65% de lipídeos)	0
264	0	\N	723	81.7	Margarina, com óleo hidrogenado, sem sal (80% de lipídeos)	0
265	0	\N	594	67.2	Margarina, com óleo interesterificado, com sal (65%de lipídeos)	0
266	0	\N	593	67.1	Margarina, com óleo interesterificado, sem sal (65% de lipídeos)	0
267	\N	\N	884	100	Óleo, de babaçu	\N
268	\N	\N	884	100	Óleo, de canola	\N
269	\N	\N	884	100	Óleo, de girassol	\N
270	\N	\N	884	100	Óleo, de milho	\N
271	\N	\N	884	100	Óleo, de pequi	\N
272	\N	\N	884	100	Óleo, de soja	\N
273	0	\N	112	1.2	Abadejo, filé, congelado, assado	23.5
274	0	\N	91	0.9	Abadejo, filé, congelado,cozido	19.3
275	0	\N	59	0.4	Abadejo, filé, congelado, cru	13.1
276	0	\N	130	1.3	Abadejo, filé, congelado, grelhado	27.6
277	0	\N	166	6	Atum, conserva em óleo	26.2
278	0	\N	118	0.9	Atum, fresco, cru	25.7
279	0	\N	136	1.3	Bacalhau, salgado, cru	29
280	1.2	\N	140	3.6	Bacalhau, salgado, refogado	24
281	3.1	0.5	208	10	Cação, posta, com farinha de trigo, frita	25
282	0	\N	116	0.7	Cação, posta, cozida	25.6
283	0	\N	83	0.8	Cação, posta, crua	17.9
284	0	\N	90	1	Camarão, Rio Grande, grande, cozido	19
285	0	\N	47	0.5	Camarão, Rio Grande, grande, cru	10
286	2.9	\N	231	15.6	Camarão, Sete Barbas, sem cabeça, com casca, frito	18.4
287	0	\N	83	0.4	Caranguejo, cozido	18.5
288	0	\N	128	6	Corimba, cru	17.4
289	0	\N	261	19.6	Corimbatá, assado	19.9
290	0	\N	239	16.9	Corimbatá, cozido	20.1
291	0	\N	101	2.2	Corvina de água doce, crua	18.9
292	0	\N	94	1.6	Corvina do mar, crua	18.6
293	0	\N	147	3.6	Corvina grande, assada	26.8
294	0	\N	100	2.6	Corvina grande, cozida	23.4
295	0	\N	131	5.6	Dourada de água doce, fresca	18.8
296	0	\N	131	6.5	Lambari, congelado, cru	16.8
297	0	\N	327	22.8	Lambari, congelado, frito	28.4
298	0	\N	152	9.4	Lambari, fresco, cru	15.7
299	10.2	0.4	344	22.6	Manjuba, com farinha de trigo, frita	23.5
300	0	\N	349	24.5	Manjuba, frita	30.1
301	0	\N	122	0.9	Merluza, filé, assado	26.6
302	0	\N	89	2	Merluza, filé, cru	16.6
303	0	\N	192	8.5	Merluza, filé, frito	26.9
304	0	\N	111	4.6	Pescada, branca, crua	16.3
305	0	\N	223	11.8	Pescada, branca, frita	27.4
306	5	0	283	19.1	Pescada, filé, com farinha de trigo, frito	21.4
307	0	\N	107	4	Pescada, filé, cru	16.7
308	0	\N	154	3.6	Pescada, filé, frito	28.6
309	5	0.8	142	8	Pescada, filé, molho escabeche	11.8
310	0	\N	76	1.1	Pescadinha, crua	15.5
311	0	\N	192	4	Pintado, assado	36.5
312	0	\N	91	1.3	Pintado, cru	18.6
313	0	\N	152	2.3	Pintado, grelhado	30.8
314	0	\N	93	0.6	Porquinho, cru	20.5
315	0	\N	229	14	Salmão, filé, com pele, fresco,  grelhado	23.9
316	0	\N	170	9.7	Salmão, sem pele, fresco, cru	19.3
317	0	\N	243	14.5	Salmão, sem pele, fresco, grelhado	26.1
318	0	\N	164	3	Sardinha, assada	32.2
319	0	\N	285	24	Sardinha, conserva em óleo	15.9
320	0	\N	257	12.7	Sardinha, frita	33.4
321	0	\N	114	2.7	Sardinha, inteira, crua	21.1
322	0	\N	88	1.2	Tucunaré, filé, congelado, cru	18
323	2.9	\N	129	6.7	Apresuntado	13.5
324	15.1	0.6	241	16.6	Caldo de carne, tablete	7.8
325	10.6	11.8	251	20.4	Caldo de galinha, tablete	6.3
326	0	\N	212	10.9	Carne, bovina, acém, moído, cozido	26.7
327	0	\N	137	5.9	Carne, bovina, acém, moído, cru	19.4
328	0	\N	215	10.9	Carne, bovina, acém, sem gordura, cozido	27.3
329	0	\N	144	6.1	Carne, bovina, acém, sem gordura, cru	20.8
330	9.8	\N	189	11.2	Carne, bovina, almôndegas, cruas	12.3
331	14.3	\N	272	15.8	Carne, bovina, almôndegas, fritas	18.2
332	0	\N	133	4.5	Carne, bovina, bucho, cozido	21.6
333	0	\N	137	5.5	Carne, bovina, bucho, cru	20.5
334	0	\N	217	15	Carne, bovina, capa de contra-filé, com gordura, crua	19.2
335	0	\N	312	20	Carne, bovina, capa de contra-filé, com gordura, grelhada	30.7
336	0	\N	131	4.3	Carne, bovina, capa de contra-filé, sem gordura, crua	21.5
337	0	\N	239	10	Carne, bovina, capa de contra-filé, sem gordura, grelhada	35.1
338	0	\N	263	11.9	Carne, bovina, charque, cozido	36.4
339	0	\N	249	16.8	Carne, bovina, charque, cru	22.7
340	12.2	0.4	352	24	Carne, bovina, contra-filé, à milanesa	20.6
341	0	\N	202	13.1	Carne, bovina, contra-filé de costela, cru	19.8
342	0	\N	275	16.3	Carne, bovina, contra-filé de costela, grelhado	29.9
343	0	\N	206	12.8	Carne, bovina, contra-filé, com gordura, cru	21.2
344	0	\N	278	15.5	Carne, bovina, contra-filé, com gordura, grelhado	32.4
345	0	\N	157	6	Carne, bovina, contra-filé, sem gordura, cru	24
346	0	\N	194	4.5	Carne, bovina, contra-filé, sem gordura, grelhado	35.9
347	0	\N	373	27.7	Carne, bovina, costela, assada	28.8
348	0	\N	358	31.8	Carne, bovina, costela, crua	16.7
349	0	\N	217	8.9	Carne, bovina, coxão duro, sem gordura, cozido	31.9
350	0	\N	148	6.2	Carne, bovina, coxão duro, sem gordura, cru	21.5
351	0	\N	219	8.9	Carne, bovina, coxão mole, sem gordura, cozido	32.4
352	0	\N	169	8.7	Carne, bovina, coxão mole, sem gordura, cru	21.2
353	0	\N	330	23	Carne, bovina, cupim, assado	28.6
354	0	\N	221	15.3	Carne, bovina, cupim, cru	19.5
355	1.1	\N	141	5.4	Carne, bovina, fígado, cru	20.7
356	4.2	\N	225	9	Carne, bovina, fígado, grelhado	29.9
357	0	\N	143	5.6	Carne, bovina, filé mingnon, sem gordura, cru	21.6
358	0	\N	220	8.8	Carne, bovina, filé mingnon, sem gordura, grelhado	32.8
359	0	\N	196	7.8	Carne, bovina, flanco, sem gordura, cozido	29.4
360	0	\N	141	6.2	Carne, bovina, flanco, sem gordura, cru	20
361	0	\N	338	26	Carne, bovina, fraldinha, com gordura, cozida	24.2
362	0	\N	221	16.1	Carne, bovina, fraldinha, com gordura, crua	17.6
363	0	\N	222	9.1	Carne, bovina, lagarto, cozido	32.9
364	0	\N	135	5.2	Carne, bovina, lagarto, cru	20.5
365	0	\N	315	24.8	Carne, bovina, língua, cozida	21.4
366	0	\N	215	15.8	Carne, bovina, língua, crua	17.1
367	0	\N	153	7	Carne, bovina, maminha, crua	20.9
368	0	\N	153	2.4	Carne, bovina, maminha, grelhada	30.7
369	0	\N	163	7.8	Carne, bovina, miolo de alcatra, sem gordura, cru	21.6
370	0	\N	241	11.6	Carne, bovina, miolo de alcatra, sem gordura, grelhado	31.9
371	0	\N	194	6.7	Carne, bovina, músculo, sem gordura, cozido	31.2
372	0	\N	142	5.5	Carne, bovina, músculo, sem gordura, cru	21.6
373	0	\N	159	7.5	Carne, bovina, paleta, com gordura, crua	21.4
374	0	\N	194	7.4	Carne, bovina, paleta, sem gordura, cozida	29.7
375	0	\N	141	5.7	Carne, bovina, paleta, sem gordura, crua	21
376	0	\N	133	4.5	Carne, bovina, patinho, sem gordura, cru	21.7
377	0	\N	219	7.3	Carne, bovina, patinho, sem gordura, grelhado	35.9
378	0	\N	338	27	Carne, bovina, peito, sem gordura, cozido	22.2
379	0	\N	259	20.4	Carne, bovina, peito, sem gordura, cru	17.6
380	0	\N	213	14.7	Carne, bovina, picanha, com gordura, crua	18.8
381	0	\N	289	19.5	Carne, bovina, picanha, com gordura, grelhada	26.4
382	0	\N	134	4.7	Carne, bovina, picanha, sem gordura, crua	21.3
383	0	\N	238	11.3	Carne, bovina, picanha, sem gordura, grelhada	31.9
384	0	\N	313	21.9	Carne, bovina, seca, cozida	26.9
385	0	\N	313	25.4	Carne, bovina, seca, crua	19.7
386	34.5	5	283	11.8	Coxinha de frango, frita	9.6
387	13.9	\N	246	15.6	Croquete, de carne, cru	12
388	18.1	\N	347	22.7	Croquete, de carne, frito	16.9
389	47.5	2.2	358	15.6	Empada de frango, pré-cozida, assada	6.9
390	35.5	2.2	377	22.9	Empada, de frango, pré-cozida	7.3
391	0	\N	213	15.1	Frango, asa, com pele, crua	18.1
392	0	\N	243	15.6	Frango, caipira, inteiro, com pele, cozido	23.9
393	0	\N	196	7.7	Frango, caipira, inteiro, sem pele, cozido	29.6
394	0	\N	222	18.6	Frango, coração, cru	12.6
395	0.6	\N	207	12.1	Frango, coração, grelhado	22.4
396	0.1	\N	215	10.4	Frango, coxa, com pele, assada	28.5
397	0	\N	161	9.8	Frango, coxa, com pele, crua	17.1
398	0	\N	167	5.8	Frango, coxa, sem pele, cozida	26.9
399	0	\N	120	4.9	Frango, coxa, sem pele, crua	17.8
400	0	\N	106	3.5	Frango, fígado, cru	17.6
401	7.5	1.1	221	7.8	Frango, filé, à milanesa	28.5
402	0	\N	226	17.3	Frango, inteiro, com pele, cru	16.4
403	0	\N	187	7.5	Frango, inteiro, sem pele, assado	28
404	0	\N	170	7.1	Frango, inteiro, sem pele, cozido	25
405	0	\N	129	4.6	Frango, inteiro, sem pele, cru	20.6
406	0	\N	212	7.6	Frango, peito, com pele, assado	33.4
407	0	\N	149	6.7	Frango, peito, com pele, cru	20.8
408	0	\N	163	3.2	Frango, peito, sem pele, cozido	31.5
409	0	\N	119	3	Frango, peito, sem pele, cru	21.5
410	0	\N	159	2.5	Frango, peito, sem pele, grelhado	32
411	0	\N	260	15.2	Frango, sobrecoxa, com pele, assada	28.7
412	0	\N	255	20.9	Frango, sobrecoxa, com pele, crua	15.5
413	0	\N	233	12	Frango, sobrecoxa, sem pele, assada	29.2
414	0	\N	162	9.6	Frango, sobrecoxa, sem pele, crua	17.6
415	4.2	\N	215	16.2	Hambúrguer, bovino, cru	13.2
416	6.3	\N	258	17	Hambúrguer, bovino, frito	20
417	11.3	\N	210	12.4	Hambúrguer, bovino, grelhado	13.2
418	0	\N	218	17.4	Lingüiça, frango, crua	14.2
419	0	\N	245	18.5	Lingüiça, frango, frita	18.3
420	0	\N	244	18.4	Lingüiça, frango, grelhada	18.2
421	0	\N	227	17.6	Lingüiça, porco, crua	16.1
422	0	\N	280	21.3	Lingüiça, porco, frita	20.5
423	0	\N	296	21.9	Lingüiça, porco, grelhada	23.2
424	5.8	\N	269	21.6	Mortadela	12
425	0	\N	163	5.7	Peru, congelado, assado	26.2
426	0	\N	94	1.8	Peru, congelado, cru	18.1
427	0	\N	164	8	Porco, bisteca, crua	21.5
428	0	\N	311	18.5	Porco, bisteca, frita	33.7
429	0	\N	280	17.4	Porco, bisteca, grelhada	28.9
430	0	\N	402	30.3	Porco, costela, assada	30.2
431	0	\N	256	19.8	Porco, costela, crua	18
432	0	\N	210	6.4	Porco, lombo, assado	35.7
433	0	\N	176	8.8	Porco, lombo, cru	22.6
434	0	\N	258	19.9	Porco, orelha, salgada, crua	18.5
435	0	\N	262	13.9	Porco, pernil, assado	32.1
436	0	\N	186	11.1	Porco, pernil, cru	20.1
437	0	\N	377	34.5	Porco, rabo, salgado, cru	15.6
438	1.4	\N	128	6.8	Presunto, com capa de gordura	14.4
439	2.1	\N	94	2.7	Presunto, sem capa de gordura	14.3
440	12.9	1.9	136	2.7	Quibe, assado	14.6
441	10.8	1.6	109	1.7	Quibe, cru	12.4
442	12.3	\N	254	15.8	Quibe, frito	14.9
443	2.9	\N	398	30.6	Salame	25.8
444	0	\N	593	60.3	Toucinho, cru	11.5
445	0	\N	697	64.3	Toucinho, frito	27.3
446	7.6	0.3	55	1.9	Bebida láctea, pêssego	2.1
447	4.5	\N	221	22.5	Creme de Leite	1.5
448	1.9	\N	51	3	Iogurte, natural	4.1
449	5.8	\N	41	0.3	Iogurte, natural, desnatado	3.8
450	\N	\N	\N	\N	Iogurte, sabor abacaxi	\N
451	9.7	0.2	70	2.3	Iogurte, sabor morango	2.7
452	9.4	0.7	68	2.3	Iogurte, sabor pêssego	2.5
453	57	\N	313	6.7	Leite, condensado	7.7
454	5.2	\N	66	3.8	Leite, de cabra	3.1
455	14.2	0.6	83	2.2	Leite, de vaca, achocolatado	2.1
456	53	\N	362	0.9	Leite, de vaca, desnatado, pó	34.7
457	\N	\N	\N	\N	Leite, de vaca, desnatado, UHT	\N
458	\N	\N	\N	\N	Leite, de vaca, integral	\N
459	39.2	\N	497	26.9	Leite, de vaca, integral, pó	25.4
460	15.7	\N	70	0.1	Leite, fermentado	1.9
461	3.2	\N	264	20.2	Queijo, minas, frescal	17.4
462	3.6	\N	321	24.6	Queijo, minas, meia cura	21.2
463	3	\N	330	25.2	Queijo, mozarela	22.6
464	1.7	\N	453	33.5	Queijo, parmesão	35.6
465	5.7	\N	303	27.4	Queijo, pasteurizado	9.4
466	18.5	\N	121	2.8	Queijo, petit suisse, morango	5.8
467	1.9	\N	360	29.1	Queijo, prato	22.7
468	2.4	\N	257	23.4	Queijo, requeijão, cremoso	9.6
469	3.8	\N	140	8.1	Queijo, ricota	12.6
470	6.4	\N	26	0	Bebida isotônica, sabores variados	0
471	1.5	\N	9	0.1	Café, infusão 10%	0.7
472	\N	\N	216	\N	Cana, aguardente 1	\N
473	18.2	0.1	65	0	Cana, caldo de	0
474	3.3	\N	41	0	Cerveja, pilsen 2	0.6
475	0.4	\N	1	0	Chá, erva-doce, infusão 5%	0
476	0.6	\N	3	0.1	Chá, mate, infusão 5%	0
477	0.6	\N	2	0	Chá, preto, infusão 5%	0
478	5.3	0.1	22	0	Coco, água de	0
479	8	\N	31	0	Refrigerante, tipo água tônica	0
480	8.7	\N	34	0	Refrigerante, tipo cola	0
481	10	\N	39	0	Refrigerante, tipo guaraná	0
482	11.8	\N	46	0	Refrigerante, tipo laranja	0
483	10.3	\N	40	0	Refrigerante, tipo limão	0
484	0.4	\N	268	22	Omelete, de queijo	15.6
485	0.8	\N	177	12.7	Ovo, de codorna, inteiro, cru	13.7
486	0	\N	59	0.1	Ovo, de galinha, clara, cozida/10minutos	13.4
487	1.6	\N	353	30.8	Ovo, de galinha, gema, cozida/10minutos	15.9
488	0.6	\N	146	9.5	Ovo, de galinha, inteiro, cozido/10minutos	13.3
489	1.6	\N	143	8.9	Ovo, de galinha, inteiro, cru	13
490	1.2	\N	240	18.6	Ovo, de galinha, inteiro, frito	15.6
491	91.2	3.9	401	2.2	Achocolatado, pó	4.2
492	99.6	\N	387	0	Açúcar, cristal	0.3
493	94.5	\N	369	0.1	Açúcar, mascavo	0.8
494	99.5	\N	387	0	Açúcar, refinado	0.3
495	59.6	2.2	540	30.3	Chocolate, ao leite	7.2
496	55.4	2.5	559	34.2	Chocolate, ao leite, com castanha do Pará	7.4
497	56.3	2.8	557	33.8	Chocolate, ao leite, dietético	6.9
498	62.4	4.9	475	29.9	Chocolate, meio amargo	4.9
499	81.4	3.6	449	13.6	Cocada branca	1.1
500	54.6	2.3	199	0.2	Doce, de abóbora, cremoso	0.9
501	59.5	\N	306	6	Doce, de leite, cremoso	5.5
502	24.2	\N	106	0.1	Geléia, mocotó, natural	2.1
503	79.4	\N	292	0	Glicose de milho	0
504	73.6	0.7	301	0.2	Maria mole	3.8
505	75.1	0.6	307	0.1	Maria mole, coco queimado	3.9
506	70.8	4.1	257	0.1	Marmelada	0.4
507	84	\N	309	0	Mel, de abelha	0
508	76.6	\N	297	0	Melado	0
509	46.3	3.2	411	24.4	Quindim	4.7
510	90.8	\N	352	0.1	Rapadura	1
511	65.8	51.2	419	11.9	Café, pó, torrado	14.7
512	73.6	2.4	417	8.6	Capuccino, pó	11.3
513	43.9	\N	90	0.1	Fermento em pó, químico	0.5
514	7.7	4.2	90	1.5	Fermento, biológico, levedura, tablete	17
515	89.2	\N	380	0	Gelatina, sabores variados, pó	8.9
516	\N	\N	\N	\N	Sal, dietético	\N
517	\N	\N	\N	\N	Sal, grosso	\N
518	11.6	\N	61	0.3	Shoyu	3.3
519	2.1	0.6	21	0.3	Tempero a base de sal	2.7
520	5.5	4.6	194	20.3	Azeitona, preta, conserva	1.2
521	4.1	3.8	137	14.2	Azeitona, verde, conserva	0.9
522	16.9	\N	315	27.3	Chantilly, spray, com gordura vegetal	0.5
523	2.2	0.7	166	18.4	Leite, de coco	1
524	7.9	\N	302	30.5	Maionese, tradicional com ovos	0.6
525	19.1	9.4	289	19.9	Acarajé	8.3
526	11.6	1.5	154	7.1	Arroz carreteiro	10.8
527	20.4	5.1	136	3.2	Baião de dois, arroz e feijão-de-corda	6.2
528	0.2	0.1	165	9.5	Barreado	18.3
529	0	\N	291	21.1	Bife à cavalo, com contra filé	23.7
530	41.7	2.7	274	8.3	Bolinho de arroz	8
531	3.2	0.4	101	6	Camarão à baiana	7.9
532	10.1	1.5	78	1.1	Charuto, de repolho	6.8
533	25.3	2.1	113	0.7	Cuscuz, de milho, cozido com sal	2.2
534	22.5	2.4	142	4.6	Cuscuz, paulista	2.6
535	5.7	3	80	3.6	Cuxá, molho	5.6
536	0	\N	125	4.4	Dobradinha	19.8
537	3	\N	173	10.8	Estrogonofe de carne	15
538	2.6	\N	157	8	Estrogonofe de frango	17.6
539	19.6	3.6	152	6.8	Feijão tropeiro mineiro	10.2
540	11.6	5.1	117	6.5	Feijoada	8.7
541	4.1	0.2	113	6.2	Frango, com açafrão	9.7
542	22.5	0.8	120	0.9	Macarrão, molho bolognesa	4.9
543	3.4	2.2	134	8.7	Maniçoba	10
544	6.6	1.7	86	2.7	Quibebe	8.6
545	8.9	2.2	96	7	Salada, de legumes, com maionese	1.1
546	7.1	2.5	35	0.3	Salada, de legumes, cozida no vapor	2
547	4.6	0.4	148	7.8	Salpicão, de frango	13.9
548	1.1	\N	123	4.4	Sarapatel	18.5
549	10.6	2.1	57	1.2	Tabule	2
550	3.4	0.2	47	0.4	Tacacá	7
551	63.6	0	348	10.9	Tapioca, com manteiga	0.1
552	4.7	0.2	27	0.3	Tucupi, com pimenta-de-cheiro	2.1
553	10.1	2.3	145	9.3	Vaca atolada	5.1
554	9.7	1.7	255	23.2	Vatapá	6
555	14.1	2.2	307	25.6	Virado à paulista	10.2
556	18.3	1.1	113	2.6	Yakisoba	7.5
557	20.3	8	544	43.9	Amendoim, grão, cru	27.2
558	18.7	7.8	606	54	Amendoim, torrado, salgado	22.5
559	14.2	9.7	88	0.5	Ervilha, em vagem	7.5
560	13.4	5.1	74	0.4	Ervilha, enlatada, drenada	4.6
561	13.6	8.5	76	0.5	Feijão, carioca, cozido	4.8
562	61.2	18.4	329	1.3	Feijão, carioca, cru	20
563	13.5	7.5	78	0.6	Feijão, fradinho, cozido	5.1
564	61.2	23.6	339	2.4	Feijão, fradinho, cru	20.2
565	16.5	13.9	93	0.5	Feijão, jalo, cozido	6.1
566	61.5	30.3	328	0.9	Feijão, jalo, cru	20.1
567	14	8.4	77	0.5	Feijão, preto, cozido	4.5
568	58.8	21.8	324	1.2	Feijão, preto, cru	21.3
569	15.3	9.3	85	0.4	Feijão, rajado, cozido	5.5
570	62.9	24	326	1.2	Feijão, rajado, cru	17.3
571	11.8	4.8	68	0.5	Feijão, rosinha, cozido	4.5
572	62.2	20.6	337	1.3	Feijão, rosinha, cru	20.9
573	12.9	11.5	77	0.5	Feijão, roxo, cozido	5.7
574	60	33.8	331	1.2	Feijão, roxo, cru	22.2
575	57.9	12.4	355	5.4	Grão-de-bico, cru	21.2
576	64	21.3	344	2.1	Guandu, cru	19
577	16.3	7.9	93	0.5	Lentilha, cozida	6.3
578	62	16.9	339	0.8	Lentilha, crua	23.2
579	52.4	7.3	487	26.1	Paçoca, amendoim	16
580	54.7	3.4	503	28	Pé-de-moleque, amendoim	13.2
581	38.4	20.2	404	14.6	Soja, farinha	36
582	4.3	0.4	39	1.6	Soja, extrato solúvel, natural, fluido	2.4
583	28.5	7.3	459	26.2	Soja, extrato solúvel, pó	35.7
584	2.1	0.8	64	4	Soja, queijo (tofu)	6.6
585	43.8	32.3	381	10.3	Tremoço, cru	33.6
586	12.4	14.4	121	3.8	Tremoço, em conserva	11.1
587	29.5	11.6	581	47.3	Amêndoa, torrada, salgada	18.6
588	29.1	3.7	570	46.3	Castanha-de-caju, torrada, salgada	18.5
589	15.1	7.9	643	63.5	Castanha-do-Brasil, crua	14.5
590	10.4	5.4	406	42	Coco, cru	3.7
591	\N	\N	\N	\N	Coco,  verde, cru	\N
592	79.2	17.9	329	0.2	Farinha, de mesocarpo de babaçu, crua	1.4
593	21.6	11.9	584	50.4	Gergelim, semente	21.2
594	43.3	33.5	495	32.3	Linhaça, semente	14.1
595	43.9	15.6	174	0.7	Pinhão, cozido	3
596	29.6	4.3	219	12.8	Pupunha, cozida	2.5
597	18.4	7.2	620	59.4	Noz, crua	14
\.


--
-- Name: alimentos alimentos_pkey; Type: CONSTRAINT; Schema: public; Owner: myuser
--

ALTER TABLE ONLY public.alimentos
    ADD CONSTRAINT alimentos_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

\unrestrict badmLHvor3b1xcSwQwaCMMbtXVhfm6HCPPDkrecAGb6Q1koVec5bBNr6nddNMTt

