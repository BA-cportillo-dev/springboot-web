/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.IMCAMCP;
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
@Entity(name = "MCAMCP")
@Table(name = "MCAMCP", schema = "MCADTA")
@IdClass(IMCAMCP.class)
public class MCAMCP {
    
    @Id
    @Column(name = "APLCOD")
    private String APLCOD;
    
    @Id
    @Column(name = "CANCOD")
    private String CANCOD;
    
    @Column(name = "MCPAOP")
    private String MCPAOP;

    @Id
    @Column(name = "MCPAR1")
    private String MCPAR1;

    @Id
    @Column(name = "MCPAR2")
    private String MCPAR2;

    @Id
    @Column(name = "MCPAR3")
    private String MCPAR3;

    @Column(name = "MCPEST")
    private String MCPEST;

    @Column(name = "MCPFEC")
    private String MCPFEC;

    @Column(name = "MCPHOR")
    private String MCPHOR;

    @Column(name = "MCPMCON")
    private String MCPMCON;

    @Column(name = "MCPNPL")
    private String MCPNPL;

    @Column(name = "MCPNPLC")
    private BigDecimal MCPNPLC;

    @Column(name = "MCPUAU")
    private String MCPUAU;

    @Column(name = "MCPUOP")
    private String MCPUOP;

    @Id
    @Column(name = "MONCOD")
    private String MONCOD;

    @Id
    @Column(name = "TRACOD")
    private String TRACOD;

}
