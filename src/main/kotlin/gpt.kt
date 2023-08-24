data class IPAddress(val address: List<Int>, val prefixLength: Int)

fun main() {
    val ipAddresses = listOf(
        "10.2.3.4/9",
        "10.128.2.3/9"
    )

    val ipObjects = ipAddresses.mapNotNull { parseIPAddress(it) }

    val summarized = summarizeIPAddresses(ipObjects)

    println("Summarized IP addresses:")
    summarized.forEach { println("${ipToString(it.address)}/${it.prefixLength}") }
}

fun parseIPAddress(ip: String): IPAddress? {
    try {
        val parts = ip.split("/")
        if (parts.size != 2) {
            throw IllegalArgumentException("Invalid IP address format: $ip")
        }
        val addressParts = parts[0].split(".").map { it.toInt() }
        val prefixLength = parts[1].toInt()
        return IPAddress(addressParts, prefixLength)
    } catch (e: Exception) {
        println("Error parsing IP address '$ip': ${e.message}")
        return null
    }
}

fun summarizeIPAddresses(ipAddresses: List<IPAddress>): List<IPAddress> {
    val sortedIPs = ipAddresses.sortedBy { ipToInt(it.address) }

    val summarized = mutableListOf<IPAddress>()

    var currentIP = sortedIPs[0]
    var currentStart = ipToInt(currentIP.address)
    var currentEnd = currentStart + (1 shl (32 - currentIP.prefixLength))

    for (i in 1 until sortedIPs.size) {
        val nextIP = sortedIPs[i]
        val nextStart = ipToInt(nextIP.address)
        val nextEnd = nextStart + (1 shl (32 - nextIP.prefixLength))

        if (nextStart <= currentEnd) {
            // Overlapping ranges, extend the current range
            currentEnd = maxOf(currentEnd, nextEnd)
        } else {
            // Non-overlapping ranges, add the current summarized range and start a new one
            summarized.add(IPAddress(intToIP(currentStart), 32 - Integer.numberOfTrailingZeros(currentEnd - currentStart)))
            currentStart = nextStart
            currentEnd = nextEnd
        }
    }

    // Add the last summarized range
    summarized.add(IPAddress(intToIP(currentStart), 32 - Integer.numberOfTrailingZeros(currentEnd - currentStart)))

    return summarized
}

fun ipToInt(ip: List<Int>): Int = ip[0] shl 24 or (ip[1] shl 16) or (ip[2] shl 8) or ip[3]

fun intToIP(i: Int): List<Int> = listOf((i shr 24) and 0xFF, (i shr 16) and 0xFF, (i shr 8) and 0xFF, i and 0xFF)

fun ipToString(ip: List<Int>): String = ip.joinToString(".")
