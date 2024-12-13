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
import javax.persistence.IdClass;
import javax.persistence.Table;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAEMORD;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CAEMORD")
@Table(name = "CAEMORD", schema = "CAEDTA")
@IdClass(ICAEMORD.class)
public class CAEMORD implements Serializable {
    
    @Id
    @Column(name = "CIENUM")
    private BigDecimal CIENUM;
    
    @Id
    @Column(name = "MORDEMP")
    private BigDecimal MORDEMP;
    
    @Id
    @Column(name = "MORDSER")
    private BigDecimal MORDSER;

    @Column(name = "MORDEDES")
    private String MORDEDES;

    @Column(name = "MORDIC")
    private BigDecimal MORDIC;

    @Column(name = "MORDCUD")
    private BigDecimal MORDCUD;

    @Column(name = "MORDFEOC")
    private String MORDFEOC;

    @Column(name = "MORDMONCOD")
    private String MORDMONCOD;

    @Column(name = "MORDTOR")
    private BigDecimal MORDTOR;

    @Column(name = "MORDTOT")
    private BigDecimal MORDTOT;

    @Column(name = "MORDTOC")
    private BigDecimal MORDTOC;

    @Column(name = "MORDMCC")
    private String MORDMCC;

    @Column(name = "MORDCUC")
    private BigDecimal MORDCUC;

    @Column(name = "MORDMCD")
    private String MORDMCD;

    @Column(name = "MORDTAC")
    private BigDecimal MORDTAC;

    @Column(name = "MORDUHIC")
    private String MORDUHIC;

    @Column(name = "MORDUFIC")
    private String MORDUFIC;

}
