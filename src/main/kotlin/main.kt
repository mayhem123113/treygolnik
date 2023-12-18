import java.util.*

data class Point(val x: Double, val y: Double)

fun main() {
    val scanner = Scanner(System.`in`)

    // Ввод координат вершин треугольника
    val triangleVertices = mutableListOf<Point>()
    for (i in 1..3) {
        print("Введите координаты вершины $i (x y): ")
        val x = readDouble(scanner)
        val y = readDouble(scanner)
        triangleVertices.add(Point(x, y))
    }

    // Ввод координат точки
    print("Введите координаты точки (x y): ")
    val pointX = readDouble(scanner)
    val pointY = readDouble(scanner)
    val point = Point(pointX, pointY)

    // Проверка, находится ли точка внутри треугольника
    val isInside = isPointInsideTriangle(point, triangleVertices)
    if (isInside) {
        println("Точка находится внутри треугольника.")
    } else {
        println("Точка находится вне треугольника.")
    }
}

fun readDouble(scanner: Scanner): Double {
    while (true) {
        try {
            return scanner.nextDouble()
        } catch (e: InputMismatchException) {
            println("Ошибка: Введите действительное число.")
            scanner.nextLine()
        }
    }
}

fun isPointInsideTriangle(point: Point, vertices: List<Point>): Boolean {
    val x = point.x
    val y = point.y

    val x1 = vertices[0].x
    val y1 = vertices[0].y
    val x2 = vertices[1].x
    val y2 = vertices[1].y
    val x3 = vertices[2].x
    val y3 = vertices[2].y

    val d1 = (x - x1) * (y2 - y1) - (x2 - x1) * (y - y1)
    val d2 = (x - x2) * (y3 - y2) - (x3 - x2) * (y - y2)
    val d3 = (x - x3) * (y1 - y3) - (x1 - x3) * (y - y3)

    val hasNeg = (d1 < 0) || (d2 < 0) || (d3 < 0)
    val hasPos = (d1 > 0) || (d2 > 0) || (d3 > 0)

    return !(hasNeg && hasPos)
}