/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.repository;

import hn.bancatlan.cierrecajaempresarial.entity.MCATRA;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.IMCATRA;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MCATRARepo extends JpaRepository<MCATRA, IMCATRA> {

    @Query("SELECT c.TRAESC FROM MCATRA c WHERE c.TRACOD = :transaccion")
    public String getEstadoTransaccion(@Param("transaccion") String transaccion);
    
    @Query("SELECT c.TRATIP FROM MCATRA c WHERE c.TRACOD = :transaccion")
    public String getTipoTransaccion(@Param("transaccion") String transaccion);
}
