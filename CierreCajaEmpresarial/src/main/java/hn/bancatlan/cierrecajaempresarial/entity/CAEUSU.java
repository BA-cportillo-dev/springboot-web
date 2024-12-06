package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAEUSU;
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
@Entity(name = "CAEUSU")
@Table(name = "CAEUSU", schema = "CAEDTA")
@IdClass(ICAEUSU.class)
public class CAEUSU {

    @Id
    @Column(name="USUATL")
    private String USUATL;
    
    @Column(name="USUDES")
    private String USUDES;
    
    @Column(name="USUEST")
    private String USUEST;
    
    @Column(name="USUASU")
    private String USUASU;
    
    @Column(name="USUCON")
    private String USUCON;
    
    @Column(name="USUCOC")
    private String USUCOC;
    
    @Column(name="USUCOE")
    private String USUCOE;
    
    @Column(name="USUEXT")
    private String USUEXT;
    
    @Column(name="PERCOD")
    private String PERCOD;
    
    @Column(name="USUACA")
    private String USUACA;
}
