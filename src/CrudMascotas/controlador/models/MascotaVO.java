package CrudMascotas.controlador.models;

public class MascotaVO {
    private long ownerId;
    private String mascotaNombre;
    private String mascotaRaza;
    private String mascotaSexo;

    public MascotaVO(long ownerId, String mascotaNombre, String mascotaRaza, String mascotaSexo) {
        this.ownerId = ownerId;
        this.mascotaNombre = mascotaNombre;
        this.mascotaRaza = mascotaRaza;
        this.mascotaSexo = mascotaSexo;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public String getMascotaNombre() {
        return mascotaNombre;
    }

    public void setMascotaNombre(String mascotaNombre) {
        this.mascotaNombre = mascotaNombre;
    }

    public String getMascotaRaza() {
        return mascotaRaza;
    }

    public void setMascotaRaza(String mascotaRaza) {
        this.mascotaRaza = mascotaRaza;
    }

    public String getMascotaSexo() {
        return mascotaSexo;
    }

    public void setMascotaSexo(String mascotaSexo) {
        this.mascotaSexo = mascotaSexo;
    }

    @Override
    public String toString() {
        return "Mascota = {" +
                "\n    dueñoId : " + ownerId +
                "\n    nombre : " + mascotaNombre +
                "\n    raza : " + mascotaRaza +
                "\n    sexo : " + mascotaSexo +
                "\n}";
    }
}
