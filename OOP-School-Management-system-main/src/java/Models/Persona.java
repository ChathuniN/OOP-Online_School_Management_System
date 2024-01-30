
package Models;

public class Persona {
    int id;
    String dni;
    String nom;
    String photo;

    public Persona() {
    }

    public Persona(String dni, String nom, String photo) {
        this.dni = dni;
        this.nom = nom;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

  
    
}
