package hn.bancatlan.cierrecajaempresarial.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.bancatlan.cierrecajaempresarial.entity.CAETRHC;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAETRHC;

@Repository
public interface CAETRHCRepo extends JpaRepository<CAETRHC, ICAETRHC> {

}
