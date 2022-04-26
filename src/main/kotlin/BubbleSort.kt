class BubbleSort {

    companion object {
        private var INSTANCE: BubbleSort? = null

        @get:Synchronized
        val instance: BubbleSort
            get() {
                if (INSTANCE == null) {
                    INSTANCE = BubbleSort()
                }
                return INSTANCE!!
            }

    }

    fun performSort(arr: IntArray): IntArray {
        var sorted = true
        while (sorted) {
            sorted = false
            for (i in 0 until arr.size - 1) {
                //Check if item at index zero is greater than index 1
                when {
                    arr[i] > arr[i + 1] -> {
                        val temp = arr[i] //add element to memory to hold temp value o(1)
                        arr[i] = arr[i + 1] //swap
                        arr[i + 1] = temp
                        sorted = true
                    }
                }
            }
        }
        return arr
    }
}