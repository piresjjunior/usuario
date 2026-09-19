package com.nascimentojamir.usuario.business;

import com.nascimentojamir.usuario.business.converter.UsuarioConverter;
import com.nascimentojamir.usuario.business.dto.UsuarioDTO;
import com.nascimentojamir.usuario.infrastucture.entity.Usuario;
import com.nascimentojamir.usuario.infrastucture.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository UsuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(
                UsuarioRepository.save(usuario)
        );
    }

}
