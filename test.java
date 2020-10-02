
///Implement Assembly line scheduling algorithm 
class test
{ 
    static int NUM_LINE = 2; 
    static int NUM_STATION = 15; 
    static int min(int a, int b)  
    {  
        return a < b ? a : b;  
          
    } 
      
    static int Assembly(int a[][], int t[][], int e[], int x[]) 
    { 
        int T1[]= new int [NUM_STATION]; 
        int T2[] =new int[NUM_STATION] ; 
        int i; 
        T1[0] = e[0] + a[0][0];  
        T2[0] = e[1] + a[1][0]; 
        for (i = 1; i < NUM_STATION; ++i) 
        { 
            T1[i] = min(T1[i - 1] + a[0][i],  
                    T2[i - 1] + t[1][i] + a[0][i]); 
            //System.out.println(T1[i]);
            T2[i] = min(T2[i - 1] + a[1][i],  
                    T1[i - 1] + t[0][i] + a[1][i]); 
            //System.out.println(T2[i]);
        } 
        return min(T1[NUM_STATION-1] + x[0],  
                    T2[NUM_STATION-1] + x[1]); 
    } 
    
    public static void main (String[] args)  
    { 
        int a[][] = {{7, 14, 8, 9,13,9,8,15,7,5,9,8,6,9,12}, 
                    {13,10,11,9,10,12,14,11,8,6,5,7,5,10,13}}; 
        int t[][] = {{0,5,8,6,5,9,5,8,8,9,5,6,7,8,10}, 
                    {0,7,6,7,5,6,7,6,5,4,7,5,8,8,6}}; 
        int e[] = {7, 9}, x[] = {5, 6}; 
      
        System.out.println(Assembly(a, t, e, x));     
      
    } 
}

