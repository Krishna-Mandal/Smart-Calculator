class Point3D {
    var x: Int = 0
    var y: Int = 0
    var z: Int = 0
}

fun createPoint(x: Int, y: Int, z: Int): Point3D {
    val paint3d = Point3D()
    paint3d.x = x
    paint3d.y = y
    paint3d.z = z

    return paint3d
}