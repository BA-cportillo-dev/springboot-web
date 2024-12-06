/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hn.bancatlan.cierrecajaempresarial.repository;

import hn.bancatlan.cierrecajaempresarial.entity.CAEMON;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAEMON;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface CAEMONRepo extends JpaRepository<CAEMON, ICAEMON> {
    @Query(value = "SELECT * FROM CAEDTA.CAEMON WHERE MONEST = 'A'", nativeQuery = true)
    public ArrayList<CAEMON> getMoneda();

    List<CAEMON> findByMONEST(String mONEST);
}
