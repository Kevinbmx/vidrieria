package dto;

public class Categoria {

    private int categoriaId;
    private String nombreCategoria;

    public Categoria() {
        ;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getCategoriaId() {
        return this.categoriaId;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getNombreCategoria() {
        return this.nombreCategoria;
    }

}
