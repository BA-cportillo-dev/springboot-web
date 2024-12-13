/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAESEC1;
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
@Entity(name = "CAESERC")
@Table(name = "CAESERC", schema = "CAEDTA")
@IdClass(ICAESEC1.class)
public class CAESERC {
    
    @Id
    @Column(name = "EMPNUM")
    private BigDecimal EMPNUM;
    
    @Id
    @Column(name = "SERNUM")
    private BigDecimal SERNUM;
    
    @Id
    @Column(name = "SECCRN")
    private BigDecimal SECCRN;

    @Column(name = "SECCRE")
    private String SECCRE;

    @Column(name = "SECMOC")
    private BigDecimal SECMOC;

    @Column(name = "SECMOF")
    private BigDecimal SECMOF;

    @Column(name = "SECPOR")
    private BigDecimal SECPOR;

    @Column(name = "SECMON")
    private BigDecimal SECMON;

}
