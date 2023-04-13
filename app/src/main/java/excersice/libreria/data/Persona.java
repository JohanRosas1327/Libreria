package excersice.libreria.data;

public class Persona {
    private int idPersona;
    private String nombrePersona;
    private String passwordPersona;

    public Persona(int idPersona, String nombrePersona, String passwordPersona) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.passwordPersona = passwordPersona;

    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getPasswordPersona() {
        return passwordPersona;
    }

    public void setPasswordPersona(String passwordPersona) {
        this.passwordPersona = passwordPersona;
    }
}
