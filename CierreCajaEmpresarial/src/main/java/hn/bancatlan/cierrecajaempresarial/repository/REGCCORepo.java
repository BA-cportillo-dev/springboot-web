package hn.bancatlan.cierrecajaempresarial.repository;

import hn.bancatlan.cierrecajaempresarial.entity.REGCCO;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface REGCCORepo extends JpaRepository<REGCCO, String> {

    @Query("SELECT s FROM REGCCO s WHERE s.codigoRegion = :codReg")
    public REGCCO getCentroCosto(@Param("codReg") String codReg);
}
