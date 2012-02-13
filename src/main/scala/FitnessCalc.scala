package GeneticAlgorithm

object FitnessCalc {
  val defaultGeneLength, maxFitness = 64
  val solution = Array.fill(defaultGeneLength)(0.toByte)

  def setSolution(sol: String) {
    sol.toList.zipWithIndex.foreach { case (char, index) =>
      solution(index) = (if(char == '1') 1 else 0).toByte }
  }

  def fitness(genes: Array[Byte]) = genes zip solution map {
    case (source, target) => if(source == target) 1 else 0 } sum
}