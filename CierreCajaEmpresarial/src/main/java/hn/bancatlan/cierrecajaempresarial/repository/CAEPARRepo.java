/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.repository;

import hn.bancatlan.cierrecajaempresarial.entity.CAEPAR;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAEPAR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CAEPARRepo extends JpaRepository<CAEPAR, ICAEPAR>{
    @Query("SELECT c FROM CAEPAR c WHERE c.PARNUM = 1")
    public CAEPAR getParametros();
}
