USE macropaybd;

--
-- Dumping data for table `loans`
--

LOCK TABLES `loans` WRITE;
/*!40000 ALTER TABLE `loans` DISABLE KEYS */;
INSERT INTO `loans` VALUES ('911ac37c-5990-4bf8-8cf0-b51f21c8ecbe',1,'2021-01-15',37500.00,'Pendiente','3'),('911ac37c-5990-4bf8-8cf0-b51f21c8ecbe',2,'2021-01-24',725.18,'Pendiente','3'),('911ac37c-5990-4bf8-8cf0-b51f21c8ecbe',3,'2021-02-05',1578.22,'Pendiente','3'),('911ac37c-5990-4bf8-8cf0-b51f21c8ecbe',4,'2021-02-09',380.00,'Pendiente','3'),('8482bcae-0b2b-45bb-9012-59ec93978265',1,'2021-01-12',2175.25,'Pagado','2'),('8482bcae-0b2b-45bb-9012-59ec93978265',2,'2021-01-18',499.99,'Pagado','2'),('8482bcae-0b2b-45bb-9012-59ec93978265',3,'2021-01-29',5725.18,'Pendiente','2'),('8482bcae-0b2b-45bb-9012-59ec93978265',4,'2021-02-12',876.13,'Pendiente','2'),('78be3a77-698d-43ef-b113-a598eb1fb791',1,'2021-02-09',545.55,'Pendiente','1'),('cee008ca-c715-456b-96c6-74ff9bd22dd3',1,'2020-12-31',15220.00,'Pagado','1');
/*!40000 ALTER TABLE `loans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES ('78be3a77-698d-43ef-b113-a598eb1fb791',0.00,'Cancelada'),('8482bcae-0b2b-45bb-9012-59ec93978265',3728.51,'Bloqueada'),('911ac37c-5990-4bf8-8cf0-b51f21c8ecbe',15375.28,'Activa'),('cee008ca-c715-456b-96c6-74ff9bd22dd3',235.28,'Activa');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
INSERT INTO `sucursal` VALUES (1,'Tijuana',8.00),(2,'Nuevo León',16.00),(3,'Tamaulipas',10.00);
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;