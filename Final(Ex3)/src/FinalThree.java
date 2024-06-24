public class FinalThree {
    public static void main(String[] args) {
        int[][] myArray = {{5,10,15},{20,25,30},{35,40,45}};
        for (int i=0;i<myArray.length; i++){
            for (int j=0;j<myArray.length; j++){
                System.out.println(myArray[i][j]+" ");
            }
            System.out.println();
        }
    }
}
