/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CAETRD")
@Table(name = "CAETRD", schema = "CAEDTA")
public class CAETRD implements Serializable {
    
    @Id
    @Column(name = "TRDNUM")
    private BigDecimal TRDNUM;
    
    @Column(name = "EMPNUM")
    private BigDecimal EMPNUM;

    @Column(name = "SERNUM")
    private BigDecimal SERNUM;

    @Column(name = "TRDID1")
    private String TRDID1;
    
    @Column(name = "TRDID2")
    private String TRDID2;

    @Column(name = "TRDID3")
    private String TRDID3;

    @Column(name = "TRDTIC")
    private String TRDTIC;

    @Column(name = "TRDSAV")
    private String TRDSAV;

    @Column(name = "TRDVAM")
    private String TRDVAM;

    @Column(name = "TRDPAM")
    private String TRDPAM;

    @Column(name = "TRDFEV")
    private String TRDFEV;

    @Column(name = "TRDCOM")
    private String TRDCOM;

    @Column(name = "TRDCAF")
    private String TRDCAF;

    @Column(name = "TRDCAH")
    private String TRDCAH;

    @Column(name = "TRDCAU")
    private String TRDCAU;
    
    @Column(name = "TRDPAN")
    private BigDecimal TRDPAN;

    @Column(name = "TRDNOA")
    private String TRDNOA;

    @Column(name = "TRDIDC")
    private String TRDIDC;

    @Column(name = "TRDCCE")
    private String TRDCCE;

    @Column(name = "TRDIEN")
    private BigDecimal TRDIEN;

    @Column(name = "TRDIED")
    private String TRDIED;

    @Column(name = "TRDREM")
    private String TRDREM;

    @Column(name = "TRDREA")
    private String TRDREA;

    @Column(name = "TRDREF")
    private String TRDREF;

    @Column(name = "TRDREH")
    private String TRDREH;

    @Column(name = "TRDVAC")
    private BigDecimal TRDVAC;

    @Column(name = "TRDTAC")
    private BigDecimal TRDTAC;

    @Column(name = "TRDINE")
    private BigDecimal TRDINE;

    @Column(name = "TRDREE")
    private BigDecimal TRDREE;

    @Column(name = "TRDREC")
    private BigDecimal TRDREC;

    @Column(name = "TRDRECN")
    private BigDecimal TRDRECN;

    @Column(name = "TRDRECB")
    private BigDecimal TRDRECB;

    @Column(name = "TRDCAJ")
    private String TRDCAJ;

    @Column(name = "TRDRET")
    private BigDecimal TRDRET;

    @Column(name = "TRDCIBS")
    private BigDecimal TRDCIBS;

    @Column(name = "AGECOD")
    private BigDecimal AGECOD;

    @Column(name = "TRDSUC")
    private BigDecimal TRDSUC;

    @Column(name = "TRDMOC")
    private BigDecimal TRDMOC;

    @Column(name = "TRDIDCON")
    private BigDecimal TRDIDCON;

}
