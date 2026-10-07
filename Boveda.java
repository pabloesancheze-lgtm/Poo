public class Boveda {
    private char[][] mapa;
    private int filas;
    private int columnas;
    private int inicioFila;
    private int inicioCol;

    public Boveda(int filas, int columnas, char[][] mapa) {
        this.filas = filas;
        this.columnas = columnas;
        this.mapa = mapa;
        buscarLupin();
    }

    private void buscarLupin() {
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                if (mapa[f][c] == 'L') {
                    inicioFila = f;
                    inicioCol = c;
                }
            }
        }
    }

    public int getInicioFila() { return inicioFila; }
    public int getInicioCol() { return inicioCol; }
    public int getFilas() { return filas; }
    public int getColumnas() { return columnas; }

    public boolean esPared(int n, int m) {
        if (n < 0 || n >= filas || m < 0 || m >= columnas) {
            return true; 
        }
        return mapa[n][m] == '#'; 
    }

    public boolean esSalida(int n, int m) {
        if (n < 0 || n >= filas || m < 0 || m >= columnas) {
            return false; 
        }
        return mapa[n][m] == 'E';
    }
}