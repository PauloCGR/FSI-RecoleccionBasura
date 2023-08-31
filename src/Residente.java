import java.io.Serializable;
import java.sql.PreparedStatement;

public class Residente implements Serializable
{ 
    String nombre, domicilio, residencia;

    public Residente(String nombre, String domicilio, String residencia) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.residencia = residencia;
    }
    
    public int insertar(Conexion cnx)
    {
        try
        {
            String sql = "INSERT INTO alumnos VALUES (?, ?, ?)";
            PreparedStatement ps = cnx.con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, domicilio);
            ps.setString(3, residencia);
            int resp = ps.executeUpdate();
            return resp;
        }
        catch (Exception e) 
        {
            System.out.println("Error:"+e.getMessage());
            return 0;
        }

    }

}