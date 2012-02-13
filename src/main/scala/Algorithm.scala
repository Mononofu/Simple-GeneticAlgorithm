package GeneticAlgorithm

object Algorithm {
  val uniformRate = 0.5
  val mutationRate = 0.015
  val tournamentSize = 5
  val elitism = true

  def evolvePopulation(pop: Population) = new Population(
    (1 to pop.size) map { i =>
      if(elitism && i == 1)
        pop.fittest
      else
        mutate( crossover( tournamentSelection(pop), tournamentSelection(pop) ) )
    } toArray )

  def crossover(a: Individual, b: Individual) = new Individual(a.genes zip b.genes map {
      case (geneA, geneB) =>
        if (util.Random.nextDouble() < uniformRate)
          geneA
        else
          geneB
    } )

  def mutate(ind: Individual) = new Individual(
    ind.genes.map {
      gene =>
        if (util.Random.nextDouble() < mutationRate)
          util.Random.nextInt(2).toByte
        else
          gene
    } )

  def tournamentSelection(pop: Population) = new Population(
    (1 to tournamentSize) map {
      i => pop.individuals(util.Random.nextInt(pop.size))
    } toArray) fittest
}