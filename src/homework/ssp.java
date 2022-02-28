package homework;

import java.util.Arrays;

public class ssp {
    public static int[] qui(int arr[] , int left ,int right){
        if (left < right){
            int part = par(arr,left,right);
            qui(arr,left,part-1);
            qui(arr,part+1,right);
        }
        return arr;
    }
    public static int par(int arr[],int left,int right){
        /*int prv = left;
        int index = prv + 1;
        for (int i = index;i <= right;i++){
            if (arr[i] < arr[prv]){
                swap(arr,i,index);
                left++;
            }
        }
        swap(arr,prv,index-1);
        return index-1;*/
        int f = left;
        int l = right;
        int prv = arr[left];
        boolean tf = true;
        while (f != l){
          if (arr[f] > arr[l] ){
                swap(arr,f,l);

            }
          if (tf){
              f++;
          }else {
              l--;
          }
          tf=!tf;
        }
        //swap(arr,prv,l);
        return l;
    }
    public static void swap(int arr[],int left,int right){
        int team = arr[left];
        arr[left] = arr[right];
        arr[right] = team;
    }

    public static void main(String[] args) {
        int[] arr= {4, 7,5,3,2,6,8,1};
        arr=qui(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
