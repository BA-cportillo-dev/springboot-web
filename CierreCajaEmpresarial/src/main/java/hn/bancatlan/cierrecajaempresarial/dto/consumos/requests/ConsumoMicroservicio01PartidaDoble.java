/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.dto.consumos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsumoMicroservicio01PartidaDoble {

    String sucursalCredito;
    String sucursalDebito;
    String formaPago;
    String monedaTransaccion;
    Double montoTransaccion;
    String cuentaDebito;
    String cuentaCredito;
    String tipoNotaPago;
    String textoNotaPago;
}
