package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAERED;
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
@Entity(name = "CAERED")
@Table(name = "CAERED", schema = "CAEDTA")
@IdClass(ICAERED.class)
public class CAERED {
    
    @Id
    @Column
    private BigDecimal REDNUM;

    @Column
    private BigDecimal EMPNUM;

    @Column
    private BigDecimal SERNUM;

    @Column
    private String REDID1;

    @Column
    private String REDID2;

    @Column
    private String REDID3;

    @Column
    private String REDREM;

    @Column
    private String REDREF;

    @Column
    private String REDREH;

    @Column
    private BigDecimal REDRET;

    @Column
    private BigDecimal REDREE;

    @Column
    private String REDCOM;

    @Column
    private String REDTER;

    @Column
    private String REDCAF;

    @Column
    private String REDCAH;

    @Column
    private String REDNOA;

    @Column
    private BigDecimal REDVAC;

    @Column
    private String REDUSR;

    @Column
    private String REDCAJ;

    @Column
    private String REDFRE;

    @Column
    private String REDHRE;

    @Column
    private String REDFAR;

    @Column
    private String REDHAR;

    @Column
    private String REDEST;

    @Column
    private String REDREVC;

    @Column
    private BigDecimal REDREC;

}