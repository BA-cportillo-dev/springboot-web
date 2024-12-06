/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.IMCADCPA;
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
@Entity(name = "MCADCP1")
@Table(name = "MCADCP1", schema = "MCADTA")
@IdClass(IMCADCPA.class)
public class MCADCP1 {
    
    @Column(name = "DCPACC")
    private BigDecimal DCPACC;
    
    @Column(name = "DCPCE1")
    private String DCPCE1;
    
    @Column(name = "DCPCE2")
    private String DCPCE2;

    @Column(name = "DCPCOM")
    private String DCPCOM;

    @Id
    @Column(name = "DCPCOR")
    private BigDecimal DCPCOR;

    @Id
    @Column(name = "DCPMOV")
    private String DCPMOV;
    
    @Id
    @Column(name = "DCPPLA")
    private String DCPPLA;

    @Column(name = "DCPTCA")
    private String DCPTCA;
        
    @Column(name = "DCPTMO")
    private String DCPTMO;

    @Column(name = "DCPVCA")
    private BigDecimal DCPVCA;

}
