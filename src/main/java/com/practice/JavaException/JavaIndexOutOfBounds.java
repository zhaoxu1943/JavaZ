package com.practice.JavaException;

/**
 * 数组下标越界
 * @author zhaoxu
 * @className JavaIndexOutOfBounds
 * @projectName JavaConcentration
 * @date 2020/7/24 10:01
 */
public class JavaIndexOutOfBounds {

    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4,2,23,2,32,1};
//        testArrayException(arr,-2);

        testException();
    }


    /**
     * 数组下标越界抛出有用信息
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private static void testArrayException(int[] arr,int index) {
        if (index<0){
            throw  new IllegalArgumentException("数组下标不能小于0");
        }
        if (index>arr.length-1) {
            int upperBound = arr.length-1;
            int lowerBound = 0;
            throw new ArrayIndexOutOfBoundsException("array下界为"+lowerBound+",array上界为"
                    +upperBound+",越界下标为"+index);
        }else {
            System.out.println(arr[index]);
        }


    }


    private void testCheckedException() throws NoSuchMethodException {
        Class clazz = JavaIndexOutOfBounds.class;
        clazz.getMethod("test");
    }


    private static void testException()  {
        int[] array = new int[]{1,2,2,2,12};
        try{
            int i = 0;
            while(true){
                System.out.println(array[i++]);}
            }catch(ArrayIndexOutOfBoundsException e){
            }
        }



}
