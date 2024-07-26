package com.example.appkio;

public class DescripcionArbol {
    private TipodeArbol problReforestar;
    private String descripcion;
    private String diametro;

    public DescripcionArbol(TipodeArbol problReforestar, String descripcion, String diametro) {
        this.problReforestar = problReforestar;
        this.descripcion = descripcion;
        this.diametro = diametro;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipodeArbol getProblReforestar() {
        return problReforestar;
    }
    public void setProblReforestar(TipodeArbol problReforestar) {
        this.problReforestar = problReforestar;
    }
    public String getDiametro() {
        return diametro;
    }
    public void setDiametro(String diametro) {
        this.diametro = diametro;
    }
    @Override
    public String toString(){
        return problReforestar.getNombre()+"\n Descripcion"+descripcion+"\n Diametro"+diametro;
    }

}
