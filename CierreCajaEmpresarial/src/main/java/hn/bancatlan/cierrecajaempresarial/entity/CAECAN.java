/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAECAN;
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
@Entity(name = "CAECAN")
@Table(name = "CAECAN", schema = "CAEDTA")
@IdClass(ICAECAN.class)
public class CAECAN {
    
    @Id
    @Column(name = "CANCOD")
    private String CANCOD;
    
    @Column(name = "CANEST")
    private String CANEST;

    @Column(name = "CANDES")
    private String CANDES;

    @Column(name = "CANIDN")
    private BigDecimal CANIDN;

    @Column(name = "CANCCO")
    private String CANCCO;

}
