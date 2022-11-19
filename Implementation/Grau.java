public enum Grau
{
    F(4),
    M(7),
    D(10);

    private int grau;

    public int getGrau()
    {
        return this.grau;
    }

    Grau(int grau)
    {
        this.grau = grau;
    }
}
