DROP PROCEDURE IF EXISTS macropaybd.GET_ADEUDOS_CUENTAS;

DELIMITER $$
$$
CREATE PROCEDURE macropaybd.GET_ADEUDOS_CUENTAS(
    IN in_fecha_actual DATE,
    IN in_tasa_interes DECIMAL(10,2),
    IN in_dias_anio_comercial INT
)
BEGIN
    DECLARE done BOOL DEFAULT false;
    DECLARE cur_client VARCHAR(40) DEFAULT "";
    DECLARE cur_date_loan DATE;
    DECLARE cur_amount_loan DECIMAL(10,2);
    DECLARE cur_iva DECIMAL(10,2);
    DECLARE dec_plazo INT;
    DECLARE dec_interes DECIMAL(10,2);
    DECLARE dec_iva DECIMAL(10,2);
    DECLARE dec_pago DECIMAL(10,2);

    DECLARE cursor_CLIENTES_ADEUDOS CURSOR FOR
    SELECT a.client, l.date_loan, l.amount AS amount_loan, s.iva  
        FROM loans AS l
            INNER JOIN accounts AS a
                ON l.client = a.client AND a.status = 'Activa' AND l.status = 'Pendiente'
            INNER JOIN sucursal AS s 
                ON s.id = l.id_sucursal;
    
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = true;

    SET in_tasa_interes = (in_tasa_interes/100);

    DROP TEMPORARY TABLE IF EXISTS tmp_data;
    CREATE TEMPORARY TABLE tmp_data (
        client VARCHAR(40),
        plazo INT, 
        amount DECIMAL(10,2), 
        interes DECIMAL(10,2), 
        iva DECIMAL(10,2),
        pago DECIMAL(10,2)
    );

    OPEN cursor_CLIENTES_ADEUDOS;
    
        process_clientes_adeudos: LOOP
        
            FETCH cursor_CLIENTES_ADEUDOS INTO cur_client, cur_date_loan, cur_amount_loan, cur_iva;
            
            IF done = true THEN 
                LEAVE process_clientes_adeudos;
            END IF;
            
            SET dec_plazo = DATEDIFF(in_fecha_actual, cur_date_loan);
            SET dec_interes = ((cur_amount_loan * dec_plazo * in_tasa_interes) / in_dias_anio_comercial);
            SET dec_iva = (dec_interes * (cur_iva/100));
            SET dec_pago = (cur_amount_loan + dec_interes + dec_iva);
        
            INSERT INTO tmp_data (client, plazo, amount, interes, iva, pago)
                VALUES(cur_client, dec_plazo, cur_amount_loan, dec_interes, dec_iva, dec_pago);
        
        END LOOP;
            
    CLOSE cursor_CLIENTES_ADEUDOS;
    
    SELECT td.client, td.plazo, td.amount, td.interes, td.iva, td.pago FROM tmp_data td ORDER BY td.plazo DESC;
    SELECT td.client, td.amount FROM tmp_data td;

END$$
DELIMITER ;
