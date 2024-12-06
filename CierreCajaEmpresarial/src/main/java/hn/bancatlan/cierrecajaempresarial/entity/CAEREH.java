package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAEREH;
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
@Entity(name = "CAEREH")
@Table(name = "CAEREH", schema = "CAEDTA")
@IdClass(ICAEREH.class)
public class CAEREH {
    
    @Id
    @Column
    private BigDecimal REHNUM;

    @Column
    private BigDecimal EMPNUM;

    @Column
    private BigDecimal SERNUM;

    @Column
    private String REHID1;

    @Column
    private String REHID2;

    @Column
    private String REHID3;

    @Column
    private String REHREM;

    @Column
    private String REHREF;

    @Column
    private String REHREH;

    @Column
    private BigDecimal REHRET;

    @Column
    private BigDecimal REHREE;

    @Column
    private String REHCOM;

    @Column
    private String REHTER;

    @Column
    private String REHCAF;

    @Column
    private String REHCAH;

    @Column
    private String REHNOA;

    @Column
    private BigDecimal REHVAC;

    @Column
    private String REHUSR;

    @Column
    private String REHCAJ;

    @Column
    private String REHFRE;

    @Column
    private String REHHRE;

    @Column
    private String REHFAR;

    @Column
    private String REHHAR;

    @Column
    private String REHEST;

    @Column
    private String REHREVC;

    @Column
    private BigDecimal REHREC;

}