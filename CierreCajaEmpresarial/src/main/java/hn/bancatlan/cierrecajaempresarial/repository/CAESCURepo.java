/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.repository;

import hn.bancatlan.cierrecajaempresarial.entity.CAECIE;
import hn.bancatlan.cierrecajaempresarial.entity.CAESCU;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAESCU;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CAESCURepo extends JpaRepository<CAESCU, ICAESCU>{
    
    @Query("SELECT c FROM CAESCU c WHERE c.EMPNUM = :numEmpresa AND c.SERNUM = :numServicio AND c.MONCOD = :moneda")
    public CAESCU getSucursal(@Param("numEmpresa") BigDecimal numEmpresa,
            @Param("numServicio") BigDecimal numServicio,
            @Param("moneda") String moneda);

}
