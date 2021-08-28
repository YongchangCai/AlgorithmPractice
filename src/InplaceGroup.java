public class InplaceGroup {

    public void group(int[] arr, int target) {
        int smallPivit = 0;
        int largePivit = arr.length - 1;
        int i = 0;
        while (i >= largePivit) {
            if (arr[i] > target) {
                swap(arr, i, largePivit--);
            }
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}