/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAEPAM1;
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
@Entity(name = "CAEPAM")
@Table(name = "CAEPAM", schema = "CAEDTA")
@IdClass(ICAEPAM1.class)
public class CAEPAM {
    
    @Id
    @Column(name = "PARNUM")
    private BigDecimal PARNUM;
    
    @Id
    @Column(name = "MONCOD")
    private String MONCOD;

    @Column(name = "PAMCCP")
    private BigDecimal PAMCCP;

    @Column(name = "PAMCCC")
    private BigDecimal PAMCCC;

    @Column(name = "PAMCCA")
    private BigDecimal PAMCCA;

    @Column(name = "PAMHTC")
    private BigDecimal PAMHTC;

}
