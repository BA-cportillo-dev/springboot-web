/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAEEMP;
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
@Entity(name = "CAEEMP")
@Table(name = "CAEEMP", schema = "CAEDTA")
@IdClass(ICAEEMP.class)
public class CAEEMP {
    
    @Id
    @Column(name = "EMPNUM")
    private BigDecimal EMPNUM;
    
    @Column(name = "EMPIBS")
    private BigDecimal EMPIBS;

    @Column(name = "EMPDES")
    private String EMPDES;

    @Column(name = "USUATL")
    private String USUATL;

    @Column(name = "EMPEST")
    private String EMPEST;

    @Column(name = "AOLEES")
    private String AOLEES;

    @Column(name = "EMPCON")
    private String EMPCON;

    @Column(name = "EMPCOS")
    private String EMPCOS;

    @Column(name = "EMPCOC")
    private String EMPCOC;

    @Column(name = "EMPCOR")
    private String EMPCOR;

    @Column(name = "EMPTEL")
    private String EMPTEL;

    @Column(name = "EMPCOM")
    private String EMPCOM;

    @Column(name = "EMPCA1")
    private BigDecimal EMPCA1;

    @Column(name = "EMPCA2")
    private BigDecimal EMPCA2;

    @Column(name = "EMPCA3")
    private BigDecimal EMPCA3;

    @Column(name = "EMPNUS")
    private BigDecimal EMPNUS;

    @Column(name = "EMPAVS")
    private String EMPAVS;

    @Column(name = "EMPAVP")
    private String EMPAVP;

    @Column(name = "EMPANS")
    private String EMPANS;

    @Column(name = "EMPANP")
    private String EMPANP;

    @Column(name = "EMPARE")
    private String EMPARE;

    @Column(name = "EMPACA")
    private String EMPACA;

}
