import org.junit.Test;

public class QuickSortTest {

    @Test
    public void testQuickSort() throws Exception {
        QuickSort mySort = new QuickSort();
        int[] testArray = {2, 5, 4, 3, 6, 4, 2, 8, 1, 12};

        mySort.quickSort(testArray);

        for (int i =0; i< testArray.length; i++ ){
            System.out.print(testArray[i]+ " ");
        }
    }

    @Test
    public void testQuickSelect() throws Exception {
        QuickSelect quickSelect = new QuickSelect();

        int[] testArray = {2, 5, 4, 3, 6, 4, 2, 8, 1, 12};

        System.out.println(quickSelect.findKSmallest(5, testArray));

        for (int i =0; i< testArray.length; i++ ){
            System.out.print(testArray[i]+ " ");
        }
    }


}
