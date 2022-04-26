class InsertionSort {

    companion object {
        private var INSTANCE: InsertionSort? = null

        @get:Synchronized
        val instance: InsertionSort
            get() {
                if (INSTANCE == null) {
                    INSTANCE = InsertionSort()
                }
                return INSTANCE!!
            }
    }

    fun preformSort(arr: IntArray): IntArray {
        //check if array is empty or less than 2 elements
        if (arr.isEmpty() && arr.count() < 2) {
            return arr
        }
        for (count in 1 until arr.count()) {
            val item = arr[count]
            var i = count
            while (i > 0 && item < arr[i - 1]) {
                arr[i] = arr[i - 1]
                i -= 1
            }
            arr[i] = item
        }

        return arr

    }
}