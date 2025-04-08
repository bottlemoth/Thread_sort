public class Merge {
    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if(a[i] <= b[j] ) {
                c[i + j] = a[i];
                i++;
            }else {
                c[j+i] = b[j];
                j++;
            }

        }
        while (i < a.length) {
            c[i + j] = a[i];
            i++;
        }

        while (j < b.length) {
            c[i + j] = b[j];
            j++;
        }
        return c;
    }
}
