@SuppressWarnings("All")
class Hero {
    val baseStrength = 1000
    inner class Equipment {
        val weapon = "trident"
        val weaponStrength = 300
    }
}

@SuppressWarnings("All")
class Villain {
    val baseStrength = 500
    inner class Equipment {
        val weapon = "bomb"
        val weaponStrength = 700
    }
}

fun main() {
    val hero = Hero()
    val villain = Villain()

    val heroEquipment = hero.Equipment()
    val heroTotalStrength = hero.baseStrength + heroEquipment.weaponStrength

    val villainEquipment = villain.Equipment()
    val villainTotalStrength = villain.baseStrength + villainEquipment.weaponStrength

    // the following lines should remain as they are
    println("The hero uses ${heroEquipment.weapon}. The total strength is $heroTotalStrength.")
    println("The villain uses ${villainEquipment.weapon}. The total strength is $villainTotalStrength.")
}