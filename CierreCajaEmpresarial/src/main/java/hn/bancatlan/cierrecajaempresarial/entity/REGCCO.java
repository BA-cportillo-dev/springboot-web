package hn.bancatlan.cierrecajaempresarial.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "REGCCO")
@Table(name = "REGCCO", schema = "SRVDTA")
public class REGCCO implements Serializable {//Si necesita un nuevo campo de la tabla, agregarlo

    @Column(name = "CCOCR")
    private String centroCosto;

    @Id
    @Column(name = "CODREG")
    private String codigoRegion;

    @Column(name = "NOMREG")
    private String nombreRegion;
}
