INSERT INTO ca_v1_dev.address (`ADDITIONALINFO`, `STREET`, `cityInfo_ID`) 
	VALUES ('', 'Abbey Road 4', 1);

INSERT INTO ca_v1_dev.cityinfo (`ID`, `CITY`, `ZIPCODE`) 
	VALUES (1, 'Ballerup', 2750);

INSERT INTO ca_v1_dev.hobby (`DESCRIPTION`, `NAME`) 
	VALUES ('Best hobby ever', 'Stamps');

INSERT INTO ca_v1_dev.hobby_infoentity (`hobbies_ID`, `persons_ID`) 
	VALUES (1, 1);

INSERT INTO ca_v1_dev.phone (`DESCRIPTION`, `NUMBER`, `InfoEntity_ID`) 
	VALUES ('Mobile', '159', 1);

INSERT INTO ca_v1_dev.`sequence` (`SEQ_NAME`, `SEQ_COUNT`) 
	VALUES ('seq 1', NULL);

INSERT INTO ca_v1_dev.infoentity (`Entity_Type`, `EMAIL`, `ADDRESS_ID`, `CVR`, `DESCRIPTION`, `MARKETVALUE`, `NAME`, `NUMEMPLOYEES`, `FIRSTNAME`, `LASTNAME`) 
	VALUES ('p', 'jjj@jf.com', 4, '1', 'Bakery', '1', 'The little bakery', 5, 'Kate', 'Bakingsale')
