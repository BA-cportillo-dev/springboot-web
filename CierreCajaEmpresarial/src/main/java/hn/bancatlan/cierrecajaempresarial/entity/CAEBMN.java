package hn.bancatlan.cierrecajaempresarial.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAEBMN;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CAEBMN")
@Table(name = "CAEBMN", schema = "CAEDTA")
@IdClass(ICAEBMN.class)
public class CAEBMN {
    
    @Id
    @Column(name = "CIENUM")
    private BigDecimal CIENUM;
    
    @Id
    @Column(name = "EMPNUM")
    private BigDecimal EMPNUM;
    
    @Id
    @Column(name = "SERNUM")
    private BigDecimal SERNUM;
    
    @Id
    @Column(name = "BMNCOR")
    private BigDecimal BMNCOR;
    
    @Column(name = "BMNMON")
    private BigDecimal BMNMON;

    @Column(name = "BMNRESP")
    private String BMNRESP;    

    @Column(name = "BMNRES2")
    private String BMNRES2;
    
    @Column(name = "BMNTIP")
    private String BMNTIP;

}

