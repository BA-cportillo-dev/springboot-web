package hn.bancatlan.cierrecajaempresarial.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAEBIT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CAEBIT")
@Table(name = "CAEBIT", schema = "CAEDTA")
@IdClass(ICAEBIT.class)
public class CAEBIT {
    
    @Id
    @Column(name = "BITNUM")
    private BigDecimal BITNUM;
    
    @Column(name = "BITDET")
    private String BITDET;

    @Column(name = "BITFEC")
    private String BITFEC;

    @Column(name = "BITHOR")
    private String BITHOR;

    @Column(name = "BITIMP")
    private String BITIMP;

}

