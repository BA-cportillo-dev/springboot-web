package hn.bancatlan.cierrecajaempresarial.utils.requests_cierre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hn.bancatlan.cierrecajaempresarial.utils.commons.InformacionCierre;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeticionBaseCierre {

    String fechaProcesamientoCierre;
    String codigoPeticionUnica;
    String codigoTransaccion;
    String codigoAplicacion;
    String codigoEmpresa;
    String codigoInstitucion;
    String codigoPais;
    String codigoRegion;
    String codigoBanco;
    String codigoAgencia;
    String codigoSucursal;
    String codigoCanal;
    String usuarioPeticion;
    String direccionIp;
    String codigoCoreBanking;
    String usuarioEjecucionCierre;
    @JsonIgnore
    String codigoStatus = "0";
    @JsonIgnore
    String idCierreDiario = "0";
    @JsonIgnore
    LocalTime tiempoInicio;
    @JsonIgnore
    InformacionCierre infoResponse;
    List<?> parametroAdicionalColeccion;
    PeticionEspecificaCierre peticionEspecificaCierre;
}
