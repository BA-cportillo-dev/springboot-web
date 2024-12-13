package hn.bancatlan.cierrecajaempresarial.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.bancatlan.cierrecajaempresarial.entity.CAETRHF;
import hn.bancatlan.cierrecajaempresarial.entity.indexes.ICAETHF;

@Repository
public interface CAETRHFRepo extends JpaRepository<CAETRHF, ICAETHF>{

}
