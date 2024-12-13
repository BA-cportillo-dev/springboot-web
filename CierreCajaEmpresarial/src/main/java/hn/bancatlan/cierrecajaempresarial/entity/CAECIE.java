/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAECIE;
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
@Entity(name = "CAECIE")
@Table(name = "CAECIE", schema = "CAEDTA")
@IdClass(ICAECIE.class)
public class CAECIE {
    
    @Id
    @Column(name = "CIENUM")
    private BigDecimal CIENUM;
    
    @Column(name = "CIEFEC")
    private String CIEFEC;

    @Column(name = "CIEHOC")
    private String CIEHOC;

    @Column(name = "CIEATL")
    private String CIEATL;

    @Column(name = "CIEDES")
    private String CIEDES;

    @Column(name = "CIETOR")
    private BigDecimal CIETOR;

    @Column(name = "CIETOO")
    private BigDecimal CIETOO;

    @Column(name = "CIEPOC")
    private BigDecimal CIEPOC;

}
