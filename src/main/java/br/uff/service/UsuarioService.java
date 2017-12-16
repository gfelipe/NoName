package br.uff.service;

import br.uff.model.Usuario;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UsuarioService {

    private String doHash(String senha) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update(senha.getBytes());
        return new String(messageDigest.digest());
    }

    public Usuario makeUser(Usuario usuario) {

        Usuario usuarioParaSalvar = new Usuario();

        usuarioParaSalvar.setMatricula(usuario.getMatricula());
        usuarioParaSalvar.setNome(usuario.getNome());
        usuarioParaSalvar.setSenha(this.doHash(usuario.getSenha()));
        usuarioParaSalvar.setEmail(usuario.getEmail());
        usuarioParaSalvar.setAprovacaoPendente(true);
        return usuarioParaSalvar;
    }

}