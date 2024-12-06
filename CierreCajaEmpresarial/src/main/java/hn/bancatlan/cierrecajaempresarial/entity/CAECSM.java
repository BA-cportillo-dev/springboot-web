/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAECSM1;
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
@Entity(name = "CAECSM")
@Table(name = "CAECSM", schema = "CAEDTA")
@IdClass(ICAECSM1.class)
public class CAECSM {
    
    @Id
    @Column(name = "CIENUM")
    private BigDecimal CIENUM;
    
    @Id
    @Column(name = "EMPNUM")
    private BigDecimal EMPNUM;
    
    @Id
    @Column(name = "SERNUM")
    private BigDecimal SERNUM;
    
    @Id
    @Column(name = "MONCOD")
    private String MONCOD;

    @Column(name = "CSMTOR")
    private BigDecimal CSMTOR;

    @Column(name = "CSMTOT")
    private BigDecimal CSMTOT;

    @Column(name = "CSMTAC")
    private BigDecimal CSMTAC;

    @Column(name = "CSMCUC")
    private BigDecimal CSMCUC;

    @Column(name = "CSMCUD")
    private BigDecimal CSMCUD;

    @Column(name = "CSMMCC")
    private String CSMMCC;

    @Column(name = "CSMMCD")
    private String CSMMCD;

    @Column(name = "CSMTOC")
    private BigDecimal CSMTOC;

    @Column(name = "CSMDES")
    private String CSMDES;

}
