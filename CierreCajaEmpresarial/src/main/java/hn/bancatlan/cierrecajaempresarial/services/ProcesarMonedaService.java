package hn.bancatlan.cierrecajaempresarial.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import hn.bancatlan.cierrecajaempresarial.entity.CAEEMP;

@Service
public class ProcesarMonedaService {
    
    public void procesarMoneda(String monCod){
        //1 setea &Tipo = 1 sí es LPS o 2 en otro caso
        BigDecimal tipo =  "LPS".equals(monCod) ? BigDecimal.valueOf(1) : BigDecimal.valueOf(2);
        
        //2 Busca en la SRVDTA.CTRLCTA por CTRLAPL y &Tipo y setea varias variables
        
        //3Recorre la CAEDTA.CAESER con un Join con la CAEEMP. (Aquí propongo recorrer sólo los servicios que están en el Diario y no todas).
        //4 Setea variables del servicio que será procesado y setea en 0 variables de cálculo.
        //5 crea la descripción de auditoría que enviará para hacer los movimientos contables.
        //6 Llama al programa PCAEPRCNF que se encarga de acreditar lo recaudado a la empresa (Esta lógica se trabajará después.)
        //7 Evalúa sí la respuesta es exitosa, sí no, registra el error en la caebit y finaliza el proceso.
        //8 Llama al programa PCAEOCS para obtener las cuentas de débito y crédito.
        //9 Setea la descripción para el cobro de comisión
        //10 hace el llamado al programa PCAEOTESF que calcula los totales del servicio.
        //11 hace el llamado al programa PCaEGCom que calcula la comisión.
        //12 Evalúa sí la comisión es > 0, sí no, sólo registra en la bitácora las comisiones en 0. //Este registro lo mantendría sí solo recorro lo necesario, lo eliminaría sí tengo que recorrer todos los servicios por empresa.
        //13 Evalúa con cases la &sCUCDT y setea cuenta y otras variables, el otherwise evalúa la respuesta de un 03
        //14 setea más variables.
        //15 valida la cuenta de débito con el 03 y sí la respuesta es 00 setea la MonDeb
        //16 Setea más variables
        //17 Cambio CAEMOR para buscar por empresa, servicio y moneda y aumenta el monto a cobrar.
        //18 Ejecuta el cobro de la comisión con el 001
        //19 evalúa la respuesta del 001 y sí es 00 ejecuta Dis-Agencia la cuál se realizará el análisis posteriormente.
        //20 Elimina los registros que se cobraron de la CAEMOR
        //21 Evalúa si la &banDeuda es 0 ejecuta normalmente el Dis-Agencia sí no:
        //22 Sí el cobro fue con mora, ejecuta el 006 con la sucursal 7500
        //23 Sí el 001 da error, registra el error contable en la CAEBIT
        //24 Registra el error en el cobro de la comisión en la CAEBMN
        //25 Registra en la CAEMOR el pago pendiente de comisión.
        //26 Crea el registro en la CAECSM y suma los montos.
    }
}
