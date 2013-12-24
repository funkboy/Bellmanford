/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bellmanford;

/**
 *
 * @author Liu Fan
 */
public class BellmanFord {

    static int[][][] distance =new int[1][][];
    static int max=Integer.MAX_VALUE;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int origin[][] = {{0, 2, max, 4, max, max, max, max, max},
            {2, 0, 15, 1, 13, max, max, max, max},
            {max, 15, 0, max, 3, 7, max, max, max},
            {4, 1, max, 0, 10, max, 1, max, max},
            {max, 13, 3, 10, 0, 2, 8, 6, max},
            {max, max, 7, max, 2, 0, max, 4, 1},
            {max, max, max, 1, 8, max, 0, 3, max},
            {max, max, max, max, 6, 4, 3, 0, 2},
            {max, max, max, max, max, 1, max, 2, 0},};
        
//        for(int i=0;i<8;i++){
//        Distance(i,origin);
//        System.out.println();
//        System.out.println();
//            for(int j=0;j<distance[i].length;j++){
//                System.out.println();
//                for(int k=0;k<distance[i].length;k++){
//                    System.out.print(distance[i][j][k]+"\t");
//                }
//            }
//        }
        
        int m=origin.length-1;
        Distance(m,origin);
        int [][] shortest= origin;
        for(int n=0;n<m+1;n++){
            
            System.out.println();
            System.out.println();
            System.out.println();
        for (int j = 0; j < distance[n].length; j++) {
            System.out.println();
            for (int k = 0; k < distance[n].length; k++) {
                System.out.print(distance[n][j][k] + "\t");
                if(distance[n][j][k]<shortest[j][k]){
                    shortest[j][k]=distance[n][j][k];
                }
            }
        }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        for (int j = 0; j < shortest.length; j++) {
            System.out.println();
            for (int k = 0; k < shortest.length; k++) {
                System.out.print(shortest[j][k] + "\t");                
            }
        }
        
    }
    
    
    
    public static void Distance(int n, int[][] origin){       
        if (n > 0) {
            Distance(n - 1, origin);
            int nodes = origin.length;
            int[][] dis = new int[nodes][nodes];
            for (int i = 0; i < nodes; i++) {
                for (int j = i + 1; j < nodes; j++) {
                    int min = max;
                    int term = 0;
                    for (int k = 0; k < nodes; k++) {
                        if (i == k || j == k) {
                            continue;
                        }
                        if(origin[i][k]==max||distance[n-1][k][j]==max){
                            term=max;
                        }else{
                        term = origin[i][k] + distance[n - 1][k][j];                        
                        }if (term < min) {
                            min = term;
                        }
                    }
                    dis[i][j] = min;
                    dis[j][i] = min;
                }
            }
            int[][][] newDis = new int[distance.length + 1][nodes][nodes];
            for (int i = 0; i < distance.length; i++) {
                newDis[i] = distance[i];
            }
            newDis[distance.length] = dis;
            distance = newDis;
        } else {
            distance[0] = origin;
        }
        
    }
}
