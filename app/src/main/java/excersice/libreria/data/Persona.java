package excersice.libreria.data;

import android.content.ContentValues;
import android.database.Cursor;
import static excersice.libreria.data.PersonaContract.PersonaEntry;

public class Persona {
    private int idPersona;
    private String nombrePersona;
    private String passwordPersona;

    public Persona(int idPersona, String nombrePersona, String passwordPersona) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.passwordPersona = passwordPersona;
    }

    public Persona(Cursor cursor) {
        idPersona = cursor.getInt(cursor.getColumnIndex(PersonaEntry.ID));
        nombrePersona = cursor.getString(cursor.getColumnIndex(PersonaEntry.NAME));
        passwordPersona = cursor.getString(cursor.getColumnIndex(PersonaEntry.PASSWORD));
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(PersonaEntry.ID, idPersona);
        values.put(PersonaEntry.NAME, nombrePersona);
        values.put(PersonaEntry.PASSWORD, passwordPersona);
        return values;
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
