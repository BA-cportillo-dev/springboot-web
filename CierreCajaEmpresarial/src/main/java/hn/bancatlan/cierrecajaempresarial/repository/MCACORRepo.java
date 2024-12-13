/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.repository;

import hn.bancatlan.cierrecajaempresarial.entity.MCACOR;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.IMCACOR;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MCACORRepo extends JpaRepository<MCACOR, IMCACOR> {

    @Query(value = "SELECT c.CORNUM FROM MCADTA.MCACOR c WHERE c.CORAPL = '2179'", nativeQuery = true)
    public BigDecimal getCorrelativo();
}
