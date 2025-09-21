package dao;

import models.*;
import java.util.HashMap;
import java.util.Map;

public class InMemoryDB {
    public final Map<Integer, Evento> eventos = new HashMap<>();
    public final Map<Integer, Usuario> usuarios = new HashMap<>();
    public final Map<Integer, Inscripcion> inscripciones = new HashMap<>();
    public final Map<Integer, Certificado> certificados = new HashMap<>();

    public Evento save(Evento e){ eventos.put(e.getId(), e); return e; }
    public Usuario save(Usuario u){ usuarios.put(u.getId(), u); return u; }
    public Inscripcion save(Inscripcion i){ inscripciones.put(i.getId(), i); return i; }
    public Certificado save(Certificado c){ certificados.put(c.getId(), c); return c; }
}
