
-- new rows to customer table

INSERT INTO customer
(id, firstname, lastname, birthyear, sex, streetaddress, postcode, email, bonusscore)
VALUES
(1, 'Aava', 'Aavanen', 1990, 'N', 'Merikatu 25', '00100', 'aava.aavanen@mail.com', 25.5),
(2, 'Kekrä', 'Kuusinen', 2000, 'M','Metsätie 165', '23450', 'kekra.kuusinen@mail.com', 15.0), 
(3, 'Valtti', 'Vuorinen', 1955, 'M', 'Vuorenpolku 3 A', '00340', 'vvuorinen@mail.com', 75.5);

-- autogeneroituva id-arvo
INSERT INTO customer
(firstname, lastname, birthyear, sex, streetaddress, postcode, email, bonusscore)
VALUES
('Aino', 'Aavanen', 1995, 'N', 'Merikatu 25', '00100', 'aino.aavanen@mail.com', 36.00);

-- more inserts