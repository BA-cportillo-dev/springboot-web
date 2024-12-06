/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.IMCACOR;
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
@Entity(name = "MCACOR")
@Table(name = "MCACOR", schema = "MCADTA")
@IdClass(IMCACOR.class)
public class MCACOR {
    
    @Id
    @Column(name = "CORAPL")
    private String CORAPL;
    
    @Column(name = "CORFEC")
    private String CORFEC;

    @Column(name = "CORHOR")
    private String CORHOR;

    @Column(name = "CORNUM")
    private BigDecimal CORNUM;

}
