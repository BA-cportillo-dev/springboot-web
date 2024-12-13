/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity.indexes;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;


@Data
public class ICAESCO implements Serializable {
    private BigDecimal EMPNUM;
    private BigDecimal SERNUM;
    private BigDecimal SCONUM;
}
