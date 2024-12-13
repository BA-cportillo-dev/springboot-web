/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAETRHC;
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
@Entity(name = "CAETRHC")
@Table(name = "CAETRHC", schema = "CAEDTA")
@IdClass(ICAETRHC.class)
public class CAETRHC {
    
    @Id
    @Column(name = "TRHNUM")
    private BigDecimal TRHNUM;
    
    @Id
    @Column(name = "TRHCNU")
    private BigDecimal TRHCNU;

    @Column(name = "TRHCMO")
    private BigDecimal TRHCMO;

    @Column(name = "TRHCOP")
    private String TRHCOP;

}
