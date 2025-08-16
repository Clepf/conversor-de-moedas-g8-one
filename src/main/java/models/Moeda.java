package models;

public record Moeda(String codigo, String nome) {
    @Override
    public String toString() {
        return codigo + " – " + nome;
    }
}
