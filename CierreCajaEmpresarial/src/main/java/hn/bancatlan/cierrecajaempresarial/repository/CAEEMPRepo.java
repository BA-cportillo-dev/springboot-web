/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.repository;

import hn.bancatlan.cierrecajaempresarial.entity.CAEEMP;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAEEMP;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CAEEMPRepo extends JpaRepository<CAEEMP, ICAEEMP> {
    @Query("SELECT c FROM CAEEMP c WHERE c.EMPNUM = :numEmpresa")
    public CAEEMP getEmpresa(@Param("numEmpresa") BigDecimal numEmpresa);
}
