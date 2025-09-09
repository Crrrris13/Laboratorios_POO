public class Ficha {
    private String valor;
    private boolean descubierta;
    private boolean emparejada;

    public Ficha(String valor) {
        this.valor = valor;
        this.descubierta = false;
        this.emparejada = false;
    }

    public String getValor() {
        return this.valor;
    }

    public boolean estaDescubierta() {
        return this.descubierta;
    }

    public boolean estaEmparejada() {
        return this.emparejada;
    }

    public Ficha descubrir() {
        this.descubierta = true;
        return this;
    }

    public Ficha ocultar() {
        if (!emparejada) {
            this.descubierta = false;
        }
        return this;
    }

    public Ficha emparejar() {
        this.emparejada = true;
        return this;
    }

    @Override
    public String toString() {
        if (emparejada) return " ";
        if (descubierta) return valor;
        return "*";
    }
}
