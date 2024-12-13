/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAETRDC;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CAETRDC")
@Table(name = "CAETRDC", schema = "CAEDTA")
@IdClass(ICAETRDC.class)
public class CAETRDC {
    
    @Id
    @Column(name = "TRDNUM")
    private BigDecimal TRDNUM;
    
    @Id
    @Column(name = "TRDCNU")
    private BigDecimal TRDCNU;

    @Column(name = "TRDCMO")
    private BigDecimal TRDCMO;

    @Column(name = "TRDCOP")
    private String TRDCOP;

}
