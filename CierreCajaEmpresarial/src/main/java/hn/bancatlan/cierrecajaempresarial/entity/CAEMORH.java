package hn.bancatlan.cierrecajaempresarial.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAEMORH;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CAEMORH")
@Table(name = "CAEMORH", schema = "CAEDTA")
@IdClass(ICAEMORH.class)
public class CAEMORH implements Serializable {

    @Id
    @Column(name = "MORHEMP")
    private BigDecimal MORHEMP;
    
    @Column(name = "MORHFECC")
    private String MORHFECC;
    
    @Column(name = "MORHFEOC")
    private String MORHFEOC;
    
    @Column(name = "MORHCUD")
    private BigDecimal MORHCUD;
    
    @Column(name = "MORHIC")
    private BigDecimal MORHIC;
    
    @Column(name = "MORHEDES")
    private String MORHEDES;
    
    @Id
    @Column(name = "MORHSER")
    private BigDecimal MORHSER;
    
    @Id
    @Column(name = "CIENUM")
    private BigDecimal CIENUM;
    
    @Column(name = "MORHTAC")
    private BigDecimal MORHTAC;
    
    @Column(name = "MORHMCD")
    private String MORHMCD;
    
    @Column(name = "MORHCUC")
    private BigDecimal MORHCUC;
    
    @Column(name = "MORHMCC")
    private String MORHMCC;
    
    @Column(name = "MORHTOC")
    private BigDecimal MORHTOC;
    
    @Column(name = "MORHTOT")
    private BigDecimal MORHTOT;
    
    @Column(name = "MORHTOR")
    private BigDecimal MORHTOR;
    
    @Column(name = "MORHMONCOD")
    private String MORHMONCOD;
    
    @Column(name = "MORHUHIC")
    private String MORHUHIC;
    
    @Column(name = "MORHUFIC")
    private String MORHUFIC;

}


