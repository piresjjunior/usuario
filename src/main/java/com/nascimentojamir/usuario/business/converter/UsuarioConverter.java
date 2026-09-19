package com.nascimentojamir.usuario.business.converter;

import com.nascimentojamir.usuario.business.dto.EnderecoDTO;
import com.nascimentojamir.usuario.business.dto.TelefoneDTO;
import com.nascimentojamir.usuario.business.dto.UsuarioDTO;
import com.nascimentojamir.usuario.infrastucture.entity.Endereco;
import com.nascimentojamir.usuario.infrastucture.entity.Telefone;
import com.nascimentojamir.usuario.infrastucture.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioConverter {

    public Usuario paraUsuario(UsuarioDTO usuarioDTO){
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEndereco(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefones(usuarioDTO.getTelefones()))
                .build();
    }

    public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecoDTOS){
        List<Endereco> enderecos = new ArrayList<>();
        for(EnderecoDTO EnderecoDTO : enderecoDTOS){
            enderecos.add(paraEndereco(EnderecoDTO));
        }
        return enderecos;
    }

    public Endereco paraEndereco(EnderecoDTO EnderecoDTO){
        return Endereco.builder()
                .rua(EnderecoDTO.getRua())
                .numero(EnderecoDTO.getNumero())
                .cidade(EnderecoDTO.getCidade())
                .complemento(EnderecoDTO.getComplemento())
                .cep(EnderecoDTO.getCep())
                .estado(EnderecoDTO.getEstado())
                .build();
    }

    public List<Telefone> paraListaTelefones(List<TelefoneDTO>telefoneDTOS){
        return telefoneDTOS.stream().map(this::paraTelefone).toList();
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO){
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

    public UsuarioDTO paraUsuarioDTO(Usuario usuarioDTO){
        return UsuarioDTO.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEnderecoDTO(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefonesDTO(usuarioDTO.getTelefones()))
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecoDTOS){
        List<EnderecoDTO> enderecos = new ArrayList<>();
        for(Endereco EnderecoDTO : enderecoDTOS){
            enderecos.add(paraEnderecoDTO(EnderecoDTO));
        }
        return enderecos;
    }

    public EnderecoDTO paraEnderecoDTO(Endereco EnderecoDTO){
        return EnderecoDTO.builder()
                .rua(EnderecoDTO.getRua())
                .numero(EnderecoDTO.getNumero())
                .cidade(EnderecoDTO.getCidade())
                .complemento(EnderecoDTO.getComplemento())
                .cep(EnderecoDTO.getCep())
                .estado(EnderecoDTO.getEstado())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefonesDTO(List<Telefone>telefoneDTOS){
        return telefoneDTOS.stream().map(this::paraTelefoneDTO).toList();
    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefoneDTO){
        return TelefoneDTO.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

}
