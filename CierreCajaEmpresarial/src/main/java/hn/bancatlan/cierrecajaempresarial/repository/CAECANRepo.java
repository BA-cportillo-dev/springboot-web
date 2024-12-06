/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.repository;

import hn.bancatlan.cierrecajaempresarial.entity.CAECAN;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAECAN;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CAECANRepo extends JpaRepository<CAECAN, ICAECAN> {
    @Query(value = "SELECT c FROM CAECAN c")
    public ArrayList<CAECAN> getCanales();
}
