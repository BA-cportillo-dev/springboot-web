/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.repository;

import hn.bancatlan.cierrecajaempresarial.entity.CAECIE;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAECIE;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CAECIERepo extends JpaRepository<CAECIE, ICAECIE>{
    
    @Query("SELECT c FROM CAECIE c WHERE c.CIEFEC = :fecha AND c.CIEPOC < 100")
    public CAECIE getExiste(@Param("fecha") String fecha);
    
    @Query("SELECT c FROM CAECIE c WHERE c.CIENUM = :numeroCierre")
    public Optional<CAECIE> getCierreExiste(@Param("numeroCierre") BigDecimal numeroCierre);
}
