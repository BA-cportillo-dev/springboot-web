/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAEPAR;
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
@Entity(name = "CAEPAR")
@Table(name = "CAEPAR", schema = "CAEDTA")
@IdClass(ICAEPAR.class)
public class CAEPAR {
    
    @Id
    @Column(name = "PARNUM")
    private BigDecimal PARNUM;
    
    @Column(name = "PAREST")
    private BigDecimal PAREST;

    @Column(name = "PARNOI")
    private String PARNOI;

    @Column(name = "PARNOA")
    private String PARNOA;

    @Column(name = "PARHOY")
    private String PARHOY;

    @Column(name = "PARHJU")
    private BigDecimal PARHJU;

    @Column(name = "PARHCO")
    private BigDecimal PARHCO;

    @Column(name = "PARHCC")
    private BigDecimal PARHCC;

    @Column(name = "PARINFO")
    private String PARINFO;
    
    @Column(name = "PARCON")
    private String PARCON;

    @Column(name = "PARBLM")
    private BigDecimal PARBLM;

    @Column(name = "PARCAC")
    private BigDecimal PARCAC;

    @Column(name = "PARMOL")
    private String PARMOL;
    
    @Column(name = "PARCAU")
    private String PARCAU;
    
    @Column(name = "PARESP")
    private String PARESP;

    @Column(name = "PARHCA")
    private BigDecimal PARHCA;

}
