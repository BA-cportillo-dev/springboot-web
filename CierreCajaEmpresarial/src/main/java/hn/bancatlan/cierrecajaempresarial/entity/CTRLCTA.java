package hn.bancatlan.cierrecajaempresarial.entity;

import lombok.Data;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICTRLCTA;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CTRLCTA")
@Table(name = "CTRLCTA", schema = "SRVDTA")
@IdClass(ICTRLCTA.class)
public class CTRLCTA { //Si necesita un nuevo campo de la tabla, agregarlo

    @Id
    @Column(name = "CTRLAPL")
    BigDecimal codigoAplicacion;

    @Id
    @Column(name = "CTRLTIP")
    BigDecimal tipoCuenta;

    @Column(name = "CTRLCCD")
    BigDecimal cuentaDetalle;

    @Column(name = "CTRLCCE")
    BigDecimal cuentaClearing;

    @Column(name = "CTRLCCL")
    BigDecimal cuentaControl;

    @Column(name = "CTRLCCO")
    BigDecimal cuentaComision;

    @Column(name = "CTRLCCT")
    BigDecimal cuentaContable;

    @Column(name = "CTRLDSC")
    String descripcionRecaudo;

}
