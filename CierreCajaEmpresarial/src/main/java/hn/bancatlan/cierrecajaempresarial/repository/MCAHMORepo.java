/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.repository;

import hn.bancatlan.cierrecajaempresarial.entity.MCAHMO;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.IMCAHMO;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MCAHMORepo extends JpaRepository<MCAHMO, IMCAHMO> {

    @Query("SELECT c FROM MCAHMO c WHERE c.HMONUM = :secuencia AND c.HMOMOV = :movimiento "
            + "AND c.HMOCOR = :correlativo")
    public MCAHMO getExiste(@Param("secuencia") BigDecimal secuencia,
            @Param("movimiento") String movimiento,
            @Param("correlativo") BigDecimal correlativo);
}
