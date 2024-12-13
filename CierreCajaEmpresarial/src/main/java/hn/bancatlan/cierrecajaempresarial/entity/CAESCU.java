/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAESCU;
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
@Entity(name = "CAESCU")
@Table(name = "CAESCU", schema = "CAEDTA")
@IdClass(ICAESCU.class)
public class CAESCU {
    
    @Id
    @Column(name = "EMPNUM")
    private BigDecimal EMPNUM;
    
    @Id
    @Column(name = "SERNUM")
    private BigDecimal SERNUM;

    @Id
    @Column(name = "MONCOD")
    private String MONCOD;

    @Column(name = "SCUCUD")
    private BigDecimal SCUCUD;

    @Column(name = "SCUCUC")
    private BigDecimal SCUCUC;

    @Column(name = "SCUEST")
    private String SCUEST;
    
    @Column(name = "SCUTCU")
    private String SCUTCU;

    @Column(name = "SCUTAC")
    private BigDecimal SCUTAC;

    @Column(name = "SCUCDT")
    private String SCUCDT;

    @Column(name = "SCUCCT")
    private String SCUCCT;

}
