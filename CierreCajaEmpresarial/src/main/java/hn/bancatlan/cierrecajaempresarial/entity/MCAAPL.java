/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.IMCAAPL;
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
@Entity(name = "MCAAPL")
@Table(name = "MCAAPL", schema = "MCADTA")
@IdClass(IMCAAPL.class)
public class MCAAPL {
    
    @Id
    @Column(name = "APLCOD")
    private String APLCOD;
    
    @Column(name = "APLDES")
    private String APLDES;

    @Column(name = "APLEBA")
    private String APLEBA;

    @Column(name = "APLEIT")
    private String APLEIT;

    @Column(name = "APLEST")
    private String APLEST;

}
