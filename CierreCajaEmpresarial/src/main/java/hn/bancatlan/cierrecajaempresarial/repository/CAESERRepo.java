/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.repository;

import hn.bancatlan.cierrecajaempresarial.entity.CAESER;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAESER1;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CAESERRepo extends JpaRepository<CAESER, ICAESER1>{
    @Query(value = "SELECT * FROM CAEDTA.CAESER c ORDER BY c.EMPNUM ASC", nativeQuery = true)
    public ArrayList<CAESER> getServicios();
}
