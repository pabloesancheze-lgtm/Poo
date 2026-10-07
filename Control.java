import java.util.Scanner;

public class Control {
    
    public void iniciarPartida() {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int T = scanner.nextInt(); 
        
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            
            char[][] mapa = new char[N][M];
            for (int i = 0; i < N; i++) {
                mapa[i] = scanner.next().toCharArray();
            }
            
            Boveda boveda = new Boveda(N, M, mapa);
            resolverLaberinto(boveda);
        }
    }

    private void resolverLaberinto(Boveda boveda) {
        int[] movFila = {-1, 1, 0, 0}; 
        int[] movCol  = {0, 0, -1, 1}; 
        
        int filas = boveda.getFilas();
        int columnas = boveda.getColumnas();
        
        int totalCeldas = filas * columnas;
        int[][] cola = new int[totalCeldas][3]; 
        
        int cabeza = 0;
        int finalCola = 0;
        
        boolean[][] visitado = new boolean[filas][columnas];
        
        cola[finalCola][0] = boveda.getInicioFila(); 
        cola[finalCola][1] = boveda.getInicioCol();   
        cola[finalCola][2] = 0;                      
        finalCola++;                                 
        
        visitado[boveda.getInicioFila()][boveda.getInicioCol()] = true;
        
        boolean pudoEscapar = false;

        while (cabeza < finalCola) {
            
            int filaActual = cola[cabeza][0];
            int colActual = cola[cabeza][1];
            int movimientos = cola[cabeza][2];
            cabeza++; 
            
            if (boveda.esSalida(filaActual, colActual)) {
                System.out.println(movimientos);
                pudoEscapar = true;
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nuevaFila = filaActual + movFila[i];
                int nuevaCol = colActual + movCol[i];
                
                if (!boveda.esPared(nuevaFila, nuevaCol) && !visitado[nuevaFila][nuevaCol]) {
                    visitado[nuevaFila][nuevaCol] = true;
                    
                    cola[finalCola][0] = nuevaFila;
                    cola[finalCola][1] = nuevaCol;
                    cola[finalCola][2] = movimientos + 1;
                    finalCola++; 
                }
            }
        }
        
        if (!pudoEscapar) {
            System.out.println("NO");
        }
    }
}