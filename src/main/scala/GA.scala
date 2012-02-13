package GeneticAlgorithm

object GA extends App {
  FitnessCalc.setSolution("1111000000000000000000000000000000000000000000000000000000001111")

  var pop = Population.withSize(50)

  var genCount = 0
  while(pop.fittest.fitness < FitnessCalc.maxFitness) {
    genCount += 1
    println("Generation %d, fitest: %d".format(genCount, pop.fittest.fitness))
    pop = Algorithm.evolvePopulation(pop)
  }
  println("Solution found in generation %d".format(genCount))
  println("Genes: %s".format(pop.fittest))

}
