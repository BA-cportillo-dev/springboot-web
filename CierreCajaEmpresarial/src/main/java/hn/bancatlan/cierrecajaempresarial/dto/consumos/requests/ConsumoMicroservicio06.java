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
public class ConsumoMicroservicio06 {

    String centroCosto;
    String cuentaDebito;
    String cuentaCredito;
    String moneda;
    Double monto;
    String sucursalDebito;
    String sucursalCredito;
    String descripcion;
}
