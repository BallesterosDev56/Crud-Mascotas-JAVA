package CrudMascotas.modelo;

public class PersonaVO {
    private long personaId;
    private String personaNombre;
    private long personaCel;

    public PersonaVO(long personaId, String personaNombre, long personaCel) {
        this.personaId = personaId;
        this.personaNombre = personaNombre;
        this.personaCel = personaCel;

    }

    public long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(long personaId) {
        this.personaId = personaId;
    }

    public String getPersonaNombre() {
        return personaNombre;
    }

    public void setPersonaNombre(String personaNombre) {
        this.personaNombre = personaNombre;
    }

    public long getPersonaCel() {
        return personaCel;
    }

    public void setPersonaCel(long personaCel) {
        this.personaCel = personaCel;
    }

    @Override
    public String toString() {
        return
                "Id       : " + personaId + "         \n" +
                "Nombre   : " + personaNombre + "     \n" +
                "Celular  : " + personaCel + "        \n" +
                "----------------------------------------------------\n";
    }
}

