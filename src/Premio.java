class Premio {
    int numero;
    int serie;
    String provincia;
    int año;

    public Premio(int numero, int serie, String provincia, int año) {
        this.numero = numero;
        this.serie = serie;
        this.provincia = provincia;
        this.año = año;
    }

    @Override
    public String toString() {
        return "Número: " + numero + ", Serie: " + serie + ", Provincia: " + provincia + ", Año: " + año;
    }
}