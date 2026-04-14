package com.cmsysadm.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usu_usuarios")
public class Usuario {

    @Id
    @Column(name = "UsuRut")
    private Integer usuRut;

    @Column(name = "UsuDv", nullable = false, length = 1)
    private String usuDv;

    @Column(name = "UsuNombres", nullable = false, length = 30)
    private String usuNombres;

    @Column(name = "UsuAPaterno", nullable = false, length = 20)
    private String usuAPaterno;

    @Column(name = "UsuAMaterno", length = 20)
    private String usuAMaterno;

    @Column(name = "UsuUsuario", nullable = false, unique = true, length = 20)
    private String usuUsuario;

    @Column(name = "UsuClave", nullable = false, columnDefinition = "TEXT")
    private String usuClave;

    @Column(name = "CodEstado", nullable = false)
    private Integer codEstado = 0;

    @Column(name = "CodTipoUsuario", nullable = false)
    private Integer codTipoUsuario;

    @Column(name = "FecVigencia")
    private LocalDateTime fecVigencia;

    @Column(name = "UsuEmail", nullable = false, length = 30)
    private String usuEmail;

    @Column(name = "UsuAvatar", length = 150)
    private String usuAvatar;

    @Column(name = "FecIngReg", nullable = false)
    private LocalDateTime fecIngReg;

    @Column(name = "UsuIngReg", nullable = false, length = 20)
    private String usuIngReg;

    @Column(name = "FunIngReg", nullable = false, length = 20)
    private String funIngReg;

    @Column(name = "FecModreg", nullable = false)
    private LocalDateTime fecModreg;

    @Column(name = "UsuModreg", nullable = false, length = 20)
    private String usuModreg;

    @Column(name = "FunModReg", nullable = false, length = 20)
    private String funModReg;

    // Getters y Setters
    public Integer getUsuRut() { return usuRut; }
    public void setUsuRut(Integer usuRut) { this.usuRut = usuRut; }

    public String getUsuDv() { return usuDv; }
    public void setUsuDv(String usuDv) { this.usuDv = usuDv; }

    public String getUsuNombres() { return usuNombres; }
    public void setUsuNombres(String usuNombres) { this.usuNombres = usuNombres; }

    public String getUsuAPaterno() { return usuAPaterno; }
    public void setUsuAPaterno(String usuAPaterno) { this.usuAPaterno = usuAPaterno; }

    public String getUsuAMaterno() { return usuAMaterno; }
    public void setUsuAMaterno(String usuAMaterno) { this.usuAMaterno = usuAMaterno; }

    public String getUsuUsuario() { return usuUsuario; }
    public void setUsuUsuario(String usuUsuario) { this.usuUsuario = usuUsuario; }

    public String getUsuClave() { return usuClave; }
    public void setUsuClave(String usuClave) { this.usuClave = usuClave; }

    public Integer getCodEstado() { return codEstado; }
    public void setCodEstado(Integer codEstado) { this.codEstado = codEstado; }

    public Integer getCodTipoUsuario() { return codTipoUsuario; }
    public void setCodTipoUsuario(Integer codTipoUsuario) { this.codTipoUsuario = codTipoUsuario; }

    public LocalDateTime getFecVigencia() { return fecVigencia; }
    public void setFecVigencia(LocalDateTime fecVigencia) { this.fecVigencia = fecVigencia; }

    public String getUsuEmail() { return usuEmail; }
    public void setUsuEmail(String usuEmail) { this.usuEmail = usuEmail; }

    public String getUsuAvatar() { return usuAvatar; }
    public void setUsuAvatar(String usuAvatar) { this.usuAvatar = usuAvatar; }

    public LocalDateTime getFecIngReg() { return fecIngReg; }
    public void setFecIngReg(LocalDateTime fecIngReg) { this.fecIngReg = fecIngReg; }

    public String getUsuIngReg() { return usuIngReg; }
    public void setUsuIngReg(String usuIngReg) { this.usuIngReg = usuIngReg; }

    public String getFunIngReg() { return funIngReg; }
    public void setFunIngReg(String funIngReg) { this.funIngReg = funIngReg; }

    public LocalDateTime getFecModreg() { return fecModreg; }
    public void setFecModreg(LocalDateTime fecModreg) { this.fecModreg = fecModreg; }

    public String getUsuModreg() { return usuModreg; }
    public void setUsuModreg(String usuModreg) { this.usuModreg = usuModreg; }

    public String getFunModReg() { return funModReg; }
    public void setFunModReg(String funModReg) { this.funModReg = funModReg; }
}