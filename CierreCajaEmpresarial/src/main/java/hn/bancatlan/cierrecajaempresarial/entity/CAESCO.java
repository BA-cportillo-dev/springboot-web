/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAESCO;
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
@Entity(name = "CAESCO")
@Table(name = "CAESCO", schema = "CAEDTA")
@IdClass(ICAESCO.class)
public class CAESCO {
    
    @Id
    @Column(name = "EMPNUM")
    private BigDecimal EMPNUM;
    
    @Id
    @Column(name = "SERNUM")
    private BigDecimal SERNUM;
    
    @Id
    @Column(name = "SCONUM")
    private BigDecimal SCONUM;
    
    @Column(name = "SCODES")
    private String SCODES;

    @Column(name = "SCOOPE")
    private String SCOOPE;

    @Column(name = "SCOAUT")
    private String SCOAUT;

    @Column(name = "SCOESP")
    private String SCOESP;

    @Column(name = "SCOEST")
    private String SCOEST;

}
