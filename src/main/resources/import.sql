insert into autores values (SEQ_AUTORES.nextval, 'BOGOTÁ D.C.', 'fivecoop@gmailcom', to_date('02/07/1990', 'dd/mm/yyyy'), 'Wilson David Cordero Mercado');
insert into autores values (SEQ_AUTORES.nextval, 'BOGOTÁ D.C.', 'wildeivid7@gmailcom', to_date('02/07/1990', 'dd/mm/yyyy'), 'Wilson David Cordero Mercado');



insert into editoriales values (SEQ_EDITORIALES.nextval, 'editorialmailto.com', 'CALLE 72', -1, 'editorialito express', '3116723132');
insert into editoriales values (SEQ_EDITORIALES.nextval, 'editorialmailtoo.com', 'CALLE 72', 3, 'editorialitoo express', '3116723132');



insert into libros values (SEQ_LIBROS.nextval, 'PROGRAMACIÓN', 320, 'Programa con SpringBoot de 0 a 100', sysdate, 1, 1);
insert into libros values (SEQ_LIBROS.nextval, 'PROGRAMACIÓN', 320, 'Programa con SpringBoot de 0 a 1000', sysdate, 1, 1);
insert into libros values (SEQ_LIBROS.nextval, 'PROGRAMACIÓN', 320, 'Programa con Js de 0 a 100', sysdate, 1, 2);
insert into libros values (SEQ_LIBROS.nextval, 'PROGRAMACIÓN', 320, 'Programa con Js de 0 a 1000', sysdate, 2, 2);


commit;
