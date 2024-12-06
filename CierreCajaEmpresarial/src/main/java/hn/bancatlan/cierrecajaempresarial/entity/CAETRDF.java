/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAETDF1;
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
@Entity(name = "CAETRDF")
@Table(name = "CAETRDF", schema = "CAEDTA")
@IdClass(ICAETDF1.class)
public class CAETRDF {
    
    @Id
    @Column(name = "TRDNUM")
    private BigDecimal TRDNUM;
    
    @Id
    @Column(name = "TRDFFD")
    private String TRDFFD;

    @Column(name = "TRDFNP")
    private BigDecimal TRDFNP;

    @Column(name = "TRDFMD")
    private BigDecimal TRDFMD;

    @Column(name = "TRDFCB")
    private BigDecimal TRDFCB;

}
