/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.IMCAHMO;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "MCAHMO")
@Table(name = "MCAHMO", schema = "MCADTA")
@IdClass(IMCAHMO.class)
public class MCAHMO {
    
    @Column(name = "HMOACC")
    private BigDecimal HMOACC;
    
    @Id
    @Column(name = "HMOAPL")
    private String HMOAPL;

    @Column(name = "HMOCER")
    private String HMOCER;

    @Id
    @Column(name = "HMOCOR")
    private BigDecimal HMOCOR;

    @Column(name = "HMOCTR")
    private BigDecimal HMOCTR;

    @Column(name = "HMOFEC")
    private String HMOFEC;

    @Column(name = "HMOHOR")
    private String HMOHOR;

    @Id
    @Column(name = "HMOMOV")
    private String HMOMOV;

    @Id
    @Column(name = "HMONUM")
    private BigDecimal HMONUM;

    @Column(name = "HMOPLA")
    private String HMOPLA;

    @Column(name = "HMORES")
    private String HMORES;

    @Column(name = "HMOTMO")
    private String HMOTMO;

    @Column(name = "HMOVAL")
    private BigDecimal HMOVAL;

}
