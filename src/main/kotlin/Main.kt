fun main(args: Array<String>) {
    val list = BubbleSort.instance.performSort(intArrayOf(6, 2, 9, 0, 1, 55, 4, 89, 5))
    //for (l in list) println(l)

    val iS = InsertionSort.instance.preformSort(intArrayOf(6, 2, 9, 0, 1, 55, 4, 89, 5))
   // for (l in iS) println(l)

    val f=Greedy.instance.canCompleteCircuit(intArrayOf(1,2),intArrayOf(2,1))

    println(f)
}