/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.repository;

import hn.bancatlan.cierrecajaempresarial.entity.MCAMCP;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.IMCAMCP;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MCAMCPRepo extends JpaRepository<MCAMCP, IMCAMCP> {

    @Query("SELECT c FROM MCAMCP c WHERE c.APLCOD = '2179' AND c.TRACOD = :transaccion "
            + "AND c.CANCOD = :canal AND c.MONCOD = :moneda AND c.MCPAR1 = :argumento1 "
            + "AND c.MCPAR2 = :argumento2 AND c.MCPAR3 = :argumento3")
    public MCAMCP getRegistro(@Param("transaccion") String transaccion,
            @Param("canal") String canal,
            @Param("moneda") String moneda,
            @Param("argumento1") String argumento1,
            @Param("argumento2") String argumento2,
            @Param("argumento3") String argumento3);
}
