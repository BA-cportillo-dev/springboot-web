/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAETRH;
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
@Entity(name = "CAETRH")
@Table(name = "CAETRH", schema = "CAEDTA")
@IdClass(ICAETRH.class)
public class CAETRH {
    
    @Id
    @Column(name = "TRHNUM")
    private BigDecimal TRHNUM;
    
    @Column(name = "EMPNUM")
    private BigDecimal EMPNUM;

    @Column(name = "SERNUM")
    private BigDecimal SERNUM;

    @Column(name = "TRHID1")
    private String TRHID1;
    
    @Column(name = "TRHID2")
    private String TRHID2;

    @Column(name = "TRHID3")
    private String TRHID3;

    @Column(name = "TRHTIC")
    private String TRHTIC;

    @Column(name = "TRHSAV")
    private String TRHSAV;

    @Column(name = "TRHVAM")
    private String TRHVAM;

    @Column(name = "TRHPAM")
    private String TRHPAM;

    @Column(name = "TRHFEV")
    private String TRHFEV;

    @Column(name = "TRHCOM")
    private String TRHCOM;

    @Column(name = "TRHCAF")
    private String TRHCAF;

    @Column(name = "TRHCAH")
    private String TRHCAH;

    @Column(name = "TRHCAU")
    private String TRHCAU;
    
    @Column(name = "TRHPAN")
    private BigDecimal TRHPAN;

    @Column(name = "TRHNOA")
    private String TRHNOA;

    @Column(name = "TRHIDC")
    private String TRHIDC;

    @Column(name = "TRHCCE")
    private String TRHCCE;

    @Column(name = "TRHIEN")
    private BigDecimal TRHIEN;

    @Column(name = "TRHIED")
    private String TRHIED;

    @Column(name = "TRHREM")
    private String TRHREM;

    @Column(name = "TRHREA")
    private String TRHREA;

    @Column(name = "TRHREF")
    private String TRHREF;

    @Column(name = "TRHREH")
    private String TRHREH;

    @Column(name = "TRHVAC")
    private BigDecimal TRHVAC;

    @Column(name = "TRHTAC")
    private BigDecimal TRHTAC;

    @Column(name = "TRHINE")
    private BigDecimal TRHINE;

    @Column(name = "TRHREE")
    private BigDecimal TRHREE;

    @Column(name = "TRHREC")
    private BigDecimal TRHREC;

    @Column(name = "TRHRECN")
    private BigDecimal TRHRECN;

    @Column(name = "TRHRECB")
    private BigDecimal TRHRECB;

    @Column(name = "TRHCAJ")
    private String TRHCAJ;

    @Column(name = "TRHRET")
    private BigDecimal TRHRET;

    @Column(name = "TRHCIBS")
    private BigDecimal TRHCIBS;

    @Column(name = "AGECOD")
    private BigDecimal AGECOD;

    @Column(name = "TRHSUC")
    private BigDecimal TRHSUC;

    @Column(name = "TRHMOC")
    private BigDecimal TRHMOC;

    @Column(name = "TRHIDCON")
    private BigDecimal TRHIDCON;

    @Column(name = "CIENUM")
    private BigDecimal CIENUM;
    
    @Column(name = "TRHACF")
    private String TRHACF;
}
