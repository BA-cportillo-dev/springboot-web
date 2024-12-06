package hn.bancatlan.cierrecajaempresarial.entity;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAEHPR;
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
@Entity(name = "CAEHPR")
@Table(name = "CAEHPR", schema = "CAEDTA")
@IdClass(ICAEHPR.class)
public class CAEHPR {

    @Id
    @Column(name = "HPRPRG")
    private String HPRPRG;

    @Column(name = "HPRTIT")
    private String HPRTIT;

    @Column(name = "HPRCOM")
    private String HPRCOM;

    @Column(name = "HPREST")
    private String HPREST;

}

