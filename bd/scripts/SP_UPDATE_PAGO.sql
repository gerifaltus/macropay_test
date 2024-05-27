DROP PROCEDURE IF EXISTS macropaybd.UPDATE_PAGOS;

DELIMITER $$
$$
CREATE PROCEDURE macropaybd.UPDATE_PAGOS(
    IN in_client VARCHAR(40),
    IN in_fecha_actual DATE,
    IN in_tasa_interes DECIMAL(10,2),
    IN in_dias_anio_comercial INT,
    IN in_pago DECIMAL(10,2)
)
BEGIN
    
    DECLARE var_client VARCHAR(40) DEFAULT "";
    DECLARE var_id INT;
    DECLARE var_date_loan DATE;
    DECLARE var_amount_loan DECIMAL(10,2);
    DECLARE var_iva DECIMAL(10,2);
    DECLARE dec_plazo INT;
    DECLARE dec_interes DECIMAL(10,2);
    DECLARE dec_iva DECIMAL(10,2);
    DECLARE dec_pago DECIMAL(10,2);
    DECLARE dec_is_payable BOOL DEFAULT false;
    
    SET in_tasa_interes = (in_tasa_interes/100);

    SELECT a.client, l.id, l.date_loan, l.amount AS amount_loan, s.iva 
        INTO var_client, var_id, var_date_loan, var_amount_loan, var_iva
    FROM loans AS l
        INNER JOIN accounts AS a
            ON l.client = a.client 
                AND a.status = 'Activa'  
                AND l.status = 'Pendiente' 
        INNER JOIN sucursal AS s 
            ON s.id = l.id_sucursal
    WHERE a.client = in_client 
    ORDER BY l.date_loan ASC 
    LIMIT 1;

    SET dec_plazo = DATEDIFF(in_fecha_actual, var_date_loan);
    SET dec_interes = ((var_amount_loan * dec_plazo * in_tasa_interes) / in_dias_anio_comercial);
    SET dec_iva = (dec_interes * (var_iva/100));
    SET dec_pago = (var_amount_loan + dec_interes + dec_iva);

    START TRANSACTION;
        IF dec_pago >= in_pago THEN
            UPDATE accounts a SET a.amount = (a.amount + in_pago) WHERE a.client = in_client AND a.status = 'Activa';    
            UPDATE loans l SET l.status = 'Pagado' WHERE l.client = in_client AND l.id = var_id AND l.status = 'Pendiente';
        END IF;
    COMMIT;

END$$
DELIMITER ;
