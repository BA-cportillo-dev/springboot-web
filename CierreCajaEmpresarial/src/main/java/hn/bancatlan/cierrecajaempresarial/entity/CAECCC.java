/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAECCC1;
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
@Entity(name = "CAECCC")
@Table(name = "CAECCC", schema = "CAEDTA")
@IdClass(ICAECCC1.class)
public class CAECCC {
    
    @Id
    @Column(name = "CIENUM")
    private BigDecimal CIENUM;
    
    @Id
    @Column(name = "CMOCOD")
    private String CMOCOD;

    @Column(name = "CCCCCC")
    private BigDecimal CCCCCC;

    @Column(name = "CCCCCP")
    private BigDecimal CCCCCP;

    @Column(name = "CCCTOT")
    private BigDecimal CCCTOT;

    @Column(name = "CCCTOC")
    private BigDecimal CCCTOC;

}
