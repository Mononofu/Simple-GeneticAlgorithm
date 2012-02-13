package GeneticAlgorithm

class Individual(val genes: Array[Byte] = Array.fill(
  FitnessCalc.defaultGeneLength)(util.Random.nextInt(2).toByte)) {

  def fitness = FitnessCalc.fitness(genes)

  override def toString = genes.mkString
}