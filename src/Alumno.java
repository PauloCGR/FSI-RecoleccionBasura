import java.io.Serializable;
import java.sql.PreparedStatement;

public class Alumno implements Serializable
{ 
    String TipoBasura, Basurero, Lugar, Ruta, DatosEmpleado;

    public Alumno(String TipoBasura, String Basurero, String Lugar, String Ruta, String DatosEmpleado) {
        this.TipoBasura = TipoBasura;
        this.Basurero = Basurero;
        this.Lugar = Lugar;
        this.Ruta = Ruta;
        this.DatosEmpleado = DatosEmpleado;
    }
    public int insertar(Conexion cnx)
    {
        try
        {
            String sql = "INSERT INTO datosbasura VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = cnx.con.prepareStatement(sql);
            ps.setString(1, TipoBasura);
            ps.setString(2, Basurero);
            ps.setString(3, Lugar);
            ps.setString(4, Ruta);
            ps.setString(5, DatosEmpleado);
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