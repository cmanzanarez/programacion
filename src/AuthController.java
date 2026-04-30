public class AuthController {

    private AuthModel modelo;

    public AuthController() {

        modelo = new AuthModel();

    }

    public void registrar(
            String usuario,
            String contrasena,
            String email
    ) {

        modelo.registro(usuario, contrasena, email);

    }

    public void abrirRegistro() {

        new RegisterView(this);

    }

}