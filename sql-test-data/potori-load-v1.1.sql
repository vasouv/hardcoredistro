insert into CUSTOMER(cemail,cpassword,cname,caddress,ccity,czipcode,ccountry) values
('vasouv.com','123456','Vasilis Souvatzis','Archiepiskopou Christodoulou','Xanthi','67133','Greece'),
('chrislafkas.com','234567','Chris Lafkas','Sardewn','Xanthi','67133','Greece'),
('johnpapadopoulos.com','345678','Giannis Papadopoulos','Kallithea','Xanthi','67100','Greece');

insert into ALBUM(title,band,release,details,photo_url,quantity,price) values
('Incorruptible','Iced Earth',2017,'album details album details album details album details album details',null,5,17.5),
('Firepower','Judas Priest',2018,'tromero comeback apo tous Judas Priest xwris ton KK Downing',null,3,18.2),
('Jomsviking','Amon Amarth',2017,'viking death metal from sweden',null,7,16),
('Nightfall in Middle Earth','Blind Guardian',1998,'apo ta kalytera power metal album pou graftikan, megalo tribute ston tolkien',null,0,13.5);

insert into PURCHASE(customer_id,date_placed,total_amount,purchase_status,date_shipped) values
(1,'2017-06-15',18,'PENDING',null),
(1,'2017-06-14',26.3,'SHIPPED','2017-06-14'),
(2,'2017-06-23',103.2,'PENDING',null),
(3,'2017-07-01',23.4,'SHIPPED','2017-07-02');

insert into PURCHASE_ALBUM(purchase_id,album_id) values
(1,1),
(2,2),
(2,3),
(3,4);