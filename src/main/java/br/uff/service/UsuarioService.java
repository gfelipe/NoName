package br.uff.service;

import br.uff.model.Usuario;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UsuarioService {

    public Usuario makeUser(Usuario usuario) {

        Usuario usuarioParaSalvar = new Usuario();
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update(usuario.getSenha().getBytes());
        String hashedString = new String(messageDigest.digest());

        usuarioParaSalvar.setMatricula(usuario.getMatricula());
        usuarioParaSalvar.setNome(usuario.getNome());
        usuarioParaSalvar.setSenha(hashedString);
        usuarioParaSalvar.setEmail(usuario.getEmail());
        usuarioParaSalvar.setAprovacaoPendente(true);
        return usuarioParaSalvar;
    }
}
