public class Sequence {

    public static int[] filter(int[] array, ByCondition condition) {
        //определяем сколько элементов массива соответствуют условию, чтобы определить длину массива результата
        int resultArrayLength = 0;
        for (int i=0; i<array.length; i++) {
            if (condition.isOk(array[i])) {
                resultArrayLength++;
            };
        }

        //создаем массив результата и наполняем его
        int[] resultArray = new int[resultArrayLength];
        int j = 0;

	    for (int i=0; i<array.length; i++) {
           if (condition.isOk(array[i])) {
               resultArray[j] = array[i];
               j++;
           };
        }
        return resultArray;
    }
}
