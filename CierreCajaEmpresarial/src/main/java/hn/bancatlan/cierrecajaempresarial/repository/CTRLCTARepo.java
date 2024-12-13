package hn.bancatlan.cierrecajaempresarial.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import hn.bancatlan.cierrecajaempresarial.entity.CTRLCTA;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICTRLCTA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CTRLCTARepo extends JpaRepository<CTRLCTA, ICTRLCTA> {

    @Query("SELECT c FROM CTRLCTA c WHERE c.codigoAplicacion = :appID AND c.tipoCuenta = :tipo ")
    public Optional<CTRLCTA> getCuentasCierre(@Param("appID") BigDecimal appId, @Param("tipo") BigDecimal tipo);

}
