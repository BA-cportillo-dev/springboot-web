/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAETHF;
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
@Entity(name = "CAETRHF")
@Table(name = "CAETRHF", schema = "CAEDTA")
@IdClass(ICAETHF.class)
public class CAETRHF {
    
    @Id
    @Column(name = "TRHNUM")
    private BigDecimal TRHNUM;
    
    @Id
    @Column(name = "TRHFDB")
    private String TRHFDB;

    @Column(name = "TRHFNP")
    private BigDecimal TRHFNP;

    @Column(name = "TRHFMD")
    private BigDecimal TRHFMD;

    @Column(name = "TRHFCB")
    private BigDecimal TRHFCB;

}
