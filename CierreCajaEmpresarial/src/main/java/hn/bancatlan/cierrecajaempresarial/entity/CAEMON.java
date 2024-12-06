/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAEMON;
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
@Entity(name = "CAEMON")
@Table(name = "CAEMON", schema = "CAEDTA")
@IdClass(ICAEMON.class)
public class CAEMON {
    
    @Id
    @Column(name = "MONCOD")
    private String MONCOD;
    
    @Column(name = "MONDES")
    private String MONDES;

    @Column(name = "MONEST")
    private String MONEST;

}
