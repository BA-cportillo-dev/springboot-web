/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.IMCATRA;
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
@Entity(name = "MCATRA")
@Table(name = "MCATRA", schema = "MCADTA")
@IdClass(IMCATRA.class)
public class MCATRA {
    
    @Id
    @Column(name = "TRACOD")
    private String TRACOD;
    
    @Column(name = "TRAAMB")
    private String TRAAMB;
    
    @Column(name = "TRACE1")
    private String TRACE1;

    @Column(name = "TRACE2")
    private String TRACE2;

    @Column(name = "TRADES")
    private String TRADES;

    @Column(name = "TRAESC")
    private String TRAESC;

    @Column(name = "TRAEST")
    private String TRAEST;

    @Column(name = "TRATIP")
    private String TRATIP;

}
