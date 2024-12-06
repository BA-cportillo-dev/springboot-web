/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.repository;

import hn.bancatlan.cierrecajaempresarial.entity.CAETRDC;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAETRDC;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CAETRDCRepo extends JpaRepository<CAETRDC, ICAETRDC> {
    @Query("SELECT SUM(c.TRDCMO) FROM CAETRDC c WHERE c.TRDNUM = :numTransaccion "
            + "AND c.TRDCNU = :numConcepto AND c.TRDCOP = '+'")
    public BigDecimal getSumaConceptos(@Param("numTransaccion") BigDecimal numTransaccion,
                                   @Param("numConcepto") BigDecimal numConcepto);

    @Query("SELECT c FROM CAETRDC c WHERE c.TRDNUM IN :numerosDiarios")
    List<CAETRDC> getDiarioC(@Param("numerosDiarios") List<BigDecimal> numerosDiarios);
}
