package main.vo;

/**
 *
 * @author Sergio Ramos
 *
 */
public class PaisVO {
    /**
     *
     */
    private int id;

    /**
     *
     */
    private String nombre;

    /**
     *
     */
    private String status;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param nuevoID
     *            the id to set
     */
    public void setId(final int nuevoID) {
        this.id = nuevoID;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nuevoNombre
     *            the nombre to set
     */
    public void setNombre(final String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param nuevoStatus
     *            the status to set
     */
    public void setStatus(final String nuevoStatus) {
        this.status = nuevoStatus;
    }

}
