class Greedy {
    companion object {
        private var INSTANCE: Greedy? = null

        @get:Synchronized
        val instance: Greedy
            get() {
                if (INSTANCE == null) {
                    INSTANCE = Greedy()
                }
                return INSTANCE!!
            }
    }

    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var start = 0
        var total = 0
        var tank = 0
        for (i in gas.indices) {
            tank = tank.plus(gas[i]).minus(cost[i])
            if (tank < 0) {
                start = i.plus(1)
                total = total.plus(tank)
                tank = 0
            }
        }
        return if (total.plus(tank) < 0) -1 else start
    }

}

class BruteForce {
    companion object {
        private var INSTANCE: BruteForce? = null

        @get:Synchronized
        val instance: BruteForce
            get() {
                if (INSTANCE == null) {
                    INSTANCE = BruteForce()
                }
                return INSTANCE!!
            }
    }

    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var validStart = true
        for (g in gas.indices) {
            var fuel = gas[g]
            // check if valid starting station
            for (l in 0 until g) {
                val currentStation = (g.plus(l)).mod(gas.size)
                val nextStation = (currentStation.plus(1)).mod(gas.size)
                fuel = fuel.minus(cost[currentStation])
                when {
                    fuel < 0 -> {//is fuel too low for journey
                        validStart = false
                        break
                    }
                }
                fuel = fuel.plus(cost[nextStation])

                if (validStart) {
                    return g
                }
            }
        }
        return -1
    }
}