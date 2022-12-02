public class App {
    public static void main(String[] args) throws Exception {

        int[] SAT_Scores = new int[]{1450, 1330, 1360, 1570, 1210, 1390, 1440, 1120, 1280, 1520};
        System.out.print("Scores: ");
        for(int j : SAT_Scores){
            System.out.print(j+" ");
        }
        System.out.println();
        System.out.println("Mean: "+mean(SAT_Scores));
        System.out.println("S Dev: "+round(sdev(SAT_Scores)));
        double sdev = round(sdev(SAT_Scores));
        double mean = mean(SAT_Scores);
        System.out.print("Z-Scores: ");
        for(int k : SAT_Scores){
            System.out.print(round((k-mean)/sdev)+" ");
    }
}

    public static int sum(int[] a){
        int total = 0;
        for (int i : a){
            total += i;
        }
        return total;
        }
    
        public static double mean(int[] a){
            return (double)sum(a)/a.length;
    
        }
    
        public static double round(double num){
            return Math.round(num*100)/100.0;
        }
        
        public static double sdev(int[] a){
            double mean = mean(a);
            int lengthArray = a.length;
            double sum = 0.0;
            for (int i : a){
                sum += (Math.pow(i-mean, 2));
            }
            double sqrRoot = Math.sqrt(sum/lengthArray);
            
            return sqrRoot;
        }
    

}


