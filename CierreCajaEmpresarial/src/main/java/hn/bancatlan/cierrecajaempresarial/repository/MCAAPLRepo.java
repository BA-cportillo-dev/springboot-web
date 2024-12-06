/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.repository;

import hn.bancatlan.cierrecajaempresarial.entity.MCAAPL;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.IMCAAPL;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MCAAPLRepo extends JpaRepository<MCAAPL, IMCAAPL> {

    @Query(value = "SELECT c.APLEST FROM MCADTA.MCAAPL c WHERE c.APLCOD = '2179'", nativeQuery = true)
    public String getEstadoAplicativo();
}
