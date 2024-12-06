package hn.bancatlan.cierrecajaempresarial.utils.requests_cierre;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PeticionEspecificaCierre {

    public PeticionEspecificaCierre(String fechaCierre, int accion) {
        this.fechaCierre = fechaCierre;
        this.accion = accion;
    }

    String fechaCierre;

    int accion;

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setAccion(int accion) {
        this.accion = accion;
    }

    public int getAccion() {
        return accion;
    }
}
