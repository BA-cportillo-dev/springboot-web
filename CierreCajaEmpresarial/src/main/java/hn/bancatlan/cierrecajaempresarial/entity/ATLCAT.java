package hn.bancatlan.cierrecajaempresarial.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.IATLCAT;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ATLCAT")
@Table(name = "ATLCAT", schema = "MCADTA")
@IdClass(IATLCAT.class)
public class ATLCAT {
    @Column(name = "CAEDET")
    private String CAEDET;
    
    @Id
    @Column(name = "CATCOD")
    private BigDecimal CATCOD;

    @Column(name = "CATDES")
    private String CATDES;

    @Column(name = "CATEST")
    private String CATEST;

    @Id
    @Column(name = "CATTIP")
    private String CATTIP;

    @Id
    @Column(name = "CATVAL")
    private String CATVAL;
}
