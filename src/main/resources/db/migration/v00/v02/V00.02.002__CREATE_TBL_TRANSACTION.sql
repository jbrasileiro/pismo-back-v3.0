CREATE TABLE PUBLIC.TRANSACTION (
	ID 							BIGINT NOT NULL,
	ID_ACCOUNT					BIGINT NOT NULL,
	ID_OPERATION_TYPE			BIGINT NOT NULL,
	UUID_MESSAGE				UUID NOT NULL,
	AMOUNT						NUMERIC(12,2) NOT NULL,
	EVENT_DATE					TIMESTAMP NOT NULL,
	
	CONSTRAINT TRANSACTION_PK PRIMARY KEY (ID)
);
-- DROP TABLE PUBLIC.TRANSACTION
