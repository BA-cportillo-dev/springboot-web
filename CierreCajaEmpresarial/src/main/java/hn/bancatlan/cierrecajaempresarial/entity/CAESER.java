/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAESER1;
import java.io.Serializable;
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
@Entity(name = "CAESER")
@Table(name = "CAESER", schema = "CAEDTA")
@IdClass(ICAESER1.class)
public class CAESER implements Serializable {
    
    @Id
    @Column(name = "EMPNUM")
    private BigDecimal EMPNUM;
    
    @Id
    @Column(name = "SERNUM")
    private BigDecimal SERNUM;

    @Column(name = "SERDES")
    private String SERDES;

    @Column(name = "SEREST")
    private String SEREST;

    @Column(name = "AOLSES")
    private String AOLSES;

    @Column(name = "SERI1D")
    private String SERI1D;

    @Column(name = "SERI2D")
    private String SERI2D;

    @Column(name = "SERI3D")
    private String SERI3D;

    @Column(name = "SERI1U")
    private String SERI1U;

    @Column(name = "SERI2U")
    private String SERI2U;

    @Column(name = "SERI3U")
    private String SERI3U;

    @Column(name = "SERTIC")
    private String SERTIC;

    @Column(name = "SERIP")
    private String SERIP;

    @Column(name = "SERPUE")
    private String SERPUE;

    @Column(name = "SERWSS")
    private String SERWSS;

    @Column(name = "SERWSP")
    private String SERWSP;

    @Column(name = "SERWSR")
    private String SERWSR;

    @Column(name = "SERWSC")
    private String SERWSC;

    @Column(name = "SERAEU")
    private String SERAEU;

    @Column(name = "SERAEC")
    private String SERAEC;

    @Column(name = "SERAECC")
    private String SERAECC;

    @Column(name = "SERCOR")
    private String SERCOR;

    @Column(name = "SERMEN")
    private String SERMEN;

    @Column(name = "SERCTC")
    private String SERCTC;

    @Column(name = "SERCFE")
    private String SERCFE;

    @Column(name = "SERCHO")
    private String SERCHO;

    @Column(name = "SERCFR")
    private BigDecimal SERCFR;

    @Column(name = "SERCAA")
    private String SERCAA;

    @Column(name = "SERPME")
    private String SERPME;

    @Column(name = "SERPMA")
    private String SERPMA;

    @Column(name = "SERPMC")
    private String SERPMC;

    @Column(name = "SERPCH")
    private String SERPCH;

    @Column(name = "SERLPU")
    private String SERLPU;

    @Column(name = "SERLPC")
    private BigDecimal SERLPC;

    @Column(name = "SERGCT")
    private String SERGCT;

    @Column(name = "SERGCI")
    private BigDecimal SERGCI;

    @Column(name = "SERUAU")
    private String SERUAU;

    @Column(name = "SERUAF")
    private String SERUAF;

    @Column(name = "SERUAH")
    private String SERUAH;

    @Column(name = "SERCRC")
    private BigDecimal SERCRC;

    @Column(name = "SERCRM")
    private String SERCRM;

    @Column(name = "SERDEC")
    private BigDecimal SERDEC;

    @Column(name = "SERDEM")
    private String SERDEM;

    @Column(name = "SERMOT")
    private BigDecimal SERMOT;

    @Column(name = "SERCOT")
    private BigDecimal SERCOT;

    @Column(name = "TISNUM")
    private BigDecimal TISNUM;

    @Column(name = "SERCOF")
    private BigDecimal SERCOF;

    @Column(name = "SERCOM")
    private String SERCOM;

    @Column(name = "SERMOM")
    private BigDecimal SERMOM;
    
    @Column(name = "SERGCM")
    private BigDecimal SERGCM;

    @Column(name = "SERRPM")
    private String SERRPM;

    @Column(name = "SERMOV")
    private BigDecimal SERMOV;

    @Column(name = "SERMCE")
    private BigDecimal SERMCE;

    @Column(name = "SERMCA")
    private BigDecimal SERMCA;

    @Column(name = "SERMOP")
    private BigDecimal SERMOP;

    @Column(name = "SERMC1")
    private BigDecimal SERMC1;

    @Column(name = "SERMC2")
    private BigDecimal SERMC2;

    @Column(name = "SERMOC")
    private String SERMOC;

    @Column(name = "TICCOD")
    private String TICCOD;

    @Column(name = "SERACA")
    private String SERACA;

}
