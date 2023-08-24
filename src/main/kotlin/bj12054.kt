class IpAddSum{
    fun solution (){
        var T = readln().toInt()
        for(i in 0 until T){
            var N = readln().toInt()
            var IpAdds = mutableListOf<Pair<UInt, Int>>()
            for(j in 0 until N){
                var str = readln()
                IpAdds.add(parseIp(str))
            }
            IpAdds.sortBy{it.first}

            var normalized = mutableListOf<Pair<UInt, Int>>()

            normalized = IpAdds.map { it->
               Pair( getNormalize(it.first, it.second), it.second)
            }.toMutableList()

            for(ip in normalized){
                printIp(ip.first, ip.second)
            }
        }
    }
    fun parseIp(ip: String): Pair<UInt, Int>{
        var parsedIp = ip.split("/")
        var ipInt = 0U
        parsedIp[0].split(".").forEachIndexed{index, it->
            ipInt = ipInt or (it.toUInt() shl (24 - (index * 8)))
        }
        var result = Pair(ipInt, 32 - parsedIp[1].toInt())
        return result
    }
    fun getNormalize(ip: UInt, m: Int): UInt{
        var netMask = 0xffffffffU shl m
        var result = ip and netMask
        return result
    }
    fun printIp(ip: UInt, m: Int){
        var ipStr = mutableListOf<String>()
        ipStr.add((ip shr 24).toString())
        ipStr.add(((ip and 0x00ffffffU) shr 16).toString())
        ipStr.add(((ip and 0x0000ffffU) shr 8).toString())
        ipStr.add(((ip and 0x000000ffU)).toString())
        var ipResult = ipStr.joinToString(".")
        var M = 32 - m
        print(Integer.toBinaryString(ip.toInt()).padStart(32, '0'))
        println(", $m : $ipResult/$M")
    }
}
fun main(){
    var S = IpAddSum()
    S.solution()
}
