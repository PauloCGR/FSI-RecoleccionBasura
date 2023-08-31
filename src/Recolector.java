import java.io.Serializable;
import java.sql.PreparedStatement;

public class Recolector {
    String nombre, basura, calificacion;

    public Recolector(String nombre, String basura, String calificacion) {
        this.nombre = nombre;
        this.basura = basura;
        this.calificacion = calificacion;
    }
    public int insertar(Conexion cnx)
    {
        try
        {
            String sql = "INSERT INTO recoltor (nombre, basura, calificacion)VALUES (?, ?, ?)";
            PreparedStatement ps = cnx.con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, basura);
            ps.setString(3, calificacion);
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
