use moviedb;

INSERT INTO `moviedb`.`movie`
(`Id`,`Duration`,`Release_day`,`Release_month`,`Release_year`,`Rating`,`Title`,`Poster`,`Genre`,`Synopsys`,`Box_office`)
VALUES
(1,104,16,2,2017,7.5,'The LEGO Batman Movie','images/posters/lego_batman_movie.jpg','Animation','A cooler-than-ever Bruce Wayne must deal with the usual suspects as they plan to rule Gotham City, while discovering that he has accidentally adopted a teenage orphan who wishes to become his sidekick.',310850384),
(2,141,1,6,2017,8.1,'Wonder Woman','images/posters/wonder_woman.jpg','Super Heroes','Before she was Wonder Woman she was Diana, princess of the Amazons, trained warrior. When a pilot crashes and tells of conflict in the outside world, she leaves home to fight a war to end all wars, discovering her full powers and true destiny.',453660634),
(3,110,8,6,2017,5.9,'The Mummy','images/posters/the_mummy.jpg','Adventure','An ancient princess is awakened from her crypt beneath the desert, bringing with her malevolence grown over millennia, and terrors that defy human comprehension.',178908331),
(4,122,23,2,2017,7.8,'John Wick: Chapter 2','images/posters/jonh_wick_2.jpg','Action','After returning to the criminal underworld to repay a debt, John Wick discovers that a large bounty has been put on his life.',166835326	),
(5,104,4,5,2017,7.8,'Get Out','images/posters/get_out.jpg','Mistery','It\'s time for a young African American to meet with his white girlfriend\'s parents for a weekend in their secluded estate in the woods, but before long, the friendly and polite ambience will give way to a nightmare.',250167609),
(6,115,27,10,2016,7.6,'Doctor Strange','images/posters/doctor_strange.jpg','Super Heroes','While on a journey of physical and spiritual healing, a brilliant neurosurgeon is drawn into the world of the mystic arts.',677718395),
(7,107,24,11,2016,7.7,'Moana','images/posters/moana.jpg','Animation','In Ancient Polynesia, when a terrible curse incurred by the Demigod Maui reaches an impetuous Chieftain\'s daughter\'s island, she answers the Ocean\'s call to seek out the Demigod to set things right.',642666887),
(8,133,17,11,2016,7.4,'Fantastic Beasts and Where to Find Them','images/posters/fantastic_beasts.jpg','Adventure','The adventures of writer Newt Scamander in New York\'s secret community of witches and wizards seventy years before Harry Potter reads his book in school.',814037575),
(9,116,10,11,2016,8.0,'Arrival','images/posters/arrival.jpg','Sci-Fi','When twelve mysterious spacecraft appear around the world, linguistics professor Louise Banks is tasked with interpreting the language of the apparent alien visitors.',202107388),
(10,127,2,2,2017,7.8,'Hidden Figures','images/posters/hidden_figures.jpg','Historical','The story of a team of female African-American mathematicians who served a vital role in NASA during the early years of the U.S. space program.',230106697);



INSERT INTO `moviedb`.`staff`
(`Id`,`Role`,`Name`,`Bio`,`Picture`)
VALUES
(1,'Voice Actor','Will Arnett','Will Arnett is a Canadian-American actor, voice actor, and comedian.','images/staff/will_arnett.jpg'),
(2,'Actress','Gal Gadot','Gal Gadot is an Israeli actress, martial artist, and model. She was born in Rosh Ha\'ayin, Israel, to a Jewish family (from Poland, Austria, Germany, and Czechoslovakia).','images/staff/gal_gadot.jpg'),
(3,'Actor','Tom Cruise','Tom is the only son (among four children) of nomadic parents, Mary Lee (Pfeiffer), a special education teacher, and Thomas Cruise Mapother III, an electrical engineer.','images/staff/tom_cruise.jpg'),
(4,'Actor','Keanu Reeves','Keanu Charles Reeves, whose first name means "cool breeze over the mountains" in Hawaiian, was born September 2, 1964 in Beirut, Lebanon. He is the son of Patricia Taylor, a showgirl and costume designer, and Samuel Nowlin Reeves, a geologist.','images/staff/keanu_reeves.jpg'),
(5,'Actor','Daniel Kaluuya','Daniel Kaluuya was born in 1989 in London, England.','images/staff/daniel_kaluya.jpg'),
(6,'Actor','Benedict Cumberbatch','Benedict Timothy Carlton Cumberbatch was born and raised in London, England. His parents, Wanda Ventham and Timothy Carlton (Timothy Carlton Congdon Cumberbatch), are both actors.','images/staff/benedict_cumberbatch.jpg'),
(7,'Voice Actress','Auli\'i Cravalho','Auli\'i Cravalho was born on November 22, 2000 in Kohala, Hawaii, USA.','images/staff/auli_cravalho.jpg'),
(8,'Actor','Eddie Redmayne','British actor Eddie Redmayne is the first, and thus far only, millennial male to have won an acting Oscar.Edward John David Redmayne was born and raised in London, England, the son of Patricia (Burke) and Richard Redmayne, a businessman.','images/staff/eddie_redmayne.jpg'),
(9,'Actress','Amy Adams','Amy Lou Adams was born in Vicenza, Veneto, Italy, to American parents, Kathryn (Hicken) and Richard Kent Adams, a U.S. serviceman who was stationed at Caserma Ederle in Italy at the time.','images/staff/amy_adams.jpg'),
(10,'Actress','Taraji Henson','Taraji P. Henson was born on September 11, 1970 in Washington, District of Columbia, USA as Taraji Penda Henson.','images/staff/taraji_henson.jpg');

INSERT INTO `moviedb`.`user`
(`Id`,`Username`,`Password`,`Avatar`,`Email`)
VALUES
(1,'user1','pass1','images/avatar/default.png','mail@mail.com'),
(2,'user2','pass2','images/avatars/user2_avatar.png','mail2@mail.com');

INSERT INTO `moviedb`.`review`
(`Id`,`MovieId`,`UserId`,`Review`,`Sound_grade`,`Story_grade`,`Direction_grade`,`Enjoyment_grade`,`Overall_grade`)
VALUES
(1,1,1,'A light hearted aproach on Batman.',7,7,6,8,7),
(2,3,1,'How not to make a reboot.',5,5,6,4,5),
(3,9,2,'Made me ponder how we comunicate',8,8,7,8,8);

INSERT INTO `moviedb`.`movie_staff`
(`MovieId`,`StaffId`)
VALUES
(1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(10,10);

INSERT INTO `moviedb`.`user_movie`
(`UserId`,`MovieId`)
VALUES
(1,1),
(1,2),
(1,3),
(1,4),
(2,7);

INSERT INTO `moviedb`.`user_movie2`
(`UserId`,`MovieId`)
VALUES
(1,1),
(1,2),
(1,3),
(1,4),
(2,7);


INSERT INTO `moviedb`.`user_movie3`
(`UserId`,`MovieId`)
VALUES
(1,5),
(2,6),
(2,8),
(2,9);
