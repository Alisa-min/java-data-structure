package LessonPaixu4;

import java.util.Arrays;

public class PaiXu4 {

    private static void mergeDate(int[] array,int left,int mid,int right,int[] temp){
        int index=left;
        int begin1=left,end1=mid,begin2=mid,end2=right;
        while(begin1<end1&&begin2<end2){
            if (array[begin1] <= array[begin2]) {
                temp[index++]=array[begin1++];
            }
            temp[index++]=array[begin2++];
        }
        while(begin1<end1){
            temp[index++]=array[begin1++];
        }
        while (begin2<end2){
            temp[index++]=array[begin2++];
        }
    }
    private static void mergeSort(int[] array,int left,int right,int[] temp ){
        if (right-left>1){
            int mid=left+((right-left)>>1);

            mergeSort(array,left,right,temp);

            mergeSort(array,mid,right,temp);

            mergeDate(array,left,mid,right,temp);



            System.arraycopy(temp,left,array,left,right-left);
        }
    }
    public static void mergeSort(int[] array){
        int[] temp=new int[array.length];
        mergeSort(array,0,array.length,temp);
    }

    public static void mergeSortNor(int[] array){
        int[] temp=new int[array.length];
        int gap=1;
        while (gap<array.length){
            for (int i=0;i<array.length;i+=gap*2){
                int left=i;
                int mid=left+gap;
                int right=mid+gap;
                if (mid>array.length){
                    mid=array.length;
                }
                if (right>array.length){
                    right=array.length;
                }
                mergeDate(array,left,mid,right,temp);
            }
            System.arraycopy(temp,0,array,0,array.length);
        }
    }
    public static void countSort(int[] array){
        int minValue=array[0];
        int maxValue=array[0];
        for (int i=1;i<=array.length;++i){
            if (array[i]>maxValue){
                maxValue=array[i];
            }
            if (array[i]<minValue){
                minValue=array[i];
            }
        }
        int range=maxValue-minValue+1;
        int[] arrayCount=new int[range];

        for (int i=0;i<array.length;++i){
            arrayCount[array[i]-minValue]++;

        }

        int index=0;
        for (int i=0;i<range;++i){
            while (arrayCount[i]-- !=0){
                array[index++]=i+minValue;

            }
        }
    }


    public static void main(String[] args) {
        int[] array={2,4,5,6,2,2,1,3,1,0,8,1,3,9,7};
       mergeSortNor(array);
        countSort(array);


    }

}
