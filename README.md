# travel-agency
Aplication boilerplate for travel agency website
This Application is like a social media where use can psot a status and see them  into their home page.
Database Setup:
Create a user name himel in MYSQl.This project has 3 database table.
1:User Table(For Registraion).
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mailid` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
2:Information Table(For Storing  Information of user like status,loaction,privacy)
CREATE TABLE `information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mailid` varchar(255) DEFAULT NULL,
  `privacytype` varchar(255) DEFAULT NULL,
  `checkinplace` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
2:Information Table(For Storing  Information of user like status,loaction,privacy)
CREATE TABLE `information` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mailid` varchar(255) DEFAULT NULL,
  `privacytype` varchar(255) DEFAULT NULL,
  `checkinplace` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
3:Loaction Table(For find the location).
CREATE TABLE `location` (
  `id` bigint(5) NOT NULL,
  `city` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
)



